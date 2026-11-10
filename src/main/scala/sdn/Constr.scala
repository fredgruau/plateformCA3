package sdn

import compiler.AST.Delayed
import compiler.ASTL.{delayedL, transfer}
import compiler.ASTLfun.{e, f, imply, v}
import compiler.{ASTLfun, Locus}
import compiler.SpatialType.{BoolE, BoolEv, BoolF, BoolV, BoolVe, BoolVf}
import progOfLayer.Sextexrect.chooseMaxOf
import progOfmacros.Comm.{apexE, apexV, insideE, neighborsSym}
import progOfmacros.Compute.{chooseMaxOf2, chooseMaxOf3, implique}
import progOfmacros.Wrapper.{inside, insideS}
import sdn.ForceAg.{Ag, AgForced}
import sdn.SplitHashMapTyped.Split
import sdn.Util.{addSymUI, myLn2}
import sdntool.addQpointFields

import scala.collection.immutable.{HashSet, ListMap}
import scala.collection.mutable

object Constr {
  implicit class ConstrFactoryOps[C <: Constr](
      private val factory: PartialUI => C
                                              ) {
    def withLimitingPrio(n: Int): PartialUI => C =
      fliprio => {
        val c = factory(fliprio)
        c.setLimitingPrio(n)
        c
      }
  }
}

/** applying constraints identifies PEs where flip should be canceled, cancelFlip will implement this cancelation */
///we now describe class for easily adding constraint, they are subclass of agents, in order to use the agent's field isV,
// NisV, and more. They used an object to defined an apply method allowing to curify the function , because fliprio is not available yet
/** @param ags one or two agents on which to apply constraint
 *            Constr is an inner classes of agents, so that it can access its main agent's field such as prio.
 */
abstract class Constr(val ags: Array[AgForced], val impact: Impact, fliprio:PartialUI) {
  /** Most of the time the constraint holds on a single agent that we call "ag" for "agent" */
  var limitingPrio= -1
  val ag=ags(0)
  /** nombre de bit pour coder une prioritéé en binaire a partir de nbit en unaire*/
  val nbitPrio=myLn2(ag.forces.size)+ag.nbitPrioRand
  def setLimitingPrio(n:Int)={limitingPrio=n}
  /** where = places where flips is still valid after the constraint newFlip<-oldFlip & where
   * defined has a method, in order allow definition prior to intanciation of needed field, such as flip.*/
  val where: BoolV
  /** if a limiting prio is specified, whereprio will be true if yesPrioDet >= limitingPrio */
   val wherePrio= delayedL(if(limitingPrio== -1) where else where | ~ (/*fliprio.valuc */ ag.yesPrioDet < ASTLfun.fromInt(limitingPrio)))
}

/**
 *
 * @param a
 * @param i
 * @param loc place where constraints is to be applied
 * @param fliprio
 */
class KeepFlipIf(a:AgForced, i: Impact, val loc:BoolV, fliprio:PartialUI) extends Constr(Array(a), i,fliprio) {
  override val where: BoolV = {
  impact match {
    case Both() => loc    case One(v) =>  implique (if (v) ag.isV else (ag.notIsV),loc)   }
}
}
object KeepFlipIf{def apply(a:AgForced, i: Impact, l:BoolV)(fliprio:PartialUI): KeepFlipIf = new KeepFlipIf(a,i,l,fliprio)}

class CancelFlipIf(a:AgForced, i: Impact, l:BoolV, fliprio:PartialUI) extends KeepFlipIf(a,i,~l,fliprio)
object CancelFlipIf{def apply(a:AgForced, i: Impact, l:BoolV)(fliprio:PartialUI): CancelFlipIf = new CancelFlipIf(a,i,l,fliprio)   }

/**
 *
 * @param bounded bounded agent
 * @param bounding bounding agent
 * @param zoneSync zone where moves of bounding transmits to move of bounded
 */
abstract class ConstrSync(val bounding:Ag, val bounded:BoundedAgV, val zoneSync:BoolV){
  /** computes where flip is further canceled */
  val cancel: (BoolV,BoolV) => BoolV
}

/**
 * We consider "imply type" sync constraint
 * @param bounded bounded agent
 * @param bounding bounding agent
 * @param zoneSync zone where moves of bounding impose a move of bounded
 */
