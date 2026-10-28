package simulator

import compiler.ASTB.False
import compiler.Locus.locusV
import compiler.{Locus, V}
import dataStruc.Util.{deepCopyArray, isEqualto, isMiror, lastSegment, printMat, stats}
import simulator.CAtype.pointLines
import simulator.Medium.christal
import simulator.Util.{copyBasic, toInts}
import triangulation.Utility.halve

import scala.collection.JavaConverters._
import java.awt.Color
import java.lang.Thread.sleep
import java.util.concurrent.atomic.AtomicBoolean
import scala.collection.convert.ImplicitConversions.{`map AsScala`, `seq AsJavaList`}
import scala.collection.immutable.{HashMap, HashSet}
import scala.collection.{immutable, mutable}
import scala.swing._
import scala.util.Random

/**
 * contains all the information needed to run a given CA.
 *
 * @param nbCol  number of column in the CA grid
 * @param nbLine number of lines in the CA grid
 * @param controller the controller contians information valid for all the environment
 * @param initName   init method for root layer, which can vary
 * @param randomRoot so that we can reproduce same list of random numbers
 */
class Env(arch: String, nbLine: Int, nbCol: Int, val controller: Controller, initName: HashMap[String, String],val t0:Int) {
  @volatile private var currentInnerRadius: Int = -1
  @volatile private var  lastInnerRadius: Int = -1
  @volatile private var  lastlastInnerRadius: Int = -1
  /** time needed to reach a small variance */
  @volatile private var tSigmaSmall: Int= -1
  /** time needed to reach uniformization of inner radius*/
  @volatile private var tUniform: Int= -1
  /** current time */
  var t = -1 //incoherent value, should be initialized

  @volatile private var threadRunning = false
  @volatile private var stopRequested = false

  @volatile var bugFound = false
  @volatile var noneAlive = false
  @volatile private var workerThread: Thread = null

  var density: Int = controller.densityInitial

  def isThreadRunning: Boolean = threadRunning

  def requestStop(): Unit = {  stopRequested = true }
  val medium: Medium with encodeByInt with InitSelect = arch match {
    case "christal" => christal(this,nbLine, nbCol, controller.CAwidth) //default medium is christal
  }
  /** Random number generator each medium has its copy */
  medium.initRandom(controller.randomRoot)
  /** Memory of the CA, it is being rewritten by the running thread, not touched if being displayed
   * we add 1 to the column size  medium.nbInt32CAmem +1 so as to avoid catching ArrayIndexOutOfBoundsException
   * when  we write at i+1 instead of i, (we do that in order to avoid memorizing register introduced for tm1s, and save local memory */
  val mem: Array[Array[Int]] = Array.ofDim[Int](controller.progCA.CAmemWidth(), medium.nbInt32total)
  /** for now we cache only memory config */
  val cache=new dataStruc.Cache[Array[Array[Int]]]
  /** associated pannel */
  var caPannel: CApannel = null //to be set latter due to mutual recursive definitionaahjhjhhhh
  /** usefull info on the run displayed above the CQA  */
  val iterationLabel = new Label(s"t=$t density=$density")
  //init() // this initialization is to be called after creation, because pannes cannot be set at creation
  // at runtime, when the user restarts the whole simulation from the restart button

