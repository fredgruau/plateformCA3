package progOfLayer

import compiler.ASTL.send
import compiler.ASTLfun._
import compiler.ASTLt.ConstLayer
import compiler.SpatialType.{BoolV, BoolVe, UintV, UintVe}
import compiler.{ASTLt, B, UI, V}
import dataStruc.BranchNamed
import progOfLayer.Sextexrect.chooseMaxOf
import progOfmacros.Compute.concat3V
import progOfmacros.Wrapper.{condL, ltUI2L, neqUI2L, not}
import sdn.Globals.root4naming
import sdn.Util.{addSymUI, randConstUintV, splitInto6}

/** tests the lt macro, containts a bugif */

class   TestAdd() extends ConstLayer[V, B](1, "global")  with BranchNamed {
 //we want a constant random to check that selected direction changes of time when two
 //or more vertices reach the minimum.
 val r1 = randConstUintV(2) //rand1::rand2
 val r2 = randConstUintV(2) //rand1::rand2
 val sum = r1 + r2
 showt(r1, r2, sum)
}


