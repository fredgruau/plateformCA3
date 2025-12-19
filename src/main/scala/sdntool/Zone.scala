package sdntool

import compiler.ASTL.{anticlock, delayedL, sym, transfer}
import compiler.ASTLfun.{cond, e, ltSI, v}
import compiler.ASTLt.ConstLayer
import compiler.SpatialType.{BoolV, BoolVe, BoolVf}
import compiler.{AST, ASTBfun, B, Locus, Ring, V}
import progOfStaticAgent.{Homogen, Leader, Seed, SpreadOnSummit}
import progOfmacros.Comm.{adjacentBall, insideBall, neighborsSym}
import progOfmacros.RedT.cac
import progOfmacros.Wrapper.{exist, existS, inside}
import sdn.{Force, LayerS, MovableAgV, MoveC, MoveC1, MoveC2, MuStruct, addGcenter}
/**
 *
 * @param d distance to particle
 * @param ri radius broadcasted from the particle
 *
 */
class Zone(p:SpreadOnSummit, val rislope:BoolVe) extends MuStruct [V,B] {
  override def inputNeighbors = List()
  val next2rect=neighborsSym(e(p.rect))
  /** true in the beginning, where voronoi is all over the place*/
  val immersedInThickVor=insideBall(p.vor.muis)
  /** consider first the case were propagation initiates next to meetE
   * we heavily constrain start otherwise it fires all over the place constantly */
  val startV:BoolV =delayedL( exist(p.bve.brdGv & rislope
    & ~next2rect //rules out the miror meetV which sends constant spurious initial propagate, due to symmetry
    & p.d.slopgt )// we consider a comparison with vertice on gcenterV, so distance hat to augment
    & ~p.rect //signals do not start on the mirror
    & ~immersedInThickVor //do not start  on zone where ri is initially zero;
  )
  /** consider now the case where  propagation initiates next to meetE */
  val startE:BoolV=delayedL( exist( p.bve.brdGe & rislope )
    & ~immersedInThickVor //probablement pas necessaire
    & p.vor.muis  & //should be on vornoi
    p.vor.b.meetE2 &  //we test voronoi edge, to rule out starting a propagation in the initial stage, when there are large voronoi patch
     ~p.rect //signals do not start on the mirror
  )




  override val muis: LayerS[V, B] = new LayerS[V, B](1, "false") {
    /** we have to consider sym to finally retrieve the new leader. */
    override val next: BoolV = (startE | startV | exist(p.d.slopgt & neighborsSym(e(pred))
      //avoid propagation to start in one voronoi cell and propagate to an adjacent voronoi cell,
      &       ~(transfer(v(p.vor.b.meeEfilled )))))   &  //by crossing a thick voronoi wall
    ~   (p.vor.b.meetV & p.vor.isV)// by crossing a thin voronoi wall, which is voronoi and nbcc2



    //import compiler.ASTLfun.fromBool //pour avoir la conversion implicite de boolean vers boolVe
    /** annule le mouvement si stable, donc seul no est défini */
  }
  val existOnPart=p.existize(muis)
  def showMe = {
    shoow(startV,startE,existOnPart)
    //shoow(zonegtInite,zonegtInitv,zoneltInitv,zoneeqInitv)
  }
}
/** makes it possible to test the miror zone, and thus avoid spurious mirror effect,
 *  such as the inner radius being temporarily not the same */
trait addRect{
  val rectLayer=new ConstLayer[V, B](1, "border")
  val rect:BoolV=rectLayer&rectLayer //manip qui a l'air débile, pour avoir un nom sous forme d'un path.
}
/** signal envoyé vers là ou le rayon est plus petit */
trait addZoneLt {
  self: SpreadOnSummit => //adds a leader to a seed ,
  val zlt=new Zone(this,ri.slopgt);
  //show(d); les show doivent etre fait dans le main
}

/** signal envoyé vers là ou le rayon est plus grand */
trait addZoneGt {
  self: SpreadOnSummit => //adds a leader to a seed ,
  val zgt=new Zone(this,ri.sloplt);
  //show(d); les show doivent etre fait dans le main
}