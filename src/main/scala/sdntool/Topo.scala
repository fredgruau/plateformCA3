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
import compiler.ASTLfun.{f, _}
import compiler.ASTL._
import compiler.SpatialType._
import compiler.Circuit.hexagon
import compiler._
import compiler.ASTLt.ConstLayer
import dataStruc.{BranchNamed, Named}
import progOfStaticAgent.SpreadOnSummit
import progOfmacros.Comm.{adjacentBall, apexE, apexV, insideBall, neighborsSym, symEv}
import sdn.MovableAgV
import progOfmacros.{Topo, Wrapper}
import progOfmacros.Compute._
import progOfmacros.Wrapper.{border, borderS, exist, existS, inside, insideS, not, shrink, shrink1, shrink2, shrink3}
import progOfmacros.RedT.{cac, enlarge, enlargeEF, enlargeFE, shrinkEF, shrinkshrink}
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
/** computes field needed to compute blob meeting points */
/*class BlobVFields(val muis:BoolV with carrySysInstr) extends Attributs {
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
}*/

/**
 *
 * @param muis provide shoow capability
 * @param otherThanMuis for computing blob properties
 *
 */
class BloobVFields(val muis:BoolV with carrySysInstr, val otherThanMuis:BoolV) extends Attributs{
  /** true on the border of the blob */
  val brdE:BoolE=  borderS(~(~ otherThanMuis) )//push everywhere possible. todo enlever la double négation.
  /** true on vertices next to the border of the blob */
  val  brdV:BoolV=existS(brdE)
  val isVe:BoolVe=e(otherThanMuis)
  /** true if there is filled vertice toward each of the 6 corresponding directions */
  val qqnEnFace:BoolVe=neighborsSym(isVe)
  val notVe= ~isVe
  /** Ve edges leaving the support , we know we may take a sym so we prepare for it, to get a meaningfull name brdVe.sym*/
  val brdVeIn: BoolVe =transfer(v(brdE)) & isVe//addSym introduit un delayed et compromet le nommage automatique par reflection. addSym( transfer(v(brdE)) & isVe)
  val brdVeOut: BoolVe=transfer(v(brdE)) & e(~otherThanMuis)//todo bien possible qu'on puisse travailler juste avec un seul brdVe
  val rand= root4naming.addRandBit().asInstanceOf[BoolV]
  val lightConcave=( exist(shrink3(brdVeOut)) | (exist(shrink2(brdVeOut)) & rand) ) & ~  inside(brdVeOut)
  /** true for inner edges */
  val insideE: BoolE =inside(transfer(isVe))
  override def showMe={ shoow(brdE,brdV,brdVeIn,brdVeOut,lightConcave)   }
}

