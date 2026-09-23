package simulator

import compiler.Locus.{allLocus, locusEv, locusV}

import java.awt.{BasicStroke, Color, Font, Graphics2D, Image, Polygon, Rectangle}
import simulator.CAtype._

import scala.swing.Swing._
import scala.swing.{Dimension, Panel}
import triangulation.{Triangle2D, Vector2D, Voroonoi}
import triangulation.Utility._

import Color._
import compiler.Locus
import dataStruc.Coord2D
import simulator.CApannel.fitTextInPolygon

import scala.collection.immutable
import scala.collection.immutable.HashSet
import scala.util.Random
import java.awt.image.BufferedImage
import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}

object CApannel {

  /** Cherche la plus grande police qui respecte la condition `fits`. */
  private def findFittedFont(
                              g: Graphics2D,
                              text: String,
                              fontName: String,
                              fontStyle: Int,
                              maxFontSize: Int,
                              minFontSize: Int
                            )(
                              fits: (Int, Int) => Boolean
                            ): Option[(Font, Int, Int)] = {
    (maxFontSize to minFontSize by -1).iterator
      .map { size =>
        val font = new Font(fontName, fontStyle, size)
        val fm = g.getFontMetrics(font)
        val textWidth = fm.stringWidth(text)
        val textHeight = fm.getHeight
        (font, textWidth, textHeight)
      }
      .find {
        case (_, textWidth, textHeight) => fits(textWidth, textHeight)
      }
  }

  /** Retourne une police adaptée aux dimensions d'une cellule. */
  def fitFontInCell(
                     g: Graphics2D,
                     text: String,
                     maxWidth: Int,
                     maxHeight: Int,
                     fontName: String = "SansSerif",
                     fontStyle: Int = Font.PLAIN,
                     maxFontSize: Int = 24,
                     minFontSize: Int = 6
                   ): Option[Font] = {
    findFittedFont(
      g,
      text,
      fontName,
      fontStyle,
      maxFontSize,
      minFontSize
    ) { (textWidth, textHeight) =>
      textWidth <= maxWidth && textHeight <= maxHeight
    }.map(_._1)
  }

  /** Calcule la police et la position d'un texte dans un polygone. */
  def fitTextInPolygon(
                        g: Graphics2D,
                        text: String,
                        polygon: Polygon,
                        fontName: String = "SansSerif",
                        fontStyle: Int = Font.PLAIN,
                        maxFontSize: Int = 12,
                        minFontSize: Int = 6
                      ): Option[(Font, Int, Int)] = {
    val bounds: Rectangle = polygon.getBounds

    val fittedFont = findFittedFont(
      g,
      text,
      fontName,
      fontStyle,
      maxFontSize,
      minFontSize
    ) { (textWidth, textHeight) =>
      // On conserve ici la condition du code d'origine.
      textWidth / 2 <= bounds.width && textHeight / 2 <= bounds.height
    }

    fittedFont.map {
      case (font, _, textHeight) =>
        val margin = 1
        val x = bounds.x + margin
        val y = bounds.y + (bounds.height - textHeight) / 2 + font.getSize
        (font, x, y)
    }
  }
}
/**
 * pannel for drawing one CA , together with relevant information
 * @param env contains all what's needed to draw
 * @param width with of the cellular automaton
 */
abstract class CApannel(width: Int, height: Int, env: Env, progCA: CAloops2) extends Panel {
  background = Color.black
  preferredSize = (width, height)
  focusable = true
  def updateStat(s: String)

  /** when zooming on a sub part we need to draw only a small portion */
  private val subca: Dimension = null
  /** rendering is improved by first drawing in an image buffer */
  private var imageBuffer: Image = null




  /**
   * Partie commune aux sorties écran et SVG.
   * `metricG` sert uniquement à mesurer les textes.
   */
  private abstract class BaseGraphics2D(metricG: Graphics2D) extends myGraphics2D {
    protected var currentColor: Color = Color.black

    /** Seul le rendu effectif du texte dépend de la sortie. */
    protected def renderText(s: String, x: Int, y: Int, font: Font): Unit

    override def drawText(s: String, x: Int, y: Int): Unit = {
      renderText(s, x, y, new Font("Serif", Font.PLAIN, 24))
    }

