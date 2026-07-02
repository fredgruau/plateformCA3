package sdn

/*
// Contains code use to compute fields for maintaining blobs and quasiPoints
// We isolate functionality which can be reused elsewhere such as borderE, borderV.
// We will distinguish basic blobV, blobE, blobVe. They each requires increasingly complex computation
// blobV could be computed from blobE, which could be computed from BlobEv,
// but we prefer to compute them each one in a specfic way because it is more clear and also more perfomrant.
*/

import compiler.AST.{Call1, Call2, Fundef1, Fundef2, Layer, pL}
import compiler.ASTB.Intof
import compiler.ASTBfun.{andLBtoR, eqUI2}
import compiler.ASTLfun._
import compiler.ASTL._
import compiler.SpatialType._
import compiler.Circuit.hexagon
import compiler._
import compiler.ASTLt.ConstLayer
import dataStruc.{BranchNamed, Named}
import progOfStaticAgent.{Convergent, SpreadOnSummit}
import progOfmacros.Comm.{adjacentBall, apexE, apexV, insideBall, neighborsSym, symEv}
import sdn.MovableAgV
import progOfmacros.{Topo, Wrapper}
import progOfmacros.Compute._
import progOfmacros.Wrapper.{border, borderS, exist, existS, inside, insideS, not, shrink, shrink1, shrink2, shrink3}
import progOfmacros.RedT.{cac, enlarge, enlargeEF, enlargeFE, shrinkshrink}
import progOfmacros.Topo.{brdin, nbcc, nbccV, nbccVe}
import progOfmacros.Util.randE2
import sdn.Globals.root4naming
import sdn.Util.{addLt, addSym}
import sdntool.{MuDist, addDist, addDistVor, addZone}

import scala.collection.IterableOnce.iterableOnceExtensionMethods
/** contains fields that can be computed for any boolV representing blobs, not just Vagents
 * for exemple, we can use it to grow voronoi, which needs meeting point
 * */

/** declares a bunch of spatial attributes, provide the necessary trait "show"  to show a selection of them */
abstract class Attributs extends  hasMuisSysInstr with shoow with BranchNamed with Named{
  def showMe
}

class BlobVFields(val muis:BoolV with carrySysInstr) extends Attributs {
  /** true on the border of the blob */
  val brdE:BoolE=  borderS(~(~ muis) )//push everywhere possible. todo enlever la double négation.
  /** true on vertices next to the border of the blob */
  val  brdV:BoolV=existS(brdE)
  val isVe:BoolVe=e(muis)
  /** true if there is filled vertice toward each of the 6 corresponding directions */
  val qqnEnFace:BoolVe=neighborsSym(isVe)
  val notVe= ~isVe
  /** Ve edges leaving the support , we know we may take a sym so we prepare for it, to get a meaningfull name brdVe.sym*/
  val brdVeIn: BoolVe =transfer(v(brdE)) & isVe//addSym introduit un delayed et compromet le nommage automatique par reflection. addSym( transfer(v(brdE)) & isVe)
  val brdVeOut: BoolVe=transfer(v(brdE)) & e(~muis)//todo bien possible qu'on puisse travailler juste avec un seul brdVe
  val rand= root4naming.addRandBit().asInstanceOf[BoolV]
  val lightConcave=( exist(shrink3(brdVeOut)) | (exist(shrink2(brdVeOut)) & rand) ) & ~  inside(brdVeOut)
  /** true for inner edges */
  val insideE: BoolE =inside(transfer(isVe))
  val smoothen: Force = new Force() {
    override def actionV(ag: MovableAgV): MoveC = {
      /** true if >= three consecutive neighbors & ~  inside(brdVeOut) rules out singleton holes which would otherwise be filled*/
      val inE:BoolE=insideS(muis)
      /**  */
      val convex: BoolV = ~exist(shrink1(transfer(v(inE))))
      val oui= MoveC1(ag.muis & convex, brdVeIn & neighborsSym(e(lightConcave)) )
        oui
    }
  }
  override def showMe={ shoow(brdE,brdV,brdVeIn,brdVeOut)   }
}
/** endows a movableAgentV with the feature needed to a blob stored in a class "f" (shortname) */
trait addBlobVfields{ self: MovableAgV =>
  val bf=new BlobVFields(muis)
}
/** fields common to all blobs properties; */
abstract class Blob extends Attributs {  val meetV:BoolV; val meetE:BoolE; val nbCc:UintV
  /** allows to picture meeE as vertices */
  def meetE2=existS[E,V](meetE)
  /** regroup all meeting points and so, all gabriel centers */
  val meet= ~ (~ delayedL(meetV | meetE2)) //double négation nécessaire pour nommer.
override def showMe=shoow(meetV,meetE,nbCc,meet)}