  /**
   * The memory is set back to virgin
   */
  private def resetMem(): Unit =
    for (bitPlane <- mem)
      for (i <- 0 until bitPlane.length)
        bitPlane(i) = 0;
  /** visit all layers that should be initialized directly,  and init the layers using the designated initMethod */
  private def initMemCA(): Unit = {
    //for (layerName: String <- controller.progCA.directInit()) {
    resetMem()
    //val toto=controller.progCA.init().keys
    for (layerName: String <- controller.progCA.init().keys) { //iterate over the layers to be initalized
      /** fields layerName's components */
      val memFields2Init: Seq[Array[Int]] = memFields(layerName) //gets the memory plane
      val initNameFinal = initName.getOrElse(layerName, controller.initName(layerName)) //either it is the root layer or we find it in env
      val finalInitMethodName: String = if (initNameFinal.startsWith(  "global")) controller.globalInitList.selection.item //currently selected init method
      else initNameFinal
      /** if true, negate the ini */
      val inverted=initNameFinal.startsWith(  "globalInv")
      val initMethod: Init = medium.initSelect(finalInitMethodName,
        controller.locusOfDisplayedOrDirectInitField(layerName), // locus is passed. It is used in def/center/yaxis
        controller.bitSizeDisplayedOrDirectInitField.getOrElse(layerName, 1),
        density ,inverted     ) // bitsize  is passed.
      initMethod.init(memFields2Init.toArray)
      val u=0
    }
  }
  /** applies a miror on the initial values of layers */
  def initMiror(): Unit = {
    for (layerName: String <- controller.progCA.init().keys) {
      val memFields2Init: Seq[Array[Int]] = memFields(layerName)
      for (memoryPlane <- memFields2Init) {
        val p = medium.propagate4Shift
        val locus = controller.locusOfDisplayedOrDirectInitField(layerName)
        if(locus == compiler.Locus.locusV && ! layerName.startsWith("lldef")) //lldef are used to detect bugs, therefore they should not undergo preparebits.
        {   p.mirror(memoryPlane)
          p.prepareBit(memoryPlane)}
        val testMiror = false //to be set to true if you want to test miror
        if (locus == locusV && testMiror) {
          val matBool = Array.ofDim[Boolean](nbLine, nbCol)
          medium.decode(memoryPlane, matBool)
          if (!isMiror(matBool)) throw new Exception("pas is miror dans init env")
        }
      }
    }
  }
  private val caLock = new AnyRef

  def init(): Unit = caLock.synchronized {
    medium.initRandom(controller.randomRoot) //we reinitialize the random number in order to reproduce exactly the same random sequence
    // medium.middleClosure(controller.currentProximityLocus)  //alternative way of building quickly voronoi.
    //controller.progCA.copyLayer(mem) plus besoin pisque je fais un forward
    if (medium.theVoronois.isEmpty)
      medium.voronoise(controller.displayedLocus, controller.currentProximityLocus) //we have to compute the voronoi upon medium's creation
    initMemCA() //invariant stipulates that memory should be filled so we fill it already right when we create it
    // System.out.println( medium.pointSet(V()).size)
    initMiror()
    t= -1
    tSigmaSmall = -1
    tUniform= -1
    currentInnerRadius = -1
    cache.reset()
    forward() //we do one forward, so as to be able to show the fields.
    for (_ <- 1 until t0) //forward till to
      forward()
    medium.resetColorTextVoronoi(controller.displayedLocus)
    computeStatistics()
    computeVoronoirColors() // for the initial painting
  }