    /** Retourne une police adaptée aux dimensions des cellules. */
    override def getFittedFontOpt: Option[Font] = {
      CApannel.fitFontInCell(
        metricG,
        "zz",
        width / env.medium.nbCol,
        height / env.medium.nbLine
      )
    }

    override def drawTextPoly(s: String, p: Polygon): Unit = {
      fitTextInPolygon(metricG, s, p).foreach {
        case (font, x, y) => renderText(s, x, y, font)
      }
    }
  }

  /** Échappe un texte afin qu'il puisse être inséré dans du XML. */
  private def escapeXml(s: String): String = {
    s.flatMap {
      case '&'  => "&amp;"
      case '<'  => "&lt;"
      case '>'  => "&gt;"
      case '"'  => "&quot;"
      case '\'' => "&apos;"
      case c    => c.toString
    }
  }

  private def svgColor(c: Color): String = {
    f"#${c.getRed}%02x${c.getGreen}%02x${c.getBlue}%02x"
  }

  private def svgAlpha(c: Color): Double = c.getAlpha.toDouble / 255.0

  private def polygonPoints(p: Polygon): String = {
    (0 until p.npoints)
      .map(i => s"${p.xpoints(i)},${p.ypoints(i)}")
      .mkString(" ")
  }

  /** Dessine l'automate dans un fichier SVG vectoriel. */
  def print(fileName: String): Unit = {
    val svg = new StringBuilder

    // Ce Graphics2D invisible sert seulement au calcul des FontMetrics.
    val metricImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB)
    val metricG = metricImage.createGraphics()

    svg ++= """<?xml version="1.0" encoding="UTF-8"?>"""
    svg += '\n'
    svg ++=
      s"""<svg xmlns="http://www.w3.org/2000/svg"
         |     width="$width"
         |     height="$height"
         |     viewBox="0 0 $width $height">
         |""".stripMargin
    svg ++=
      s"""  <rect x="0" y="0" width="$width" height="$height"
         |        fill="${svgColor(background)}"
         |        fill-opacity="${svgAlpha(background)}" />
         |""".stripMargin

    val svgFig = new BaseGraphics2D(metricG) {
      override def setColor(c: Color): Unit = {
        currentColor = c
      }

      override def drawPoint(x: Int, y: Int, size: Int): Unit = {
        val radius = size.toDouble / 2.0
        svg ++=
          s"""  <circle cx="$x" cy="$y" r="$radius"
             |          fill="${svgColor(currentColor)}"
             |          fill-opacity="${svgAlpha(currentColor)}" />
             |""".stripMargin
      }

      override def drawLine(x: Int, y: Int, x2: Int, y2: Int): Unit = {
        svg ++=
          s"""  <line x1="$x" y1="$y" x2="$x2" y2="$y2"
             |        stroke="${svgColor(currentColor)}"
             |        stroke-opacity="${svgAlpha(currentColor)}"
             |        stroke-width="1" />
             |""".stripMargin
      }

      override def fillPolygon(p: Polygon): Unit = {
        if (p.npoints > 0) {
          svg ++=
            s"""  <polygon points="${polygonPoints(p)}"
               |           fill="${svgColor(currentColor)}"
               |           fill-opacity="${svgAlpha(currentColor)}"
               |           stroke="none" />
               |""".stripMargin
        }
      }

      override def drawPolygon(p: Polygon): Unit = {
        if (p.npoints > 0) {
          svg ++=
            s"""  <polygon points="${polygonPoints(p)}" fill="none"
               |           stroke="${svgColor(currentColor)}"
               |           stroke-opacity="${svgAlpha(currentColor)}"
               |           stroke-width="1" />
               |""".stripMargin
        }
      }

      override protected def renderText(
                                         s: String,
                                         x: Int,
                                         y: Int,
                                         font: Font
                                       ): Unit = {
        svg ++=
          s"""  <text x="$x" y="$y"
             |        fill="${svgColor(currentColor)}"
             |        fill-opacity="${svgAlpha(currentColor)}"
             |        font-family="${escapeXml(font.getFamily)}"
             |        font-size="${font.getSize}">${escapeXml(s)}</text>
             |""".stripMargin
      }
    }