/** endows an Agent vertex with the feature needed to a blob stored in a class "bf" (shortname) */
trait addBlobVfields{ self: Agent[V] =>
  /** muis is send two time: for one to provide shoow ability and for two, to compute blob on */
  val bf=new BloobVFields(muis,muis)
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
 * @param muis  provides show capabilities
 * @param f blob generic fields,  on which to compute  classic blob features
 */
class BloobV(val muis:BoolV with carrySysInstr,f:BloobVFields) extends Blob  {
  val nbCc=nbccV(f.brdE)
  val meetV=nbCc>1
  val nbcc0= ~neq(nbCc)
  val twoAdjBlob: BoolE = insideS[V, E](f.brdV) //third use of brdE, check that there is two adjacent blobs next to the empty rhombus
  val emptyRhomb: BoolE = ~rhombusExist(f.brdE) // true if center of a NON-totally empty rhombus
  val meetE=twoAdjBlob & emptyRhomb
  val meetEfilled=meetE & f.insideE
  val meetVfilled=meetV&f.otherThanMuis
  /** */
  override  def showMe={super.showMe }
}

/** adds some field to bloobV, of topological nature,  so as to compute the center */
/*
class BloobVctr (override val muis:BoolV with carrySysInstr, bfields:BloobVFields,z:sdntool.Zone) extends BloobV(muis,bfields){
  val meetiV=(meetV|nbcc0) & bfields.otherThanMuis
  val meetiEselected=meetEfilled & existS[V,E](muis)
  val nbcc3F=insideS[E,F](meetEfilled)  //true where faces splits the summit in three
  val nbcc3=existS[F,V](nbcc3F ) //true where faces splits the summit in three
  val loosangeIncluded:BoolE=insideS[F,E](nbcc3F)
 val  losangeApexes:BoolV = exist[F, V](apexV(f(loosangeIncluded))) //on calcul les apex du losange, afin de pouvoir bouger le tripleton en les enlevant
  //on doit verifie que les deux apex sont oubien occupée par la particules ou bien dans zlt
  val rhombusFilled=losangeApexes & (muis | z.muis)  //le coté vide est celui proche de zonegt
val rhombusShouldFlip=inside[F,E](apexE(f(rhombusFilled)))
  val losangeApexToRemoveFromCtr=losangeApexes & ~z.muis & muis & exist[F, V](apexV(f(rhombusShouldFlip)))
  //meme formule utiliser pour shorten ou extend


  val faceFull:BoolF=insideS[V,F](bfields.otherThanMuis) //true for faces with three vertice withing summit
  val density: UintVx = addLt(countNeighbors(addSym(e(bfields.otherThanMuis)).sym))
  val oneNeighbor= bfields.otherThanMuis & (~(density>1)) &  neq(density)
  val twoNeighbor=bfields.otherThanMuis & (~(density>2)) &  neq(density) & ~oneNeighbor
  val isTripletonF=insideS[V,F](existS[F,V](faceFull) & twoNeighbor)
  val isTripleton=existS[F,V](isTripletonF)  //true if the summits form a triangle.
  val meetiE:BoolV=existS[E,V](meetiEselected) & bfields.otherThanMuis

  val shadowedNbcc3=exist[E,V](neighborsSym(e(nbcc3)))
  val meetiEnotShadowed=meetiE & ~ shadowedNbcc3
  val meetiVnotShadowed=meetiV & ~ shadowedNbcc3
  val isDoubleton=existS[E,V](insideS[V,E](oneNeighbor)) //an edge represents a doubleton, if the two connected vertice have a single neighbor
val meetEV=meetiE|meetiV // we need to consider also elongated particles.
   val meetEblockingZltnbcc3=nbcc3 & ~z.muis & exist[E,V](neighborsSym(e(nbcc3 & z.muis)))
  val raaand:BoolV= root4naming.addRandBit().asInstanceOf[BoolV] //vrai avec trois chance sur quatre
  val meetEblockingZltmeetE=raaand & meetEV & ~z.muis & exist[E,V](neighborsSym(e(meetEV & z.muis))) //on randomize l'attraction vers zonelt, pour creer du jitter

  val ctr=((meetiVnotShadowed | meetiEnotShadowed) & ~ meetEblockingZltmeetE)|
    isDoubleton | isTripleton | (nbcc3 & ~losangeApexToRemoveFromCtr/* & ~meetEblockingZltnbcc3 trop fort cui la*/)
  override  def showMe={super.showMe }
}
*/

/** endows a movableAgentV with the blob meeting points */
trait addBloobV{ self: MovableAgV with addBlobVfields =>val b=new BloobV(muis,bf)}

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
/** endows a distance with a detected agent for the Gabriel center,  which are almost the same as BlobVe'
 * gabriel centers can be directly obtain simply by computing Ve-meeting-point  using sloplt
 * we also need brdE
 * */
trait addGcenter{
  self: MovableAgV with addBlobVfields with addDist=>
  val thismuis=muis
  val bve=new BlobVe(muis,~d.level,d.sloplt){
    /**  OBSOLETE silly way of avoiding superposition of agents with Gcenter
     * we just subtract muis from meet2E,
     * we use a val for testing */
    override val meetE2: ASTLt[V, B] = (super.meetE2 ) //& OBSOLETE ~ thismuis ya probablement plus besoin d'enlever thismuis
  }
  val gc= new DetectedAgV(bve.meetE2 | bve.meetV) with keepInsideForce {
    override def inputNeighbors = List(d)
  }
} //todo verifier que override fonctionne

