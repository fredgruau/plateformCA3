package compiler

import compiler.Constraint.{Cycle, Schedules}
import org.scalatest.FunSuite

import scala.collection.immutable.ArraySeq

class LocusTest extends FunSuite {

  test("partitionable F") {
    val f=new F()
    val c=f.partitionnables
    val c2=c.get.toList
    //println(c2)
    val it =
      for {
        p1 <- (0 to 2).permutations
        p2 <- (3 to 5).permutations
        res <- Iterator(p1 ++ p2, p2 ++ p1)
      } yield res


    it.foreach(println)

   // assert(c2.size==72)
    //printMem(cs)
  }





}
