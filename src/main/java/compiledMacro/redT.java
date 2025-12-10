package compiledMacro;
 import simulator.PrShift;
 public class redT{
 
public static int shrinkFE_1_1GateCount=6;
 public static void shrinkFE_1_1(PrShift p,int [][] pshrink,int [][] redTshrinkFE){
 int[] redTshrinkFE$e=redTshrinkFE[0],redTshrinkFE$se=redTshrinkFE[1],redTshrinkFE$sw=redTshrinkFE[2],redTshrinkFE$w=redTshrinkFE[3],redTshrinkFE$nw=redTshrinkFE[4],redTshrinkFE$ne=redTshrinkFE[5],pshrink$es=pshrink[0],pshrink$s=pshrink[1],pshrink$ws=pshrink[2],pshrink$wn=pshrink[3],pshrink$n=pshrink[4],pshrink$en=pshrink[5];

// initialisation 
 int auxL94=0,shiftshrink=0,shrink=0;
for (int i = 1; i < pshrink$es.length -1; i++) {
 auxL94= pshrink$en[i] ;shrink= pshrink$es[i] ;redTshrinkFE$e[i]=( shrink  &  auxL94 );shiftshrink= shrink ;
 shrink= pshrink$s[i] ;redTshrinkFE$se[i]=( shrink  &  shiftshrink );shiftshrink= shrink ;shrink= pshrink$ws[i] ;
 redTshrinkFE$sw[i]=( shrink  &  shiftshrink );shiftshrink= shrink ;shrink= pshrink$wn[i] ;redTshrinkFE$w[i]=( shrink  &  shiftshrink );
 shiftshrink= shrink ;shrink= pshrink$n[i] ;redTshrinkFE$nw[i]=( shrink  &  shiftshrink );shiftshrink= shrink ;
 redTshrinkFE$ne[i]=( auxL94  &  shiftshrink );
  }
  ;
p.prepareBit(redTshrinkFE)
 ;
  }
public static int shrinkEF_1_1GateCount=6;
 public static void shrinkEF_1_1(PrShift p,int [][] pshrink,int [][] redTshrinkEF){
 int[] redTshrinkEF$es=redTshrinkEF[0],redTshrinkEF$s=redTshrinkEF[1],redTshrinkEF$ws=redTshrinkEF[2],redTshrinkEF$wn=redTshrinkEF[3],redTshrinkEF$n=redTshrinkEF[4],redTshrinkEF$en=redTshrinkEF[5],pshrink$e=pshrink[0],pshrink$se=pshrink[1],pshrink$sw=pshrink[2],pshrink$w=pshrink[3],pshrink$nw=pshrink[4],pshrink$ne=pshrink[5];

// initialisation 
 int auxL67=0,shiftshrink=0,shrink=0;
for (int i = 1; i < pshrink$e.length -1; i++) {
 auxL67= pshrink$e[i] ;shrink= pshrink$se[i] ;redTshrinkEF$es[i]=( shrink  &  auxL67 );shiftshrink= shrink ;
 shrink= pshrink$sw[i] ;redTshrinkEF$s[i]=( shrink  &  shiftshrink );shiftshrink= shrink ;shrink= pshrink$w[i] ;
 redTshrinkEF$ws[i]=( shrink  &  shiftshrink );shiftshrink= shrink ;shrink= pshrink$nw[i] ;redTshrinkEF$wn[i]=( shrink  &  shiftshrink );
 shiftshrink= shrink ;shrink= pshrink$ne[i] ;redTshrinkEF$n[i]=( shrink  &  shiftshrink );shiftshrink= shrink ;
 redTshrinkEF$en[i]=( auxL67  &  shiftshrink );
  }
  ;
p.prepareBit(redTshrinkEF)
 ;
  }}