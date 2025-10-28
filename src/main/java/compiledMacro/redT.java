package compiledMacro;
 import simulator.PrShift;
 public class redT{
 
public static int enlargeFE_1_1GateCount=6;
 public static void enlargeFE_1_1(PrShift p,int [][] penlarge,int [][] redTenlargeFE){
 int[] redTenlargeFE$e=redTenlargeFE[0],redTenlargeFE$se=redTenlargeFE[1],redTenlargeFE$sw=redTenlargeFE[2],redTenlargeFE$w=redTenlargeFE[3],redTenlargeFE$nw=redTenlargeFE[4],redTenlargeFE$ne=redTenlargeFE[5],penlarge$es=penlarge[0],penlarge$s=penlarge[1],penlarge$ws=penlarge[2],penlarge$wn=penlarge[3],penlarge$n=penlarge[4],penlarge$en=penlarge[5];

// initialisation 
 int auxL04=0,enlarge=0,shiftenlarge=0;
for (int i = 1; i < penlarge$es.length -1; i++) {
 auxL04= penlarge$en[i] ;enlarge= penlarge$es[i] ;redTenlargeFE$e[i]=( enlarge  |  auxL04 );shiftenlarge= enlarge ;
 enlarge= penlarge$s[i] ;redTenlargeFE$se[i]=( enlarge  |  shiftenlarge );shiftenlarge= enlarge ;enlarge= penlarge$ws[i] ;
 redTenlargeFE$sw[i]=( enlarge  |  shiftenlarge );shiftenlarge= enlarge ;enlarge= penlarge$wn[i] ;redTenlargeFE$w[i]=( enlarge  |  shiftenlarge );
 shiftenlarge= enlarge ;enlarge= penlarge$n[i] ;redTenlargeFE$nw[i]=( enlarge  |  shiftenlarge );shiftenlarge= enlarge ;
 redTenlargeFE$ne[i]=( auxL04  |  shiftenlarge );
  }
  ;
p.prepareBit(redTenlargeFE)
 ;
  }
public static int enlargeEF_1_1GateCount=6;
 public static void enlargeEF_1_1(PrShift p,int [][] penlarge,int [][] redTenlargeEF){
 int[] redTenlargeEF$es=redTenlargeEF[0],redTenlargeEF$s=redTenlargeEF[1],redTenlargeEF$ws=redTenlargeEF[2],redTenlargeEF$wn=redTenlargeEF[3],redTenlargeEF$n=redTenlargeEF[4],redTenlargeEF$en=redTenlargeEF[5],penlarge$e=penlarge[0],penlarge$se=penlarge[1],penlarge$sw=penlarge[2],penlarge$w=penlarge[3],penlarge$nw=penlarge[4],penlarge$ne=penlarge[5];

// initialisation 
 int auxL06=0,enlarge=0,shiftenlarge=0;
for (int i = 1; i < penlarge$e.length -1; i++) {
 auxL06= penlarge$e[i] ;enlarge= penlarge$se[i] ;redTenlargeEF$es[i]=( enlarge  |  auxL06 );shiftenlarge= enlarge ;
 enlarge= penlarge$sw[i] ;redTenlargeEF$s[i]=( enlarge  |  shiftenlarge );shiftenlarge= enlarge ;enlarge= penlarge$w[i] ;
 redTenlargeEF$ws[i]=( enlarge  |  shiftenlarge );shiftenlarge= enlarge ;enlarge= penlarge$nw[i] ;redTenlargeEF$wn[i]=( enlarge  |  shiftenlarge );
 shiftenlarge= enlarge ;enlarge= penlarge$ne[i] ;redTenlargeEF$n[i]=( enlarge  |  shiftenlarge );shiftenlarge= enlarge ;
 redTenlargeEF$en[i]=( auxL06  |  shiftenlarge );
  }
  ;
p.prepareBit(redTenlargeEF)
 ;
  }}