/**
 *
 * @param muis allows to shoow
 * @param f generic fields of a blob, needed to compute meeting points
 */
class BlobV(val muis:BoolV with carrySysInstr,f:BlobVFields) extends Blob  {
  val nbCc=nbccV(f.brdE)
  val meetV=nbCc>1
  val nbcc0= ~neq(nbCc)
  val twoAdjBlob: BoolE = insideS[V, E](f.brdV) //third use of brdE, check that there is two adjacent blobs next to the empty rhombus
  val emptyRhomb: BoolE = ~rhombusExist(f.brdE) // true if center of a NON-totally empty rhombus
  val meetE=twoAdjBlob & emptyRhomb
  val meeEfilled=meetE & f.insideE
  /** */
  override  def showMe={super.showMe;shoow(emptyRhomb) }
}

/** endows a movableAgentV with the blob meeting points */
trait addBloobV{ self: MovableAgV with addBlobVfields =>val b=new BlobV(muis,bf)}

/** endows  a  BoolVe COMPUTED AS THE SLOPELT OF  A DISTANCE,  with  its  meeting points
 * those meeting points correspond to the gabriel centers.
 * It computes first a borderE, muis is passed for the sole purpose of enabling shoow */
class BlobVe(val muis:BoolV with carrySysInstr,brdE:BoolE, brdVe:BoolVe) extends Blob{
  val nbCc: UintV = nbccVe(brdVe) //nbcc 's computation is refined compared to BlobV, and BlobE
  val vf: BoolVf = cac(ASTBfun.delta, brdVe)/**  true if all neighbors are at equal distance which happen for a PE is encicled by an hexagon of seeds at distance 2, or a the very begining*/
  /**  make sur meetV is on initially, when dg is flat */
  val meetVinit= ~exist(transfer(v(brdE))) //todo, si ca se trouve ca coresponds a nbcc==0 qui serai plus esthetique
  val meetV: BoolV = ((nbCc > 1) & (nbCc<3)) // | meetVinit //makes an implicit conversion of nbCh from unsigned int to signed int. shoudl take into acount only nbch$1
  val upwardSelle:BoolE =inside(apexE(shrink(brdVe))) //les deux vertex lointaint du losange sont strictement plus loin
  val downwardSelle:BoolE= ~brdE //les deux vertex proches du losange sont a la meme distance
  val brdEsrc=exist(transfer(e(muis)))
  val selle=upwardSelle&downwardSelle & ~brdEsrc //selle cannot hapen next to seed. (it could if we did not explicitely forbid it, due to a specific artefact of simultaneously extending and diminishin a doubleton seed, fuck.
   val emptyRhomb:BoolE= ~rhombusExist(brdE) //il y a un gros plateau de distance sur tout le rhombus
  val meetE= selle | emptyRhomb //ca n'est pas un vrai gcenter avec emptyrhomb
//used to initiate propagation from the gcenter towards particles

  /** true if insidie a gcenter edge */  val brdGe=transfer(v(meetE))
  /** true if next to a gcenter vertice */  val brdGv:BoolVe=neighborsSym(e(meetV))
  /** combination , true if next to a gcenter */ //val brdG= brdGv // |brdGe

