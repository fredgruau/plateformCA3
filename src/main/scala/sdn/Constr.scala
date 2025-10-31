package sdn

import compiler.ASTL.transfer
import compiler.ASTLfun.{e, f, imply, v}
import compiler.Locus
import compiler.SpatialType.{BoolE, BoolEv, BoolF, BoolV, BoolVe, BoolVf}
import progOfLayer.Sextexrect.chooseMaxOf
import progOfmacros.Comm.{apexE, apexV, neighborsSym}
import progOfmacros.Compute.implique
import progOfmacros.Wrapper.{inside, insideS}
import sdn.ForceAg.Agg
import sdn.SplitHashMapTyped.Split

import scala.collection.immutable.{HashSet, ListMap}
import scala.collection.mutable



/** applying constraints identifies PEs where flip should be canceled, cancelFlip will implement this cancelation */
///we now describe class for easily adding constraint, they are subclass of agents, in order to use the agent's field isV,
// NisV, and more. They used an object to defined an apply method allowing to curify the function , because fliprio is not available yet
/** @param ags one or two agents on which to apply constraint
 *            Constr is an inner classes of agents, so that it can access its main agent's field such as prio.
 */
abstract class Constr(val ags: Array[Agg], val impact: Impact, fliprio:PartialUI) {
  /** Most of the time the constraint holds on a single agent that we call "ag" for "agent" */
  val ag=ags(0)
  /** where = places where flips is still valid after the constraint newFlip<-olcFlip&where
   * defined has a method, in order allow definition prior to intanciation of needed field, such as flip.*/
  val where: BoolV //will use fields from the agent: flip, as well as this
}
class KeepFlipIf(a:Agg, i: Impact,val loc:BoolV,fliprio:PartialUI) extends Constr(Array(a), i,fliprio) { override val where: BoolV = {
  impact match {
    case Both() => loc    case One(v) =>  implique (if (v) ag.isV else (ag.notIsV),loc)   }
}
}
object KeepFlipIf{def apply(a:Agg,i: Impact, l:BoolV)(fliprio:PartialUI): KeepFlipIf = new KeepFlipIf(a,i,l,fliprio)}

class CancelFlipIf(a:Agg,i: Impact, l:BoolV,fliprio:PartialUI) extends KeepFlipIf(a,i,~l,fliprio)
object CancelFlipIf{def apply(a:Agg,i: Impact, l:BoolV)(fliprio:PartialUI): CancelFlipIf = new CancelFlipIf(a,i,l,fliprio)   }


abstract class ConstrSync(val source:Agg,val dest:Agg,val zoneSync:BoolV){
  /** computes where flip is further canceled */
  val cancel: (BoolV,BoolV) => BoolV
}
/** imply syncConstraint */
class ConstrSyncImply(source:Agg,dest:Agg,zoneSync:BoolV){
  /**flip is further canceled if implication source => dest is false*/
  val cancel:(BoolV,BoolV)=>BoolV = ~ implique(_,_)
}


/**
 *
 * @param i
 * @param mutex not more than one will flip each side of mutex
 */
class MutKeepFlipIf(a:Agg,i: Impact,val mutex:BoolE,val fliprio:PartialUI) extends Constr(Array(a), i,fliprio) {
  /** mutex is triggered if there is indeed two flips on each side of the mutex, and in the right state. */
  def mutrig:BoolE =mutex &  (impact  match {
    case Both() => insideS(fliprio.defined)
    case One(v) =>  insideS(fliprio.defined & (if (v) ag.isV else (ag.notIsV))) // result also depend on impact
  })
  /** flip is ok if prio is maximum with respect to the other side */
  def tmp: BoolEv =imply(v(mutrig),fliprio.valuc.lt) //todo faut mettre lt?oui, lt est vrai du coté de la plus grosse prio
  /** flip remains ok if no neighbor edge present a problem */
  val ttmp=tmp
  val where: BoolV =inside(transfer(ttmp))
}
object MutKeepFlipIf{def apply(a:Agg,i: Impact, mutex:BoolE)(fliprio:PartialUI ): MutKeepFlipIf = new MutKeepFlipIf(a,i,mutex,fliprio) }
/**
 *
 * @param i
 * @param mutex not more than one will flip each remote (apex) side
 */
class MutApexKeepFlipIf(a:Agg,i: Impact,val mutex:BoolE,fliprio:PartialUI ) extends Constr(Array(a), i,fliprio) {
  /** mutex is triggered if there is indeed two flips on each side of the mutex, and in the right state. */
  val mutrig:BoolE ={
    mutex &  (impact  match {
      case Both() => inside(apexE(f(fliprio.defined)))
      case One(v) =>  inside(apexE(f(fliprio.defined & (if (v) ag.isV else (ag.notIsV)))))// result also depend on impact
    })}
  /** flip is ok if prio is smaller with respect to the other side */
  //  val chekLtIfMutrig=imply(f(mutrig),prio.ltApex) // je mettait lt au lieu de gt, cela peut créer des oscillations.
  val chekLtIfMutrig=imply(f(mutrig),fliprio.valuc.ltApex)
  val where=inside(apexV(chekLtIfMutrig))
}
object MutApexKeepFlipIf{def apply(a:Agg,i: Impact, mutex:BoolE)(fliprio:PartialUI): MutApexKeepFlipIf =
  new MutApexKeepFlipIf(a,i,mutex,fliprio) }

