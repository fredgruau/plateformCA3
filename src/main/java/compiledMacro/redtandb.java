package compiledMacro;
 import simulator.PrShift;
 public class redtandb{

public static int vf_1_1GateCount=6;
 public static void vf_1_1(PrShift p,int [][] ppVF,int [][] redtandbvf){
 int[] redtandbvf$e=redtandbvf[0],redtandbvf$se=redtandbvf[1],redtandbvf$sw=redtandbvf[2],redtandbvf$w=redtandbvf[3],redtandbvf$nw=redtandbvf[4],redtandbvf$ne=redtandbvf[5],ppVF$es=ppVF[0],ppVF$s=ppVF[1],ppVF$ws=ppVF[2],ppVF$wn=ppVF[3],ppVF$n=ppVF[4],ppVF$en=ppVF[5];

// initialisation 
 int auxL74=0,pVF=0,shiftpVF=0;
for (int i = 1; i < ppVF$es.length -1; i++) {
 auxL74= ppVF$en[i] ;pVF= ppVF$es[i] ;redtandbvf$e[i]=( pVF  &  auxL74 );shiftpVF= pVF ;
 pVF= ppVF$s[i] ;redtandbvf$se[i]=( pVF  &  shiftpVF );shiftpVF= pVF ;pVF= ppVF$ws[i] ;
 redtandbvf$sw[i]=( pVF  &  shiftpVF );shiftpVF= pVF ;pVF= ppVF$wn[i] ;redtandbvf$w[i]=( pVF  &  shiftpVF );
 shiftpVF= pVF ;pVF= ppVF$n[i] ;redtandbvf$nw[i]=( pVF  &  shiftpVF );shiftpVF= pVF ;
 redtandbvf$ne[i]=( auxL74  &  shiftpVF );
  }
  ;
p.prepareBit(redtandbvf)
 ;
  }
public static int ve_1_1GateCount=6;
 public static void ve_1_1(PrShift p,int [][] ppVE,int [][] redtandbve){
 int[] redtandbve$es=redtandbve[0],redtandbve$s=redtandbve[1],redtandbve$ws=redtandbve[2],redtandbve$wn=redtandbve[3],redtandbve$n=redtandbve[4],redtandbve$en=redtandbve[5],ppVE$e=ppVE[0],ppVE$se=ppVE[1],ppVE$sw=ppVE[2],ppVE$w=ppVE[3],ppVE$nw=ppVE[4],ppVE$ne=ppVE[5];

// initialisation 
 int auxL91=0,pVE=0,shiftpVE=0;
for (int i = 1; i < ppVE$e.length -1; i++) {
 auxL91= ppVE$e[i] ;pVE= ppVE$se[i] ;redtandbve$es[i]=( pVE  &  auxL91 );shiftpVE= pVE ;
 pVE= ppVE$sw[i] ;redtandbve$s[i]=( pVE  &  shiftpVE );shiftpVE= pVE ;pVE= ppVE$w[i] ;
 redtandbve$ws[i]=( pVE  &  shiftpVE );shiftpVE= pVE ;pVE= ppVE$nw[i] ;redtandbve$wn[i]=( pVE  &  shiftpVE );
 shiftpVE= pVE ;pVE= ppVE$ne[i] ;redtandbve$n[i]=( pVE  &  shiftpVE );shiftpVE= pVE ;
 redtandbve$en[i]=( auxL91  &  shiftpVE );
  }
  ;
p.prepareBit(redtandbve)
 ;
  }}