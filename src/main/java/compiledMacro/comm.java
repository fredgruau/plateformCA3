package compiledMacro;
 import simulator.PrShift;
 public class comm{
 
public static int apexEtoVui_5_5GateCount=0;
 public static void apexEtoVui_5_5(PrShift p,int [][] pdistantEdgeef,int [][] apexEf){
 int[] apexEf$h1$0=apexEf[0],apexEf$h1$1=apexEf[1],apexEf$h1$2=apexEf[2],apexEf$h1$3=apexEf[3],apexEf$h1$4=apexEf[4],apexEf$h2$0=apexEf[5],apexEf$h2$1=apexEf[6],apexEf$h2$2=apexEf[7],apexEf$h2$3=apexEf[8],apexEf$h2$4=apexEf[9],apexEf$d1$0=apexEf[10],apexEf$d1$1=apexEf[11],apexEf$d1$2=apexEf[12],apexEf$d1$3=apexEf[13],apexEf$d1$4=apexEf[14],apexEf$d2$0=apexEf[15],apexEf$d2$1=apexEf[16],apexEf$d2$2=apexEf[17],apexEf$d2$3=apexEf[18],apexEf$d2$4=apexEf[19],apexEf$ad1$0=apexEf[20],apexEf$ad1$1=apexEf[21],apexEf$ad1$2=apexEf[22],apexEf$ad1$3=apexEf[23],apexEf$ad1$4=apexEf[24],apexEf$ad2$0=apexEf[25],apexEf$ad2$1=apexEf[26],apexEf$ad2$2=apexEf[27],apexEf$ad2$3=apexEf[28],apexEf$ad2$4=apexEf[29],pdistantEdgeef$es$0=pdistantEdgeef[0],pdistantEdgeef$es$1=pdistantEdgeef[1],pdistantEdgeef$es$2=pdistantEdgeef[2],pdistantEdgeef$es$3=pdistantEdgeef[3],pdistantEdgeef$es$4=pdistantEdgeef[4],pdistantEdgeef$s$0=pdistantEdgeef[5],pdistantEdgeef$s$1=pdistantEdgeef[6],pdistantEdgeef$s$2=pdistantEdgeef[7],pdistantEdgeef$s$3=pdistantEdgeef[8],pdistantEdgeef$s$4=pdistantEdgeef[9],pdistantEdgeef$ws$0=pdistantEdgeef[10],pdistantEdgeef$ws$1=pdistantEdgeef[11],pdistantEdgeef$ws$2=pdistantEdgeef[12],pdistantEdgeef$ws$3=pdistantEdgeef[13],pdistantEdgeef$ws$4=pdistantEdgeef[14],pdistantEdgeef$wn$0=pdistantEdgeef[15],pdistantEdgeef$wn$1=pdistantEdgeef[16],pdistantEdgeef$wn$2=pdistantEdgeef[17],pdistantEdgeef$wn$3=pdistantEdgeef[18],pdistantEdgeef$wn$4=pdistantEdgeef[19],pdistantEdgeef$n$0=pdistantEdgeef[20],pdistantEdgeef$n$1=pdistantEdgeef[21],pdistantEdgeef$n$2=pdistantEdgeef[22],pdistantEdgeef$n$3=pdistantEdgeef[23],pdistantEdgeef$n$4=pdistantEdgeef[24],pdistantEdgeef$en$0=pdistantEdgeef[25],pdistantEdgeef$en$1=pdistantEdgeef[26],pdistantEdgeef$en$2=pdistantEdgeef[27],pdistantEdgeef$en$3=pdistantEdgeef[28],pdistantEdgeef$en$4=pdistantEdgeef[29];

// initialisation 
 int tmun28$0=0,tmun28$1=0,tmun28$2=0,tmun28$3=0,tmun28$4=0,tmun29$0=0,tmun29$1=0,tmun29$2=0,tmun29$3=0,tmun29$4=0;
for (int i = 1; i < pdistantEdgeef$es$0.length -1; i++) {
 apexEf$h1$0[i]=( tmun28$0  <<  1 );apexEf$h1$1[i]=( tmun28$1  <<  1 );apexEf$h1$2[i]=( tmun28$2  <<  1 );apexEf$h1$3[i]=( tmun28$3  <<  1 );
 apexEf$h1$4[i]=( tmun28$4  <<  1 );tmun28$0= pdistantEdgeef$s$0[i] ;tmun28$1= pdistantEdgeef$s$1[i] ;tmun28$2= pdistantEdgeef$s$2[i] ;
 tmun28$3= pdistantEdgeef$s$3[i] ;tmun28$4= pdistantEdgeef$s$4[i] ;apexEf$h2$0[i-1]= pdistantEdgeef$n$0[i] ;apexEf$h2$1[i-1]= pdistantEdgeef$n$1[i] ;
 apexEf$h2$2[i-1]= pdistantEdgeef$n$2[i] ;apexEf$h2$3[i-1]= pdistantEdgeef$n$3[i] ;apexEf$h2$4[i-1]= pdistantEdgeef$n$4[i] ;apexEf$d1$0[i]=( pdistantEdgeef$ws$0[i]  <<  1 );
 apexEf$d1$1[i]=( pdistantEdgeef$ws$1[i]  <<  1 );apexEf$d1$2[i]=( pdistantEdgeef$ws$2[i]  <<  1 );apexEf$d1$3[i]=( pdistantEdgeef$ws$3[i]  <<  1 );apexEf$d1$4[i]=( pdistantEdgeef$ws$4[i]  <<  1 );
 apexEf$d2$0[i-1]=( pdistantEdgeef$en$0[i]  >>>  1 );apexEf$d2$1[i-1]=( pdistantEdgeef$en$1[i]  >>>  1 );apexEf$d2$2[i-1]=( pdistantEdgeef$en$2[i]  >>>  1 );apexEf$d2$3[i-1]=( pdistantEdgeef$en$3[i]  >>>  1 );
 apexEf$d2$4[i-1]=( pdistantEdgeef$en$4[i]  >>>  1 );apexEf$ad1$0[i-1]= pdistantEdgeef$wn$0[i] ;apexEf$ad1$1[i-1]= pdistantEdgeef$wn$1[i] ;apexEf$ad1$2[i-1]= pdistantEdgeef$wn$2[i] ;
 apexEf$ad1$3[i-1]= pdistantEdgeef$wn$3[i] ;apexEf$ad1$4[i-1]= pdistantEdgeef$wn$4[i] ;apexEf$ad2$0[i-1]=( tmun29$0  >>>  1 );apexEf$ad2$1[i-1]=( tmun29$1  >>>  1 );
 apexEf$ad2$2[i-1]=( tmun29$2  >>>  1 );apexEf$ad2$3[i-1]=( tmun29$3  >>>  1 );apexEf$ad2$4[i-1]=( tmun29$4  >>>  1 );tmun29$0= pdistantEdgeef$es$0[i] ;
 tmun29$1= pdistantEdgeef$es$1[i] ;tmun29$2= pdistantEdgeef$es$2[i] ;tmun29$3= pdistantEdgeef$es$3[i] ;tmun29$4= pdistantEdgeef$es$4[i] ;
  }
  ;
p.prepareBit(apexEf)
 ;
  }
public static int neighborsUI_5_5GateCount=0;
 public static void neighborsUI_5_5(PrShift p,int [][] pngh,int [][] ver){
 int[] ver$e$0=ver[0],ver$e$1=ver[1],ver$e$2=ver[2],ver$e$3=ver[3],ver$e$4=ver[4],ver$se$0=ver[5],ver$se$1=ver[6],ver$se$2=ver[7],ver$se$3=ver[8],ver$se$4=ver[9],ver$sw$0=ver[10],ver$sw$1=ver[11],ver$sw$2=ver[12],ver$sw$3=ver[13],ver$sw$4=ver[14],ver$w$0=ver[15],ver$w$1=ver[16],ver$w$2=ver[17],ver$w$3=ver[18],ver$w$4=ver[19],ver$nw$0=ver[20],ver$nw$1=ver[21],ver$nw$2=ver[22],ver$nw$3=ver[23],ver$nw$4=ver[24],ver$ne$0=ver[25],ver$ne$1=ver[26],ver$ne$2=ver[27],ver$ne$3=ver[28],ver$ne$4=ver[29],pngh$e$0=pngh[0],pngh$e$1=pngh[1],pngh$e$2=pngh[2],pngh$e$3=pngh[3],pngh$e$4=pngh[4],pngh$se$0=pngh[5],pngh$se$1=pngh[6],pngh$se$2=pngh[7],pngh$se$3=pngh[8],pngh$se$4=pngh[9],pngh$sw$0=pngh[10],pngh$sw$1=pngh[11],pngh$sw$2=pngh[12],pngh$sw$3=pngh[13],pngh$sw$4=pngh[14],pngh$w$0=pngh[15],pngh$w$1=pngh[16],pngh$w$2=pngh[17],pngh$w$3=pngh[18],pngh$w$4=pngh[19],pngh$nw$0=pngh[20],pngh$nw$1=pngh[21],pngh$nw$2=pngh[22],pngh$nw$3=pngh[23],pngh$nw$4=pngh[24],pngh$ne$0=pngh[25],pngh$ne$1=pngh[26],pngh$ne$2=pngh[27],pngh$ne$3=pngh[28],pngh$ne$4=pngh[29];

// initialisation 
 int tmun45$0=0,tmun45$1=0,tmun45$2=0,tmun45$3=0,tmun45$4=0,tmun46$0=0,tmun46$1=0,tmun46$2=0,tmun46$3=0,tmun46$4=0,tmun47$0=0,tmun47$1=0,tmun47$2=0,tmun47$3=0,tmun47$4=0;
for (int i = 1; i < pngh$e$0.length -1; i++) {
 ver$e$0[i]=( pngh$w$0[i]  <<  1 );ver$e$1[i]=( pngh$w$1[i]  <<  1 );ver$e$2[i]=( pngh$w$2[i]  <<  1 );ver$e$3[i]=( pngh$w$3[i]  <<  1 );
 ver$e$4[i]=( pngh$w$4[i]  <<  1 );ver$se$0[i-1]= pngh$nw$0[i] ;ver$se$1[i-1]= pngh$nw$1[i] ;ver$se$2[i-1]= pngh$nw$2[i] ;
 ver$se$3[i-1]= pngh$nw$3[i] ;ver$se$4[i-1]= pngh$nw$4[i] ;ver$sw$0[i-1]=( pngh$ne$0[i]  >>>  1 );ver$sw$1[i-1]=( pngh$ne$1[i]  >>>  1 );
 ver$sw$2[i-1]=( pngh$ne$2[i]  >>>  1 );ver$sw$3[i-1]=( pngh$ne$3[i]  >>>  1 );ver$sw$4[i-1]=( pngh$ne$4[i]  >>>  1 );ver$w$0[i-1]=( tmun45$0  >>>  1 );
 ver$w$1[i-1]=( tmun45$1  >>>  1 );ver$w$2[i-1]=( tmun45$2  >>>  1 );ver$w$3[i-1]=( tmun45$3  >>>  1 );ver$w$4[i-1]=( tmun45$4  >>>  1 );
 tmun45$0= pngh$e$0[i] ;tmun45$1= pngh$e$1[i] ;tmun45$2= pngh$e$2[i] ;tmun45$3= pngh$e$3[i] ;
 tmun45$4= pngh$e$4[i] ;ver$nw$0[i]= tmun46$0 ;ver$nw$1[i]= tmun46$1 ;ver$nw$2[i]= tmun46$2 ;
 ver$nw$3[i]= tmun46$3 ;ver$nw$4[i]= tmun46$4 ;tmun46$0= pngh$se$0[i] ;tmun46$1= pngh$se$1[i] ;
 tmun46$2= pngh$se$2[i] ;tmun46$3= pngh$se$3[i] ;tmun46$4= pngh$se$4[i] ;ver$ne$0[i]=( tmun47$0  <<  1 );
 ver$ne$1[i]=( tmun47$1  <<  1 );ver$ne$2[i]=( tmun47$2  <<  1 );ver$ne$3[i]=( tmun47$3  <<  1 );ver$ne$4[i]=( tmun47$4  <<  1 );
 tmun47$0= pngh$sw$0[i] ;tmun47$1= pngh$sw$1[i] ;tmun47$2= pngh$sw$2[i] ;tmun47$3= pngh$sw$3[i] ;
 tmun47$4= pngh$sw$4[i] ;
  }
  ;
p.prepareBit(ver)
 ;
  }
public static int apexVtoE_1_1GateCount=0;
 public static void apexVtoE_1_1(PrShift p,int [][] pdistantEdgeef,int [][] apexEf){
 int[] apexEf$h1=apexEf[0],apexEf$h2=apexEf[1],apexEf$d1=apexEf[2],apexEf$d2=apexEf[3],apexEf$ad1=apexEf[4],apexEf$ad2=apexEf[5],pdistantEdgeef$es=pdistantEdgeef[0],pdistantEdgeef$s=pdistantEdgeef[1],pdistantEdgeef$ws=pdistantEdgeef[2],pdistantEdgeef$wn=pdistantEdgeef[3],pdistantEdgeef$n=pdistantEdgeef[4],pdistantEdgeef$en=pdistantEdgeef[5];

// initialisation 
 int tmun32=0,tmun33=0;
for (int i = 1; i < pdistantEdgeef$es.length -1; i++) {
 apexEf$h1[i]=( tmun32  <<  1 );tmun32= pdistantEdgeef$s[i] ;apexEf$h2[i-1]= pdistantEdgeef$n[i] ;apexEf$d1[i]=( pdistantEdgeef$ws[i]  <<  1 );
 apexEf$d2[i-1]=( pdistantEdgeef$en[i]  >>>  1 );apexEf$ad1[i-1]= pdistantEdgeef$wn[i] ;apexEf$ad2[i-1]=( tmun33  >>>  1 );tmun33= pdistantEdgeef$es[i] ;
  }
  ;
p.prepareBit(apexEf)
 ;
  }
public static int apexEtoV_1_1GateCount=0;
 public static void apexEtoV_1_1(PrShift p,int [][] pdistantEdgevf,int [][] apexVf){
 int[] apexVf$es=apexVf[0],apexVf$s=apexVf[1],apexVf$ws=apexVf[2],apexVf$wn=apexVf[3],apexVf$n=apexVf[4],apexVf$en=apexVf[5],pdistantEdgevf$h1=pdistantEdgevf[0],pdistantEdgevf$h2=pdistantEdgevf[1],pdistantEdgevf$d1=pdistantEdgevf[2],pdistantEdgevf$d2=pdistantEdgevf[3],pdistantEdgevf$ad1=pdistantEdgevf[4],pdistantEdgevf$ad2=pdistantEdgevf[5];

// initialisation 
 int tmun07=0,tmun08=0,tmun09=0,tmun10=0;
for (int i = 1; i < pdistantEdgevf$h1.length -1; i++) {
 apexVf$es[i]=( pdistantEdgevf$ad2[i]  <<  1 );apexVf$s[i-1]=( pdistantEdgevf$h1[i]  >>>  1 );apexVf$ws[i-1]=( tmun07  >>>  1 );tmun07= pdistantEdgevf$d1[i] ;
 apexVf$wn[i]= tmun08 ;tmun08= pdistantEdgevf$ad1[i] ;apexVf$n[i]= tmun09 ;tmun09= pdistantEdgevf$h2[i] ;
 apexVf$en[i]=( tmun10  <<  1 );tmun10= pdistantEdgevf$d2[i] ;
  }
  ;
p.prepareBit(apexVf)
 ;
  }
public static int neighborsEv_1_1GateCount=0;
 public static void neighborsEv_1_1(PrShift p,int [][] pnghhhh,int [][] ver){
 int[] ver$h1=ver[0],ver$h2=ver[1],ver$d1=ver[2],ver$d2=ver[3],ver$ad1=ver[4],ver$ad2=ver[5],pnghhhh$e=pnghhhh[0],pnghhhh$se=pnghhhh[1],pnghhhh$sw=pnghhhh[2],pnghhhh$w=pnghhhh[3],pnghhhh$nw=pnghhhh[4],pnghhhh$ne=pnghhhh[5];


for (int i = 1; i < pnghhhh$e.length -1; i++) {
 ver$h1[i]= pnghhhh$w[i] ;ver$h2[i]=( pnghhhh$e[i]  <<  1 );ver$d1[i]= pnghhhh$nw[i] ;ver$d2[i-1]= pnghhhh$se[i] ;
 ver$ad1[i]= pnghhhh$ne[i] ;ver$ad2[i-1]=( pnghhhh$sw[i]  >>>  1 );
  }
  ;
p.prepareBit(ver)
 ;
  }
public static int neighbors_1_1GateCount=0;
 public static void neighbors_1_1(PrShift p,int [][] pngh,int [][] commneighbors){
 int[] commneighbors$e=commneighbors[0],commneighbors$se=commneighbors[1],commneighbors$sw=commneighbors[2],commneighbors$w=commneighbors[3],commneighbors$nw=commneighbors[4],commneighbors$ne=commneighbors[5],pngh$e=pngh[0],pngh$se=pngh[1],pngh$sw=pngh[2],pngh$w=pngh[3],pngh$nw=pngh[4],pngh$ne=pngh[5];

// initialisation 
 int tmun49=0,tmun50=0,tmun51=0;
for (int i = 1; i < pngh$e.length -1; i++) {
 commneighbors$e[i]=( pngh$w[i]  <<  1 );commneighbors$se[i-1]= pngh$nw[i] ;commneighbors$sw[i-1]=( pngh$ne[i]  >>>  1 );commneighbors$w[i-1]=( tmun49  >>>  1 );
 tmun49= pngh$e[i] ;commneighbors$nw[i]= tmun50 ;tmun50= pngh$se[i] ;commneighbors$ne[i]=( tmun51  <<  1 );
 tmun51= pngh$sw[i] ;
  }
  ;
p.prepareBit(commneighbors)
 ;
  }}