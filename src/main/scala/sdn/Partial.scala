package sdn

import compiler.ASTLfun.andLB2R
import compiler.SpatialType.{BoolV, UintV, UintVx}
import compiler.{ASTL, ASTLt, B, Locus, Ring, UI, V, repr}
import dataStruc.{BranchNamed, Named}
import sdn.Util.addLt

/**
 *
 * @param defined true if value is defined
 * @param value actual partially defined value
 * @tparam R  ring can be signed, unsigned int, or bool
 * we very often use partially defined value, defining a class for it allows to regroup all the code for this.
 * the main exemple is to group flip and prio, because prio is relevant only if flip is true.
 * invariant dans ce cas est defined=false=>value=0

 */
class PartialASTL[ R <: Ring](val defined:BoolV, val value:ASTLt[V,R])(implicit m:repr[R]) {

}

class PartialUI (override val defined:BoolV, override val value:UintV) extends PartialASTL[UI](defined,value) with Named with BranchNamed{
   val valuc:UintVx = if(value.isInstanceOf[UintVx]) value.asInstanceOf[UintVx] else addLt(value)
  /** regéner un partial UI qui vérifie a nouveau l'invaraint aprés un rarefies */
  def restoreInvariant:PartialUI = new PartialUI(defined, andLB2R(defined, value))
  /**
   *
   * @param cancelFlip makes more precise where flip is definied by adding a new condition that a constraint must check
   * @return
   */
  def rarefies(cancelFlip: BoolV): PartialUI = {
    new PartialUI(defined & cancelFlip, valuc)
  }
}
