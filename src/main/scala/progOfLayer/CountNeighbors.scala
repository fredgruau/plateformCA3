package progOfLayer

import compiler.ASTBfun.addtwo2to3UI
import compiler.ASTL.{binop, send}
import compiler.ASTLfun._
import compiler.ASTLt.ConstLayer
import compiler.SpatialType.{BoolV, BoolVe, UintV, UintVe}
import compiler.{ASTLt, B, UI, V}
import dataStruc.BranchNamed
import progOfmacros.Compute.{concat3V, countNeighbors}
import progOfmacros.Wrapper.{condL, ltUI2L, neqUI2L, not}
import sdn.Globals.root4naming
import sdn.Util.{addSym, addSymUI, randConstUintV, splitInto6}

/** tests the lt macro, containts a bugif */

class   CountNeighbors() extends ConstLayer[V, B](1, "global")  with BranchNamed {
 val voisins: BoolVe = addSym(e(this)).sym
 /**  récupére tout les bits de tout ces voisins, reste ensuite a  les regrouper en paquet, un par voisin*/
 val nasI: UintV = concatR(voisins) //si k = 4, on récupére 24 bits a la suite pour 6 voisins, chacun 4 bits,
 val (n0, n1, n2, n3, n4, n5) = (elt(0, nasI), elt(1, nasI), elt(2, nasI), elt(3, nasI), elt(4, nasI), elt(5, nasI))
 val n012: UintV = sum3V(n0 ,n1, n2); val n345: UintV = sum3V(n3 ,n4, n5)
 //val sum6=binop(addtwo2to3UI,n012,n345) //bug a corriger
 val sum6=countNeighbors(voisins)
 show(this)
 showText(sum6, List())
}


