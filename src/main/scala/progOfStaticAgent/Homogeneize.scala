package progOfStaticAgent
import sdntool.{Leader, Qpoint, QpointConstrain, addDist, addDistVor, addInsideBall, addLeader, addQpointFields, addRadius, addRect, addArea, addZone, addZoneGt, addZoneLt, addSeize, blobConstrain}
import compiler.ASTL.{ASTLg, anticlock, broadcast, clock, delayedL, sym, transfer}
import compiler.ASTLfun.{cond, e, fromInt, imply, v}
import compiler.SpatialType.{BoolV, BoolVe, BoolVf, UintV, UintVx}
import compiler.{AST, ASTBfun, ASTLt, B, E, Locus, Ring, SI, T, V, chip}
import dataStruc.DagNode.EmptyBag
import dataStruc.{BranchNamed, Named}
import progOfmacros.Wrapper.{border, borderS, exist, existS, inside, insideS, smoothen, smoothen2, testShrink}
import sdn.Force.{attractPropagate, cibler, ciblerFaible, repulsePropagate, restrictF, stabilizeNotEmpty}
import sdn.Globals.root4naming
import sdn.MuStruct.{setFlipSynced, setFliprioOfMoveAndFlipAfterConstr, showMustruct, showTrucPourDebugger}
import sdn.Util.{addLt, addSym}
import sdn._
object Homogeneize{
  /** bit size for integer encoding distance to particle*/   val nbitD=4
  /** bit size for integer encoding distance to gcenter and voronoi*/   val nbitDgv=4
  /** bit size for integer encoding innerRadius*/   val nbitRi=4
}
/**illustrate the working of repulsion combined with exploration  */
class Homogeneize() extends LDAG with Named with BranchNamed
{
  //builds the hierarchy of agents
  val part=new HomogenCVG()
  //iterate through the hierarchy,  to apply forces, constraints, and sync
  showMustruct;
  setFliprioOfMoveAndFlipAfterConstr();  setFlipSynced()
  //part.shoow(part.gc.flipAfterSync,part.gc.flipAfterConstr)
  showTrucPourDebugger
  part.shoow(part.rand)
  part.shoow(part.vor.muis) //triggers evaluation
  part.shoow(part.gc.alreadyThere,part.gc.muis)
  part.shoow(part.vor.mergedMoves("repulse").asInstanceOf[MoveC2].yes.empty)
  /*
  garder ce qui suit en commentaire, ca indique comment faire pour montrer l'effet d'une force via son nom, come "seize"

   part.shoow(part.vor.mergedMoves("repulse").asInstanceOf[MoveC2].no.empty)
   part.shoow(part.mergedMoves("repulse").asInstanceOf[MoveC2].yes.empty)
   part.shoow(part.mergedMoves("repulse").asInstanceOf[MoveC2].no.empty)
   part.shoow(part.vor.mergedMoves("containGcenter").asInstanceOf[MoveC2].yes.push)

   */
  // part.ar.showMe
 part.shot(part.ar.muis)
  part.ar.showMe()

  part.shoow(part.lead.muis)
  //part.shoow(part.singleStreched)
  part.bfTn.bv.showMe
  part.shoow(part.muis)
  part.vor.showMe
  //part.vor.baba.showMe;
  part.showMe
  part.bf.showMe;  part.bf.bv.showMe;  part.bve.showMe;  part.d.showMe; part.dgv.showMe
  part.shoowText(part.ri.muis,List()); part.ri.showMe;

 // part.zon.showMe
  part.qf.showMe
  part.sum.showMe
  part.bsm.showMe
  part.shoow(part.inbl.muis)
  part.inbl.showMe
  part.shoow( part.deflipSync)
  part.shoow( part.vor.deflipSync)
}


  /** computes the average and variance of a partial SintV defined by a pair ( SintV ;BoolV )*/
  trait statHomo{ self:Homogen with addLeader with addRadius with addArea=>
    staat(lead.muis, ar.total) // this is used, because the area is informative
    staat(lead.muis, ri.muis) //however this is not used because the radius precision is too low.
  }



