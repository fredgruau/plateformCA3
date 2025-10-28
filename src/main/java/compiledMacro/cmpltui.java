package compiledMacro;
 import simulator.PrShift;
 public class cmpltui{
 
public static int vui_3_3_1GateCount=14;
 public static void vui_3_3_1(PrShift p,int [][] ppVUI,int [][] pqVUI,int [] cmpltuivui){
 int[] ppVUI$0=ppVUI[0],ppVUI$1=ppVUI[1],ppVUI$2=ppVUI[2],pqVUI$0=pqVUI[0],pqVUI$1=pqVUI[1],pqVUI$2=pqVUI[2];

// initialisation 
 int r0=0,r1=0,r2=0,r3=0;
for (int i = 1; i < ppVUI$0.length -1; i++) {
 r2=((r1=(r0=( ppVUI$2[i]  ^  pqVUI$2[i] ))) &  pqVUI$2[i] );r2=( r2  | ((~(r3= r1 ) & (r1=(r0=( r0  | ( ppVUI$1[i]  ^  pqVUI$1[i] ))))) &  pqVUI$1[i] ));r2=( r2  | ((~ r1  & ( r0  | ( ppVUI$0[i]  ^  pqVUI$0[i] ))) &  pqVUI$0[i] ));cmpltuivui[i]= r2 ;
  }
  p.border(cmpltuivui);
 ;
  }
public static int vui_4_4_1GateCount=20;
 public static void vui_4_4_1(PrShift p,int [][] ppVUI,int [][] pqVUI,int [] cmpltuivui){
 int[] ppVUI$0=ppVUI[0],ppVUI$1=ppVUI[1],ppVUI$2=ppVUI[2],ppVUI$3=ppVUI[3],pqVUI$0=pqVUI[0],pqVUI$1=pqVUI[1],pqVUI$2=pqVUI[2],pqVUI$3=pqVUI[3];

// initialisation 
 int r0=0,r1=0,r2=0,r3=0;
for (int i = 1; i < ppVUI$0.length -1; i++) {
 r3=((r2=(r0=( ppVUI$3[i]  ^  pqVUI$3[i] ))) &  pqVUI$3[i] );r3=( r3  | ((~(r1= r2 ) & (r2=(r0=( r0  | ( ppVUI$2[i]  ^  pqVUI$2[i] ))))) &  pqVUI$2[i] ));r3=( r3  | ((~(r1= r2 ) & (r2=(r0=( r0  | ( ppVUI$1[i]  ^  pqVUI$1[i] ))))) &  pqVUI$1[i] ));r3=( r3  | ((~ r2  & ( r0  | ( ppVUI$0[i]  ^  pqVUI$0[i] ))) &  pqVUI$0[i] ));
 cmpltuivui[i]= r3 ;
  }
  p.mirror(cmpltuivui);
p.prepareBit(cmpltuivui)
 ;
  }}