class TriKeepFlipIf(a:Agg,i: Impact,val tritex: BoolF,fliprio:PartialUI) extends Constr(Array(a), i,fliprio) {
  /** mutex is triggered if there is indeed two flips on each side of the mutex, and in the right state. */
  val tritrig:BoolF =tritex &  (impact  match {  //y a moyen d'écrire un trigger générique pour mut,tri, et loc
    case Both() => insideS(fliprio.defined)
    case One(v) =>  insideS(fliprio.defined& (if (v) ag.isV else (ag.notIsV))) // result also depend on impact
  })
  /** flip is ok if prio is minimum with respect to the other side */
  def tmp: BoolVf =imply(transfer(v(tritrig)),fliprio.valuc.gt3)
  /** flip is preserved if no neighbor edge present a problem */
  val where=inside(tmp)
}
object TriKeepFlipIf{def apply(a:Agg,i: Impact, tritex: BoolF)(fliprio:PartialUI): TriKeepFlipIf =
  new TriKeepFlipIf(a,i,tritex,fliprio) }



/** will choose neighbor with higest flip priority, where FLIP IS DEFINED
 *  sexKeepFlipIf is the same constraint for any agents, so it is not defined as a class but as a class instance*/
class SexTex(a:Agg, fliprio:PartialUI) extends Constr(Array(a), null,fliprio){
  //si j'enleve la ligne suivante,avec sexKeepFlipIfoldoldold, ca veut plus initialiser part.isV, c'est un bug du compilo
 // val  sexKeepFlipIfoldoldold: Int => Int = (fp:Int)=> 3//chooseMaxOf(fp.value, 4)
  /**if we implement sextex, qpoint fields must be available*/
  val singleton=ag.asInstanceOf[addQpointFields].qf.singleton
  /** carefull with the number of bit, 4
   * carefull that this constraint uses prioYesNotQuiescent so it assumes that moves have been already computed
   * if we want to endows our agent with constraints before computing moves, this will not work*/
  val choose: BoolVe = chooseMaxOf(fliprio.restoreInvariant.value, 4) //todo deplacer dans constraint ca fait jouer prio
  val whereto:BoolVe= imply(e(singleton),choose)
  /** where = places where flips is still valid after the constraint newFlip<-oldFlip&where
   * defined has a method, in order allow definition prior to intanciation of needed field, such as flip.  */
  override val where: BoolV = inside(neighborsSym(whereto))
}
object SexTex{ def apply(a:Agg)(fliprio:PartialUI): SexTex=new SexTex(a,fliprio)}


/** sofware for classifying constraints */
object SplitHashMapTyped {
/*  sealed trait Kind
  case object Local extends Kind
  case object Mutex extends Kind
  case object MutApex extends Kind
  case object Tritex extends Kind
  case object Sextex extends Kind

  final case class ConstrFn(kind: Kind, f: PartialUI => Constr)

  def splitConstrs(
                    src: mutable.LinkedHashMap[String, ConstrFn]
                  ): Split[String] = {

    def pick(k: Kind) =
      toSortedLinkedHashMap(src.collect { case (key, ConstrFn(`k`, f)) => key -> f })

    val locals   = pick(Local)
    val mutexes  = pick(Mutex)
    val mutApex  = pick(MutApex)
    val tritex   = pick(Tritex)
    val sextex   = pick(Sextex)


    Split(locals, mutexes, mutApex, tritex, sextex)
  }
*/
  /** Résultat fortement typé. */
  //q leqQuatre diseapearSingle diseapearDouble diseaperTripletaon _vmeet =hmeet  ;videplein sloW
  val localsInitials="qs_w"
  val mutexesInitials="d;="
  val mutapexInitials="a"
  val tritexInitials="t"
  val sextexInitials= "x"
  final case class Split[K](locals: mutable.LinkedHashMap[K, PartialUI=>Constr], mutexes: mutable.LinkedHashMap[K, PartialUI=>Constr],
                            mutApexes: mutable.LinkedHashMap[K, PartialUI=>Constr],
                            tritexes: mutable.LinkedHashMap[K,PartialUI=>Constr], sextexes:mutable.LinkedHashMap[K,PartialUI=>Constr])

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
    assert(locals.size+mutexes.size+mutapexes.size+tritexes.size+sextexes.size==src.size,"some cosntraints not processed") //check that we processed all constraint
     Split[String](locals,mutexes, mutapexes, tritexes, sextexes)}

}
