package simulator

import compiler.{Locus, V}
import triangulation.Vector2D

import scala.util.Random


trait Init {
  /**
   * fills the set of memory fields corresponding to a CA field, according to a given init wished for
   *
   * @param CAmemFields memory fields to fill
   */
  def init(CAmemFields: Array[Array[Int]]): Unit

}

/** for a medium, adds  the possibity of choosing an init */
trait InitSelect {
  self: Medium with encodeByInt=>   // Some inits are using encode

  /**
   *
   * @param initMethodName name of the init chosen
   * @param l              Locus of the layer to be initalized we do not need to pass a bit size, since integer field are usually initialized to zero
   * @param density how many point populate initial config
   * @return an  "Init" which can initialize a layer, because of lazy, this init is created once and then reused
   *         this is the only public method provided by the initSelect trait,
   */
  def initSelect(initMethodName: String, l: Locus, nbit: Int,density:Int, inverted:Boolean): Init = {
    initMethodName match {
      case "0" => zeroInit
      case "true" => unInit
      case "center" => centerInit
      case "blackHole" =>     blackHoleInit(density,inverted)
      case "cloud" =>     cloudInit(inverted)
      case "debug" => zeroInit
      case "sparse" => sparseInitInside(l, nbit)
      case "randinside" => randInitInside(l, nbit)
      case "def" => defInit(l) //here we must take into account the locus, we use a method instead of a lazy val in order to save space
      case "xaxis" => xaxisInit
      case "yaxis" => yaxisInit
      case "dottedBorder" => dottedBorderInit
      case "sym" => symInit

      case "grid" => gridInit
      case "border" => borderInit
      case "random" => randomInit
      case "false" => zeroInit
    }
  }
  /** Random number generator each medium has its copy */
  private var  rand:Random =null
  def initRandom(r:Int):Unit={
    val seed = new Random(env.controller.randomRoot.toLong).nextLong()
    rand = new Random(seed)
  }
  //geometric primitive fields used to construct initial configurations
  private val origin = new Vector2D(0, 0)
  private val center = new Vector2D(nbLine / 2, nbCol / 2)

  /** different possible inits, non static fields of the medium class, because they use data from the mediium
   * be it only the number of lines and columns.
   * declared with lazy to spare memory, since only one or two will be instanciated
   * make use of primitives fields declared in medium to simplify the programming
   * todo  there is a pb in that we need different init field, in case of random init.=> no val
   *
   * contains material for creating "Init" object which can initialize a layer
   * sub class of medium because for amorphous medium we will need to access the topology of the medium
   *
   * @param locus locus of field being initialized
   * @param nbit  equals to 1 now, could be allowed to become >1 if we make Init for integer layer.
   */

  private lazy val yaxisInit: InitMaald = new InitMaald(1) {
    for (i <- 0 until nbLine) setBoolVField(i, 0)
  }
  private lazy val xaxisInit: InitMaald = new InitMaald(1) {
    for (j <- 0 until nbCol) setBoolVField(0, j)
  }
  private lazy val
  zeroInit: InitMaald = new InitMaald(1) {} //nothing to do, the boolV field would be zero by default.
  private lazy val unInit: InitMaald = new InitMaald(1) {
    for (i <- 2 until nbLine - 2) {
      val (j0, j1) = if (i % 2 == 0) (2, nbCol - 1) else (1, nbCol - 2)
      for (j <- j0 until j1) {
        boolVField(i)(j) = true

      }
    }
  } //n
  private lazy val dottedBorderInit: InitMold = new InitMold(V(), 1) {
    for (i <- 0 until nbLine) if (i % 2 == 0) {
      setBoolVField(i, 0);
      setBoolVField(i, nbCol - 1)
    }
    for (i <- 0 until nbCol) if (i % 2 == 0) {
      setBoolVField(0, i);
      setBoolVField(nbLine - 1, i)
    }
  }
  private lazy val borderInit: InitMaald = new InitMaald(1) {
    for (i <- 0 until nbLine) {
      setBoolVField(i, 0);if(i%2==1) setBoolVField(i, nbCol - 3)
      setBoolVField(i, 1); setBoolVField(i, nbCol - 2)
    }
    for (i <- 0 until nbCol) {
      setBoolVField(0, i); setBoolVField(nbLine - 1, i)
      setBoolVField(1, i); setBoolVField(nbLine - 2, i)
    }
  }
  private lazy val symInit: InitMaald = new InitMaald(1) {
    setBoolVField(nbLine/2, 1); setBoolVField(nbLine/2, nbCol - 2)
    setBoolVField(1, nbCol/2); setBoolVField(nbLine - 2 , nbCol/2)
  }
  private lazy val gridInit: InitMaald = new InitMaald(1) {
    for (i <- 0 to (nbLine-1)/3)
      for (j <- 0 to (nbCol-1)/3)
         setBoolVField(i*3,j*3)
  }
  private lazy val randomInit: InitMold = new InitMold(V(), 1) {
    override def init(CAmemFields: Array[Array[Int]]): Unit = { // init is redefined becase instead of encode, we directly write into the CA
      for (lCAmem: Array[Int] <- CAmemFields) { //dot iteration, we iterate on the dot product of the two ranges
        for (i <- 0 until lCAmem.size) lCAmem(i) = rand.nextInt()
      }
    }
  }

