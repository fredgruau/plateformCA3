package compiledMacro;
 import simulator.PrShift;
 public class redsxorb{
 
public static int ve_1_1GateCount=3;
 public static void ve_1_1(PrShift p,int [] ppVE,int [][] redsxorbveR){
 int[] redsxorbveR$h=redsxorbveR[0],redsxorbveR$d=redsxorbveR[1],redsxorbveR$ad=redsxorbveR[2];

// initialisation 
 int auxL42=0,auxL43=0;
for (int i = 1; i < ppVE.length -1; i++) {
 redsxorbveR$h[i-1]=(( auxL43  <<  1 ) ^  auxL43 );auxL43= ppVE[i] ;redsxorbveR$d[i-1]=( auxL42  ^  auxL43 );redsxorbveR$ad[i-1]=( auxL42  ^ ( auxL43  >>>  1 ));
 auxL42= auxL43 ;
  }
  ;
p.prepareBit(redsxorbveR)
 ;
  }


}