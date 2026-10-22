package progOfStaticAgent
import sdntool.{Leader, addDist, addDistVor, addInsideBall, addLeader, addRadius, addRect, addSurf, addZone, addZoneGt, addZoneLt}
import compiler.ASTL.{ASTLg, anticlock, broadcast, clock, delayedL, sym, transfer}
import compiler.ASTLfun.{cond, e, fromInt, imply, v}
import compiler.SpatialType.{BoolV, BoolVe, BoolVf, UintV, UintVx}
import compiler.{AST, ASTBfun, ASTLt, B, E, Locus, Ring, SI, T, V, chip}
import dataStruc.DagNode.EmptyBag
import dataStruc.{BranchNamed, Named}
import progOfmacros.Comm.{adjacentBall, insideBall, neighborsSym}
import progOfmacros.Compute.countNeighbors
import progOfmacros.RedT.{cac, shrink2min1to5, shrinkshrink}
import progOfmacros.Topo.nbccV
import progOfmacros.Wrapper
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
  //val part=new Homogen()
  val part=new SpreadOnSummit()
  //val part=new Convergent()
  showMustruct;
  setFliprioOfMoveAndFlipAfterConstr();  setFlipSynced()
  //part.shoow(part.gc.flipAfterSync,part.gc.flipAfterConstr)
  showTrucPourDebugger
  part.shoow(part.allflipRandcancel)
  part.shoow(part.vor.muis) //triggers evaluation
  part.shoow(part.gc.alreadyThere,part.gc.muis)
  //part.shoow(part.mergedMoves("stabilize").asInstanceOf[MoveC2].no.empty)
  //garder ce qui suit en commentaire, ca indique comment faire pour montrer l'effet d'une force via son nom, come "seize"
 // part.shoow(part.mergedMoves("seize").asInstanceOf[MoveC1].yes.empty)
//  part.shoow(part.mergedMoves("seize").asInstanceOf[MoveC1].push)
  //part.shoow(part.mergedMoves("seize").asInstanceOf[MoveC2].no.empty)
  //part.shoow(part.mergedMoves("seize").asInstanceOf[MoveC2].no.push)

  /*  part.shoow(part.vor.mergedMoves("repulse").asInstanceOf[MoveC2].yes.empty)
   part.shoow(part.vor.mergedMoves("repulse").asInstanceOf[MoveC2].no.empty)
   part.shoow(part.mergedMoves("repulse").asInstanceOf[MoveC2].yes.empty)
   part.shoow(part.mergedMoves("repulse").asInstanceOf[MoveC2].no.empty)
   part.shoow(part.vor.mergedMoves("containGcenter").asInstanceOf[MoveC2].yes.push)

   */
  // part.ar.showMe
 part.shoowText(part.ar.muis,List())
  part.shoow(part.lead.muis)
  part.shoow(part.singleStreched)
  part.bTn.showMe
  part.shoow(part.muis)
  part.vor.showMe
  part.vor.baba.showMe;   part.vor.bf.showMe;  part.showMe
  part.bf.showMe;  part.baba.showMe;  part.bve.showMe;  part.d.showMe; part.dgv.showMe
  part.shoowText(part.ri.muis,List()); part.ri.showMe;
  //part.shoow(part.moderators("repulse"))
  // part.sm.showme; //does not work, because sm is not taking part i the computation.
 // part.shoow(part.sm.muis, part.sm.b.meetiE, part.sm.b.meetiV, part.sm.b.ctr, part.sm.b.isDoubleton)
/*  part.shoow(part.summit.centerZlt,part.summit.meetiE,part.summit.meetiV,part.summit.nbcc3,part.summit.twoNeighbor,part.summit.isTripleton,
    part.summit.meetiEselected,part.summit.loosangeIncluded,part.summit.losangeApexes,part.summit.rhombusShouldFlip,part.summit.losangeApexToRemoveFromCtr,
    part.summit.meetEblockingZltmeetE,part.summit.weakMeetE,part.summit.meetEblockingZltnbcc3,part.summit.raand)
 part.shoowText(part.summit.density, List())*/
  part.zon.showMe
  part.qf.showMe
  part.sum.showMe
  part.ctr.showMe
  part.blobsm.showMe
  //part.shoow(part.sf.isSummit)
 // part.shoowText( part.sf.density,List())
