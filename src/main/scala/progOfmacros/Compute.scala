package progOfmacros

//import compiler._

import compiler.SpatialType._
import compiler.AST._
import compiler.ASTL._
import compiler.ASTLfun._
import compiler.ASTB._
import compiler.ASTBfun.{Fundef3R, addRedop, addtwo2to3UI, inc, redop}
import compiler._
import progOfLayer.Sextexrect.{weakCmpProdZero, weakCmpProdtwo}
import sdn.ForceAg.AgForced
import sdn.Util.{addSymUI, addSymUIbis, splitInto6}
/** Contains the code of spatial macro used as a layer of  building blocks of small bits of spatial operators, compiled with optimal perf. */
object Compute {
  val updateSIdef:Fundef4[(V, SI), (V, B),(V, SI), (V, SI), (V, SI)]= {
    val pred = pL[V, SI]("pred")
    val src = pL[V, B]("src")
    val targetOnSource = pL[V, SI]("targetOnSource ")
    val delta = pL[V, SI]("delta")
    val next=pred + cond(src, sign(targetOnSource),delta)
    Fundef4("compute.updateSI",next, pred,src, targetOnSource,delta)
  }
  def updateSI(pred:SintV,src:BoolV, targetOnSource:SintV,delta:SintV):SintV=
    new Call4(updateSIdef,pred,src, targetOnSource,delta)(repr.nomLR(repr.nomV, repr.nomSI))with SintV

  val concat3VDef: Fundef3[(V, B), (V, B),(V, B), (V, UI)]={
    val a = pL[V, B]("a")
    val b = pL[V, B]("b")
    val c = pL[V, B]("c")
    Fundef3("compute.concat3V", c.asInstanceOf[UintV]::b::a,a,b,c) //bizarement on doit les concaténer dans cet ordre, je ne sait pas trop pourquoi
  }
  def concat3V(b0: BoolV, b1: BoolV, b2: BoolV):UintV =
    new Call3(concat3VDef, b0, b1,b2)(repr.nomLR(repr.nomV, repr.nomUI)) with UintV

  val concat4VDef: Fundef4[(V, B), (V, B),(V, B),(V, B), (V, UI)]={
    val a = pL[V, B]("a")
    val b = pL[V, B]("b")
    val c = pL[V, B]("c")
    val d = pL[V, B]("d")
    Fundef4("compute.concat4V", d.asInstanceOf[UintV]::c.asInstanceOf[UintV]::b::a,a,b,c,d) //bizarement on doit les concaténer dans cet ordre, je ne sait pas trop pourquoi
  }
  val concat5VDef: Fundef5[(V, B), (V, B),(V, B),(V, B),(V, B), (V, UI)]={
    val a = pL[V, B]("a")
    val b = pL[V, B]("b")
    val c = pL[V, B]("c")
    val d = pL[V, B]("d")
    val e = pL[V, B]("e")
    Fundef5("compute.concat5V",  e.asInstanceOf[UintV]::d.asInstanceOf[UintV]::c.asInstanceOf[UintV]::b::a,a,b,c,d,e) //bizarement on doit les concaténer dans cet ordre, je ne sait pas trop pourquoi
  }
  def concat4V(b0: BoolV, b1: BoolV, b2: BoolV, b3: BoolV):UintV =
    new Call4(concat4VDef, b0, b1,b2,b3)(repr.nomLR(repr.nomV, repr.nomUI)) with UintV
  def concat5V(b0: BoolV, b1: BoolV, b2: BoolV, b3: BoolV, b4: BoolV):UintV =
    new Call5(concat5VDef, b0, b1,b2,b3,b4)(repr.nomLR(repr.nomV, repr.nomUI)) with UintV

  val countNeighborsDef: Fundef1[(T[V,E], B), (V,UI)] = {
  val n=pL[T[V,E], B]("neighbor")
  /** int of 6 bits*/
  val nasI: UintV = concatR(n)
  val (n0, n1, n2, n3, n4, n5) = (elt(0, nasI), elt(1, nasI), elt(2, nasI), elt(3, nasI), elt(4, nasI), elt(5, nasI))
  val n012: UintV = sum3V(n0 ,n1, n2); val n345: UintV = sum3V(n3 ,n4, n5)
  val sum6=binop(addtwo2to3UI,n012,n345) //bug a corriger
  Fundef1("compute.countNeighbors",sum6, n)
}
def countNeighbors(n:BoolVe)=new Call1(countNeighborsDef, n)(repr.nomLR(repr.nomV, repr.nomUI)) with UintV
  /**
   *
   * @param prio
   * @param k number of bit of priority
   * @return
   */

  def chooseMaxOfDef(k:Int): Fundef1[(T[V,E], UI), (T[V,E],B)]={
    /**  contients les 6 voisins dans l'ordre clock: east,se,sw, west, nw,ne */
    val vois2 = pL[T[V,E], UI]("vois")

    /**  récupére tout les bits de tout ces voisins, reste ensuite a  les regrouper en paquet, un par voisin*/
    val nasI: UintV = concatR(vois2) //si k = 4, on récupére 24 bits a la suite pour 6 voisins, chacun 4 bits,
    val Array(east,se,sw, west,nwest,neast)=splitInto6(nasI, k)
    /** Two in weakCmpProdtwo  means that if arg1 = arg2 we expand in both directions, going from a singleton to a tripleton */
    val (northmin, nwnw, nene) = weakCmpProdtwo(nwest, neast)
    val (southmin, swsw, sese) = weakCmpProdtwo(sw, se)
    val (horizMin, heast, hwest) = weakCmpProdZero(east, west) //here we cannot expand both east and west
    val (vertmin, nn, ss) = weakCmpProdZero(northmin, southmin)
    val (toto, vert, horiz) = weakCmpProdZero(vertmin, horizMin)
    val firstStage = Array(heast, sese, swsw, hwest, nwnw, nene) //peut y avoir plusieurs bit a 1. faudra refaire des "ET" logique
    val south = ss & vert
    val north = nn & vert
    val secondStage: Array[ASTLt[V, B]] = Array(horiz, south, south, horiz, north, north)
    /** a seulement un bits a 1 sauf pour etendre vers le haut ou  vers le bas, ou la ca marche sur deux bits. */
    val sextexInt: List[ASTLt[V, B]] = (0 to 5).map((i: Int) => {
      firstStage(i) & secondStage(i)
    }).toList
    /** represente un uint sur 6 bit qui est le code unaire d'un nombre compris entre 0 et 5, possiblement zero en cas de failure.
     * sur les 6, un seul est vrai ou deux adjacents. on peut "l'envoyer" avec send */
    //val success=sextexInt.reduce(_|_);show(success) //monitor if there is actual move.
    val sextex: ASTLt[T[V,E], B] = Send(sextexInt)
    Fundef1("compute.chooseMax"+k,sextex, vois2)
  }

