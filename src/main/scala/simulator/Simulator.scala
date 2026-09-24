package simulator

import compiler.Circuit
import compiler.Circuit.{compiledCA, findPackage, naameCA, pkgCA}
import compiler.DataProg.{nameDirCompilLoops, nameDirProgLoops}
import dataStruc.Util.{CustomClassLoader, existInJava, getProg, hasBeenReprogrammed, loadClass}

import java.awt.{Font, FontMetrics, Image}
import java.io.File

//import simulator.Simulator.SimulatorUtil.envs
import simulator.SimulatorUtil._
import simulator.XMLutilities._
import triangulation.Vector2D

import java.awt.{Color, Polygon}
import java.io.{FileNotFoundException, IOException}
import java.net.URL
import javax.swing.{ImageIcon, JFrame, JTree}
import scala.swing.Swing.Icon
import scala.swing._
import scala.xml.{Elem, Node}
import BorderPanel.Position._
import scala.collection.immutable.HashMap


/*object mySim extends Simulator
class AppletLauncher extends JFrame {
  //super.("Eno");
  val mySim2 = new Simulator();
  mySim2.startup(Array("toto","tata"))
  //getContentPane().add(mySim2.top;
  }*/

object Simulator extends SimpleSwingApplication {

  /** name of Cellular automaton being simulated, to be set by method startUp, and then used by method top */
  var nameCA: String = " "
  var pkgCA: String = " "
  var nameSimulParam: String = " "

  /** parameters defining sizes, t0, isPlaying, common to all simulations */
  var simulParam: Node = null

  /** contains info about which layers are expanded, what where the already used colors. */
  var displayParam: Node = null
  var globalInit: Node = null
  var selectedGlobalInit: Int = -1 //it will bug if we forget to read it.
  var nameGlobalInit: String = null

  var options: String = "" //-c pour compile


  /**
   * @param args command line argument, contains the name of CA being simulated
   *             startup is called before top is launched,so that
   *             it can access args which nameCA as well as other names of files containing parameters for simulation
   *             and store them in order to later be able to open the files with the CA program, and parameters
   */
  override def startup(args: Array[String]): Unit = {

    nameCA = args(0) //name of the CA program

    val racine = new File("src/main/java").getCanonicalFile
    val nomFichier = args(0) + "CA.java"

    if (!racine.exists() || !racine.isDirectory) {
      println(
        s"Erreur: le dossier racine '${racine.getPath}' n'existe pas ou n'est pas un dossier."
      )
      System.exit(1)
    }

    val maybePackage = findPackage(racine, nomFichier)

    maybePackage match {
      case Some(pkg) =>
        println(s"Fichier trouvé dans le package: $pkg")
        pkgCA = pkg

      case None =>
        println(
          s"Fichier '$nomFichier' non trouvé sous '${racine.getPath}'"
        )
    }

    nameGlobalInit = args(1)

    globalInit =
      readXML(
        "src/main/java/compiledCA/globalInit/" +
          nameGlobalInit
      )

    nameSimulParam = args(2)

    simulParam =
      readXML(
        "src/main/java/compiledCA/simulParam/" +
          nameSimulParam
      )

    val pathDisplayParam =
      "src/main/java/" +
        pkgCA +
        "/displayParam/" +
        nameCA +
        ".xml"

    displayParam =
      try {
        //readXML(pathDisplayParam)

        readXML(
          "src/main/java/compiledCA/displayParam/" +
            nameCA +
            ".xml"
        )
      }
      catch {
        case _: FileNotFoundException =>
          readXML(
            "src/main/java/compiledCA/displayParam/default.xml"
          )
      }

    if (args.length > 3)
      options = args(3)

    super.startup(args)
  }


  /** @param args command line argument, contains the name of CA being simulated */
  override def main(args: Array[String]): Unit = {
    super.main(args)
  }


