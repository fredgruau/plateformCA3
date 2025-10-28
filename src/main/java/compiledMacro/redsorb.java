package compiledMacro;
 import simulator.PrShift;
 public class redsorb{
 
public static int fe_1_1GateCount=3;
 public static void fe_1_1(PrShift p,int [][] ppFE,int [][] redsorbfeR){
 int[] redsorbfeR$h=redsorbfeR[0],redsorbfeR$d=redsorbfeR[1],redsorbfeR$ad=redsorbfeR[2],ppFE$do=ppFE[0],ppFE$up=ppFE[1];

// initialisation 
 int auxL26=0,auxL27=0,tmun02=0;
for (int i = 1; i < ppFE$do.length -1; i++) {
 auxL27= ppFE$do[i] ;auxL26= ppFE$up[i] ;redsorbfeR$h[i]=( auxL27  |  tmun02 );tmun02=( auxL26  <<  1 );
 redsorbfeR$d[i]=( auxL27  |  auxL26 );redsorbfeR$ad[i]=( auxL26  | ( auxL27  >>>  1 ));
  }
  ;
p.prepareBit(redsorbfeR)
 ;
  }
public static int ef_1_1GateCount=4;
 public static void ef_1_1(PrShift p,int [][] ppEF,int [][] redsorbefR){
 int[] redsorbefR$do=redsorbefR[0],redsorbefR$up=redsorbefR[1],ppEF$h=ppEF[0],ppEF$d=ppEF[1],ppEF$ad=ppEF[2];

// initialisation 
 int auxL44=0,auxL45=0,auxL46=0,redsorbef=0,redsorbeftm1=0;
for (int i = 1; i < ppEF$h.length -1; i++) {
 redsorbefR$do[i-1]=(( auxL44  | ( auxL45  <<  1 )) |  auxL46 );auxL44= ppEF$h[i] ;redsorbef=( redsorbeftm1  | ( auxL44  >>>  1 ));auxL45= ppEF$ad[i] ;
 auxL46= ppEF$d[i] ;redsorbeftm1=( auxL45  |  auxL46 );redsorbefR$up[i-1]= redsorbef ;
  }
  ;
p.prepareBit(redsorbefR)
 ;
  }
public static int ev_1_1GateCount=5;
 public static void ev_1_1(PrShift p,int [][] ppEV,int [] redsorbevR){
 int[] ppEV$h=ppEV[0],ppEV$d=ppEV[1],ppEV$ad=ppEV[2];

// initialisation 
 int auxL48=0,auxL49=0,auxL50=0,tmun08=0;
for (int i = 1; i < ppEV$h.length -1; i++) {
 auxL48= ppEV$h[i] ;auxL49= ppEV$d[i] ;auxL50= ppEV$ad[i] ;redsorbevR[i]=(((( tmun08  |  auxL48 ) |  auxL49 ) |  auxL50 ) | ( auxL48  >>>  1 ));
 tmun08=( auxL49  | ( auxL50  <<  1 ));
  }
  p.mirror(redsorbevR);
p.prepareBit(redsorbevR)
 ;
  }
public static int fv_1_1GateCount=5;
 public static void fv_1_1(PrShift p,int [][] ppFV,int [] redsorbfvR){
 int[] ppFV$do=ppFV[0],ppFV$up=ppFV[1];

// initialisation 
 int auxL78=0,auxL79=0,tmun03=0;
for (int i = 1; i < ppFV$do.length -1; i++) {
 auxL78= ppFV$do[i] ;auxL79= ppFV$up[i] ;redsorbfvR[i]=((( tmun03  |  auxL78 ) |  auxL79 ) | ( auxL78  >>>  1 ));tmun03=(( auxL79  |  auxL78 ) | ( auxL79  <<  1 ));
  }
  p.mirror(redsorbfvR);
p.prepareBit(redsorbfvR)
 ;
  }}