  /**
   *
   * @param fieldName name of a field that we want to read in CA memory
   * @return a list of array of Int32  storing the  field components
   */
  def memFields(fieldName: String): List[Array[Int]] =
    controller.memFieldsOffset(fieldName).map(mem(_))
  /** we create that array once and forall to decode memory bit planes */
  private val bitPlaneBuffer: Array[Array[Boolean]] = Array.ofDim[Boolean](nbLine, nbCol)
  private val bitPlaneBufferIsDef: Array[Array[Boolean]] = Array.ofDim[Boolean](nbLine, nbCol)
  /**
   * sum to the colors of locus l, the contribution of bitplanes
   * which can represent a boolean field
   *
   * @param locus     locus where new colors are to be summed
   * @param color     color to be summed
   * @param bitPlanes whether it should be summed
   */
  private def sumColorVoronoi(locus: Locus, color: Color, bitPlanes: List[Array[Int]]): Unit = {
    assert (bitPlanes.size == medium.locusPlane(locus).length, "number of bit planes should be locus density")
    for ((plane, points) <- bitPlanes zip medium.locusPlane(locus)) { //we do a dot iteration simultaneously on pointsPlane, and bitPlane
      //   decodeInterleavRot(nbLineCA, nbColCA, plane, sandBox) //we convert the compact encoding on Int32, into simple booleans
      medium.decode(plane, bitPlaneBuffer) //we convert the compact encoding on Int32, into simple booleans
      medium.sumColorVoronoi(color,bitPlaneBuffer, points, controller.darkness)
    }
  }
  /** computes the index of the text that should be displayed  if defined*/
  private def sumInt32VoronoiPartial(locus: Locus, bitPlanesIsdefined: List[Array[Int]], bitPlanesValue: List[Array[Int]]): Unit = {
    assert (bitPlanesValue.size == medium.locusPlane(locus).length, "number of bit planes for values should be locus density")
    assert (bitPlanesIsdefined.size == medium.locusPlane(locus).length, "number of bit planes for is defined should be locus density")
    bitPlanesIsdefined.zip (bitPlanesValue). zip (medium.locusPlane(locus)) .foreach{
      case((isDefinedPlane,valuePlane),points)=>
        //we do a dot iteration simultaneously on pointsPlane, and bitPlane
        //   decodeInterleavRot(nbLineCA, nbColCA, plane, sandBox) //we convert the compact encoding on Int32, into simple booleans
        medium.decode(valuePlane, bitPlaneBuffer) //we convert the compact encoding on Int32, into simple booleans
        medium.decode(isDefinedPlane, bitPlaneBufferIsDef)
        medium.sumBitVoronoiPartial(bitPlaneBufferIsDef,bitPlaneBuffer, points)
    }
  }

  /** computes the index of the text that should be displayed */
  private def sumInt32Voronoi(locus: Locus, bitPlanes: List[Array[Int]]): Unit = {
    assert (bitPlanes.size == medium.locusPlane(locus).length, "number of bit planes should be locus density")
    for ((plane: Array[Int], points: pointLines) <- bitPlanes zip medium.locusPlane(locus)) { //we do a dot iteration simultaneously on pointsPlane, and bitPlane
      //   decodeInterleavRot(nbLineCA, nbColCA, plane, sandBox) //we convert the compact encoding on Int32, into simple booleans
      medium.decode(plane, bitPlaneBuffer) //we convert the compact encoding on Int32, into simple booleans
      medium.sumBitVoronoi(bitPlaneBuffer, points)
    }
  }

  /** computes the text associated to an int32 on each voronoi */
  private def textify(locus: Locus, ls:List[String]): Unit = {
    for (points <- medium.locusPlane(locus))   medium.textify( points,ls)
  }

  /** iterate through all the layers to be displayed */
  private def computeVoronoirColors(): Unit = {
    medium.resetColorTextVoronoi(controller.displayedLocus) //hyper important, poil au dents
    for ((layerName, color) <- controller.colorDisplayedField) { //process fiedls to be displayed, one by one
      val locus: Locus = controller.locusOfDisplayedOrDirectInitField(layerName)
      val bitSize: Int = controller.bitSizeDisplayedOrDirectInitField.getOrElse(layerName, 1) //default bitsize is one, for boolean
      /** 1D array of  integers reprensenting the fields */
      val bitPlane: Array[Array[Int]] = memFields(layerName).toArray
      val density = locus.density * bitSize
      /** if we display an int, then color associated to the field shoudl be halved */
      var colorAjusted: Color = if (bitSize > 1) halve(color) else color //if we print int, we have to make a sum of colors, so we first take halve
      assert(density == bitPlane.size, "the number of bit plane should be equal to the field's density")
      for (i <- (0 until bitSize).reverse) { //loops over the bits of integers reverse so that bit 0 gets smallest color
        //we decompose an int into its  bits, first bit are strongest bit
        /** bitiof locus's arity is locus density */
        val bitiOfLocus: List[Array[Int]] = (0 until locus.density).map(j => bitPlane(i + j * bitSize)).toList

        if(controller.displayedAsText.contains(layerName))   sumInt32Voronoi(locus,  bitiOfLocus) //genere and int 32 bits on each voronoi
        else sumColorVoronoi(locus, colorAjusted, bitiOfLocus) // on est ramené au cas d'afficher un  boolV
        colorAjusted = halve(colorAjusted)// on divise par deux pour arriver au bit de point moins fort.
      }
      //for text we have to compute a string on each voronoi, the default case uses a list of string
      if(controller.textOfFields.contains(layerName))
        textify(locus,controller.textOfFields(layerName))
    }
  }