//  part.shoow(part.centr.notCentrForallize)
 // part.shoow(part.centr.isSummit)
 // part.centr.showMe
//  part.shoow(part.bve.meetE2)
  part.shoow( part.vor.isForced)
  part.shoow(part.inbl.muis)
  part.inbl.showMe
  part.shoow( part.deflipSync)
  part.shoow( part.vor.deflipSync)
  //;  part.inbl.showMe
 // part.shoow(part.doubletonImplyStreched)
  //part.shoow(part.next2strechedDoubleton)
  //part.shoow(part.hyperStretchedTripleton)

  //part.shoow(part.zon.zlt.muis,part.rect); part.shoow(part.zon.zgt.muis);
 // part.zon.zlt.showMe;    part.zon.zgt.showMe
  // part.z.showMe
}

/** basic quasiparticle with blob and quasipoint constraints */
class Seed extends MovableAg[V]("global") with MovableAgV  with addBloobV with blobConstrain with addQpointFields with QpointConstrain
  with EmptyBag[sdn.MuStruct[_<: Locus,_<:Ring]]

/** computes the average and variance of a partial SintV defined by a pair ( SintV ;BoolV )*/
trait stat{ self:Homogen with addLeader with addRadius=> staat(lead.muis, ri.muis)// staat(bve.meet, d.muis);;staat(bve.meetV, d.muis);  staat(bve.meetE2, d.muis)
   }


/**adds distance, gabriel center, voronoi distance to voronoi, and then finally repulsive force from voronoi*/
class Homogen() extends Seed with addDist with addGcenter // with keepOutsideForce
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

class SpreadOnSummit extends Homogen with addRadius with addInsideBall with addRect with addSurf
  with addZone
 // with addSommet
  with addSummit with addBlobSummit with addCenter
  with addLeader  with stat  with addTunnel/*: we stopped using zone*/
{  /** seize applique la force qui cible le  centre si et seulement si le radius est uniforme */
  /** cette force exerce une poussé des particules vers les radisu plus grand
 *  elle "prévient" les situation de campfire,
 * idealement pour etre sur de solutionner les campfire, faudrait  mettreune priorité plus forte que repulse,
 * mais cela devient trop instable.
 * pour les transition de rayon, uniformize radius crée des instabilité
 */
 val uniformizeRadius:Force= repulsePropagate(zon.zgt.muis) // | attractPropagate(zon.zlt.muis)

 // val seizeCenter2:Force=restrictF(cibler(summit.centerZlt),zon.zeqOnSeed)
  val seizeCenter=ciblerFaible(ctr.ctr2) //on préfére mettre en jeu plusieurs force

//  val seizeNbcc3= ciblerFaible((blobsm.nbcc3 & ~ctr.rhombusApexToRemoveFromCtr))
val seizeTunnel=ciblerFaible(bTn.meetV & ~blobsm.losangeApexes & ~sum.weakSummit /*& ~blobsm.losangeApexes*//*& blobsm.meet c'est  redondant par contre le tunnel empeche d'empecher*/) // | Force.empty(~blobsm.meet) //marche depuis un singleton mais aussi depuis un doubleton
  val seizeTunnelOld=Force.ciblerNotEmptyPush(singleStreched,transfer(v(dgv.streched)))
  val seizeNbcc3= ciblerFaible((blobsm.nbcc3 & ~blobsm.losangeApexes & ~sum.weakSummit )) //| Force.empty(blobsm.losangeApexes) //on veut oublier zlt
  val seizeLeton=ciblerFaible(  blobsm.isDoubleton | blobsm.isTripleton)
  val seizeMeetiEnotShadowed=ciblerFaible(blobsm.meetiEnotShadowed)
   val toFire=Force.empty(zon.isBLockingToFire)|Force.total.restrict(zon.zlt.muis) //exploration plus avant de zlt
  // & ~ctr.next2vor)
  val singleStreched: BoolV = exist[E,V] (transfer(v(dgv.streched & bf.insideE))) & ~exist[E,V](transfer(v(dgv.doubleStreched & bf.insideE)))

  force(introduceNewPriority(), "explore",'O', Force.total)
  val keepTunnelWide = MutKeepFlipIf(this,One(false),dgv.doubleStreched) _ ; //on peut pas détruire en meme temps deux elements sur un bord du tunnel wide.
  //val forbidExtremityTunnel=   CancelFlipIf(this,One(false),bTn.nbcc0 ) _// agents should not invade cells where distance is negative
  //addConstraint("exttun",'u',forbidExtremityTunnel)
  addConstraint("nmeet",'n',keepTunnelWide); //todo préciser que ca contraint juste les force de priorité inférieure a prioTunnel
  val prioTunn=introduceNewPriority();  force(prioTunn, "tunnel",'t', seizeTunnel)
  val extremity= ~blobsm.meet & sum.isSummit2 //le complementaire des meeting points, sur le sommet. celui qu'on envisage de  vider d'office
  shoow(extremity)
 force(introduceNewPriority(), "noext",'e', Force.empty(extremity ))  //conserve une epaisseur de tunnel de deux
  force(introduceNewPriority(), "letonseize",'y', seizeLeton)
  force(introduceNewPriority(), "nbcc3seize",'3', seizeNbcc3)
  //force(introduceNewPriority(), "tofire",'f', toFire)
  force(introduceNewPriority(), "norhomb",'E', Force.empty(blobsm.losangeApexes))  //conserve une epaisseur de tunnel de deux

  // force(introduceNewPriority(),"unif",'u',uniformizeRadius)
  force(introduceNewPriority(),"repulse",'|',dgv.repulse)//dgv.repulse moves seed away from voronoi, in fact from gcenter,
  // because it is allowed to overlap voronoi, which should thereafter withdraw.
  // This overlapping is the key for ensuring uniformization of the radius.?? that remains to be investigated.


 }


