package sdntool

import compiler.ASTBfun.{addRedop, maxSign, maxSignRedop, minSignRedop, redop}
import compiler.ASTL.{binop, delayedL, send, transfer}
import compiler.ASTLfun.{cond, e, eq0, extend, fromInt, reduce, sign}
import compiler.SpatialType.{BoolE, BoolV, IntE, IntEv, IntV, IntVe, SintV}
import compiler.{AST, B, Locus, Ring, SI, V}
import progOfmacros.Comm.neighborsSym
import progOfmacros.Wrapper.exist
import sdn.{CancelFlipIf, LayerS, MovableAgV, MuStruct, One}

object InnerRadius{
  /** we use the same number of bits for radius, as for distance to gcenter and voronoi.  */
  val nbit=MuDistGcenterVor.nbit
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
class InnerRadius ( val source:MuStruct [V,B], val d:SiField,val dgv:Dist) extends MuStruct [V,SI]{
  override def inputNeighbors: List[MuStruct[_ <: Locus, _ <: Ring]] = List(source,d,dgv)
  /** nearer alone may sometimes be all 0 if we are next to particle support. In this spécific case, we have thus to include the particle support   */
  val nearer=d.sloplt |  neighborsSym(e(source.muis))
  val existNearer=exist(nearer)
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
    override val next: AST[(V, SI)] = cond(existNearer|source.muis, this.pred +  incr2, zero)
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
  val sgnLt:IntVe= cond(/*d.sloplt*/nearer,sign(transfer(grad6)),extend(2,fromInt(1))) // on regarde les voisins plus proche de particule
  val minSignLt: IntV = reduce(minSignRedop, sgnLt) //we need to add 2, using one more bit, in order to add modulo 16 and not 8
  /** sign which allows neighbors having high radius, to pull up the radius,
   * by considering delta in the window 3,2,1  causing  a positive (resp null, resp negative sign */
  val signGradm2=sign(extend(7, transfer(grad6)) + (-2) )//on regarde tous  les voisin qui sont a un delta au moins de 2 voir 3
  /** pulls radius of a voronoi cell towards radius of dominant voronoi neighbor (dominant= the one with biggest radius) */
  val maxSignGradm2: IntV = reduce(maxSignRedop, signGradm2) //on regarde tous  les voisin qui sont a un delta au moins de 2 voir 3


  val incr=binop(maxSign,maxSignGradm2,minSignLt)

}
/** adds  inner Radius to particles */
trait addRadius {
  self: MovableAgV with  addDist with addDistGcenterVor=> //adds a distance to a LayerV , also limit its movement so as to avoid vortices
  val ri = new InnerRadius(self,self.d,self.dgv);
  //show(d); les show doivent etre fait dans le main
}