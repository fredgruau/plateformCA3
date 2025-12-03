package sdntool


import compiler.AST._
import compiler.SpatialType.{BoolVe, _}
import compiler.ASTBfun.{addRedop, andRedop, isneg, maxSign, maxSignRedop, minSignRedop, orRedop, p, redop, xorRedop}
import compiler.ASTL._
import compiler.ASTLfun._
import compiler.ASTLt._
import compiler.Circuit.hexagon
import compiler._
import compiler.SpatialType._
import dataStruc.{BranchNamed, Named}
import progOfStaticAgent.{Homogeneize, Leader}
import progOfmacros.Comm.neighborsSym
import progOfmacros.Grad.{deltaCall, deltaCallProp, siFieldOperator, siFieldOperatorProp, slopeDeltaDistDef}
import progOfmacros.{Grad, Wrapper}
import progOfmacros.Wrapper.{borderS, exist, existS, inside, neqUI2L}
import progOfmacros.RedT.cacEndomorph
import sdn.{BlobVe, CancelFlipIf, Force, LayerS, MovableAgV, MoveC, MoveC1, MoveC2, MuStruct, One, Stratify, addGcenter, addVor, carrySysInstr}
import sdn.Util.{addLt, addLtSI}

/**
 *regroup all what is common when setting up a signed integer field
 * @param n number of bits
 */
abstract class SiField(n:Int,  source: MuStruct[V, B],op:siFieldOperator) extends MuStruct [V,SI] {
  val targetOnSource: ASTLt[V, SI]
  /** we introduce an inner class in order to be able to override its next field which is necessary for radius */
   override val muis: LayerS[V, SI] = new LayerS[V, SI](n,"0") { // new SIlayer()
     override val next: AST[(V, SI)] =delayedL( this.pred +cond(source.muis.munext, sign(targetOnSource) ,delta))(this.mym)
   }
   /** slopelt retrieves the sign of the slope, which is allways needed, delta is 0, +1 ot -1  we update with small delta:either increment or decrement */
   val (sloplt: BoolVe, delta, level, gap) = deltaCall(muis.pred,op)
  val slopgt = neighborsSym(sloplt);  val existNearer = exist(sloplt);  val existFurther = exist(slopgt);
  val opp = -(muis)  //todo opp can be retrieved from deltaCall
  /** spurious vortex occurs outside chip.borderF.df, so we have to and with chip.borderF.df in order to prevent false detection of vortex bug */
  val vortex: BoolF =   chip.borderF.df & andR(transfer(cacEndomorph(xorRedop[B]._1, sloplt)))
/** same story with gap*/   val gap2=gap & chip.borderE.df
  def showMe = { shoow(sloplt,level); shoowText(muis, List());
    // buugif( vortex) ;  buugif( gap2)
    shoow (vortex) ;  shoow( gap2)
  }
}


/**
 * define the repulse  forces.
 *
 */
trait addRepulse{
  self:SiField=>
  val repulse: Force = new Force() {
    override def actionV(ag: MovableAgV): MoveC = {
      val hasNearer: BoolV = Wrapper.exist(sloplt & neighborsSym(e(ag.muis)))
      val hasFurther = Wrapper.exist(slopgt & neighborsSym(e(ag.muis)))
      val oui = MoveC1( ag.muis & hasFurther & ~hasNearer,
        neighborsSym(sloplt) & ag.bf.brdVeIn) //extends towards increasing value of distances and empties everywhere possible.
      val non = MoveC1(ag.muis & hasNearer, sloplt & ag.bf.brdVeIn  ) //falseVe
      MoveC2(oui, non)
    }}}
trait addRepulseVor{
  self:SiField=>
  val repulseVor: Force = new Force() {
  override def actionV(ag: MovableAgV): MoveC = {
    /** true if a nearby vertice is filled, and nearer to the source */
    val hasNearer: BoolV = Wrapper.exist(sloplt & ag.bf.qqnEnFace)
    /** true if a nearby vertice is filled, and further from  the source */
    val hasFurther = Wrapper.exist(slopgt & ag.bf.qqnEnFace)
    /** we will empty if there is a further, and no nearer */
    val weWantItEmpty=hasFurther & ~hasNearer
    /** we empty if weWantItEmpty, and vertice was occupied
     *  we fill towards increasing value of distances, if it's empty */
    val oui = MoveC1(ag.muis & weWantItEmpty,
      neighborsSym(sloplt) & ag.bf.brdVeIn)
    /** negative moves takes place is weWantItEmpty, and vertice was NOT occupied
     * if it was occupied, we should first remove nearer if it has some nearer*/
    val non = MoveC1(cond(ag.muis,hasNearer,weWantItEmpty), e(fromBool(false))/*sloplt & ag.bf.brdVeIn*/  ) //falseVe
    MoveC2(oui, non)
  }}}
