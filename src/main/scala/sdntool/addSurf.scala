package sdntool

import compiler.ASTBfun.{addRedop, redop}
import compiler.ASTL.{ASTLg, delayedL, sym, transfer}
import compiler.ASTLfun.{cond, e, halve, neighbors, reduce, sign}
import compiler.SpatialType.{IntE, IntV, UintV, UintVe}
import compiler.{AST, ASTL, ASTLfun, ASTLt, Locus, Ring, SI, UI, V}
import progOfStaticAgent.Seed
import progOfmacros.Comm.neighborsSym
import progOfmacros.Compute.countNeighbors
import progOfmacros.Wrapper.exist
import sdn.{Attributs, LayerS, MovableAgV, MuStruct, QpointConstrain, carrySysInstr}
import sdntool.area.nbitArea
object area{
  val nbitArea=12
}

class Area(val d:MuDist,p:Seed) extends MuStruct [V,UI]  {
  /** support of agent, implemented as a layer. we also use it to store a list  of system instructions */
  val cardNearer=countNeighbors(d.sloplt)
  val singleOutput= ~(cardNearer > ASTLfun.fromInt(1)) //un seul voisin plus pres
  override val muis: ASTL.Strate[V, UI] with ASTLt[V, UI] with carrySysInstr  =  new LayerS[V, UI](nbitArea,"0") { // new SIlayer()
      override val next: UintV=delayedL(sum2)
  }
  val out2=cond(singleOutput, muis, halve(muis))
  val inNeig2: UintVe=cond( d.slopgt,  transfer(sym(transfer(e(out2)))) , ASTLfun.fromInt(0)   )  //
  val sum2:UintV = reduce(addRedop[UI].asInstanceOf[redop[UI]],inNeig2)+ASTLfun.fromInt(2)

    val zeroifiedFeature:UintV=cond(p.muis,sum2,ASTLfun.fromInt(0))
    val zeroifiedFeatureNeig= transfer(sym(transfer(e(zeroifiedFeature))))
    val suuuum:UintV=reduce(addRedop[UI].asInstanceOf[redop[UI]],zeroifiedFeatureNeig) //y en a 6 bit, faut donc ajouter des bits!
  val total=p.sumize(sum2)


  override def inputNeighbors: List[MuStruct[_ <: Locus, _ <: Ring]] = List(d)
  def showMe(): Unit = {shot(cardNearer,out2,inNeig2,sum2,total);shoow(singleOutput)}

}
trait addSurf {//adds a computation of the area within voronoi, made available on the leader
  self: Seed with addDist=>
  val ar=new Area(d,this)


}
