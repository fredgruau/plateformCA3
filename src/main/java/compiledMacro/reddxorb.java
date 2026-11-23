package compiledMacro;
 import simulator.PrShift;
 public class reddxorb{
 
public static int ev_1_1GateCount=3;
 public static void ev_1_1(PrShift p,int [][] ppVE,int [][] reddxorbevR){
 int[] reddxorbevR$h=reddxorbevR[0],reddxorbevR$d=reddxorbevR[1],reddxorbevR$ad=reddxorbevR[2],ppVE$h1=ppVE[0],ppVE$h2=ppVE[1],ppVE$d1=ppVE[2],ppVE$d2=ppVE[3],ppVE$ad1=ppVE[4],ppVE$ad2=ppVE[5];


for (int i = 1; i < ppVE$h1.length -1; i++) {
 reddxorbevR$h[i]=( ppVE$h1[i]  ^  ppVE$h2[i] );reddxorbevR$d[i]=( ppVE$d1[i]  ^  ppVE$d2[i] );reddxorbevR$ad[i]=( ppVE$ad1[i]  ^  ppVE$ad2[i] );
  }
  ;
p.prepareBit(reddxorbevR)
 ;
  }
public static int vf_1_1GateCount=5;
 public static void vf_1_1(PrShift p,int [][] ppFV,int [] reddxorbvfR){
 int[] ppFV$es=ppFV[0],ppFV$s=ppFV[1],ppFV$ws=ppFV[2],ppFV$wn=ppFV[3],ppFV$n=ppFV[4],ppFV$en=ppFV[5];


for (int i = 1; i < ppFV$es.length -1; i++) {
 reddxorbvfR[i]=((((( ppFV$es[i]  ^  ppFV$s[i] ) ^  ppFV$ws[i] ) ^  ppFV$wn[i] ) ^  ppFV$n[i] ) ^  ppFV$en[i] );
  }
  p.mirror(reddxorbvfR);
p.prepareBit(reddxorbvfR)
 ;
  }
public static int fv_1_1GateCount=4;
 public static void fv_1_1(PrShift p,int [][] ppVF,int [][] reddxorbfvR){
 int[] reddxorbfvR$do=reddxorbfvR[0],reddxorbfvR$up=reddxorbfvR[1],ppVF$dop=ppVF[0],ppVF$dob1=ppVF[1],ppVF$dob2=ppVF[2],ppVF$upp=ppVF[3],ppVF$upb1=ppVF[4],ppVF$upb2=ppVF[5];


for (int i = 1; i < ppVF$dop.length -1; i++) {
 reddxorbfvR$do[i]=(( ppVF$dop[i]  ^  ppVF$dob1[i] ) ^  ppVF$dob2[i] );reddxorbfvR$up[i]=(( ppVF$upp[i]  ^  ppVF$upb1[i] ) ^  ppVF$upb2[i] );
  }
  ;
p.prepareBit(reddxorbfvR)
 ;
  }
public static int ef_1_1GateCount=3;
 public static void ef_1_1(PrShift p,int [][] ppFE,int [][] reddxorbefR){
int[] reddxorbefR$h=reddxorbefR[0],reddxorbefR$d=reddxorbefR[1],reddxorbefR$ad=reddxorbefR[2],ppFE$h1=ppFE[0],ppFE$h2=ppFE[1],ppFE$d1=ppFE[2],ppFE$d2=ppFE[3],ppFE$ad1=ppFE[4],ppFE$ad2=ppFE[5];;;;

for (int i = 1; i < ppFE$h1.length -1; i++) {
 reddxorbefR$h[i]=( ppFE$h1[i]  ^  ppFE$h2[i] );reddxorbefR$d[i]=( ppFE$d1[i]  ^  ppFE$d2[i] );reddxorbefR$ad[i]=( ppFE$ad1[i]  ^  ppFE$ad2[i] );   }
 ;p.prepareBit(reddxorbefR) ;   }}