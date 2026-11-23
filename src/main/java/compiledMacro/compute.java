package compiledMacro;
 import simulator.PrShift;
 public class compute{
 
public static int countNeighbors_1_3GateCount=20;
 public static void countNeighbors_1_3(PrShift p,int [][] pneighbor,int [][] computecountNeighbors){
int[] computecountNeighbors$0=computecountNeighbors[0],computecountNeighbors$1=computecountNeighbors[1],computecountNeighbors$2=computecountNeighbors[2],pneighbor$e=pneighbor[0],pneighbor$se=pneighbor[1],pneighbor$sw=pneighbor[2],pneighbor$w=pneighbor[3],pneighbor$nw=pneighbor[4],pneighbor$ne=pneighbor[5];;;;
int auxL61=0,auxL62=0,auxL63=0,auxL64=0,auxL65=0,auxL66=0,auxL67$0=0,auxL67$1=0,auxL67$2=0,auxL67$3=0,auxL67$4=0,auxL67$5=0,r0=0,r1=0,r2=0;// initialisation
for (int i = 1; i < pneighbor$e.length -1; i++) {
 auxL67$0= pneighbor$e[i] ;auxL67$1= pneighbor$se[i] ;auxL67$2= pneighbor$sw[i] ;auxL67$3= pneighbor$w[i] ;
 auxL67$4= pneighbor$nw[i] ;auxL67$5= pneighbor$ne[i] ;r0= auxL67$0 ;auxL66= r0 ;
 r0= auxL67$4 ;auxL62= r0 ;r0= auxL67$3 ;auxL63= r0 ;
 r0= auxL67$5 ;auxL61= r0 ;r0= auxL67$1 ;auxL65= r0 ;
 r0= auxL67$2 ;auxL64= r0 ;computecountNeighbors$0[i]=((r0=(( auxL66  ^  auxL65 ) ^  auxL64 )) ^ (r1=(( auxL63  ^  auxL62 ) ^  auxL61 )));computecountNeighbors$1[i]=(((r2=( r1  &  r0 )) ^ (r0=(( auxL66  &  auxL65 ) | ( auxL64  & ( auxL66  |  auxL65 ))))) ^ (r1=(( auxL63  &  auxL62 ) | ( auxL61  & ( auxL63  |  auxL62 )))));
 computecountNeighbors$2[i]=(( r2  &  r0 ) | ( r1  & ( r2  |  r0 )));   }
 p.mirror(computecountNeighbors);p.prepareBit(computecountNeighbors) ;   }
public static int chooseMax4_4_1GateCount=221;
 public static void chooseMax4_4_1(PrShift p,int [][] pvois,int [][] computechooseMax4){
int[] computechooseMax4$e=computechooseMax4[0],computechooseMax4$se=computechooseMax4[1],computechooseMax4$sw=computechooseMax4[2],computechooseMax4$w=computechooseMax4[3],computechooseMax4$nw=computechooseMax4[4],computechooseMax4$ne=computechooseMax4[5],pvois$e$0=pvois[0],pvois$e$1=pvois[1],pvois$e$2=pvois[2],pvois$e$3=pvois[3],pvois$se$0=pvois[4],pvois$se$1=pvois[5],pvois$se$2=pvois[6],pvois$se$3=pvois[7],pvois$sw$0=pvois[8],pvois$sw$1=pvois[9],pvois$sw$2=pvois[10],pvois$sw$3=pvois[11],pvois$w$0=pvois[12],pvois$w$1=pvois[13],pvois$w$2=pvois[14],pvois$w$3=pvois[15],pvois$nw$0=pvois[16],pvois$nw$1=pvois[17],pvois$nw$2=pvois[18],pvois$nw$3=pvois[19],pvois$ne$0=pvois[20],pvois$ne$1=pvois[21],pvois$ne$2=pvois[22],pvois$ne$3=pvois[23];;;;
int auxL36=0,auxL37=0,auxL38=0,auxL39=0,auxL40$0=0,auxL40$1=0,auxL40$2=0,auxL40$3=0,auxL41$0=0,auxL41$1=0,auxL41$2=0,auxL41$3=0,auxL42=0,auxL43=0,auxL44$0=0,auxL44$1=0,auxL44$2=0,auxL44$3=0,auxL45=0,auxL46=0,auxL47=0,auxL48$0=0,auxL48$1=0,auxL48$2=0,auxL48$3=0,auxL49$0=0,auxL49$1=0,auxL49$2=0,auxL49$3=0,auxL50$0=0,auxL50$1=0,auxL50$2=0,auxL50$3=0,auxL51=0,auxL52=0,auxL53=0,auxL54$0=0,auxL54$1=0,auxL54$2=0,auxL54$3=0,auxL55$0=0,auxL55$1=0,auxL55$2=0,auxL55$3=0,auxL56=0,auxL57=0,auxL58$0=0,auxL58$1=0,auxL58$2=0,auxL58$3=0,auxL59$0=0,auxL59$1=0,auxL59$2=0,auxL59$3=0,auxL60$0=0,auxL60$1=0,auxL60$10=0,auxL60$11=0,auxL60$12=0,auxL60$13=0,auxL60$14=0,auxL60$15=0,auxL60$16=0,auxL60$17=0,auxL60$18=0,auxL60$19=0,auxL60$2=0,auxL60$20=0,auxL60$21=0,auxL60$22=0,auxL60$23=0,auxL60$3=0,auxL60$4=0,auxL60$5=0,auxL60$6=0,auxL60$7=0,auxL60$8=0,auxL60$9=0,r0=0,r1=0,r2=0,r3=0;// initialisation
for (int i = 1; i < pvois$e$0.length -1; i++) {
 auxL60$0= pvois$e$0[i] ;auxL60$1= pvois$e$1[i] ;auxL60$2= pvois$e$2[i] ;auxL60$3= pvois$e$3[i] ;
 auxL60$4= pvois$se$0[i] ;auxL60$5= pvois$se$1[i] ;auxL60$6= pvois$se$2[i] ;auxL60$7= pvois$se$3[i] ;
 auxL60$8= pvois$sw$0[i] ;auxL60$9= pvois$sw$1[i] ;auxL60$10= pvois$sw$2[i] ;auxL60$11= pvois$sw$3[i] ;
 auxL60$12= pvois$w$0[i] ;auxL60$13= pvois$w$1[i] ;auxL60$14= pvois$w$2[i] ;auxL60$15= pvois$w$3[i] ;
 auxL60$16= pvois$nw$0[i] ;auxL60$17= pvois$nw$1[i] ;auxL60$18= pvois$nw$2[i] ;auxL60$19= pvois$nw$3[i] ;
 auxL60$20= pvois$ne$0[i] ;auxL60$21= pvois$ne$1[i] ;auxL60$22= pvois$ne$2[i] ;auxL60$23= pvois$ne$3[i] ;
 r0= auxL60$15 ;r1= auxL60$14 ;r2= auxL60$12 ;r3= auxL60$13 ;
 auxL58$0= r2 ;auxL58$1= r3 ;auxL58$2= r1 ;auxL58$3= r0 ;
 r0= auxL60$3 ;r1= auxL60$1 ;r2= auxL60$0 ;r3= auxL60$2 ;
 auxL59$0= r2 ;auxL59$1= r1 ;auxL59$2= r3 ;auxL59$3= r0 ;
 r3=((r0=(r2=( auxL59$3  ^  auxL58$3 ))) &  auxL58$3 );r3=( r3  | ((~(r1= r0 ) & (r0=(r2=( r2  | ( auxL59$2  ^  auxL58$2 ))))) &  auxL58$2 ));r3=( r3  | ((~(r1= r0 ) & (r0=(r2=( r2  | ( auxL59$1  ^  auxL58$1 ))))) &  auxL58$1 ));r3=( r3  | ((~ r0  & ( r2  | ( auxL59$0  ^  auxL58$0 ))) &  auxL58$0 ));
 auxL57= r3 ;r0=( auxL59$0  ^  auxL58$0 );r0=( r0  | ( auxL59$1  ^  auxL58$1 ));r0=( r0  | ( auxL59$2  ^  auxL58$2 ));
 r0=( r0  | ( auxL59$3  ^  auxL58$3 ));auxL56=(~ auxL57  &  r0 );auxL40$0=(( auxL56  &  auxL59$0 ) | ((r0=~ auxL56 ) &  auxL58$0 ));auxL40$1=(( auxL56  &  auxL59$1 ) | ((r0=~ auxL56 ) &  auxL58$1 ));
 auxL40$2=(( auxL56  &  auxL59$2 ) | ((r0=~ auxL56 ) &  auxL58$2 ));auxL40$3=(( auxL56  &  auxL59$3 ) | ((r0=~ auxL56 ) &  auxL58$3 ));r0= auxL60$22 ;r1= auxL60$21 ;
 r2= auxL60$20 ;r3= auxL60$23 ;auxL54$0= r2 ;auxL54$1= r1 ;
 auxL54$2= r0 ;auxL54$3= r3 ;r0= auxL60$18 ;r1= auxL60$16 ;
 r2= auxL60$19 ;r3= auxL60$17 ;auxL55$0= r1 ;auxL55$1= r3 ;
 auxL55$2= r0 ;auxL55$3= r2 ;r1=((r3=(r2=( auxL55$3  ^  auxL54$3 ))) &  auxL54$3 );r1=( r1  | ((~(r0= r3 ) & (r3=(r2=( r2  | ( auxL55$2  ^  auxL54$2 ))))) &  auxL54$2 ));
 r1=( r1  | ((~(r0= r3 ) & (r3=(r2=( r2  | ( auxL55$1  ^  auxL54$1 ))))) &  auxL54$1 ));r1=( r1  | ((~ r3  & ( r2  | ( auxL55$0  ^  auxL54$0 ))) &  auxL54$0 ));auxL53= r1 ;r0=( auxL55$0  ^  auxL54$0 );
 r0=( r0  | ( auxL55$1  ^  auxL54$1 ));r0=( r0  | ( auxL55$2  ^  auxL54$2 ));r0=( r0  | ( auxL55$3  ^  auxL54$3 ));auxL52=~ r0 ;
 auxL51=(~ auxL53  |  auxL52 );auxL50$0=(( auxL51  &  auxL55$0 ) | ((r0=~ auxL51 ) &  auxL54$0 ));auxL50$1=(( auxL51  &  auxL55$1 ) | ((r0=~ auxL51 ) &  auxL54$1 ));auxL50$2=(( auxL51  &  auxL55$2 ) | ((r0=~ auxL51 ) &  auxL54$2 ));
 auxL50$3=(( auxL51  &  auxL55$3 ) | ((r0=~ auxL51 ) &  auxL54$3 ));r0= auxL60$11 ;r1= auxL60$8 ;r2= auxL60$10 ;
 r3= auxL60$9 ;auxL49$0= r1 ;auxL49$1= r3 ;auxL49$2= r2 ;
 auxL49$3= r0 ;r0= auxL60$5 ;r1= auxL60$7 ;r2= auxL60$6 ;
 r3= auxL60$4 ;auxL48$0= r3 ;auxL48$1= r0 ;auxL48$2= r2 ;
 auxL48$3= r1 ;r2=((r0=(r1=( auxL49$3  ^  auxL48$3 ))) &  auxL48$3 );r2=( r2  | ((~(r3= r0 ) & (r0=(r1=( r1  | ( auxL49$2  ^  auxL48$2 ))))) &  auxL48$2 ));r2=( r2  | ((~(r3= r0 ) & (r0=(r1=( r1  | ( auxL49$1  ^  auxL48$1 ))))) &  auxL48$1 ));
 r2=( r2  | ((~ r0  & ( r1  | ( auxL49$0  ^  auxL48$0 ))) &  auxL48$0 ));auxL47= r2 ;r0=( auxL49$0  ^  auxL48$0 );r0=( r0  | ( auxL49$1  ^  auxL48$1 ));
 r0=( r0  | ( auxL49$2  ^  auxL48$2 ));r0=( r0  | ( auxL49$3  ^  auxL48$3 ));auxL46=~ r0 ;auxL45=(~ auxL47  |  auxL46 );
 auxL44$0=(( auxL45  &  auxL49$0 ) | ((r0=~ auxL45 ) &  auxL48$0 ));auxL44$1=(( auxL45  &  auxL49$1 ) | ((r0=~ auxL45 ) &  auxL48$1 ));auxL44$2=(( auxL45  &  auxL49$2 ) | ((r0=~ auxL45 ) &  auxL48$2 ));auxL44$3=(( auxL45  &  auxL49$3 ) | ((r0=~ auxL45 ) &  auxL48$3 ));
 r0=((r1=(r3=( auxL50$3  ^  auxL44$3 ))) &  auxL44$3 );r0=( r0  | ((~(r2= r1 ) & (r1=(r3=( r3  | ( auxL50$2  ^  auxL44$2 ))))) &  auxL44$2 ));r0=( r0  | ((~(r2= r1 ) & (r1=(r3=( r3  | ( auxL50$1  ^  auxL44$1 ))))) &  auxL44$1 ));r0=( r0  | ((~ r1  & ( r3  | ( auxL50$0  ^  auxL44$0 ))) &  auxL44$0 ));
 auxL43= r0 ;r0=( auxL50$0  ^  auxL44$0 );r0=( r0  | ( auxL50$1  ^  auxL44$1 ));r0=( r0  | ( auxL50$2  ^  auxL44$2 ));
 r0=( r0  | ( auxL50$3  ^  auxL44$3 ));auxL42=(~ auxL43  &  r0 );auxL41$0=(( auxL42  &  auxL50$0 ) | ((r0=~ auxL42 ) &  auxL44$0 ));auxL41$1=(( auxL42  &  auxL50$1 ) | ((r0=~ auxL42 ) &  auxL44$1 ));
 auxL41$2=(( auxL42  &  auxL50$2 ) | ((r0=~ auxL42 ) &  auxL44$2 ));auxL41$3=(( auxL42  &  auxL50$3 ) | ((r0=~ auxL42 ) &  auxL44$3 ));r1=((r3=(r2=( auxL41$3  ^  auxL40$3 ))) &  auxL40$3 );r1=( r1  | ((~(r0= r3 ) & (r3=(r2=( r2  | ( auxL41$2  ^  auxL40$2 ))))) &  auxL40$2 ));
 r1=( r1  | ((~(r0= r3 ) & (r3=(r2=( r2  | ( auxL41$1  ^  auxL40$1 ))))) &  auxL40$1 ));r1=( r1  | ((~ r3  & ( r2  | ( auxL41$0  ^  auxL40$0 ))) &  auxL40$0 ));auxL39= r1 ;r0=( auxL41$0  ^  auxL40$0 );
 r0=( r0  | ( auxL41$1  ^  auxL40$1 ));r0=( r0  | ( auxL41$2  ^  auxL40$2 ));r0=( r0  | ( auxL41$3  ^  auxL40$3 ));auxL38=(~ auxL39  &  r0 );
 auxL37=( auxL43  &  auxL38 );auxL36=( auxL42  &  auxL38 );computechooseMax4$e[i]=( auxL56  &  auxL39 );computechooseMax4$se[i]=(( auxL47  |  auxL46 ) &  auxL37 );
 computechooseMax4$sw[i]=( auxL45  &  auxL37 );computechooseMax4$w[i]=( auxL57  &  auxL39 );computechooseMax4$nw[i]=( auxL51  &  auxL36 );computechooseMax4$ne[i]=(( auxL53  |  auxL52 ) &  auxL36 );   }
 ;p.prepareBit(computechooseMax4) ;   }
public static int implique_1_1_1GateCount=2;
 public static void implique_1_1_1(PrShift p,int [] pa,int [] pb,int [] computeimplique){


for (int i = 1; i < pa.length -1; i++) {
 computeimplique[i]=(~ pa[i]  |  pb[i] );   }
 p.mirror(computeimplique);p.prepareBit(computeimplique) ;   }
public static int chooseMax5_5_1GateCount=277;
 public static void chooseMax5_5_1(PrShift p,int [][] pvois,int [][] computechooseMax5){
int[] computechooseMax5$e=computechooseMax5[0],computechooseMax5$se=computechooseMax5[1],computechooseMax5$sw=computechooseMax5[2],computechooseMax5$w=computechooseMax5[3],computechooseMax5$nw=computechooseMax5[4],computechooseMax5$ne=computechooseMax5[5],pvois$e$0=pvois[0],pvois$e$1=pvois[1],pvois$e$2=pvois[2],pvois$e$3=pvois[3],pvois$e$4=pvois[4],pvois$se$0=pvois[5],pvois$se$1=pvois[6],pvois$se$2=pvois[7],pvois$se$3=pvois[8],pvois$se$4=pvois[9],pvois$sw$0=pvois[10],pvois$sw$1=pvois[11],pvois$sw$2=pvois[12],pvois$sw$3=pvois[13],pvois$sw$4=pvois[14],pvois$w$0=pvois[15],pvois$w$1=pvois[16],pvois$w$2=pvois[17],pvois$w$3=pvois[18],pvois$w$4=pvois[19],pvois$nw$0=pvois[20],pvois$nw$1=pvois[21],pvois$nw$2=pvois[22],pvois$nw$3=pvois[23],pvois$nw$4=pvois[24],pvois$ne$0=pvois[25],pvois$ne$1=pvois[26],pvois$ne$2=pvois[27],pvois$ne$3=pvois[28],pvois$ne$4=pvois[29];;;;
int auxL42=0,auxL43=0,auxL44=0,auxL45=0,auxL46$0=0,auxL46$1=0,auxL46$2=0,auxL46$3=0,auxL46$4=0,auxL47$0=0,auxL47$1=0,auxL47$2=0,auxL47$3=0,auxL47$4=0,auxL48=0,auxL49=0,auxL50$0=0,auxL50$1=0,auxL50$2=0,auxL50$3=0,auxL50$4=0,auxL51=0,auxL52=0,auxL53=0,auxL54$0=0,auxL54$1=0,auxL54$2=0,auxL54$3=0,auxL54$4=0,auxL55$0=0,auxL55$1=0,auxL55$2=0,auxL55$3=0,auxL55$4=0,auxL56$0=0,auxL56$1=0,auxL56$2=0,auxL56$3=0,auxL56$4=0,auxL57=0,auxL58=0,auxL59=0,auxL60$0=0,auxL60$1=0,auxL60$2=0,auxL60$3=0,auxL60$4=0,auxL61$0=0,auxL61$1=0,auxL61$2=0,auxL61$3=0,auxL61$4=0,auxL62=0,auxL63=0,auxL64$0=0,auxL64$1=0,auxL64$2=0,auxL64$3=0,auxL64$4=0,auxL65$0=0,auxL65$1=0,auxL65$2=0,auxL65$3=0,auxL65$4=0,auxL66$0=0,auxL66$1=0,auxL66$10=0,auxL66$11=0,auxL66$12=0,auxL66$13=0,auxL66$14=0,auxL66$15=0,auxL66$16=0,auxL66$17=0,auxL66$18=0,auxL66$19=0,auxL66$2=0,auxL66$20=0,auxL66$21=0,auxL66$22=0,auxL66$23=0,auxL66$24=0,auxL66$25=0,auxL66$26=0,auxL66$27=0,auxL66$28=0,auxL66$29=0,auxL66$3=0,auxL66$4=0,auxL66$5=0,auxL66$6=0,auxL66$7=0,auxL66$8=0,auxL66$9=0,r0=0,r1=0,r2=0,r3=0,r4=0;// initialisation
for (int i = 1; i < pvois$e$0.length -1; i++) {
 auxL66$0= pvois$e$0[i] ;auxL66$1= pvois$e$1[i] ;auxL66$2= pvois$e$2[i] ;auxL66$3= pvois$e$3[i] ;
 auxL66$4= pvois$e$4[i] ;auxL66$5= pvois$se$0[i] ;auxL66$6= pvois$se$1[i] ;auxL66$7= pvois$se$2[i] ;
 auxL66$8= pvois$se$3[i] ;auxL66$9= pvois$se$4[i] ;auxL66$10= pvois$sw$0[i] ;auxL66$11= pvois$sw$1[i] ;
 auxL66$12= pvois$sw$2[i] ;auxL66$13= pvois$sw$3[i] ;auxL66$14= pvois$sw$4[i] ;auxL66$15= pvois$w$0[i] ;
 auxL66$16= pvois$w$1[i] ;auxL66$17= pvois$w$2[i] ;auxL66$18= pvois$w$3[i] ;auxL66$19= pvois$w$4[i] ;
 auxL66$20= pvois$nw$0[i] ;auxL66$21= pvois$nw$1[i] ;auxL66$22= pvois$nw$2[i] ;auxL66$23= pvois$nw$3[i] ;
 auxL66$24= pvois$nw$4[i] ;auxL66$25= pvois$ne$0[i] ;auxL66$26= pvois$ne$1[i] ;auxL66$27= pvois$ne$2[i] ;
 auxL66$28= pvois$ne$3[i] ;auxL66$29= pvois$ne$4[i] ;r0= auxL66$21 ;r1= auxL66$20 ;
 r2= auxL66$24 ;r3= auxL66$23 ;r4= auxL66$22 ;auxL61$0= r1 ;
 auxL61$1= r0 ;auxL61$2= r4 ;auxL61$3= r3 ;auxL61$4= r2 ;
 r0= auxL66$25 ;r1= auxL66$28 ;r2= auxL66$27 ;r3= auxL66$29 ;
 r4= auxL66$26 ;auxL60$0= r0 ;auxL60$1= r4 ;auxL60$2= r2 ;
 auxL60$3= r1 ;auxL60$4= r3 ;r0=( auxL61$0  ^  auxL60$0 );r0=( r0  | ( auxL61$1  ^  auxL60$1 ));
 r0=( r0  | ( auxL61$2  ^  auxL60$2 ));r0=( r0  | ( auxL61$3  ^  auxL60$3 ));r0=( r0  | ( auxL61$4  ^  auxL60$4 ));auxL58=~ r0 ;
 r1=((r3=(r2=( auxL61$4  ^  auxL60$4 ))) &  auxL60$4 );r1=( r1  | ((~(r0= r3 ) & (r3=(r2=( r2  | ( auxL61$3  ^  auxL60$3 ))))) &  auxL60$3 ));r1=( r1  | ((~(r0= r3 ) & (r3=(r2=( r2  | ( auxL61$2  ^  auxL60$2 ))))) &  auxL60$2 ));r1=( r1  | ((~(r0= r3 ) & (r3=(r2=( r2  | ( auxL61$1  ^  auxL60$1 ))))) &  auxL60$1 ));
 r1=( r1  | ((~ r3  & ( r2  | ( auxL61$0  ^  auxL60$0 ))) &  auxL60$0 ));auxL59= r1 ;auxL57=(~ auxL59  |  auxL58 );auxL56$0=(( auxL57  &  auxL61$0 ) | ((r0=~ auxL57 ) &  auxL60$0 ));
 auxL56$1=(( auxL57  &  auxL61$1 ) | ((r0=~ auxL57 ) &  auxL60$1 ));auxL56$2=(( auxL57  &  auxL61$2 ) | ((r0=~ auxL57 ) &  auxL60$2 ));auxL56$3=(( auxL57  &  auxL61$3 ) | ((r0=~ auxL57 ) &  auxL60$3 ));auxL56$4=(( auxL57  &  auxL61$4 ) | ((r0=~ auxL57 ) &  auxL60$4 ));
 r0= auxL66$13 ;r1= auxL66$10 ;r2= auxL66$12 ;r3= auxL66$11 ;
 r4= auxL66$14 ;auxL55$0= r1 ;auxL55$1= r3 ;auxL55$2= r2 ;
 auxL55$3= r0 ;auxL55$4= r4 ;r0= auxL66$8 ;r1= auxL66$6 ;
 r2= auxL66$5 ;r3= auxL66$7 ;r4= auxL66$9 ;auxL54$0= r2 ;
 auxL54$1= r1 ;auxL54$2= r3 ;auxL54$3= r0 ;auxL54$4= r4 ;
 r0=((r2=(r3=( auxL55$4  ^  auxL54$4 ))) &  auxL54$4 );r0=( r0  | ((~(r1= r2 ) & (r2=(r3=( r3  | ( auxL55$3  ^  auxL54$3 ))))) &  auxL54$3 ));r0=( r0  | ((~(r1= r2 ) & (r2=(r3=( r3  | ( auxL55$2  ^  auxL54$2 ))))) &  auxL54$2 ));r0=( r0  | ((~(r1= r2 ) & (r2=(r3=( r3  | ( auxL55$1  ^  auxL54$1 ))))) &  auxL54$1 ));
 r0=( r0  | ((~ r2  & ( r3  | ( auxL55$0  ^  auxL54$0 ))) &  auxL54$0 ));auxL53= r0 ;r0=( auxL55$0  ^  auxL54$0 );r0=( r0  | ( auxL55$1  ^  auxL54$1 ));
 r0=( r0  | ( auxL55$2  ^  auxL54$2 ));r0=( r0  | ( auxL55$3  ^  auxL54$3 ));r0=( r0  | ( auxL55$4  ^  auxL54$4 ));auxL52=~ r0 ;
 auxL51=(~ auxL53  |  auxL52 );auxL50$0=(( auxL51  &  auxL55$0 ) | ((r0=~ auxL51 ) &  auxL54$0 ));auxL50$1=(( auxL51  &  auxL55$1 ) | ((r0=~ auxL51 ) &  auxL54$1 ));auxL50$2=(( auxL51  &  auxL55$2 ) | ((r0=~ auxL51 ) &  auxL54$2 ));
 auxL50$3=(( auxL51  &  auxL55$3 ) | ((r0=~ auxL51 ) &  auxL54$3 ));auxL50$4=(( auxL51  &  auxL55$4 ) | ((r0=~ auxL51 ) &  auxL54$4 ));r3=((r1=(r2=( auxL56$4  ^  auxL50$4 ))) &  auxL50$4 );r3=( r3  | ((~(r0= r1 ) & (r1=(r2=( r2  | ( auxL56$3  ^  auxL50$3 ))))) &  auxL50$3 ));
 r3=( r3  | ((~(r0= r1 ) & (r1=(r2=( r2  | ( auxL56$2  ^  auxL50$2 ))))) &  auxL50$2 ));r3=( r3  | ((~(r0= r1 ) & (r1=(r2=( r2  | ( auxL56$1  ^  auxL50$1 ))))) &  auxL50$1 ));r3=( r3  | ((~ r1  & ( r2  | ( auxL56$0  ^  auxL50$0 ))) &  auxL50$0 ));auxL49= r3 ;
 r0=( auxL56$0  ^  auxL50$0 );r0=( r0  | ( auxL56$1  ^  auxL50$1 ));r0=( r0  | ( auxL56$2  ^  auxL50$2 ));r0=( r0  | ( auxL56$3  ^  auxL50$3 ));
 r0=( r0  | ( auxL56$4  ^  auxL50$4 ));auxL48=(~ auxL49  &  r0 );auxL47$0=(( auxL48  &  auxL56$0 ) | ((r0=~ auxL48 ) &  auxL50$0 ));auxL47$1=(( auxL48  &  auxL56$1 ) | ((r0=~ auxL48 ) &  auxL50$1 ));
 auxL47$2=(( auxL48  &  auxL56$2 ) | ((r0=~ auxL48 ) &  auxL50$2 ));auxL47$3=(( auxL48  &  auxL56$3 ) | ((r0=~ auxL48 ) &  auxL50$3 ));auxL47$4=(( auxL48  &  auxL56$4 ) | ((r0=~ auxL48 ) &  auxL50$4 ));r0= auxL66$15 ;
 r1= auxL66$17 ;r2= auxL66$19 ;r3= auxL66$18 ;r4= auxL66$16 ;
 auxL64$0= r0 ;auxL64$1= r4 ;auxL64$2= r1 ;auxL64$3= r3 ;
 auxL64$4= r2 ;r0= auxL66$1 ;r1= auxL66$0 ;r2= auxL66$2 ;
 r3= auxL66$4 ;r4= auxL66$3 ;auxL65$0= r1 ;auxL65$1= r0 ;
 auxL65$2= r2 ;auxL65$3= r4 ;auxL65$4= r3 ;r2=((r3=(r0=( auxL65$4  ^  auxL64$4 ))) &  auxL64$4 );
 r2=( r2  | ((~(r1= r3 ) & (r3=(r0=( r0  | ( auxL65$3  ^  auxL64$3 ))))) &  auxL64$3 ));r2=( r2  | ((~(r1= r3 ) & (r3=(r0=( r0  | ( auxL65$2  ^  auxL64$2 ))))) &  auxL64$2 ));r2=( r2  | ((~(r1= r3 ) & (r3=(r0=( r0  | ( auxL65$1  ^  auxL64$1 ))))) &  auxL64$1 ));r2=( r2  | ((~ r3  & ( r0  | ( auxL65$0  ^  auxL64$0 ))) &  auxL64$0 ));
 auxL63= r2 ;r0=( auxL65$0  ^  auxL64$0 );r0=( r0  | ( auxL65$1  ^  auxL64$1 ));r0=( r0  | ( auxL65$2  ^  auxL64$2 ));
 r0=( r0  | ( auxL65$3  ^  auxL64$3 ));r0=( r0  | ( auxL65$4  ^  auxL64$4 ));auxL62=(~ auxL63  &  r0 );auxL46$0=(( auxL62  &  auxL65$0 ) | ((r0=~ auxL62 ) &  auxL64$0 ));
 auxL46$1=(( auxL62  &  auxL65$1 ) | ((r0=~ auxL62 ) &  auxL64$1 ));auxL46$2=(( auxL62  &  auxL65$2 ) | ((r0=~ auxL62 ) &  auxL64$2 ));auxL46$3=(( auxL62  &  auxL65$3 ) | ((r0=~ auxL62 ) &  auxL64$3 ));auxL46$4=(( auxL62  &  auxL65$4 ) | ((r0=~ auxL62 ) &  auxL64$4 ));
 r2=((r1=(r0=( auxL47$4  ^  auxL46$4 ))) &  auxL46$4 );r2=( r2  | ((~(r3= r1 ) & (r1=(r0=( r0  | ( auxL47$3  ^  auxL46$3 ))))) &  auxL46$3 ));r2=( r2  | ((~(r3= r1 ) & (r1=(r0=( r0  | ( auxL47$2  ^  auxL46$2 ))))) &  auxL46$2 ));r2=( r2  | ((~(r3= r1 ) & (r1=(r0=( r0  | ( auxL47$1  ^  auxL46$1 ))))) &  auxL46$1 ));
 r2=( r2  | ((~ r1  & ( r0  | ( auxL47$0  ^  auxL46$0 ))) &  auxL46$0 ));auxL45= r2 ;r0=( auxL47$0  ^  auxL46$0 );r0=( r0  | ( auxL47$1  ^  auxL46$1 ));
 r0=( r0  | ( auxL47$2  ^  auxL46$2 ));r0=( r0  | ( auxL47$3  ^  auxL46$3 ));r0=( r0  | ( auxL47$4  ^  auxL46$4 ));auxL44=(~ auxL45  &  r0 );
 auxL42=( auxL48  &  auxL44 );auxL43=( auxL49  &  auxL44 );computechooseMax5$e[i]=( auxL62  &  auxL45 );computechooseMax5$se[i]=(( auxL53  |  auxL52 ) &  auxL43 );
 computechooseMax5$sw[i]=( auxL51  &  auxL43 );computechooseMax5$w[i]=( auxL63  &  auxL45 );computechooseMax5$nw[i]=( auxL57  &  auxL42 );computechooseMax5$ne[i]=(( auxL59  |  auxL58 ) &  auxL42 );   }
 ;p.prepareBit(computechooseMax5) ;   }}