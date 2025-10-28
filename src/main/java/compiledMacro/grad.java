package compiledMacro;
 import simulator.PrShift;
 public class grad{
 
public static int slopDelta_6_1_2_1_1GateCount=335;
 public static void slopDelta_6_1_2_1_1(PrShift p,int [][] pdis,int [][] slop,int [][] deltaR,int [][] level,int [][] resultCA,int [][] lldefVe){
 int[] lldefVe$e=lldefVe[0],lldefVe$se=lldefVe[1],lldefVe$sw=lldefVe[2],lldefVe$w=lldefVe[3],lldefVe$nw=lldefVe[4],lldefVe$ne=lldefVe[5],slop$e=slop[0],slop$se=slop[1],slop$sw=slop[2],slop$w=slop[3],slop$nw=slop[4],slop$ne=slop[5],deltaR$0=deltaR[0],deltaR$1=deltaR[1],level$h=level[0],level$d=level[1],level$ad=level[2],resultCA$h=resultCA[0],resultCA$d=resultCA[1],resultCA$ad=resultCA[2],pdis$0=pdis[0],pdis$1=pdis[1],pdis$2=pdis[2],pdis$3=pdis[3],pdis$4=pdis[4],pdis$5=pdis[5];

// initialisation 
 int auxL50=0,auxL51$0=0,auxL51$1=0,auxL51$2=0,auxL51$3=0,auxL51$4=0,auxL51$5=0,auxL52$0=0,auxL52$1=0,auxL52$2=0,auxL52$3=0,auxL52$4=0,auxL52$5=0,auxL81=0,auxL84$0=0,auxL84$1=0,auxL84$2=0,auxL84$3=0,auxL84$4=0,auxL84$5=0,auxL85$0=0,auxL85$1=0,auxL85$2=0,auxL85$3=0,auxL85$4=0,auxL85$5=0,auxL85$6=0,auxL86$0=0,auxL86$1=0,auxL86$2=0,auxL86$3=0,auxL86$4=0,auxL86$5=0,auxO08=0,defVe$e=0,defVe$ne=0,defVe$nw=0,defVe$se=0,defVe$sw=0,defVe$w=0,delta$0=0,delta$1=0,dis$0=0,dis$1=0,dis$2=0,dis$3=0,dis$4=0,dis$5=0,grad$0=0,grad$1=0,grad$2=0,grad$3=0,grad$4=0,grad$5=0,r0=0,r1=0,r10=0,r11=0,r12=0,r2=0,r3=0,r4=0,r5=0,r6=0,r7=0,r8=0,r9=0,tmun33$0=0,tmun33$1=0,tmun33$2=0,tmun33$3=0,tmun33$4=0,tmun33$5=0,tmun34=0,tmun35=0,tmun36=0,tmun37=0,tmun38=0,tmun39=0,tmun40$0=0,tmun40$1=0,tmun40$2=0,tmun40$3=0,tmun40$4=0,tmun40$5=0,tmun41=0,tmun42=0,tmun43=0,tmun44$0=0,tmun44$1=0,tmun44$2=0,tmun44$3=0,tmun44$4=0,tmun44$5=0,tmun45=0,tmun46=0,tmun47=0,tmun48=0,tmun49=0;
for (int i = 1; i < pdis$0.length -1; i++) {
 defVe$e= lldefVe$e[i] ;dis$0= pdis$0[i] ;dis$1= pdis$1[i] ;dis$2= pdis$2[i] ;
 dis$3= pdis$3[i] ;dis$4= pdis$4[i] ;dis$5= pdis$5[i] ;auxL52$0= dis$0 ;
 auxL52$1=((r0=~ dis$0 ) ^ ~ dis$1 );auxL52$2=((r0=( r0  & ~ dis$1 )) ^ ~ dis$2 );auxL52$3=((r0=( r0  & ~ dis$2 )) ^ ~ dis$3 );auxL52$4=((r0=( r0  & ~ dis$3 )) ^ ~ dis$4 );
 auxL52$5=(( r0  & ~ dis$4 ) ^ ~ dis$5 );grad$0= tmun33$0 ;grad$1= tmun33$1 ;grad$2= tmun33$2 ;
 grad$3= tmun33$3 ;grad$4= tmun33$4 ;grad$5= tmun33$5 ;tmun33$0=((r1=( auxL52$0  <<  1 )) ^  dis$0 );
 tmun33$1=(((r0=( dis$0  &  r1 )) ^ (r1=( auxL52$1  <<  1 ))) ^  dis$1 );tmun33$2=(((r0=(( r0  &  r1 ) | ( dis$1  & ( r0  |  r1 )))) ^ (r1=( auxL52$2  <<  1 ))) ^  dis$2 );tmun33$3=(((r0=(( r0  &  r1 ) | ( dis$2  & ( r0  |  r1 )))) ^ (r1=( auxL52$3  <<  1 ))) ^  dis$3 );tmun33$4=(((r0=(( r0  &  r1 ) | ( dis$3  & ( r0  |  r1 )))) ^ (r1=( auxL52$4  <<  1 ))) ^  dis$4 );
 tmun33$5=(((( r0  &  r1 ) | ( dis$4  & ( r0  |  r1 ))) ^ ( auxL52$5  <<  1 )) ^  dis$5 );auxL51$0= grad$0 ;auxL51$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL51$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );
 auxL51$3=((r0=( r0  & ~ grad$2 )) ^ ~ grad$3 );auxL51$4=((r0=( r0  & ~ grad$3 )) ^ ~ grad$4 );auxL51$5=(( r0  & ~ grad$4 ) ^ ~ grad$5 );r4= auxL51$0 ;
 r6= auxL51$1 ;r0= auxL51$2 ;r5= auxL51$3 ;r3= auxL51$4 ;
 r2=(r1= auxL51$5 );r7= r1 ;r1= r4 ;r10= r1 ;
 r1=~ r6 ;r10=( r10  |  r1 );r1=((r8= r6 ) ^  r0 );r10=( r10  |  r1 );
 r1=((r8=( r8  &  r0 )) ^  r5 );r10=( r10  |  r1 );r1=((r8=( r8  &  r5 )) ^  r3 );r10=( r10  |  r1 );
 r1=((r8=( r8  &  r3 )) ^  r2 );r10=( r10  |  r1 );r9=(r1=(( r8  &  r2 ) ^  r7 ));r10=( r10  |  r1 );
 delta$0= r10 ;delta$1= r9 ;r0= auxL51$5 ;auxL50= r0 ;
 slop$e[i-1]=(( tmun35  &  auxL50 ) |  tmun34 );tmun35= defVe$e ;defVe$w= lldefVe$w[i] ;auxO08= auxL50 ;
 auxL51$0= grad$0 ;auxL51$1= grad$1 ;auxL51$2= grad$2 ;auxL51$3= grad$3 ;
 auxL51$4= grad$4 ;auxL51$5= grad$5 ;r0= delta$0 ;r1= delta$1 ;
 r6=( auxL51$0  >>>  1 );r7=( auxL51$1  >>>  1 );r8=( auxL51$2  >>>  1 );r2=( auxL51$3  >>>  1 );
 r3=( auxL51$4  >>>  1 );r5=(r4=( auxL51$5  >>>  1 ));r9= r4 ;r12=(r10= r6 );
 r12=( r12  | (r10=~ r7 ));r12=( r12  | (r10=((r4= r7 ) ^  r8 )));r12=( r12  | (r10=((r4=( r4  &  r8 )) ^  r2 )));r12=( r12  | (r10=((r4=( r4  &  r2 )) ^  r3 )));
 r12=( r12  | (r10=((r4=( r4  &  r3 )) ^  r5 )));r12=( r12  | (r10=(( r4  &  r5 ) ^  r9 )));r11= r10 ;r4= r12 ;
 r3= r4 ;r2=(r4= r11 );r4=( r1  |  r2 );delta$0=( r4  | (~ r4  & ( r0  &  r3 )));
 delta$1= r4 ;r0= auxL51$5 ;auxL50= r0 ;slop$w[i-1]=(( tmun37  & ( auxL50  >>>  1 )) |  tmun36 );
 tmun37= defVe$w ;defVe$se= lldefVe$se[i] ;level$h[i-1]=~( auxO08  |  auxL50 );r0= grad$0 ;
 r0=( r0  |  grad$1 );r0=( r0  | ~ grad$2 );r0=( r0  | ((r1= grad$2 ) ^  grad$3 ));r0=( r0  | ((r1=( r1  &  grad$3 )) ^  grad$4 ));
 r0=( r0  | (( r1  &  grad$4 ) ^  grad$5 ));resultCA$h[i-1]=~ r0 ;grad$0=( auxL84$0  ^  auxL52$0 );grad$1=(((r0=( auxL52$0  &  auxL84$0 )) ^  auxL84$1 ) ^  auxL52$1 );
 grad$2=(((r0=(( r0  &  auxL84$1 ) | ( auxL52$1  & ( r0  |  auxL84$1 )))) ^  auxL84$2 ) ^  auxL52$2 );grad$3=(((r0=(( r0  &  auxL84$2 ) | ( auxL52$2  & ( r0  |  auxL84$2 )))) ^  auxL84$3 ) ^  auxL52$3 );grad$4=(((r0=(( r0  &  auxL84$3 ) | ( auxL52$3  & ( r0  |  auxL84$3 )))) ^  auxL84$4 ) ^  auxL52$4 );grad$5=(((( r0  &  auxL84$4 ) | ( auxL52$4  & ( r0  |  auxL84$4 ))) ^  auxL84$5 ) ^  auxL52$5 );
 auxL51$0= grad$0 ;auxL51$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL51$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );auxL51$3=((r0=( r0  & ~ grad$2 )) ^ ~ grad$3 );
 auxL51$4=((r0=( r0  & ~ grad$3 )) ^ ~ grad$4 );auxL51$5=(( r0  & ~ grad$4 ) ^ ~ grad$5 );r4= auxL51$0 ;r6= auxL51$1 ;
 r0= auxL51$2 ;r1= auxL51$3 ;r3= auxL51$4 ;r5=(r7= auxL51$5 );
 r2= r7 ;r7= delta$1 ;r11= r4 ;r8= r11 ;
 r11=~ r6 ;r8=( r8  |  r11 );r11=((r10= r6 ) ^  r0 );r8=( r8  |  r11 );
 r11=((r10=( r10  &  r0 )) ^  r1 );r8=( r8  |  r11 );r11=((r10=( r10  &  r1 )) ^  r3 );r8=( r8  |  r11 );
 r11=((r10=( r10  &  r3 )) ^  r5 );r8=( r8  |  r11 );r9=(r11=(( r10  &  r5 ) ^  r2 ));r8=( r8  |  r11 );
 r0= delta$0 ;r3=(r2= r8 );r2= r9 ;r1= r2 ;
 r2=( r7  |  r1 );delta$0=( r2  | (~ r2  & ( r0  &  r3 )));delta$1= r2 ;r0= auxL51$5 ;
 auxL50= r0 ;slop$se[i-1]=(( tmun39  &  auxL50 ) |  tmun38 );tmun39= defVe$se ;defVe$nw= lldefVe$nw[i] ;
 auxO08= auxL50 ;auxL51$0= grad$0 ;auxL51$1= grad$1 ;auxL51$2= grad$2 ;
 auxL51$3= grad$3 ;auxL51$4= grad$4 ;auxL51$5= grad$5 ;r0= delta$0 ;
 r1= delta$1 ;r6= tmun40$0 ;r9= tmun40$1 ;r2= tmun40$2 ;
 r7= tmun40$3 ;r4= tmun40$4 ;r5=(r3= tmun40$5 );r8= r3 ;
 r12= r6 ;r10= r12 ;r12=~ r9 ;r10=( r10  |  r12 );
 r12=((r3= r9 ) ^  r2 );r10=( r10  |  r12 );r12=((r3=( r3  &  r2 )) ^  r7 );r10=( r10  |  r12 );
 r12=((r3=( r3  &  r7 )) ^  r4 );r10=( r10  |  r12 );r12=((r3=( r3  &  r4 )) ^  r5 );r10=( r10  |  r12 );
 r11=(r12=(( r3  &  r5 ) ^  r8 ));r10=( r10  |  r12 );r3=(r4= r10 );r4= r11 ;
 r2= r4 ;r4=( r1  |  r2 );delta$0=( r4  | (~ r4  & ( r0  &  r3 )));delta$1= r4 ;
 tmun40$0= auxL51$0 ;tmun40$1= auxL51$1 ;tmun40$2= auxL51$2 ;tmun40$3= auxL51$3 ;
 tmun40$4= auxL51$4 ;tmun40$5= auxL51$5 ;r0= auxL51$5 ;auxL50= r0 ;
 slop$nw[i-1]=(( tmun43  &  tmun42 ) |  tmun41 );tmun42= auxL50 ;tmun43= defVe$nw ;defVe$ne= lldefVe$ne[i] ;
 level$d[i-1]=~( auxO08  |  auxL50 );r1= grad$0 ;r1=( r1  |  grad$1 );r1=( r1  | ~ grad$2 );
 r1=( r1  | ((r0= grad$2 ) ^  grad$3 ));r1=( r1  | ((r0=( r0  &  grad$3 )) ^  grad$4 ));r1=( r1  | (( r0  &  grad$4 ) ^  grad$5 ));resultCA$d[i-1]=~ r1 ;
 grad$0=( auxL84$0  ^ (r1=( auxL52$0  >>>  1 )));grad$1=(((r0=( r1  &  auxL84$0 )) ^  auxL84$1 ) ^ (r1=( auxL52$1  >>>  1 )));grad$2=(((r0=(( r0  &  auxL84$1 ) | ( r1  & ( r0  |  auxL84$1 )))) ^  auxL84$2 ) ^ (r1=( auxL52$2  >>>  1 )));grad$3=(((r0=(( r0  &  auxL84$2 ) | ( r1  & ( r0  |  auxL84$2 )))) ^  auxL84$3 ) ^ (r1=( auxL52$3  >>>  1 )));
 grad$4=(((r0=(( r0  &  auxL84$3 ) | ( r1  & ( r0  |  auxL84$3 )))) ^  auxL84$4 ) ^ (r1=( auxL52$4  >>>  1 )));grad$5=(((( r0  &  auxL84$4 ) | ( r1  & ( r0  |  auxL84$4 ))) ^  auxL84$5 ) ^ ( auxL52$5  >>>  1 ));auxL84$0= dis$0 ;auxL84$1= dis$1 ;
 auxL84$2= dis$2 ;auxL84$3= dis$3 ;auxL84$4= dis$4 ;auxL84$5= dis$5 ;
 auxL51$0= grad$0 ;auxL51$1= grad$1 ;auxL51$2= grad$2 ;auxL51$3= grad$3 ;
 auxL51$4= grad$4 ;auxL51$5= grad$5 ;r0= delta$1 ;r1= tmun44$0 ;
 r3= tmun44$1 ;r8= tmun44$2 ;r7= tmun44$3 ;r2= tmun44$4 ;
 r4=(r5= tmun44$5 );r6= r5 ;r5= delta$0 ;r9= r1 ;
 r10= r9 ;r9=~ r3 ;r10=( r10  |  r9 );r9=((r11= r3 ) ^  r8 );
 r10=( r10  |  r9 );r9=((r11=( r11  &  r8 )) ^  r7 );r10=( r10  |  r9 );r9=((r11=( r11  &  r7 )) ^  r2 );
 r10=( r10  |  r9 );r9=((r11=( r11  &  r2 )) ^  r4 );r10=( r10  |  r9 );r12=(r9=(( r11  &  r4 ) ^  r6 ));
 r10=( r10  |  r9 );r2=(r1= r10 );r1= r12 ;r3= r1 ;
 r1=( r0  |  r3 );delta$0=( r1  | (~ r1  & ( r5  &  r2 )));delta$1= r1 ;tmun44$0=( auxL51$0  <<  1 );
 tmun44$1=( auxL51$1  <<  1 );tmun44$2=( auxL51$2  <<  1 );tmun44$3=( auxL51$3  <<  1 );tmun44$4=( auxL51$4  <<  1 );
 tmun44$5=( auxL51$5  <<  1 );r0= auxL51$5 ;auxL50= r0 ;slop$ne[i-1]=(( tmun47  &  tmun46 ) |  tmun45 );
 tmun46=( auxL50  <<  1 );tmun47= defVe$ne ;defVe$sw= lldefVe$sw[i] ;auxO08= auxL50 ;
 auxL51$0= grad$0 ;auxL51$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL51$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );auxL51$3=((r0=( r0  & ~ grad$2 )) ^ ~ grad$3 );
 auxL51$4=((r0=( r0  & ~ grad$3 )) ^ ~ grad$4 );auxL51$5=(( r0  & ~ grad$4 ) ^ ~ grad$5 );r0= delta$0 ;r8= auxL51$0 ;
 r6= auxL51$1 ;r3= auxL51$2 ;r2= auxL51$3 ;r5= auxL51$4 ;
 r1=(r7= auxL51$5 );r4= r7 ;r9=(r10= r8 );r9=( r9  | (r10=~ r6 ));
 r9=( r9  | (r10=((r11= r6 ) ^  r3 )));r9=( r9  | (r10=((r11=( r11  &  r3 )) ^  r2 )));r9=( r9  | (r10=((r11=( r11  &  r2 )) ^  r5 )));r9=( r9  | (r10=((r11=( r11  &  r5 )) ^  r1 )));
 r9=( r9  | (r10=(( r11  &  r1 ) ^  r4 )));r7= r10 ;r1=(r3= r9 );r3= r7 ;
 r2= r3 ;r3= delta$1 ;r4=( r3  |  r2 );deltaR$0[i-1]=( r4  | (~ r4  & ( r0  &  r1 )));
 deltaR$1[i-1]= r4 ;r0= auxL51$5 ;auxL50= r0 ;slop$sw[i-1]=(( tmun49  &  auxL50 ) |  tmun48 );
 tmun49= defVe$sw ;level$ad[i-1]=~( auxO08  |  auxL50 );r0= grad$0 ;r0=( r0  |  grad$1 );
 r0=( r0  | ~ grad$2 );r0=( r0  | ((r1= grad$2 ) ^  grad$3 ));r0=( r0  | ((r1=( r1  &  grad$3 )) ^  grad$4 ));r0=( r0  | (( r1  &  grad$4 ) ^  grad$5 ));
 resultCA$ad[i-1]=~ r0 ;
  }
  p.mirror(deltaR);
