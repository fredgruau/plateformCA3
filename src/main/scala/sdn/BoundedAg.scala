package sdn

import compiler.SpatialType.{BoolV, BoolVe, UintV}
import compiler.{AST, B, Locus, Ring, V, repr}
import dataStruc.DagNode
import dataStruc.DagNode.Singleton
import progOfStaticAgent.{Homogen}
import sdntool.addDist



/** voronoi is our first instance of partially  bounded agents, so we define it here, allthough we should modify the code
 * so as to faire entrer en scéne bounded agent. */
class Vor(h:MovableAgV with addDist with addGcenter with keepOutsideForce )
  extends MovableAg[V]("globalInv") with MovableAgV with addBloobV with blobConstrain with blobConstrTrou
{  override def inputNeighbors=List(h.gc,h.d)
  /** exploring priority */
  var tmp:BoolV=null;
  //val explore=introduceNewPriority();  force(explore, "explore",'O', bf.smoothen)
  val homogeneize=introduceNewPriority()
  /** priority of "obliged" force */
  override val priorityObliged=homogeneize+1  //on pourrait automatiser cela
  force(homogeneize,"repulse",'|',h.d.repulseVor)//specific forces applied to Flies
  /** keep outide is not necessary; particle will not overlap gcenter is sufficient to ensure that part does not overlap voronoi */
//force(introduceNewPriority(),"donotCoverPart",'<',h.keepOutside)
 // h.addConstrSync(new ConstrSyncImply(this,h, ~ h.isV & this.isV ))
  // voronoi has to contain gcenter
    force(introduceNewPriority(),"containGcenter",'>',h.gc.keepInside) //todo, this is a forced move to be supplied directly upon definition of bounded agent
}

trait addVor {
  self:MovableAgV with addDist  with addGcenter with keepOutsideForce=>
  val vor=new Vor(this)
}
/**
 * support location is partially computed from parent's support (input neighbors of the DAG )
 * @param follows Move that is imposed to the agent so that its follows the bounding agent
 * @param arg input agents which is bounding */
 class BoundedAgV(init:String, arg: MuStruct[_<:Locus,_ <:Ring] , val follows:Force )
  extends  MovableAg[V](init) with  MovableAgV   {

  override val priorityObliged: Int = -1

  override def inputNeighbors: List[MuStruct[_ <: Locus, _ <: Ring]] = ???
}

/** to be used later on, when we implement simult */
/*class Voronoi (parent: MuStruct[V,B] with addDist with addGcenter)
  extends BoundedAgV("globalInv",parent.d, parent.gc.keepInside) {
  override def arg = parent
}*/