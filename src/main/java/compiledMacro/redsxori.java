package compiledMacro;
 import simulator.PrShift;
 public class redsxori{
 
public static int ve_1_1GateCount=3;
 public static void ve_1_1(PrShift p,int [] ppVE,int [][] redsxoriveR){
 int[] redsxoriveR$h$0=redsxoriveR[0],redsxoriveR$d$0=redsxoriveR[1],redsxoriveR$ad$0=redsxoriveR[2],ppVE$0=ppVE;
// initialisation 
 int auxL01$0=0,auxL02$0=0;
for (int i = 1; i < ppVE$0.length -1; i++) {
 redsxoriveR$h$0[i-1]=(( auxL02$0  <<  1 ) ^  auxL02$0 );
 auxL02$0= ppVE$0[i] ;
 redsxoriveR$d$0[i-1]=( auxL01$0  ^  auxL02$0 );
 redsxoriveR$ad$0[i-1]=( auxL01$0  ^ ( auxL02$0  >>>  1 ));
 auxL01$0= auxL02$0 ;
   } }
public static int ve_2_2GateCount=6;
 public static void ve_2_2(PrShift p,int [][] ppVE,int [][] redsxoriveR){
 int[] redsxoriveR$h$0=redsxoriveR[0],redsxoriveR$h$1=redsxoriveR[1],redsxoriveR$d$0=redsxoriveR[2],redsxoriveR$d$1=redsxoriveR[3],redsxoriveR$ad$0=redsxoriveR[4],redsxoriveR$ad$1=redsxoriveR[5],ppVE$0=ppVE[0],ppVE$1=ppVE[1];
// initialisation 
 int auxL01$0=0,auxL01$1=0,auxL02$0=0,auxL02$1=0;
for (int i = 1; i < ppVE$0.length -1; i++) {
 redsxoriveR$h$0[i-1]=(( auxL02$0  <<  1 ) ^  auxL02$0 );redsxoriveR$h$1[i-1]=(( auxL02$1  <<  1 ) ^  auxL02$1 );auxL02$0= ppVE$0[i] ;auxL02$1= ppVE$1[i] ;
 redsxoriveR$d$0[i-1]=( auxL01$0  ^  auxL02$0 );redsxoriveR$d$1[i-1]=( auxL01$1  ^  auxL02$1 );redsxoriveR$ad$0[i-1]=( auxL01$0  ^ ( auxL02$0  >>>  1 ));redsxoriveR$ad$1[i-1]=( auxL01$1  ^ ( auxL02$1  >>>  1 ));
 auxL01$0= auxL02$0 ;auxL01$1= auxL02$1 ;
   } }
public static int ve_5_5GateCount=15;
 public static void ve_5_5(PrShift p,int [][] ppVE,int [][] redsxoriveR){
 int[] redsxoriveR$h$0=redsxoriveR[0],redsxoriveR$h$1=redsxoriveR[1],redsxoriveR$h$2=redsxoriveR[2],redsxoriveR$h$3=redsxoriveR[3],redsxoriveR$h$4=redsxoriveR[4],redsxoriveR$d$0=redsxoriveR[5],redsxoriveR$d$1=redsxoriveR[6],redsxoriveR$d$2=redsxoriveR[7],redsxoriveR$d$3=redsxoriveR[8],redsxoriveR$d$4=redsxoriveR[9],redsxoriveR$ad$0=redsxoriveR[10],redsxoriveR$ad$1=redsxoriveR[11],redsxoriveR$ad$2=redsxoriveR[12],redsxoriveR$ad$3=redsxoriveR[13],redsxoriveR$ad$4=redsxoriveR[14],ppVE$0=ppVE[0],ppVE$1=ppVE[1],ppVE$2=ppVE[2],ppVE$3=ppVE[3],ppVE$4=ppVE[4];
// initialisation 
 int auxL00$0=0,auxL00$1=0,auxL00$2=0,auxL00$3=0,auxL00$4=0,auxL01$0=0,auxL01$1=0,auxL01$2=0,auxL01$3=0,auxL01$4=0;
for (int i = 1; i < ppVE$0.length -1; i++) {
 redsxoriveR$h$0[i-1]=(( auxL01$0  <<  1 ) ^  auxL01$0 );redsxoriveR$h$1[i-1]=(( auxL01$1  <<  1 ) ^  auxL01$1 );redsxoriveR$h$2[i-1]=(( auxL01$2  <<  1 ) ^  auxL01$2 );redsxoriveR$h$3[i-1]=(( auxL01$3  <<  1 ) ^  auxL01$3 );
 redsxoriveR$h$4[i-1]=(( auxL01$4  <<  1 ) ^  auxL01$4 );auxL01$0= ppVE$0[i] ;auxL01$1= ppVE$1[i] ;auxL01$2= ppVE$2[i] ;
 auxL01$3= ppVE$3[i] ;auxL01$4= ppVE$4[i] ;redsxoriveR$d$0[i-1]=( auxL00$0  ^  auxL01$0 );redsxoriveR$d$1[i-1]=( auxL00$1  ^  auxL01$1 );
 redsxoriveR$d$2[i-1]=( auxL00$2  ^  auxL01$2 );redsxoriveR$d$3[i-1]=( auxL00$3  ^  auxL01$3 );redsxoriveR$d$4[i-1]=( auxL00$4  ^  auxL01$4 );redsxoriveR$ad$0[i-1]=( auxL00$0  ^ ( auxL01$0  >>>  1 ));
 redsxoriveR$ad$1[i-1]=( auxL00$1  ^ ( auxL01$1  >>>  1 ));redsxoriveR$ad$2[i-1]=( auxL00$2  ^ ( auxL01$2  >>>  1 ));redsxoriveR$ad$3[i-1]=( auxL00$3  ^ ( auxL01$3  >>>  1 ));redsxoriveR$ad$4[i-1]=( auxL00$4  ^ ( auxL01$4  >>>  1 ));
 auxL00$0= auxL01$0 ;auxL00$1= auxL01$1 ;auxL00$2= auxL01$2 ;auxL00$3= auxL01$3 ;
 auxL00$4= auxL01$4 ;
   } }
public static int ve_6_6GateCount=18;
 public static void ve_6_6(PrShift p,int [][] ppVE,int [][] redsxoriveR){
 int[] redsxoriveR$h$0=redsxoriveR[0],redsxoriveR$h$1=redsxoriveR[1],redsxoriveR$h$2=redsxoriveR[2],redsxoriveR$h$3=redsxoriveR[3],redsxoriveR$h$4=redsxoriveR[4],redsxoriveR$h$5=redsxoriveR[5],redsxoriveR$d$0=redsxoriveR[6],redsxoriveR$d$1=redsxoriveR[7],redsxoriveR$d$2=redsxoriveR[8],redsxoriveR$d$3=redsxoriveR[9],redsxoriveR$d$4=redsxoriveR[10],redsxoriveR$d$5=redsxoriveR[11],redsxoriveR$ad$0=redsxoriveR[12],redsxoriveR$ad$1=redsxoriveR[13],redsxoriveR$ad$2=redsxoriveR[14],redsxoriveR$ad$3=redsxoriveR[15],redsxoriveR$ad$4=redsxoriveR[16],redsxoriveR$ad$5=redsxoriveR[17],ppVE$0=ppVE[0],ppVE$1=ppVE[1],ppVE$2=ppVE[2],ppVE$3=ppVE[3],ppVE$4=ppVE[4],ppVE$5=ppVE[5];
// initialisation 
 int auxL03$0=0,auxL03$1=0,auxL03$2=0,auxL03$3=0,auxL03$4=0,auxL03$5=0,auxL04$0=0,auxL04$1=0,auxL04$2=0,auxL04$3=0,auxL04$4=0,auxL04$5=0;
for (int i = 1; i < ppVE$0.length -1; i++) {
 redsxoriveR$h$0[i-1]=(( auxL04$0  <<  1 ) ^  auxL04$0 );redsxoriveR$h$1[i-1]=(( auxL04$1  <<  1 ) ^  auxL04$1 );redsxoriveR$h$2[i-1]=(( auxL04$2  <<  1 ) ^  auxL04$2 );redsxoriveR$h$3[i-1]=(( auxL04$3  <<  1 ) ^  auxL04$3 );
 redsxoriveR$h$4[i-1]=(( auxL04$4  <<  1 ) ^  auxL04$4 );redsxoriveR$h$5[i-1]=(( auxL04$5  <<  1 ) ^  auxL04$5 );auxL04$0= ppVE$0[i] ;auxL04$1= ppVE$1[i] ;
 auxL04$2= ppVE$2[i] ;auxL04$3= ppVE$3[i] ;auxL04$4= ppVE$4[i] ;auxL04$5= ppVE$5[i] ;
 redsxoriveR$d$0[i-1]=( auxL03$0  ^  auxL04$0 );redsxoriveR$d$1[i-1]=( auxL03$1  ^  auxL04$1 );redsxoriveR$d$2[i-1]=( auxL03$2  ^  auxL04$2 );redsxoriveR$d$3[i-1]=( auxL03$3  ^  auxL04$3 );
 redsxoriveR$d$4[i-1]=( auxL03$4  ^  auxL04$4 );redsxoriveR$d$5[i-1]=( auxL03$5  ^  auxL04$5 );redsxoriveR$ad$0[i-1]=( auxL03$0  ^ ( auxL04$0  >>>  1 ));redsxoriveR$ad$1[i-1]=( auxL03$1  ^ ( auxL04$1  >>>  1 ));
 redsxoriveR$ad$2[i-1]=( auxL03$2  ^ ( auxL04$2  >>>  1 ));redsxoriveR$ad$3[i-1]=( auxL03$3  ^ ( auxL04$3  >>>  1 ));redsxoriveR$ad$4[i-1]=( auxL03$4  ^ ( auxL04$4  >>>  1 ));redsxoriveR$ad$5[i-1]=( auxL03$5  ^ ( auxL04$5  >>>  1 ));
 auxL03$0= auxL04$0 ;auxL03$1= auxL04$1 ;auxL03$2= auxL04$2 ;auxL03$3= auxL04$3 ;
 auxL03$4= auxL04$4 ;auxL03$5= auxL04$5 ;
   } }
public static int ve_3_3GateCount=9;
 public static void ve_3_3(PrShift p,int [][] ppVE,int [][] redsxoriveR){
 int[] redsxoriveR$h$0=redsxoriveR[0],redsxoriveR$h$1=redsxoriveR[1],redsxoriveR$h$2=redsxoriveR[2],redsxoriveR$d$0=redsxoriveR[3],redsxoriveR$d$1=redsxoriveR[4],redsxoriveR$d$2=redsxoriveR[5],redsxoriveR$ad$0=redsxoriveR[6],redsxoriveR$ad$1=redsxoriveR[7],redsxoriveR$ad$2=redsxoriveR[8],ppVE$0=ppVE[0],ppVE$1=ppVE[1],ppVE$2=ppVE[2];

// initialisation 
 int auxL42$0=0,auxL42$1=0,auxL42$2=0,auxL43$0=0,auxL43$1=0,auxL43$2=0;
for (int i = 1; i < ppVE$0.length -1; i++) {
 redsxoriveR$h$0[i-1]=(( auxL43$0  <<  1 ) ^  auxL43$0 );redsxoriveR$h$1[i-1]=(( auxL43$1  <<  1 ) ^  auxL43$1 );redsxoriveR$h$2[i-1]=(( auxL43$2  <<  1 ) ^  auxL43$2 );auxL43$0= ppVE$0[i] ;
 auxL43$1= ppVE$1[i] ;auxL43$2= ppVE$2[i] ;redsxoriveR$d$0[i-1]=( auxL42$0  ^  auxL43$0 );redsxoriveR$d$1[i-1]=( auxL42$1  ^  auxL43$1 );
 redsxoriveR$d$2[i-1]=( auxL42$2  ^  auxL43$2 );redsxoriveR$ad$0[i-1]=( auxL42$0  ^ ( auxL43$0  >>>  1 ));redsxoriveR$ad$1[i-1]=( auxL42$1  ^ ( auxL43$1  >>>  1 ));redsxoriveR$ad$2[i-1]=( auxL42$2  ^ ( auxL43$2  >>>  1 ));
 auxL42$0= auxL43$0 ;auxL42$1= auxL43$1 ;auxL42$2= auxL43$2 ;
  }
  ;
 ;
  }
public static int ve_4_4GateCount=12;
 public static void ve_4_4(PrShift p,int [][] ppVE,int [][] redsxoriveR){
 int[] redsxoriveR$h$0=redsxoriveR[0],redsxoriveR$h$1=redsxoriveR[1],redsxoriveR$h$2=redsxoriveR[2],redsxoriveR$h$3=redsxoriveR[3],redsxoriveR$d$0=redsxoriveR[4],redsxoriveR$d$1=redsxoriveR[5],redsxoriveR$d$2=redsxoriveR[6],redsxoriveR$d$3=redsxoriveR[7],redsxoriveR$ad$0=redsxoriveR[8],redsxoriveR$ad$1=redsxoriveR[9],redsxoriveR$ad$2=redsxoriveR[10],redsxoriveR$ad$3=redsxoriveR[11],ppVE$0=ppVE[0],ppVE$1=ppVE[1],ppVE$2=ppVE[2],ppVE$3=ppVE[3];

// initialisation 
 int auxL61$0=0,auxL61$1=0,auxL61$2=0,auxL61$3=0,auxL62$0=0,auxL62$1=0,auxL62$2=0,auxL62$3=0;
for (int i = 1; i < ppVE$0.length -1; i++) {
 redsxoriveR$h$0[i-1]=(( auxL62$0  <<  1 ) ^  auxL62$0 );redsxoriveR$h$1[i-1]=(( auxL62$1  <<  1 ) ^  auxL62$1 );redsxoriveR$h$2[i-1]=(( auxL62$2  <<  1 ) ^  auxL62$2 );redsxoriveR$h$3[i-1]=(( auxL62$3  <<  1 ) ^  auxL62$3 );
 auxL62$0= ppVE$0[i] ;auxL62$1= ppVE$1[i] ;auxL62$2= ppVE$2[i] ;auxL62$3= ppVE$3[i] ;
 redsxoriveR$d$0[i-1]=( auxL61$0  ^  auxL62$0 );redsxoriveR$d$1[i-1]=( auxL61$1  ^  auxL62$1 );redsxoriveR$d$2[i-1]=( auxL61$2  ^  auxL62$2 );redsxoriveR$d$3[i-1]=( auxL61$3  ^  auxL62$3 );
 redsxoriveR$ad$0[i-1]=( auxL61$0  ^ ( auxL62$0  >>>  1 ));redsxoriveR$ad$1[i-1]=( auxL61$1  ^ ( auxL62$1  >>>  1 ));redsxoriveR$ad$2[i-1]=( auxL61$2  ^ ( auxL62$2  >>>  1 ));redsxoriveR$ad$3[i-1]=( auxL61$3  ^ ( auxL62$3  >>>  1 ));
 auxL61$0= auxL62$0 ;auxL61$1= auxL62$1 ;auxL61$2= auxL62$2 ;auxL61$3= auxL62$3 ;
  }
  ;
p.prepareBit(redsxoriveR)
 ;
  }}