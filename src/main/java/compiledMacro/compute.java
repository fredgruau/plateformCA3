package compiledMacro;
 import simulator.PrShift;
 public class compute{
 
public static int concat4V_1_1_1_1_4GateCount=0;
 public static void concat4V_1_1_1_1_4(PrShift p,int [] pa,int [] pb,int [] pc,int [] pd,int [][] computeconcat4V){
 int[] computeconcat4V$0=computeconcat4V[0],computeconcat4V$1=computeconcat4V[1],computeconcat4V$2=computeconcat4V[2],computeconcat4V$3=computeconcat4V[3];


for (int i = 1; i < pa.length -1; i++) {
 computeconcat4V$0[i]= pd[i] ;computeconcat4V$1[i]= pc[i] ;computeconcat4V$2[i]= pb[i] ;computeconcat4V$3[i]= pa[i] ;
  }
  p.mirror(computeconcat4V);
p.prepareBit(computeconcat4V)
 ;
  }
public static int implique_1_1_1GateCount=2;
 public static void implique_1_1_1(PrShift p,int [] pa,int [] pb,int [] computeimplique){
 


for (int i = 1; i < pa.length -1; i++) {
 computeimplique[i]=(~ pa[i]  |  pb[i] );
  }
  p.mirror(computeimplique);
p.prepareBit(computeimplique)
 ;
  }}