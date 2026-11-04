package sdn

import compiler.ASTLfun.{cond, e, fromInt}
import compiler.SpatialType.{BoolV, BoolVe, UintV, UintVx}
import compiler.{AST, ASTL, ASTLt, B, Locus, Ring, V, repr}
import dataStruc.DagNode
import dataStruc.DagNode.Singleton
import progOfStaticAgent.Homogen
import progOfmacros.Compute.countNeighbors
import sdn.ForceAg.{Ag, AgForced}
import sdn.Util.{addLt, addSym}
import sdntool.{BlobVe, addDist, blobConstrTrou, blobConstrain}

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer


/**
 * in bounded agent support location is partially computed from parent's support (input neighbors of the DAG )
 * @param init how to initialize
 * @param bounding parents agent imposing partially the support of the bounded agent
 * @param follows force that is imposed to the agent so that its follows the bounding agent
 */
abstract class BoundedAgV(init:String, val bounding: Ag, val follows:Force )
  extends  MovableAg[V](init) with  MovableAgV   {
   /** bounded variable must compute when they are forced by their bounding parent, because a forced move cannot be randomly canceled */
 var isForced:BoolV=null
  var isWrong:BoolV=null
  override def setFliprioOfMove(): Unit = {
    appendForce("follows",'<',follows) //follows aura la priorité max puisque ajouté a la fin au dernier moment
    super.setFliprioOfMove();
    randConstr =   (CancelFlipIf(this, Both(), rand) _).withLimitingPrio(getPriority(follows)) //oblige la randomisation a ne pas avoir lieu sur la force follows
    //isForced= yesPrioDet == fromInt(forces.size) //on calcule isForced au plus tot, dés qu'on a yesHighestTriggered Ca va affiche seulement les vertices ou follows impose un flip.
    //isWrong=isForced & ~ASTL.delayedL(flipAfterConstr)
  }

  /** si le bounded agent bouge avec sa force de plus haute priorité, c'est une force obligée, donc faut pas randomiser dans ce cas précis */

  override def showMe(): Unit = {super.showMe; bf.showMe;  }
}


/** endows a distance with a detected agent for the Gabriel center,  which are almost the same as BlobVe'
 * gabriel centers can be directly obtain simply by computing Ve-meeting-point  using sloplt
 * we also need brdE
 * */
trait addGcenter{
  self: MovableAgV with sdntool.addBlobVfields with addDist=>
  val thismuis=muis
  val bve=new BlobVe(muis,~d.level,d.sloplt){
    /**  OBSOLETE silly way of avoiding superposition of agents with Gcenter
     * we just subtract muis from meet2E,
     * we use a val for testing */
    override val meetE2: ASTLt[V, B] = (super.meetE2 ) //& OBSOLETE ~ thismuis ya probablement plus besoin d'enlever thismuis
  }
  val gc= new DetectedAgV(bve.meetE2 | bve.meetV) with keepMeInsideForce {
    override def inputNeighbors = List(d)
  }
} //todo verifier que override fonctionne


/** voronoi is our first instance of partially  bounded agents, so we define it here, it is our first bounded agent. */
class Vor(part:MovableAgV with addDist with addGcenter /*with keepOutsideForce*/ )
  extends BoundedAgV("globalInv", part.gc, part.gc.keepMeInside ) with MovableAgV with sdntool.addBlobVfields with blobConstrain with blobConstrTrou
{  override def inputNeighbors=List(part.gc,part.d)

  //force(introduceNewPriority(),"vote",'v',vote())//specific forces applied to voronoi, pour l'instant ne sert a rien.
  appendForce("vote",'|', moderate(vote,"vote" ))

  /** illustrates how to print stuff */var tmp:BoolV=null;
  /** priority of "obliged" force */
  //force(introduceNewPriority(),"repulse",'|',part.d.repulseVor)//specific forces applied to Flies
  appendForce("repulse",'|', moderate(part.d.repulseVor,"repulse" ))

  /** donotcover part turns out not to be necessary; indeed, particle will not overlap gcenter,
   * and that alone is sufficient to ensure that part very rarely overlap voronoi
   *  when it does it, in very dense condition, this does not last long*/
  //force(introduceNewPriority(),"donotCoverPart",'<',h.keepOutside) h.addConstrSync(new ConstrSyncImply(this,h, ~ h.isV & this.isV ))

  //zone sync equals no gcenter and no voronoi,
  // on this zone, apparition of gcenter (flip) implies also apparition of voronoi (flip).
  // on this zone, if the voronoi deflip, so should do the gabriel center, although it cannot, (so it triggers a bug).
  part.gc.addConstrSync("inside",'w', new ConstrSyncImply(part.gc,this,~part.gc.isV & ~this.isV))
  // the slow constraints emited by radius hits the particle not the voronoi.
  // the slow constraints emitted by Mudist(voronoi) does hit the voronoi, we should check that it does not transfer to
  // the gcenter. let us display the
 override def showMe(){super.showMe; bf.bv.showMe}
}


trait addVor {
  self:MovableAgV with addDist  with addGcenter /*with keepOutsideForce*/=>
  val vor: Vor =new Vor(this)
}


/** to be used later on, when we implement simult */
/*class Voronoi (parent: MuStruct[V,B] with addDist with addGcenter)
  extends BoundedAgV("globalInv",parent.d, parent.gc.keepInside) {
  override def arg = parent
}*/