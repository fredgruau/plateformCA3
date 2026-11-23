package sdntool

import compiler.ASTL.{ASTLg, transfer}
import compiler.ASTLfun.{e, f, neq}
import compiler.SpatialType.{BoolE, BoolF, BoolV, BoolVe}
import compiler.{ASTLfun, ASTLt, B, E, F, V}
import progOfStaticAgent.Homogen
import progOfmacros.Comm.{adjacentRing, apexE, apexV, neighborsSym}
import progOfmacros.Compute
import progOfmacros.Wrapper.{border, borderS, exist, existS, insideS}
import sdn.Force.{cibler, ciblerFaible}
import sdn.{Attributs, Force, MovableAgV, carrySysInstr}

trait addSummit{
  self: MovableAgV  with addDistVor =>
  val thiiismuis=muis;
  val sum=new Attributs {
    override val muis: ASTLg with carrySysInstr = thiiismuis
    val particuleAuVoisinage: BoolVe =neighborsSym(e(isV)) //y a une particule au voisinage
    val notReallySummit=exist(dgv.slopgt) //permet de ne pas générer de tripleton pas au sommet.
    val particuleAuVoisinageRealSummit: BoolVe =neighborsSym(e(isV & ~notReallySummit)) //y a une particule au voisinage
    val particuleAuVoisinageNotRealSummit: BoolVe =neighborsSym(e(isV & notReallySummit)) //y a une particule au voisinage
    //on peut etre sommet tout en ayant un dgv slopt, car proche de la particule
    val maybeweakSummit= exist (~dgv.slopgt & particuleAuVoisinageNotRealSummit)
    val isSummit1: BoolV =  isV |
      (  ~exist(dgv.slopgt & particuleAuVoisinage)  & //y a pas de particule au voisinage, plus loin
        exist (~dgv.slopgt & particuleAuVoisinageRealSummit) )//y a une particule au voisinage a la meme distance ou plus pres
    /** etends la detection des sommet un vertex plus loin, y a un summit1 au voisinage a la meme distance ou plus pres */
    val weakSummit=maybeweakSummit & ~ notReallySummit & isSummit1
    val isSummit2=isSummit1 |  exist (~dgv.slopgt & neighborsSym(e(isSummit1)) )
    override def showMe: Unit = {shoow(isSummit1,isSummit2)
      // shoow(particuleAuVoisinageRealSummit,notReallySummit,weakSummit)
    }
  }


}
/**
 * Calcule une zone remarquable inclue dans summit, de 1,2, ou 3 vertex, appelée centre, qu'on pense que c'est la zone
 * a envahir par la qseed, pour se trouver impeccablement au centre du voronoi, dans le cas de cellule de Voronoi pas trop allongée
 * fait des calculs assez compliqué pour occuper le sommet le mieux possible par rapport
 * a sa forme spécifique , ces calculs résultent d'une étude à la main */
