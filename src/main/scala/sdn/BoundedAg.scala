package sdn

import compiler.ASTLfun.{cond, fromInt}
import compiler.SpatialType.{BoolV, BoolVe, UintV}
import compiler.{AST, B, Locus, Ring, V, repr}
import dataStruc.DagNode
import dataStruc.DagNode.Singleton
import progOfStaticAgent.Homogen
import sdn.ForceAg.{Agg, Aggg}
import sdntool.addDist

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer



/** voronoi is our first instance of partially  bounded agents, so we define it here, allthough we should modify the code
 * so as to faire entrer en scéne bounded agent. */
class VorOld(h:MovableAgV with addDist with addGcenter with keepOutsideForce )
  extends MovableAg[V]("globalInv") with MovableAgV with addBloobV with blobConstrain with blobConstrTrou
{  override def inputNeighbors=List(h.gc,h.d)
  /** illustrates how to print stuff */
  var tmp:BoolV=null;
  //val explore=introduceNewPriority();  force(explore, "explore",'O', bf.smoothen)
  val homogeneize=introduceNewPriority()
  /** priority of "obliged" force */
  force(homogeneize,"repulse",'|',h.d.repulseVor)//specific forces applied to Flies
  /** donotcover part turns out not to be necessary; indeed, particle will not overlap gcenter,
   * and that alone is sufficient to ensure that part very rarely overlap voronoi
   *  when it does it, in very dense condition, this does not last long*/
//force(introduceNewPriority(),"donotCoverPart",'<',h.keepOutside) h.addConstrSync(new ConstrSyncImply(this,h, ~ h.isV & this.isV ))

  // voronoi has to allways contain the whole of  gcenter
    force(introduceNewPriority(),"containGcenter",'>',h.gc.keepInside) //todo, this is a forced move to be supplied directly upon definition of bounded agent

}

/**
 * support location is partially computed from parent's support (input neighbors of the DAG )
 * @param follows Move that is imposed to the agent so that its follows the bounding agent
 * @param arg input agents which is bounding */
abstract class BoundedAgV(init:String, val bounding: Aggg , val follows:Force )
  extends  MovableAg[V](init) with  MovableAgV   {
  var priorityObliged= -1
  /** take into account the follow force called when computing flipOfmove*/
  override def allForces: ArrayBuffer[mutable.LinkedHashMap[String, Force]] = {
    val copy = forces.clone()   // nouvelle instance
    val nbforces=forces.size
    priorityObliged=nbforces //priority of the follow force
    copy+= mutable.LinkedHashMap[String,Force]();
    copy(nbforces)("!follows")=follows
    moves+= mutable.LinkedHashMap[String,MoveC]();
    copy
  }
  /** bounded variable must compute when they are forced by their bounding parent, because a forced move cannot be randomly canceled */
  var isForced:BoolV=null
  //on calcule isForced au plus tot, dés qu'on a yesHighestTriggered
  override def setFliprioOfMove(): Unit = { super.setFliprioOfMove();isForced=yesHighestTriggered>fromInt(1)  }
  override def  flipRandomlyCanceled=   cond(isForced, flipAfterSync,super.flipRandomlyCanceled)
}
/** voronoi is our first instance of partially  bounded agents, so we define it here, it is our first bounded agent. */
class Vor(part:MovableAgV with addDist with addGcenter /*with keepOutsideForce*/ )
  extends BoundedAgV("globalInv", part.gc,part.gc.keepInside ) with MovableAgV with addBloobV with blobConstrain with blobConstrTrou
{  override def inputNeighbors=List(part.gc,part.d)
  /** illustrates how to print stuff */var tmp:BoolV=null;
  /** priority of "obliged" force */
   force(introduceNewPriority(),"repulse",'|',part.d.repulseVor)//specific forces applied to Flies
  /** donotcover part turns out not to be necessary; indeed, particle will not overlap gcenter,
   * and that alone is sufficient to ensure that part very rarely overlap voronoi
   *  when it does it, in very dense condition, this does not last long*/
  //force(introduceNewPriority(),"donotCoverPart",'<',h.keepOutside) h.addConstrSync(new ConstrSyncImply(this,h, ~ h.isV & this.isV ))

  //zone sync equals no gcenter and no voronoi,
  // on this zone, apparition of gcenter (flip) implies also apparition of voronoi (flip).
  // on this zone, if the particle deflip, so should do the gabriel center, although it cannot, (so it triggers a bug).
  part.gc.addConstrSync("toto",'w', new ConstrSyncImply(part.gc,this,~part.gc.isV & ~this.isV))
  // the slow constraints emited by radius hits the particle not the voronoi.
  // the slow constraints emitted by Mudist(voronoi) does hit the voronoi, we should check that it does not transfer to
  // the gcenter. let us display the

}


trait addVor {
  self:MovableAgV with addDist  with addGcenter /*with keepOutsideForce*/=>
  val vor=new Vor(this)
}


/** to be used later on, when we implement simult */
/*class Voronoi (parent: MuStruct[V,B] with addDist with addGcenter)
  extends BoundedAgV("globalInv",parent.d, parent.gc.keepInside) {
  override def arg = parent
}*/