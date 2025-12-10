package progOfStaticAgent

import compiler.ASTL.{ASTLg, anticlock, clock, delayedL, sym, transfer}
import compiler.ASTLfun.{cond, e, fromInt, imply, v}
import compiler.SpatialType.{BoolV, BoolVe, BoolVf, UintV, UintVx}
import compiler.{AST, ASTBfun, ASTLt, B, E, Locus, Ring, SI, T, V, chip}
import dataStruc.DagNode.EmptyBag
import dataStruc.{BranchNamed, Named}
import progOfmacros.Comm.{adjacentBall, insideBall, neighborsSym}
import progOfmacros.Compute.countNeighbors
import progOfmacros.RedT.{cac, shrinkshrink}
import progOfmacros.Topo.nbccV
import progOfmacros.Wrapper
import progOfmacros.Wrapper.{border, borderS, exist, existS, inside, insideS, smoothen, smoothen2, testShrink}
import sdn.Force.restrictF
import sdn.Globals.root4naming
import sdn.MuStruct.{setFlipSynced, setFliprioOfMoveAndFlipAfterConstr, showMustruct, showTrucPourDebugger}
import sdn.Util.{addLt, addSym}
import sdn._
import sdntool.{addDist, addDistVor, addInsideBall, addRadius, addRect, addZoneGt, addZoneLt}
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
  showMustruct;  setFliprioOfMoveAndFlipAfterConstr();  setFlipSynced()
  //part.shoow(part.gc.flipAfterSync,part.gc.flipAfterConstr)
  showTrucPourDebugger
  part.shoow(part.vor.muis) //triggers evaluation
  part.shoow(part.gc.alreadyThere)
  part.shoow(part.mergedMoves("seize").asInstanceOf[MoveC2].yes.empty)
  part.shoow(part.mergedMoves("seize").asInstanceOf[MoveC2].yes.push)
  part.shoow(part.mergedMoves("seize").asInstanceOf[MoveC2].no.empty)
  part.shoow(part.mergedMoves("seize").asInstanceOf[MoveC2].no.push)

  /*  part.shoow(part.vor.mergedMoves("repulse").asInstanceOf[MoveC2].yes.empty)
   part.shoow(part.vor.mergedMoves("repulse").asInstanceOf[MoveC2].no.empty)
   part.shoow(part.mergedMoves("repulse").asInstanceOf[MoveC2].yes.empty)
   part.shoow(part.mergedMoves("repulse").asInstanceOf[MoveC2].no.empty)
   part.shoow(part.vor.mergedMoves("containGcenter").asInstanceOf[MoveC2].yes.push)*/
  part.shoow(part.muis)
  part.vor.showMe;   part.vor.b.showMe;   part.vor.bf.showMe;  part.showMe
  part.bf.showMe;  part.b.showMe;  part.bve.showMe;  part.d.showMe; part.dgv.showMe
  part.shoowText(part.ri.muis,List()); part.ri.showMe;
 part.gc.showme;
  part.sf.showMe
  part.su.showMe
  //part.shoow(part.sf.isSummit)
 // part.shoowText( part.sf.density,List())
  part.shoow(part.bve.meetE2)
  part.shoow( part.vor.isForced)
  part.shoow(part.inbl.muis);  part.inbl.showMe
  part.shoow(part.zlt.muis,part.rect);  part.zlt.showMe
  part.shoow(part.zgt.muis);  part.zgt.showMe
  // part.z.showMe
}

/** basic quasiparticle with blob and quasipoint constraints */
class Seed extends MovableAg[V]("global") with MovableAgV  with addBloobV with blobConstrain with addQpointFields with QpointConstrain
  with EmptyBag[sdn.MuStruct[_<: Locus,_<:Ring]]

/** moves as much as possible called "fly" because flies move without purpose */
class Flies2 extends Seed { force(introduceNewPriority(), "explore",'O', Force.total) }

/** computes the average and variance of a partial SintV defined by a pair ( SintV ;BoolV )*/
trait stat{ self:Homogen=>  staat(bve.meet, d.muis);  staat(bve.meetV, d.muis)
  staat(muis, dgv.muis);  staat(bve.meetE2, d.muis)}

