package compiledMacro;
 import simulator.PrShift;
 public class reddandb{
 
public static int ve_1_1GateCount=5;
 public static void ve_1_1(PrShift p,int [][] ppEV,int [] reddandbveR){
 int[] ppEV$e=ppEV[0],ppEV$se=ppEV[1],ppEV$sw=ppEV[2],ppEV$w=ppEV[3],ppEV$nw=ppEV[4],ppEV$ne=ppEV[5];


for (int i = 1; i < ppEV$e.length -1; i++) {
 reddandbveR[i]=((((( ppEV$e[i]  &  ppEV$se[i] ) &  ppEV$sw[i] ) &  ppEV$w[i] ) &  ppEV$nw[i] ) &  ppEV$ne[i] );
  }
  p.mirror(reddandbveR);
p.prepareBit(reddandbveR)
 ;
  }
public static int vf_1_1GateCount=5;
 public static void vf_1_1(PrShift p,int [][] ppFV,int [] reddandbvfR){
 int[] ppFV$es=ppFV[0],ppFV$s=ppFV[1],ppFV$ws=ppFV[2],ppFV$wn=ppFV[3],ppFV$n=ppFV[4],ppFV$en=ppFV[5];


for (int i = 1; i < ppFV$es.length -1; i++) {
 reddandbvfR[i]=((((( ppFV$es[i]  &  ppFV$s[i] ) &  ppFV$ws[i] ) &  ppFV$wn[i] ) &  ppFV$n[i] ) &  ppFV$en[i] );
  }
  p.mirror(reddandbvfR);
p.prepareBit(reddandbvfR)
 ;
  }
public static int ef_1_1GateCount=3;
 public static void ef_1_1(PrShift p,int [][] ppFE,int [][] reddandbefR){
 int[] reddandbefR$h=reddandbefR[0],reddandbefR$d=reddandbefR[1],reddandbefR$ad=reddandbefR[2],ppFE$h1=ppFE[0],ppFE$h2=ppFE[1],ppFE$d1=ppFE[2],ppFE$d2=ppFE[3],ppFE$ad1=ppFE[4],ppFE$ad2=ppFE[5];


for (int i = 1; i < ppFE$h1.length -1; i++) {
 reddandbefR$h[i]=( ppFE$h1[i]  &  ppFE$h2[i] );reddandbefR$d[i]=( ppFE$d1[i]  &  ppFE$d2[i] );reddandbefR$ad[i]=( ppFE$ad1[i]  &  ppFE$ad2[i] );
  }
  ;
p.prepareBit(reddandbefR)
 ;
  }}