/** provides just the summit, that's difficult enough to justify an attribute for this */
trait addSummit{
  self: MovableAgV  with addDistVor =>
  val thiiismuis=muis;
  val sum=new Attributs {
    override def showMe: Unit = {}
    override val muis: ASTLg with carrySysInstr = thiiismuis
    val particuleAuVoisinage=neighborsSym(e(isV)) //y a une particule au voisinage
    //on peut etre sommet tout en ayant un dgv slopt, car proche de la particule
    val isSummit1: BoolV =  isV |
      (  ~exist(dgv.slopgt & particuleAuVoisinage)  & //y a pas de particule au voisinage, plus loin
        exist (~dgv.slopgt & particuleAuVoisinage) )//y a une particule au voisinage a la meme distance ou plus pres
    /** etends la detection des sommet un vertex plus loin, y a un summit1 au voisinage a la meme distance ou plus pres */
    val isSummit2=isSummit1 |  exist (~dgv.slopgt & neighborsSym(e(isSummit1)) )
  }
}

/**
 * Calcule une zone remarquable inclue dans summit, de 1,2, ou 3 vertex, appelée centre, qu'on pense que c'est la zone
 * a envahir par la qseed, pour se trouver impeccablement au centre du voronoi, dans le cas de cellule de Voronoi pas trop allongée
 * fait des calculs assez compliqué pour occuper le sommet le mieux possible par rapport
 * a sa forme spécifique , ces calculs résultent d'une étude à la main*/
trait addBlobsm {
  self: MovableAgV with addDistVor with addSummit with QpointConstrain  with addZone => //on utilise prop.tripletonstreched
  val muissssSelf = this.muis
  /** computes blob fields of summit */
  val bfi = new BloobVFields(muis, sum.isSummit2)
  val blobsm = new BloobV(muissssSelf, bfi) {
    //we add here he stuff computed using blobs and summit.
    /** true for vertice to be in center because either Vmeeting point or isolated singleton */
    val meetiV = (meetV | nbcc0) & bfi.otherThanMuis
    /** true for meeting edges which are next to a particules, and therefore likely to participate to the center */
    val meetiEselected = meetEfilled & existS[V, E](muis)
    val meetiE: BoolV = existS[E, V](meetiEselected) & bfi.otherThanMuis
    val meetEV = meetiE | meetiV
    /** faces splitting the summit in three */
    val nbcc3F = insideS[E, F](meetEfilled)
    /** summits part of a face splitting the summit in three */
    val nbcc3 = existS[F, V](nbcc3F)
    /** true if there are two competing splitting-in-3 face */
    val loosangeIncluded: BoolE = insideS[F, E](nbcc3F)
    /** if there is a rhombus, then we compute the apex so as to be able to remove them
     * in order to orchestrate a switch from one split3 tripleton, to the other */
    val losangeApexes: BoolV = exist[F, V](apexV(f(loosangeIncluded)))
    /** faces with three vertice within the  summit */
    val insideFace: BoolF = insideS[V, F](bfi.otherThanMuis)
    /** number of neighbor summits */
    val density: UintVx = addLt(countNeighbors(addSym(e(bfi.otherThanMuis)).sym))
    /** summits having a single neighbor */
    val oneNeighbor = bfi.otherThanMuis & (~(density > 1)) & neq(density)
    /** isolated doubleton,  two connected vertice have a single neighbor */
    val isDoubleton = existS[E, V](insideS[V, E](oneNeighbor))
    /** summits having exactly two  neighbors */
    val twoNeighbor = bfi.otherThanMuis & (~(density > 2)) & neq(density) & ~oneNeighbor
    /** true for the inside face of an isolated tripleton (the neighbors have all exactly two neighbors */
    val isTripletonF: BoolF = insideS[V, F](existS[F, V](insideFace) & twoNeighbor)
    /** vertices of an isolated tripleton */
    val isTripleton = existS[F, V](isTripletonF) //true if the summits form a triangle.
    /** split-in-3 tripleton are predominant over Vmeeting points and Emeeting points. */
    val shadowedNbcc3 = exist[E, V](neighborsSym(e(nbcc3)))
    /** we will consider meeting point not shadowed by a split-in-3 face */
    val meetEVnotShadowed = meetEV & ~shadowedNbcc3

  }
  }
