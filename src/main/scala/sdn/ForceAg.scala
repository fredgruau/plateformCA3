package sdn
//toto
import compiler.AST.Layer
import compiler.ASTB.{False, Uint}
import compiler.ASTBfun.{addRedop, derivative, ltUI2, orRedop, redop}
import compiler.ASTL.{delayedL, send, transfer, unop}
import compiler.ASTLfun.{allOne, andLB2R, b2SIL, e, eq0, f, fromBool, imply, lt2, ltSI, neighbors, neq, orScanRight, reduce, uI2SIL, v}
import compiler.SpatialType.{BoolE, BoolEv, BoolF, BoolV, BoolVe, BoolVf, IntE, IntEv, IntV, IntVe, UintV, UintVx}
import compiler.repr.nomE
import compiler.{AST, ASTLfun, ASTLt, B, E, F, Locus, SI, T, UI, V, chip, repr}
import dataStruc.{BranchNamed, Named}
import progOfCA._
import progOfLayer.Sextexrect.chooseMaxOf
import progOfmacros.Comm.{apexE, apexV, neighborsSym}
import progOfmacros.{Compute, Grad, Wrapper}
import progOfmacros.Compute.implique
import progOfmacros.Wrapper.{exist, inside, insideS, not, unary2Bin}
import sdn.ForceAg.Agg
import sdn.Globals.root4naming

import scala.collection.immutable
//import sdn.Util.addLt

import scala.::
import scala.Predef._
import scala.collection.convert.ImplicitConversions.`map AsJavaMap`
import scala.collection.mutable.{ArrayBuffer, HashMap}
import scala.collection.mutable
/** makes precise where a constraint applies*/
sealed trait Impact
/** constraint is applied whether it is empty or not */
case class Both() extends Impact
/**  constraint will prevent filling (resp emptying), if noFill is true (resp. false)*/
case class
One(noFill: Boolean) extends Impact //on veut pouvoir calculer le complementaire d'une contraint, forbid et oblige sont complementaire


/** an entity such has a boolV  or more generally a mustruct, which provide hasIsV, can be completed with utilAgent */
trait HasIsV{
/** used for computing flip cancelation depending on impact of constraint, so that constraint can act non only
 * which can be both(),  noFill(true) noFill(false)
 * case class One(noFill: Boolean) extends Impact
 * on veut pouvoir calculer le complementaire d'une contraint, forbid et oblige sont complementaire
 *  not only for BoolV Agent, but also for Ev Agents */
val isV: BoolV
/** can be defined on agent, delayed is needed because  isV is not known yet */
val notIsV :BoolV= ~(delayedL(isV))
}
/**
* agents are boolean muStruct udated using force
  * * @tparam L  locus of the agent's support, we can have Vagent L=V, Ve AgentsL=Ve, ....
* For the moment we consider that all agents extend hasIsv, it may be the case that E-agents, do not.
  */
abstract class Agent[L <: Locus] extends MuStruct[L, B] with HasIsV {
  /** also used by DetectedAg */

  var flipAfterConstr: BoolV=null
  /** flipAfterConsrtr is used as a first approximation to compute next, which is neccesary to know in order to compute keepOutside
   * however, when we build the force keepOutside, we do not have yet flipafterConstr, hence we need the delayed version */
  val dflipAfterConstr=delayedL(flipAfterConstr)
  var flipRandomlyCanceled: BoolV=null
  /** the two boolV will be synchronized flip being progressively rarefied.
   * if an agent forces several others, then its synchronized flip will be iteratively adjuster whenever each output agents updates
   * we will likely have to iterate over path of increasing lenght on a graphe where edges corresponds to synchronized agents,
   * and check intersection of constraints on intersection on synchronized zone,  */
  val constrsync= new scala.collection.mutable.LinkedHashMap[String,ConstrSync]()
  /**  */
}

/** on l'ajoute a un agent qui souhaite en inclure un autre */
trait keepInsideForce {
  self : Agent[V]=>
  /** place where new self appears , available for agent which are detected agents */
  val nouveau= muis.munext & ~muis.pred
  val alreadyThere=muis.munext & muis.pred

