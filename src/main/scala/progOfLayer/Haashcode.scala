package progOfLayer

//used to test quick voronoisation protocol, realized throug a locus proximity graph precomputed for a small CA
//a singe java is generated, so we can use if for compiling java directly;
import compiler.AST.Layer
import compiler.SpatialType._
import compiler._
import dataStruc.BranchNamed

/** we test the display using a TVe constant layers, initialized randomly*/
class Haashcode() extends Layer[(V,B)](1,"global")  with BoolV with BranchNamed{
  //l'init de Ve ne marche pas parfaitement a cause du preparebit, on s'en fout.
  /*val Ev:BoolEv=transfer(this)
  /l V:BoolV=orR(this)
  val E:BoolE=orR(Ev)
  val Vf:BoolVf=clock(this)
  val Fv=transfer(Vf)
  val F:BoolF=orR(Fv)
  val Ef:BoolEf=clock(Ev)
  val Fe=transfer(Ef)*/
  /** the value at t, is the strate itself. */
  def etdeou(b:BoolV)=b & (b| ~ b)
  def etdeou20(b:BoolV)={
    var res=b
    for(i<-0 to 18) {
      res=etdeou(res)
    }
    res
  }
  def list10=List(etdeou20(this),etdeou20(this)).toSet
  override val next= list10.head
  show(this)
  //show(Ev,E,V,Fv,Vf,F,Ef,Fe)

}


