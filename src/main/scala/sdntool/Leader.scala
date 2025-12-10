package progOfStaticAgent

import compiler.ASTL.{anticlock, delayedL, sym, transfer}
import compiler.ASTLfun.{cond, e}
import compiler.SpatialType.{BoolV, BoolVe, BoolVf}
import compiler.{AST, ASTBfun, B, Locus, Ring, V}
import progOfmacros.Comm.adjacentBall
import progOfmacros.RedT.cac
import progOfmacros.Wrapper.exist
import sdn.{Force, LayerS, MovableAgV, MoveC, MoveC1, MoveC2, MuStruct}

/**
 *
 * @param source quasiparticle
 * identifies a vertex within source, may be not usefull after all,
 * since it is arguably easier to compute stuf on the whole particle support*/
class Leader(source: Seed) extends MuStruct [V,B] {
  override def inputNeighbors = List(source)
  /** should be initialized globally,  exactly as source */
  val sourceNext = source.muis.next.asInstanceOf[BoolV]
  /** true if leader is no longer on the support of its source */
  val sourceOfLeaserHasMoved = source.isV & ~sourceNext & delayedL(muis.pred)
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

  //import compiler.ASTLfun.fromBool //pour avoir la conversion implicite de boolean vers boolVe
  /** annule le mouvement si stable, donc seul no est défini */
}


trait addLeader {
  self: Seed => //adds a leader to a seed ,
  val lead=new Leader(this);
  //show(d); les show doivent etre fait dans le main
}