/** using blobsm, adds somme zlt info, and randomness in order to compute an accurate center, also able to penetrate */
  trait addCenter {
    self: MovableAgV with addDistVor with addSummit with QpointConstrain with addBlobsm with addZone => //on utilise prop.tripletonstreched
    val muuiis:BoolV with carrySysInstr =self.muis
    val ctr=new Attributs {
      override def showMe: Unit = {   }
      override val muis: BoolV with carrySysInstr = muuiis
    /** true for rhombus  apexes wrongly occupied, i.e the seed does not occupy the zlt apex, */
    val rhombusWronglyOccupied=blobsm.losangeApexes & (zon.zlt.muis | muis )  //le coté vide est celui proche de zonegt
      /** detect wrongly occupied on the rhombus middle edge */
    val rhombusShouldFlip=inside[F,E](apexE(f(rhombusWronglyOccupied)))
      /** true where wrongly occupied apex should be removed  */
    val rhombusApexToRemoveFromCtr: BoolV=blobsm.losangeApexes & ~zon.zlt.muis & muis & exist[F, V](apexV(f(rhombusShouldFlip)))
    /** turns out to be too strong removal: when progressing towards zlt zone, we should not remove hyperstreched tripleton */
    val meetEblockingZltnbcc3=blobsm.nbcc3 & ~zon.zlt.muis & exist[E,V](neighborsSym(e(blobsm.nbcc3 & zon.zlt.muis)))

    val raaand:BoolV= root4naming.addRandBit().asInstanceOf[BoolV]
      /** weak (meetEV) cutting point not sitting on zlt zone, but next to another weak cutting point on zlt zone,
       * should be removed from support, in order to allow progression towards zlt zone.
       * this removal, however, is subjected to randomization so that this progression happens at different pace, allowing  symetry breaking */
    val removalMeetEnotZltNextToMeetEonZlt=raaand & blobsm.meetEV & ~zon.zlt.muis & exist[E,V](neighborsSym(e(blobsm.meetEV & zon.zlt.muis)))
     /** first approximation of center, includes not shadowed meetEV not blocking progression to zlt zone
      * raw doubleton and tripleton, and hyperstreched tripleton which do not need to flip orientation*/
    val ctr1=(blobsm.meetEVnotShadowed  & ~ removalMeetEnotZltNextToMeetEonZlt) |
      blobsm.isDoubleton | blobsm.isTripleton | (blobsm.nbcc3 & ~rhombusApexToRemoveFromCtr/* & ~meetEblockingZltnbcc3 trop fort cui la*/)

     // val raand:BoolV= ~ (~root4naming.addRandBit().asInstanceOf[BoolV] )//random bit not necessary, we reused raaand
      /** was intended for restricting exploration of zon.zlt to agent already streching weakly in that direction, turned out to be to restrictive */
      val weakMeetE:BoolE=dgv.streched & insideS(sum.isSummit2) & existS(blobsm.meetiV)
      /** adds the possibility to directly move towards zlt, staying along the summit, randomized for symetry breaking */
      val ctr2= ctr1 | (/*existS[E,V](weakMeetE ) &*/zon.zlt.muis /*& sum.isSummit2*/ &  raaand) //let the seed explore zon.zlt, but along the summit, and with a random bit to create a jitter.


    }

}


/** endows an agent having a vonoi with a summit */
/*trait addSommet{
  self: MovableAgV with addDistVor with addSummit with addZone =>
  /** computes blobV fields with respect fo being summit or not */
  val isSummitBlob=new BloobVFields(muis,sum.isSummit2)
  val summit=new BloobVctr(muis,isSummitBlob, zon.zlt){
    val raand:BoolV= ~ (~root4naming.addRandBit().asInstanceOf[BoolV] )//random bit
    /** was intended for restricting exploration of zon.zlt to agent already strecing weakly in that direction, turned out to be to restrictive */
    val weakMeetE:BoolE=dgv.streched & insideS(sum.isSummit2) & existS(meetiV)
    val centerZlt= ctr | (/*existS[E,V](weakMeetE ) &*/zon.zlt.muis & sum.isSummit2 &  raand) //let the seed explore zon.zlt, but along the summit, and with a random bit to create a jitter.
  }
}*/

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