  /** the def fields have to be generated for each locus. Hence, it is computed on the fly, in order to save memory */
  private def defInit(l: Locus): Init = new InitMold(l, 1) {
    for (d <- 0 until l.density)
      for (i <- 0 until nbLine) {
        for (j <- 0 until nbCol)
          if (locusPlane(l)(d)(i)(j).isDefined)
            setMemField(d, i, j)
      }
  }

  /** does a random init covering only cells which will not be mirored */
  private def randInitInside(l: Locus, nbit: Int): Init = new InitMold(l, nbit) {
    for (f <- memFields)
      for (i <- 2 until nbLine - 2) {
        val (j0, j1) = if (i % 2 == 0) (2, nbCol - 1) else (1, nbCol - 2)
        for (j <- j0 until j1) {
          if (rand.nextFloat() < 0.6) //locusPlane(l)(d)(i)(j).isDefined)
            f(i)(j) = true
        }
        //setMemField(f, i, j)
      }
  }

  /** does a sparse init covering only cells which will not be mirored */
  private def sparseInitInside(l: Locus, nbit: Int): Init = new InitMold(l, nbit) {
    for (f <- memFields)
      for (i <- 2 until nbLine - 2) {
        val (j0, j1) = if (i % 2 == 0) (2, nbCol - 1) else (1, nbCol - 2)
        for (j <- j0 until j1) {
          if (rand.nextFloat() < 0.06) //locusPlane(l)(d)(i)(j).isDefined)
            f(i)(j) = true
        }
        //setMemField(f, i, j)
      }
  }

  /** contains material, a big array of booleans,  used for InitMaald */
  trait BoolVField {
    /** represent the initial value of a boolV field */
    val boolVField: Array[Array[Boolean]] = Array.ofDim[Boolean](nbLine, nbCol)

    /**
     * @param p a point within the medium
     *          initialize the corresponding value of the boolVfield
     */
    def setBoolVField(p: Vector2D): Unit = setBoolVField(p.x.toInt, p.y.toInt)

    def setBoolVField(i: Int, j: Int): Unit =
      boolVField(i)(j) = true
    def flipBoolVField(i: Int, j: Int): Unit =
      boolVField(i)(j) = !boolVField(i)(j)



  import scala.util.Random

  def remplirSansContact(n: Int ): Unit = {
    val  maxEssais: Int = 100
    val nbLine = boolVField.length
    val nbCol = if (nbLine == 0) 0 else boolVField(0).length

    require(boolVField.forall(_.length == nbCol),
      "Le tableau doit être rectangulaire")
    val nbCasesInterieures =
      math.max(0, nbLine - 2).toLong * math.max(0, nbCol - 2)

    require(n >= 0 && n.toLong <= nbCasesInterieures,
      "Nombre de particules supérieur au nombre de cases intérieures")

    require(maxEssais > 0, "maxEssais doit être positif")

    def vider(): Unit =
      boolVField.foreach(ligne =>
        java.util.Arrays.fill(ligne, false)
      )

    def libre(l: Int, c: Int): Boolean = {
      // Sur une ligne impaire, les voisins des lignes adjacentes
      // sont aux colonnes c et c+1 ; sinon, c-1 et c.
      val decalage = if (l % 2 == 0) -1 else 1

      val voisins = Array(
        (l,     c - 1),
        (l,     c + 1),
        (l - 1, c),
        (l - 1, c + decalage),
        (l + 1, c),
        (l + 1, c + decalage)
      )

      !boolVField(l)(c) && voisins.forall { case (lv, cv) =>
        lv < 0 || lv >= nbLine ||
          cv < 0 || cv >= nbCol ||
          !boolVField(lv)(cv)
      }
    }

    val cases = (for {
      l <- 2 until (nbLine - 2)
      c <- 2 until (nbCol - 2)
    } yield (l, c)).toVector

    vider()
    if (n == 0) return

    for (_ <- 0 until maxEssais) {
      vider()
      var places = 0

      // Chaque case est testée une seule fois, dans un ordre aléatoire.
      val candidats = rand.shuffle(cases).iterator

      while (candidats.hasNext && places < n) {
        val (l, c) = candidats.next()

        if (libre(l, c)) {
          boolVField(l)(c) = true
          places += 1
        }
      }
      if (places == n) return
    }
    vider()
    throw new IllegalStateException(
      s"Impossible de placer $n particules après $maxEssais essais."
    )
  }

  }



