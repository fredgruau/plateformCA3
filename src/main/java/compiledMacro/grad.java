package compiledMacro;
 import simulator.PrShift;
 public class grad{
 
public static int ltapex2_4_4_1_1GateCount=27;
 public static void ltapex2_4_4_1_1(PrShift p,int [][] pdeef,int [][] psegmentderiv,int [][] pdifff,int [][] gradltapex2){
 int[] gradltapex2$h1=gradltapex2[0],gradltapex2$h2=gradltapex2[1],gradltapex2$d1=gradltapex2[2],gradltapex2$d2=gradltapex2[3],gradltapex2$ad1=gradltapex2[4],gradltapex2$ad2=gradltapex2[5],pdeef$h1$0=pdeef[0],pdeef$h1$1=pdeef[1],pdeef$h1$2=pdeef[2],pdeef$h1$3=pdeef[3],pdeef$h2$0=pdeef[4],pdeef$h2$1=pdeef[5],pdeef$h2$2=pdeef[6],pdeef$h2$3=pdeef[7],pdeef$d1$0=pdeef[8],pdeef$d1$1=pdeef[9],pdeef$d1$2=pdeef[10],pdeef$d1$3=pdeef[11],pdeef$d2$0=pdeef[12],pdeef$d2$1=pdeef[13],pdeef$d2$2=pdeef[14],pdeef$d2$3=pdeef[15],pdeef$ad1$0=pdeef[16],pdeef$ad1$1=pdeef[17],pdeef$ad1$2=pdeef[18],pdeef$ad1$3=pdeef[19],pdeef$ad2$0=pdeef[20],pdeef$ad2$1=pdeef[21],pdeef$ad2$2=pdeef[22],pdeef$ad2$3=pdeef[23],psegmentderiv$h$0=psegmentderiv[0],psegmentderiv$h$1=psegmentderiv[1],psegmentderiv$h$2=psegmentderiv[2],psegmentderiv$h$3=psegmentderiv[3],psegmentderiv$d$0=psegmentderiv[4],psegmentderiv$d$1=psegmentderiv[5],psegmentderiv$d$2=psegmentderiv[6],psegmentderiv$d$3=psegmentderiv[7],psegmentderiv$ad$0=psegmentderiv[8],psegmentderiv$ad$1=psegmentderiv[9],psegmentderiv$ad$2=psegmentderiv[10],psegmentderiv$ad$3=psegmentderiv[11],pdifff$h=pdifff[0],pdifff$d=pdifff[1],pdifff$ad=pdifff[2];

// initialisation 
 int auxL60=0,r0=0;
for (int i = 1; i < pdeef$h1$0.length -1; i++) {
 r0=( psegmentderiv$h$0[i]  &  pdeef$h1$0[i] );r0=( r0  | ( psegmentderiv$h$1[i]  &  pdeef$h1$1[i] ));r0=( r0  | ( psegmentderiv$h$2[i]  &  pdeef$h1$2[i] ));r0=( r0  | ( psegmentderiv$h$3[i]  &  pdeef$h1$3[i] ));
 auxL60= r0 ;gradltapex2$h1[i]= auxL60 ;gradltapex2$h2[i]=(~ auxL60  &  pdifff$h[i] );r0=( psegmentderiv$d$0[i]  &  pdeef$d1$0[i] );
 r0=( r0  | ( psegmentderiv$d$1[i]  &  pdeef$d1$1[i] ));r0=( r0  | ( psegmentderiv$d$2[i]  &  pdeef$d1$2[i] ));r0=( r0  | ( psegmentderiv$d$3[i]  &  pdeef$d1$3[i] ));auxL60= r0 ;
 gradltapex2$d1[i]= auxL60 ;gradltapex2$d2[i]=(~ auxL60  &  pdifff$d[i] );r0=( psegmentderiv$ad$0[i]  &  pdeef$ad1$0[i] );r0=( r0  | ( psegmentderiv$ad$1[i]  &  pdeef$ad1$1[i] ));
 r0=( r0  | ( psegmentderiv$ad$2[i]  &  pdeef$ad1$2[i] ));r0=( r0  | ( psegmentderiv$ad$3[i]  &  pdeef$ad1$3[i] ));auxL60= r0 ;gradltapex2$ad1[i]= auxL60 ;
 gradltapex2$ad2[i]=(~ auxL60  &  pdifff$ad[i] );
  }
  ;
p.prepareBit(gradltapex2)
 ;
  }
public static int slopDelta_6_1_2_1_1GateCount=335;
 public static void slopDelta_6_1_2_1_1(PrShift p,int [][] pdis,int [][] slop,int [][] deltaR,int [][] level,int [][] resultCA,int [][] lldefVe){
 int[] lldefVe$e=lldefVe[0],lldefVe$se=lldefVe[1],lldefVe$sw=lldefVe[2],lldefVe$w=lldefVe[3],lldefVe$nw=lldefVe[4],lldefVe$ne=lldefVe[5],slop$e=slop[0],slop$se=slop[1],slop$sw=slop[2],slop$w=slop[3],slop$nw=slop[4],slop$ne=slop[5],deltaR$0=deltaR[0],deltaR$1=deltaR[1],level$h=level[0],level$d=level[1],level$ad=level[2],resultCA$h=resultCA[0],resultCA$d=resultCA[1],resultCA$ad=resultCA[2],pdis$0=pdis[0],pdis$1=pdis[1],pdis$2=pdis[2],pdis$3=pdis[3],pdis$4=pdis[4],pdis$5=pdis[5];

// initialisation 
 int auxL104=0,auxL112$0=0,auxL112$1=0,auxL112$2=0,auxL112$3=0,auxL112$4=0,auxL112$5=0,auxL113$0=0,auxL113$1=0,auxL113$2=0,auxL113$3=0,auxL113$4=0,auxL113$5=0,auxL113$6=0,auxL114$0=0,auxL114$1=0,auxL114$2=0,auxL114$3=0,auxL114$4=0,auxL114$5=0,auxL57=0,auxL58$0=0,auxL58$1=0,auxL58$2=0,auxL58$3=0,auxL58$4=0,auxL58$5=0,auxL59$0=0,auxL59$1=0,auxL59$2=0,auxL59$3=0,auxL59$4=0,auxL59$5=0,auxO13=0,defVe$e=0,defVe$ne=0,defVe$nw=0,defVe$se=0,defVe$sw=0,defVe$w=0,delta$0=0,delta$1=0,dis$0=0,dis$1=0,dis$2=0,dis$3=0,dis$4=0,dis$5=0,grad$0=0,grad$1=0,grad$2=0,grad$3=0,grad$4=0,grad$5=0,r0=0,r1=0,r10=0,r11=0,r12=0,r2=0,r3=0,r4=0,r5=0,r6=0,r7=0,r8=0,r9=0,tmun56$0=0,tmun56$1=0,tmun56$2=0,tmun56$3=0,tmun56$4=0,tmun56$5=0,tmun57=0,tmun58=0,tmun59=0,tmun60=0,tmun61=0,tmun62=0,tmun63$0=0,tmun63$1=0,tmun63$2=0,tmun63$3=0,tmun63$4=0,tmun63$5=0,tmun64=0,tmun65=0,tmun66=0,tmun67$0=0,tmun67$1=0,tmun67$2=0,tmun67$3=0,tmun67$4=0,tmun67$5=0,tmun68=0,tmun69=0,tmun70=0,tmun71=0,tmun72=0;
for (int i = 1; i < pdis$0.length -1; i++) {
 defVe$e= lldefVe$e[i] ;dis$0= pdis$0[i] ;dis$1= pdis$1[i] ;dis$2= pdis$2[i] ;
 dis$3= pdis$3[i] ;dis$4= pdis$4[i] ;dis$5= pdis$5[i] ;auxL59$0= dis$0 ;
 auxL59$1=((r0=~ dis$0 ) ^ ~ dis$1 );auxL59$2=((r0=( r0  & ~ dis$1 )) ^ ~ dis$2 );auxL59$3=((r0=( r0  & ~ dis$2 )) ^ ~ dis$3 );auxL59$4=((r0=( r0  & ~ dis$3 )) ^ ~ dis$4 );
 auxL59$5=(( r0  & ~ dis$4 ) ^ ~ dis$5 );grad$0= tmun56$0 ;grad$1= tmun56$1 ;grad$2= tmun56$2 ;
 grad$3= tmun56$3 ;grad$4= tmun56$4 ;grad$5= tmun56$5 ;tmun56$0=((r0=( auxL59$0  <<  1 )) ^  dis$0 );
 tmun56$1=(((r1=( dis$0  &  r0 )) ^ (r0=( auxL59$1  <<  1 ))) ^  dis$1 );tmun56$2=(((r1=(( r1  &  r0 ) | ( dis$1  & ( r1  |  r0 )))) ^ (r0=( auxL59$2  <<  1 ))) ^  dis$2 );tmun56$3=(((r1=(( r1  &  r0 ) | ( dis$2  & ( r1  |  r0 )))) ^ (r0=( auxL59$3  <<  1 ))) ^  dis$3 );tmun56$4=(((r1=(( r1  &  r0 ) | ( dis$3  & ( r1  |  r0 )))) ^ (r0=( auxL59$4  <<  1 ))) ^  dis$4 );
 tmun56$5=(((( r1  &  r0 ) | ( dis$4  & ( r1  |  r0 ))) ^ ( auxL59$5  <<  1 )) ^  dis$5 );auxL58$0= grad$0 ;auxL58$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL58$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );
 auxL58$3=((r0=( r0  & ~ grad$2 )) ^ ~ grad$3 );auxL58$4=((r0=( r0  & ~ grad$3 )) ^ ~ grad$4 );auxL58$5=(( r0  & ~ grad$4 ) ^ ~ grad$5 );r1= auxL58$0 ;
 r4= auxL58$1 ;r5= auxL58$2 ;r2= auxL58$3 ;r0= auxL58$4 ;
 r6=(r7= auxL58$5 );r3= r7 ;r7= r1 ;r8= r7 ;
 r7=~ r4 ;r8=( r8  |  r7 );r7=((r9= r4 ) ^  r5 );r8=( r8  |  r7 );
 r7=((r9=( r9  &  r5 )) ^  r2 );r8=( r8  |  r7 );r7=((r9=( r9  &  r2 )) ^  r0 );r8=( r8  |  r7 );
 r7=((r9=( r9  &  r0 )) ^  r6 );r8=( r8  |  r7 );r10=(r7=(( r9  &  r6 ) ^  r3 ));r8=( r8  |  r7 );
 delta$0= r8 ;delta$1= r10 ;r0= auxL58$5 ;auxL57= r0 ;
 slop$e[i-1]=(( tmun58  &  auxL57 ) |  tmun57 );tmun58= defVe$e ;defVe$w= lldefVe$w[i] ;auxO13= auxL57 ;
 auxL58$0= grad$0 ;auxL58$1= grad$1 ;auxL58$2= grad$2 ;auxL58$3= grad$3 ;
 auxL58$4= grad$4 ;auxL58$5= grad$5 ;r0= delta$1 ;r1= delta$0 ;
 r8=( auxL58$0  >>>  1 );r6=( auxL58$1  >>>  1 );r3=( auxL58$2  >>>  1 );r7=( auxL58$3  >>>  1 );
 r9=( auxL58$4  >>>  1 );r2=(r4=( auxL58$5  >>>  1 ));r5= r4 ;r10= r8 ;
 r11= r10 ;r10=~ r6 ;r11=( r11  |  r10 );r10=((r12= r6 ) ^  r3 );
 r11=( r11  |  r10 );r10=((r12=( r12  &  r3 )) ^  r7 );r11=( r11  |  r10 );r10=((r12=( r12  &  r7 )) ^  r9 );
 r11=( r11  |  r10 );r10=((r12=( r12  &  r9 )) ^  r2 );r11=( r11  |  r10 );r4=(r10=(( r12  &  r2 ) ^  r5 ));
 r11=( r11  |  r10 );r2= r11 ;r3= r2 ;r5=(r2= r4 );
 r2=( r0  |  r5 );delta$0=( r2  | (~ r2  & ( r1  &  r3 )));delta$1= r2 ;r0= auxL58$5 ;
 auxL57= r0 ;slop$w[i-1]=(( tmun60  & ( auxL57  >>>  1 )) |  tmun59 );tmun60= defVe$w ;defVe$se= lldefVe$se[i] ;
 level$h[i-1]=~( auxO13  |  auxL57 );r1= grad$0 ;r1=( r1  |  grad$1 );r1=( r1  | ~ grad$2 );
 r1=( r1  | ((r0= grad$2 ) ^  grad$3 ));r1=( r1  | ((r0=( r0  &  grad$3 )) ^  grad$4 ));r1=( r1  | (( r0  &  grad$4 ) ^  grad$5 ));resultCA$h[i-1]=~ r1 ;
 grad$0=( auxL112$0  ^  auxL59$0 );grad$1=(((r0=( auxL59$0  &  auxL112$0 )) ^  auxL112$1 ) ^  auxL59$1 );grad$2=(((r0=(( r0  &  auxL112$1 ) | ( auxL59$1  & ( r0  |  auxL112$1 )))) ^  auxL112$2 ) ^  auxL59$2 );grad$3=(((r0=(( r0  &  auxL112$2 ) | ( auxL59$2  & ( r0  |  auxL112$2 )))) ^  auxL112$3 ) ^  auxL59$3 );
 grad$4=(((r0=(( r0  &  auxL112$3 ) | ( auxL59$3  & ( r0  |  auxL112$3 )))) ^  auxL112$4 ) ^  auxL59$4 );grad$5=(((( r0  &  auxL112$4 ) | ( auxL59$4  & ( r0  |  auxL112$4 ))) ^  auxL112$5 ) ^  auxL59$5 );auxL58$0= grad$0 ;auxL58$1=((r0=~ grad$0 ) ^ ~ grad$1 );
 auxL58$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );auxL58$3=((r0=( r0  & ~ grad$2 )) ^ ~ grad$3 );auxL58$4=((r0=( r0  & ~ grad$3 )) ^ ~ grad$4 );auxL58$5=(( r0  & ~ grad$4 ) ^ ~ grad$5 );
 r0= delta$0 ;r6= auxL58$0 ;r2= auxL58$1 ;r1= auxL58$2 ;
 r7= auxL58$3 ;r4= auxL58$4 ;r5=(r3= auxL58$5 );r8= r3 ;
 r9= r6 ;r10= r9 ;r9=~ r2 ;r10=( r10  |  r9 );
 r9=((r3= r2 ) ^  r1 );r10=( r10  |  r9 );r9=((r3=( r3  &  r1 )) ^  r7 );r10=( r10  |  r9 );
 r9=((r3=( r3  &  r7 )) ^  r4 );r10=( r10  |  r9 );r9=((r3=( r3  &  r4 )) ^  r5 );r10=( r10  |  r9 );
 r11=(r9=(( r3  &  r5 ) ^  r8 ));r10=( r10  |  r9 );r1= r10 ;r2= r1 ;
 r3=(r1= r11 );r1= delta$1 ;r4=( r1  |  r3 );delta$0=( r4  | (~ r4  & ( r0  &  r2 )));
 delta$1= r4 ;r0= auxL58$5 ;auxL57= r0 ;slop$se[i-1]=(( tmun62  &  auxL57 ) |  tmun61 );
 tmun62= defVe$se ;defVe$nw= lldefVe$nw[i] ;auxO13= auxL57 ;auxL58$0= grad$0 ;
 auxL58$1= grad$1 ;auxL58$2= grad$2 ;auxL58$3= grad$3 ;auxL58$4= grad$4 ;
 auxL58$5= grad$5 ;r0= delta$0 ;r1= delta$1 ;r9= tmun63$0 ;
 r2= tmun63$1 ;r3= tmun63$2 ;r6= tmun63$3 ;r8= tmun63$4 ;
 r7=(r4= tmun63$5 );r5= r4 ;r11= r9 ;r12= r11 ;
 r11=~ r2 ;r12=( r12  |  r11 );r11=((r10= r2 ) ^  r3 );r12=( r12  |  r11 );
 r11=((r10=( r10  &  r3 )) ^  r6 );r12=( r12  |  r11 );r11=((r10=( r10  &  r6 )) ^  r8 );r12=( r12  |  r11 );
 r11=((r10=( r10  &  r8 )) ^  r7 );r12=( r12  |  r11 );r4=(r11=(( r10  &  r7 ) ^  r5 ));r12=( r12  |  r11 );
 r5= r12 ;r3= r5 ;r2=(r5= r4 );r4=( r1  |  r2 );
 delta$0=( r4  | (~ r4  & ( r0  &  r3 )));delta$1= r4 ;tmun63$0= auxL58$0 ;tmun63$1= auxL58$1 ;
 tmun63$2= auxL58$2 ;tmun63$3= auxL58$3 ;tmun63$4= auxL58$4 ;tmun63$5= auxL58$5 ;
 r0= auxL58$5 ;auxL57= r0 ;slop$nw[i-1]=(( tmun66  &  tmun65 ) |  tmun64 );tmun66= defVe$nw ;
 tmun65= auxL57 ;defVe$ne= lldefVe$ne[i] ;level$d[i-1]=~( auxO13  |  auxL57 );r0= grad$0 ;
 r0=( r0  |  grad$1 );r0=( r0  | ~ grad$2 );r0=( r0  | ((r1= grad$2 ) ^  grad$3 ));r0=( r0  | ((r1=( r1  &  grad$3 )) ^  grad$4 ));
 r0=( r0  | (( r1  &  grad$4 ) ^  grad$5 ));resultCA$d[i-1]=~ r0 ;grad$0=( auxL112$0  ^ (r0=( auxL59$0  >>>  1 )));grad$1=(((r1=( r0  &  auxL112$0 )) ^  auxL112$1 ) ^ (r0=( auxL59$1  >>>  1 )));
 grad$2=(((r1=(( r1  &  auxL112$1 ) | ( r0  & ( r1  |  auxL112$1 )))) ^  auxL112$2 ) ^ (r0=( auxL59$2  >>>  1 )));grad$3=(((r1=(( r1  &  auxL112$2 ) | ( r0  & ( r1  |  auxL112$2 )))) ^  auxL112$3 ) ^ (r0=( auxL59$3  >>>  1 )));grad$4=(((r1=(( r1  &  auxL112$3 ) | ( r0  & ( r1  |  auxL112$3 )))) ^  auxL112$4 ) ^ (r0=( auxL59$4  >>>  1 )));grad$5=(((( r1  &  auxL112$4 ) | ( r0  & ( r1  |  auxL112$4 ))) ^  auxL112$5 ) ^ ( auxL59$5  >>>  1 ));
 auxL112$0= dis$0 ;auxL112$1= dis$1 ;auxL112$2= dis$2 ;auxL112$3= dis$3 ;
 auxL112$4= dis$4 ;auxL112$5= dis$5 ;auxL58$0= grad$0 ;auxL58$1= grad$1 ;
 auxL58$2= grad$2 ;auxL58$3= grad$3 ;auxL58$4= grad$4 ;auxL58$5= grad$5 ;
 r0= delta$0 ;r1= tmun67$0 ;r8= tmun67$1 ;r5= tmun67$2 ;
 r6= tmun67$3 ;r7= tmun67$4 ;r2=(r4= tmun67$5 );r3= r4 ;
 r4=(r11= r1 );r4=( r4  | (r11=~ r8 ));r4=( r4  | (r11=((r10= r8 ) ^  r5 )));r4=( r4  | (r11=((r10=( r10  &  r5 )) ^  r6 )));
 r4=( r4  | (r11=((r10=( r10  &  r6 )) ^  r7 )));r4=( r4  | (r11=((r10=( r10  &  r7 )) ^  r2 )));r4=( r4  | (r11=(( r10  &  r2 ) ^  r3 )));r9= r11 ;
 r3= r4 ;r2= r3 ;r1=(r3= r9 );r3= delta$1 ;
 r4=( r3  |  r1 );delta$0=( r4  | (~ r4  & ( r0  &  r2 )));delta$1= r4 ;tmun67$0=( auxL58$0  <<  1 );
 tmun67$1=( auxL58$1  <<  1 );tmun67$2=( auxL58$2  <<  1 );tmun67$3=( auxL58$3  <<  1 );tmun67$4=( auxL58$4  <<  1 );
 tmun67$5=( auxL58$5  <<  1 );r0= auxL58$5 ;auxL57= r0 ;slop$ne[i-1]=(( tmun70  &  tmun69 ) |  tmun68 );
 tmun70= defVe$ne ;tmun69=( auxL57  <<  1 );defVe$sw= lldefVe$sw[i] ;auxO13= auxL57 ;
 auxL58$0= grad$0 ;auxL58$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL58$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );auxL58$3=((r0=( r0  & ~ grad$2 )) ^ ~ grad$3 );
 auxL58$4=((r0=( r0  & ~ grad$3 )) ^ ~ grad$4 );auxL58$5=(( r0  & ~ grad$4 ) ^ ~ grad$5 );r5= auxL58$0 ;r6= auxL58$1 ;
 r1= auxL58$2 ;r2= auxL58$3 ;r3= auxL58$4 ;r7=(r4= auxL58$5 );
 r0= r4 ;r8= r5 ;r10= r8 ;r8=~ r6 ;
 r10=( r10  |  r8 );r8=((r9= r6 ) ^  r1 );r10=( r10  |  r8 );r8=((r9=( r9  &  r1 )) ^  r2 );
 r10=( r10  |  r8 );r8=((r9=( r9  &  r2 )) ^  r3 );r10=( r10  |  r8 );r8=((r9=( r9  &  r3 )) ^  r7 );
 r10=( r10  |  r8 );r4=(r8=(( r9  &  r7 ) ^  r0 ));r10=( r10  |  r8 );r0= delta$0 ;
 r1= delta$1 ;r2= r10 ;r3= r2 ;r5=(r2= r4 );
 r2=( r1  |  r5 );deltaR$0[i-1]=( r2  | (~ r2  & ( r0  &  r3 )));deltaR$1[i-1]= r2 ;r0= auxL58$5 ;
 auxL57= r0 ;slop$sw[i-1]=(( tmun72  &  auxL57 ) |  tmun71 );tmun72= defVe$sw ;level$ad[i-1]=~( auxO13  |  auxL57 );
 r1= grad$0 ;r1=( r1  |  grad$1 );r1=( r1  | ~ grad$2 );r1=( r1  | ((r0= grad$2 ) ^  grad$3 ));
 r1=( r1  | ((r0=( r0  &  grad$3 )) ^  grad$4 ));r1=( r1  | (( r0  &  grad$4 ) ^  grad$5 ));resultCA$ad[i-1]=~ r1 ;
  }
  p.mirror(deltaR);