/**
 *
 * @param n number of bits
 *//*
abstract class Dist(val n:Int)extends MuStruct [V,SI] {
  /** 0, +1 ot -1  we update with small delta:either increment or decrement*/
  val incr: ASTLt[V, SI]
  override val muis: LayerS[V, SI] = new LayerS[V, SI](n, "0")
  { override val next: AST[(V, SI)] = delayedL(this.pred + incr)(this.mym)  }
  val (sloplt: BoolVe, deltag, level, gap) = Grad.slopDeltaDist(muis.pred)
  val slopgt= neighborsSym(sloplt);  val existNearer=exist(sloplt);  val existFurther=exist(slopgt)
  val opp = -(muis.pred)
  /** spurious vortex occurs outside chip.borderF.df, so we have to and with chip.borderF.df in order to prevent false detection of vortex bug */
  val vortex: BoolF = chip.borderF.df & andR(transfer(cacEndomorph(xorRedop[B]._1, sloplt)))
  def showMe={
    shoow( sloplt)
  //  shoow(gap,level, vortex)//was necessary so as to use all parameters returned by slopeDeltashoow(vortex) not necessary anymore
    shoow(existNearer,existFurther);
    //shoowText(deltag,List())
    shoowText(muis, List())
    val deefV = new ConstLayer[V, B](1, "def") //this is just a reminder
    buugif(vortex) //todo, mettre aussi un bug si y a un écart  sur la source plus grand K en valeur absolue, K reste a déterminer
    buugif(chip.borderE.df&gap)
  }

  /** we may have to replace muis by isV in order to obtain a force that can acts on BoolEv Agents, and not only BoolV agents */
  val repulse: Force = new Force() {
    override def actionV(ag: MovableAgV): MoveC = {
      val hasNearer: BoolV = Wrapper.exist(sloplt & neighborsSym(e(ag.muis)))
      val hasFurther = Wrapper.exist(slopgt & neighborsSym(e(ag.muis)))
      val oui = MoveC1( ag.muis & hasFurther & ~hasNearer,
        neighborsSym(sloplt) & ag.bf.brdVeIn) //extends towards increasing value of distances and empties everywhere possible.
      val non = MoveC1(ag.muis & hasNearer, sloplt & ag.bf.brdVeIn  ) //falseVe
      MoveC2(oui, non)
    }
  }
  /** repulseVor is distinct because we move something which is non quasipunctual */
  val repulseVor: Force = new Force() {
    override def actionV(ag: MovableAgV): MoveC = {
      /** true if a nearby vertice is filled, and nearer to the source */
      val hasNearer: BoolV = Wrapper.exist(sloplt & ag.bf.qqnEnFace)
      /** true if a nearby vertice is filled, and further from  the source */
      val hasFurther = Wrapper.exist(slopgt & ag.bf.qqnEnFace)
      /** we will empty if there is a further, and no nearer */
      val weWantItEmpty=hasFurther & ~hasNearer
      /** we empty if weWantItEmpty, and vertice was occupied
       *  we fill towards increasing value of distances, if it's empty */
      val oui = MoveC1(ag.muis & weWantItEmpty,
        neighborsSym(sloplt) & ag.bf.brdVeIn)
      /** negative moves takes place is weWantItEmpty, and vertice was NOT occupied
       * if it was occupied, we should first remove nearer if it has some nearer*/
      val non = MoveC1(cond(ag.muis,hasNearer,weWantItEmpty), e(fromBool(false))/*sloplt & ag.bf.brdVeIn*/  ) //falseVe
      MoveC2(oui, non)
    }
  }
}
*/

object MuDist{
  val nbitSize=4 //3 works also, we use 4 in order to compute statistics
}
/**
 * @param source
 * @param bitSize sometimes more than 3 bits are necessary
 *  * computes distance to source
 */
class MuDist(bitSize:Int, source: MuStruct[V, B])
  extends SiField(bitSize, source , slopeDeltaDistDef) {
  override def inputNeighbors = List(source)
  override val targetOnSource: ASTLt[V, SI] = opp
  source match{
    case ag: sdn.ForceAg[V]=> //adds a slow constraint to avoid vortex creation
      /** moving to forbidden would create a source in a negative distance
       * which would preevent to ecrease the distance level towards zero */
      val forbidden:BoolV= ASTLfun.isneg(muis.pred)
      val  slow=CancelFlipIf(ag,One(false),forbidden ) _// agents should not invade cells where distance is negative
      ag.addConstraint("slow",'w',slow)
    case _ =>
  }
 /* override def showMe={super.showMe; shoow(testLevel)}
  // val deefF=new ConstLayer[F, B](1, "def") //we sometimes need to restrict*/
}
/*

class MuDist(val source: MuStruct[V, B], val bitSize:Int) extends Dist(bitSize) {
      override def inputNeighbors: List[MuStruct[_ <: Locus, _ <: Ring]] = List(source)
      val incr = cond(delayedL(source.muis.munext), sign(opp), deltag)
      source match{
        case ag: sdn.ForceAg[V]=> //adds a slow constraint to avoid vortex creation
          /** moving to forbidden would create a source in a negative distance
           * that would hence not be able to correctly decrease its distance level */
          val forbidden:BoolV= ASTLfun.isneg(muis.pred)
          val  slow=CancelFlipIf(ag,One(false),forbidden ) _// agents should not invade cells where distance is negative
          ag.addConstraint("slow",'w',slow)
        case _ =>
      }
      /* override def showMe={super.showMe; shoow(testLevel)}
       // val deefF=new ConstLayer[F, B](1, "def") //we sometimes need to restrict*/
    }
