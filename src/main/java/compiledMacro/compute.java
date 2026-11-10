package compiledMacro;
 import simulator.PrShift;
 public class compute{
 
public static int implique_1_1_1GateCount=2;
 public static void implique_1_1_1(PrShift p,int [] pa,int [] pb,int [] computeimplique){
 


for (int i = 1; i < pa.length -1; i++) {
 computeimplique[i]=(~ pa[i]  |  pb[i] );
  }
  p.mirror(computeimplique);
p.prepareBit(computeimplique)
 ;
  }
public static int concat3V_1_1_1_3GateCount=0;
 public static void concat3V_1_1_1_3(PrShift p,int [] pa,int [] pb,int [] pc,int [][] computeconcat3V){
 int[] computeconcat3V$0=computeconcat3V[0],computeconcat3V$1=computeconcat3V[1],computeconcat3V$2=computeconcat3V[2];


for (int i = 1; i < pa.length -1; i++) {
 computeconcat3V$0[i]= pc[i] ;computeconcat3V$1[i]= pb[i] ;computeconcat3V$2[i]= pa[i] ;
  }
  p.mirror(computeconcat3V);
p.prepareBit(computeconcat3V)
 ;
  }
public static int chooseMax3_3_1GateCount=165;
 public static void chooseMax3_3_1(PrShift p,int [][] pvois,int [][] computechooseMax3){
 int[] computechooseMax3$e=computechooseMax3[0],computechooseMax3$se=computechooseMax3[1],computechooseMax3$sw=computechooseMax3[2],computechooseMax3$w=computechooseMax3[3],computechooseMax3$nw=computechooseMax3[4],computechooseMax3$ne=computechooseMax3[5],pvois$e$0=pvois[0],pvois$e$1=pvois[1],pvois$e$2=pvois[2],pvois$se$0=pvois[3],pvois$se$1=pvois[4],pvois$se$2=pvois[5],pvois$sw$0=pvois[6],pvois$sw$1=pvois[7],pvois$sw$2=pvois[8],pvois$w$0=pvois[9],pvois$w$1=pvois[10],pvois$w$2=pvois[11],pvois$nw$0=pvois[12],pvois$nw$1=pvois[13],pvois$nw$2=pvois[14],pvois$ne$0=pvois[15],pvois$ne$1=pvois[16],pvois$ne$2=pvois[17];

// initialisation 
 int auxL02=0,auxL03=0,auxL04=0,auxL05=0,auxL06$0=0,auxL06$1=0,auxL06$2=0,auxL07$0=0,auxL07$1=0,auxL07$2=0,auxL08=0,auxL09=0,auxL10$0=0,auxL10$1=0,auxL10$2=0,auxL11=0,auxL12=0,auxL13=0,auxL14$0=0,auxL14$1=0,auxL14$2=0,auxL15$0=0,auxL15$1=0,auxL15$2=0,auxL16$0=0,auxL16$1=0,auxL16$2=0,auxL17=0,auxL18=0,auxL19=0,auxL20$0=0,auxL20$1=0,auxL20$2=0,auxL21$0=0,auxL21$1=0,auxL21$2=0,auxL22=0,auxL23=0,auxL24$0=0,auxL24$1=0,auxL24$2=0,auxL25$0=0,auxL25$1=0,auxL25$2=0,auxL26$0=0,auxL26$1=0,auxL26$10=0,auxL26$11=0,auxL26$12=0,auxL26$13=0,auxL26$14=0,auxL26$15=0,auxL26$16=0,auxL26$17=0,auxL26$2=0,auxL26$3=0,auxL26$4=0,auxL26$5=0,auxL26$6=0,auxL26$7=0,auxL26$8=0,auxL26$9=0,r0=0,r1=0,r2=0,r3=0;
for (int i = 1; i < pvois$e$0.length -1; i++) {
 auxL26$0= pvois$e$0[i] ;auxL26$1= pvois$e$1[i] ;auxL26$2= pvois$e$2[i] ;auxL26$3= pvois$se$0[i] ;
 auxL26$4= pvois$se$1[i] ;auxL26$5= pvois$se$2[i] ;auxL26$6= pvois$sw$0[i] ;auxL26$7= pvois$sw$1[i] ;
 auxL26$8= pvois$sw$2[i] ;auxL26$9= pvois$w$0[i] ;auxL26$10= pvois$w$1[i] ;auxL26$11= pvois$w$2[i] ;
 auxL26$12= pvois$nw$0[i] ;auxL26$13= pvois$nw$1[i] ;auxL26$14= pvois$nw$2[i] ;auxL26$15= pvois$ne$0[i] ;
 auxL26$16= pvois$ne$1[i] ;auxL26$17= pvois$ne$2[i] ;r0= auxL26$16 ;r1= auxL26$15 ;
 r2= auxL26$17 ;auxL20$0= r2 ;auxL20$1= r0 ;auxL20$2= r1 ;
 r0= auxL26$14 ;r1= auxL26$13 ;r2= auxL26$12 ;auxL21$0= r0 ;
 auxL21$1= r1 ;auxL21$2= r2 ;r0=( auxL21$0  ^  auxL20$0 );r0=( r0  | ( auxL21$1  ^  auxL20$1 ));
 r0=( r0  | ( auxL21$2  ^  auxL20$2 ));auxL18=~ r0 ;r2=((r1=(r0=( auxL21$2  ^  auxL20$2 ))) &  auxL20$2 );r2=( r2  | ((~(r3= r1 ) & (r1=(r0=( r0  | ( auxL21$1  ^  auxL20$1 ))))) &  auxL20$1 ));
 r2=( r2  | ((~ r1  & ( r0  | ( auxL21$0  ^  auxL20$0 ))) &  auxL20$0 ));auxL19= r2 ;auxL17=(~ auxL19  |  auxL18 );auxL16$0=(( auxL17  &  auxL21$0 ) | ((r0=~ auxL17 ) &  auxL20$0 ));
 auxL16$1=(( auxL17  &  auxL21$1 ) | ((r0=~ auxL17 ) &  auxL20$1 ));auxL16$2=(( auxL17  &  auxL21$2 ) | ((r0=~ auxL17 ) &  auxL20$2 ));r0= auxL26$10 ;r1= auxL26$11 ;
 r2= auxL26$9 ;auxL24$0= r1 ;auxL24$1= r0 ;auxL24$2= r2 ;
 r0= auxL26$1 ;r1= auxL26$2 ;r2= auxL26$0 ;auxL25$0= r1 ;
 auxL25$1= r0 ;auxL25$2= r2 ;r3=((r1=(r0=( auxL25$2  ^  auxL24$2 ))) &  auxL24$2 );r3=( r3  | ((~(r2= r1 ) & (r1=(r0=( r0  | ( auxL25$1  ^  auxL24$1 ))))) &  auxL24$1 ));
 r3=( r3  | ((~ r1  & ( r0  | ( auxL25$0  ^  auxL24$0 ))) &  auxL24$0 ));auxL23= r3 ;r0=( auxL25$0  ^  auxL24$0 );r0=( r0  | ( auxL25$1  ^  auxL24$1 ));
 r0=( r0  | ( auxL25$2  ^  auxL24$2 ));auxL22=(~ auxL23  &  r0 );auxL06$0=(( auxL22  &  auxL25$0 ) | ((r0=~ auxL22 ) &  auxL24$0 ));auxL06$1=(( auxL22  &  auxL25$1 ) | ((r0=~ auxL22 ) &  auxL24$1 ));
 auxL06$2=(( auxL22  &  auxL25$2 ) | ((r0=~ auxL22 ) &  auxL24$2 ));r0= auxL26$5 ;r1= auxL26$3 ;r2= auxL26$4 ;
 auxL14$0= r0 ;auxL14$1= r2 ;auxL14$2= r1 ;r0= auxL26$7 ;
 r1= auxL26$6 ;r2= auxL26$8 ;auxL15$0= r2 ;auxL15$1= r0 ;
 auxL15$2= r1 ;r0=((r2=(r1=( auxL15$2  ^  auxL14$2 ))) &  auxL14$2 );r0=( r0  | ((~(r3= r2 ) & (r2=(r1=( r1  | ( auxL15$1  ^  auxL14$1 ))))) &  auxL14$1 ));r0=( r0  | ((~ r2  & ( r1  | ( auxL15$0  ^  auxL14$0 ))) &  auxL14$0 ));
 auxL13= r0 ;r0=( auxL15$0  ^  auxL14$0 );r0=( r0  | ( auxL15$1  ^  auxL14$1 ));r0=( r0  | ( auxL15$2  ^  auxL14$2 ));
 auxL12=~ r0 ;auxL11=(~ auxL13  |  auxL12 );auxL10$0=(( auxL11  &  auxL15$0 ) | ((r0=~ auxL11 ) &  auxL14$0 ));auxL10$1=(( auxL11  &  auxL15$1 ) | ((r0=~ auxL11 ) &  auxL14$1 ));
 auxL10$2=(( auxL11  &  auxL15$2 ) | ((r0=~ auxL11 ) &  auxL14$2 ));r1=((r0=(r2=( auxL16$2  ^  auxL10$2 ))) &  auxL10$2 );r1=( r1  | ((~(r3= r0 ) & (r0=(r2=( r2  | ( auxL16$1  ^  auxL10$1 ))))) &  auxL10$1 ));r1=( r1  | ((~ r0  & ( r2  | ( auxL16$0  ^  auxL10$0 ))) &  auxL10$0 ));
 auxL09= r1 ;r0=( auxL16$0  ^  auxL10$0 );r0=( r0  | ( auxL16$1  ^  auxL10$1 ));r0=( r0  | ( auxL16$2  ^  auxL10$2 ));
 auxL08=(~ auxL09  &  r0 );auxL07$0=(( auxL08  &  auxL16$0 ) | ((r0=~ auxL08 ) &  auxL10$0 ));auxL07$1=(( auxL08  &  auxL16$1 ) | ((r0=~ auxL08 ) &  auxL10$1 ));auxL07$2=(( auxL08  &  auxL16$2 ) | ((r0=~ auxL08 ) &  auxL10$2 ));
 r1=((r0=(r2=( auxL07$2  ^  auxL06$2 ))) &  auxL06$2 );r1=( r1  | ((~(r3= r0 ) & (r0=(r2=( r2  | ( auxL07$1  ^  auxL06$1 ))))) &  auxL06$1 ));r1=( r1  | ((~ r0  & ( r2  | ( auxL07$0  ^  auxL06$0 ))) &  auxL06$0 ));auxL05= r1 ;
 r0=( auxL07$0  ^  auxL06$0 );r0=( r0  | ( auxL07$1  ^  auxL06$1 ));r0=( r0  | ( auxL07$2  ^  auxL06$2 ));auxL04=(~ auxL05  &  r0 );
 auxL03=( auxL09  &  auxL04 );auxL02=( auxL08  &  auxL04 );computechooseMax3$e[i]=( auxL22  &  auxL05 );computechooseMax3$se[i]=(( auxL13  |  auxL12 ) &  auxL03 );
 computechooseMax3$sw[i]=( auxL11  &  auxL03 );computechooseMax3$w[i]=( auxL23  &  auxL05 );computechooseMax3$nw[i]=( auxL17  &  auxL02 );computechooseMax3$ne[i]=(( auxL19  |  auxL18 ) &  auxL02 );
  }
  ;
p.prepareBit(computechooseMax3)
 ;
  }}