p.prepareBit(slop);p.prepareBit(deltaR);p.prepareBit(level);p.prepareBit(resultCA)
 ;
  }
public static int lt_4_4_1GateCount=45;
 public static void lt_4_4_1(PrShift p,int [][] pdis,int [][] psegment,int [][] gradlt){
 int[] gradlt$h1=gradlt[0],gradlt$h2=gradlt[1],gradlt$d1=gradlt[2],gradlt$d2=gradlt[3],gradlt$ad1=gradlt[4],gradlt$ad2=gradlt[5],pdis$0=pdis[0],pdis$1=pdis[1],pdis$2=pdis[2],pdis$3=pdis[3],psegment$h$0=psegment[0],psegment$h$1=psegment[1],psegment$h$2=psegment[2],psegment$h$3=psegment[3],psegment$d$0=psegment[4],psegment$d$1=psegment[5],psegment$d$2=psegment[6],psegment$d$3=psegment[7],psegment$ad$0=psegment[8],psegment$ad$1=psegment[9],psegment$ad$2=psegment[10],psegment$ad$3=psegment[11];

// initialisation 
 int auxL110$0=0,auxL110$1=0,auxL110$2=0,auxL110$3=0,auxL111$0=0,auxL111$1=0,auxL111$2=0,auxL111$3=0,auxL61=0,auxTmp1$0=0,auxTmp1$1=0,auxTmp1$2=0,auxTmp1$3=0,r0=0,segment$0=0,segment$1=0,segment$2=0,segment$3=0,tmun49$0=0,tmun49$1=0,tmun49$2=0,tmun49$3=0,tmun50$0=0,tmun50$1=0,tmun50$2=0,tmun50$3=0,tmun51=0,tmun52$0=0,tmun52$1=0,tmun52$2=0,tmun52$3=0,tmun53=0,tmun54$0=0,tmun54$1=0,tmun54$2=0,tmun54$3=0,tmun55=0;
for (int i = 1; i < pdis$0.length -1; i++) {
 auxL111$0= pdis$0[i] ;auxL111$1= pdis$1[i] ;auxL111$2= pdis$2[i] ;auxL111$3= pdis$3[i] ;
 auxTmp1$0= auxL110$0 ;auxTmp1$1= auxL110$1 ;auxTmp1$2= auxL110$2 ;auxTmp1$3= auxL110$3 ;
 segment$0= psegment$h$0[i] ;segment$1= psegment$h$1[i] ;segment$2= psegment$h$2[i] ;segment$3= psegment$h$3[i] ;
 r0=( tmun50$0  &  auxTmp1$0 );r0=( r0  | ( tmun50$1  &  auxTmp1$1 ));r0=( r0  | ( tmun50$2  &  auxTmp1$2 ));r0=( r0  | ( tmun50$3  &  auxTmp1$3 ));
 auxL61= r0 ;tmun50$3= segment$3 ;tmun50$2=(~(r0= segment$3 ) &  segment$2 );tmun50$1=(~(r0= segment$2 ) &  segment$1 );
 tmun50$0=(~ segment$1  &  segment$0 );tmun49$0=( auxL111$0  <<  1 );tmun49$1=( auxL111$1  <<  1 );tmun49$2=( auxL111$2  <<  1 );
 tmun49$3=( auxL111$3  <<  1 );gradlt$h1[i-1]= auxL61 ;gradlt$h2[i-1]=(~ auxL61  &  tmun51 );r0= segment$0 ;
 tmun51= r0 ;auxTmp1$0= auxL110$0 ;auxTmp1$1= auxL110$1 ;auxTmp1$2= auxL110$2 ;
 auxTmp1$3= auxL110$3 ;segment$0= psegment$d$0[i] ;segment$1= psegment$d$1[i] ;segment$2= psegment$d$2[i] ;
 segment$3= psegment$d$3[i] ;r0=( tmun52$0  &  auxTmp1$0 );r0=( r0  | ( tmun52$1  &  auxTmp1$1 ));r0=( r0  | ( tmun52$2  &  auxTmp1$2 ));
 r0=( r0  | ( tmun52$3  &  auxTmp1$3 ));auxL61= r0 ;tmun52$3= segment$3 ;tmun52$2=(~(r0= segment$3 ) &  segment$2 );
 tmun52$1=(~(r0= segment$2 ) &  segment$1 );tmun52$0=(~ segment$1  &  segment$0 );gradlt$d1[i-1]= auxL61 ;gradlt$d2[i-1]=(~ auxL61  &  tmun53 );
 r0= segment$0 ;tmun53= r0 ;auxTmp1$0= auxL110$0 ;auxTmp1$1= auxL110$1 ;
 auxTmp1$2= auxL110$2 ;auxTmp1$3= auxL110$3 ;auxL110$0= auxL111$0 ;auxL110$1= auxL111$1 ;
 auxL110$2= auxL111$2 ;auxL110$3= auxL111$3 ;segment$0= psegment$ad$0[i] ;segment$1= psegment$ad$1[i] ;
 segment$2= psegment$ad$2[i] ;segment$3= psegment$ad$3[i] ;r0=( tmun54$0  &  auxTmp1$0 );r0=( r0  | ( tmun54$1  &  auxTmp1$1 ));
 r0=( r0  | ( tmun54$2  &  auxTmp1$2 ));r0=( r0  | ( tmun54$3  &  auxTmp1$3 ));auxL61= r0 ;tmun54$3= segment$3 ;
 tmun54$2=(~(r0= segment$3 ) &  segment$2 );tmun54$1=(~(r0= segment$2 ) &  segment$1 );tmun54$0=(~ segment$1  &  segment$0 );gradlt$ad1[i-1]= auxL61 ;
 gradlt$ad2[i-1]=(~ auxL61  &  tmun55 );r0= segment$0 ;tmun55= r0 ;
  }
  ;
p.prepareBit(gradlt)
 ;
  }