    try {
      drawCA(svgFig, env)
      svg ++= "</svg>\n"
      Files.write(
        Paths.get(fileName),
        svg.toString().getBytes(StandardCharsets.UTF_8)
      )
      ()
    } finally {
      metricG.dispose()
    }
  }

  /** called by the system, in order to paint or repaint the pannel */
  override def paintComponent(g: Graphics2D): Unit = {
    super.paintComponent(g)
    val gscreen = new BaseGraphics2D(g) {
      override def setColor(c: Color): Unit = {
        currentColor = c
        g.setColor(c)
      }

      override def fillPolygon(p: Polygon): Unit = g.fillPolygon(p)

      override def drawPolygon(p: Polygon): Unit = g.drawPolygon(p)

      override def drawPoint(x: Int, y: Int, size: Int): Unit = {
        g.setStroke(new BasicStroke(size))
        g.drawLine(x, y, x, y)
      }

      override def drawLine(x: Int, y: Int, x2: Int, y2: Int): Unit = {
        g.setStroke(new BasicStroke(1))
        g.drawLine(x, y, x2, y2)
      }

      override protected def renderText(
                                         s: String,
                                         x: Int,
                                         y: Int,
                                         font: Font
                                       ): Unit = {
        g.setFont(font)
        g.drawString(s, x, y)
      }
    }
    drawCA(gscreen, env)
  }




  /**
   *
   * @param g delegate the fillPolygone to either printing on the screen, or in a svg file
   * @param env
   */
  def drawCA(g: myGraphics2D, env: Env) = {

    val rand = new Random()
    def randColor=new Color(rand.nextFloat, rand.nextFloat, rand.nextFloat)


    def drawText(c: Color) = {
      g.setColor(c);
      if(env.bugs.nonEmpty)
        g.drawText("BUG: "+env.bugs.mkString(","), 100, /*height -*/ 100)
    }
    def drawTriangles(c: Color,triangleSoup:List[Triangle2D]) = {
      g.setColor(c);
      for (t <- triangleSoup)
        g.drawPolygon(toPolygon(t))
    }

    def fillTriangles(c: Color,triangleSoup:List[Triangle2D]) = {
      g.setColor(c);
      for (t <- triangleSoup)
        g.fillPolygon(toPolygon(t))
    }

    def drawTrianglesVEv(c: Color,triangleSoup:List[Triangle2D]) = {
      g.setColor(c);
      val targetLoci: Set[Locus]=HashSet(locusV,locusEv)
      val locusOfPoint:immutable.HashMap[Vector2D,Locus]=immutable.HashMap.empty++allLocus.map((l:Locus) => env.medium.pointSet(l).toList.map((v:Vector2D)=>(v->l))).flatten
      for (t <- triangleSoup) {
        val lociSummit: Set[Locus] =HashSet(t.a,t.b,t.c).map (locusOfPoint(_))
        if(  targetLoci.subsetOf(lociSummit))
          //g.setColor(randColor);
          g.drawPolygon(toPolygon(t))
      }
    }

    def drawdebug(c:Color)={
      g.setColor(c)
      for ((p1,p2)<-env.medium.bug) {
        g.drawLine(p1.x.toInt,p1.y.toInt,p2.x.toInt,p2.y.toInt)
        g.drawPoint(p1.x.toInt, p1.y.toInt,6)
        g.drawPoint(p2.x.toInt, p2.y.toInt,6)
      }
    }

    def drawEdges(c: Color) = {
      g.setColor(c);
      // env.medium.resetLocusNeigbors
      // for (p <- env.medium.displayedPoint)
      //  for (p2<- env.medium.locusNeighbors(p))
      //  g.drawLine(p.x.toInt,p.y.toInt,p2.x.toInt,p2.y.toInt)
      for(e<-env.medium.planarGraph.edges)
        g.drawLine(e.src.x.toInt,e.src.y.toInt,e.target.x.toInt,e.target.y.toInt)
    }
    /** used for debug */
    def drawFaces(): Unit = {
      for(f<-env.medium.planarGraph.faces)
        if( f.border.size>6 && !f.outerBorder && rand.nextBoolean()&& rand.nextBoolean()  )//
        {
          g.setColor(WHITE)
          g.fillPolygon(f.toPolygon)
          g.setColor(black)

          g.drawPolygon(f.toPolygon)
          for(p<-f.border)
            g.drawPoint(p.src.x.toInt,p.src.y.toInt,6)
        }
    }
    def drawCrossedFaces(): Unit = {
      g.setColor(gray)
      for(f<-env.medium.planarGraph.faces)
        if(f.isCrossing && f.border.size<31 && rand.nextBoolean()&& rand.nextBoolean() )  //we do not fill the outer border which is allowed to have crossing, due to two pending edges
          g.fillPolygon(f.toPolygon)
    }
    def drawCAinsideContour(c: Color) = {
      g.setColor(c);
      for ((_, v) <- env.medium.theVoronois)
        if (v.sides.isEmpty)
          g.drawPolygon(v.polygon)
    }
    def drawCA1DborderContour(c: Color) = {
      g.setColor(c);
      for ((_, v) <- env.medium.theVoronois)
        if (v.isBorder)
          g.drawPolygon(v.polygon)
    }
    def drawOutsideFace()={
      env.medium.planarGraph.setOuterBorder()
      val outBorder=env.medium.planarGraph.outerBorder.border
      for(e<-outBorder) {
        if(outBorder.contains(e.miror))g.setColor(pink)  //we use a distinct color for crossed edge
        else g.setColor(orange)
        g.drawLine(e.src.x.toInt,e.src.y.toInt,e.target.x.toInt,e.target.y.toInt)
      }
    }

    /** remplis tout les points au centre des polygones du voronoi dont les seeds correspondent au displayed loci */
    def drawPoints() = {
      for (p <- env.medium.displayedPoint) {
        val v2=env.medium.theVoronois(Coord2D(p.x,p.y))
        if(v2.trianglesOK) {
          g.setColor(gray)
          g.drawPoint(p.x.toInt, p.y.toInt,2)
        }
        else  {
          g.setColor(white)
          g.drawPoint(p.x.toInt, p.y.toInt,4)
        }

      }
    }
    /** remplis tout les  polygones du voronoi dont les seeds correspondent au displayed loci */
    def drawCAcolorVoronoi() = {
      //env.computeVoronoirColors() //painting allways need to recompute the colors, it would seem
      //for (v: Voroonoi <- env.medium.voronoi.values) {
      for(p<-env.medium.displayedPoint){
        val v2: Voroonoi =env.medium.theVoronois(Coord2D(p.x,p.y))
        if (v2.polygon.npoints==0){ //we could not build the voronoi, we just draw a point.
          g.setColor(v2.color)
          g.drawPoint(p.x.toInt, p.y.toInt,10)
          g.drawPoint(p.x.toInt, p.y.toInt,1)} //on veut que le stroke revient a 1.
        else {
          g.setColor(v2.color)
          g.fillPolygon(v2.polygon)
        }
/*          if
        (v2.color != Color.black || v2.corner.isDefined //we print the corners even it they are black, because they can overlap
        ) {
          g.setColor(v2.color)
          g.fillPolygon(v2.polygon)
        }*/
      }
    }

    /** remplis tout les  polygones du voronoi avec les textes qui correspondent au displayed loci */
    def drawCATextVoronoi() = {
      val f=g.getFittedFontOpt
      val u=0
      //env.computeVoronoirColors() //painting allways need to recompute the colors, it would seem
      //for (v: Voroonoi <- env.medium.voronoi.values) {
      for(p<-env.medium.displayedPoint){
        val v2: Voroonoi =env.medium.theVoronois(Coord2D(p.x,p.y))
        if (v2.polygon.npoints>0 && v2.text!=null) {
          g.setColor(Color.gray) //calculer la couleur du texte blanc ou noir pour que cela se voit bien
          g.drawTextPoly(v2.text,v2.polygon)
        }
        // g.drawText(v2.text, 100, /*height -*/ 100) //fitte le texte dans le polygone.
      }
    }


    //drawCAtestInit(env.medium.defInit(E()),red)
    drawCAcolorVoronoi()
    drawCATextVoronoi()
    // drawCAinsideContour(gray)
    // drawCA1DborderContour(white)

    //

    //     drawTriangles(blue,env.medium.triangleSoupDelaunay)
    // drawTriangles(green,env.medium.triangleSoupGraph)
    // drawEdges(red)
    drawPoints()
    drawText(white)


    //drawdebug(green)
    if(env.controller.showMore) {drawCrossedFaces();drawFaces()}

    // drawTriangles(blue,env.medium.triangleSoupDelaunay)
    //   drawTrianglesVEv(blue,env.medium.triangleSoupDelaunay)
    // drawOutsideFace() plante si y ajuste V()
  }

}

