package sdn


import compiler.AST.{Call2, Fundef2}
import compiler.ASTL.{sym, transfer}
import compiler.ASTLfun.{cond, e, v}
import compiler.{AST, ASTB, ASTBfun, ASTBt, ASTLfun, B, E, Locus, Ring, T, V, repr}
import compiler.SpatialType.{BoolE, BoolEv, BoolV, BoolVe, UintVx}
import dataStruc.{BranchNamed, Named}
import progOfmacros.Comm.neighborsSym
import progOfmacros.Wrapper.{borderS, exist}
import progOfmacros.RedT.{clock2, shrink2min1to5}
import progOfmacros.Wrapper
import sdn.Globals.root4naming
import sdn.Rand
import sdn.Util.addSym

import scala.util.matching.Regex.Match
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
  def | (that: MoveC):MoveC
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
  def | (that: MoveC):MoveC = that match{
    case mc1:MoveC1=>MoveC1(empty|mc1.empty,push|mc1.push)
    case mc2:MoveC2=> mc2 | this
  }
  /* adds a condition to the move*/
  def restrict(cond:BoolV)= MoveC1(empty & cond,push & e(cond))
  /** rand is a small proba that we do empty if its  target, or we do not push if it is not */
  def inflechi(target:BoolV,rand:BoolV)=MoveC1(empty&(~target|rand),push& (e(rand)|neighborsSym(e(target))))
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
  def | (that: MoveC):MoveC = that match {
    case mc2:MoveC2=> MoveC2((yes|mc2.yes).asInstanceOf[MoveC1],(no|mc2.no).asInstanceOf[MoveC1] )
    case mc1:MoveC1=> MoveC2((yes|mc1).asInstanceOf[MoveC1],no )  //moveC1 are considered to be yesMove by default.
  }

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
  def | (that: Force)= {
    val myThis=this
    new Force {
      override def actionV(ag: MovableAgV): MoveC =  myThis.actionV(ag) | that.actionV(ag)
    }
  }
  /** wherever this!that, voids with a probability half*/
   def inflechi(target:BoolV):Force={
    val myThis=this
     val rnd= root4naming.addRandBit().asInstanceOf[BoolV]
     val rnd2= root4naming.addRandBit().asInstanceOf[BoolV]
     val rnd3= root4naming.addRandBit().asInstanceOf[BoolV]
     new Force {
      override def actionV(ag: MovableAgV): MoveC =
        myThis.actionV(ag).asInstanceOf[MoveC1].inflechi(rnd&rnd2&rnd3,target) //marche seulement si le move est un moveC1
    }
  }}



object Force{
  /**
   *
   * @param force to be restricted
   * @param b restricting condition, should be uniform where the force is exerted
   * @return restricted force
   */
  def restrictF(f:Force,b:BoolV)=new Force {
    override def actionV(ag: MovableAgV): MoveC =  f.actionV(ag).restrict(b)
  }

  import MoveC._
  /** produce maximum possible move, rely on random bits of priority to obtain random movement */
  val total:Force=new Force(){
    override def actionV(ag: MovableAgV): MoveC = MoveC1(ag.muis,ag.bf.brdVeIn)//extends and empties everywhere possible.
  }
  /**
   *
   * @param cible where we want our particle to be
   * @return creates a generic force that will let the particle exactly fills cible */
  def cibler(cible:BoolV):Force=new Force{
    val toCible=neighborsSym(e(cible))
    /** true if there is a target in the immediate neighborhood */
    val next2cible=exist(toCible)
    override def actionV(ag: MovableAgV): MoveC = {
      //we empty non-target and forbid moving towards non-target, only if target is reachable, so as to avoid blocking situation
      MoveC2(MoveC1(~cible & next2cible ,toCible & ag.bf.brdVeIn),MoveC1(cible, ~(toCible&e(next2cible))& ag.bf.brdVeIn ))
    }
  }