public static int slopDelta_3_1_2_1_1GateCount=215;
 public static void slopDelta_3_1_2_1_1(PrShift p,int [][] pdis,int [][] slop,int [][] deltaR,int [][] level,int [][] resultCA,int [][] lldefVe){
 int[] lldefVe$e=lldefVe[0],lldefVe$se=lldefVe[1],lldefVe$sw=lldefVe[2],lldefVe$w=lldefVe[3],lldefVe$nw=lldefVe[4],lldefVe$ne=lldefVe[5],slop$e=slop[0],slop$se=slop[1],slop$sw=slop[2],slop$w=slop[3],slop$nw=slop[4],slop$ne=slop[5],deltaR$0=deltaR[0],deltaR$1=deltaR[1],level$h=level[0],level$d=level[1],level$ad=level[2],resultCA$h=resultCA[0],resultCA$d=resultCA[1],resultCA$ad=resultCA[2],pdis$0=pdis[0],pdis$1=pdis[1],pdis$2=pdis[2];

// initialisation 
 int auxL102$0=0,auxL102$1=0,auxL102$2=0,auxL103$0=0,auxL103$1=0,auxL103$2=0,auxL103$3=0,auxL103$4=0,auxL103$5=0,auxL103$6=0,auxL104=0,auxL105$0=0,auxL105$1=0,auxL105$2=0,auxL105$3=0,auxL57=0,auxL58$0=0,auxL58$1=0,auxL58$2=0,auxL59$0=0,auxL59$1=0,auxL59$2=0,auxO10=0,defVe$e=0,defVe$ne=0,defVe$nw=0,defVe$se=0,defVe$sw=0,defVe$w=0,delta$0=0,delta$1=0,dis$0=0,dis$1=0,dis$2=0,grad$0=0,grad$1=0,grad$2=0,r0=0,r1=0,r10=0,r11=0,r12=0,r2=0,r3=0,r4=0,r5=0,r6=0,r7=0,r8=0,r9=0,tmun15$0=0,tmun15$1=0,tmun15$2=0,tmun16=0,tmun17=0,tmun18=0,tmun19=0,tmun20=0,tmun21=0,tmun22$0=0,tmun22$1=0,tmun22$2=0,tmun23=0,tmun24=0,tmun25=0,tmun26$0=0,tmun26$1=0,tmun26$2=0,tmun27=0,tmun28=0,tmun29=0,tmun30=0,tmun31=0;
for (int i = 1; i < pdis$0.length -1; i++) {
 defVe$e= lldefVe$e[i] ;dis$0= pdis$0[i] ;dis$1= pdis$1[i] ;dis$2= pdis$2[i] ;
 auxL59$0= dis$0 ;auxL59$1=((r0=~ dis$0 ) ^ ~ dis$1 );auxL59$2=(( r0  & ~ dis$1 ) ^ ~ dis$2 );grad$0= tmun15$0 ;
 grad$1= tmun15$1 ;grad$2= tmun15$2 ;tmun15$0=((r1=( auxL59$0  <<  1 )) ^  dis$0 );tmun15$1=(((r0=( dis$0  &  r1 )) ^ (r1=( auxL59$1  <<  1 ))) ^  dis$1 );
 tmun15$2=(((( r0  &  r1 ) | ( dis$1  & ( r0  |  r1 ))) ^ ( auxL59$2  <<  1 )) ^  dis$2 );auxL58$0= grad$0 ;auxL58$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL58$2=(( r0  & ~ grad$1 ) ^ ~ grad$2 );
 r3= auxL58$0 ;r1= auxL58$1 ;r0=(r6= auxL58$2 );r5= r6 ;
 r7= r6 ;r2= r6 ;r4= r6 ;r8=(r9= r3 );
 r8=( r8  | (r9=~ r1 ));r8=( r8  | (r9=((r10= r1 ) ^  r0 )));r8=( r8  | (r9=((r10=( r10  &  r0 )) ^  r5 )));r8=( r8  | (r9=((r10=( r10  &  r5 )) ^  r7 )));
 r8=( r8  | (r9=((r10=( r10  &  r7 )) ^  r2 )));r8=( r8  | (r9=(( r10  &  r2 ) ^  r4 )));r6= r9 ;delta$0= r8 ;
 delta$1= r6 ;r0= auxL58$2 ;auxL57= r0 ;slop$e[i-1]=(( tmun17  &  auxL57 ) |  tmun16 );
 tmun17= defVe$e ;defVe$w= lldefVe$w[i] ;auxO10= auxL57 ;auxL58$0= grad$0 ;
 auxL58$1= grad$1 ;auxL58$2= grad$2 ;r0= delta$0 ;r4=( auxL58$0  >>>  1 );
 r3=( auxL58$1  >>>  1 );r2=(r7=( auxL58$2  >>>  1 ));r8= r7 ;r5= r7 ;
 r1= r7 ;r6= r7 ;r7= delta$1 ;r9= r4 ;
 r11= r9 ;r9=~ r3 ;r11=( r11  |  r9 );r9=((r10= r3 ) ^  r2 );
 r11=( r11  |  r9 );r9=((r10=( r10  &  r2 )) ^  r8 );r11=( r11  |  r9 );r9=((r10=( r10  &  r8 )) ^  r5 );
 r11=( r11  |  r9 );r9=((r10=( r10  &  r5 )) ^  r1 );r11=( r11  |  r9 );r12=(r9=(( r10  &  r1 ) ^  r6 ));
 r11=( r11  |  r9 );r3=(r1= r11 );r1= r12 ;r2= r1 ;
 r1=( r7  |  r2 );delta$0=( r1  | (~ r1  & ( r0  &  r3 )));delta$1= r1 ;r0= auxL58$2 ;
 auxL57= r0 ;slop$w[i-1]=(( tmun19  & ( auxL57  >>>  1 )) |  tmun18 );tmun19= defVe$w ;defVe$se= lldefVe$se[i] ;
 level$h[i-1]=~( auxO10  |  auxL57 );r1=(r2= grad$0 );r1=( r1  | (r2= grad$1 ));r1=( r1  | ~(r2=(r0= grad$2 )));
 r1=( r1  | ( r2  ^  r0 ));resultCA$h[i-1]=~ r1 ;grad$0=( auxL102$0  ^  auxL59$0 );grad$1=(((r0=( auxL59$0  &  auxL102$0 )) ^  auxL102$1 ) ^  auxL59$1 );
 grad$2=(((( r0  &  auxL102$1 ) | ( auxL59$1  & ( r0  |  auxL102$1 ))) ^  auxL102$2 ) ^  auxL59$2 );auxL58$0= grad$0 ;auxL58$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL58$2=(( r0  & ~ grad$1 ) ^ ~ grad$2 );
 r0= delta$0 ;r1= delta$1 ;r6= auxL58$0 ;r4= auxL58$1 ;
 r2=(r3= auxL58$2 );r8= r3 ;r5= r3 ;r7= r3 ;
 r9= r3 ;r3=(r10= r6 );r3=( r3  | (r10=~ r4 ));r3=( r3  | (r10=((r12= r4 ) ^  r2 )));
 r3=( r3  | (r10=((r12=( r12  &  r2 )) ^  r8 )));r3=( r3  | (r10=((r12=( r12  &  r8 )) ^  r5 )));r3=( r3  | (r10=((r12=( r12  &  r5 )) ^  r7 )));r3=( r3  | (r10=(( r12  &  r7 ) ^  r9 )));
 r11= r10 ;r5=(r4= r3 );r4= r11 ;r2= r4 ;
 r3=( r1  |  r2 );delta$0=( r3  | (~ r3  & ( r0  &  r5 )));delta$1= r3 ;r0= auxL58$2 ;
 auxL57= r0 ;slop$se[i-1]=(( tmun21  &  auxL57 ) |  tmun20 );tmun21= defVe$se ;defVe$nw= lldefVe$nw[i] ;
 auxO10= auxL57 ;auxL58$0= grad$0 ;auxL58$1= grad$1 ;auxL58$2= grad$2 ;
 r0= delta$1 ;r1= delta$0 ;r6= tmun22$0 ;r4= tmun22$1 ;
 r8=(r5= tmun22$2 );r3= r5 ;r2= r5 ;r9= r5 ;
 r7= r5 ;r5=(r12= r6 );r5=( r5  | (r12=~ r4 ));r5=( r5  | (r12=((r10= r4 ) ^  r8 )));
 r5=( r5  | (r12=((r10=( r10  &  r8 )) ^  r3 )));r5=( r5  | (r12=((r10=( r10  &  r3 )) ^  r2 )));r5=( r5  | (r12=((r10=( r10  &  r2 )) ^  r9 )));r5=( r5  | (r12=(( r10  &  r9 ) ^  r7 )));
 r11= r12 ;r3= r5 ;r4= r3 ;r2=(r3= r11 );
 r3=( r0  |  r2 );delta$0=( r3  | (~ r3  & ( r1  &  r4 )));delta$1= r3 ;tmun22$0= auxL58$0 ;
 tmun22$1= auxL58$1 ;tmun22$2= auxL58$2 ;r0= auxL58$2 ;auxL57= r0 ;
 slop$nw[i-1]=(( tmun25  &  tmun24 ) |  tmun23 );tmun25= defVe$nw ;tmun24= auxL57 ;defVe$ne= lldefVe$ne[i] ;
 level$d[i-1]=~( auxO10  |  auxL57 );r2=(r1= grad$0 );r2=( r2  | (r1= grad$1 ));r2=( r2  | ~(r1=(r0= grad$2 )));
 r2=( r2  | ( r1  ^  r0 ));resultCA$d[i-1]=~ r2 ;grad$0=( auxL102$0  ^ (r1=( auxL59$0  >>>  1 )));grad$1=(((r0=( r1  &  auxL102$0 )) ^  auxL102$1 ) ^ (r1=( auxL59$1  >>>  1 )));
 grad$2=(((( r0  &  auxL102$1 ) | ( r1  & ( r0  |  auxL102$1 ))) ^  auxL102$2 ) ^ ( auxL59$2  >>>  1 ));auxL102$0= dis$0 ;auxL102$1= dis$1 ;auxL102$2= dis$2 ;
 auxL58$0= grad$0 ;auxL58$1= grad$1 ;auxL58$2= grad$2 ;r3= tmun26$0 ;
 r4= tmun26$1 ;r7=(r0= tmun26$2 );r2= r0 ;r1= r0 ;
 r6= r0 ;r5= r0 ;r0=(r8= r3 );r0=( r0  | (r8=~ r4 ));
 r0=( r0  | (r8=((r9= r4 ) ^  r7 )));r0=( r0  | (r8=((r9=( r9  &  r7 )) ^  r2 )));r0=( r0  | (r8=((r9=( r9  &  r2 )) ^  r1 )));r0=( r0  | (r8=((r9=( r9  &  r1 )) ^  r6 )));
 r0=( r0  | (r8=(( r9  &  r6 ) ^  r5 )));r10= r8 ;r1= delta$1 ;r4= r0 ;
 r3= r4 ;r2=(r4= r10 );r0=( r1  |  r2 );r1= delta$0 ;
 delta$0=( r0  | (~ r0  & ( r1  &  r3 )));delta$1= r0 ;tmun26$0=( auxL58$0  <<  1 );tmun26$1=( auxL58$1  <<  1 );
 tmun26$2=( auxL58$2  <<  1 );r0= auxL58$2 ;auxL57= r0 ;slop$ne[i-1]=(( tmun29  &  tmun28 ) |  tmun27 );
 tmun28=( auxL57  <<  1 );tmun29= defVe$ne ;defVe$sw= lldefVe$sw[i] ;auxO10= auxL57 ;
 auxL58$0= grad$0 ;auxL58$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL58$2=(( r0  & ~ grad$1 ) ^ ~ grad$2 );r0= delta$0 ;
 r1= delta$1 ;r8= auxL58$0 ;r3= auxL58$1 ;r5=(r7= auxL58$2 );
 r6= r7 ;r4= r7 ;r2= r7 ;r9= r7 ;
 r7=(r10= r8 );r7=( r7  | (r10=~ r3 ));r7=( r7  | (r10=((r11= r3 ) ^  r5 )));r7=( r7  | (r10=((r11=( r11  &  r5 )) ^  r6 )));
 r7=( r7  | (r10=((r11=( r11  &  r6 )) ^  r4 )));r7=( r7  | (r10=((r11=( r11  &  r4 )) ^  r2 )));r7=( r7  | (r10=(( r11  &  r2 ) ^  r9 )));r12= r10 ;
 r3=(r4= r7 );r4= r12 ;r2= r4 ;r4=( r1  |  r2 );
 deltaR$0[i-1]=( r4  | (~ r4  & ( r0  &  r3 )));deltaR$1[i-1]= r4 ;r0= auxL58$2 ;auxL57= r0 ;
 slop$sw[i-1]=(( tmun31  &  auxL57 ) |  tmun30 );tmun31= defVe$sw ;level$ad[i-1]=~( auxO10  |  auxL57 );r1=(r2= grad$0 );
 r1=( r1  | (r2= grad$1 ));r1=( r1  | ~(r2=(r0= grad$2 )));r1=( r1  | ( r2  ^  r0 ));resultCA$ad[i-1]=~ r1 ;
  }
  p.mirror(deltaR);
p.prepareBit(slop);p.prepareBit(deltaR);p.prepareBit(level);p.prepareBit(resultCA)
 ;
  }