  def chooseMaxOfMacro(k: Int,arg: ASTLt[T[V,E], UI]): BoolVe =
    new Call1(chooseMaxOfDef(k), arg) with BoolVe


  /**
   *  fonction that we are finally using. Elect the direction of max priority.
   * @param prio  priority
   * @param k number of bits. for exemple two  bits of priority plus two random bits, make four bits
   * @return
   */
  def chooseMaxOf(k:Int,voisins: UintVe): BoolVe={
    /**  contients les 6 voisins dans l'ordre clock: east,se,sw, west, nw,ne */
    //val voisins: UintVe = addSymUI(e(prio)).symUI
    /**  récupére tout les bits de tout ces voisins, reste ensuite a  les regrouper en paquet, un par voisin*/
    val nasI: UintV = concatR(voisins) //si k = 4, on récupére 24 bits a la suite pour 6 voisins, chacun 4 bits,

    val Array(east,se,sw, west,nwest,neast)=splitInto6(nasI, k)

    /** Two in weakCmpProdtwo  means that if arg1 = arg2 we expand in both directions, going from a singleton to a tripleton */
    val (northmin, nwnw, nene) = weakCmpProdtwo(nwest, neast)
    //  shoow(northmin,nwnw,nene)
    val (southmin, swsw, sese) = weakCmpProdtwo(sw, se)
    val (horizMin, heast, hwest) = weakCmpProdZero(east, west) //here we cannot expand both east and west
    val (vertmin, nn, ss) = weakCmpProdZero(northmin, southmin)

    val (toto, vert, horiz) = weakCmpProdZero(vertmin, horizMin)
   // a.shoow(east,se,sw, west,nwest,neast, northmin,southmin, vertmin,toto)
    //shoow(vert,horiz)
    val firstStage = Array(heast, sese, swsw, hwest, nwnw, nene) //peut y avoir plusieurs bit a 1. faudra refaire des "ET" logique
    val south = ss & vert
    val north = nn & vert
    val secondStage: Array[ASTLt[V, B]] = Array(horiz, south, south, horiz, north, north)
    /** a seulement un bits a 1 sauf pour etendre vers le haut ou  vers le bas, ou la ca marche sur deux bits. */
    val sextexInt: List[ASTLt[V, B]] = (0 to 5).map((i: Int) => {
      firstStage(i) & secondStage(i)
    }).toList
    /** represente un uint sur 6 bit qui est le code unaire d'un nombre compris entre 0 et 5, possiblement zero en cas de failure.
     * sur les 6, un seul est vrai ou deux adjacents. on peut "l'envoyer" avec send */
    //val success=sextexInt.reduce(_|_);show(success) //monitor if there is actual move.
    val sextex: BoolVe = send(sextexInt)
    sextex
  }

  def eltbis[L <: Locus, R <: I](i: Int, arg: ASTLt[L, R])(implicit m: repr[L], n: repr[R]): ASTLt[L, B] =
    unop(ASTBfun.elt(i), arg)

  val countIntOnNeighborsDef: Fundef1[(T[V,E], UI), (V,UI)] = {
    val n=pL[T[V,E], UI]("neighborUI") //the parametre.
    /** int of 6 * k bits*/
    val nasI: UintV = concatR(n)
    val (n0, n1, n2, n3, n4, n5) = (elt(0, nasI), elt(1, nasI), elt(2, nasI), elt(3, nasI), elt(4, nasI), elt(5, nasI))
    val n012: UintV = sum3V(n0 ,n1, n2); val n345: UintV = sum3V(n3 ,n4, n5)
    val sum6=binop(addtwo2to3UI,n012,n345) //bug a corriger
    Fundef1("compute.countIntOnNeighbors",sum6, n)
  }

  val impliqueDef: Fundef2[(V, B), (V, B), (V, B)] = {
    val a = pL[V, B]("a")
    val b = pL[V, B]("b")
    Fundef2("compute.implique", ~a | b, a, b)
  }
  def implique(b0: BoolV, b1: BoolV): BoolV = new Call2(impliqueDef, b0, b1)(repr.nomLR(repr.nomV, repr.nomB)) with BoolV

  def impluqDef[L<:Locus](implicit n:repr[L]): Fundef2[(L, B), (L, B), (L, B)] = {
    val a = pL[L, B]("a")
    val b = pL[L, B]("b")
    Fundef2("compute.impluq", ~a | b, a, b)
  }
  def impluq[L<:Locus](b0: ASTLt[L,B], b1: ASTLt[L,B])(implicit n:repr[L]): ASTLt[L,B]= new Call2(impluqDef, b0, b1) with ASTLt[L,B]

}