 /** shows the fields related to blobVe meeting points*/
  override def showMe: Unit = {
    super.showMe
    shoow(upwardSelle,downwardSelle,emptyRhomb)
    //;shoow(emptyRhomb);shoow(meetE2)
  }
}

/** endows a distance with BlobVE meeting points */
//trait addBloobVe{ self: MovableAgV with addBlobVfields with addDist=>val b=new BlobVe(muis,d.voisinDiff,  d.sloplt)}
/** endows a distance with Gabriel center which are almost the same as BlobVe'
 * gabriel centers can be directly obtain simply by computing Ve-meeting-point  using sloplt
 * we also need brdE
 * */
trait addGcenter{
  self: MovableAgV with addBlobVfields with addDist=>
  val thismuis=muis
  val bve=new BlobVe(muis,~d.level,d.sloplt){
    /**  OBSOLETEsilly way of avoiding superposition of agents with Gcenter
     * we just subtract muis from meet2E,
     * we use a val for testing */
    override val meetE2: ASTLt[V, B] = (super.meetE2 ) //& OBSOLETE ~ thismuis ya probablement plus besoin d'enlever thismuis
  }
  val gc= new DetectedAgV(bve.meetE2 | bve.meetV) with keepInsideForce {
    override def inputNeighbors = List(d)
  }
} //todo verifier que override fonctionne

/** avoid simultaneous emtpy and invade  that can result in creating holes */
trait blobConstrTrou{
  self: MovableAgV with addBloobV=>
  val videPlein= MutKeepFlipIf(this,Both(),bf.brdE) _ ;  addConstraint("videplein",';',videPlein)}
trait  blobConstrain   {
  self: MovableAgV with addBloobV=>
  /** meetV points cannot flip */
  val vmeet: PartialUI => Constr =  CancelFlipIf(this,Both(),b.meetV | b.nbcc0) _
  addConstraint("vmeet",'_',vmeet)
  /**a doubleton cannot flip both vertices*/
  val emeet = MutKeepFlipIf(this,Both(),b.meetE) _ ;  addConstraint("emeet",'=',emeet);}

/** computes a boolV proped, true iff a quasiParticle is inner balled is "proped" on its voronoi wall
 * it could not move further without penetrating that wall
 * if proped is true, it means that we should keep the quasiparticle thick, i.e
 * not allows it to shrink, if its 2 or 3 vertice wide, il will remain non punctual
 * we are happy because it is a convergence criterium, and such convergence is hard to formulate
 *  allthough caution should be made that this specific condition is not met that often.
 *
 *  We
 * */
