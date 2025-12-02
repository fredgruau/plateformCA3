package progOfStaticAgent

import compiler.ASTL.{ASTLg, anticlock, clock, delayedL, sym, transfer}
import compiler.ASTLfun.{cond, e, fromInt, imply}
import compiler.SpatialType.{BoolV, BoolVe, BoolVf}
import compiler.{AST, ASTBfun, ASTLt, B, E, Locus, Ring, SI, T, V, chip}
import dataStruc.DagNode.EmptyBag
import dataStruc.{BranchNamed, Named}
import progOfmacros.Comm.{adjacentBall, insideBall, neighborsSym}
import progOfmacros.Compute.countNeighbors
import progOfmacros.RedT.cac
import progOfmacros.Wrapper
import progOfmacros.Wrapper.{border, borderS, exist, existS, inside, insideS, smoothen, smoothen2, testShrink}
import sdn.MuStruct.{setFlipSynced, setFliprioOfMoveAndFlipAfterConstr, showMustruct, showTrucPourDebugger}
import sdn.Util.{addLt, addSym}
import sdn._
import sdntool.{addDist,  addDistGcenterVor, addRadius}

/**illustrate the working of repulsion combined with exploration  */
class Homogeneize() extends LDAG with Named with BranchNamed
{
  //val part=new Homogen()
  val part=new SpreadOnSummit()
  //val part=new Convergent()
  showMustruct
  setFliprioOfMoveAndFlipAfterConstr()
  setFlipSynced()
  //part.shoow(part.gc.flipAfterSync,part.gc.flipAfterConstr)
  showTrucPourDebugger
 // setFlipCanceled()
  part.shoow(part.vor.muis) //triggers evaluation
  part.shoow(part.gc.alreadyThere)
  //refaire. stoquer dans vor, une map ou tableau (trouvable par reflection) mprimable des mouvement par priorité, resultant d'une reduction or.
/*  part.shoow(part.vor.mergedMoves("repulse").asInstanceOf[MoveC2].yes.empty)
  part.shoow(part.vor.mergedMoves("repulse").asInstanceOf[MoveC2].no.empty)
  part.shoow(part.mergedMoves("repulse").asInstanceOf[MoveC2].yes.empty)
  part.shoow(part.mergedMoves("repulse").asInstanceOf[MoveC2].no.empty)*/
//  part.shoow(part.vor.mergedMoves("containGcenter").asInstanceOf[MoveC2].yes.push)
  part.shoow(part.muis)
  part.vor.showMe
   part.vor.b.showMe
   part.vor.bf.showMe
  part.showMe
  part.bf.showMe
  part.b.showMe
  part.bve.showMe
  part.d.showMe;
  part.shoow( part.dgv.gap, part.dgv.sloplt, part.dgv.level, part.dgv.vortex) // necessary so as to use all parameters returned by slopeDeltashoow(vortex)
  part.shoowText(part.dgv.deltag,List())
  part.shoowText(part.dgv.muis, List())
 // part.shoow( part.dg.gap, part.dg.sloplt, part.dg.level, part.dg.vortex) // necessary so as to use all parameters returned by slopeDeltashoow(vortex)
 // part.shoowText(part.dg.deltag,List())
//  part.shoowText(part.dg.muis, List())
  //part.dg.showMe;part.dgv.showMe
 part.gc.showme

  //part.shoow(part.sf.isSummit)
 // part.shoowText( part.sf.density,List())
 part.shoow( part.vor.isForced)

  part.shoow(part.sf.stableSimple);  part.shoow(part.sf.stableSimple2)
  // part.shoow(part.sf.stable2)
    part.shoow(part.ri.muis)
  part.shoowText(part.ri.maxSignGradm2,List())
  part.shoowText(part.ri.minSignLt,List())
  part.shoowText(part.ri.incr,List())
  part.shoow(part.ri.signGradm2)
  part.shoow(part.ri.nearer)
  part.shoow(part.ri.existNearer)
  part.shoow(part.ri.gap)
  part.shoow(part.ri.gapV)
  part.staat(part.bve.meet, part.d.muis)
  part.staat(part.bve.meetV, part.d.muis)
 part.staat(part.muis, part.dgv.muis)
  part.staat(part.bve.meetE2, part.d.muis)
  part.shoow(part.bve.meetE2)
}

/** basic quasiparticle with blob and qpoint constraints */
abstract class Seed extends MovableAg[V]("global") with MovableAgV  with addBloobV with blobConstrain with addQpointFields with QpointConstrain
  with EmptyBag[sdn.MuStruct[_<: Locus,_<:Ring]]

/** moves as much as possible */
abstract class Flies2 extends Seed {
  /** exploring priority */  final val explore=introduceNewPriority()
  force(explore, "explore",'O', Force.total)
  //final val explore2=introduceNewPriority() // force(explore2, "toto",'P', Force.total)
}

/**adds distance, gabriel center,  distance to gabriel center, and then finally repulsive force*/
class Homogen() extends Flies2 with addDist with addGcenter with keepOutsideForce with addVor with addDistGcenterVor
{  /** seed should not overlap gCenters */
   val  avoidGc= CancelFlipIf(this,One(false), gc.detected  ) _
  addConstraint("avoidgc",'g',avoidGc)
}

