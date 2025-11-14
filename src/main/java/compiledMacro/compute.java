package compiledMacro;
 import simulator.PrShift;
 public class compute{
 
public static int countNeighbors_1_3GateCount=20;
 public static void countNeighbors_1_3(PrShift p,int [][] pneighbor,int [][] computecountNeighbors){
 int[] computecountNeighbors$0=computecountNeighbors[0],computecountNeighbors$1=computecountNeighbors[1],computecountNeighbors$2=computecountNeighbors[2],pneighbor$e=pneighbor[0],pneighbor$se=pneighbor[1],pneighbor$sw=pneighbor[2],pneighbor$w=pneighbor[3],pneighbor$nw=pneighbor[4],pneighbor$ne=pneighbor[5];

// initialisation 
 int auxL00=0,auxL01=0,auxL02=0,auxL03=0,auxL04=0,auxL05=0,auxL06$0=0,auxL06$1=0,auxL06$2=0,auxL06$3=0,auxL06$4=0,auxL06$5=0,r0=0,r1=0,r2=0;
for (int i = 1; i < pneighbor$e.length -1; i++) {
 auxL06$0= pneighbor$e[i] ;auxL06$1= pneighbor$se[i] ;auxL06$2= pneighbor$sw[i] ;auxL06$3= pneighbor$w[i] ;
 auxL06$4= pneighbor$nw[i] ;auxL06$5= pneighbor$ne[i] ;r0= auxL06$4 ;auxL01= r0 ;
 r0= auxL06$0 ;auxL05= r0 ;r0= auxL06$2 ;auxL03= r0 ;
 r0= auxL06$1 ;auxL04= r0 ;r0= auxL06$5 ;auxL00= r0 ;
 r0= auxL06$3 ;auxL02= r0 ;computecountNeighbors$0[i]=((r2=(( auxL05  ^  auxL04 ) ^  auxL03 )) ^ (r0=(( auxL02  ^  auxL01 ) ^  auxL00 )));computecountNeighbors$1[i]=(((r1=( r0  &  r2 )) ^ (r2=(( auxL05  &  auxL04 ) | ( auxL03  & ( auxL05  |  auxL04 ))))) ^ (r0=(( auxL02  &  auxL01 ) | ( auxL00  & ( auxL02  |  auxL01 )))));
 computecountNeighbors$2[i]=(( r1  &  r2 ) | ( r0  & ( r1  |  r2 )));
  }
  p.mirror(computecountNeighbors);
p.prepareBit(computecountNeighbors)
 ;
  }
public static int concat4V_1_1_1_1_4GateCount=0;
 public static void concat4V_1_1_1_1_4(PrShift p,int [] pa,int [] pb,int [] pc,int [] pd,int [][] computeconcat4V){
 int[] computeconcat4V$0=computeconcat4V[0],computeconcat4V$1=computeconcat4V[1],computeconcat4V$2=computeconcat4V[2],computeconcat4V$3=computeconcat4V[3];


for (int i = 1; i < pa.length -1; i++) {
 computeconcat4V$0[i]= pd[i] ;computeconcat4V$1[i]= pc[i] ;computeconcat4V$2[i]= pb[i] ;computeconcat4V$3[i]= pa[i] ;
  }
  p.mirror(computeconcat4V);
p.prepareBit(computeconcat4V)
 ;
  }
public static int implique_1_1_1GateCount=2;
 public static void implique_1_1_1(PrShift p,int [] pa,int [] pb,int [] computeimplique){
 


for (int i = 1; i < pa.length -1; i++) {
 computeimplique[i]=(~ pa[i]  |  pb[i] );
  }
  p.mirror(computeimplique);
p.prepareBit(computeimplique)
 ;
  }}