package compiledMacro;
 import simulator.PrShift;
 public class binoxorb{
 
public static int vb_1_1_1GateCount=1;
 public static void vb_1_1_1(PrShift p,int [] ppVB,int [] pqVB,int [] resultCA){
 


for (int i = 1; i < ppVB.length -1; i++) {
 resultCA[i]=( ppVB[i]  ^  pqVB[i] );
   } }}