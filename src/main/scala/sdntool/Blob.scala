package sdntool

import compiler.ASTL.{delayedL, transfer}
import compiler.ASTLfun.{e, f, fromInt, neq, rhombusExist, v}
import compiler.SpatialType.{BoolE, BoolF, BoolV, BoolVe, BoolVf, UintV, UintVx}
import compiler.{ASTBfun, ASTLfun, E, V}
import progOfmacros.Comm.{apexE, neighborsSym}
import progOfmacros.Compute.countNeighbors
import progOfmacros.RedT.cac
import progOfmacros.Topo.{nbccV, nbccVe}
import progOfmacros.Wrapper.{borderS, exist, existS, inside, insideS, shrink, shrink2, shrink3}
import sdn.Globals.root4naming
import sdn.Util.{addLt, addSym}
import sdn.{Agent, Attributs,  Both, CancelFlipIf, Constr, MovableAgV, MutKeepFlipIf, PartialUI,  carrySysInstr}

/** defines what's neccessary to obtain a blob: the meeting points meetE, and meetV, and also the number of connected component nbcc*/
abstract class Blob extends Attributs {  val meetV:BoolV; val meetE:BoolE; val nbCc:UintV
  /** allows to picture meeE as vertices */
  def meetE2=existS[E,V](meetE)
  /** regroup all meeting points and so, all gabriel centers */
  val meet= ~ (~ delayedL(meetV | meetE2)) //double négation nécessaire pour nommer, car on ne peut pas nommer un delayedL.
  //val meetFilled= ~ (~ delayedL(meetV | meetE2)) //double négation nécessaire pour nommer.
  override def showMe=shoow(meet)//;shoowText(nbCc,List())
}



/**
 * Build a blob from  the brdE and brdV fields of a BlobVfieldB
 * @param muis  provides show capabilities
 * @param f generic blobVfields,  containing brdE for computing blob on a boolE, plus many often used fields
 */
class BloobV(val muis:BoolV with carrySysInstr, f:BloobVFields) extends Blob  {
  val nbCc=nbccV(f.brdE)
  val meetV= (nbCc > ASTLfun.fromInt(1))
  val nbcc0= ~neq(nbCc)
  val nbcc1= ~nbcc0 & ~meetV  //une seule composante connexe au voisinage
  val twoAdjBlob: BoolE = insideS[V, E](f.brdV) //third use of brdE, check that there is two adjacent blobs next to the empty rhombus
  val emptyRhomb: BoolE = ~rhombusExist(f.brdE) // true if center of a NON-totally empty rhombus
  val meetE=twoAdjBlob & emptyRhomb
  /** provides the meeting edge inside the blob */
  val meetEfilled=meetE & f.insideE
  /** provides the meeting edge outside the blob */
  val meetEempty=meetE & f.outsideE
  /** provides the meeting vertice  inside the blob */
  val meetVfilled=meetV&f.otherThanMuis
  /** */
  override  def showMe={super.showMe ; shoow(nbcc0,nbcc1,meetV); shoowText(nbCc,List())
  }
}


/** endows a movableAgentV with the blob meeting points */
//trait addBloobV{ self: MovableAgV with addBlobVfields =>  val baba=new BloobV(muis,bf)}



/** endows  a  BoolVe COMPUTED AS THE SLOPELT OF  A DISTANCE,  with  its  meeting points
 * those meeting points correspond to the gabriel centers.
 * It computes first a borderE, muis is passed for the sole purpose of enabling shoow
 * note that it implements exactly the abstract class Blob*/
class BlobVe(val muis:BoolV with carrySysInstr,brdE:BoolE, brdVe:BoolVe) extends Blob{
  val nbCc: UintV = nbccVe(brdVe) //nbcc 's computation is refined compared to BlobV, and BlobE
  val vf: BoolVf = cac(ASTBfun.delta, brdVe)/**  true if all neighbors are at equal distance which happen for a PE is encicled by an hexagon of seeds at distance 2, or a the very begining*/
  /**  make sur meetV is on initially, when dg is flat */
  val meetVinit= ~exist(transfer(v(brdE))) //todo, si ca se trouve ca coresponds a nbcc==0 qui serai plus esthetique
  val meetV: BoolV = nbCc > ASTLfun.fromInt( 1) & nbCc<ASTLfun.fromInt(3)// | meetVinit //makes an implicit conversion of nbCh from unsigned int to signed int. shoudl take into acount only nbch$1
  val upwardSelle:BoolE =inside(apexE(shrink(brdVe))) //les deux vertex lointaint du losange sont strictement plus loin
  val downwardSelle:BoolE= ~brdE //les deux vertex proches du losange sont a la meme distance
  val brdEsrc=exist(transfer(e(muis)))
  val selle=upwardSelle&downwardSelle & ~brdEsrc //selle cannot hapen next to seed. (it could if we did not explicitely forbid it, due to a specific artefact of simultaneously extending and diminishin a doubleton seed, fuck.
  val emptyRhomb:BoolE= ~rhombusExist(brdE) //il y a un gros plateau de distance sur tout le rhombus
  val emptyRhomb3:BoolF=inside(transfer( f(emptyRhomb)))
  val emptyRhombAdjusted:BoolE=emptyRhomb & ~exist(transfer(e(emptyRhomb3)))
  val meetE= selle | emptyRhombAdjusted //ca n'est pas un vrai gcenter avec emptyrhomb

