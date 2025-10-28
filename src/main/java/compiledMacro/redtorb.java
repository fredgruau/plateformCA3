package compiledMacro;
 import simulator.PrShift;
 public class redtorb{
 
public static int ve_1_1GateCount=6;
 public static void ve_1_1(PrShift p,int [][] ppVE,int [][] redtorbve){
 int[] redtorbve$es=redtorbve[0],redtorbve$s=redtorbve[1],redtorbve$ws=redtorbve[2],redtorbve$wn=redtorbve[3],redtorbve$n=redtorbve[4],redtorbve$en=redtorbve[5],ppVE$e=ppVE[0],ppVE$se=ppVE[1],ppVE$sw=ppVE[2],ppVE$w=ppVE[3],ppVE$nw=ppVE[4],ppVE$ne=ppVE[5];

// initialisation 
 int auxL44=0,pVE=0,shiftpVE=0;
for (int i = 1; i < ppVE$e.length -1; i++) {
 auxL44= ppVE$e[i] ;pVE= ppVE$se[i] ;redtorbve$es[i]=( pVE  |  auxL44 );shiftpVE= pVE ;
 pVE= ppVE$sw[i] ;redtorbve$s[i]=( pVE  |  shiftpVE );shiftpVE= pVE ;pVE= ppVE$w[i] ;
 redtorbve$ws[i]=( pVE  |  shiftpVE );shiftpVE= pVE ;pVE= ppVE$nw[i] ;redtorbve$wn[i]=( pVE  |  shiftpVE );
 shiftpVE= pVE ;pVE= ppVE$ne[i] ;redtorbve$n[i]=( pVE  |  shiftpVE );shiftpVE= pVE ;
 redtorbve$en[i]=( auxL44  |  shiftpVE );
  }
  ;
p.prepareBit(redtorbve)
 ;
  }}