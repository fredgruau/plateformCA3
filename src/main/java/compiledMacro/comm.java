package compiledMacro;
 import simulator.PrShift;
 public class comm{
 
public static int insdEDef_1_1GateCount=5;
 public static void insdEDef_1_1(PrShift p,int [][] pngh,int [] resR){
 int[] pngh$e=pngh[0],pngh$se=pngh[1],pngh$sw=pngh[2],pngh$w=pngh[3],pngh$nw=pngh[4],pngh$ne=pngh[5];

// initialisation 
 int tmun00=0,tmun01=0,tmun02=0,tmun03=0;
for (int i = 1; i < pngh$e.length -1; i++) {
 resR[i-1]=((( tmun01  &  pngh$nw[i] ) & ( pngh$ne[i]  >>>  1 )) & ( tmun00  >>>  1 ));tmun01=((( pngh$w[i]  <<  1 ) &  tmun03 ) & ( tmun02  <<  1 ));tmun03= pngh$se[i] ;tmun02= pngh$sw[i] ;
 tmun00= pngh$e[i] ;
  }
  p.mirror(resR);
p.prepareBit(resR)
 ;
  }
public static int adjEDef_1_1GateCount=5;
 public static void adjEDef_1_1(PrShift p,int [][] pngh,int [] resR){
 int[] pngh$e=pngh[0],pngh$se=pngh[1],pngh$sw=pngh[2],pngh$w=pngh[3],pngh$nw=pngh[4],pngh$ne=pngh[5];

// initialisation 
 int tmun23=0,tmun24=0,tmun25=0,tmun26=0;
for (int i = 1; i < pngh$e.length -1; i++) {
 resR[i-1]=((( tmun24  |  pngh$nw[i] ) | ( pngh$ne[i]  >>>  1 )) | ( tmun23  >>>  1 ));tmun23= pngh$e[i] ;tmun24=((( pngh$w[i]  <<  1 ) |  tmun26 ) | ( tmun25  <<  1 ));tmun26= pngh$se[i] ;
 tmun25= pngh$sw[i] ;
  }
  p.mirror(resR);
p.prepareBit(resR)
 ;
  }
public static int neighborsUI_3_3GateCount=0;
 public static void neighborsUI_3_3(PrShift p,int [][] pngh,int [][] ver){
 int[] ver$e$0=ver[0],ver$e$1=ver[1],ver$e$2=ver[2],ver$se$0=ver[3],ver$se$1=ver[4],ver$se$2=ver[5],ver$sw$0=ver[6],ver$sw$1=ver[7],ver$sw$2=ver[8],ver$w$0=ver[9],ver$w$1=ver[10],ver$w$2=ver[11],ver$nw$0=ver[12],ver$nw$1=ver[13],ver$nw$2=ver[14],ver$ne$0=ver[15],ver$ne$1=ver[16],ver$ne$2=ver[17],pngh$e$0=pngh[0],pngh$e$1=pngh[1],pngh$e$2=pngh[2],pngh$se$0=pngh[3],pngh$se$1=pngh[4],pngh$se$2=pngh[5],pngh$sw$0=pngh[6],pngh$sw$1=pngh[7],pngh$sw$2=pngh[8],pngh$w$0=pngh[9],pngh$w$1=pngh[10],pngh$w$2=pngh[11],pngh$nw$0=pngh[12],pngh$nw$1=pngh[13],pngh$nw$2=pngh[14],pngh$ne$0=pngh[15],pngh$ne$1=pngh[16],pngh$ne$2=pngh[17];

// initialisation 
 int tmun11$0=0,tmun11$1=0,tmun11$2=0,tmun12$0=0,tmun12$1=0,tmun12$2=0,tmun13$0=0,tmun13$1=0,tmun13$2=0;
for (int i = 1; i < pngh$e$0.length -1; i++) {
 ver$e$0[i]=( pngh$w$0[i]  <<  1 );ver$e$1[i]=( pngh$w$1[i]  <<  1 );ver$e$2[i]=( pngh$w$2[i]  <<  1 );ver$se$0[i-1]= pngh$nw$0[i] ;
 ver$se$1[i-1]= pngh$nw$1[i] ;ver$se$2[i-1]= pngh$nw$2[i] ;ver$sw$0[i-1]=( pngh$ne$0[i]  >>>  1 );ver$sw$1[i-1]=( pngh$ne$1[i]  >>>  1 );
 ver$sw$2[i-1]=( pngh$ne$2[i]  >>>  1 );ver$w$0[i-1]=( tmun11$0  >>>  1 );ver$w$1[i-1]=( tmun11$1  >>>  1 );ver$w$2[i-1]=( tmun11$2  >>>  1 );
 tmun11$0= pngh$e$0[i] ;tmun11$1= pngh$e$1[i] ;tmun11$2= pngh$e$2[i] ;ver$nw$0[i]= tmun12$0 ;
 ver$nw$1[i]= tmun12$1 ;ver$nw$2[i]= tmun12$2 ;tmun12$0= pngh$se$0[i] ;tmun12$1= pngh$se$1[i] ;
 tmun12$2= pngh$se$2[i] ;ver$ne$0[i]=( tmun13$0  <<  1 );ver$ne$1[i]=( tmun13$1  <<  1 );ver$ne$2[i]=( tmun13$2  <<  1 );
 tmun13$0= pngh$sw$0[i] ;tmun13$1= pngh$sw$1[i] ;tmun13$2= pngh$sw$2[i] ;
  }
  ;
p.prepareBit(ver)
 ;
  }
public static int apexVtoE_1_1GateCount=0;
 public static void apexVtoE_1_1(PrShift p,int [][] pdistantEdgeef,int [][] apexEf){
 int[] apexEf$h1=apexEf[0],apexEf$h2=apexEf[1],apexEf$d1=apexEf[2],apexEf$d2=apexEf[3],apexEf$ad1=apexEf[4],apexEf$ad2=apexEf[5],pdistantEdgeef$es=pdistantEdgeef[0],pdistantEdgeef$s=pdistantEdgeef[1],pdistantEdgeef$ws=pdistantEdgeef[2],pdistantEdgeef$wn=pdistantEdgeef[3],pdistantEdgeef$n=pdistantEdgeef[4],pdistantEdgeef$en=pdistantEdgeef[5];

// initialisation 
 int tmun14=0,tmun15=0;
for (int i = 1; i < pdistantEdgeef$es.length -1; i++) {
 apexEf$h1[i]=( tmun14  <<  1 );tmun14= pdistantEdgeef$s[i] ;apexEf$h2[i-1]= pdistantEdgeef$n[i] ;apexEf$d1[i]=( pdistantEdgeef$ws[i]  <<  1 );
 apexEf$d2[i-1]=( pdistantEdgeef$en[i]  >>>  1 );apexEf$ad1[i-1]= pdistantEdgeef$wn[i] ;apexEf$ad2[i-1]=( tmun15  >>>  1 );tmun15= pdistantEdgeef$es[i] ;
  }
  ;
p.prepareBit(apexEf)
 ;
  }
public static int adjRingDef_1_1GateCount=5;
 public static void adjRingDef_1_1(PrShift p,int [] pngh,int [] resR){
 

// initialisation 
 int auxL46=0,auxL47=0,tmun16=0;
for (int i = 1; i < pngh.length -1; i++) {
 auxL47= pngh[i] ;resR[i-1]=((( tmun16  |  auxL47 ) | ( auxL47  >>>  1 )) | ( auxL46  >>>  1 ));tmun16=((( auxL47  <<  1 ) |  auxL46 ) | ( auxL46  <<  1 ));auxL46= auxL47 ;
  }
  p.mirror(resR);
p.prepareBit(resR)
 ;
  }
public static int apexEtoV_1_1GateCount=0;
 public static void apexEtoV_1_1(PrShift p,int [][] pdistantEdgevf,int [][] apexVf){
 int[] apexVf$es=apexVf[0],apexVf$s=apexVf[1],apexVf$ws=apexVf[2],apexVf$wn=apexVf[3],apexVf$n=apexVf[4],apexVf$en=apexVf[5],pdistantEdgevf$h1=pdistantEdgevf[0],pdistantEdgevf$h2=pdistantEdgevf[1],pdistantEdgevf$d1=pdistantEdgevf[2],pdistantEdgevf$d2=pdistantEdgevf[3],pdistantEdgevf$ad1=pdistantEdgevf[4],pdistantEdgevf$ad2=pdistantEdgevf[5];

// initialisation 
 int tmun17=0,tmun18=0,tmun19=0,tmun20=0;
for (int i = 1; i < pdistantEdgevf$h1.length -1; i++) {
 apexVf$es[i]=( pdistantEdgevf$ad2[i]  <<  1 );apexVf$s[i-1]=( pdistantEdgevf$h1[i]  >>>  1 );apexVf$ws[i-1]=( tmun17  >>>  1 );tmun17= pdistantEdgevf$d1[i] ;
 apexVf$wn[i]= tmun18 ;tmun18= pdistantEdgevf$ad1[i] ;apexVf$n[i]= tmun19 ;tmun19= pdistantEdgevf$h2[i] ;
 apexVf$en[i]=( tmun20  <<  1 );tmun20= pdistantEdgevf$d2[i] ;
  }
  ;
p.prepareBit(apexVf)
 ;
  }
public static int apexEtoVui_3_3GateCount=0;
 public static void apexEtoVui_3_3(PrShift p,int [][] pdistantEdgeef,int [][] apexEf){
 int[] apexEf$h1$0=apexEf[0],apexEf$h1$1=apexEf[1],apexEf$h1$2=apexEf[2],apexEf$h2$0=apexEf[3],apexEf$h2$1=apexEf[4],apexEf$h2$2=apexEf[5],apexEf$d1$0=apexEf[6],apexEf$d1$1=apexEf[7],apexEf$d1$2=apexEf[8],apexEf$d2$0=apexEf[9],apexEf$d2$1=apexEf[10],apexEf$d2$2=apexEf[11],apexEf$ad1$0=apexEf[12],apexEf$ad1$1=apexEf[13],apexEf$ad1$2=apexEf[14],apexEf$ad2$0=apexEf[15],apexEf$ad2$1=apexEf[16],apexEf$ad2$2=apexEf[17],pdistantEdgeef$es$0=pdistantEdgeef[0],pdistantEdgeef$es$1=pdistantEdgeef[1],pdistantEdgeef$es$2=pdistantEdgeef[2],pdistantEdgeef$s$0=pdistantEdgeef[3],pdistantEdgeef$s$1=pdistantEdgeef[4],pdistantEdgeef$s$2=pdistantEdgeef[5],pdistantEdgeef$ws$0=pdistantEdgeef[6],pdistantEdgeef$ws$1=pdistantEdgeef[7],pdistantEdgeef$ws$2=pdistantEdgeef[8],pdistantEdgeef$wn$0=pdistantEdgeef[9],pdistantEdgeef$wn$1=pdistantEdgeef[10],pdistantEdgeef$wn$2=pdistantEdgeef[11],pdistantEdgeef$n$0=pdistantEdgeef[12],pdistantEdgeef$n$1=pdistantEdgeef[13],pdistantEdgeef$n$2=pdistantEdgeef[14],pdistantEdgeef$en$0=pdistantEdgeef[15],pdistantEdgeef$en$1=pdistantEdgeef[16],pdistantEdgeef$en$2=pdistantEdgeef[17];

// initialisation 
 int tmun09$0=0,tmun09$1=0,tmun09$2=0,tmun10$0=0,tmun10$1=0,tmun10$2=0;
for (int i = 1; i < pdistantEdgeef$es$0.length -1; i++) {
 apexEf$h1$0[i]=( tmun09$0  <<  1 );apexEf$h1$1[i]=( tmun09$1  <<  1 );apexEf$h1$2[i]=( tmun09$2  <<  1 );tmun09$0= pdistantEdgeef$s$0[i] ;
 tmun09$1= pdistantEdgeef$s$1[i] ;tmun09$2= pdistantEdgeef$s$2[i] ;apexEf$h2$0[i-1]= pdistantEdgeef$n$0[i] ;apexEf$h2$1[i-1]= pdistantEdgeef$n$1[i] ;
 apexEf$h2$2[i-1]= pdistantEdgeef$n$2[i] ;apexEf$d1$0[i]=( pdistantEdgeef$ws$0[i]  <<  1 );apexEf$d1$1[i]=( pdistantEdgeef$ws$1[i]  <<  1 );apexEf$d1$2[i]=( pdistantEdgeef$ws$2[i]  <<  1 );
 apexEf$d2$0[i-1]=( pdistantEdgeef$en$0[i]  >>>  1 );apexEf$d2$1[i-1]=( pdistantEdgeef$en$1[i]  >>>  1 );apexEf$d2$2[i-1]=( pdistantEdgeef$en$2[i]  >>>  1 );apexEf$ad1$0[i-1]= pdistantEdgeef$wn$0[i] ;
 apexEf$ad1$1[i-1]= pdistantEdgeef$wn$1[i] ;apexEf$ad1$2[i-1]= pdistantEdgeef$wn$2[i] ;apexEf$ad2$0[i-1]=( tmun10$0  >>>  1 );apexEf$ad2$1[i-1]=( tmun10$1  >>>  1 );
 apexEf$ad2$2[i-1]=( tmun10$2  >>>  1 );tmun10$0= pdistantEdgeef$es$0[i] ;tmun10$1= pdistantEdgeef$es$1[i] ;tmun10$2= pdistantEdgeef$es$2[i] ;
  }
  ;
p.prepareBit(apexEf)
 ;
  }
public static int neighborsUI_4_4GateCount=0;
 public static void neighborsUI_4_4(PrShift p,int [][] pngh,int [][] ver){
 int[] ver$e$0=ver[0],ver$e$1=ver[1],ver$e$2=ver[2],ver$e$3=ver[3],ver$se$0=ver[4],ver$se$1=ver[5],ver$se$2=ver[6],ver$se$3=ver[7],ver$sw$0=ver[8],ver$sw$1=ver[9],ver$sw$2=ver[10],ver$sw$3=ver[11],ver$w$0=ver[12],ver$w$1=ver[13],ver$w$2=ver[14],ver$w$3=ver[15],ver$nw$0=ver[16],ver$nw$1=ver[17],ver$nw$2=ver[18],ver$nw$3=ver[19],ver$ne$0=ver[20],ver$ne$1=ver[21],ver$ne$2=ver[22],ver$ne$3=ver[23],pngh$e$0=pngh[0],pngh$e$1=pngh[1],pngh$e$2=pngh[2],pngh$e$3=pngh[3],pngh$se$0=pngh[4],pngh$se$1=pngh[5],pngh$se$2=pngh[6],pngh$se$3=pngh[7],pngh$sw$0=pngh[8],pngh$sw$1=pngh[9],pngh$sw$2=pngh[10],pngh$sw$3=pngh[11],pngh$w$0=pngh[12],pngh$w$1=pngh[13],pngh$w$2=pngh[14],pngh$w$3=pngh[15],pngh$nw$0=pngh[16],pngh$nw$1=pngh[17],pngh$nw$2=pngh[18],pngh$nw$3=pngh[19],pngh$ne$0=pngh[20],pngh$ne$1=pngh[21],pngh$ne$2=pngh[22],pngh$ne$3=pngh[23];

// initialisation 
 int tmun09$0=0,tmun09$1=0,tmun09$2=0,tmun09$3=0,tmun10$0=0,tmun10$1=0,tmun10$2=0,tmun10$3=0,tmun11$0=0,tmun11$1=0,tmun11$2=0,tmun11$3=0;
for (int i = 1; i < pngh$e$0.length -1; i++) {
 ver$e$0[i]=( pngh$w$0[i]  <<  1 );ver$e$1[i]=( pngh$w$1[i]  <<  1 );ver$e$2[i]=( pngh$w$2[i]  <<  1 );ver$e$3[i]=( pngh$w$3[i]  <<  1 );
 ver$se$0[i-1]= pngh$nw$0[i] ;ver$se$1[i-1]= pngh$nw$1[i] ;ver$se$2[i-1]= pngh$nw$2[i] ;ver$se$3[i-1]= pngh$nw$3[i] ;
 ver$sw$0[i-1]=( pngh$ne$0[i]  >>>  1 );ver$sw$1[i-1]=( pngh$ne$1[i]  >>>  1 );ver$sw$2[i-1]=( pngh$ne$2[i]  >>>  1 );ver$sw$3[i-1]=( pngh$ne$3[i]  >>>  1 );
 ver$w$0[i-1]=( tmun09$0  >>>  1 );ver$w$1[i-1]=( tmun09$1  >>>  1 );ver$w$2[i-1]=( tmun09$2  >>>  1 );ver$w$3[i-1]=( tmun09$3  >>>  1 );
 tmun09$0= pngh$e$0[i] ;tmun09$1= pngh$e$1[i] ;tmun09$2= pngh$e$2[i] ;tmun09$3= pngh$e$3[i] ;
 ver$nw$0[i]= tmun10$0 ;ver$nw$1[i]= tmun10$1 ;ver$nw$2[i]= tmun10$2 ;ver$nw$3[i]= tmun10$3 ;
 tmun10$0= pngh$se$0[i] ;tmun10$1= pngh$se$1[i] ;tmun10$2= pngh$se$2[i] ;tmun10$3= pngh$se$3[i] ;
 ver$ne$0[i]=( tmun11$0  <<  1 );ver$ne$1[i]=( tmun11$1  <<  1 );ver$ne$2[i]=( tmun11$2  <<  1 );ver$ne$3[i]=( tmun11$3  <<  1 );
 tmun11$0= pngh$sw$0[i] ;tmun11$1= pngh$sw$1[i] ;tmun11$2= pngh$sw$2[i] ;tmun11$3= pngh$sw$3[i] ;
  }
  ;
p.prepareBit(ver)
 ;
  }
public static int apexEtoVui_4_4GateCount=0;
 public static void apexEtoVui_4_4(PrShift p,int [][] pdistantEdgeef,int [][] apexEf){
 int[] apexEf$h1$0=apexEf[0],apexEf$h1$1=apexEf[1],apexEf$h1$2=apexEf[2],apexEf$h1$3=apexEf[3],apexEf$h2$0=apexEf[4],apexEf$h2$1=apexEf[5],apexEf$h2$2=apexEf[6],apexEf$h2$3=apexEf[7],apexEf$d1$0=apexEf[8],apexEf$d1$1=apexEf[9],apexEf$d1$2=apexEf[10],apexEf$d1$3=apexEf[11],apexEf$d2$0=apexEf[12],apexEf$d2$1=apexEf[13],apexEf$d2$2=apexEf[14],apexEf$d2$3=apexEf[15],apexEf$ad1$0=apexEf[16],apexEf$ad1$1=apexEf[17],apexEf$ad1$2=apexEf[18],apexEf$ad1$3=apexEf[19],apexEf$ad2$0=apexEf[20],apexEf$ad2$1=apexEf[21],apexEf$ad2$2=apexEf[22],apexEf$ad2$3=apexEf[23],pdistantEdgeef$es$0=pdistantEdgeef[0],pdistantEdgeef$es$1=pdistantEdgeef[1],pdistantEdgeef$es$2=pdistantEdgeef[2],pdistantEdgeef$es$3=pdistantEdgeef[3],pdistantEdgeef$s$0=pdistantEdgeef[4],pdistantEdgeef$s$1=pdistantEdgeef[5],pdistantEdgeef$s$2=pdistantEdgeef[6],pdistantEdgeef$s$3=pdistantEdgeef[7],pdistantEdgeef$ws$0=pdistantEdgeef[8],pdistantEdgeef$ws$1=pdistantEdgeef[9],pdistantEdgeef$ws$2=pdistantEdgeef[10],pdistantEdgeef$ws$3=pdistantEdgeef[11],pdistantEdgeef$wn$0=pdistantEdgeef[12],pdistantEdgeef$wn$1=pdistantEdgeef[13],pdistantEdgeef$wn$2=pdistantEdgeef[14],pdistantEdgeef$wn$3=pdistantEdgeef[15],pdistantEdgeef$n$0=pdistantEdgeef[16],pdistantEdgeef$n$1=pdistantEdgeef[17],pdistantEdgeef$n$2=pdistantEdgeef[18],pdistantEdgeef$n$3=pdistantEdgeef[19],pdistantEdgeef$en$0=pdistantEdgeef[20],pdistantEdgeef$en$1=pdistantEdgeef[21],pdistantEdgeef$en$2=pdistantEdgeef[22],pdistantEdgeef$en$3=pdistantEdgeef[23];

// initialisation 
 int tmun15$0=0,tmun15$1=0,tmun15$2=0,tmun15$3=0,tmun16$0=0,tmun16$1=0,tmun16$2=0,tmun16$3=0;
for (int i = 1; i < pdistantEdgeef$es$0.length -1; i++) {
 apexEf$h1$0[i]=( tmun15$0  <<  1 );apexEf$h1$1[i]=( tmun15$1  <<  1 );apexEf$h1$2[i]=( tmun15$2  <<  1 );apexEf$h1$3[i]=( tmun15$3  <<  1 );
 tmun15$0= pdistantEdgeef$s$0[i] ;tmun15$1= pdistantEdgeef$s$1[i] ;tmun15$2= pdistantEdgeef$s$2[i] ;tmun15$3= pdistantEdgeef$s$3[i] ;
 apexEf$h2$0[i-1]= pdistantEdgeef$n$0[i] ;apexEf$h2$1[i-1]= pdistantEdgeef$n$1[i] ;apexEf$h2$2[i-1]= pdistantEdgeef$n$2[i] ;apexEf$h2$3[i-1]= pdistantEdgeef$n$3[i] ;
 apexEf$d1$0[i]=( pdistantEdgeef$ws$0[i]  <<  1 );apexEf$d1$1[i]=( pdistantEdgeef$ws$1[i]  <<  1 );apexEf$d1$2[i]=( pdistantEdgeef$ws$2[i]  <<  1 );apexEf$d1$3[i]=( pdistantEdgeef$ws$3[i]  <<  1 );
 apexEf$d2$0[i-1]=( pdistantEdgeef$en$0[i]  >>>  1 );apexEf$d2$1[i-1]=( pdistantEdgeef$en$1[i]  >>>  1 );apexEf$d2$2[i-1]=( pdistantEdgeef$en$2[i]  >>>  1 );apexEf$d2$3[i-1]=( pdistantEdgeef$en$3[i]  >>>  1 );
 apexEf$ad1$0[i-1]= pdistantEdgeef$wn$0[i] ;apexEf$ad1$1[i-1]= pdistantEdgeef$wn$1[i] ;apexEf$ad1$2[i-1]= pdistantEdgeef$wn$2[i] ;apexEf$ad1$3[i-1]= pdistantEdgeef$wn$3[i] ;
 apexEf$ad2$0[i-1]=( tmun16$0  >>>  1 );apexEf$ad2$1[i-1]=( tmun16$1  >>>  1 );apexEf$ad2$2[i-1]=( tmun16$2  >>>  1 );apexEf$ad2$3[i-1]=( tmun16$3  >>>  1 );
 tmun16$0= pdistantEdgeef$es$0[i] ;tmun16$1= pdistantEdgeef$es$1[i] ;tmun16$2= pdistantEdgeef$es$2[i] ;tmun16$3= pdistantEdgeef$es$3[i] ;
  }
  ;
p.prepareBit(apexEf)
 ;
  }
public static int neighbors_1_1GateCount=0;
 public static void neighbors_1_1(PrShift p,int [][] pngh,int [][] commneighbors){
 int[] commneighbors$e=commneighbors[0],commneighbors$se=commneighbors[1],commneighbors$sw=commneighbors[2],commneighbors$w=commneighbors[3],commneighbors$nw=commneighbors[4],commneighbors$ne=commneighbors[5],pngh$e=pngh[0],pngh$se=pngh[1],pngh$sw=pngh[2],pngh$w=pngh[3],pngh$nw=pngh[4],pngh$ne=pngh[5];

// initialisation 
 int tmun12=0,tmun13=0,tmun14=0;
for (int i = 1; i < pngh$e.length -1; i++) {
 commneighbors$e[i]=( pngh$w[i]  <<  1 );commneighbors$se[i-1]= pngh$nw[i] ;commneighbors$sw[i-1]=( pngh$ne[i]  >>>  1 );commneighbors$w[i-1]=( tmun12  >>>  1 );
 tmun12= pngh$e[i] ;commneighbors$nw[i]= tmun13 ;tmun13= pngh$se[i] ;commneighbors$ne[i]=( tmun14  <<  1 );
 tmun14= pngh$sw[i] ;
  }
  ;
p.prepareBit(commneighbors)
 ;
  }}