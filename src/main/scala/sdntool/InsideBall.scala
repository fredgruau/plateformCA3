package sdntool

import compiler.ASTL.{anticlock, delayedL, sym, transfer}
import compiler.ASTLfun.{cond, e, ltSI}
import compiler.SpatialType.{BoolV, BoolVe, BoolVf}
import compiler.{AST, ASTBfun, B, Locus, Ring, V}
import progOfStaticAgent.{Homogen, Leader, Seed, SpreadOnSummit}
import progOfmacros.Comm.{adjacentBall, insideBall}
import progOfmacros.RedT.cac
import progOfmacros.Wrapper.exist
import sdn.{Force, LayerS, MovableAgV, MoveC, MoveC1, MoveC2, MuStruct, Vor}

/**
 *
 * @param d distance to particle
 * @param ri radius broadcasted from the particle
 */
class InsideBall(d:MuDist,ri:InnerRadius,v:Vor) extends MuStruct [V,B] {
  override def inputNeighbors = List(d, ri)

  val rmd = delayedL(ri.muis - d.muis)
  val inBall = ~ltSI(rmd)|d.source.muis
  /** true if next to previous inside ball */
  val adj = delayedL(adjacentBall(muis))
  /** under growth, inBall is valid only if adjacent to previous insideBall */
  val inBallgrow = inBall & adj
  /** under shrink, inBall is not  valid only if adjacent to previous insideBall */
  val ins = delayedL(insideBall(muis))
  val inBallshrink = ~inBall & ~ins & ~d.source.muis //& ~adjacentBall(inBallgrow)
  override val muis: LayerS[V, B] = new LayerS[V, B](1, "global") {
    /** we have to consider sym to finally retrieve the new leader. */
    override val next: BoolV = ((pred & ~inBallshrink) | inBallgrow)& ~v.muis


    //import compiler.ASTLfun.fromBool //pour avoir la conversion implicite de boolean vers boolVe
    /** annule le mouvement si stable, donc seul no est défini */
  }
  def showMe = {
    shoow(inBallgrow, inBallshrink, adj)
    shot(rmd)
  }
}

trait addInsideBall {
  self: SpreadOnSummit => //adds a leader to a seed ,
  val inbl=new InsideBall(d,ri,vor);
  //show(d); les show doivent etre fait dans le main
}