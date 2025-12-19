package progOfLayer

import compiler.ASTLt.ConstLayer
import compiler.SpatialType.{SintV, UintV}
import compiler.{B, V}
import dataStruc.BranchNamed
import progOfmacros.Grad
import sdn.Util.randConstUintV

/** tests the lt macro, containts a bugif */

class   TestSlope() extends ConstLayer[V, B](1, "global")  with BranchNamed {
 //we want a constant random to check that selected direction changes of time when two
 //or more vertices reach the minimum.
 val r = randConstUintV(4).asInstanceOf[SintV] //rand1::rand2
 //val r2 = randConstUintV(2) //rand1::rand2
 val (slope, grad)=Grad.slopGradGap(r)
show(slope)
 showt(r, grad)
}