  /** hierarchy of swing Jcomponents */
  def top: MainFrame = new MainFrame {

    val nameDirProgCA =
      "src/main/scala/" + pkgCA + "/"

    val nameDirCompilCA =
      "src/main/java/" + pkgCA + "/"

    /** true if scala CA has been reprogrammed */
    val reprogrammed =
      hasBeenReprogrammed(
        nameDirProgCA + nameCA.capitalize + ".scala",
        nameDirCompilCA + nameCA + "CA.java"
      )

    /** true if java CA has been deleted */
    val deletedJava =
      !existInJava(
        nameDirCompilCA + nameCA + "CA.java"
      )

    /** contains the loops but also many other parameters */
    val progCA: CAloops2 =

      if (
        options.contains("-c") ||
          (
            options.contains("-b") &&
              (reprogrammed || deletedJava)
            )
      ) {

        Circuit.pkgCA = pkgCA
        Circuit.compiledCA(nameCA, pkgCA)

      } else {

        val classCA: Class[CAloops2] =
          loadClass(
            pkgCA + "." + nameCA + "CA"
          )

        getProg(classCA)
      }


    title =
      "spatial computation " +
        nameCA +
        " gateCount=" +
        progCA.gateCount() +
        " memory Width=" +
        progCA.CAmemWidth()


    /**
     * Process the signal.
     * We create controller first in order to instantiate state
     * variables used by layerTree.
     */
    val controller =
      new Controller(
        nameCA,
        globalInit,
        nameGlobalInit,
        simulParam,
        nameSimulParam,
        displayParam,
        progCA,
        pkgCA,
        this
      )


    /** Tree for browsing the hierarchy of layers and which field to display */
    val xmlLayerTree: Elem =
      readXmlTree(
        progCA.displayableLayerHierarchy()
      )

    System.out.println(
      "the displayable layers are\n" +
        xmlLayerTree
    )

    val layerTree: LayerTree =
      new LayerTree(
        xmlLayerTree,
        controller
      )

    val scrollableXmlTree =
      new ScrollPane(layerTree)

    controller.init(layerTree)


    /**
     * We simulate several CA simultaneously.
     */
    val iterEnvs: Iterable[Env] =
      envs(controller)


    /**
     * The CA panels are displayed vertically as rows.
     *
     * Rule:
     *
     *   nbCol < 32  -> small CA
     *                  two small CA can share a row
     *
     *   nbCol >= 32 -> large CA
     *                  one row for this CA
     *
     * Each CApannel keeps exactly the dimensions of its
     * medium.boundingBox so that cells have the same visual size
     * from one environment to another.
     */
    val pannels =
      new BoxPanel(Orientation.Vertical) {

        /**
         * Current row used for small CA.
         */
        var currentRow =
          new BoxPanel(Orientation.Horizontal)

        /**
         * Number of small CA currently stored in currentRow.
         * Can therefore only be 0 or 1 here between insertions.
         */
        var nbSmallInRow = 0


        for (env: Env <- iterEnvs) {

          /**
           * Controller needs access to all environments.
           */
          controller.envList =
            controller.envList :+ env


          /**
           * Two CA with fewer than 32 columns can be placed
           * on the same row.
           */
          val isSmall =
            env.medium.nbCol < 30


          /**
           * Use actual graphical dimensions computed by Medium.
           *
           * This is important:
           * we do NOT give all CA the same width.
           *
           * Therefore a CA with twice as many columns is
           * approximately twice as wide and individual cells
           * keep the same visual size.
           */
          val panelWidth =
            env.medium.boundingBox.width

          val panelHeight =
            env.medium.boundingBox.height


          val stat =
            new Label("stat : 0")


          env.caPannel =
            new CApannel(
              panelWidth,
              panelHeight,
              env,
              progCA
            ) {

              override def updateStat(
                                       s: String
                                     ): Unit = {
                stat.text = s
              }
            }


          /**
           * BoxLayout is allowed to resize components up to their
           * maximumSize.
           *
           * Fix all three dimensions so CApannel cannot be enlarged
           * by the surrounding BoxPanels.
           */
          val caSize =
            new Dimension(
              panelWidth,
              panelHeight
            )

          env.caPannel.minimumSize =
            caSize

          env.caPannel.preferredSize =
            caSize

          env.caPannel.maximumSize =
            caSize


          /**
           * Information displayed just above this CA.
           */
          val numberPannel =
            new BoxPanel(
              Orientation.Horizontal
            ) {

              contents += env.iterationLabel

              contents +=
                Swing.HStrut(10)

              contents += stat

              contents +=
                Swing.HGlue
            }


          /**
           * One complete environment:
           *
           *       t / density / statistics
           *       CA
           */
          val envPanel =
            new BoxPanel(
              Orientation.Vertical
            ) {

              contents += numberPannel
              contents += env.caPannel
            }


          if (isSmall) {

            /**
             * Add this small CA to the current row.
             */
            currentRow.contents +=
              envPanel

            nbSmallInRow += 1


            /**
             * Separation between two small CA.
             */
            if (nbSmallInRow == 1) {

              currentRow.contents +=
                Swing.HStrut(10)
            }


            /**
             * Two small CA:
             * the row is complete.
             */
            if (nbSmallInRow == 2) {

              currentRow.contents +=
                Swing.HGlue

              contents +=
                currentRow

              /**
               * Prepare next row.
               */
              currentRow =
                new BoxPanel(
                  Orientation.Horizontal
                )

              nbSmallInRow = 0
            }

          } else {

            /**
             * A large CA must start on a new row.
             *
             * Therefore, if a small CA is waiting alone in
             * currentRow, first close that row.
             */
            if (nbSmallInRow > 0) {

              currentRow.contents +=
                Swing.HGlue

              contents +=
                currentRow

              currentRow =
                new BoxPanel(
                  Orientation.Horizontal
                )

              nbSmallInRow = 0
            }


            /**
             * Large CA:
             * one entire row for this environment.
             */
            val largeRow =
              new BoxPanel(
                Orientation.Horizontal
              ) {

                contents +=
                  envPanel

                /**
                 * Remaining horizontal space stays on the right.
                 */
                contents +=
                  Swing.HGlue
              }


            contents +=
              largeRow
          }


          /**
           * env.init() must be called only once caPannel has been
           * created because initialization can update the display.
           */
          env.init()
        }


        /**
         * There may be one final small CA without a partner.
         */
        if (nbSmallInRow > 0) {

          currentRow.contents +=
            Swing.HGlue

          contents +=
            currentRow
        }
      }


    /**
     * We generate many panels and the mouse wheel allows
     * vertical scrolling.
     */
    val scrollablPannels =
      new ScrollPane(pannels)


    /** this way of doing make the toolbar floatable */
    contents =
      new BorderPanel {

        layout(scrollableXmlTree) =
          West

        layout(controller) =
          North

        layout(scrollablPannels) =
          Center
      }
  }
}


