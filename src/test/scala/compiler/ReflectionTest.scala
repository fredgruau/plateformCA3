package compiler

import compiler.AST.Layer
import compiler.ASTL.delayedL
import compiler.SpatialType.IntV
import dataStruc.Naame.setAllName
import dataStruc.{BranchNamed, Dag, DagNode, Named}
import org.scalatest.{BeforeAndAfter, FunSuite}

class ReflectionTest extends FunSuite with BeforeAndAfter {

  /** programme de test */

    class MyClassSubmember extends Named {
      val subField="submemberfield"
    }

    class MyClassMember extends BranchNamed with Named {
      val subField="subfield"
      val subMember=new MyClassSubmember
    }


    class SuperClass {
      val superField: Int = 42
    }

    class MyClass extends SuperClass with BranchNamed with Named {
      var mutableField: String = "Initial"
      val meember:MyClassMember=new MyClassMember
    }
  test("toto") {
  // Création d'une instance de MyClass
    val myInstance = new MyClass
    //setAllName(myInstance,"racine")

    // Vérification finale de la valeur du champ
    println(s"Nouvelle valeur du name de member: ${myInstance.meember.asInstanceOf[Named].name}")
  }
}



