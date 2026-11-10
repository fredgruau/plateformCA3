package sdntool

import compiler.ASTBfun.{addRedop, redop}
import compiler.ASTL.{anticlock, delayedL, sym, transfer}
import compiler.ASTLfun.{apex, cond, e, f, imply, orR, reduce}
import compiler.SpatialType.{BoolE, BoolF, BoolV, BoolVe, BoolVf, UintV}
import compiler.{AST, ASTBfun, ASTLfun, B, E, F, Locus, Ring, UI, V}
import dataStruc.DagNode.EmptyBag
import progOfmacros.Comm.{adjacentBall, adjacentRing, apexV, insideBall, neighborsSym}
import progOfmacros.Compute.implique
import progOfmacros.RedT.cac
import progOfmacros.Wrapper.{exist, existS, inside, insideS, not}
import sdn.{Attributs, CancelFlipIf, KeepFlipIf, LayerS, MovableAg, MovableAgV, MuStruct, MutApexKeepFlipIf, MutKeepFlipIf, One, SexTex, TriKeepFlipIf, carrySysInstr, rando}


/** basic quasiparticle with blob and quasipoint constraints */
class Qpoint extends MovableAg[V]("global") with MovableAgV  with addBlobVfields with blobConstrain with addQpointFields with QpointConstrain
  with EmptyBag[sdn.MuStruct[_<: Locus,_<:Ring]]{
  /**
   *
   * @param feature
   * return a boolV true throughout the seed,
   * if and only if feature is also true throughout the seed
   */
  def forallize(feature:BoolV)={
    insideBall(imply(muis, feature))&muis
  }
  /** return a boolV true throughout the seed,
   * if and only if feature is also true for one vertex of the seed
   * feature is usually only defined in the seed */
  def existize(feature:BoolV)={
    adjacentBall(muis & feature)
/*    val muisfeature=muis & feature
    muisfeature | (muis & exist(neighborsSym(e(muisfeature))))*/
  }
  /** given a an integer feature, makes the sum on quasiparticle. */
  def sumize(feature:UintV):UintV={
    val zeroifiedFeature:UintV=cond(muis,feature,ASTLfun.fromInt(0)) //met 0 si on n'est pas sur la qparticule
    val zeroifiedFeatureNeig= transfer(sym(transfer(e(zeroifiedFeature))))
    val suuuum:UintV=reduce(addRedop[UI].asInstanceOf[redop[UI]],zeroifiedFeatureNeig) //y en a 6 bit, faut donc ajouter des bits!
    suuuum + zeroifiedFeature
  }

}



/** field needed to compute the constraints of  a quasipoint, defining them separately enable to use them elsewhere*/
trait addQpointFields {
  self: MovableAgV with addBlobVfields => //MovableAgentV with addBlobVfields =>
  /** allows to refere to the englobing class from the body of the anonymous attribute */
  private val selfRef = this
  /** on utilise une classe anonyme pour stoquer les fields utiliser pour réaliser un quasipoints */
  val qf = new Attributs() {
    override val muis: BoolV with carrySysInstr = selfRef.muis
    /** true for the vertices of a qpt consiting exactly of one vertices */
    val singleton: BoolV = inside(bf.brdVeIn) //& muis
    val nonsingleton = ~singleton & muis
    val next2NonSingleton = adjacentRing(nonsingleton)
    /** true if both apex vertices of the edge are empty */
    val bothApexEmpty: BoolE = not(orR(apex[V, E, B](f(muis))))
    /** true for the edge inside qpt consiting exactly of two vertices */
    val doubletoon=insideS[V, E](muis)
    val doubleton: BoolE = doubletoon& bothApexEmpty
    val doubletonV: BoolV = existS[E, V](doubleton)
    val isApexV: BoolV = exist[F, V](apexV(f(doubleton)))
    /** true for the face inside a qpt consiting exactly of three adjacent  vertices */
    val tripleton: BoolF = insideS[V, F](muis)
    val tripletonV: BoolV = existS[F, V](tripleton)
    //val choose: BoolVe =chooseMinOf(prio)
    //val choose: BoolVe = chooseMaxOf(prioYesNotQuiescent, 4) //todo deplacer dans constraint ca fait jouer prio
    override def showMe = {
      shoow(doubletonV, tripletonV,tripleton)
    }
  }
}
/** defines all the constraint that should be met by a quasipoint,
 * nb: constraints must be expressed as function of prio, and flip
 * since we do not know those at the time of constraint creation. */
trait  QpointConstrain extends addQpointFields   {
  self: MovableAgV => //a quasi point  is allways a movableAgentV


  /** will choose neighbor with higest flip priority in fp, does not depends on flip  */
  val sextexx= SexTex(this) _
  addConstraint("growToTwo",'x',sextexx)
  /** true for neighbors of non singleton*/
  //  val next2NonSingleton = exist(neighborsSym(e(doubletonV | tripletonV)))

  /**  cancel growth for non singleton, exept for doubleton, on appex, this needs a tournament*/
  val leqQuatre =    KeepFlipIf(this,One(false),implique(qf.next2NonSingleton, qf.isApexV)) _
  addConstraint("leqQuatre",'q',leqQuatre)
  /** singleton cannot flip */
  val diseaperSingle = CancelFlipIf(this,One(true),qf.singleton)_
  addConstraint("diseaperSingle",'s',diseaperSingle)
  /**a doubleton cannot flip both vertices*/
  val diseaperDouble = MutKeepFlipIf(this,One(false),qf.doubleton)_
  addConstraint("diseaperDouble",'d',diseaperDouble)
  /** cannot grow from two, to four on both apex */
  val appearDouble = MutApexKeepFlipIf(this,One(true),qf.doubleton) _
  addConstraint("appearDouble",'a',appearDouble)
  /**  a tripleton cannot flip its three vertices*/
  val diseaperTriple=TriKeepFlipIf(this,One(false),qf.tripleton)_
  addConstraint("diseaperTriple",'t',diseaperTriple)

  //val extend2side: BoolVe = clock2(transfer(sym(v(doubleton) & rand.randSide)))

  /** used to compute flip cancelation depending on impact */
}


/**
 *
 * @param source quasiparticle
 * identifies a single vertex within source,
 * when doing computation within a quasiparticle, only the leader would need to do them.
 * Also, adding a leader dimish movement, indeed the leader moves less than the quasiparticle.
 * may be not usefull after all,
 * since it is arguably easier to compute stuf on the whole particle support*/
class Leader(source: Qpoint) extends MuStruct [V,B] {
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
  shoow(electedNeigbor1)
  //shoow(electedNeigbor2,electedNeigbor1,sourceMovedWide,neighborSourceNext,elected3)
}


trait addLeader {
  self: Qpoint => //adds a leader to a seed ,
  val lead=new Leader(this);
  //show(d); les show doivent etre fait dans le main
}
