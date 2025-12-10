package sdn


import compiler.AST.{Call2, Fundef2}
import compiler.ASTL.{sym, transfer}
import compiler.ASTLfun.{cond, e, v}
import compiler.{AST, ASTB, ASTBfun, ASTBt, ASTLfun, B, E, Locus, Ring, T, V, repr}
import compiler.SpatialType.{BoolE, BoolEv, BoolV, BoolVe}
import dataStruc.{BranchNamed, Named}
import progOfmacros.Comm.neighborsSym
import progOfmacros.Wrapper.{borderS, exist}
import progOfmacros.RedT.clock2
import sdn.Globals.root4naming
import sdn.Rand
import sdn.Util.addSym
/** adds the possibility of using a randomizer */
trait rando {
   val _rand = new Rand()  // Champ privé
  def rand: Rand = _rand          // Getter public pour le champ
}


/**
 * MoveC is a "centered move". It means that it is defined within the body support
 * it can  encodes a move on V-agents, but also Ve agents. For exemple, the effect of all is also
 * to move everywhere possible the agent..
 */
abstract class MoveC extends Named with BranchNamed {
  def restrict(cond:BoolV):MoveC
  val triggered:BoolV
  /** when computing push, we selected maxprio only among the yes, we do not consider the no */
  val triggeredYes:BoolV
  def move2flip(is:BoolV):BoolV
  /** should remain false */
  val bug:BoolV
}

/** @param empty where to withdraw at
 * @param push  where to extends towards
 * centered move with only yes
 */
case class MoveC1 (val empty: BoolV, val push: BoolVe) extends MoveC{
  def | (that: MoveC1) = MoveC1(empty|that.empty,push|that.push)
  /* adds a condition to the move*/
  def restrict(cond:BoolV)= MoveC1(empty & cond,push & e(cond))
  /* convert push to a boolV, true for vertice pointed by one of the push. NB there can be several distinct push
  * to the same single vertice, it is sufficient that there is one.  */
  val invade=exist(neighborsSym(push))
  /** true if the force has an effect*/
  val triggered=empty|invade
  override val triggeredYes: BoolV = triggered
  def move2flip(isV:BoolV):BoolV=cond(isV,empty,invade)
  val bug=empty & invade
}

/**
 * a centered move can take into account the fact that we can force no change
 * @param yes for setting flip
 * @param no for specifying absence of flip ,  using either no.push or no.Empty
 */
case class MoveC2(val yes:MoveC1,val no:MoveC1) extends MoveC{
  def restrict(cond:BoolV)=MoveC2(yes.restrict(cond),no.restrict(cond))
  override val triggered = yes.triggered | no.triggered
  val bug= yes.triggered & no.triggered | yes.bug | no.bug
  override val triggeredYes: BoolV = yes.triggered
  /** bugif for a given priority, one move specifies flip, and another move spécifies not flip */
  def move2flip(isV:BoolV):BoolV=yes.move2flip(isV) & ~ no.move2flip(isV)
}



import ASTLfun._
object MoveC{
  def empty(where:BoolV)=MoveC1(where,  e(root4naming.myFalse))
  def push(where:BoolVe)=MoveC1(root4naming.myFalse, where)
}
/** a force is exerted on an's  support and generates a movement */
abstract class Force extends  Named {
  /**
   * @return an agent-centered move   * when applied, the movement produced is already centered on the agents.
   */
  def actionV(ag:MovableAgV): MoveC= {assert(false,"force "+name+"undefined on Vagent");null}
  //def actionVe(ag:VeAg): MoveC={assert(false,"force "+name+"undefined on Veagent");null}
  /** when applied, the movement produced is already centered on the agents.*/
  def action (ag: MovableAg[_<:Locus]): MoveC=
    ag.locus match {
    case V() => actionV(ag.asInstanceOf[MovableAgV])
   // case T(V(),E()) => actionVe(ag.asInstanceOf[MovAgVe])
  }
  val myThis = this

}
object Force{
  /**
   *
   * @param force to be restricted
   * @param b
   * @return restricted force
   */
  def restrictF(f:Force,b:BoolV)=new Force {
    override def actionV(ag: MovableAgV): MoveC = {
      val mvc = f.actionV(ag).restrict(b)
      mvc
    }
  }
  import MoveC._
  /** produce maximum possible move, rely on priority to obtain random movement */
  val total:Force=new Force(){
    override def actionV(ag: MovableAgV): MoveC = MoveC1(ag.muis,ag.bf.brdVeIn)//extends and empties everywhere possible.
  }

  /** we designed a random move that does not break the quasipoint property,
   * eliminating the need for checking gate-expensive mutex
   * However, we must still check for directionnality using
   * sophisticated blob tests, because combination with other force may break directionality
  val qpointRand: Force = new Force() with rando  {
    override def actionV(is: BoolV): MoveC = {
      val isqp = is.asInstanceOf[BoolV with QPointify] //this force works only on quasiPoint
      val extend12dir: BoolVe = e(isqp.singleton) & r.randDir //isolated point move toward one of the 12 possible directions
      val extend2side: BoolVe = clock2(transfer(sym(v(isqp.doubleton) & r.randSide)))
      MoveC1(false,extend2side | extend12dir) //ici on fait un or sur des boolVe
    }
  }*/
}