trait addProp{
  self: MovableAgV with addDistVor with QpointConstrain with addZone=>
/** rename this.muis in order to be able to adress it later on. */
  val muisSelf= this.muis
  val prop=new Attributs() { //su==summitFields
    override val muis: ASTLg with carrySysInstr = muisSelf
    //true if border is adjacent to a strictly decreasing distance
    val brdVeSlopped: ASTLt[T[V, E], B] =bf.brdVeIn & dgv.sloplt  //to consider a sloplt greater than 1


     //bifurcation: plutot que de calculer des existze sur les 6 direction, on calcule les composante connexe de BrdVeSlopped
   val participatinSite:BoolVf=shrink(bf.brdVeIn) //place to consider when computing the number of streched link
    val streched: BoolVf =  participatinSite & cac(ASTBfun.delta, brdVeSlopped)
    val bit0StrechedLocal: BoolV=border(streched)
    val orStrechedLocal: BoolV =exist(streched) //vrai si ya des strech
    val bit1StrechedLocal: BoolV =orStrechedLocal & ~bit0StrechedLocal  //il y a une retenu si on a le bit0 qui vaut 0, mais il y  a un voisin qui vaut 1



    val bitONbStreched: BoolF = border(transfer(f(bit0StrechedLocal) )) //on peut trouver directement le bit0 final
    val tforStrechedLocal=transfer(f(orStrechedLocal))
    val orStrechedGlobal:BoolF=exist(tforStrechedLocal)
    val threeOne:BoolF=inside(tforStrechedLocal) //true if tripleton has three neighbors, symetric
    val carry= threeOne | (orStrechedGlobal & ~ bitONbStreched ) //il y a une retenu si on a le bit0 qui vaut 0, mais y a des strech warning, faut aussi regarder si les trois valent 1
    val bit1NbStreched:BoolF = exist(transfer(f(bit1StrechedLocal))) | carry //le bit 1 vaut 1 si un des voisins contribue 2, ou bien si ya retenue
    //val tripletonStreched:BoolF=qf.tripleton & (bit1NbStreched | ~ bitONbStreched) //test if nbccStreched is two or zero.
    val adj3=bit1NbStreched & bitONbStreched
    val adj2=bit1NbStreched & ~bitONbStreched
    val adj0= ~bit1NbStreched & ~bitONbStreched
    val notLocalCvgcRadius:BoolF = existS(zon.zneq)
    val awayFromRiGt=zon.zlt.existOnPart & ~ zon.zlt.muis  //vrai pour la particule du tripleton qui n'a pas été attente par zon.zlt
    val tripletonStreched:BoolF=qf.tripleton &(  (adj3 | adj0 /*& ~notLocalCvgcRadius*/)) //test if nbccStreched is three or zero, or two with local cvgc of radius.

    val ebitONbStreched = border(transfer(e(bit0StrechedLocal) ))
    val teorStrechedLocal=transfer(e(orStrechedLocal))
    val eorStrechedGlobal=exist(teorStrechedLocal)
    val twoOne=inside(teorStrechedLocal) //true if doubleton has two neighbors, symetric
    val ecarry= twoOne | (eorStrechedGlobal & ~ ebitONbStreched ) //il y a une retenu si on a le bit0 qui vaut 0, mais y a des strech warning, faut aussi regarder si les trois valent 1
    val ebit1NbStreched:BoolE = exist(transfer(e(bit1StrechedLocal))) | ecarry //le bit 1 vaut 1 si un des voisins contribue 2, ou bien si ya retenue
    val eadj2=ebit1NbStreched & ~ebitONbStreched
    val eadj0= ~ebit1NbStreched & ~ebitONbStreched
    val doubletonStreched:BoolE=qf.doubleton & (eadj2 | eadj0) //test if nbccStreched is two or zero.

    override def showMe: Unit = {shoow(brdVeSlopped,participatinSite,streched,orStrechedGlobal,bitONbStreched,bit1NbStreched,tripletonStreched,doubletonStreched,awayFromRiGt)}


    //ce qui suit et probable obsolete
    val allBrdSlop: UintV = concatR(brdVeSlopped) //on récupére 18 bits a la suite pour 6 voisins, chacun 3 bits,
    val (east, se, sw, w, nw, ne) = (elt(0, allBrdSlop), elt(1, allBrdSlop), elt(2, allBrdSlop), elt(3, allBrdSlop), elt(4, allBrdSlop), elt(5, allBrdSlop)) // aprés on les numérote

    val (xe, xse, xsw, xw, xnw, xne) = (existize(east), existize(se), existize(sw), existize(w), existize(nw), existize(ne))
    val a:Array[BoolV]=Array(xe, xse, xsw, xw, xnw, xne)
    /** interdit la présence de deux trous contigus qui crée donc un trou de deux directions adjacentes */
     val deuxTrousConsecutif:Array[BoolV]=(0 until 6).map(i => ~ a(i)   &  ~ a((i+1)%6)).toArray
    //val trous:Array[BoolV]=(0 until 6).map(i => ~ a(i) ).toArray
    /** interdit la présence de deux trous unitaire en face l'un de l'autre */
    val deuxTrousEnface:Array[BoolV]=(0 until 3).map(i =>  ~ a(i)   &  ~ a((i+3)%6) ).toArray
    val toutLesTrous=(0 until 6).map(i => ~ a(i)  ).toArray;
    import compiler.MyAstlBoolOp
    val xTrouConsecutifs=deuxTrousConsecutif.reduce ((x, y) => x|y) //y a un trou ou on peut bouger
    val xTrousEnface=deuxTrousEnface.reduce ((x, y) => x|y) //y a un trou ou  on peut bouger
    val xTrous=toutLesTrous.reduce ((x, y) => x|y)
    val propedOld: BoolV= ~xTrouConsecutifs  & ~ xTrousEnface  &  muisSelf//calé si pas de trou consecutif ou en face
    val proped: BoolV= ~xTrous &  muisSelf//calé si pas de trou du tout
   // override def showMe: Unit = {shoow(e, se, sw, w, nw, ne,xe, xse, xsw, xw, xnw, xne, xTrouConsecutifs,proped)}

  }
}
/**
 * Calcule une zone remarquable inclue dans summit, de 1,2, ou 3 vertex, appelée centre, qu'on pense que c'est la zone
 * a envahir par la qseed, pour se trouver impeccablement au centre du voronoi, dans le cas de cellule de Voronoi pas trop allongée
 * fait des calculs assez compliqué pour occuper le sommet le mieux possible par rapport
 * a sa forme spécifique , ces calculs résultent d'une étude à la main*/