  /**
   *
   * @param stbl true if forces of lower priority should be voided
   * @return a force that blocks movement of lower priority, so as to obtain convergence.
   */
  def stabilize(stbl:BoolV): Force = new Force() {
      //import compiler.ASTLfun.fromBool
      override def actionV(ag: MovableAgV): MoveC = {
        val yes=MoveC1(root4naming.myFalse,e(root4naming.myFalse)) //force is pure negative
        /** if stable2 , this will cancel movement of lower priority, */
          val agblob=ag.asInstanceOf[addBlobVfields]
        val no = MoveC1(stbl, e(stbl)& ag.bf.brdVeIn) // negative  forces
        MoveC2(yes,no)
      }
  }







/*
  val emptyZgt=(isV&zgt.muis) & exist(neighborsSym(e(isV & ~(zgt.muis))))
  val emptyZlt= (isV& ~zlt.muis) & exist(neighborsSym(e(isV & (zlt.muis))))
  val pushZlt=shrink2min1to5(neighborsSym(e(zlt.muis)))
  val pushZgt=shrink2min1to5(neighborsSym(e(~zgt.muis)))*/

  /**
   *
   * @param zoneGt signal comming from nearest Gabriel centes, true if radius of adjacent voronoi is bigger,
   * @return force which repulse move the particles aways from this bigger voronoi,
   */
  def repulsePropagate(zoneGt:BoolV):Force = new Force{
    override def actionV(ag: MovableAgV): MoveC = {
      //emptying applies on tripleton or doubleton, on vertice inside zoneGt having neighbor vertices outside
        MoveC1( ag.muis & zoneGt & exist(neighborsSym(e(ag.muis & ~ zoneGt))),
      //we fill by looking "most away as possible from zoneGt
      shrink2min1to5(neighborsSym(e(~zoneGt))))
    }
  }
  /**
   *
   * @param zoneLt signal comming from nearest Gabriel centes, true if radius of adjacent voronoi is smaller,
   * @return force which  move the particles nearer to this smaller voronoi,
   */
  def attractPropagate(zoneLt:BoolV):Force = new Force{
    override def actionV(ag: MovableAgV): MoveC = {
      //emptying applies on tripleton or doubleton, on vertice outside zoneLt having neighbor vertices inside
      MoveC1( ag.muis & ~ zoneLt & exist(neighborsSym(e(ag.muis &  zoneLt))),
        //we fill by looking "most towards as possible to zoneLt
        shrink2min1to5(neighborsSym(e(zoneLt))))
    }
  }

/** use density to favors occupancy of center of voronoi */
  def seizeSummitDensity(density:UintVx)=new Force{
    override def actionV(ag:MovableAgV): MoveC= {
      val hasNearer: BoolV = exist(transfer( density.lt) & neighborsSym(e(ag.muis)))
      val hasFurther = Wrapper.exist(transfer( density.gt) & neighborsSym(e(ag.muis)))
      val notDense = density < fromInt(3)
      val notDenseN = addSym(e(notDense))
      val oui=MoveC1( ag.muis & hasFurther & ~hasNearer & notDense, //on vide si y a des plus loin, pas de plus pres,
        // et si on n'est pas dense
        transfer(density.gt)& ag.bf.brdVeIn) //on envahit des voisines plus dense OK
      //on va toujours remplir un vertice dont la densité est plus grande
      //pour cibler des particules tripleton,
      // on peut ou on peut ne pas autoriser  de vider si nombre de voisin est   3

      val non = MoveC1(ag.muis & ~hasFurther,  //on interdit de vider si y a pas de plus dense a coté
        transfer( density.lt)  & ag.bf.brdVeIn & notDenseN.sym ) //on interdit d'envahir des moins dense qui de plus ne sont pas dense
      //on ne vas pas non plus chercher a remplir un vertice sommet voisin de dentisté pluc petite, si celle ci est  <3
      MoveC2(oui, non)
    }
  }


  /** we designed a random move that does not break the quasipoint property,
   * eliminating the need for checking gate-expensive mutex
   * However, we must still check for directionnality using
   * sophisticated blob tests, because combination with other force may break directionality
   * therefore, it is not usefull, finally
  val qpointRand: Force = new Force() with rando  {
    override def actionV(is: BoolV): MoveC = {
      val isqp = is.asInstanceOf[BoolV with QPointify] //this force works only on quasiPoint
      val extend12dir: BoolVe = e(isqp.singleton) & r.randDir //isolated point move toward one of the 12 possible directions
      val extend2side: BoolVe = clock2(transfer(sym(v(isqp.doubleton) & r.randSide)))
      MoveC1(false,extend2side | extend12dir) //ici on fait un or sur des boolVe
    }
  }*/
}
