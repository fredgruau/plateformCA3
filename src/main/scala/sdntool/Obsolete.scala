package sdntool

import compiler.ASTL.{ASTLg, transfer}
import compiler.ASTLfun.{e, f}
import compiler.SpatialType.{BoolE, BoolF, BoolV, BoolVf}
import compiler.{ASTBfun, ASTLt, B, E, F, T, V}
import progOfmacros.Comm.{apexE, apexV, neighborsSym}
import progOfmacros.RedT.cac
import progOfmacros.Wrapper.{border, exist, existS, inside, insideS, shrink}
import sdn.Force.ciblerFaible
import sdn.Globals.root4naming
import sdn.{Attributs, MovableAgV,  carrySysInstr}

class Obsolete {

}

/** using toto, adds somme zlt info, and randomness in order to compute an accurate center, also able to penetrate */
trait addCenter {
  self: Qpoint with addDistVor with addSummit  with addBlobSummit with addZone => //on utilise prop.tripletonstreched
  val muuiis:BoolV with carrySysInstr =self.muis
  val ctr=new Attributs {
    override val muis: BoolV with carrySysInstr = muuiis
    /** true for rhombus  apexes wrongly occupied, i.e the seed does not occupy the zlt apex, */
    val rhombusWronglyOccupied=bsm.losangeApexes & (zon.zlt.muis | muis )  //le coté vide est celui proche de zonegt
    /** detect wrongly occupied on the rhombus middle edge */
    val rhombusShouldFlip=inside[F,E](apexE(f(rhombusWronglyOccupied)))
    /** true where wrongly occupied apex should be removed  */
    val rhombusApexToRemoveFromCtr: BoolV=bsm.losangeApexes & ~zon.zlt.muis & muis & exist[F, V](apexV(f(rhombusShouldFlip)))
    val raaand:BoolV= ~(~root4naming.addRandBit().asInstanceOf[BoolV])
    val raaand2:BoolV= root4naming.addRandBit().asInstanceOf[BoolV]
    val raaand3:BoolV= root4naming.addRandBit().asInstanceOf[BoolV]
    val tinyrand:BoolV=inside[E,V](neighborsSym( e(raaand)))
    val smallRand:BoolV= raaand & raaand2 & raaand3 //vrai avec trois chance sur quatre

    /** turns out to be too strong removal: when progressing towards zlt zone, we should not remove hyperstreched tripleton */
    val next2vor=  exist(neighborsSym(e(dgv.source.muis)))
    /** true if should be removed for allowing go closer to fire particle site, not sitting on zlt zone, but next to another particle on zlt zone,
     * should be removed from support, in order to allow progression towards zlt zone.
     * this removal, however, is subjected to randomization so that this progression happens at different pace, allowing  symetry breaking */
    def awayFromFire(initialCtr:BoolV)=initialCtr & ~zon.zlt.muis & exist[E,V](neighborsSym(e(initialCtr & zon.zlt.muis)))
    /** symetric case for zgt, true if should be removed to get closer to zlt */
    def awayFromZlt(initialCtr:BoolV)=initialCtr & zon.zgt.muis & exist[E,V](neighborsSym(e(initialCtr & ~zon.zgt.muis)))
    /** same but randomised */
    def closerToFireR(initialCtr:BoolV)= initialCtr & ~(awayFromFire(initialCtr)&raaand)
    def closerToFireSR(initialCtr:BoolV)= initialCtr &  ~(awayFromFire(initialCtr)&smallRand)
    def closerToZltSR(initialCtr:BoolV)= initialCtr & ~(awayFromZlt(initialCtr)&smallRand)
    // ~next2vor & //on restreint cela car si la seed touche le mur ca empeche de converger, ca devient instable
    qf.tripletonV //sans ca on trouve que le sommet contient bien un tripleton hyperstreched, mais la particule cependant n'est pas dans le tripleton.
    /** first approximation of center, includes not shadowed meetEV not blocking progression to zlt zone
     * raw doubleton and tripleton, and hyperstreched tripleton which do not need to flip orientation*/
    val ctr1=closerToFireR(bsm.meetiEnotShadowed) & closerToZltSR(bsm.meetiEnotShadowed) |
      closerToFireR(bsm.isLeton) |
      (closerToFireSR(bsm.nbcc3) & // on met une proba plus faible pour éviter des instabilité car NBCC3 est "strong"
        closerToZltSR(bsm.nbcc3) &   //nbcc3 is a subcase of meetEV, so we should also subject it to removalMeetEnotZltNextToMeetEonZlt
        ~rhombusApexToRemoveFromCtr  )
    val ctrNoZlt=bsm.meetiEVnotShadowed |   bsm.isLeton |   (bsm.nbcc3 & ~rhombusApexToRemoveFromCtr)

    /** we target identifying thin support toto.meetV at the "pointe of" zlt  zon.b.nbcc1  */
    val yetCloser=zon.bzlt.nbcc1 & bfs.bv.meetV
    /** detect when a particle is located between two higher radius particle which pulls it in oppositie direction */
    val ecartelee=forallize( zon.bzlt.meet & isV)
   /** if ecartelée,adopt a random move. */
    val ctr1bis=ctr1 & ((~yetCloser & ~ ecartelee )| raaand)
    /**  on etend le centre au voisin de meme rayon, pour compresser un peu la zone de rayon supérieur, sommet, */
    val exploreAwayZgt=  smallRand & ~zon.zgt.muis & sum.isSummit2&exist[E,V](neighborsSym(e(isV& zon.zgt.muis)))

    /** adds the possibility to directly move towards zlt, staying along the summit, randomized for symetry breaking */
    val ctr2=(ctr1bis | zon.zlt.muis  &  raaand | exploreAwayZgt)&sum.isSummit2
    /** was intended for restricting exploration of zon.zlt to agent already streching weakly in that direction, turned out to be to restrictive */
    val weakMeetE:BoolE=dgv.streched & insideS(sum.isSummit2) & existS(bsm.meetiV)
    /** seizeCenter etait la force qui marchait bien */
    val seizeCenter=ciblerFaible(ctr2)
    override def showMe: Unit = { shoow(tinyrand,ecartelee,ctr2,rhombusApexToRemoveFromCtr,
      rhombusShouldFlip,exploreAwayZgt)  }
  }
}

/** computes tripletonStreched which may still be usefull
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


