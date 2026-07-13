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
  override def showMe={ shoow(brdE,brdV,brdVeIn,brdVeOut,lightConcave)   }
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

    override def showMe: Unit = {shoow(brdVeSlopped,participatinSite,streched,orStrechedGlobal,bitONbStreched,bit1NbStreched,//awayFromRiGt,
      tripletonStreched,doubletonStreched,adj0,adj3)}


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
    val isSummit1: BoolV =  isV |
      (  ~exist(dgv.slopgt & neighborsSym(e(isV)))  & //y a pas de particule au voisinage, plus loin
          exist (~dgv.slopgt & neighborsSym(e(isV))) )//y a une particule au voisinage a la meme distance ou plus pres
    val cisSummit=isSummit1 |  exist (~dgv.slopgt & neighborsSym(e(isSummit1)) ) //permet d'etendre la detection des sommet un peu plus loin
    /** number of summit in immediate neighborhood */
    val density: UintVx = addLt(countNeighbors(addSym(e(cisSummit)).sym))
    /** summits of local highest density */
    val cisSummSumm = cisSummit & ~exist(transfer(density.gt) & neighborsSym(e(cisSummit)))
    /** true if there is a single sumsum */
    val singleSumSum = cisSummSumm & ~exist(transfer(v(density.eq)) & neighborsSym(e(cisSummit)))
    //val nbCC: UintV = nbccV(borderS(isSummit))


    //val cutingSumSum = singleSumSum & meetV
    val isSummitN = neighborsSym(e(cisSummit))
    val vassalN = shrinkshrink(isSummitN)
    val vassal2N = shrinkshrink(vassalN)
    val isNullVassal2N = ~exist(vassal2N)
    val vassalMin = cond(e(isNullVassal2N), vassalN, vassal2N)
    val queenOld = exist(neighborsSym(vassalMin & e(singleSumSum)))
    /** voisin de sumsum */
    val cqueen=cisSummit & exist(neighborsSym(e(cisSummSumm)) )& inside(neighborsSym(imply(e(cisSummSumm),vassalMin)))
    val cknight: BoolV = cisSummit & (~cisSummSumm) & exist(transfer(density.lt) & neighborsSym(e(cqueen)))

    val nbCC: UintV = nbccV(insideS(~cisSummSumm & ~cqueen & cisSummit))
    val meetV = nbCC > fromInt(1)//utilisé pour pouvoir inscrire un losange dans le centre, oui mais cela dysimetrise, c'est donc peut etre pas indiqué.
    val center1 = cisSummSumm | cknight | cqueen
    val nbCC2: UintV = nbccV(insideS(cisSummit& ~center1)) //nbccV(insideS(isSummit& ~isV))
    val cjoker = nbCC2 > fromInt(1)
    /** neighbor of vassal with higher density of vassal that is not sumsum */
   /** neighbor of vassal with higher or equal density of vassal that is not sumsum */
    //val queeneq: BoolV = isSummit & (~isSummSumm) & exist(transfer(~ density.gt) & neighborsSym(e(isVassal)))
    /** aboutissement de tout ces calculs et d'identifier "center", zone du sommet qu'on souhaite occuper */
    val center = center1 | cjoker// isSummSumm | knight | queen  | meetV //| meetV2//
    val triangleIncluded:BoolF=insideS(center);   val losangeIncluded:BoolE=insideS(triangleIncluded) //ya une macro pour rhombus
    /** if losange and tripleton, tripleton is removed the apex and becomes a doubleton, so that it can move avaint further */
    val  losangeApexes:BoolV = exist[F, V](apexV(f(losangeIncluded))) //on calcul les apex du losange, afin de pouvoir bouger le tripleton en les enlevant
    //on verifie que les deux apex sont soient égale a meetV2, soient occupée par la particules
    val confirmedApexes=losangeApexes & (isV|(cjoker & zon.zlt.muis))  //le coté vide est celui proche de zonegt
    val tripletonPeutBasculer:BoolE=inside[F,E](apexE(f(confirmedApexes)))
   val shortenOrExtendApexToBasculate=exist[F,V](apexV(f(tripletonPeutBasculer))) //meme formule utiliser pour shorten ou extend
    val weakLink:BoolE=bf.insideE & ~dgv.streched //true for edges located between two vertice, one of them could be removed from center because link is not streched
    val potentialWeaLink:BoolE=bf.brdE & ~dgv.streched //if vertice is filled on one side, it will create a weak link
    val randV:BoolV=root4naming.addRandBit().asInstanceOf[BoolV];   val randE: BoolE = borderS[V, E, B](randV);   val randEv: BoolEv = send[E, V, B](List(randE, ~randE)) //selects on of the vertices of a weak link
    /** true for one of the two summits of a tripleton linked  by a weakedge, iff that tripleton is no streched */
    val oneOfWeaklinkExtremityOld=exist(transfer(v(weakLink)&randEv))
    val tripletonStrechedV= existS[F,V](prop.tripletonStreched)
    val shortenOneOfWeaklinkExtremity=exist(transfer(v(weakLink))) &  ~ zon.zlt.muis & ~ tripletonStrechedV//au lieu d'utiliser un rand, on enleve celui qui est de l'autre coté du plus gros
    //@todo faudra se gaffer que ca peut faire disparaite les deux
    //on fait pas si le tripleton est stretched

    /** places where tripleton should shorten */
    val shortenTripleton= qf.tripletonV &  //places to be removed from center, for a tripleton
     (shortenOrExtendApexToBasculate  | //this was for switching from one tripleton to another one, both having nbcc=3. seem to be not  useful ther center is restricted to the losange center so that after, we can add the appex
      ( shortenOneOfWeaklinkExtremity ) //remvoves one of two vertices of weaklink extremity does not touch tripleton which are "streched" have nbcc =0 or nbcc =3
       )
     val mignonLosange:BoolV=   cisSummSumm & eq0(density ^const(Intof(3)))  //caractérise le centre d'un sommet en forme de losange, qui  a pour densité 3, et  avec un doubleton dans son centre, et vide sur les apex.
                                                                                  // on souhaite laisser tranquille les doubletons de ces mignons losanges.
    /**pour deplacer un doubleton suivant un axe perpendiculaire avec celui du doubleton:*/
    val perpendicularMoveOfDoubleton:BoolE=dgv.streched & existS[V,E](qf.doubletonV) &
      ~qf.doubleton & //on considére les edge qu'on peut ajouter, donc n dehors de celui du doubleton lui meme
      ~existS[V,E](mignonLosange )  //removes simple situation were extending center is not appropriate
    val perpendicularMoveOfDoubleton2:BoolE=perpendicularMoveOfDoubleton & existS[V,E](zon.zlt.muis)
   val extendDoubletonToDoubletonCreate=(cisSummit & existS[E,V](perpendicularMoveOfDoubleton2)) //reforme un tripleton de l'autre cote de l'edge perpendicularMoveOfDoubleton2
    val shortenDoubletonToDoubletonDelete:BoolV=qf.doubletonV & exist[F,V](apexV(f(perpendicularMoveOfDoubleton2))) //Il faudrait mieux assurer que la deletion et la creation se correspondent
    val extendDoubletonToUnstableTripleton=(cisSummit & existS[E,V](perpendicularMoveOfDoubleton)& (~existS[E,V](potentialWeaLink) | zon.zlt.muis)&    ~center& ~isV) //reforme un tripleton
    val extendDoubletonToTripletonApexBasculate=qf.doubletonV & shortenOrExtendApexToBasculate & zon.zlt.muis //on s'étends vers l'apex seulement si ca rapproche de zoneg[

    //extension et retrecissement dans leur ordre d'apparition.
    val density1=eq0(density ^const(Intof(1))) //density is only one
    val extendSingletonToInstableDoubleton=cisSummit&exist(neighborsSym(e(qf.singleton))) &   density1 & ~isV //allows a center of one vertex to temporarily explore a nearby summit, needs  zone.zlt.muis
    val shortendoubletonNotStreched2: BoolV = existS[E,V](qf.doubleton & ~dgv.streched ) //to let preceding force move singleton, the created doubleton must me able to subsequently shorten
    val singletonOnEdge:BoolE= existS[V,E](qf.singleton)
    val extendSingletonToStableDoubleton=existS[E,V](insideS[V,E](cisSummit)& dgv.streched & singletonOnEdge & bf.brdE) //this is always a smart move independantly of zon.zlt.muis
    //but it creates a cycle, since the center is not modified, the created doubleton diseapeal at the next time step.
    val extendCenter1=    (extendSingletonToInstableDoubleton& zon.zlt.muis) |   extendDoubletonToDoubletonCreate  //|extendSingletonToStableDoubleton
    val shortenCenter1 =shortenDoubletonToDoubletonDelete | (shortenOneOfWeaklinkExtremity  & qf.tripletonV)

    val shortenCenter =   shortenDoubletonToDoubletonDelete |shortendoubletonNotStreched2 |  shortenTripleton  //places within the center, to be removed from the center comming either from doubleton or from tripleton
    val extendCenter=    (extendSingletonToInstableDoubleton& zon.zlt.muis) |    extendSingletonToStableDoubleton   |
    /*  extendDoubletonToUnstableTripleton  |*/     extendDoubletonToTripletonApexBasculate & zon.zlt.muis | extendDoubletonToDoubletonCreate
   // val updatedCenter= (center&  ~ shortenCenter) | extendCenter ///(center)
    val updatedCenter= (center &  ~ shortenCenter1)| extendCenter1

    override def showMe: Unit = {shoow(shortenCenter,potentialWeaLink,perpendicularMoveOfDoubleton,perpendicularMoveOfDoubleton2,
      shortenTripleton,extendDoubletonToDoubletonCreate,shortenDoubletonToDoubletonDelete,
      tripletonPeutBasculer,tripletonStrechedV,shortenOrExtendApexToBasculate,vassalMin,updatedCenter,shortenCenter1,extendCenter1,
     extendCenter, extendSingletonToStableDoubleton,extendSingletonToInstableDoubleton,extendDoubletonToUnstableTripleton,extendDoubletonToTripletonApexBasculate,
      shortenOneOfWeaklinkExtremity,weakLink,losangeIncluded,
     center,cisSummit,cqueen,cknight,meetV,cjoker,cisSummSumm,// losangeCenter,mignonLosange,losangeApexes,losangeIncluded,   randE,randV
    )}
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