  /**
   *
   * @param locus locus where statistics are gathered
   * @param bitPlanesIsdefined bitplane where to read wether partial int is defined
   * @return
   */
  private def statistics(locus: Locus, bitPlanesIsdefined: List[Array[Int]]):List[Int] = {
    var result:List[Int]=List()
    assert (bitPlanesIsdefined.size == medium.locusPlane(locus).length, "number of bit planes for is defined should be locus density")
    bitPlanesIsdefined.zip (medium.locusPlane(locus)).foreach{
      case(isDefinedPlane,points)=>
        //we do a dot iteration simultaneously on pointsPlane, and bitPlane
        //   decodeInterleavRot(nbLineCA, nbColCA, plane, sandBox) //we convert the compact encoding on Int32, into simple booleans
        medium.decode(isDefinedPlane, bitPlaneBufferIsDef)
        result=medium.statistics(bitPlaneBufferIsDef, points):::result
    }
    result
  }

  @volatile private var lastStatText = ""

  /**
   * iterate through all the layers for which we should compute statistics
   * does some computation to check wether variance of area is reduced.
   * @return true if radius is uniformized
   */
  def computeStatistics():Boolean = {
    var text = ""
    var uniformized = false
    var sigmaSmall = false
    /** returns a list of integers representing a partially defined Int */
    def integers(valueDefined: String): List[Int] = {
      medium.resetColorTextVoronoi(controller.displayedLocus)
      val leaderMuis = controller.partial(valueDefined)
      val namesState = lastSegment(valueDefined) //gets the name associated
      val locusDefined: Locus = controller.locusOfDisplayedOrDirectInitField(leaderMuis)
      val locusValue: Locus = controller.locusOfDisplayedOrDirectInitField(valueDefined)
      assert(locusValue == locusDefined) //tout les deux des boolV
      val bitSizeInt: Int = controller.bitSizeDisplayedOrDirectInitField.getOrElse(valueDefined, 1) //default bitsize is one, for boolean
      /** 1D array of  integers reprensenting the fields */
      val bitPlaneIsDefined: Array[Array[Int]] = memFields(leaderMuis).toArray
      val bitPlaneValue: Array[Array[Int]] = memFields(valueDefined).toArray
      val density = locusDefined.density * bitSizeInt
      assert(density == bitPlaneValue.size, "the number of bit plane should be equal to the field's density")
      val bitIsDefined: List[Array[Int]] = (0 until locusDefined.density).map(j => bitPlaneIsDefined(j)).toList
      for (i <- (0 until bitSizeInt).reverse) { //loops over the bits of integers reverse so that bit 0 gets smallest color
        //we decompose an int into its  bits, first bit are strongest bit
        /** bitiof locus's arity is locus density */
        val bitiOfValue: List[Array[Int]] = (0 until locusDefined.density).map(j => bitPlaneValue(i + j * bitSizeInt)).toList
        //we generate an int32, but only if defined
        sumInt32VoronoiPartial(locusDefined, bitIsDefined, bitiOfValue) //genere and int 32 bits on each voronoi if defined
      }
      statistics(locusDefined, bitIsDefined)
    }
    val (meanAr, stdNormAr, minValAr, maxValAr)=stats(integers("homogeneizePartArTotal"))  //statistics on voronoi area
    val (meanRi, stdNormRi, minValRi, maxValRi)=stats(integers("homogeneizePartRiMuis"))   //statistics on inner radius
    val efficacity=minValAr/maxValAr
    text += " Area:" +f"stdev:$stdNormAr%.2f"+" moy:"+ f"$meanAr%.1f" +  " " +minValAr+"<"+maxValAr+f"eff$efficacity%.2f"
    text+=" Ri: "+f"stdev: $stdNormRi%.2f"+" moy:"+ f"$meanRi%.1f "+minValRi+"<"+maxValRi
      if(stdNormAr<0.2 && tSigmaSmall<0 /*&& stdNormRi <0.2 */&& t>50)    tSigmaSmall=t;
    uniformized=(minValRi==maxValRi)
    if (uniformized)       currentInnerRadius = minValRi
     lastStatText = text
    uniformized
      }