/** obsolete, calcule une convergence qui n'est pas assez generale pour stabiliser, soit elle stabilise trop tot,
 * soit elle ne stabilise  pas assez*/
/*class Convergent extends Homogen with addLeader //with addRadius // //pas besoin de leader pour le moment
{  val sf=new Attributs()
{ //sf==stableFields
  override val muis: ASTLg with carrySysInstr = Convergent.this.muis
  /** border of qparticle  where dg diminishes */
  val brdVeSloped=bf.brdVeIn & dgv.sloplt
  /** around isV, adds Vertices on the otherside of brdVeslopped */
  val isVplus: ASTLt[V, B] =isV | exist(transfer(sym(transfer(brdVeSloped))))
  /** add vertex  if three neighbors are on */
  val isVsmoothed=smoothen(isVplus)
  /** computes the Vf bool and yes that is right*/
  val isVtest=testShrink(isVplus)
  /** add vertex  if four neighbors are on, bugs, more restrictive therefore, than smoothen */
  val isVsmoothed2: BoolV =isVplus| exist(isVtest)
  // shoow(isVplus,isVsmoothed,isVsmoothed2,isVtest)  /** true for one seed if on its whole border dg diminishes */
  /** essai de stable plus compliqué */
  val stableComplex=Convergent.this.muis.asInstanceOf[BoolV] & insideBall(isVsmoothed2)
  val stableComplexAll=forallize(stableComplex) & isV
  /**  stable simple qu'on est sur qu'il ne perturbe pas l'homogeneisation */
  val stableSimple: ASTLt[V, B] =isV & inside(imply(bf.brdVeIn,dgv.sloplt))
  val stableSimpleAll=forallize(stableSimple) & isV
  override def showMe: Unit = ()// shoow(isVplus) //shoow(stable1,stable2)
  val balance: Force = new Force() {
    //import compiler.ASTLfun.fromBool
    override def actionV(ag: MovableAgV): MoveC = {
      val yes=MoveC1(root4naming.myFalse,e(root4naming.myFalse)) //force is pure negative
      /** if stable2 , this will cancel movement of lower priority, */
      val no = MoveC1(stableSimpleAll, e(stableSimpleAll)& bf.brdVeIn) // negative  forces
      MoveC2(yes,no)
    }
  }
}
  // force(introduceNewPriority(),"balance",'_',sf.balance)
}*/