trait addCenter {
  self: MovableAgV with addDistVor with QpointConstrain with addProp with addZone=> //on utilise prop.tripletonstreched
  val muissSelf= this.muis
  val centr=new Attributs() { //su==summitFields
    override val muis: ASTLg with carrySysInstr = muissSelf
    val isSummitOld: BoolV = ~exist(dgv.slopgt) & adjacentBall(isV)
    //on peut etre sommet tout en ayant un dgv slopt, car proche de la particule
    val isSummit: BoolV =  isV |
      (  ~exist(dgv.slopgt & neighborsSym(e(isV)))  & //y a pas de particule au voisinage, plus loin
          exist (~dgv.slopgt & neighborsSym(e(isV))) )//y a une particule au voisinage a la meme distance ou plus pres
    /** number of summit in immediate neighborhood */
    val density: UintVx = addLt(countNeighbors(addSym(e(isSummit)).sym))
    /** summits of local highest density */
    val isSummSumm = isSummit & ~exist(transfer(density.gt) & neighborsSym(e(isSummit)))
    /** true if there is a single sumsum */
    val singleSumSum = isSummSumm & ~exist(transfer(v(density.eq)) & neighborsSym(e(isSummit)))
    //val nbCC: UintV = nbccV(borderS(isSummit))


    //val cutingSumSum = singleSumSum & meetV
    val isSummitN = neighborsSym(e(isSummit))
    val vassalN = shrinkshrink(isSummitN)
    val vassal2N = shrinkshrink(vassalN)
    val isNullVassal2N = ~exist(vassal2N)
    val vassalMin = cond(e(isNullVassal2N), vassalN, vassal2N)
    val isVassal = exist(neighborsSym(vassalMin & e(singleSumSum)))
    val nbCC: UintV = nbccV(insideS(~isSummSumm & ~isVassal & isSummit))
    val meetV = nbCC > fromInt(1)
    val mignonLosange:BoolV=   isSummSumm & eq0(density ^const(Intof(3)))  //on mesure densité = 3 caractérise un petit losange avec un doubleton, pour lequel on ne veut pas deplacer le doubleton
    /** neighbor of vassal with higher density of vassal that is not sumsum */
    val queen: BoolV = isSummit & (~isSummSumm) & exist(transfer(density.lt) & neighborsSym(e(isVassal)))
    /** neighbor of vassal with higher or equal density of vassal that is not sumsum */
    //val queeneq: BoolV = isSummit & (~isSummSumm) & exist(transfer(~ density.gt) & neighborsSym(e(isVassal)))
    /** aboutissement de tout ces calculs et d'identifier "center", zone du sommet qu'on souhaite occuper */
    val center = isSummSumm | queen | isVassal  | meetV


    val triangleIncluded:BoolF=insideS(center)
    val losangeIncluded:BoolE=insideS(triangleIncluded) //ya une macro pour rhombus
    val losangeCenter:BoolV=existS(losangeIncluded)
    /** if losange and tripleton, tripleton is removed the apex and becomes a doubleton, so that it can move avaint further */
    val  shortenApexes = exist[F, V](apexV(f(losangeIncluded))) //on calcul les apex du losange, afin de pouvoir bouger le tripleton en les enlevant
    val weakDouletohLink:BoolE=bf.insideE & ~dgv.streched //true for edges located between two vertice, one of them could be removed from center because not streched
    val potentialWeakDouletohLink:BoolE=bf.brdE & ~dgv.streched //if vertice is filled on one side, it will create a weak doubleton link
    val randV:BoolV=root4naming.addRandBit().asInstanceOf[BoolV];
    val randE: BoolE = borderS[V, E, B](randV);
    val randEv: BoolEv = send[E, V, B](List(randE, ~randE)) //selects on of the vertices of a weak link
    /** true for one of the two summits of a tripleton linked  by a weakedge, iff that tripleton is no streched */
    val shortenOneOfWeaklinkExtremity=exist(transfer(v(weakDouletohLink)&randEv)) & ~existS[F,V](prop.tripletonStreched) //si on a nbcc=3 on prefere laisser le tripleton
    //on va raboter les appex si randrabot est vrai

  //  val shortenDoubleton= ~existS[E,V](qf.doubleton & dgv.streched ) //places where doubleton should shorten
    val shortendoubletonNotStreched2: BoolV = existS[E,V](qf.doubleton & ~dgv.streched ) //places where doubleton is not steched
    //val doubletonNotStreched=  qf.doubletonV & ~shortenDoubleton//on diminue un doubleton qui n'est pas etiré

    //val adjustedCentr1forTripletonMove=center & ~tripletonNotStreched
    //val shortenTripleton= apexes | oneOfWeaklinkExtremity //places where tripleton should shorten
   /** places where tripleton should shorten */
    val shortenTripleton2= qf.tripletonV &  //target tripleton
      (shortenApexes | //this was for switching from one tripleton to another one, both having nbcc=3. seem to be not  usefull
        shortenOneOfWeaklinkExtremity ) & //remvoves either rhombus extremities or a weaklink extremity
      ~existS[F,V](prop.tripletonStreched) //does not touch tripleton which have nbcc =0 or nbcc =3
    //val tripletonNotStreched = qf.tripletonV & ~apexes & ~randRabotDeplDoubletonPerpendiculaire
 //   val tripletonNotStreched = qf.tripletonV & ~shortenTripleton  //how to update center, if it is a tripleton.
  //  val adjustedCentr1forTripletonMove=cond(qf.tripletonV, center & ~apexes & (~randRabotDeplDoubletonPerpendiculaire), center) //rabote un des sommets du tripleton non streched, (en enlevant les pointes du losange) pour lui permettre de ensuise se déplacer
  //val shortenCenter= (tripletonNotStreched  |   doubletonNotStreched)
  val shortenCenter = shortenTripleton2 |  shortendoubletonNotStreched2 //forces removal of center
   // val adjustedCentr1forTripletonMove=cond(qf.tripletonV, center & ~shortenTripleton, center) //rabote un des sommets du tripleton non streched, (en enlevant les pointes du losange) pour lui permettre de ensuise se déplacer


    /**pour deplacer un doubleton suivant un axe perpendiculaire avec celi du doubleton:*/
    val perpendicularMoveOfDoubleton:BoolE=dgv.streched & existS[V,E](qf.doubletonV) & ~qf.doubleton & ~existS[V,E](mignonLosange )
   // val extendToTripletonForPerpMove=(isSummit & existS[E,V](perpendicularMoveOfDoubleton)& ~center& ~isV) //reforme un tripleton
    val extendToTripletonForPerpMove=(isSummit & existS[E,V](perpendicularMoveOfDoubleton)&
      (~existS[E,V](potentialWeakDouletohLink) | zon.zlt.muis)&
      ~center& ~isV) //reforme un tripleton
    //val adjustedCentr2forDouubleton = adjustedCentr1forTripletonMove | extendToTripletonForPerpMove
    val dis1=eq0(density ^const(Intof(1))) //density is only one
    val extendSingletonToYtail=isSummit&exist(neighborsSym(e(qf.singleton))) &   dis1 & ~isV //adds Y tail to center
   // val adjustCenter3ForSingletonMove=(adjustedCentr2forDouubleton & ~doubletonNotStreched) | extendSingletonToYtail
    val singletonOnApex= existS[F,E](existS[V,F](qf.singleton))
     val extendSingletonToDoubleton=existS[E,V](insideS[V,E](isSummit)& dgv.streched & singletonOnApex & bf.brdE) //marche aussi pour Y tail
   // val adjustCenter4ForYMove=adjustCenter3ForSingletonMove | extendSingletonToDoubleton
    val extendCenter= extendToTripletonForPerpMove | extendSingletonToYtail | extendSingletonToDoubleton
    val updatedCenter= (center & ~shortenCenter) | extendCenter
    //pour deplacer un doubleton suivant un axe parallele avec celui du doubleton:
   // val nsummit=neighborsSym(e(isSummit))
   // val applySymetry:BoolVe=nsummit^sym(nsummit)
   // val middleOfSegment3=exist(nsummit) & ~exist(applySymetry)
    //val centerForMovingSingleton=cond(qf.doubletonV, center,isSummit & exist(neighborsSym(e(middleOfSegment3))))
    override def showMe: Unit = {shoow(updatedCenter,shortenCenter,shortendoubletonNotStreched2,shortenTripleton2,
      extendCenter, extendSingletonToDoubleton,extendSingletonToYtail,perpendicularMoveOfDoubleton,extendToTripletonForPerpMove,
      shortenOneOfWeaklinkExtremity,weakDouletohLink,
      center,isSummit,isVassal,queen,meetV,isSummSumm,losangeCenter,mignonLosange,shortenApexes,losangeIncluded,
      randE,randV)}
  }}

