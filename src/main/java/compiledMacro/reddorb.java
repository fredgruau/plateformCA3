package compiledMacro;
 import simulator.PrShift;
 public class reddorb{
 

public static int ev_1_1GateCount=3;
 public static void ev_1_1(PrShift p,int [][] ppVE,int [][] reddorbevR){
 int[] reddorbevR$h=reddorbevR[0],reddorbevR$d=reddorbevR[1],reddorbevR$ad=reddorbevR[2],ppVE$h1=ppVE[0],ppVE$h2=ppVE[1],ppVE$d1=ppVE[2],ppVE$d2=ppVE[3],ppVE$ad1=ppVE[4],ppVE$ad2=ppVE[5];
//p.mirror(ppVE,compiler.Locus.locusEv());p.prepareBit(ppVE)
 ;

for (int i = 1; i < ppVE$h1.length -1; i++) {
 reddorbevR$h[i]=( ppVE$h1[i]  |  ppVE$h2[i] );reddorbevR$d[i]=( ppVE$d1[i]  |  ppVE$d2[i] );reddorbevR$ad[i]=( ppVE$ad1[i]  |  ppVE$ad2[i] );
   }
 p.border(reddorbevR);
 }


 
public static int fv_1_1GateCount=4;
 public static void fv_1_1(PrShift p,int [][] ppVF,int [][] reddorbfvR){
 int[] reddorbfvR$do=reddorbfvR[0],reddorbfvR$up=reddorbfvR[1],ppVF$dop=ppVF[0],ppVF$dob1=ppVF[1],ppVF$dob2=ppVF[2],ppVF$upp=ppVF[3],ppVF$upb1=ppVF[4],ppVF$upb2=ppVF[5];


for (int i = 1; i < ppVF$dop.length -1; i++) {
 reddorbfvR$do[i]=(( ppVF$dop[i]  |  ppVF$dob1[i] ) |  ppVF$dob2[i] );reddorbfvR$up[i]=(( ppVF$upp[i]  |  ppVF$upb1[i] ) |  ppVF$upb2[i] );
  }
  ;
p.prepareBit(reddorbfvR)
 ;
  }
public static int vf_1_1GateCount=5;
 public static void vf_1_1(PrShift p,int [][] ppFV,int [] reddorbvfR){
 int[] ppFV$es=ppFV[0],ppFV$s=ppFV[1],ppFV$ws=ppFV[2],ppFV$wn=ppFV[3],ppFV$n=ppFV[4],ppFV$en=ppFV[5];
 // if(ppFV$es.length<10)   System.out.println("rroororo");

for (int i = 1; i < ppFV$es.length -1; i++) {

 reddorbvfR[i]=((((( ppFV$es[i]  |  ppFV$s[i] ) |  ppFV$ws[i] ) |  ppFV$wn[i] ) |  ppFV$n[i] ) |  ppFV$en[i] );
  }
  p.mirror(reddorbvfR);
p.prepareBit(reddorbvfR)
 ;
  }
public static int ve_1_1GateCount=5;
 public static void ve_1_1(PrShift p,int [][] ppEV,int [] reddorbveR){
 int[] ppEV$e=ppEV[0],ppEV$se=ppEV[1],ppEV$sw=ppEV[2],ppEV$w=ppEV[3],ppEV$nw=ppEV[4],ppEV$ne=ppEV[5];


for (int i = 1; i < ppEV$e.length -1; i++) {
 reddorbveR[i]=((((( ppEV$e[i]  |  ppEV$se[i] ) |  ppEV$sw[i] ) |  ppEV$w[i] ) |  ppEV$nw[i] ) |  ppEV$ne[i] );
  }
  p.mirror(reddorbveR);
p.prepareBit(reddorbveR)
 ;
  }}