/**
 * retrieve icons stored in the ressources directory
 */
object ExampleData {

  val fileIcon: ImageIcon =
    Icon("src/ressources/file.png")

  val folderIcon: ImageIcon =
    Icon("src/ressources/folder.png")

  val playNormalIcon: ImageIcon =
    Icon("src/ressources/play_black.gif")

  val playReverseIcon: ImageIcon =
    Icon("src/ressources/playReverse.jpg")

  val pauseNormalIcon: ImageIcon =
    Icon("src/ressources/pause_black.gif")

  val forwardIcon: ImageIcon =
    Icon("src/ressources/skip_forward_black.gif")

  val fastForwardIcon: ImageIcon =
    Icon("src/ressources/FFF.jpg")

  val fastBackwardIcon: ImageIcon =
    Icon("src/ressources/RWW.jpg")

  val backwardIcon: ImageIcon =
    Icon("src/ressources/skip_backward_black.gif")

  val initIcon: ImageIcon =
    Icon("src/ressources/rewind_black.gif")

  val closeBoxIcon: ImageIcon =
    Icon("src/ressources/zoom_in_small.png")

  val printerIcon: ImageIcon =
    Icon("src/ressources/printer.png")

  val printerIconSmall =
    new ImageIcon(
      printerIcon.getImage.getScaledInstance(
        32,
        32,
        Image.SCALE_SMOOTH
      )
    )
}


