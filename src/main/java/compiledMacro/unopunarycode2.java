package compiledMacro;
 import simulator.PrShift;
 public class unopunarycode2{
 
public static int v_2_2GateCount=3;
 public static void v_2_2(PrShift p,int [][] ppV,int [][] unopunarycode2v){
 int[] unopunarycode2v$0=unopunarycode2v[0],unopunarycode2v$1=unopunarycode2v[1],ppV$0=ppV[0],ppV$1=ppV[1];

// initialisation 
 int r0=0,r1=0,r2=0,r3=0,r4=0;
for (int i = 1; i < ppV$0.length -1; i++) {
 r3=(r1= ppV$0[i] );r2=(r0=( r1  ^  ppV$1[i] ));r1=~ r0 ;r4=( r1  &  r3 );
 r0= r4 ;unopunarycode2v$0[i]= r2 ;unopunarycode2v$1[i]= r0 ;
  }
  p.mirror(unopunarycode2v);
p.prepareBit(unopunarycode2v)
 ;
  }
public static int v_3_2GateCount=7;
 public static void v_3_2(PrShift p,int [][] ppV,int [][] unopunarycode2v){
 int[] unopunarycode2v$0=unopunarycode2v[0],unopunarycode2v$1=unopunarycode2v[1],ppV$0=ppV[0],ppV$1=ppV[1],ppV$2=ppV[2];

// initialisation 
 int r0=0,r1=0,r2=0,r3=0,r4=0,r5=0,r6=0;
for (int i = 1; i < ppV$0.length -1; i++) {
 r2=(r0= ppV$0[i] );r4=(r0=( r0  ^  ppV$1[i] ));r1=(r3=( r0  ^  ppV$2[i] ));r0=~(r5= r3 );
 r6=~ r4 ;r5=( r6  &  r2 );r5=( r5  ^ ( r0  &  r4 ));r3= r5 ;
 unopunarycode2v$0[i]= r1 ;unopunarycode2v$1[i]= r3 ;
  }
  p.mirror(unopunarycode2v);
p.prepareBit(unopunarycode2v)
 ;
  }
public static int v_1_2GateCount=0;
 public static void v_1_2(PrShift p,int [] ppV,int [][] unopunarycode2v){
 int[] unopunarycode2v$0=unopunarycode2v[0],unopunarycode2v$1=unopunarycode2v[1],ppV$0=ppV;

// initialisation 
 int r0=0,r1=0;
for (int i = 1; i < ppV$0.length -1; i++) {
 r1=(r0= ppV$0[i] );unopunarycode2v$0[i]= r1 ;
  }
  p.mirror(unopunarycode2v);
p.prepareBit(unopunarycode2v)
 ;
  }
public static int v_4_2GateCount=11;
 public static void v_4_2(PrShift p,int [][] ppV,int [][] unopunarycode2v){
 int[] unopunarycode2v$0=unopunarycode2v[0],unopunarycode2v$1=unopunarycode2v[1],ppV$0=ppV[0],ppV$1=ppV[1],ppV$2=ppV[2],ppV$3=ppV[3];

// initialisation 
 int r0=0,r1=0,r2=0,r3=0,r4=0,r5=0,r6=0,r7=0,r8=0;
for (int i = 1; i < ppV$0.length -1; i++) {
 r4=(r2= ppV$0[i] );r1=(r2=( r2  ^  ppV$1[i] ));r0=(r2=( r2  ^  ppV$2[i] ));r5=(r3=( r2  ^  ppV$3[i] ));
 r8=~(r7= r3 );r6=~(r7= r0 );r2=~ r1 ;r3=( r2  &  r4 );
 r3=( r3  ^ ( r6  &  r1 ));r3=( r3  ^ ( r8  &  r0 ));r7= r3 ;unopunarycode2v$0[i]= r5 ;
 unopunarycode2v$1[i]= r7 ;
  }
  p.mirror(unopunarycode2v);
p.prepareBit(unopunarycode2v)
 ;
  }}