  /** if there is an ag present next to nouveau , it will be pushed to fill the nouveau
   * noneed to empty whatever, so empty remains false.  */
  def keepInside:Force=  new Force() {
    override def actionV(ag: MovableAgV): MoveC = {
      /** the surrounding agent does not yet contain nouveau */
      val nouveauToFill = nouveau & ~ag.muis
      /** if not null will create a push in order to fill nouveau which are not yet filled */
      val push=neighbors(nouveauToFill) & e(ag.muis)
      val coveredByPush=exist(neighborsSym(push))
      /** should be true everywhere */
       val oui = MoveC1(fromBool(false), push)
      /** we must not empty voronoi in places where it will contain gcenters*/
      val non = MoveC1(alreadyThere&ag.muis,e(fromBool(false)))
      MoveC2(oui,non)
    }
  }}
  /** if there is an ag present on nouveau , it will be emptied to prevent overlapp
   *  * noneed to empty whatever, so empty remains false.
   *  We have a problem, since keep outside needs to be computed
   *     - before computing the moves of voronoi,
   *     - after computing the flipAfterConstr of particles.
   *     =>In the first pass, we compute both flipOfMove and flipAfterCons
   *   NB as flipAfterSYnc is updated, in inputagent, so is the forced move,
      At the end of this process, the idea is that the final forced Move
        created from  a movable should no create inpossible move in the boundagents
   *  */
  trait keepOutsideForce{
    self : ForceAg[V] =>
  def keepOutside:Force=  new Force() {
    override def actionV(ag: MovableAgV): MoveC = {
      //val fliipAafterCoonstr=fliprioOfMove.defined  //on se contente du flipMove pour le moment
      // val fliipAafterCoonstr=flipAfterLocalConstr.defined  //plus long puisqu'on fait jouer les conhtrainte locale
      // val fliipAafterCoonstr=flipAfterMutexConstr.defined  //plus long puisqu'on fait jouer les conhtrainte locale
        val fliipAafterCoonstr=    flipAfterConstr //le normal qui produit des millions de neouds
      //val teeest=new Dag[AST[_]](List(fliipAafterCoonstr))  //teste la présence de cycles ??
      // l'instruction suivante affiche un truc enorme

      val nouveauAfterConstr= ~muis.pred  & fliipAafterCoonstr
      val remainThere  =   muis.pred   & ~fliipAafterCoonstr     /** the surrounding agent overlap with nouveau */
      val nouveauToEmpty = nouveauAfterConstr & ag.muis
      /** if not null will create a emptying of  nouveau where ag is filled */
      val oui = MoveC1(nouveauToEmpty, e(fromBool(false)))
      /** we must not push voronoi towards vertices that will contain particles */
        val willbethere=nouveauAfterConstr | remainThere
      val non = MoveC1(muis.pred & ~muis.pred ,ag.bf.brdVeIn & neighborsSym(e(willbethere)))
      MoveC2(oui,non)
    }
  }
}


/** detected Agents directly compute their next state using a field called "detected"
 * typically, gCenter is a detected agent
 * they are not really agent because they do not undergo forces.
 * we can compute deflipSimult, also for those agents, in order to check that no deflip will apply*/
abstract class DetectedAgV ( val detected: BoolV )  extends Agent[V] {
  /** support of agent, implemented as a layer. we also use it to store a list  of system instructions */
  override val muis=new Layer[(V, B)](1, "globalInv") with ASTLt[V,B]  with Stratify [V,B] with carrySysInstr   {


    override val  next = detected  }
  override val isV: BoolV = muis
  /** artificially reconstructed, we will be able to watch if it happens to be canceled by simult constraint */
   flipAfterConstr=muis ^ muis.next
  def showme={shoow(detected)}
}

//class Gcenter(arg: ) extends DetectedAgV