  def computeStatisticsOld():Boolean = {
    var text=""
    var uniformized=false
    var sigmaSmall=false
    for (valueDefined: String <- controller.partial.keys) { //process fiedls to be displayed, one by one we do all the stat
      medium.resetColorTextVoronoi(controller.displayedLocus)
      val leaderMuis=controller.partial(valueDefined)  //gets the booV where partial value is defined
       val namesState = lastSegment(valueDefined) //gets the name associated
      val locusDefined: Locus = controller.locusOfDisplayedOrDirectInitField(leaderMuis)
      val locusValue : Locus = controller.locusOfDisplayedOrDirectInitField(valueDefined)
      assert(locusValue==locusDefined)  //tout les deux des boolV
      val bitSizeInt: Int = controller.bitSizeDisplayedOrDirectInitField.getOrElse(valueDefined, 1) //default bitsize is one, for boolean
      /** 1D array of  integers reprensenting the fields */
      val bitPlaneIsDefined: Array[Array[Int]] = memFields(leaderMuis).toArray
      val bitPlaneValue: Array[Array[Int]] = memFields(valueDefined).toArray
      val density = locusDefined.density * bitSizeInt
      /** if we display an int, then color associated to the field shoudl be halved */
      //var colorAjusted: Color = if (bitSize > 1) halve(color) else color //if we print int, we have to make a sum of colors, so we first take halve
      assert(density == bitPlaneValue.size, "the number of bit plane should be equal to the field's density")
      val bitIsDefined: List[Array[Int]]= (0 until locusDefined.density).map(j => bitPlaneIsDefined(j )).toList
      for (i <- (0 until bitSizeInt).reverse) { //loops over the bits of integers reverse so that bit 0 gets smallest color
        //we decompose an int into its  bits, first bit are strongest bit
        /** bitiof locus's arity is locus density */
        val bitiOfValue: List[Array[Int]] = (0 until locusDefined.density).map(j => bitPlaneValue(i + j * bitSizeInt)).toList
        //we generate an int32, but only if defined
        sumInt32VoronoiPartial(locusDefined,bitIsDefined,  bitiOfValue) //genere and int 32 bits on each voronoi if defined
      }
      /** computes the text associated to an int32 on each voronoi */
      val integers: List[Int] =statistics(locusDefined, bitIsDefined)
     //println(integers)
      if(integers.nonEmpty)
      {
        val (mean, stdNorm, minVal, maxVal)=stats(integers)
        if(namesState.startsWith("Total")) //il s'agit de l'aire de la case voronoi
        { val efficacity=minVal/maxVal
          text += " Area:" +f"stdev$stdNorm%.2f"+" moy:"+ f"$mean%.1f" +  " " +minVal+"<"+maxVal+f"eff$efficacity%.2f"
          if(stdNorm<0.2 && tSigmaSmall<0 && t>50)
          { tSigmaSmall=t;
            //println(f"density=$density t=$t stdNorm=$stdNorm%.8f")
          }
        }

        else if(namesState.startsWith("Muis")) //il s'agit du rayon  de la case voronoi
      //  if(lastSegment(leaderMuis)=="Meet") { //global assesmentt
          //uniformized=(stdNorm *10 < 2 && stdNorm > 0.01  )
        { text+=" Ri: "+f"stdev$stdNorm%.2f"+" moy:"+ f"$mean%.1f"+minVal+"<"+maxVal
          uniformized=(minVal==maxVal)
        }
        if (uniformized)
          currentInnerRadius = minVal
       //a present je calcule deux courbes: small, smallp2
       //val (s,sp2)=smallp2(integers)        smalls=s::smalls        smallp2s=sp2::smallp2s        val first=smalls.take(50)        val moy=first.sum/first.size.toDouble
       // System.out.println( f"$s%.2f"+"   "+f"$moy%.2f")
      }
      lastStatText = text// //    caPannel.updateStat(text) //on veut deux décimale sur standard deviation

    }
    uniformized // the inner radius is the same everywhere
    //at this stage, the int32 where is defined is true, are set we can collect the values in a list, and then compute statistics
  }

