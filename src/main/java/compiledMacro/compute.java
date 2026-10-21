package compiledMacro;
 import simulator.PrShift;
 public class compute{
 
public static int countNeighbors_1_3GateCount=20;
 public static void countNeighbors_1_3(PrShift p,int [][] pneighbor,int [][] computecountNeighbors){
 int[] computecountNeighbors$0=computecountNeighbors[0],computecountNeighbors$1=computecountNeighbors[1],computecountNeighbors$2=computecountNeighbors[2],pneighbor$e=pneighbor[0],pneighbor$se=pneighbor[1],pneighbor$sw=pneighbor[2],pneighbor$w=pneighbor[3],pneighbor$nw=pneighbor[4],pneighbor$ne=pneighbor[5];

// initialisation 
 int auxL75=0,auxL76=0,auxL77=0,auxL78=0,auxL79=0,auxL80=0,auxL81$0=0,auxL81$1=0,auxL81$2=0,auxL81$3=0,auxL81$4=0,auxL81$5=0,r0=0,r1=0,r2=0;
for (int i = 1; i < pneighbor$e.length -1; i++) {
 auxL81$0= pneighbor$e[i] ;auxL81$1= pneighbor$se[i] ;auxL81$2= pneighbor$sw[i] ;auxL81$3= pneighbor$w[i] ;
 auxL81$4= pneighbor$nw[i] ;auxL81$5= pneighbor$ne[i] ;r0= auxL81$5 ;auxL75= r0 ;
 r0= auxL81$4 ;auxL76= r0 ;r0= auxL81$3 ;auxL77= r0 ;
 r0= auxL81$0 ;auxL80= r0 ;r0= auxL81$1 ;auxL79= r0 ;
 r0= auxL81$2 ;auxL78= r0 ;computecountNeighbors$0[i]=((r0=(( auxL80  ^  auxL79 ) ^  auxL78 )) ^ (r2=(( auxL77  ^  auxL76 ) ^  auxL75 )));computecountNeighbors$1[i]=(((r1=( r2  &  r0 )) ^ (r0=(( auxL80  &  auxL79 ) | ( auxL78  & ( auxL80  |  auxL79 ))))) ^ (r2=(( auxL77  &  auxL76 ) | ( auxL75  & ( auxL77  |  auxL76 )))));
 computecountNeighbors$2[i]=(( r1  &  r0 ) | ( r2  & ( r1  |  r0 )));
  }
  p.mirror(computecountNeighbors);
p.prepareBit(computecountNeighbors)
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
  }
public static int concat5V_1_1_1_1_1_5GateCount=0;
 public static void concat5V_1_1_1_1_1_5(PrShift p,int [] pa,int [] pb,int [] pc,int [] pd,int [] pe,int [][] computeconcat5V){
 int[] computeconcat5V$0=computeconcat5V[0],computeconcat5V$1=computeconcat5V[1],computeconcat5V$2=computeconcat5V[2],computeconcat5V$3=computeconcat5V[3],computeconcat5V$4=computeconcat5V[4];


for (int i = 1; i < pa.length -1; i++) {
 computeconcat5V$0[i]= pe[i] ;computeconcat5V$1[i]= pd[i] ;computeconcat5V$2[i]= pc[i] ;computeconcat5V$3[i]= pb[i] ;
 computeconcat5V$4[i]= pa[i] ;
  }
  p.mirror(computeconcat5V);
p.prepareBit(computeconcat5V)
 ;
  }}