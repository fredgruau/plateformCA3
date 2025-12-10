package sdntool

import compiler.ASTBfun.{addRedop, maxSign, maxSignRedop, minSignRedop, redop, xorRedop}
import compiler.ASTL.{binop, delayedL, send, transfer}
import compiler.ASTLfun.{andR, cond, e, eq0, extend, fromInt, ltSI, reduce, sign}
import compiler.SpatialType.{BoolE, BoolF, BoolV, BoolVe, IntE, IntEv, IntV, IntVe, SintV}
import compiler.{AST, ASTLfun, ASTLt, B, Locus, Ring, SI, V, chip}
import progOfStaticAgent.Homogeneize
import progOfmacros.Comm.{insideBall, neighborsSym}
import progOfmacros.Grad.{deltaCallProp, siFieldOperatorProp, slopeDeltaDistDef, slopeDeltaRadiusDef}
import progOfmacros.RedT.cacEndomorph
import progOfmacros.Wrapper.exist
import sdn.{CancelFlipIf, LayerS, MovableAgV, MuStruct, One}

/**
 *
 * @param n number of bits
 * @param source place where target on source should be targeted
 * @param srcProp points to source for propagation
 * @param op operator. this class is a wrapper for that operator siFieldOperatorProp,
 *  which computes all what's needed to compute for an integer layers */
abstract class SiFieldZeroInit2(n:Int,  source: MuStruct[V, B], srcProp:BoolVe , op:siFieldOperatorProp)extends MuStruct [V,SI] {
  val targetOnSource: ASTLt[V, SI]
  val zero:SintV=fromInt(0);
  override val muis: LayerS[V, SI] =  new LayerS[V, SI](n,"0") { // new SIlayer()
    override val next: AST[(V, SI)] =cond (exist(srcProp)|source.muis.munext,delayedL( this.pred +cond(source.muis.munext, sign(targetOnSource) ,delta))(this.mym),zero)
  }
  /** slopelt retrieves the sign of the slope, which is allways needed, delta is 0, +1 ot -1  we update with small delta:either increment or decrement */
  val (sloplt: BoolVe, delta, level, gap) = deltaCallProp(muis.pred,srcProp,op)
  val slopgt = neighborsSym(sloplt);  val existNearer = exist(sloplt);  val existFurther = exist(slopgt);
  val opp = -(muis)  //todo opp can be retrieved from deltaCallProp, it spared computation and factorize code
  /** spurious vortex occurs outside chip.borderF.df, so we have to and with chip.borderF.df in order to prevent false detection of vortex bug */
  val vortex: BoolF =   chip.borderF.df & andR(transfer(cacEndomorph(xorRedop[B]._1, sloplt)))
  /** same story with gap*/   val gap2=gap & chip.borderE.df
  def showMe = { shoow(sloplt,level);//shoowText(muis, List());
    //buugif( vortex) ;  buugif( gap2)
     shoow (vortex) ;  shoow( gap2)
  }
}
class InnerRadius(source: MuStruct[V, B], val d:MuDist, val dgv:MuDist)
  extends SiFieldZeroInit2(Homogeneize.nbitRi,
    source ,d.sloplt|neighborsSym(e(source.muis)),
    slopeDeltaRadiusDef  ) {
  /** pour propager radius, on regarde les voisins plus proche de particule si y en pas
   * (a cause d'un vidage et remplisage simultané ) on regarde les vertices voising dans le support d'une particule. */
  var forbidden: BoolV = null
  override def inputNeighbors: List[MuStruct[_ <: Locus, _ <: Ring]] = List(source)
  override val targetOnSource: ASTLt[V, SI] = (dgv.muis + (-2)) - muis
  source match{
    case ag: sdn.ForceAg[V]=> //adds a slow constraint to avoid vortex creation
      val fucked=eq0(targetOnSource + 4)
      /** neither can it be three, because dgv can change simultaneously with rin */
      val couldBeFucked=eq0(targetOnSource + 3)
      /** moving to forbidden would create a source in a negative distance
       * that would hence not be able to correctly decrease its distance level */
       forbidden= fucked | couldBeFucked
      val  slow=CancelFlipIf(ag,One(false),forbidden ) _// agents should not invade cells where distance is negative
      ag.addConstraint("slov",'v',slow)
    case _ =>
  }

  override def showMe: Unit = {super.showMe;  }
}