p.prepareBit(slop);p.prepareBit(deltaR);p.prepareBit(level);p.prepareBit(resultCA)
 ;
  }
public static int slopDelta_5_1_2_1_1GateCount=292;
 public static void slopDelta_5_1_2_1_1(PrShift p,int [][] pdis,int [][] slop,int [][] deltaR,int [][] level,int [][] resultCA,int [][] lldefVe){
 int[] lldefVe$e=lldefVe[0],lldefVe$se=lldefVe[1],lldefVe$sw=lldefVe[2],lldefVe$w=lldefVe[3],lldefVe$nw=lldefVe[4],lldefVe$ne=lldefVe[5],slop$e=slop[0],slop$se=slop[1],slop$sw=slop[2],slop$w=slop[3],slop$nw=slop[4],slop$ne=slop[5],deltaR$0=deltaR[0],deltaR$1=deltaR[1],level$h=level[0],level$d=level[1],level$ad=level[2],resultCA$h=resultCA[0],resultCA$d=resultCA[1],resultCA$ad=resultCA[2],pdis$0=pdis[0],pdis$1=pdis[1],pdis$2=pdis[2],pdis$3=pdis[3],pdis$4=pdis[4];

// initialisation 
 int auxL50=0,auxL51$0=0,auxL51$1=0,auxL51$2=0,auxL51$3=0,auxL51$4=0,auxL52$0=0,auxL52$1=0,auxL52$2=0,auxL52$3=0,auxL52$4=0,auxL79$0=0,auxL79$1=0,auxL79$2=0,auxL79$3=0,auxL79$4=0,auxL80$0=0,auxL80$1=0,auxL80$2=0,auxL80$3=0,auxL80$4=0,auxL80$5=0,auxL80$6=0,auxL81=0,auxL82$0=0,auxL82$1=0,auxL82$2=0,auxL82$3=0,auxL82$4=0,auxO05=0,defVe$e=0,defVe$ne=0,defVe$nw=0,defVe$se=0,defVe$sw=0,defVe$w=0,delta$0=0,delta$1=0,dis$0=0,dis$1=0,dis$2=0,dis$3=0,dis$4=0,grad$0=0,grad$1=0,grad$2=0,grad$3=0,grad$4=0,r0=0,r1=0,r10=0,r11=0,r12=0,r2=0,r3=0,r4=0,r5=0,r6=0,r7=0,r8=0,r9=0,tmun16$0=0,tmun16$1=0,tmun16$2=0,tmun16$3=0,tmun16$4=0,tmun17=0,tmun18=0,tmun19=0,tmun20=0,tmun21=0,tmun22=0,tmun23$0=0,tmun23$1=0,tmun23$2=0,tmun23$3=0,tmun23$4=0,tmun24=0,tmun25=0,tmun26=0,tmun27$0=0,tmun27$1=0,tmun27$2=0,tmun27$3=0,tmun27$4=0,tmun28=0,tmun29=0,tmun30=0,tmun31=0,tmun32=0;
for (int i = 1; i < pdis$0.length -1; i++) {
 defVe$e= lldefVe$e[i] ;dis$0= pdis$0[i] ;dis$1= pdis$1[i] ;dis$2= pdis$2[i] ;
 dis$3= pdis$3[i] ;dis$4= pdis$4[i] ;auxL52$0= dis$0 ;auxL52$1=((r0=~ dis$0 ) ^ ~ dis$1 );
 auxL52$2=((r0=( r0  & ~ dis$1 )) ^ ~ dis$2 );auxL52$3=((r0=( r0  & ~ dis$2 )) ^ ~ dis$3 );auxL52$4=(( r0  & ~ dis$3 ) ^ ~ dis$4 );grad$0= tmun16$0 ;
 grad$1= tmun16$1 ;grad$2= tmun16$2 ;grad$3= tmun16$3 ;grad$4= tmun16$4 ;
 tmun16$0=((r1=( auxL52$0  <<  1 )) ^  dis$0 );tmun16$1=(((r0=( dis$0  &  r1 )) ^ (r1=( auxL52$1  <<  1 ))) ^  dis$1 );tmun16$2=(((r0=(( r0  &  r1 ) | ( dis$1  & ( r0  |  r1 )))) ^ (r1=( auxL52$2  <<  1 ))) ^  dis$2 );tmun16$3=(((r0=(( r0  &  r1 ) | ( dis$2  & ( r0  |  r1 )))) ^ (r1=( auxL52$3  <<  1 ))) ^  dis$3 );
 tmun16$4=(((( r0  &  r1 ) | ( dis$3  & ( r0  |  r1 ))) ^ ( auxL52$4  <<  1 )) ^  dis$4 );auxL51$0= grad$0 ;auxL51$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL51$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );
 auxL51$3=((r0=( r0  & ~ grad$2 )) ^ ~ grad$3 );auxL51$4=(( r0  & ~ grad$3 ) ^ ~ grad$4 );r5= auxL51$0 ;r3= auxL51$1 ;
 r2= auxL51$2 ;r4= auxL51$3 ;r0=(r7= auxL51$4 );r6= r7 ;
 r1= r7 ;r8=(r9= r5 );r8=( r8  | (r9=~ r3 ));r8=( r8  | (r9=((r10= r3 ) ^  r2 )));
 r8=( r8  | (r9=((r10=( r10  &  r2 )) ^  r4 )));r8=( r8  | (r9=((r10=( r10  &  r4 )) ^  r0 )));r8=( r8  | (r9=((r10=( r10  &  r0 )) ^  r6 )));r8=( r8  | (r9=(( r10  &  r6 ) ^  r1 )));
 r7= r9 ;delta$0= r8 ;delta$1= r7 ;r0= auxL51$4 ;
 auxL50= r0 ;slop$e[i-1]=(( tmun18  &  auxL50 ) |  tmun17 );tmun18= defVe$e ;defVe$w= lldefVe$w[i] ;
 auxO05= auxL50 ;auxL51$0= grad$0 ;auxL51$1= grad$1 ;auxL51$2= grad$2 ;
 auxL51$3= grad$3 ;auxL51$4= grad$4 ;r0= delta$1 ;r5=( auxL51$0  >>>  1 );
 r1=( auxL51$1  >>>  1 );r7=( auxL51$2  >>>  1 );r2=( auxL51$3  >>>  1 );r4=(r3=( auxL51$4  >>>  1 ));
 r6= r3 ;r8= r3 ;r3= delta$0 ;r9=(r10= r5 );
 r9=( r9  | (r10=~ r1 ));r9=( r9  | (r10=((r11= r1 ) ^  r7 )));r9=( r9  | (r10=((r11=( r11  &  r7 )) ^  r2 )));r9=( r9  | (r10=((r11=( r11  &  r2 )) ^  r4 )));
 r9=( r9  | (r10=((r11=( r11  &  r4 )) ^  r6 )));r9=( r9  | (r10=(( r11  &  r6 ) ^  r8 )));r12= r10 ;r2= r9 ;
 r4= r2 ;r1=(r2= r12 );r2=( r0  |  r1 );delta$0=( r2  | (~ r2  & ( r3  &  r4 )));
 delta$1= r2 ;r0= auxL51$4 ;auxL50= r0 ;slop$w[i-1]=(( tmun20  & ( auxL50  >>>  1 )) |  tmun19 );
 tmun20= defVe$w ;defVe$se= lldefVe$se[i] ;level$h[i-1]=~( auxO05  |  auxL50 );r0= grad$0 ;
 r0=( r0  |  grad$1 );r0=( r0  | ~ grad$2 );r0=( r0  | ((r1= grad$2 ) ^  grad$3 ));r0=( r0  | (( r1  &  grad$3 ) ^  grad$4 ));
 resultCA$h[i-1]=~ r0 ;grad$0=( auxL79$0  ^  auxL52$0 );grad$1=(((r0=( auxL52$0  &  auxL79$0 )) ^  auxL79$1 ) ^  auxL52$1 );grad$2=(((r0=(( r0  &  auxL79$1 ) | ( auxL52$1  & ( r0  |  auxL79$1 )))) ^  auxL79$2 ) ^  auxL52$2 );
 grad$3=(((r0=(( r0  &  auxL79$2 ) | ( auxL52$2  & ( r0  |  auxL79$2 )))) ^  auxL79$3 ) ^  auxL52$3 );grad$4=(((( r0  &  auxL79$3 ) | ( auxL52$3  & ( r0  |  auxL79$3 ))) ^  auxL79$4 ) ^  auxL52$4 );auxL51$0= grad$0 ;auxL51$1=((r0=~ grad$0 ) ^ ~ grad$1 );
 auxL51$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );auxL51$3=((r0=( r0  & ~ grad$2 )) ^ ~ grad$3 );auxL51$4=(( r0  & ~ grad$3 ) ^ ~ grad$4 );r0= delta$0 ;
 r5= auxL51$0 ;r7= auxL51$1 ;r6= auxL51$2 ;r4= auxL51$3 ;
 r2=(r1= auxL51$4 );r8= r1 ;r3= r1 ;r9=(r11= r5 );
 r9=( r9  | (r11=~ r7 ));r9=( r9  | (r11=((r10= r7 ) ^  r6 )));r9=( r9  | (r11=((r10=( r10  &  r6 )) ^  r4 )));r9=( r9  | (r11=((r10=( r10  &  r4 )) ^  r2 )));
 r9=( r9  | (r11=((r10=( r10  &  r2 )) ^  r8 )));r9=( r9  | (r11=(( r10  &  r8 ) ^  r3 )));r1= r11 ;r3=(r4= r9 );
 r4= r1 ;r2= r4 ;r1= delta$1 ;r4=( r1  |  r2 );
 delta$0=( r4  | (~ r4  & ( r0  &  r3 )));delta$1= r4 ;r0= auxL51$4 ;auxL50= r0 ;
 slop$se[i-1]=(( tmun22  &  auxL50 ) |  tmun21 );tmun22= defVe$se ;defVe$nw= lldefVe$nw[i] ;auxO05= auxL50 ;
 auxL51$0= grad$0 ;auxL51$1= grad$1 ;auxL51$2= grad$2 ;auxL51$3= grad$3 ;
 auxL51$4= grad$4 ;r5= tmun23$0 ;r3= tmun23$1 ;r0= tmun23$2 ;
 r2= tmun23$3 ;r7=(r4= tmun23$4 );r6= r4 ;r1= r4 ;
 r4=(r8= r5 );r4=( r4  | (r8=~ r3 ));r4=( r4  | (r8=((r9= r3 ) ^  r0 )));r4=( r4  | (r8=((r9=( r9  &  r0 )) ^  r2 )));
 r4=( r4  | (r8=((r9=( r9  &  r2 )) ^  r7 )));r4=( r4  | (r8=((r9=( r9  &  r7 )) ^  r6 )));r4=( r4  | (r8=(( r9  &  r6 ) ^  r1 )));r10= r8 ;
 r1= r4 ;r0= r1 ;r2=(r1= r10 );r1= delta$1 ;
 r3=( r1  |  r2 );r1= delta$0 ;delta$0=( r3  | (~ r3  & ( r1  &  r0 )));delta$1= r3 ;
 tmun23$0= auxL51$0 ;tmun23$1= auxL51$1 ;tmun23$2= auxL51$2 ;tmun23$3= auxL51$3 ;
 tmun23$4= auxL51$4 ;r0= auxL51$4 ;auxL50= r0 ;slop$nw[i-1]=(( tmun26  &  tmun25 ) |  tmun24 );
 tmun25= auxL50 ;tmun26= defVe$nw ;defVe$ne= lldefVe$ne[i] ;level$d[i-1]=~( auxO05  |  auxL50 );
 r0= grad$0 ;r0=( r0  |  grad$1 );r0=( r0  | ~ grad$2 );r0=( r0  | ((r1= grad$2 ) ^  grad$3 ));
 r0=( r0  | (( r1  &  grad$3 ) ^  grad$4 ));resultCA$d[i-1]=~ r0 ;grad$0=( auxL79$0  ^ (r0=( auxL52$0  >>>  1 )));grad$1=(((r1=( r0  &  auxL79$0 )) ^  auxL79$1 ) ^ (r0=( auxL52$1  >>>  1 )));
 grad$2=(((r1=(( r1  &  auxL79$1 ) | ( r0  & ( r1  |  auxL79$1 )))) ^  auxL79$2 ) ^ (r0=( auxL52$2  >>>  1 )));grad$3=(((r1=(( r1  &  auxL79$2 ) | ( r0  & ( r1  |  auxL79$2 )))) ^  auxL79$3 ) ^ (r0=( auxL52$3  >>>  1 )));grad$4=(((( r1  &  auxL79$3 ) | ( r0  & ( r1  |  auxL79$3 ))) ^  auxL79$4 ) ^ ( auxL52$4  >>>  1 ));auxL79$0= dis$0 ;
 auxL79$1= dis$1 ;auxL79$2= dis$2 ;auxL79$3= dis$3 ;auxL79$4= dis$4 ;
 auxL51$0= grad$0 ;auxL51$1= grad$1 ;auxL51$2= grad$2 ;auxL51$3= grad$3 ;
 auxL51$4= grad$4 ;r0= tmun27$0 ;r6= tmun27$1 ;r3= tmun27$2 ;
 r4= tmun27$3 ;r2=(r7= tmun27$4 );r1= r7 ;r5= r7 ;
 r8=(r10= r0 );r8=( r8  | (r10=~ r6 ));r8=( r8  | (r10=((r9= r6 ) ^  r3 )));r8=( r8  | (r10=((r9=( r9  &  r3 )) ^  r4 )));
 r8=( r8  | (r10=((r9=( r9  &  r4 )) ^  r2 )));r8=( r8  | (r10=((r9=( r9  &  r2 )) ^  r1 )));r8=( r8  | (r10=(( r9  &  r1 ) ^  r5 )));r7= r10 ;
 r0= r8 ;r1= r0 ;r2=(r0= r7 );r0= delta$0 ;
 r3= delta$1 ;r4=( r3  |  r2 );delta$0=( r4  | (~ r4  & ( r0  &  r1 )));delta$1= r4 ;
 tmun27$0=( auxL51$0  <<  1 );tmun27$1=( auxL51$1  <<  1 );tmun27$2=( auxL51$2  <<  1 );tmun27$3=( auxL51$3  <<  1 );
 tmun27$4=( auxL51$4  <<  1 );r0= auxL51$4 ;auxL50= r0 ;slop$ne[i-1]=(( tmun30  &  tmun29 ) |  tmun28 );
 tmun30= defVe$ne ;tmun29=( auxL50  <<  1 );defVe$sw= lldefVe$sw[i] ;auxO05= auxL50 ;
 auxL51$0= grad$0 ;auxL51$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL51$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );auxL51$3=((r0=( r0  & ~ grad$2 )) ^ ~ grad$3 );
 auxL51$4=(( r0  & ~ grad$3 ) ^ ~ grad$4 );r0= delta$0 ;r1= delta$1 ;r2= auxL51$0 ;
 r3= auxL51$1 ;r6= auxL51$2 ;r7= auxL51$3 ;r4=(r9= auxL51$4 );
 r8= r9 ;r5= r9 ;r12= r2 ;r11= r12 ;
 r12=~ r3 ;r11=( r11  |  r12 );r12=((r10= r3 ) ^  r6 );r11=( r11  |  r12 );
 r12=((r10=( r10  &  r6 )) ^  r7 );r11=( r11  |  r12 );r12=((r10=( r10  &  r7 )) ^  r4 );r11=( r11  |  r12 );
 r12=((r10=( r10  &  r4 )) ^  r8 );r11=( r11  |  r12 );r9=(r12=(( r10  &  r8 ) ^  r5 ));r11=( r11  |  r12 );
 r3=(r2= r11 );r2= r9 ;r4= r2 ;r2=( r1  |  r4 );
 deltaR$0[i-1]=( r2  | (~ r2  & ( r0  &  r3 )));deltaR$1[i-1]= r2 ;r0= auxL51$4 ;auxL50= r0 ;
 slop$sw[i-1]=(( tmun32  &  auxL50 ) |  tmun31 );tmun32= defVe$sw ;level$ad[i-1]=~( auxO05  |  auxL50 );r1= grad$0 ;
 r1=( r1  |  grad$1 );r1=( r1  | ~ grad$2 );r1=( r1  | ((r0= grad$2 ) ^  grad$3 ));r1=( r1  | (( r0  &  grad$3 ) ^  grad$4 ));
 resultCA$ad[i-1]=~ r1 ;
  }
  p.mirror(deltaR);
