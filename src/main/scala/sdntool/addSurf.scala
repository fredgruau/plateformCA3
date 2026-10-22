package sdntool

import compiler.ASTBfun.{addRedop, redop}
import compiler.ASTL.{ASTLg, delayedL, sym, transfer}
import compiler.ASTLfun.{cond, e, neighbors, reduce, sign}
import compiler.SpatialType.{IntE, IntV, UintV, UintVe}
import compiler.{AST, ASTL, ASTLt, Locus, Ring, SI, UI, V}
import progOfmacros.Comm.neighborsSym
import progOfmacros.Compute.countNeighbors
import progOfmacros.Wrapper.exist
import sdn.{Attributs, LayerS, MovableAgV, MuStruct, carrySysInstr}

class Area(val d:MuDist) extends MuStruct [V,UI]  {
  /** support of agent, implemented as a layer. we also use it to store a list  of system instructions */
  val cardNearer=countNeighbors(d.sloplt)
  override val muis: ASTL.Strate[V, UI] with ASTLt[V, UI] with carrySysInstr  =  new LayerS[V, UI](8,"0") { // new SIlayer()

    val neig: UintVe=delayedL( transfer(sym(transfer(e(pred)))) ) //&  d.slopgt )
    val sum:UintV = reduce(addRedop[UI].asInstanceOf[redop[UI]],neig)
    override val next: AST[(V, UI)] = sum
  }
  override def inputNeighbors: List[MuStruct[_ <: Locus, _ <: Ring]] = List(d)
  def showMe(): Unit = {shoowText(cardNearer,List());shoowText(muis,List())}

}
trait addSurf {
  self: MovableAgV with  addDist with addDistVor=> //adds a distance to a LayerV , also limit its movement so as to avoid vortices
   val supermuis=muis
  val ar=new Area(d)


}
