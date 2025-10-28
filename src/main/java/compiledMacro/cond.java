package compiledMacro;
 import simulator.PrShift;
 public class cond{
 
public static int vb_1_1_1_1GateCount=4;
 public static void vb_1_1_1_1(PrShift p,int [] pcVB,int [] ppVB,int [] pqVB,int [] condvb){
 

// initialisation 
 int cVB=0;
for (int i = 1; i < pcVB.length -1; i++) {
 cVB= pcVB[i] ;condvb[i]=(( cVB  &  ppVB[i] ) | (~ cVB  &  pqVB[i] ));
  }
  p.mirror(condvb);
p.prepareBit(condvb)
 ;
  }
public static int vui_1_3_3_3GateCount=12;
 public static void vui_1_3_3_3(PrShift p,int [] pcVUI,int [][] ppVUI,int [][] pqVUI,int [][] condvui){
 int[] condvui$0=condvui[0],condvui$1=condvui[1],condvui$2=condvui[2],ppVUI$0=ppVUI[0],ppVUI$1=ppVUI[1],ppVUI$2=ppVUI[2],pqVUI$0=pqVUI[0],pqVUI$1=pqVUI[1],pqVUI$2=pqVUI[2];

// initialisation 
 int cVUI=0,r0=0;
for (int i = 1; i < pcVUI.length -1; i++) {
 cVUI= pcVUI[i] ;condvui$0[i]=(( cVUI  &  ppVUI$0[i] ) | ((r0=~ cVUI ) &  pqVUI$0[i] ));condvui$1[i]=(( cVUI  &  ppVUI$1[i] ) | ((r0=~ cVUI ) &  pqVUI$1[i] ));condvui$2[i]=(( cVUI  &  ppVUI$2[i] ) | ((r0=~ cVUI ) &  pqVUI$2[i] ));
  }
  p.mirror(condvui);
p.prepareBit(condvui)
 ;
  }
public static int vui_1_4_4_4GateCount=16;
 public static void vui_1_4_4_4(PrShift p,int [] pcVUI,int [][] ppVUI,int [][] pqVUI,int [][] condvui){
 int[] condvui$0=condvui[0],condvui$1=condvui[1],condvui$2=condvui[2],condvui$3=condvui[3],ppVUI$0=ppVUI[0],ppVUI$1=ppVUI[1],ppVUI$2=ppVUI[2],ppVUI$3=ppVUI[3],pqVUI$0=pqVUI[0],pqVUI$1=pqVUI[1],pqVUI$2=pqVUI[2],pqVUI$3=pqVUI[3];

// initialisation 
 int cVUI=0,r0=0;
for (int i = 1; i < pcVUI.length -1; i++) {
 cVUI= pcVUI[i] ;condvui$0[i]=(( cVUI  &  ppVUI$0[i] ) | ((r0=~ cVUI ) &  pqVUI$0[i] ));condvui$1[i]=(( cVUI  &  ppVUI$1[i] ) | ((r0=~ cVUI ) &  pqVUI$1[i] ));condvui$2[i]=(( cVUI  &  ppVUI$2[i] ) | ((r0=~ cVUI ) &  pqVUI$2[i] ));
 condvui$3[i]=(( cVUI  &  ppVUI$3[i] ) | ((r0=~ cVUI ) &  pqVUI$3[i] ));
  }
  p.mirror(condvui);
p.prepareBit(condvui)
 ;
  }}