p.prepareBit(slop);p.prepareBit(deltaR);p.prepareBit(level);p.prepareBit(resultCA)
 ;
  }
public static int lt_3_3_1GateCount=33;
 public static void lt_3_3_1(PrShift p,int [][] pdis,int [][] psegment,int [][] gradlt){
 int[] gradlt$h1=gradlt[0],gradlt$h2=gradlt[1],gradlt$d1=gradlt[2],gradlt$d2=gradlt[3],gradlt$ad1=gradlt[4],gradlt$ad2=gradlt[5],pdis$0=pdis[0],pdis$1=pdis[1],pdis$2=pdis[2],psegment$h$0=psegment[0],psegment$h$1=psegment[1],psegment$h$2=psegment[2],psegment$d$0=psegment[3],psegment$d$1=psegment[4],psegment$d$2=psegment[5],psegment$ad$0=psegment[6],psegment$ad$1=psegment[7],psegment$ad$2=psegment[8];

// initialisation 
 int auxL54=0,auxL72$0=0,auxL72$1=0,auxL72$2=0,auxL73$0=0,auxL73$1=0,auxL73$2=0,auxTmp1$0=0,auxTmp1$1=0,auxTmp1$2=0,r0=0,segment$0=0,segment$1=0,segment$2=0,tmun06$0=0,tmun06$1=0,tmun06$2=0,tmun07$0=0,tmun07$1=0,tmun07$2=0,tmun08=0,tmun09$0=0,tmun09$1=0,tmun09$2=0,tmun10=0,tmun11$0=0,tmun11$1=0,tmun11$2=0,tmun12=0;
for (int i = 1; i < pdis$0.length -1; i++) {
 auxL73$0= pdis$0[i] ;auxL73$1= pdis$1[i] ;auxL73$2= pdis$2[i] ;auxTmp1$0= auxL72$0 ;
 auxTmp1$1= auxL72$1 ;auxTmp1$2= auxL72$2 ;segment$0= psegment$h$0[i] ;segment$1= psegment$h$1[i] ;
 segment$2= psegment$h$2[i] ;r0=( tmun07$0  &  auxTmp1$0 );r0=( r0  | ( tmun07$1  &  auxTmp1$1 ));r0=( r0  | ( tmun07$2  &  auxTmp1$2 ));
 auxL54= r0 ;tmun07$2= segment$2 ;tmun07$1=(~(r0= segment$2 ) &  segment$1 );tmun07$0=(~ segment$1  &  segment$0 );
 tmun06$0=( auxL73$0  <<  1 );tmun06$1=( auxL73$1  <<  1 );tmun06$2=( auxL73$2  <<  1 );gradlt$h1[i-1]= auxL54 ;
 gradlt$h2[i-1]=(~ auxL54  &  tmun08 );r0= segment$0 ;tmun08= r0 ;auxTmp1$0= auxL72$0 ;
 auxTmp1$1= auxL72$1 ;auxTmp1$2= auxL72$2 ;segment$0= psegment$d$0[i] ;segment$1= psegment$d$1[i] ;
 segment$2= psegment$d$2[i] ;r0=( tmun09$0  &  auxTmp1$0 );r0=( r0  | ( tmun09$1  &  auxTmp1$1 ));r0=( r0  | ( tmun09$2  &  auxTmp1$2 ));
 auxL54= r0 ;tmun09$2= segment$2 ;tmun09$1=(~(r0= segment$2 ) &  segment$1 );tmun09$0=(~ segment$1  &  segment$0 );
 gradlt$d1[i-1]= auxL54 ;gradlt$d2[i-1]=(~ auxL54  &  tmun10 );r0= segment$0 ;tmun10= r0 ;
 auxTmp1$0= auxL72$0 ;auxTmp1$1= auxL72$1 ;auxTmp1$2= auxL72$2 ;auxL72$0= auxL73$0 ;
 auxL72$1= auxL73$1 ;auxL72$2= auxL73$2 ;segment$0= psegment$ad$0[i] ;segment$1= psegment$ad$1[i] ;
 segment$2= psegment$ad$2[i] ;r0=( tmun11$0  &  auxTmp1$0 );r0=( r0  | ( tmun11$1  &  auxTmp1$1 ));r0=( r0  | ( tmun11$2  &  auxTmp1$2 ));
 auxL54= r0 ;tmun11$2= segment$2 ;tmun11$1=(~(r0= segment$2 ) &  segment$1 );tmun11$0=(~ segment$1  &  segment$0 );
 gradlt$ad1[i-1]= auxL54 ;gradlt$ad2[i-1]=(~ auxL54  &  tmun12 );r0= segment$0 ;tmun12= r0 ;
  }
  ;
p.prepareBit(gradlt)
 ;
  }