class ConstrSyncImply(override val bounding:Ag, override val bounded:BoundedAgV, override val zoneSync:BoolV)
  extends ConstrSync (bounding, bounded, zoneSync){
  /** if forced move does not happen on bounded .. flip of bounding which caused the forced move is also canceled
   * we must have bounding.flip => bounded.flip on zoneSync=not gcenter and not vor (apparition of gcenter cause apparition of vor
   * on gcenter and vor,
   *
   *
   * flip is further canceled if implication bounding.flipSYnc => bounded.flipSync is false on zone sync
   * for example, in the case of voronoi, zoneSync=not gabrielcenter, on this zone, if bounding=gabrielcenter flips, it implies
   * that voronoi should also flip.
   * */
  val cancel:(BoolV,BoolV)=>BoolV = ~ implique(_,_)
}


/**
 *
 * @param i
 * @param mutex not more than one will flip each side of mutex
 */
class MutKeepFlipIf(a:AgForced, i: Impact, val mutex:BoolE, val fliprio:PartialUI) extends Constr(Array(a), i,fliprio) {
  /** mutex is triggered if there is indeed two flips on each side of the mutex, and in the right state. */
  def mutrig:BoolE =mutex &  (impact  match {
    case Both() => insideS(fliprio.defined)
    case One(v) =>  insideS(fliprio.defined & (if (v) ag.notIsV else (ag.isV))) // result also depend on impact
  })
  /** flip is ok if prio is maximum with respect to the other side */
  def tmp: BoolEv =imply(v(mutrig),fliprio.valuc.lt) //todo faut mettre lt?oui, lt est vrai du coté de la plus grosse prio
  /** flip remains ok if no neighbor edge present a problem */
  val ttmp=tmp
  val where: BoolV =inside(transfer(ttmp))
}
object MutKeepFlipIf{def apply(a:AgForced, i: Impact, mutex:BoolE)(fliprio:PartialUI ): MutKeepFlipIf = new MutKeepFlipIf(a,i,mutex,fliprio) }
/**
 *
 * @param i
 * @param mutex not more than one will flip each remote (apex) side
 */
class MutApexKeepFlipIf(a:AgForced, i: Impact, val mutex:BoolE, fliprio:PartialUI ) extends Constr(Array(a), i,fliprio) {
  /** mutex is triggered if there is indeed two flips on each side of the mutex, and in the right state. */
  val mutrig:BoolE ={
    mutex &  (impact  match {
      case Both() => inside(apexE(f(fliprio.defined)))
      case One(v) =>  inside(apexE(f(fliprio.defined & (if (v) ag.notIsV else (ag.isV)))))// result also depend on impact
    })}
  /** flip is ok if prio is smaller with respect to the other side */
  //  val chekLtIfMutrig=imply(f(mutrig),prio.ltApex) // je mettait lt au lieu de gt, cela peut créer des oscillations.
  val chekLtIfMutrig=imply(f(mutrig),fliprio.valuc.ltApex)
  val where=inside(apexV(chekLtIfMutrig))
}
object MutApexKeepFlipIf{def apply(a:AgForced, i: Impact, mutex:BoolE)(fliprio:PartialUI): MutApexKeepFlipIf =
  new MutApexKeepFlipIf(a,i,mutex,fliprio) }

class TriKeepFlipIf(a:AgForced, i: Impact, val tritex: BoolF, fliprio:PartialUI) extends Constr(Array(a), i,fliprio) {
  /** mutex is triggered if there is indeed two flips on each side of the mutex, and in the right state. */
  val tritrig:BoolF =tritex &  (impact  match {  //y a moyen d'écrire un trigger générique pour mut,tri, et loc
    case Both() => insideS(fliprio.defined)
    case One(v) =>  insideS(fliprio.defined& (if (v) ag.notIsV else (ag.isV))) // result also depend on impact
  })
  /** flip is ok if prio is minimum with respect to the other side */
  def tmp: BoolVf =imply(transfer(v(tritrig)),fliprio.valuc.lt3)
  /** flip is preserved if no neighbor edge present a problem */
  val where=inside(tmp)
}
object TriKeepFlipIf{def apply(a:AgForced, i: Impact, tritex: BoolF)(fliprio:PartialUI): TriKeepFlipIf =
  new TriKeepFlipIf(a,i,tritex,fliprio) }



/** will choose neighbor with higest flip priority, where FLIP IS DEFINED
 *  sexKeepFlipIf is the same constraint for any agents, so it is not defined as a class but as a class instance*/