/**
 *
 *
 *
 * @param source particle where distance is sampled to compute radius, which is thereafter braodcasted.
 * @param d distance to particle
 * @param dgv distance to voronoi and gcenter
 *   radius is defined as the min value of dgv, taken on the particle support
 *   we could but we actually do not take the time to compute the min, we consider only the min, as seen from neighbors.
 *  the class computes an additional layer which broadcaste the radius throughout the voronoi cell.
 */
/*
class InnerRadius ( val source:MuStruct [V,B], val d:MuDist2,val dgv:MuDist2) extends MuStruct [V,SI]{
  override def inputNeighbors: List[MuStruct[_ <: Locus, _ <: Ring]] = List(source,d,dgv)
  /** nearer alone may sometimes be all 0 if we are next to particle support. In this spécific case, we have thus to include the particle support   */
  val sourcePropag=d.sloplt |  neighborsSym(e(source.muis))
  val existSourcePropag=exist(sourcePropag)
  var gapV:BoolV=null
  /** the layer itself */
  override val muis: LayerS[V, SI] = new LayerS[V, SI](MuDistGcenterVor.nbit, "0") //we first put 5 bits so as to obtain continuity but 3 bits suffice at the end
  { /** near the source, rin will follow distance to voronoi, so we have to check the difference */
    val diffRdgv= (dgv.muis + (-2)) - pred
    /** that difference cannot be 4, otherwise comparison is not possible */
    val fucked=eq0(diffRdgv + 4)
    /** neither can it be three, because dgv can change simultaneously with rin */
    val couldBeFucked=eq0(diffRdgv + 3)
    gapV=fucked | couldBeFucked
    /** used to update rin when on particle support */
    val sgndiffRdgv=sign(diffRdgv)
    /** as for mudit, setting radius to dgv on source's support is done incrementally, by adding the sign of the difference */
     val incr2=delayedL(cond(source.muis,sgndiffRdgv, incr))
    /** Radius is initialized to zero, at the very start, when there is no nearer */
    val zero:SintV=fromInt(0)
    /** instead of adding incr which takes care of the case far */
    override val next: AST[(V, SI)] = cond(existSourcePropag|source.muis, this.pred +  incr2, zero)
  }
  source match{
    case ag: sdn.ForceAg[V]=> //adds a slow constraint to avoid vortex creation
      /** moving to forbidden would cause rin to decrease instead of increasing */
      val forbidden:BoolV= gapV
      val  slow=CancelFlipIf(ag,One(false),forbidden ) _// agents should not invade cells where distance is negative
      ag.addConstraint("slov",'v',slow)
    case _ =>
  }

  /** 0, +1 ot -1  we update with small delta:either increment or decrement*/
  val rri = muis
  val rriopp = -rri
  val se: IntVe = send(List(rri, rri, rri, rriopp, rriopp, rriopp)) //we  apply an opp on distances comming from the center.
  val grad3: IntE = reduce(addRedop[SI].asInstanceOf[redop[SI]], transfer(se)) //the trick here is to do the expensive operation (add) only on the three edges locus, instead of the 6 Ve transfer
  val gap: BoolE = eq0(grad3 + 4) //  gap is true iff the two neighbors cannot be compared
  val grad6: IntEv = send(List(-grad3, grad3))

  /** we do the min only on nearer,  1 is neutral for min*/
  val sgnLt:IntVe= cond(/*d.sloplt*/sourcePropag,sign(transfer(grad6)),extend(2,fromInt(1))) // on regarde les voisins plus proche de particule
  val minSignLt: IntV = reduce(minSignRedop, sgnLt) //we need to add 2, using one more bit, in order to add modulo 16 and not 8
  /** sign which allows neighbors having high radius, to pull up the radius,
   * by considering delta in the window 3,2,1  causing  a positive (resp null, resp negative sign */
  val signGradm2=sign(extend(7, transfer(grad6)) + (-2) )//on regarde tous  les voisin qui sont a un delta au moins de 2 voir 3
  /** pulls radius of a voronoi cell towards radius of dominant voronoi neighbor (dominant= the one with biggest radius) */
  val maxSignGradm2: IntV = reduce(maxSignRedop, signGradm2) //on regarde tous  les voisin qui sont a un delta au moins de 2 voir 3


  val incr=binop(maxSign,maxSignGradm2,minSignLt)

}
/** adds  inner Radius to particles */
*/


trait addRadius {
  self: MovableAgV with  addDist with addDistVor=> //adds a distance to a LayerV , also limit its movement so as to avoid vortices
  val ri = new InnerRadius(self,self.d,self.dgv.asInstanceOf[MuDist]);
  //show(d); les show doivent etre fait dans le main
}