public static int ltapex2_3_3_1_1GateCount=21;
 public static void ltapex2_3_3_1_1(PrShift p,int [][] pdeef,int [][] psegmentderiv,int [][] pdifff,int [][] gradltapex2){
 int[] gradltapex2$h1=gradltapex2[0],gradltapex2$h2=gradltapex2[1],gradltapex2$d1=gradltapex2[2],gradltapex2$d2=gradltapex2[3],gradltapex2$ad1=gradltapex2[4],gradltapex2$ad2=gradltapex2[5],pdeef$h1$0=pdeef[0],pdeef$h1$1=pdeef[1],pdeef$h1$2=pdeef[2],pdeef$h2$0=pdeef[3],pdeef$h2$1=pdeef[4],pdeef$h2$2=pdeef[5],pdeef$d1$0=pdeef[6],pdeef$d1$1=pdeef[7],pdeef$d1$2=pdeef[8],pdeef$d2$0=pdeef[9],pdeef$d2$1=pdeef[10],pdeef$d2$2=pdeef[11],pdeef$ad1$0=pdeef[12],pdeef$ad1$1=pdeef[13],pdeef$ad1$2=pdeef[14],pdeef$ad2$0=pdeef[15],pdeef$ad2$1=pdeef[16],pdeef$ad2$2=pdeef[17],psegmentderiv$h$0=psegmentderiv[0],psegmentderiv$h$1=psegmentderiv[1],psegmentderiv$h$2=psegmentderiv[2],psegmentderiv$d$0=psegmentderiv[3],psegmentderiv$d$1=psegmentderiv[4],psegmentderiv$d$2=psegmentderiv[5],psegmentderiv$ad$0=psegmentderiv[6],psegmentderiv$ad$1=psegmentderiv[7],psegmentderiv$ad$2=psegmentderiv[8],pdifff$h=pdifff[0],pdifff$d=pdifff[1],pdifff$ad=pdifff[2];

// initialisation 
 int auxL53=0,r0=0;
for (int i = 1; i < pdeef$h1$0.length -1; i++) {
 r0=( psegmentderiv$h$0[i]  &  pdeef$h1$0[i] );r0=( r0  | ( psegmentderiv$h$1[i]  &  pdeef$h1$1[i] ));r0=( r0  | ( psegmentderiv$h$2[i]  &  pdeef$h1$2[i] ));auxL53= r0 ;
 gradltapex2$h1[i]= auxL53 ;gradltapex2$h2[i]=(~ auxL53  &  pdifff$h[i] );r0=( psegmentderiv$d$0[i]  &  pdeef$d1$0[i] );r0=( r0  | ( psegmentderiv$d$1[i]  &  pdeef$d1$1[i] ));
 r0=( r0  | ( psegmentderiv$d$2[i]  &  pdeef$d1$2[i] ));auxL53= r0 ;gradltapex2$d1[i]= auxL53 ;gradltapex2$d2[i]=(~ auxL53  &  pdifff$d[i] );
 r0=( psegmentderiv$ad$0[i]  &  pdeef$ad1$0[i] );r0=( r0  | ( psegmentderiv$ad$1[i]  &  pdeef$ad1$1[i] ));r0=( r0  | ( psegmentderiv$ad$2[i]  &  pdeef$ad1$2[i] ));auxL53= r0 ;
 gradltapex2$ad1[i]= auxL53 ;gradltapex2$ad2[i]=(~ auxL53  &  pdifff$ad[i] );
  }
  ;
p.prepareBit(gradltapex2)
 ;
  }