/** computes tripletonStreched
 * */
trait addProp{
  self: MovableAgV with addDistVor with QpointConstrain with addZone=>
/** rename this.muis in order to be able to adress it later on. */
  val muisSelf= this.muis
  val prop=new Attributs() { //su==summitFields
    override val muis: ASTLg with carrySysInstr = muisSelf
    //true if border is adjacent to a strictly decreasing distance
    val brdVeSlopped: ASTLt[T[V, E], B] =bf.brdVeIn & dgv.sloplt  //to consider a sloplt greater than 1
     //on calcule les composante connexe de BrdVeSlopped
   val participatinSite:BoolVf=shrink(bf.brdVeIn) //place to consider when computing the number of streched link
    val streched: BoolVf =  participatinSite & cac(ASTBfun.delta, brdVeSlopped) //computes one extremity for each connected component
    val bit0StrechedLocal: BoolV=border(streched) //bit0 of localNbcc for each of the three vertice of a tripleton
    val orStrechedLocal: BoolV =exist(streched) //true if localNbcc>0
    val bit1StrechedLocal: BoolV =orStrechedLocal & ~bit0StrechedLocal  //there must be a carry if bit0 is 0, but localNbcc>0
    val bitONbStreched: BoolF = border(transfer(f(bit0StrechedLocal) )) //we consider now the three vertice, and the F locus in the middle, using a xor, we can directly deduce bit 0
    val tforStrechedLocal=transfer(f(orStrechedLocal))
    val orStrechedGlobal:BoolF=exist(tforStrechedLocal) //globalNbcc>0 iff one of localNbcc >0
    val threeOne:BoolF=inside(tforStrechedLocal) //true if tripleton has three neighbors, symetric
    val carry= threeOne | (orStrechedGlobal & ~ bitONbStreched ) //il y a une retenu si on a le bit0 qui vaut 0, mais nbccGlobal>0, faut aussi regarder si les trois valent 1
    val bit1NbStreched:BoolF = exist(transfer(f(bit1StrechedLocal))) | carry //le bit 1 vaut 1 si un des voisins contribue 2, ou bien si ya retenue
    val adj3=bit1NbStreched & bitONbStreched
    val adj0= ~bit1NbStreched & ~bitONbStreched
    val tripletonStreched:BoolF=qf.tripleton &(  (adj3 | adj0 /*& ~notLocalCvgcRadius*/)) //test if nbccStreched is three or zero, or two with local cvgc of radius.

/*
    val ebitONbStreched = border(transfer(e(bit0StrechedLocal) ))
    val teorStrechedLocal=transfer(e(orStrechedLocal))
    val eorStrechedGlobal=exist(teorStrechedLocal)
    val twoOne=inside(teorStrechedLocal) //true if doubleton has two neighbors, symetric
    val ecarry= twoOne | (eorStrechedGlobal & ~ ebitONbStreched ) //il y a une retenu si on a le bit0 qui vaut 0, mais y a des strech warning, faut aussi regarder si les trois valent 1
    val ebit1NbStreched:BoolE = exist(transfer(e(bit1StrechedLocal))) | ecarry //le bit 1 vaut 1 si un des voisins contribue 2, ou bien si ya retenue
    val eadj2=ebit1NbStreched & ~ebitONbStreched
    val eadj0= ~ebit1NbStreched & ~ebitONbStreched
    val doubletonStreched:BoolE=qf.doubleton & (eadj2 | eadj0) //test if nbccStreched is two or zero.
*/

    override def showMe: Unit = {shoow(//brdVeSlopped,participatinSite,streched,orStrechedGlobal,bitONbStreched,bit1NbStreched,,adj0,adj3//awayFromRiGt,
      tripletonStreched)}

/*

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
*/

  }
}


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





