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
class InnerRadius ( val source:MuStruct [V,B], val d:Dist,val dgv:Dist) extends MuStruct [V,SI]{
  override def inputNeighbors: List[MuStruct[_ <: Locus, _ <: Ring]] = List(source,d,dgv)
  val nearer=d.sloplt |  neighborsSym(e(source.muis))
  val existNearer=exist(nearer)
  var gapV:BoolV=null
  override val muis: LayerS[V, SI] = new LayerS[V, SI](MuDistGcenterVor.nbit, "0") //we first put 5 bits so as to obtain continuity but 3 bits suffice at the end
  { val zero:SintV=fromInt(0)
    val diffRdgv= (dgv.muis + (-2)) - pred
    /** si gapV devient vrai ca merde */
    gapV=eq0(diffRdgv + 4)|eq0(diffRdgv + 3)
    val sgndiffRdgv=sign(diffRdgv)
    //on met zero si il n'existe pas encore de nearer. sauf que nearer considére aussi les voisin particule
    // override val next: AST[(V, SI)] = delayedL(cond(source.muis, this.pred + sgndiffRdgv, cond(/*d.*/existNearer,this.pred + incr, zero) ))
    val incr2=delayedL(cond(source.muis,sgndiffRdgv, incr))
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

  /** 1 is neutral for min*/
  val sgnLt:IntVe= cond(/*d.sloplt*/nearer,sign(transfer(grad6)),extend(2,fromInt(1))) // on regarde les voisins plus proche de particule
  val sgnMinLt: IntV = reduce(minSignRedop, sgnLt) //we need to add 2, using one more bit, in order to add modulo 16 and not 8
  /** -1 is neutral for max */
  val sgngradm2=sign(extend(7, transfer(grad6)) + (-2) )//on regarde tous  les voisin qui sont a un delta au moins de 2 voir 3
  /** sign pulled up by neighbor having high radius.  */
  val sgnMaxVor: IntV = reduce(maxSignRedop, sgngradm2) //on regarde tous  les voisin qui sont a un delta au moins de 2 voir 3
  /** pulls radius on voronoi towards radius of dominant voronoi neighbor (dominant= the one with biggest radius) */

  //val sgngradm2Gt:IntVe= cond(d.slopgt,sgngradm2,fromInt(-1)) //todo 7 ca a l'air vachement trop grand
  // val sgnMaxGt=reduce(maxSignRedop, sgngradm2Gt)
  //val sgnMax=cond(d.existFurther,sgnMaxGt,sgnMaxVor)

  // val maxltgt=binop(maxSign,sgnMax,sgnMinLt)
  val maxltgt=binop(maxSign,sgnMaxVor,sgnMinLt)
  //val incr=extend(4,maxltgt)  //on  ajoute un signe sur deux bit, a un int sur 3 bits.
  val incr=maxltgt //on  ajoute un signe sur deux bit, a un int sur 3 bits.
  // val incr=maxltgt  //on  ajoute un signe sur deux bit, a un int sur 3 bits.
  /** support of agent, implemented as a layer. we also use it to store a list  of system instructions */
}
/** adds  inner Radius to particles */
trait addRadius {
  self: MovableAgV with  addDist with addDistGcenterVor=> //adds a distance to a LayerV , also limit its movement so as to avoid vortices
  val ri = new InnerRadius(self,self.d,self.dgv);
  //show(d); les show doivent etre fait dans le main
}