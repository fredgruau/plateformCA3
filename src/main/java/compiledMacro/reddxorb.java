package compiledMacro;
 import simulator.PrShift;
 public class reddxorb{
 
public static int ev_1_1GateCount=3;
 public static void ev_1_1(PrShift p,int [][] ppVE,int [][] reddxorbevR){
 int[] reddxorbevR$h=reddxorbevR[0],reddxorbevR$d=reddxorbevR[1],reddxorbevR$ad=reddxorbevR[2],ppVE$h1=ppVE[0],ppVE$h2=ppVE[1],ppVE$d1=ppVE[2],ppVE$d2=ppVE[3],ppVE$ad1=ppVE[4],ppVE$ad2=ppVE[5];


for (int i = 1; i < ppVE$h1.length -1; i++) {
 reddxorbevR$h[i]=( ppVE$h1[i]  ^  ppVE$h2[i] );reddxorbevR$d[i]=( ppVE$d1[i]  ^  ppVE$d2[i] );reddxorbevR$ad[i]=( ppVE$ad1[i]  ^  ppVE$ad2[i] );
  }
  ;
p.prepareBit(reddxorbevR)
 ;
  }}