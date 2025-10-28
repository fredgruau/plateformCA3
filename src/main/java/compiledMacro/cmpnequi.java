package compiledMacro;
 import simulator.PrShift;
 public class cmpnequi{
 
public static int vui_3_3_1GateCount=5;
 public static void vui_3_3_1(PrShift p,int [][] ppVUI,int [][] pqVUI,int [] cmpnequivui){
 int[] ppVUI$0=ppVUI[0],ppVUI$1=ppVUI[1],ppVUI$2=ppVUI[2],pqVUI$0=pqVUI[0],pqVUI$1=pqVUI[1],pqVUI$2=pqVUI[2];

// initialisation 
 int r0=0;
for (int i = 1; i < ppVUI$0.length -1; i++) {
 r0=( ppVUI$0[i]  ^  pqVUI$0[i] );r0=( r0  | ( ppVUI$1[i]  ^  pqVUI$1[i] ));r0=( r0  | ( ppVUI$2[i]  ^  pqVUI$2[i] ));cmpnequivui[i]= r0 ;
  }
  p.border(cmpnequivui);
 ;
  }
public static int vui_4_4_1GateCount=7;
 public static void vui_4_4_1(PrShift p,int [][] ppVUI,int [][] pqVUI,int [] cmpnequivui){
 int[] ppVUI$0=ppVUI[0],ppVUI$1=ppVUI[1],ppVUI$2=ppVUI[2],ppVUI$3=ppVUI[3],pqVUI$0=pqVUI[0],pqVUI$1=pqVUI[1],pqVUI$2=pqVUI[2],pqVUI$3=pqVUI[3];

// initialisation 
 int r0=0;
for (int i = 1; i < ppVUI$0.length -1; i++) {
 r0=( ppVUI$0[i]  ^  pqVUI$0[i] );r0=( r0  | ( ppVUI$1[i]  ^  pqVUI$1[i] ));r0=( r0  | ( ppVUI$2[i]  ^  pqVUI$2[i] ));r0=( r0  | ( ppVUI$3[i]  ^  pqVUI$3[i] ));
 cmpnequivui[i]= r0 ;
  }
  p.mirror(cmpnequivui);
p.prepareBit(cmpnequivui)
 ;
  }}