class SexTex(a:AgForced, fliprio:PartialUI) extends Constr(Array(a), null,fliprio){
  //si j'enleve la ligne suivante,avec sexKeepFlipIfoldoldold, ca veut plus initialiser part.isV, c'est un bug du compilo
 // val  sexKeepFlipIfoldoldold: Int => Int = (fp:Int)=> 3//chooseMaxOf(fp.value, 4)
  /**if we implement sextex, qpoint fields must be available*/
  val singleton=ag.asInstanceOf[addQpointFields].qf.singleton
  /**
   * indicates one among the six possible direction. the chosen direction is the one with max priority
   * carefull that this constraint uses prioYesNotQuiescent so it assumes that moves have been already computed
   * if we want to endows our agent with constraints before computing moves, this will not work*/
  val vois=addSymUI(e(fliprio.restoreInvariant.value)).symUI

  val choose2: BoolVe = chooseMaxOf3(vois, nbitPrio)
  //val choose: BoolVe = chooseMaxOf(fliprio.restoreInvariant.value, nbitPrio)
  val whereto:BoolVe= imply(e(singleton),choose2)
  /** where = places where flips is still valid after the constraint newFlip<-oldFlip&where
   * defined has a method, in order allow definition prior to intanciation of needed field, such as flip.  */
  override val where: BoolV = insideE(whereto)
}
object SexTex{ def apply(a:AgForced)(fliprio:PartialUI): SexTex=new SexTex(a,fliprio)}


/** sofware for classifying constraints */
object SplitHashMapTyped {
  /** Résultat fortement typé. */
  //q leqQuatre diseapearSingle diseapearDouble diseaperTripletaon _vmeet =hmeet  ;videplein sloW
  val localsInitials="qs_vwgu"
  val mutexesInitials="d;=n"
  val mutapexInitials="a"
  val tritexInitials="t"
  val sextexInitials= "x"
  val randInitials="r"
  final case class Split[K](locals: mutable.LinkedHashMap[K, PartialUI=>Constr], mutexes: mutable.LinkedHashMap[K, PartialUI=>Constr],
                            mutApexes: mutable.LinkedHashMap[K, PartialUI=>Constr],
                            tritexes: mutable.LinkedHashMap[K,PartialUI=>Constr], sextexes:mutable.LinkedHashMap[K,PartialUI=>Constr],
                            randexes:mutable.LinkedHashMap[K,PartialUI=>Constr])

  def toSortedSeq[V]( m: Map[String, V],ord: Ordering[String] = Ordering.String,   ascending: Boolean = true  ): Seq[(String, V)] = {
    val sorted = m.toSeq.sortWith { (a, b) =>
      val cmp = ord.compare(a._1, b._1)
      if (ascending) cmp < 0 else cmp > 0
    }
    sorted
  }
  def toSortedListMap[V]( m: Map[String, V],   ord: Ordering[String] = Ordering.String, ascending: Boolean = true): ListMap[String, V] =
    ListMap.from(toSortedSeq(m, ord, ascending))
  def toSortedLinkedHashMap[V]( m: collection.Map[String, V], ord: Ordering[String] = Ordering.String, ascending: Boolean = true): mutable.LinkedHashMap[String, V] = {
    val out = new mutable.LinkedHashMap[String, V]()
    for ((k, v) <- toSortedSeq(m.toMap, ord, ascending)) out.update(k, v)
    out
  }

  def subMapByFirstChar[V]( m: mutable.LinkedHashMap[String, V],allowed: String ): mutable.LinkedHashMap[String, V] = {
    val set = allowed.toSet
    mutable.LinkedHashMap.from(  m.iterator.filter { case (k, _) =>  k.nonEmpty && set(  k.head )  }   ) }
  /** separe les differente contraintes, conserve un ordre induit par leur  initiale et leur nom*/
  def splitConstrs(src: mutable.LinkedHashMap[String, PartialUI=>Constr]): Split[String] = {
    val locals=subMapByFirstChar(src,localsInitials)
    val mutexes= subMapByFirstChar(src,mutexesInitials )
    val mutapexes= subMapByFirstChar(src,mutapexInitials )
    val tritexes= subMapByFirstChar(src,tritexInitials )
    val sextexes= subMapByFirstChar(src,sextexInitials )
    val randexes= subMapByFirstChar(src,randInitials )
    //we do -1 because of the randConstraint
    assert(locals.size+mutexes.size+mutapexes.size+tritexes.size+sextexes.size+randexes.size==src.size,"some constraints not processed") //check that we processed all constraint
     Split[String](locals,mutexes, mutapexes, tritexes, sextexes,randexes)}

}