  //used to initiate propagation from the gcenter towards particles

  /** true if insidie a gcenter edge */
  val brdGe=transfer(v(meetE))
  /** true if next to a gcenter vertice */
  val brdGv:BoolVe=neighborsSym(e(meetV))
  /** combination , true if next to a gcenter */ //val brdG= brdGv // |brdGe

  /** shows the fields related to blobVe meeting points*/
  override def showMe: Unit = {
    super.showMe
    shoow(upwardSelle,downwardSelle,emptyRhomb,emptyRhomb3,emptyRhombAdjusted,brdGe,brdGv)
    //;shoow(emptyRhomb);shoow(meetE2)
  }
}

/** avoid simultaneous emtpy and invade  that can result in creating holes */
trait blobConstrTrou{
  self: MovableAgV with addBlobVfields =>
  val videPlein= MutKeepFlipIf(this,Both(),bf.brdE) _ ;  addConstraint("videplein",';',videPlein)}

trait  blobConstrain   {
  self: MovableAgV with addBlobVfields=>
  /** meetV points cannot flip */
  val vmeet: PartialUI => Constr =  CancelFlipIf(this,Both(),bf.bv.meetV | bf.bv.nbcc0) _
  addConstraint("vmeet",'_',vmeet)
  /**a doubleton cannot flip both vertices*/
  val emeet = MutKeepFlipIf(this,Both(),bf.bv.meetE) _ ;  addConstraint("emeet",'=',emeet);}



/**   computes field needed to compute blob meeting points, as well a many other field often used for blob
 *   this avoir having to redefine them.
 *
 * @param muis provide shoow capability
 * @param otherThanMuis for computing blob properties, otherThanMuis is equal to muis, if muis is an agent[V]
 *
 */
class BloobVFields(val muis:BoolV with carrySysInstr, val otherThanMuis:BoolV) extends Attributs{
  /** true on the border of the blob  la double négation est la pour que le champs s'appelle bien brdE */
  val brdE:BoolE=  borderS(~(~ otherThanMuis) )//push everywhere possible.
  /** true on vertices next to the border of the blob */
  val  brdV:BoolV=existS(brdE)
  val isVe:BoolVe=e(otherThanMuis)
  /** true if there is a filled vertice towards the corresponding direction among the 6 directions*/
  val qqnEnFace:BoolVe=neighborsSym(isVe)
  /** Ve edges leaving the support , we know we may take a sym so we prepare for it, to get a meaningfull name brdVe.sym*/
  val brdVeIn: BoolVe =transfer(v(brdE)) & isVe//addSym introduit un delayed et compromet le nommage automatique par reflection. addSym( transfer(v(brdE)) & isVe)
  val brdVeOut: BoolVe=transfer(v(brdE)) & e(~otherThanMuis)//todo bien possible qu'on puisse travailler juste avec un seul brdVe
  /** true for inner edges */
  val insideE: BoolE =inside(transfer(isVe))
  val outsideE: BoolE =inside(transfer(~isVe))
  val rand= root4naming.addRandBit().asInstanceOf[BoolV]
  /** todo ya deux vote, un ca suffit */
  val lightConcave=( exist(shrink3(brdVeOut)) | (exist(shrink2(brdVeOut)) & rand) ) & ~  inside(brdVeOut)

  val density: UintVx = addLt(countNeighbors(addSym(e(otherThanMuis)).sym))
  //val raand:BoolV= ~ (~root4naming.addRandBit().asInstanceOf[BoolV] )//random bit
  val notDense = density < fromInt(3)
  val dense= ~(density<4)
  val density3: BoolV = ~notDense & ~dense //density = 3 todo remove
  val thiis=this
  /** this contains information systematically used to build a blob, so we just go ahead and create that blob as a field of a blobV field */
  val bv=new BloobV(muis,thiis)
  override def showMe={ shoow(brdV)}//shoow(brdE,brdV,brdVeIn,brdVeOut,lightConcave,dense, notDense) ; shoowText(density,List())  }
}

/** endows an Agent vertex with the feature needed to a blob stored in a class "bf" (shortname) */
trait addBlobVfields{
  self: Agent[V] =>
  /** muis is send two time: for one to provide shoow ability and for two, to compute blob on */
  val bf=new BloobVFields(muis,muis)
}