public static int slopDelta_4_1_2_1_1GateCount=249;
 public static void slopDelta_4_1_2_1_1(PrShift p,int [][] pdis,int [][] slop,int [][] deltaR,int [][] level,int [][] resultCA,int [][] lldefVe){
 int[] lldefVe$e=lldefVe[0],lldefVe$se=lldefVe[1],lldefVe$sw=lldefVe[2],lldefVe$w=lldefVe[3],lldefVe$nw=lldefVe[4],lldefVe$ne=lldefVe[5],slop$e=slop[0],slop$se=slop[1],slop$sw=slop[2],slop$w=slop[3],slop$nw=slop[4],slop$ne=slop[5],deltaR$0=deltaR[0],deltaR$1=deltaR[1],level$h=level[0],level$d=level[1],level$ad=level[2],resultCA$h=resultCA[0],resultCA$d=resultCA[1],resultCA$ad=resultCA[2],pdis$0=pdis[0],pdis$1=pdis[1],pdis$2=pdis[2],pdis$3=pdis[3];

// initialisation 
 int auxL102$0=0,auxL102$1=0,auxL102$2=0,auxL102$3=0,auxL103$0=0,auxL103$1=0,auxL103$2=0,auxL103$3=0,auxL103$4=0,auxL103$5=0,auxL103$6=0,auxL104=0,auxL105$0=0,auxL105$1=0,auxL105$2=0,auxL105$3=0,auxL57=0,auxL58$0=0,auxL58$1=0,auxL58$2=0,auxL58$3=0,auxL59$0=0,auxL59$1=0,auxL59$2=0,auxL59$3=0,auxO18=0,defVe$e=0,defVe$ne=0,defVe$nw=0,defVe$se=0,defVe$sw=0,defVe$w=0,delta$0=0,delta$1=0,dis$0=0,dis$1=0,dis$2=0,dis$3=0,grad$0=0,grad$1=0,grad$2=0,grad$3=0,r0=0,r1=0,r10=0,r11=0,r12=0,r2=0,r3=0,r4=0,r5=0,r6=0,r7=0,r8=0,r9=0,tmun30$0=0,tmun30$1=0,tmun30$2=0,tmun30$3=0,tmun31=0,tmun32=0,tmun33=0,tmun34=0,tmun35=0,tmun36=0,tmun37$0=0,tmun37$1=0,tmun37$2=0,tmun37$3=0,tmun38=0,tmun39=0,tmun40=0,tmun41$0=0,tmun41$1=0,tmun41$2=0,tmun41$3=0,tmun42=0,tmun43=0,tmun44=0,tmun45=0,tmun46=0;
for (int i = 1; i < pdis$0.length -1; i++) {
 defVe$e= lldefVe$e[i] ;dis$0= pdis$0[i] ;dis$1= pdis$1[i] ;dis$2= pdis$2[i] ;
 dis$3= pdis$3[i] ;auxL59$0= dis$0 ;auxL59$1=((r0=~ dis$0 ) ^ ~ dis$1 );auxL59$2=((r0=( r0  & ~ dis$1 )) ^ ~ dis$2 );
 auxL59$3=(( r0  & ~ dis$2 ) ^ ~ dis$3 );grad$0= tmun30$0 ;grad$1= tmun30$1 ;grad$2= tmun30$2 ;
 grad$3= tmun30$3 ;tmun30$0=((r1=( auxL59$0  <<  1 )) ^  dis$0 );tmun30$1=(((r0=( dis$0  &  r1 )) ^ (r1=( auxL59$1  <<  1 ))) ^  dis$1 );tmun30$2=(((r0=(( r0  &  r1 ) | ( dis$1  & ( r0  |  r1 )))) ^ (r1=( auxL59$2  <<  1 ))) ^  dis$2 );
 tmun30$3=(((( r0  &  r1 ) | ( dis$2  & ( r0  |  r1 ))) ^ ( auxL59$3  <<  1 )) ^  dis$3 );auxL58$0= grad$0 ;auxL58$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL58$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );
 auxL58$3=(( r0  & ~ grad$2 ) ^ ~ grad$3 );r6= auxL58$0 ;r0= auxL58$1 ;r2= auxL58$2 ;
 r3=(r5= auxL58$3 );r1= r5 ;r4= r5 ;r7= r5 ;
 r10=(r5= r6 );r10=( r10  | (r5=~ r0 ));r10=( r10  | (r5=((r9= r0 ) ^  r2 )));r10=( r10  | (r5=((r9=( r9  &  r2 )) ^  r3 )));
 r10=( r10  | (r5=((r9=( r9  &  r3 )) ^  r1 )));r10=( r10  | (r5=((r9=( r9  &  r1 )) ^  r4 )));r10=( r10  | (r5=(( r9  &  r4 ) ^  r7 )));r8= r5 ;
 delta$0= r10 ;delta$1= r8 ;r0= auxL58$3 ;auxL57= r0 ;
 slop$e[i-1]=(( tmun32  &  auxL57 ) |  tmun31 );tmun32= defVe$e ;defVe$w= lldefVe$w[i] ;auxO18= auxL57 ;
 auxL58$0= grad$0 ;auxL58$1= grad$1 ;auxL58$2= grad$2 ;auxL58$3= grad$3 ;
 r0= delta$1 ;r1= delta$0 ;r8=( auxL58$0  >>>  1 );r9=( auxL58$1  >>>  1 );
 r4=( auxL58$2  >>>  1 );r6=(r7=( auxL58$3  >>>  1 ));r2= r7 ;r3= r7 ;
 r5= r7 ;r11=(r7= r8 );r11=( r11  | (r7=~ r9 ));r11=( r11  | (r7=((r12= r9 ) ^  r4 )));
 r11=( r11  | (r7=((r12=( r12  &  r4 )) ^  r6 )));r11=( r11  | (r7=((r12=( r12  &  r6 )) ^  r2 )));r11=( r11  | (r7=((r12=( r12  &  r2 )) ^  r3 )));r11=( r11  | (r7=(( r12  &  r3 ) ^  r5 )));
 r10= r7 ;r2=(r4= r11 );r4= r10 ;r3= r4 ;
 r4=( r0  |  r3 );delta$0=( r4  | (~ r4  & ( r1  &  r2 )));delta$1= r4 ;r0= auxL58$3 ;
 auxL57= r0 ;slop$w[i-1]=(( tmun34  & ( auxL57  >>>  1 )) |  tmun33 );tmun34= defVe$w ;defVe$se= lldefVe$se[i] ;
 level$h[i-1]=~( auxO18  |  auxL57 );r0= grad$0 ;r0=( r0  |  grad$1 );r0=( r0  | ~ grad$2 );
 r0=( r0  | ( grad$2  ^  grad$3 ));resultCA$h[i-1]=~ r0 ;grad$0=( auxL102$0  ^  auxL59$0 );grad$1=(((r0=( auxL59$0  &  auxL102$0 )) ^  auxL102$1 ) ^  auxL59$1 );
 grad$2=(((r0=(( r0  &  auxL102$1 ) | ( auxL59$1  & ( r0  |  auxL102$1 )))) ^  auxL102$2 ) ^  auxL59$2 );grad$3=(((( r0  &  auxL102$2 ) | ( auxL59$2  & ( r0  |  auxL102$2 ))) ^  auxL102$3 ) ^  auxL59$3 );auxL58$0= grad$0 ;auxL58$1=((r0=~ grad$0 ) ^ ~ grad$1 );
 auxL58$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );auxL58$3=(( r0  & ~ grad$2 ) ^ ~ grad$3 );r0= delta$0 ;r1= delta$1 ;
 r7= auxL58$0 ;r8= auxL58$1 ;r3= auxL58$2 ;r5=(r4= auxL58$3 );
 r6= r4 ;r9= r4 ;r2= r4 ;r12= r7 ;
 r11= r12 ;r12=~ r8 ;r11=( r11  |  r12 );r12=((r4= r8 ) ^  r3 );
 r11=( r11  |  r12 );r12=((r4=( r4  &  r3 )) ^  r5 );r11=( r11  |  r12 );r12=((r4=( r4  &  r5 )) ^  r6 );
 r11=( r11  |  r12 );r12=((r4=( r4  &  r6 )) ^  r9 );r11=( r11  |  r12 );r10=(r12=(( r4  &  r9 ) ^  r2 ));
 r11=( r11  |  r12 );r3=(r2= r11 );r2= r10 ;r4= r2 ;
 r2=( r1  |  r4 );delta$0=( r2  | (~ r2  & ( r0  &  r3 )));delta$1= r2 ;r0= auxL58$3 ;
 auxL57= r0 ;slop$se[i-1]=(( tmun36  &  auxL57 ) |  tmun35 );tmun36= defVe$se ;defVe$nw= lldefVe$nw[i] ;
 auxO18= auxL57 ;auxL58$0= grad$0 ;auxL58$1= grad$1 ;auxL58$2= grad$2 ;
 auxL58$3= grad$3 ;r0= delta$1 ;r3= tmun37$0 ;r4= tmun37$1 ;
 r6= tmun37$2 ;r8=(r5= tmun37$3 );r1= r5 ;r7= r5 ;
 r2= r5 ;r11=(r10= r3 );r11=( r11  | (r10=~ r4 ));r11=( r11  | (r10=((r5= r4 ) ^  r6 )));
 r11=( r11  | (r10=((r5=( r5  &  r6 )) ^  r8 )));r11=( r11  | (r10=((r5=( r5  &  r8 )) ^  r1 )));r11=( r11  | (r10=((r5=( r5  &  r1 )) ^  r7 )));r11=( r11  | (r10=(( r5  &  r7 ) ^  r2 )));
 r9= r10 ;r2=(r1= r11 );r1= r9 ;r3= r1 ;
 r1=( r0  |  r3 );r0= delta$0 ;delta$0=( r1  | (~ r1  & ( r0  &  r2 )));delta$1= r1 ;
 tmun37$0= auxL58$0 ;tmun37$1= auxL58$1 ;tmun37$2= auxL58$2 ;tmun37$3= auxL58$3 ;
 r0= auxL58$3 ;auxL57= r0 ;slop$nw[i-1]=(( tmun40  &  tmun39 ) |  tmun38 );tmun39= auxL57 ;
 tmun40= defVe$nw ;defVe$ne= lldefVe$ne[i] ;level$d[i-1]=~( auxO18  |  auxL57 );r0= grad$0 ;
 r0=( r0  |  grad$1 );r0=( r0  | ~ grad$2 );r0=( r0  | ( grad$2  ^  grad$3 ));resultCA$d[i-1]=~ r0 ;
 grad$0=( auxL102$0  ^ (r0=( auxL59$0  >>>  1 )));grad$1=(((r1=( r0  &  auxL102$0 )) ^  auxL102$1 ) ^ (r0=( auxL59$1  >>>  1 )));grad$2=(((r1=(( r1  &  auxL102$1 ) | ( r0  & ( r1  |  auxL102$1 )))) ^  auxL102$2 ) ^ (r0=( auxL59$2  >>>  1 )));grad$3=(((( r1  &  auxL102$2 ) | ( r0  & ( r1  |  auxL102$2 ))) ^  auxL102$3 ) ^ ( auxL59$3  >>>  1 ));
 auxL102$0= dis$0 ;auxL102$1= dis$1 ;auxL102$2= dis$2 ;auxL102$3= dis$3 ;
 auxL58$0= grad$0 ;auxL58$1= grad$1 ;auxL58$2= grad$2 ;auxL58$3= grad$3 ;
 r0= delta$1 ;r5= tmun41$0 ;r8= tmun41$1 ;r1= tmun41$2 ;
 r6=(r2= tmun41$3 );r3= r2 ;r4= r2 ;r7= r2 ;
 r2= delta$0 ;r12= r5 ;r9= r12 ;r12=~ r8 ;
 r9=( r9  |  r12 );r12=((r10= r8 ) ^  r1 );r9=( r9  |  r12 );r12=((r10=( r10  &  r1 )) ^  r6 );
 r9=( r9  |  r12 );r12=((r10=( r10  &  r6 )) ^  r3 );r9=( r9  |  r12 );r12=((r10=( r10  &  r3 )) ^  r4 );
 r9=( r9  |  r12 );r11=(r12=(( r10  &  r4 ) ^  r7 ));r9=( r9  |  r12 );r3=(r4= r9 );
 r4= r11 ;r1= r4 ;r4=( r0  |  r1 );delta$0=( r4  | (~ r4  & ( r2  &  r3 )));
 delta$1= r4 ;tmun41$0=( auxL58$0  <<  1 );tmun41$1=( auxL58$1  <<  1 );tmun41$2=( auxL58$2  <<  1 );
 tmun41$3=( auxL58$3  <<  1 );r0= auxL58$3 ;auxL57= r0 ;slop$ne[i-1]=(( tmun44  &  tmun43 ) |  tmun42 );
 tmun43=( auxL57  <<  1 );tmun44= defVe$ne ;defVe$sw= lldefVe$sw[i] ;auxO18= auxL57 ;
 auxL58$0= grad$0 ;auxL58$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL58$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );auxL58$3=(( r0  & ~ grad$2 ) ^ ~ grad$3 );
 r0= delta$0 ;r7= auxL58$0 ;r6= auxL58$1 ;r1= auxL58$2 ;
 r3=(r8= auxL58$3 );r4= r8 ;r5= r8 ;r2= r8 ;
 r9= r7 ;r8= r9 ;r9=~ r6 ;r8=( r8  |  r9 );
 r9=((r10= r6 ) ^  r1 );r8=( r8  |  r9 );r9=((r10=( r10  &  r1 )) ^  r3 );r8=( r8  |  r9 );
 r9=((r10=( r10  &  r3 )) ^  r4 );r8=( r8  |  r9 );r9=((r10=( r10  &  r4 )) ^  r5 );r8=( r8  |  r9 );
 r11=(r9=(( r10  &  r5 ) ^  r2 ));r8=( r8  |  r9 );r2=(r3= r8 );r3= r11 ;
 r1= r3 ;r3= delta$1 ;r4=( r3  |  r1 );deltaR$0[i-1]=( r4  | (~ r4  & ( r0  &  r2 )));
 deltaR$1[i-1]= r4 ;r0= auxL58$3 ;auxL57= r0 ;slop$sw[i-1]=(( tmun46  &  auxL57 ) |  tmun45 );
 tmun46= defVe$sw ;level$ad[i-1]=~( auxO18  |  auxL57 );r0= grad$0 ;r0=( r0  |  grad$1 );
 r0=( r0  | ~ grad$2 );r0=( r0  | ( grad$2  ^  grad$3 ));resultCA$ad[i-1]=~ r0 ;
  }
  p.mirror(deltaR);
p.prepareBit(slop);p.prepareBit(deltaR);p.prepareBit(level);p.prepareBit(resultCA)
 ;
  }}