/**adds distance, gabriel center, voronoi distance to voronoi, and then finally repulsive force from voronoi*/
class Homogen() extends Qpoint with addDist with addGcenter // with keepOutsideForce
  with addVor with addDistVor
{  /** seed should not overlap gCenters */
   val  avoidGc= CancelFlipIf(this,One(false), gc.detected  ) _
  addConstraint("avoidgc",'g',avoidGc)

}

/** we compute the insideRadius rin,
 *  the ball centered on part, with radius rin
 *  zonelt (resp. zonegt) which inform wether the adjacent voronoi has larger (resp. smaller) rin
 *  a force fine tunning occupancy of summits by:
 *    1-   if zoneLt or zoneGt are touchin particle, attract particle to  zoneLt and repulsefrom zoneGt
 *    2- otherwise, use the the force seizesummit  which fills up summit according to summit's density
 *       by choosing to invade preferently vertices on summit whose number of summit-neighbor  are largest
 *  */

class HomogenCVG extends Homogen   with addSeize with addArea with addRadius with addInsideBall  /*with addRect  with addZone*/
  with addLeader  with statHomo /*: we stopped using zone*/
{
  /** cette force exerce une poussé des particules vers les radius plus grand
 *  elle "prévient" les situation de campfire,
 * idealement pour etre sur de solutionner les campfire, faudrait  mettreune priorité plus forte que repulse,
 * mais cela devient trop instable.
 * pour les transition de rayon, uniformize radius crée des instabilité
 */
 //val uniformizeRadius:Force= repulsePropagate(zon.zgt.muis) // | attractPropagate(zon.zlt.muis)
  /** seize applique la force qui cible le  centre si et seulement si le radius est uniforme */
 // val seizeCenter2:Force=restrictF(cibler(isSummit2.centerZlt),zon.zeqOnSeed)
 // val seizeMeetiEnotShadowed=ciblerFaible(bsm.meetiEnotShadowed)
 // val toFire=Force.empty(zon.isBLockingToFire)|Force.total.restrict(zon.zlt.muis) //exploration plus avant de zlt
  // & ~ctr.next2vor)
 // val singleStreched: BoolV = exist[E,V] (transfer(v(dgv.streched & bf.insideE))) & ~exist[E,V](transfer(v(dgv.doubleStreched & bf.insideE)))
  /** le complementaire des meeting points, sur le sommet. celui qu'on envisage de  vider d'office */
 // val extremity= ~bfs.bv.meet & sum.isSummit2   //shoow(extremity)//force(introduceNewPriority(), "noext",'e', Force.empty(extremity ))  //conserve une epaisseur de tunnel de deux. Il s'agit de forbidExtremityTunnel implementé comme une contrainte
  //val seizeTunnel: Force =ciblerFaible(bTn.meetV & ~bsm.losangeApexes & ~sum.weakSummit)
  // val seizeNbcc3= ciblerFaible((bsm.nbcc3 & ~bsm.losangeApexes & ~sum.weakSummit )) //| Force.empty(toto.losangeApexes) //on veut oublier zlt
  //val seizeLeton=ciblerFaible(  bsm.isDoubleton | bsm.isTripleton)
  val mySeize= moderate(seize,"seize")
 //force(introduceNewPriority(), "tunnel",'t', seizeTunnel);  force(introduceNewPriority(), "letonseize",'y', seizeLeton);  force(introduceNewPriority(), "nbcc3seize",'3', seizeNbcc3)
  val explore=moderate(Force.total,"explore")
  appendForce("explore",'0', explore )
  appendForce("seize",'y',mySeize )
  appendForce("repulse",'|',dgv.repulse)
  /** on peut pas détruire en meme temps deux elements sur un bord du tunnel wide.
   * withLimitingPrio(getPriority(seize)+1) assure que cette contrainte s'exerce  juste pour les force de priorité inférieure ou egal a la priorité de size
   */
  val keepTunnelWide = (MutKeepFlipIf(this,One(false),dgv.twoStrechedSeparator) _ ).withLimitingPrio(getPriority(mySeize)+1) ; addConstraint("nmeet",'n',keepTunnelWide);


  // particles is allowed to overlap voronoi, it may be the key for ensuring uniformization but that remains to be investigated.

 }
