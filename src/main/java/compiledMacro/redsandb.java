package compiledMacro;
 import simulator.PrShift;

public class redsandb {

public static int ve_1_1GateCount=3;
public static void ve_1_1(PrShift p,int [] ppVE,int [][] redsandbveR){
int[] redsandbveR$h=redsandbveR[0],redsandbveR$d=redsandbveR[1],redsandbveR$ad=redsandbveR[2];

// initialisation 
int auxL44=0,auxL45=0;
for (int i = 1; i < ppVE.length -1; i++) {
redsandbveR$h[i-1]=(( auxL45  <<  1 ) &  auxL45 );auxL45= ppVE[i] ;redsandbveR$d[i-1]=( auxL44  &  auxL45 );redsandbveR$ad[i-1]=( auxL44  & ( auxL45  >>>  1 ));
auxL44= auxL45 ;
 }
 ;
p.prepareBit(redsandbveR)
;
 }
public static int vf_1_1GateCount=4;
public static void vf_1_1(PrShift p,int [] ppVF,int [][] redsandbvfR){
int[] redsandbvfR$do=redsandbvfR[0],redsandbvfR$up=redsandbvfR[1];

// initialisation 
int auxL43=0,tmun07=0,tmun08=0;
for (int i = 1; i < ppVF.length -1; i++) {
auxL43= ppVF[i] ;redsandbvfR$up[i-1]=(( tmun07  & ( auxL43  >>>  1 )) &  auxL43 );tmun07= auxL43 ;redsandbvfR$do[i-1]=( tmun08  &  auxL43 );
tmun08=(( auxL43  <<  1 ) &  auxL43 );
 }
 ;
p.prepareBit(redsandbvfR)
;
 }
public static int ev_1_1GateCount=5;
public static void ev_1_1(PrShift p,int [][] ppEV,int [] redsandbevR){
int[] ppEV$h=ppEV[0],ppEV$d=ppEV[1],ppEV$ad=ppEV[2];

// initialisation 
int auxL56=0,auxL57=0,auxL58=0,tmun01=0;
for (int i = 1; i < ppEV$h.length -1; i++) {
auxL56= ppEV$h[i] ;auxL57= ppEV$d[i] ;auxL58= ppEV$ad[i] ;redsandbevR[i]=(((( tmun01  &  auxL56 ) &  auxL57 ) &  auxL58 ) & ( auxL56  >>>  1 ));
tmun01=( auxL57  & ( auxL58  <<  1 ));
 }
 p.mirror(redsandbevR);
p.prepareBit(redsandbevR)
;
 }
public static int fv_1_1GateCount=5;
 public static void fv_1_1(PrShift p,int [][] ppFV,int [] redsandbfvR){
 int[] ppFV$do=ppFV[0],ppFV$up=ppFV[1];

// initialisation 
 int auxL98=0,auxL99=0,tmun10=0;
for (int i = 1; i < ppFV$do.length -1; i++) {
 auxL98= ppFV$do[i] ;auxL99= ppFV$up[i] ;redsandbfvR[i]=((( tmun10  &  auxL98 ) &  auxL99 ) & ( auxL98  >>>  1 ));tmun10=(( auxL99  &  auxL98 ) & ( auxL99  <<  1 ));
  }
  p.mirror(redsandbfvR);
p.prepareBit(redsandbfvR)
 ;
  }
public static int fe_1_1GateCount=3;
 public static void fe_1_1(PrShift p,int [][] ppFE,int [][] redsandbfeR){
 int[] redsandbfeR$h=redsandbfeR[0],redsandbfeR$d=redsandbfeR[1],redsandbfeR$ad=redsandbfeR[2],ppFE$do=ppFE[0],ppFE$up=ppFE[1];

// initialisation 
 int auxL116=0,auxL117=0,tmun32=0;
for (int i = 1; i < ppFE$do.length -1; i++) {
 auxL117= ppFE$do[i] ;auxL116= ppFE$up[i] ;redsandbfeR$h[i]=( auxL117  &  tmun32 );tmun32=( auxL116  <<  1 );
 redsandbfeR$d[i]=( auxL117  &  auxL116 );redsandbfeR$ad[i]=( auxL116  & ( auxL117  >>>  1 ));
  }
  ;
p.prepareBit(redsandbfeR)
 ;
  }}