  /** initalize all the scalar component of a locus in the same way */
  private class InitMaald(val nbit: Int) extends Init with BoolVField {
    assert(nbit == 1, "InitMaald initialize only boolean fields")

    /** fills the set of memory fields corresponding to a CA field, according to a given init wished for
     *
     * @param CAmemFields memory fields to fill
     */
    override def init(CAmemFields: Array[Array[Int]]): Unit = {
      for (lCAmem: Array[Int] <- CAmemFields) { //dot iteration, we iterate on the dot product of the two ranges
        encode(boolVField, lCAmem)
      }
    }
  }

  private class InitMold(val locus: Locus, val nbit: Int) extends Init {
    /** use as a tmp list of bool arrays], to more  easily computes the initial values */
    val memFields: Array[Array[Array[Boolean]]] = Array.ofDim[Boolean](locus.density * nbit, nbLine, nbCol)
    /** simplification for the common case which is a boolV field */
    val boolVField: Array[Array[Boolean]] = if (locus == V()) memFields(0) else null

    /**
     * @param CAmemFields memory fields to fill
     *                    fills the set of memory fields corresponding to a CA field, according to a given already computed,  init wished for
     */
    override def init(CAmemFields: Array[Array[Int]]): Unit = {
      assert(CAmemFields.length == memFields.length, "count of CA bit planes does not corresponds " + CAmemFields.length + " " + memFields.length)
      for ((lCA, lCAmem: Array[Int]) <- memFields zip CAmemFields) { //dot iteration, we iterate on the dot product of the two ranges
        encode(lCA, lCAmem)
      }
    }

    def setMemField(d: Int, i: Int, j: Int): Unit = memFields(d)(i)(j) = true

    def setAllMemField(i: Int, j: Int): Unit = {
      for (f <- memFields)
        f(i)(j) = true
    }

    /**
     *
     * @param p a point within the medium
     * @return set the corresponding value of the boolVfield being initialized
     */
    def setAllMemField(p: Vector2D): Unit = setAllMemField(p.x.toInt, p.y.toInt)

    /**
     *
     * @param p a point within the medium
     * @return set the corresponding value of the boolVfield being initialized
     */
    def setBoolVField(p: Vector2D): Unit = setBoolVField(p.x.toInt, p.y.toInt)

    def setBoolVField(i: Int, j: Int): Unit = boolVField(i)(j) = true


  }

  private lazy val centerInit: InitMaald = new InitMaald(1) {
    setBoolVField(center)
  }

  /**
   *
   * @param density nombre de point crées
   * @return creates a blackhole, i.e a rectangle of nearby points
   */
  private def cloudInit(inverted:Boolean): InitMaald = new InitMaald(1) {
     initRandom(env.controller.randomRoot)
    val max=env.densityMax(nbCol, nbLine)
    val maxln2 = rand.between(1.0, math.log(max) / math.log(2))
    val n: Int = math.pow(2, maxln2).toInt
    env.density=n
     remplirSansContact(n)
    if(inverted)
      for(i<-0 until nbLine)
        for(j<-0 until  nbCol)
          flipBoolVField(i,j)

  }
  /**
   *
   * @param density nombre de point crées
   * @return creates a blackhole, i.e a rectangle of nearby points
   */
  private def blackHoleInit(density:Int,inverted:Boolean): InitMaald = new InitMaald(1) {
    val upperleft=new Vector2D(2, 2)
    val deltaY=3//nbCol/3 -4
    val deltaX=3// nbLine/3 -4
    /** nombre de point par ligne */
    val numColUsable=(nbCol-3)/3  //faudra faire fois 3  + 3
    val numLineUsable=(nbLine-3)/3  //faudra faire fois 3  +3
    var k=0
    var maxSquareSize=Math.min(numColUsable,numLineUsable)
    while (maxSquareSize*maxSquareSize>density)
    {maxSquareSize-=1}
    val numLineUsed=maxSquareSize
    var numColUsed=maxSquareSize
    //case landscape grid nbColUsable> nbLineUsable
    while(numColUsed*numLineUsed<density &&  numColUsed<numColUsable-1)
    {numColUsed+=1}

    for(i<-0 to numLineUsable)
      for(j<-0 to numColUsed) {
        if (k < density )
          setBoolVField(upperleft.add(new Vector2D(i * deltaX, j * deltaY)))
        k=k+1
      }
    if (inverted)
      for(i<-0 until nbLine)
        for(j<-0 until  nbCol)
          flipBoolVField(i,j)

  }
}