/**adds distance, gabriel center, voronoi distance to voronoi, and then finally repulsive force from voronoi*/
class Homogen() extends Flies2 with addDist with addGcenter // with keepOutsideForce
  with addVor with addDistVor with stat
{  /** seed should not overlap gCenters */
   val  avoidGc= CancelFlipIf(this,One(false), gc.detected  ) _
  addConstraint("avoidgc",'g',avoidGc)

}


/** obsolete */
class Convergent extends Homogen //with addRadius // with Lead //pas besoin de leader pour le moment
{  val sf=new Attributs()
{ //sf==stableFields
  override val muis: ASTLg with carrySysInstr = Convergent.this.muis
  /** border of qparticle  where dg diminishes */
  val brdVeSloped=bf.brdVeIn & dgv.sloplt
  /** around isV, adds Vertices on the otherside of brdVeslopped */
  val isVplus=isV | exist(transfer(sym(transfer(brdVeSloped))))
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
}

/** we compute the insideRadius rin,
 *  the ball centered on part, with radius rin
 *  zonelt (resp. zonegt) which inform wether the adjacent voronoi has larger (resp. smaller) rin
 *  a force fine tunning occupancy of summits by:
 *    1-   if zoneLt or zoneGt are touchin particle, attract particle to  zoneLt and repulsefrom zoneGt
 *    2- otherwise, use the the force seizesummit  which fills up summit according to summit's density
 *       by choosing to invade preferently vertices on summit whose number of summit-neighbor  are largest
 *  */
class SpreadOnSummit extends Convergent with addRadius with addInsideBall with addRect with addZoneLt with addZoneGt /* with addLeader*/
{
  val su=new Attributs() { //su==summitFields
  override val muis: ASTLg with carrySysInstr = SpreadOnSummit.this.muis

  val isSummit:BoolV=  ~exist(dgv.slopgt) & adjacentBall(isV)
  val density: UintVx =addLt(countNeighbors( addSym(e(isSummit)).sym))
    /** summits of local highest density */
    val isSummSumm=isSummit & ~exist(transfer( density.gt)& neighborsSym(e(isSummit)))
    /** true if there is a single sumsum */
   val singleSumSum= isSummSumm & ~exist(transfer( v(density.eq)) & neighborsSym(e(isSummit)))
    val nbCC: UintV = nbccV(borderS(isSummit))
    val meetV= nbCC > fromInt(1)
    val cutingSumSum=singleSumSum&meetV
    val vassal=shrinkshrink(neighborsSym(e(isSummit)))

  val notDense= density < fromInt(3)
  val notDenseN=addSym(e(notDense))
    val zeq=  ~(zlt.existOnPart|zgt.existOnPart)
    override def showMe: Unit = {
      shoow(isSummit,cutingSumSum,vassal)
    //  shoowText(density,List())
    }
  val seizeSummit=new Force{
    override def actionV(ag:MovableAgV): MoveC= {
      val hasNearer: BoolV = exist(transfer( density.lt) & neighborsSym(e(ag.muis)))
      val hasFurther = Wrapper.exist(transfer( density.gt) & neighborsSym(e(ag.muis)))
      val oui=MoveC1( ag.muis & hasFurther & ~hasNearer & notDense, //on vide si y a des plus loin, pas de plus pres,
        // et si on n'est pas dense
        transfer(density.gt)& ag.bf.brdVeIn) //on envahit des voisines plus dense OK
      //on va toujours remplir un vertice dont la densité est plus grande
      //pour cibler des particules tripleton,
      // on peut ou on peut ne pas autoriser  de vider si nombre de voisin est   3

      val non = MoveC1(ag.muis & ~hasFurther,  //on interdit de vider si y a pas de plus dense a coté
        transfer( density.lt)  & ag.bf.brdVeIn & notDenseN.sym ) //on interdit d'envahir des moins dense qui de plus ne sont pas dense
      //on ne vas pas non plus chercher a remplir un vertice sommet voisin de dentisté pluc petite, si celle ci est  <3
      MoveC2(oui, non)
    }
  }

  val f=seizeSummit
  force(introduceNewPriority(),"seize",'z',restrictF(f,zeq ))//allows final convergence
  force(introduceNewPriority(),"repulse",'|',dgv.repulse)//go away from voronoi, but in fact from gcenter,
  // because it is allowed to overlap voronoi, which should thereafter withdraw.
  // This overlapping is the key for ensuring uniformization of the radius.

}


 }