public static int slopDelta_3_1_2_1_1GateCount=215;
 public static void slopDelta_3_1_2_1_1(PrShift p,int [][] pdis,int [][] slop,int [][] deltaR,int [][] level,int [][] resultCA,int [][] lldefVe){
 int[] lldefVe$e=lldefVe[0],lldefVe$se=lldefVe[1],lldefVe$sw=lldefVe[2],lldefVe$w=lldefVe[3],lldefVe$nw=lldefVe[4],lldefVe$ne=lldefVe[5],slop$e=slop[0],slop$se=slop[1],slop$sw=slop[2],slop$w=slop[3],slop$nw=slop[4],slop$ne=slop[5],deltaR$0=deltaR[0],deltaR$1=deltaR[1],level$h=level[0],level$d=level[1],level$ad=level[2],resultCA$h=resultCA[0],resultCA$d=resultCA[1],resultCA$ad=resultCA[2],pdis$0=pdis[0],pdis$1=pdis[1],pdis$2=pdis[2];

// initialisation 
 int auxL50=0,auxL51$0=0,auxL51$1=0,auxL51$2=0,auxL52$0=0,auxL52$1=0,auxL52$2=0,auxL76$0=0,auxL76$1=0,auxL76$2=0,auxL77$0=0,auxL77$1=0,auxL77$2=0,auxL77$3=0,auxL77$4=0,auxL77$5=0,auxL77$6=0,auxL78=0,auxL79$0=0,auxL79$1=0,auxL79$2=0,auxL79$3=0,auxO08=0,defVe$e=0,defVe$ne=0,defVe$nw=0,defVe$se=0,defVe$sw=0,defVe$w=0,delta$0=0,delta$1=0,dis$0=0,dis$1=0,dis$2=0,grad$0=0,grad$1=0,grad$2=0,r0=0,r1=0,r10=0,r11=0,r12=0,r2=0,r3=0,r4=0,r5=0,r6=0,r7=0,r8=0,r9=0,tmun09$0=0,tmun09$1=0,tmun09$2=0,tmun10=0,tmun11=0,tmun12=0,tmun13=0,tmun14=0,tmun15=0,tmun16$0=0,tmun16$1=0,tmun16$2=0,tmun17=0,tmun18=0,tmun19=0,tmun20$0=0,tmun20$1=0,tmun20$2=0,tmun21=0,tmun22=0,tmun23=0,tmun24=0,tmun25=0;
for (int i = 1; i < pdis$0.length -1; i++) {
 defVe$e= lldefVe$e[i] ;dis$0= pdis$0[i] ;dis$1= pdis$1[i] ;dis$2= pdis$2[i] ;
 auxL52$0= dis$0 ;auxL52$1=((r0=~ dis$0 ) ^ ~ dis$1 );auxL52$2=(( r0  & ~ dis$1 ) ^ ~ dis$2 );grad$0= tmun09$0 ;
 grad$1= tmun09$1 ;grad$2= tmun09$2 ;tmun09$0=((r1=( auxL52$0  <<  1 )) ^  dis$0 );tmun09$1=(((r0=( dis$0  &  r1 )) ^ (r1=( auxL52$1  <<  1 ))) ^  dis$1 );
 tmun09$2=(((( r0  &  r1 ) | ( dis$1  & ( r0  |  r1 ))) ^ ( auxL52$2  <<  1 )) ^  dis$2 );auxL51$0= grad$0 ;auxL51$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL51$2=(( r0  & ~ grad$1 ) ^ ~ grad$2 );
 r7= auxL51$0 ;r2= auxL51$1 ;r1=(r3= auxL51$2 );r0= r3 ;
 r5= r3 ;r4= r3 ;r6= r3 ;r8= r7 ;
 r3= r8 ;r8=~ r2 ;r3=( r3  |  r8 );r8=((r10= r2 ) ^  r1 );
 r3=( r3  |  r8 );r8=((r10=( r10  &  r1 )) ^  r0 );r3=( r3  |  r8 );r8=((r10=( r10  &  r0 )) ^  r5 );
 r3=( r3  |  r8 );r8=((r10=( r10  &  r5 )) ^  r4 );r3=( r3  |  r8 );r9=(r8=(( r10  &  r4 ) ^  r6 ));
 r3=( r3  |  r8 );delta$0= r3 ;delta$1= r9 ;r0= auxL51$2 ;
 auxL50= r0 ;slop$e[i-1]=(( tmun11  &  auxL50 ) |  tmun10 );tmun11= defVe$e ;defVe$w= lldefVe$w[i] ;
 auxO08= auxL50 ;auxL51$0= grad$0 ;auxL51$1= grad$1 ;auxL51$2= grad$2 ;
 r0= delta$0 ;r1= delta$1 ;r5=( auxL51$0  >>>  1 );r8=( auxL51$1  >>>  1 );
 r3=(r7=( auxL51$2  >>>  1 ));r4= r7 ;r6= r7 ;r9= r7 ;
 r2= r7 ;r12=(r10= r5 );r12=( r12  | (r10=~ r8 ));r12=( r12  | (r10=((r7= r8 ) ^  r3 )));
 r12=( r12  | (r10=((r7=( r7  &  r3 )) ^  r4 )));r12=( r12  | (r10=((r7=( r7  &  r4 )) ^  r6 )));r12=( r12  | (r10=((r7=( r7  &  r6 )) ^  r9 )));r12=( r12  | (r10=(( r7  &  r9 ) ^  r2 )));
 r11= r10 ;r2= r12 ;r3= r2 ;r4=(r2= r11 );
 r2=( r1  |  r4 );delta$0=( r2  | (~ r2  & ( r0  &  r3 )));delta$1= r2 ;r0= auxL51$2 ;
 auxL50= r0 ;slop$w[i-1]=(( tmun13  & ( auxL50  >>>  1 )) |  tmun12 );tmun13= defVe$w ;defVe$se= lldefVe$se[i] ;
 level$h[i-1]=~( auxO08  |  auxL50 );r0=(r1= grad$0 );r0=( r0  | (r1= grad$1 ));r0=( r0  | ~(r1=(r2= grad$2 )));
 r0=( r0  | ( r1  ^  r2 ));resultCA$h[i-1]=~ r0 ;grad$0=( auxL76$0  ^  auxL52$0 );grad$1=(((r0=( auxL52$0  &  auxL76$0 )) ^  auxL76$1 ) ^  auxL52$1 );
 grad$2=(((( r0  &  auxL76$1 ) | ( auxL52$1  & ( r0  |  auxL76$1 ))) ^  auxL76$2 ) ^  auxL52$2 );auxL51$0= grad$0 ;auxL51$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL51$2=(( r0  & ~ grad$1 ) ^ ~ grad$2 );
 r5= auxL51$0 ;r3= auxL51$1 ;r1=(r7= auxL51$2 );r0= r7 ;
 r4= r7 ;r2= r7 ;r6= r7 ;r9=(r7= r5 );
 r9=( r9  | (r7=~ r3 ));r9=( r9  | (r7=((r8= r3 ) ^  r1 )));r9=( r9  | (r7=((r8=( r8  &  r1 )) ^  r0 )));r9=( r9  | (r7=((r8=( r8  &  r0 )) ^  r4 )));
 r9=( r9  | (r7=((r8=( r8  &  r4 )) ^  r2 )));r9=( r9  | (r7=(( r8  &  r2 ) ^  r6 )));r10= r7 ;r0= delta$0 ;
 r3= r9 ;r2= r3 ;r1=(r3= r10 );r3= delta$1 ;
 r4=( r3  |  r1 );delta$0=( r4  | (~ r4  & ( r0  &  r2 )));delta$1= r4 ;r0= auxL51$2 ;
 auxL50= r0 ;slop$se[i-1]=(( tmun15  &  auxL50 ) |  tmun14 );tmun15= defVe$se ;defVe$nw= lldefVe$nw[i] ;
 auxO08= auxL50 ;auxL51$0= grad$0 ;auxL51$1= grad$1 ;auxL51$2= grad$2 ;
 r5= tmun16$0 ;r0= tmun16$1 ;r7=(r2= tmun16$2 );r6= r2 ;
 r3= r2 ;r1= r2 ;r4= r2 ;r2= r5 ;
 r8= r2 ;r2=~ r0 ;r8=( r8  |  r2 );r2=((r9= r0 ) ^  r7 );
 r8=( r8  |  r2 );r2=((r9=( r9  &  r7 )) ^  r6 );r8=( r8  |  r2 );r2=((r9=( r9  &  r6 )) ^  r3 );
 r8=( r8  |  r2 );r2=((r9=( r9  &  r3 )) ^  r1 );r8=( r8  |  r2 );r10=(r2=(( r9  &  r1 ) ^  r4 ));
 r8=( r8  |  r2 );r1= r8 ;r2= r1 ;r0=(r1= r10 );
 r1= delta$1 ;r3=( r1  |  r0 );r0= delta$0 ;delta$0=( r3  | (~ r3  & ( r0  &  r2 )));
 delta$1= r3 ;tmun16$0= auxL51$0 ;tmun16$1= auxL51$1 ;tmun16$2= auxL51$2 ;
 r0= auxL51$2 ;auxL50= r0 ;slop$nw[i-1]=(( tmun19  &  tmun18 ) |  tmun17 );tmun18= auxL50 ;
 tmun19= defVe$nw ;defVe$ne= lldefVe$ne[i] ;level$d[i-1]=~( auxO08  |  auxL50 );r1=(r2= grad$0 );
 r1=( r1  | (r2= grad$1 ));r1=( r1  | ~(r2=(r0= grad$2 )));r1=( r1  | ( r2  ^  r0 ));resultCA$d[i-1]=~ r1 ;
 grad$0=( auxL76$0  ^ (r0=( auxL52$0  >>>  1 )));grad$1=(((r1=( r0  &  auxL76$0 )) ^  auxL76$1 ) ^ (r0=( auxL52$1  >>>  1 )));grad$2=(((( r1  &  auxL76$1 ) | ( r0  & ( r1  |  auxL76$1 ))) ^  auxL76$2 ) ^ ( auxL52$2  >>>  1 ));auxL76$0= dis$0 ;
 auxL76$1= dis$1 ;auxL76$2= dis$2 ;auxL51$0= grad$0 ;auxL51$1= grad$1 ;
 auxL51$2= grad$2 ;r3= tmun20$0 ;r2= tmun20$1 ;r7=(r4= tmun20$2 );
 r1= r4 ;r6= r4 ;r5= r4 ;r0= r4 ;
 r4= delta$0 ;r8= delta$1 ;r9=(r10= r3 );r9=( r9  | (r10=~ r2 ));
 r9=( r9  | (r10=((r11= r2 ) ^  r7 )));r9=( r9  | (r10=((r11=( r11  &  r7 )) ^  r1 )));r9=( r9  | (r10=((r11=( r11  &  r1 )) ^  r6 )));r9=( r9  | (r10=((r11=( r11  &  r6 )) ^  r5 )));
 r9=( r9  | (r10=(( r11  &  r5 ) ^  r0 )));r12= r10 ;r0= r9 ;r2= r0 ;
 r1=(r0= r12 );r0=( r8  |  r1 );delta$0=( r0  | (~ r0  & ( r4  &  r2 )));delta$1= r0 ;
 tmun20$0=( auxL51$0  <<  1 );tmun20$1=( auxL51$1  <<  1 );tmun20$2=( auxL51$2  <<  1 );r0= auxL51$2 ;
 auxL50= r0 ;slop$ne[i-1]=(( tmun23  &  tmun22 ) |  tmun21 );tmun22=( auxL50  <<  1 );tmun23= defVe$ne ;
 defVe$sw= lldefVe$sw[i] ;auxO08= auxL50 ;auxL51$0= grad$0 ;auxL51$1=((r0=~ grad$0 ) ^ ~ grad$1 );
 auxL51$2=(( r0  & ~ grad$1 ) ^ ~ grad$2 );r0= delta$1 ;r5= auxL51$0 ;r1= auxL51$1 ;
 r8=(r2= auxL51$2 );r7= r2 ;r4= r2 ;r3= r2 ;
 r6= r2 ;r2= r5 ;r11= r2 ;r2=~ r1 ;
 r11=( r11  |  r2 );r2=((r10= r1 ) ^  r8 );r11=( r11  |  r2 );r2=((r10=( r10  &  r8 )) ^  r7 );
 r11=( r11  |  r2 );r2=((r10=( r10  &  r7 )) ^  r4 );r11=( r11  |  r2 );r2=((r10=( r10  &  r4 )) ^  r3 );
 r11=( r11  |  r2 );r9=(r2=(( r10  &  r3 ) ^  r6 ));r11=( r11  |  r2 );r1= r11 ;
 r3= r1 ;r2=(r1= r9 );r1=( r0  |  r2 );r0= delta$0 ;
 deltaR$0[i-1]=( r1  | (~ r1  & ( r0  &  r3 )));deltaR$1[i-1]= r1 ;r0= auxL51$2 ;auxL50= r0 ;
 slop$sw[i-1]=(( tmun25  &  auxL50 ) |  tmun24 );tmun25= defVe$sw ;level$ad[i-1]=~( auxO08  |  auxL50 );r2=(r1= grad$0 );
 r2=( r2  | (r1= grad$1 ));r2=( r2  | ~(r1=(r0= grad$2 )));r2=( r2  | ( r1  ^  r0 ));resultCA$ad[i-1]=~ r2 ;
  }
  p.mirror(deltaR);
p.prepareBit(slop);p.prepareBit(deltaR);p.prepareBit(level);p.prepareBit(resultCA)
 ;
  }