*/
/*
    /** computes distance to gabriel centers added to the distance of that gabriel center to seeds i.e, distance to nearest neighbors */
class MuDistGcenter(val source:MovableAgV with addDist with addGcenter) extends Dist(3) {
  override def inputNeighbors = List(source.d)
  val incr: ASTLt[V, SI] = cond(delayedL(source.bve.meetE2), sign(opp/*+2*/), cond(delayedL(source.bve.meetV), sign(opp), deltag))
}*/



/** adds  distance to particles */
trait addDist {
  self: MuStruct[V, B] => //adds a distance to a LayerV , also limit its movement so as to avoid vortices
  val d = new MuDist(MuDist.nbitSize,self) with addRepulse with addRepulseVor {} ;
  //show(d); les show doivent etre fait dans le main
}

/** adds gabriel centers, uses blob computation on slopelt, works like magic */


/** adds distance to gcentern */
/*trait addDistGcenter {
  self: MovableAgV with addDist with addGcenter=>
  val dg = new MuDistGcenter(this)
  //show(d); les show doivent etre fait dans le main
}*/
object MuDistGcenterVor{
  val nbit=3
}
/** computes distance to gabriel centers also taking into account distance to voronoi, in order to avoid vibration
 * caused by the fact that gabriel centers are discontinuous*/
/*
class MuDistGcenterVor(val source:MovableAgV with addDist with addVor with addGcenter)
  extends Dist(MuDistGcenterVor.nbit) {
  override def inputNeighbors = List(source.vor,source.gc)
 // val incr: ASTLt[V, SI] = cond(delayedL(source.bve.meetV), sign(opp), cond(delayedL(source.bve.meetE2), sign(opp/*+2*/), deltag))
  val incr: ASTLt[V, SI] = cond(/*delayedL(source.bve.meetV) | delayedL(source.bve.meetE2) |*/source.vor.muis , sign(opp), deltag)
}
*/


/** computes distance to gabriel centers but also  to voronoi (which allways include gcenter),
 * in order to avoid vibration caused by the fact that gabriel centers are discontinuous*/
/*class MuDistGcenterVor(souource:MovableAgV with addDist with addVor with addGcenter)
 // extends MuDist2(MuDistGcenterVor.nbit, delayedL(source.bve.meetV) | delayedL(source.bve.meetE2) |source.vor.muis ) {
  extends MuDist(MuDistGcenterVor.nbit, souource.vor ) {
    override def inputNeighbors = List(souource.vor,souource.gc)
}*/


/** adds distance to gcentern corrected by voronoi*/
trait addDistVor {
  self: MovableAgV with addDist with addVor with addGcenter=>
  val dgv = new MuDist(MuDistGcenterVor.nbit,this.vor) with addRepulse {} //totoal
  //show(d); les show doivent etre fait dans le main
}



/** contains show(dist) otherwise, class Dist is not compiled at all, because not used from the root */
trait DistSimplerT {
  self: Layer[(V, B)] => //adds a distance to a LayerV todo, it should also limit its movement
  val dist = new DistSimpler(self);
 // show(dist); les show doivent etre fait dans le main

}

/** a simpler version of distance, which does not uses send */
class DistSimpler(val source: Layer[(V, B)]) extends Layer[(V, SI)](3, "0") with ASTLt[V, SI] {
  /*val level: BoolV = elem(2, this);*/
  val grad: IntVe = neighbors(this) - e(this)
  val lt: BoolVe = ltSI(grad)
  val eq: BoolE = ~reduce[E, V, B](orRedop[B], transfer(lt)) //its equal if it is neither lt nor gt
  val delta: IntV = reduce(minSignRedop, sign(extend(4, grad) + 2)) //we need to add 2, using one more bit, in order to add modulo 16 and not 8
  val next: ASTLt[V, SI] = this + cond(source.asInstanceOf[BoolV], sign(-this), delta) //faudrait en faire une macro qui prends delta, source et dist et renvoie distNext
  show(lt, eq)
}