  def stopAndWait(): Unit = {
    stopRequested = true
    val thread = workerThread
    if (thread != null && thread != Thread.currentThread()) {
      thread.join()
    }
  }


def densityMax(nbCol: Int, nbLine: Int): Int = {
    // même calcul de numLineUsed / numColUsed...
    val r=Math.min( nbLine, nbCol)/3
    r*(r+1)+2
  }


  private def unitIncrease=Math.max(1,Math.round( densityMax(nbCol, nbLine)/100))

  /** contains a thread which iterates the CA, while not asked to pause */
  def play(fwd: Boolean): Unit = synchronized {
    /** after this time, we stop the thread automatically */
      var missedUniformed=0;  var missedSigmaSmall=0;  var nbtrial=0;  var sommeTuniform=0;  var sommeTsigmasmall=0
    def timeout=t>nbCol*nbLine*5
    def sigmaSmallfound=tSigmaSmall!= -1

    if (isThreadRunning)    return
    stopRequested = false
    threadRunning = true
    val thread = new Thread {
      var timeSinceNonalive = 0
      var timeWhileRiuniformized=0
      def innerRadiusUniformized= timeWhileRiuniformized >= 20  //je met 20 au lieu de 100
      def enoughRelaxing: Boolean = (sigmaSmallfound  && innerRadiusUniformized  ) | timeout
      override def run(): Unit = {
        bugFound = false
        noneAlive = false
        var iterationsSinceDisplay = 0
        var convergenceSansRiUniformized = false
        var riUniformized = false
        try {
          tSigmaSmall= -1
          while ( //itére sur les densité
            !stopRequested &&
              !bugFound &&
              !convergenceSansRiUniformized &&
              ((density <= densityMax(nbCol, nbLine) && fwd) || !fwd) &&
              (lastlastInnerRadius!=0 || density< (nbCol*nbLine)/20) //on peut avoir le radius qui vaut 0 a cause d'un modulo, ici, on veut le rayon O pour de vrai, pas modulo
          ) {
2
            var nbIter = 0
            val nbLoops = math.pow(2, controller.speedSlider.value)
            /*
         * On ne rafraîchit jamais plus souvent
         * que toutes les 16 itérations.
         */
            val displayEvery =   math.max(2, nbLoops)
            val goesToConverged= false && nbLoops>= 512 //we never go directly to converged, we want to follow what's going on.
            val iterateThroughDensity= (nbLoops>= 1024 | true)//for the moment we iterate allways

            //itére un paquet de forward
            while (
              !stopRequested &&
                !bugFound &&
                !convergenceSansRiUniformized &&
                !enoughRelaxing &&
                (nbIter < nbLoops || goesToConverged)
            ) {
              if (fwd) { riUniformized = forward()
                if (noneAlive)   timeSinceNonalive += 1
                else     timeSinceNonalive = 0
                if(riUniformized) timeWhileRiuniformized+=1
                else timeWhileRiuniformized=0
                if(timeWhileRiuniformized >= 20 && tUniform== -1 )
                { tUniform=t-timeWhileRiuniformized
                }
              } else { backward(1)   }
              nbIter += 1
              iterationsSinceDisplay += 1
            }
            if (iterationsSinceDisplay >= displayEvery) {repaint(); sleep(20); iterationsSinceDisplay = 0   } //Affichage beaucoup moins fréquent.
            if ( fwd &&  enoughRelaxing &&  !bugFound && !stopRequested )
            { if ( iterateThroughDensity) {
                val convergenceIteration = t - 20
                ConvergenceLogger.append( nbLine,  nbCol,   density, tUniform /*convergenceIteration*/, currentInnerRadius, controller.randomRoot, tSigmaSmall)
              lastlastInnerRadius=lastInnerRadius
               lastInnerRadius=currentInnerRadius

              nbtrial+=1
              if(tUniform== -1)missedUniformed+=1 else sommeTuniform+= tUniform-20
              if(tSigmaSmall== -1)missedSigmaSmall+=1 else sommeTsigmasmall+=tSigmaSmall
              println("density" + density +" tUniformMoy:" +  sommeTuniform/(nbtrial-missedUniformed) + " missedUniform:"+missedUniformed+
                " tSigmasmallMoy:" +  sommeTsigmasmall/(nbtrial-missedSigmaSmall) + " missedSigmalsmall:"+missedSigmaSmall
              )

                density += unitIncrease

                //controller.randomRoot+=1
                repaint();  sleep (20)
                noneAlive = false; timeSinceNonalive = 0;    timeWhileRiuniformized=0
                init()
              } else {
                convergenceSansRiUniformized = true
                println( "STOP: convergence sans RI uniformisé, ou bien parcequ'on veut voir" +  "density=" + density +   " t=" + t
                )
              }
            }
          }

        } finally {
          threadRunning = false
          workerThread = null
          println("END PLAY THREAD = " +    Thread.currentThread().getName
          )
        }
      }
    }
    workerThread = thread
    thread.start()
  }
  var bugs: mutable.Buffer[String] = mutable.Buffer.empty
  var isalives: mutable.Buffer[String] = mutable.Buffer.empty
  /** contains locus of bug */
  var lociBug:Set[Locus]=immutable.HashSet()
  var lociLive:Set[Locus]=immutable.HashSet()