public static int ltapex2_4_4_1_1GateCount=27;
 public static void ltapex2_4_4_1_1(PrShift p,int [][] pdeef,int [][] psegmentderiv,int [][] pdifff,int [][] gradltapex2){
 int[] gradltapex2$h1=gradltapex2[0],gradltapex2$h2=gradltapex2[1],gradltapex2$d1=gradltapex2[2],gradltapex2$d2=gradltapex2[3],gradltapex2$ad1=gradltapex2[4],gradltapex2$ad2=gradltapex2[5],pdeef$h1$0=pdeef[0],pdeef$h1$1=pdeef[1],pdeef$h1$2=pdeef[2],pdeef$h1$3=pdeef[3],pdeef$h2$0=pdeef[4],pdeef$h2$1=pdeef[5],pdeef$h2$2=pdeef[6],pdeef$h2$3=pdeef[7],pdeef$d1$0=pdeef[8],pdeef$d1$1=pdeef[9],pdeef$d1$2=pdeef[10],pdeef$d1$3=pdeef[11],pdeef$d2$0=pdeef[12],pdeef$d2$1=pdeef[13],pdeef$d2$2=pdeef[14],pdeef$d2$3=pdeef[15],pdeef$ad1$0=pdeef[16],pdeef$ad1$1=pdeef[17],pdeef$ad1$2=pdeef[18],pdeef$ad1$3=pdeef[19],pdeef$ad2$0=pdeef[20],pdeef$ad2$1=pdeef[21],pdeef$ad2$2=pdeef[22],pdeef$ad2$3=pdeef[23],psegmentderiv$h$0=psegmentderiv[0],psegmentderiv$h$1=psegmentderiv[1],psegmentderiv$h$2=psegmentderiv[2],psegmentderiv$h$3=psegmentderiv[3],psegmentderiv$d$0=psegmentderiv[4],psegmentderiv$d$1=psegmentderiv[5],psegmentderiv$d$2=psegmentderiv[6],psegmentderiv$d$3=psegmentderiv[7],psegmentderiv$ad$0=psegmentderiv[8],psegmentderiv$ad$1=psegmentderiv[9],psegmentderiv$ad$2=psegmentderiv[10],psegmentderiv$ad$3=psegmentderiv[11],pdifff$h=pdifff[0],pdifff$d=pdifff[1],pdifff$ad=pdifff[2];

// initialisation 
 int auxL47=0,r0=0;
for (int i = 1; i < pdeef$h1$0.length -1; i++) {
 r0=( psegmentderiv$h$0[i]  &  pdeef$h1$0[i] );r0=( r0  | ( psegmentderiv$h$1[i]  &  pdeef$h1$1[i] ));r0=( r0  | ( psegmentderiv$h$2[i]  &  pdeef$h1$2[i] ));r0=( r0  | ( psegmentderiv$h$3[i]  &  pdeef$h1$3[i] ));
 auxL47= r0 ;gradltapex2$h1[i]= auxL47 ;gradltapex2$h2[i]=(~ auxL47  &  pdifff$h[i] );r0=( psegmentderiv$d$0[i]  &  pdeef$d1$0[i] );
 r0=( r0  | ( psegmentderiv$d$1[i]  &  pdeef$d1$1[i] ));r0=( r0  | ( psegmentderiv$d$2[i]  &  pdeef$d1$2[i] ));r0=( r0  | ( psegmentderiv$d$3[i]  &  pdeef$d1$3[i] ));auxL47= r0 ;
 gradltapex2$d1[i]= auxL47 ;gradltapex2$d2[i]=(~ auxL47  &  pdifff$d[i] );r0=( psegmentderiv$ad$0[i]  &  pdeef$ad1$0[i] );r0=( r0  | ( psegmentderiv$ad$1[i]  &  pdeef$ad1$1[i] ));
 r0=( r0  | ( psegmentderiv$ad$2[i]  &  pdeef$ad1$2[i] ));r0=( r0  | ( psegmentderiv$ad$3[i]  &  pdeef$ad1$3[i] ));auxL47= r0 ;gradltapex2$ad1[i]= auxL47 ;
 gradltapex2$ad2[i]=(~ auxL47  &  pdifff$ad[i] );
  }
  ;
p.prepareBit(gradltapex2)
 ;
  }
