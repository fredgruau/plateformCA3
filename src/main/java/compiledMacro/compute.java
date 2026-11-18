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
 p.mirror(computeimplique);p.prepareBit(computeimplique) ;   }}