trait addBlobSummitAndMore {
  self: Qpoint with addSummit with addBlobSummitAndMore   => //on utilise prop.tripletonstreched
  val muissssSelf = this.muis
  /** computes blob fields of summit2 itself */
  val bfs = new BloobVFields(muis, ~(~sum.isSummit2))
  /** computes many field about the summit's shape, whether it is a perfect doubleton or singleton, wether it is a face splitting the summit in three, wether it is a tunnel*/
  val bsmAtt =new Attributs {
    override val muis = muissssSelf
    val meetiV = (bfs.bv.meetV | bfs.bv.nbcc0) & bfs.couldBeOtherThanMuis
    /** true for meeting edges which are next to a particules, and therefore likely to participate to the center */
    val meetiEselected = bfs.bv.meetEfilled & existS[V, E](muis)
    val meetiE: BoolV = existS[E, V](meetiEselected) & bfs.couldBeOtherThanMuis
    val meetiEV = meetiE | meetiV
    /** faces splitting the summit in three */
    val nbcc3F: BoolF= insideS[E, F](bfs.bv.meetEfilled)
    /** summits part of a face splitting the summit in three */
    val nbcc3: BoolV = existS[F, V](nbcc3F)
    /** true if there are two competing splitting-in-3 face */
    val loosangeIncluded: BoolE = insideS[F, E](nbcc3F)
    /** if there is a rhombus, then we compute the apex so as to be able to remove them
     * in order to orchestrate a switch from one split3 tripleton, to the other */
    val losangeApexes: BoolV = exist[F, V](apexV(f(loosangeIncluded)))

    /** calcul des info pour la force qui pousse dans le "coude" true at the border betwenn thickness 2, and thickness one*/

    val finDeDepassement:BoolE=border(apexE(f(bfs.concaveconvex)))&bfs.insideE & bf.insideE & bfs.insideRhombusE
    /** apexes which should change in order to act the depassement */
    val depasseZone:BoolV=exist(apexV(f(finDeDepassement)))
    val depassOui=depasseZone&bfs.concaveconvex
    val depassNon=depasseZone& ~bfs.concaveconvex

    val finDeDepassement3:BoolE=border(apexE(f(bfs.strongConcave)))&bfs.insideE & bf.insideE & bfs.insideRhombusE & loosangeIncluded
    /** apexes which should change in order to act the depassement */
    val depasseZone3:BoolV=exist(apexV(f(finDeDepassement3)))
    val depassOui3=depasseZone3&bfs.strongConcave
    val depassNon3=depasseZone3& ~bfs.strongConcave

    /** faces with three vertice within the  summit */
    val insideFace: BoolF = insideS[V, F](bfs.couldBeOtherThanMuis)
    /** number of neighbor summits */
    //val density: UintVx = bfs.density//addLt(countNeighbors(addSym(e(bfi.otherThanMuis)).sym))
    /** summits having a single neighbor */
    val oneNeighbor = bfs.couldBeOtherThanMuis & (~(bfs.density > ASTLfun.fromInt(1)) & neq(bfs.density))
    /** true if the summits form a doubleton,  two connected vertice have a single neighbor */
    val isDoubleton = existS[E, V](insideS[V, E](oneNeighbor))
    /** summits having exactly two  neighbors */
    val twoNeighbor = bfs.couldBeOtherThanMuis & (~(bfs.density > ASTLfun.fromInt(2))) & neq(bfs.density) & ~oneNeighbor
    /** true for the inside face of an isolated tripleton (the neighbors have all exactly two neighbors */
    val isTripletonF: BoolF = insideS[V, F](existS[F, V](insideFace) & twoNeighbor)
    /** true for vertices of an isolated tripleton */
    val isTripleton = existS[F, V](isTripletonF) //true if the summits form a triangle.
    /** the summit is either a perfect doubleton or a perfect tripleton */
    val isLeton=isTripleton | isDoubleton
    /** split-in-3 tripleton are predominant over Vmeeting points and Emeeting points. */
    val shadowedNbcc3 = exist[E, V](neighborsSym(e(nbcc3)))| nbcc3
    /** we may consider only meeting point not shadowed by a split-in-3 face */
    val meetiEVnotShadowed = meetiEV & ~shadowedNbcc3;  val meetiEnotShadowed = meetiE & ~shadowedNbcc3
    // def showMore:Unit=shoow(nbcc3,isDoubleton,isTripleton,meetiE,meetiV,meetiEV,loosangeIncluded)
    override def showMe: Unit = {shoow( losangeApexes,isLeton,loosangeIncluded,nbcc3,shadowedNbcc3,meetiEVnotShadowed,finDeDepassement,depassOui,depassNon)
      bfs.showMe
    }
  }
}
/** we now computes the blob field of summit deprived of particles */
trait addTunnel {
  self: MovableAgV with addSummit with addBlobSummitAndMore =>
  /** for elongated summit, forming a tunnel of thickness 2, we want to maintain the particle into dividing the tunnel */
  val tunnel=sum.isSummit2 & ~ muis
  /** bfTh.bv.meetV true if  emptying particle would cause particle to stop dividing a "tunnel summit"*/
  val bfTn= new BloobVFields(muis, tunnel)
}

/**
 *  use all the fields computed around the summit, in order to create a "ciblerFaible" force "seize" which will maitain doubleton and tripleton particles
 *  it does not forces empty when not on target, and it allows to invade next to target.
 *  *  */
trait addSeize extends  Homogen with addSummit with addBlobSummitAndMore with addTunnel with addProp with addRadius with addRect with addZone {
  //val zltNear=existS[V,E](zon.zlt.muis)
  val losangeApexesQuelconque=bsmAtt.losangeApexes& ~ zon.zlt.muis
  val cibleTripleton= bfTn.bv.meetV | prop.tripletonStreched | bsmAtt.nbcc3
  val cibleZonisee=cibleTripleton & (Compute.implique(~zon.zlt.muis, ~adjacentRing(cibleTripleton & zon.zlt.muis)))

  val seize= ciblerFaible(  ( bsmAtt.isLeton | bfTn.bv.meetV | /*prop.tripletonStreched |*/ bsmAtt.nbcc3 )& ~bsmAtt.losangeApexes & ~sum.weakSummit)
 // val seizeOld= closerFaible(  ( bsmAtt.isLeton | bfTn.bv.meetV )/* */ & ~bsmAtt.losangeApexes & ~sum.weakSummit|  prop.tripletonStreched)
 val depasser1= Force.empty(bsmAtt.depassNon& ~zon.zlt.muis) | Force.fill(bsmAtt.depassOui& ~zon.zlt.muis)
  val depasser3= Force.empty(bsmAtt.depassOui3) | Force.fill(bsmAtt.depassNon3)
  val zltEnface: BoolVe =neighborsSym(e(zon.zlt.muis))
  val keepUltraPair= Force.notfill(e(prop.doubletonHyperStreched) /*& ~ zltEnface*/)
val depasser=depasser1 | depasser3

  override def shoi={super.shoi;sum.showMe;bsmAtt.showMe;bfTn.showMe; prop.showMe
    //shoow(bsm.losangeApexes,bsm.isDoubleton , bsm.isTripleton ,bfTn.bv.meetV,bsm.nbcc3)
  }
}