public static int lt_4_4_1GateCount=45;
 public static void lt_4_4_1(PrShift p,int [][] pdis,int [][] psegment,int [][] gradlt){
 int[] gradlt$h1=gradlt[0],gradlt$h2=gradlt[1],gradlt$d1=gradlt[2],gradlt$d2=gradlt[3],gradlt$ad1=gradlt[4],gradlt$ad2=gradlt[5],pdis$0=pdis[0],pdis$1=pdis[1],pdis$2=pdis[2],pdis$3=pdis[3],psegment$h$0=psegment[0],psegment$h$1=psegment[1],psegment$h$2=psegment[2],psegment$h$3=psegment[3],psegment$d$0=psegment[4],psegment$d$1=psegment[5],psegment$d$2=psegment[6],psegment$d$3=psegment[7],psegment$ad$0=psegment[8],psegment$ad$1=psegment[9],psegment$ad$2=psegment[10],psegment$ad$3=psegment[11];

// initialisation 
 int auxL48=0,auxL76$0=0,auxL76$1=0,auxL76$2=0,auxL76$3=0,auxL77$0=0,auxL77$1=0,auxL77$2=0,auxL77$3=0,auxTmp1$0=0,auxTmp1$1=0,auxTmp1$2=0,auxTmp1$3=0,r0=0,segment$0=0,segment$1=0,segment$2=0,segment$3=0,tmun09$0=0,tmun09$1=0,tmun09$2=0,tmun09$3=0,tmun10$0=0,tmun10$1=0,tmun10$2=0,tmun10$3=0,tmun11=0,tmun12$0=0,tmun12$1=0,tmun12$2=0,tmun12$3=0,tmun13=0,tmun14$0=0,tmun14$1=0,tmun14$2=0,tmun14$3=0,tmun15=0;
for (int i = 1; i < pdis$0.length -1; i++) {
 auxL77$0= pdis$0[i] ;auxL77$1= pdis$1[i] ;auxL77$2= pdis$2[i] ;auxL77$3= pdis$3[i] ;
 auxTmp1$0= auxL76$0 ;auxTmp1$1= auxL76$1 ;auxTmp1$2= auxL76$2 ;auxTmp1$3= auxL76$3 ;
 segment$0= psegment$h$0[i] ;segment$1= psegment$h$1[i] ;segment$2= psegment$h$2[i] ;segment$3= psegment$h$3[i] ;
 r0=( tmun10$0  &  auxTmp1$0 );r0=( r0  | ( tmun10$1  &  auxTmp1$1 ));r0=( r0  | ( tmun10$2  &  auxTmp1$2 ));r0=( r0  | ( tmun10$3  &  auxTmp1$3 ));
 auxL48= r0 ;tmun09$0=( auxL77$0  <<  1 );tmun09$1=( auxL77$1  <<  1 );tmun09$2=( auxL77$2  <<  1 );
 tmun09$3=( auxL77$3  <<  1 );tmun10$3= segment$3 ;tmun10$2=(~(r0= segment$3 ) &  segment$2 );tmun10$1=(~(r0= segment$2 ) &  segment$1 );
 tmun10$0=(~ segment$1  &  segment$0 );gradlt$h1[i-1]= auxL48 ;gradlt$h2[i-1]=(~ auxL48  &  tmun11 );r0= segment$0 ;
 tmun11= r0 ;auxTmp1$0= auxL76$0 ;auxTmp1$1= auxL76$1 ;auxTmp1$2= auxL76$2 ;
 auxTmp1$3= auxL76$3 ;segment$0= psegment$d$0[i] ;segment$1= psegment$d$1[i] ;segment$2= psegment$d$2[i] ;
 segment$3= psegment$d$3[i] ;r0=( tmun12$0  &  auxTmp1$0 );r0=( r0  | ( tmun12$1  &  auxTmp1$1 ));r0=( r0  | ( tmun12$2  &  auxTmp1$2 ));
 r0=( r0  | ( tmun12$3  &  auxTmp1$3 ));auxL48= r0 ;tmun12$3= segment$3 ;tmun12$2=(~(r0= segment$3 ) &  segment$2 );
 tmun12$1=(~(r0= segment$2 ) &  segment$1 );tmun12$0=(~ segment$1  &  segment$0 );gradlt$d1[i-1]= auxL48 ;gradlt$d2[i-1]=(~ auxL48  &  tmun13 );
 r0= segment$0 ;tmun13= r0 ;auxTmp1$0= auxL76$0 ;auxTmp1$1= auxL76$1 ;
 auxTmp1$2= auxL76$2 ;auxTmp1$3= auxL76$3 ;auxL76$0= auxL77$0 ;auxL76$1= auxL77$1 ;
 auxL76$2= auxL77$2 ;auxL76$3= auxL77$3 ;segment$0= psegment$ad$0[i] ;segment$1= psegment$ad$1[i] ;
 segment$2= psegment$ad$2[i] ;segment$3= psegment$ad$3[i] ;r0=( tmun14$0  &  auxTmp1$0 );r0=( r0  | ( tmun14$1  &  auxTmp1$1 ));
 r0=( r0  | ( tmun14$2  &  auxTmp1$2 ));r0=( r0  | ( tmun14$3  &  auxTmp1$3 ));auxL48= r0 ;tmun14$3= segment$3 ;
 tmun14$2=(~(r0= segment$3 ) &  segment$2 );tmun14$1=(~(r0= segment$2 ) &  segment$1 );tmun14$0=(~ segment$1  &  segment$0 );gradlt$ad1[i-1]= auxL48 ;
 gradlt$ad2[i-1]=(~ auxL48  &  tmun15 );r0= segment$0 ;tmun15= r0 ;
  }
  ;
p.prepareBit(gradlt)
 ;
  }}