object SimulatorUtil {

  /**
   *
   * @param gridSizes  the different posible CA sizes
   * @param controller the controler
   * @return env Iterator implemented separately method because it is big
   */
  def envs(
            controller: Controller
          ): Iterable[Env] = {

    val simulParam =
      controller.simulParam

    /**
     * When simulating CAs whose number of Lines and columns augment
     */
    val gridSizes:
      collection.Seq[(Int, Int)] =

      fromXMLasListIntCouple(
        simulParam,
        "sizes",
        "size",
        "@nbLine",
        "@nbCol"
      )


    val t0s =
      fromXMLasList(
        simulParam,
        "sizes",
        "size",
        "@t0"
      )


    /** When simulating CAs with different init */
    val multiInits =
      xArrayString(
        simulParam,
        "multiInit",
        "@inits"
      )


    val rootLayer: String =
      if (multiInits.nonEmpty)
        x(
          simulParam,
          "multiInit",
          "@layer"
        )
      else
        null


    val iter: String =
      x(
        simulParam,
        "display",
        "@iter"
      )


    def totalIter: Int =
      iter match {

        case "CAsize" =>
          gridSizes.size

        case "multiInit" =>
          multiInits.size

        case "random" =>
          4

        case "none" =>
          1
      }


    new Iterable[Env] {

      val iterator: Iterator[Env] =
        new Iterator[Env] {

          var nbIter = 0

          /**
           * coded as a double so that we do not lose precision
           * when multiplying by sqrt(2)
           */
          var nbLineCA: Int =
            xInt(
              simulParam,
              "machine",
              "@nbLine"
            )

          var nbColCA: Int =
            xInt(
              simulParam,
              "machine",
              "@nbCol"
            )


          var initRoot:
            HashMap[String, String] =
            HashMap.empty


          val arch: String =
            x(
              simulParam,
              "machine",
              "@arch"
            )


          /**
           * @return true if there is a next element
           */
          override def hasNext: Boolean =
            nbIter < totalIter


          /**
           * @return next environment
           */
          override def next(): Env = {

            iter match {

              case "CAsize" =>

                nbLineCA =
                  gridSizes(nbIter)._1

                nbColCA =
                  gridSizes(nbIter)._2


              case "multiInit" =>

                initRoot =
                  HashMap(
                    rootLayer ->
                      multiInits(nbIter)
                  )


              case "random" =>

                controller.randomRoot =
                  nbIter


              case _ =>
            }


            val t0 =
              t0s(nbIter).toInt


            nbIter += 1


            new Env(
              arch,
              nbLineCA,
              nbColCA,
              controller,
              initRoot,
              t0
            )
          }
        }
    }
  }
}


/**
 * contains the types used in the simulator
 */
object CAtype {

  /** stores all the memory fields of a CA */
  type CAMem =
    Array[Array[Int]]


  /**
   * coordinate for all vertices, or for one subfield of all edges,
   * face or transfer locus.
   *
   * points is undefined if it lies out of the bounding box.
   */
  type pointLines =
    Array[
      Array[
        Option[Vector2D]
      ]
    ]


  /**
   * allows to reuse the same code for displaying
   * or for generating svg
   */
  trait myGraphics2D {

    def setColor(
                  c: Color
                ): Unit

    def drawPoint(
                   x: Int,
                   y: Int,
                   size: Int
                 ): Unit

    def drawLine(
                  x: Int,
                  y: Int,
                  x2: Int,
                  y2: Int
                ): Unit

    def fillPolygon(
                     p: Polygon
                   ): Unit

    def drawPolygon(
                     p: Polygon
                   ): Unit

    def drawText(
                  s: String,
                  i: Int,
                  j: Int
                ): Unit

    def drawTextPoly(
                      s: String,
                      p: Polygon
                    )

    /** returns a font size adapted to hexagon dimensions */
    def getFittedFontOpt:
    Option[Font]
  }
}