class SpreadOnSummit extends Homogen with addRadius{
  val sf=new Attributs() { //sf==stableFields
    override val muis: ASTLg with carrySysInstr = SpreadOnSummit.this.muis
    override def showMe: Unit =  shoow(isSummit)
    val isSummit:BoolV=  ~exist(dgv.slopgt) & adjacentBall(isV)
    val density=addLt(countNeighbors( addSym(e(isSummit)).sym))
    val notDense= density < fromInt(3)
    val notDenseN=addSym(e(notDense))
    val stableSimple: ASTLt[V, B] =isV & inside(imply(bf.brdVeIn,dgv.sloplt))
    val stableSimple2=forallize(stableSimple) & isV
    val balance: Force = new Force() {
      import compiler.ASTLfun.fromBool
      override def actionV(ag: MovableAgV): MoveC = {
        val yes=MoveC1(false,false) //force is pure negative
        /** if stable2 , this will cancel movement of lower priority, */
        val no = MoveC1(stableSimple2, e(stableSimple2)& bf.brdVeIn) // negative  forces
        MoveC2(yes,no)
      }}
    val seizeSummit=new Force{
       override def actionV(ag:MovableAgV): MoveC= {
        val hasNearer: BoolV = Wrapper.exist(transfer( density.lt) & neighborsSym(e(ag.muis)))
        val hasFurther = Wrapper.exist(transfer( density.gt) & neighborsSym(e(ag.muis)))
        val oui=MoveC1( ag.muis & hasFurther & ~hasNearer & notDense, //on vide si y a des plus loin, pas de plus pres,
                                                       // et on n'est pas dense
          transfer(density.gt)) //on envahit des voisines plus dense OK
         //on va toujours remplir un vertice dont la densité est plus grande
         //pour cibler des particules tripleton,
         // on peut ou on peut ne pas autoriser  de vider si nombre de voisin est   3

         val non = MoveC1(ag.muis & ~hasFurther,  //on interdit de vider si y a pas de plus dense a coté
              transfer( density.lt)  & ag.bf.brdVeIn & notDenseN.sym ) //on interdit d'envahir des moins dense qui de plus ne sont pas dense
         //on ne vas pas non plus chercher a remplir un vertice sommet voisin de dentisté pluc petite, si celle ci est  <3
        MoveC2(oui, non)
      }
    }
  }
 // force(introduceNewPriority(),"seize",'z',sf.seizeSummit)//allows final convergence
  force(introduceNewPriority(),"repulse",'|',dgv.repulse)//go away from voronoi, but in fact from gcenter,
  // because it is allowed to overlap voronoi, which should thereafter withdraw.
  // This overlapping is the key for ensuring uniformization of the radius.
    force(introduceNewPriority(),"balance",'_',sf.balance)
}
/** obsolete */
class Convergent extends Homogen with addRadius // with Lead //pas besoin de leader pour le moment
{  val sf=new Attributs() { //sf==stableFields
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
  val stableSimple: ASTLt[V, B] =isV & inside(imply(bf.brdVeIn,dgv.sloplt))
  val stableSimple2=forallize(stableSimple) & isV
  val stable1=Convergent.this.muis.asInstanceOf[BoolV] & insideBall(isVsmoothed2)
  val stable2=forallize(stable1) & isV

  override def showMe: Unit = ()// shoow(isVplus) //shoow(stable1,stable2)
}
  val stabilize=introduceNewPriority()
  val balance: Force = new Force() {
    import compiler.ASTLfun.fromBool
    override def actionV(ag: MovableAgV): MoveC = {
      val yes=MoveC1(false,false) //force is pure negative
      /** if stable2 , this will cancel movement of lower priority, */
      val no = MoveC1(sf.stableSimple2, e(sf.stableSimple2)& bf.brdVeIn) // negative  forces
      MoveC2(yes,no)
    }
  }
  force(stabilize,"balance",'_',balance)
}



/**
 *
 * @param source quasiparticle
 * identifies a vertex within source, may be not usefull after all,
 * since it is arguably easier to compute stuf on the whole particle support*/
class Leader(source: Seed)extends MuStruct [V,B] {
  override def inputNeighbors: List[MuStruct[_ <: Locus, _ <: Ring]] = List(source)

  /** should be initialized globally,  exactly as source */
  val sourceNext = source.muis.next.asInstanceOf[BoolV]
  /** true if leader is no longer on the support of its source */
  val sourceOfLeaserHasMoved = source.isV & ~sourceNext & delayedL( muis.pred)
  /** extends sourceHasMoved to the adjacent Vertices */
  val sourceMovedWide = adjacentBall(sourceOfLeaserHasMoved)

  val neighborSourceNext: BoolVe = transfer(sym(transfer(e(sourceNext))) ) & e(delayedL( muis.pred))
  /** by hypothesis, neighborSourceNext is a segment, electedNeigbor is just the first element of this segment */
  val electedNeigbor1: BoolVf = cac(ASTBfun.delta, neighborSourceNext)
  val electedNeigbor2: BoolVe=anticlock(electedNeigbor1)
  val elected3: BoolV =  exist(transfer(sym(transfer(electedNeigbor2))))
  override val muis: LayerS[V, B] = new LayerS[V, B](1, "global") {
    /** we have to consider sym to finally retrieve the new leader. */
      override val next: AST[(V, B)] = delayedL(cond(sourceMovedWide,elected3,this.pred))(this.mym)
  }

  shoow(electedNeigbor2,electedNeigbor1,sourceMovedWide,neighborSourceNext,elected3)

  import compiler.ASTLfun.fromBool //pour avoir la conversion implicite de boolean vers boolVe
 /** annule le mouvement si stable, donc seul no est défini */
  val balance: Force = new Force() {
    override def actionV(ag: MovableAgV): MoveC = {
      val yes=MoveC1(false,false) //convergent is a pure negative move
      val no = MoveC1(muis, false) //ne va pas empty sur leader, juste pour tester
    MoveC2(yes,no)
    }
  }
}
trait Lead {
  self: Seed => //adds a leader to seed ,
  val myleader=new Leader(this);
  //show(d); les show doivent etre fait dans le main
}