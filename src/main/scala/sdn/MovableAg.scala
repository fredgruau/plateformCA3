package sdn

import compiler.AST.{Layer, delayed, pL}
import compiler.ASTB.True
import compiler.ASTBfun.{addRedop, derivative, orRedop, redop, unaryToBinary2}
import compiler.ASTLfun.{cond, e, inputBool, ltSI, neighbors, neq, orR, orScanRight, reduce, uI2SIL, v}
import compiler.ASTL.{delayedL, send, transfer, unop}
import compiler.SpatialType.{BoolE, BoolEv, BoolV, BoolVe, IntE, IntEv, IntV, IntVe, UintV, UintVx}
import compiler.{AST, ASTL, ASTLfun, ASTLt, B, E, Locus, Ring, SI, T, UI, V, repr}
import compiler.repr.nomV
import dataStruc.BranchNamed
import dataStruc.DagNode.EmptyBag
import progOfmacros.Comm.neighborsSym
import progOfmacros.Wrapper.{borderS, exist, existS, unary2Bin, xorBin}
import sdn.Force.cibler
import sdn.Globals.root4naming
import sdn.{Compar, ForceAg, carrySysInstr}
import sdn.Util.{addLt, addSym, randUintV}
import sdntool.addDist

import scala.collection.immutable.HashMap
/** list the  movable-agent's methods which needs a processing dependant  on the locus L in V,E,Ve, F...
 * will be implemented by Vagent or VeAgent*/
trait vef[L<:Locus]{
  /**  computes the new agent'support from flip.
   * for V agent it is a simple xor,
   * for Ve agents there will be a non trivial computation */
  def flip2next: AST[(L, B)]
}

/** contains fields of  Vagent.  not used right now,
 * since we store all of them in blob fields or qpoint fields */
trait UtilVagent extends BranchNamed{
  self:MovableAgV=>
}


/** defines the methods in vef[V], adds UtilVagent, which mixin some further usefull field, rando is used to get a random bit, for vote*/
trait MovableAgV extends MovableAg[V] with vef[V] with UtilVagent with sdntool.addBlobVfields with rando {  //probably another rand
  self:MovableAg[V] =>
  override val isV: BoolV = muis
  /** well known voting rule we put "lazy" to avoir waising a rand, if there isn't a vote*/
  lazy val vote= {val rand= root4naming.addRandBit().asInstanceOf[BoolV]
    cibler(bf.dense | bf.density3 & rand)}
  override def flip2next=  {
    val f=flipAfterSync;  f ^ muis
  }
}

/**  code  common to Movable agents which stores a support
 * and can directly apply the move on this support in order to modify it */
abstract  class MovableAg[L <: Locus](init:String)(implicit m: repr[L]) extends  ForceAg[L] with vef[L]
  { override def allTriggered:UintV={
    moves.map(_.values.map(_.triggered).reduce(_ | _).asInstanceOf[UintV]).toList.reduce(_ :: _)
  }
  override def allTriggeredYes:UintV={
    moves.map(_.values.map(_.triggeredYes).reduce(_ | _).asInstanceOf[UintV]).toList.reduce(_ :: _)
  }
  /** for each priority, we look if flip is produced or not */
  override def  allFlip: UintV ={
    moves.map(_.values.map(_.move2flip(isV)).reduce(_ | _).asInstanceOf[UintV]).toList.reduce(_ :: _)
  }
    override def  allBug: UintV ={
      moves.map(_.values.map(_.bug).reduce(_ | _).asInstanceOf[UintV]).toList.reduce(_ :: _)
    }

  /** a random priority is needed to help finalize tournament, in case of equality c'est plus sérieux avec deux bits de random priority*/
  override val prioRand=  randUintV(nbitPrioRand).asInstanceOf[UintV]   //sans "asInstance" il gueule non compatibilité de override entre addLt e UintVx

  /** Movable Agent's support. It is memorized in a layer a movable agent is a mustruct, so it is  called muis. */
  override val muis=new Layer[(L, B)](1, init) with ASTLt[L,B]  with Stratify [L,B] with carrySysInstr   {override val  next: AST[(L, B)] = delayedL(flip2next.asInstanceOf[ASTLt[L,B]])   }

  }