/** field needed to compute the constraints of  a quasipoint, and possibly elsewehere */
trait addQpointFields {
  self: MovableAgV with addBlobVfields => //MovableAgentV with addBlobVfields =>
  /** allows to refere to the englobing class from the body of the anonymous attribute */
  private val selfRef = this
  /** on utilise une classe anonyme pour stoquer les fields utiliser pour réaliser un quasipoints */
  val qf = new Attributs() {
    override val muis: BoolV with carrySysInstr = selfRef.muis
    /** true for the vertices of a qpt consiting exactly of one vertices */
    val singleton: BoolV = inside(bf.brdVeIn) & muis
    val nonsingleton = ~singleton & muis
    val next2NonSingleton = exist(neighborsSym(e(nonsingleton)))
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
trait  QpointConstrain extends addQpointFields  with rando {
  self: MovableAgV => //a quasi point  is allways a movableAgentV

  /**
   *
   * @param feature
   * return a boolV true throughout the seed,
   * if and only if feature is also true throughout the seed
   */
  def forallize(feature:BoolV)={
    insideBall(imply(muis, feature))
  }
  /** return a boolV true throughout the seed,
  * if and only if feature is also true for one vertex of the seed
  * feature is usually only defined in the seed */
  def existize(feature:BoolV)={
    val muisfeature=muis & feature
    muisfeature | (muis & exist(neighborsSym(e(muisfeature))))
  }

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
  val diseaperDouble = MutKeepFlipIf(this,One(true),qf.doubleton)_
  addConstraint("diseaperDouble",'d',diseaperDouble)
  /** cannot grow from two, to four on both apex */
  val appearDouble = MutApexKeepFlipIf(this,One(false),qf.doubleton) _
  addConstraint("appearDouble",'a',appearDouble)
  /**  a tripleton cannot flip its three vertices*/
  val diseaperTriple=TriKeepFlipIf(this,One(true),qf.tripleton)_
  addConstraint("diseaperTriple",'t',diseaperTriple)

  //val extend2side: BoolVe = clock2(transfer(sym(v(doubleton) & rand.randSide)))


  /** used to compute flip cancelation depending on impact */
}