  /**
   * does one CA iteration on the memory
   * @return returns true if radius uniformized
   *
   */
  def forward(): Boolean = caLock.synchronized {
    //  controller.progCA.anchorFieldInMem(mem) //todo a refaire seulement si meme change (quand on display ou qu'on display plus)
    val conteneur = controller.progCA.theLoops(medium.propagate4Shift, mem) //we retrieve wether there was a bug
    bugs=conteneur.get(0).asScala
    isalives=conteneur.get(1).asScala
    bugFound= bugs.nonEmpty
    noneAlive = isalives.isEmpty
    t += 1
    val uniformizedRi =computeStatistics()
    if (bugs.nonEmpty) {  //we set the locus of bugs
      for(bugName<-bugs) {
        val  locusBug=controller.progCA.fieldLocus.asScala(bugName)
        lociBug=lociBug+locusBug // pas sur qu'on doive pas plutot stoquer cela dans env
        val BugFieldName = "llbug"+locusBug.toString.dropRight(2)
        controller.colorDisplayedField+=(BugFieldName->Color.white)
      }
      controller.checkNewLocus(lociBug) //marche meme si y a plusieurs bug différent détecté en meme temps.
      val i=0
    }
    /*if (isalives.isEmpty) {  //we set the locus of bugs
      for(notliveName<-isalives) {
        val  locusLive=controller.progCA.fieldLocus.asScala(notliveName)
        lociLive=lociLive+locusLive // pas sur qu'on doive pas plutot stoquer cela dans env
        val LiveFieldName = "llive"+locusLive.toString.dropRight(2)
        controller.colorDisplayedField+=(LiveFieldName->Color.white)
      }
      controller.checkNewLocus(lociBug) ; controller.checkNewLocus(lociLive) //marche meme si y a plusieurs bug différent détecté en meme temps.
      val i=0
    }*/
   // iterationLabel.text = s"t=$t density=$density" //todo je fais cela ou alors?
   cache.push(deepCopyArray( mem))
    uniformizedRi
  }

