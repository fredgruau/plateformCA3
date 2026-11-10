package sdntool

import compiler.ASTBfun.{addRedop, redop}
import compiler.ASTL.{ASTLg, delayedL, sym, transfer}
import compiler.ASTLfun.{cond, e, halve, neighbors, reduce, sign}
import compiler.SpatialType.{IntE, IntV, UintV, UintVe}
import compiler.{AST, ASTL, ASTLfun, ASTLt, E, Locus, Ring, SI, T, UI, V}
import progOfmacros.Comm.neighborsSym
import progOfmacros.Compute.countNeighbors
import progOfmacros.Wrapper.exist
import sdn.{Attributs, LayerS, MovableAgV, MuStruct, carrySysInstr}
import sdntool.area.nbitArea
object area{
  val nbitArea=12
}

class Area(val d:MuDist,p:Qpoint) extends MuStruct [V,UI]  {
  /** support of agent, implemented as a layer. we also use it to store a list  of system instructions */
  val cardNearer=countNeighbors(d.sloplt)
  val singleOutput= ~(cardNearer > ASTLfun.fromInt(1)) //un seul voisin plus pres
  override val muis: ASTL.Strate[V, UI] with ASTLt[V, UI] with carrySysInstr  =  new LayerS[V, UI](nbitArea,"0") { // new SIlayer()
      override val next: UintV=delayedL(sum2)
  }
  /** a bug forces me to show not only muis, but also intermediate value inNeig2 */
  override def shoi={showMe}//d.source.shot(sum2,total)}
  /** if two neighbors are going to sum, we need to divide output */
  val out2=cond(singleOutput, muis, halve(muis))
  /** build the intVe  */
  val inNeig2: UintVe=cond( d.slopgt,  transfer(sym(transfer(e(out2)))) , ASTLfun.fromInt(0)   )
  /** make the sum */
  val sum2:UintV = reduce(addRedop[UI].asInstanceOf[redop[UI]],inNeig2)+ASTLfun.fromInt(2)

  val total=p.sumize(sum2)
  override def inputNeighbors: List[MuStruct[_ <: Locus, _ <: Ring]] = List(d)
  def showMe(): Unit = {shot(total,sum2,inNeig2
    //,cardNearer,out2
  );
    //shoow(singleOutput)
    }

}
trait addArea {//adds a computation of the area within voronoi, made available on the leader
  self: Qpoint with addDist=>
  val ar=new Area(d,this)
}