object ForceAg{
  /** standard generic agent */
  type Agg = ForceAg[_ <: Locus]

}
/**  ForcedAg are Agents  udated using force */
abstract class ForceAg[L <: Locus] extends Agent[L]
 { val forces:ArrayBuffer[mutable.LinkedHashMap[String,Force]] = ArrayBuffer()
   protected def addForces(priority:Int, name:String, shortName:Char, f:Force ) = { //we may have to store set of moves, if we need add move of same priority.
     val ht=forces(priority)
     assert(!(ht.contains(name)), "each force must have a distinct priority");
     forces(priority)(shortName+name)=f
   }

   /** moves are stored in centered form, so that we can restrict them. we store one hashmap for each priority. It two moves with identical names are added, we throw an exception */
   val moves:ArrayBuffer[mutable.LinkedHashMap[String,MoveC]] = ArrayBuffer() //empty at the beginning
   /** we introdued a new priority use to qualify a new range of move, creating a new functionnality such  as explore, homogeneize, stabilize*/
   def introduceNewPriority():Int={ moves+= mutable.LinkedHashMap[String,MoveC]();
     forces+= mutable.LinkedHashMap[String,Force]();  moves.size-1 }
   /** if move of same priority exists, signal an error */
   protected def addMoves(priority:Int, name:String, shortName:Char, m: MoveC ) = { //we may have to store set of moves, if we need add move of same priority.
     val ht=moves(priority)
     assert(!(ht.contains(name)), "each force must have a distinct priority");
     moves(priority)(shortName+name)=m
   }
   /** generates move from forces */
   def applyForces = {
     var priority=0
     for(mapForces<-forces)
        {for((name,f)<-mapForces)
          addMoves(priority,name.drop(1),name(0),f.action(this.asInstanceOf[MovableAgV]))
          priority+=1
        }
   }

   /** the agent's list of consrtrain. Constraints have a name, and the list is also ordered */
   val constrs= new scala.collection.mutable.LinkedHashMap[String,PartialUI =>Constr]()

   /**
    * @param name more explicit name
    * @param shortName used for display in CApannel
    * @param c constraint to be added to the list of agent's constraint
    *          it is a function because at the time of adding the constraint, prio and flip are no known yet
    */
   def addConstraint(name:String, shortName:Char, c: PartialUI=>Constr) = {
   if(constrs.contains(shortName+name))    throw new Exception("une contrainte du nom "+name+" exite déja, changez le nom siou plait")
   constrs(shortName+name)=c  }
   def addConstrSync(name:String, shortName:Char, c: ConstrSync) = {
     if(constrsync.contains(shortName+name))    throw new Exception("une contrainte sync du nom "+name+" exite déja, changez le nom siou plait")
     constrsync(shortName+name)=c  }


   /** not the same for  movable/bound  */
   def allTriggered:UintV;
   def allBug:UintV;
   def allTriggeredYes:UintV
   /** flips for all priorities */
   def allFlip:UintV
  //variable defined when computing fliprioOfMove
   var isQuiescent:BoolV=null
   var yesHighestTriggered:UintV=null
   var allBugs:UintV=null
   /**  adds a bit of randomnes to forces's priority
    * allows to  breaking  symetry in case of tournament with equal force's priority */
   val prioRand:UintV
   var fliprioOfMove:PartialUI=null

   val mergedMoves= new  mutable.HashMap[String,MoveC]() with Named {}

   /**  */
   def setFliprioOfMove() = {
     applyForces
     /** stores all the moves in a single hashMap, with the name of the force as key, so that we can easily shoow them */
    for (m <- moves; (k, v) <- m) mergedMoves(k.drop(1)) = v

     /** does a computation to be repeated specifically for yes moves */
     def processMoves(all:UintV):(UintV,UintV,UintV)={
       /** bouche les trous avec un orscanright */
       val filled=orScanRight(all)
       (filled,unop(derivative, filled),unary2Bin(filled))
     }
     val (filledTriggered,/** all false except for highest priority move */ highestTriggered, prioDet: UintV) =
       processMoves(allTriggered)
     /** selectionne le flip parmis les flip des mouvement proposés */
     val flipOfMove = neq(highestTriggered & allFlip)

     /** on le fait aussi pour les "yes" move */
     val (yesFilledTriggered, yHT, yesPrioDet) = {
       /** makes a global logical or, of boolean which are true for C2moves,
        * if false then there will not be negative move
        * and yesFilledtriggered is equal to fill triggered, thereby simplifying the computation*/
       val presenceOfC2moves = moves.map(_.values.map({case a: MoveC2 =>true  case a: MoveC1 =>  false} ).reduce(_ | _)).reduce(_ | _)
       if (!presenceOfC2moves ) (filledTriggered, highestTriggered, prioDet)
       else processMoves(allTriggeredYes)
     }
     allBugs=allBug
     yesHighestTriggered = yHT //used for printable purpose
     /** selected positive move has lower priority than selected move, implies quiescence */
     isQuiescent = lt2(yesPrioDet, prioDet)
     val prioYes: UintV = prioRand :: yesPrioDet
     /** nullify prio if vertice is quiescent we are interested only in high prio only if move is generated
      * this priority is the one to be used when evaluationg local constraints */
     val prioYesNotQuiescent = Util.addLt(andLB2R(~isQuiescent, prioYes))
     fliprioOfMove=new PartialUI(flipOfMove, prioYesNotQuiescent)
   }
  //setFliprioOfMove() //this is now done separately



   //val flipCancelLocal=  new scala.collection.mutable.LinkedHashMap[String,BoolV]() with Named {}
   val highproba= root4naming.addRandBit().asInstanceOf[BoolV]| root4naming.addRandBit().asInstanceOf[BoolV]

   /** applies all the constraints on the move */
   //var  allFlipCancel: UintV = null
   var  allFlipLocalCanceled: UintV = null
   var flipAfterLocalConstr: PartialUI=null
   var  allFlipMutexCanceled: UintV = null
   var flipAfterMutexConstr:PartialUI=null
   var  allFlipSextexCanceled: UintV = null
   var flipAfterSextexConstr:PartialUI=null
   var splitConstr: SplitHashMapTyped.Split[String]=null
   /** computes an IntVUI  whose individual bits are cancel Flips, using a sublist of constraints  */
   def allFlipCancel(fliprio: PartialUI, subConstrs:mutable.LinkedHashMap[String,sdn.PartialUI => sdn.Constr]): UintV = {
     /** stores results of applies the passed contraint in subConstr, using fliprio */
     val flipCancel=  new scala.collection.mutable.LinkedHashMap[String,BoolV]() with Named {}
     for ((name, c) <- subConstrs)   flipCancel(name) = ~c(fliprio).where & fliprio.defined //where also takes into account flipOfMove
     val allFlipCancel: Array[UintV] = flipCancel.values.toArray.map(_.asInstanceOf[UintV])
     allFlipCancel.reduce(_ :: _)
   }

   def setFlipCancel()= {
     //we separate local  then  mutex, mutapex, tritex and then sextex
      splitConstr = SplitHashMapTyped.splitConstrs(constrs)
     //new staged computation more precise.
      allFlipLocalCanceled=allFlipCancel(fliprioOfMove, splitConstr.locals)
     flipAfterLocalConstr = fliprioOfMove.rarefies(eq0(allFlipLocalCanceled))
     //on regroupe les différents mutex et tritex, car ils opérent en exclusion les uns de autres. Par exemple, apexmutex n'opére pas en meme temp que mutex ni que tritex
     allFlipMutexCanceled=allFlipCancel(flipAfterLocalConstr, splitConstr.mutexes++splitConstr.mutApexes++splitConstr.tritexes)
     flipAfterMutexConstr = flipAfterLocalConstr.rarefies(eq0(allFlipMutexCanceled))
     if(splitConstr.sextexes.nonEmpty){ //on fait un if car voronoi n'a pas de contrainte directionnelle.
       allFlipSextexCanceled=allFlipCancel(flipAfterMutexConstr, splitConstr.sextexes)
      flipAfterSextexConstr = flipAfterMutexConstr.rarefies(eq0(allFlipSextexCanceled))   }
     else flipAfterSextexConstr=flipAfterMutexConstr
     //former global computation.    allFlipCancel=allFlipCancel2(fliprioOfMove,constrs);   val noFlipCancel=eq0(allFlipCancel)
     val noFlipCancel=flipAfterSextexConstr.defined
     flipAfterConstr = noFlipCancel  & fliprioOfMove.defined
     flipRandomlyCanceled=flipAfterConstr //& highproba //decommenter pour annuler au hasard, utilise pour casser les cycles
     //flipRandomlyCanceled=flipAfterLocalConstr.defined
   }
   var flipAfterSync:BoolV=null
   def setFlipSync()={
     flipAfterSync=flipAfterConstr //les contraintes sont a stoquée chez l'agent contraint.

     for((_,c)<-constrsync){
       flipAfterSync=c.zoneSync & c.cancel(c.source.flipAfterSync,flipAfterSync)}
 }



   /** stores the first letter of each move's name for all priorities, This lettre is to be displayed if move is selected
    * there can be at  most  one positive move selected
    * if move is blocking nothing get displayed, and  isquiscent will be true */
   def codeMove:Iterable[String] = { assert(moves.size>1,"faut au moins deux move, sinon pb entier codé par un bool")
     moves.map(_.keys.head.charAt(0).toString) }

   /** will show only move that trigger movement. Move that "block" movement are hidden,  */
   def showPositiveMoves={
     shoowText(yesHighestTriggered,codeMove.toList)
     // shoowText(prioDeet,List())
     shoowText(allBugs,codeMove.toList)
   }
   // /** shows also  moves that block movement */
   // def showMoves={ shoowText(highestTriggered,codeMove.toList)}
   /** we sometimes need to check the prio, wether it is quiescent or not */
   def showAllFlip={
     shoowText(fliprioOfMove.valuc, List() )
     shoow(fliprioOfMove.valuc.lt)
     shoow(fliprioOfMove.defined, isQuiescent, flipAfterConstr,flipAfterLocalConstr.defined,
       flipAfterMutexConstr.defined)
   }
   /** stores the first letter of each constraint's name. This lettre is to be displayed on vertice where constraint is active
    * there can be several active constraints*/
   def codeConstraint(constrs:mutable.LinkedHashMap[String,PartialUI=>Constr]): Iterable[String] =constrs.keys.toList.map(_.charAt(0).toString)
   /** shows a letter corresponding to the constraint, for all constraint which effectively contribute in reducing flip */
   def showConstraint={
     // shoowText(allFlipCancel,codeConstraint(constrs).toList)
     shoowText(allFlipLocalCanceled,codeConstraint(splitConstr.locals).toList)
     shoowText(allFlipMutexCanceled,codeConstraint(splitConstr.mutexes++splitConstr.mutApexes++splitConstr.tritexes).toList)
     if(splitConstr.sextexes.nonEmpty)  shoowText(allFlipSextexCanceled  ,codeConstraint(splitConstr.sextexes).toList)
   }
   /** test que les var s'affiche bien */
   def showMe={
     showPositiveMoves;
     showConstraint;showAllFlip;
   }
 }
