package compiledMacro;
 import simulator.PrShift;
 public class topo{
 
public static int nbccV_1_2GateCount=21;
 public static void nbccV_1_2(PrShift p,int [][] pborderE,int [][] toponbccV){
 int[] toponbccV$0=toponbccV[0],toponbccV$1=toponbccV[1],pborderE$h=pborderE[0],pborderE$d=pborderE[1],pborderE$ad=pborderE[2];

// initialisation 
 int asInt$0=0,asInt$1=0,asInt$2=0,asInt$3=0,asInt$4=0,asInt$5=0,auxL51=0,auxL52=0,auxL53=0,auxL54=0,auxL93=0,auxL94=0,auxL95=0,r0=0,r1=0,shiftauxL54=0,tmun11=0,tmun12=0;
for (int i = 1; i < pborderE$h.length -1; i++) {
 auxL95= pborderE$h[i] ;auxL93= pborderE$d[i] ;auxL54= auxL93 ;asInt$1=( auxL54  & ~ auxL95 );
 shiftauxL54= auxL54 ;auxL94= pborderE$ad[i] ;auxL54= auxL94 ;asInt$2=( auxL54  & ~ shiftauxL54 );
 shiftauxL54= auxL54 ;auxL54=( auxL95  >>>  1 );asInt$3=( auxL54  & ~ shiftauxL54 );shiftauxL54= auxL54 ;
 auxL54= tmun11 ;tmun11= auxL93 ;asInt$4=( auxL54  & ~ shiftauxL54 );shiftauxL54= auxL54 ;
 auxL54= tmun12 ;tmun12=( auxL94  <<  1 );asInt$5=( auxL54  & ~ shiftauxL54 );shiftauxL54= auxL54 ;
 asInt$0=( auxL95  & ~ shiftauxL54 );r0= asInt$4 ;r1= asInt$5 ;auxL51=( r0  |  r1 );
 r0= asInt$0 ;r1= asInt$1 ;auxL53=( r0  |  r1 );r0= asInt$3 ;
 r1= asInt$2 ;auxL52=( r1  |  r0 );toponbccV$0[i]=(( auxL53  ^  auxL52 ) ^  auxL51 );toponbccV$1[i]=(( auxL53  &  auxL52 ) | ( auxL51  & ( auxL53  |  auxL52 )));
  }
  p.mirror(toponbccV);
p.prepareBit(toponbccV)
 ;
  }
public static int nbccVe_1_2GateCount=21;
 public static void nbccVe_1_2(PrShift p,int [][] pringAroundV,int [][] toponbccVe){
 int[] toponbccVe$0=toponbccVe[0],toponbccVe$1=toponbccVe[1],pringAroundV$e=pringAroundV[0],pringAroundV$se=pringAroundV[1],pringAroundV$sw=pringAroundV[2],pringAroundV$w=pringAroundV[3],pringAroundV$nw=pringAroundV[4],pringAroundV$ne=pringAroundV[5];

// initialisation 
 int asInt$0=0,asInt$1=0,asInt$2=0,asInt$3=0,asInt$4=0,asInt$5=0,auxL55=0,auxL56=0,auxL57=0,auxL92=0,r0=0,r1=0,ringAroundV=0,shiftringAroundV=0;
for (int i = 1; i < pringAroundV$e.length -1; i++) {
 auxL92= pringAroundV$e[i] ;ringAroundV= pringAroundV$se[i] ;asInt$1=( ringAroundV  & ~ auxL92 );shiftringAroundV= ringAroundV ;
 ringAroundV= pringAroundV$sw[i] ;asInt$2=( ringAroundV  & ~ shiftringAroundV );shiftringAroundV= ringAroundV ;ringAroundV= pringAroundV$w[i] ;
 asInt$3=( ringAroundV  & ~ shiftringAroundV );shiftringAroundV= ringAroundV ;ringAroundV= pringAroundV$nw[i] ;asInt$4=( ringAroundV  & ~ shiftringAroundV );
 shiftringAroundV= ringAroundV ;ringAroundV= pringAroundV$ne[i] ;asInt$5=( ringAroundV  & ~ shiftringAroundV );shiftringAroundV= ringAroundV ;
 asInt$0=( auxL92  & ~ shiftringAroundV );r0= asInt$5 ;r1= asInt$4 ;auxL55=( r1  |  r0 );
 r0= asInt$3 ;r1= asInt$2 ;auxL56=( r1  |  r0 );r0= asInt$0 ;
 r1= asInt$1 ;auxL57=( r0  |  r1 );toponbccVe$0[i]=(( auxL57  ^  auxL56 ) ^  auxL55 );toponbccVe$1[i]=(( auxL57  &  auxL56 ) | ( auxL55  & ( auxL57  |  auxL56 )));
  }
  p.mirror(toponbccVe);
p.prepareBit(toponbccVe)
 ;
  }}