  /** @param nbIter number of iteration steps
   * does backward steps using the cache */
  def backward(nbIter:Int): Unit = caLock.synchronized  {
    // bugs = controller.progCA.theLoops(medium.propagate4Shift, mem).asScala //we retrieve wether there was a bug
    if(cache.top==null) return; //on backward pas sur la config initiale
    val timeTarget=t-nbIter
    copyBasic(cache.pop(nbIter),mem)
    t = cache.nextIndex-1
    while(t<timeTarget) //forward till to
      forward()
  }

  def reset(): Unit = caLock.synchronized {
    density = controller.densityInitial
    init()
  }

  /** permet d'aller plus vite en arriére presque le meme code que backward, car "cache" peut prendre en parametre,
   *  le nombre d'itération que l'on souhaite reculer*/
  def fastBackward(nbIter:Int): Unit =caLock.synchronized {
    if(cache.top==null) return;
    copyBasic(cache.pop(nbIter),mem)
    t = cache.nextIndex
    iterationLabel.text="" + t
  }

  /** permet d'aller plus vite au résultat sans se taper de voir un tas d'image */
  def fastForward(nbIter:Int)=
    for(i<- 0 until nbIter) forward()

  def repaintOld(): Unit = {
    computeVoronoirColors()
    caPannel.revalidate()
    caPannel.repaint()
  }

  private val repaintPending =
    new AtomicBoolean(false)

  def repaint(): Unit = {

    // Il y a déjà un affichage en attente :
    // inutile d'en ajouter un autre dans la queue Swing.
    if (!repaintPending.compareAndSet(false, true))
      return
    Swing.onEDT {
      try {
        caLock.synchronized {
          computeVoronoirColors()
          iterationLabel.text =
            s"t=$t density=$density r=${controller.randomRoot}"
          caPannel.updateStat(lastStatText)
          caPannel.peer.paintImmediately(     0,          0,
            caPannel.peer.getWidth,
            caPannel.peer.getHeight
          )
        }
      } finally {
        repaintPending.set(false)
      }
    }
  }

  def repaint2Old(): Unit = {

    Swing.onEDT {

      caLock.synchronized {

        /*
         * On construit l'image à afficher pendant que
         * le thread de calcul est bloqué.
         */
        computeVoronoirColors()

        iterationLabel.text =
          s"t=$t density=$density"

        /*
         * On peint immédiatement pendant qu'on possède
         * encore le verrou.
         *
         * Ainsi forward()/computeStatistics() ne peut pas
         * remettre à zéro les Voronoï au milieu du dessin.
         */
        caPannel.peer.paintImmediately(
          0,
          0,
          caPannel.peer.getWidth,
          caPannel.peer.getHeight
        )
      }
    }
  }

  def print(i:Int) = caPannel.print("/home/frederic/svgCA/toto"+i+".svg")

}

import java.io.{File, FileWriter, PrintWriter}

object ConvergenceLogger {

  private val file =
    new File("results/convergence.csv")
  println("CSV = " + file.getAbsolutePath)

  def fmt(value: Any): String =
    if (value == -1) " " else value.toString

  def append(
              nbLine: Int,
              nbCol: Int,
              density: Int,
              iterations: Int,
              innerRadius: Int,
              randomRoot: Int,
              tSmallSigma:Int
            ): Unit = synchronized {

    // crée le répertoire results s'il n'existe pas
    file.getParentFile.mkdirs()

    val writeHeader =
      !file.exists() || file.length() == 0

    val out =
      new PrintWriter(
        new FileWriter(file, true)
      )

    try {

      if (writeHeader)
        out.println(
          "nbLine,nbCol,density,tUniform,innerRadius,RandomRoot,tSmallSigma"
        )

      out.println(
        s"$nbLine,$nbCol,$density,${fmt(iterations)},$innerRadius, $randomRoot, ${fmt(tSmallSigma)}"
      )

    } finally {

      out.close()
    }
  }
}
