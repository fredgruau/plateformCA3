package compiledMacro;
 import simulator.PrShift;
 public class grad{
 
public static int lt_3_3_1GateCount=33;
 public static void lt_3_3_1(PrShift p,int [][] pdis,int [][] psegment,int [][] gradlt){
 int[] gradlt$h1=gradlt[0],gradlt$h2=gradlt[1],gradlt$d1=gradlt[2],gradlt$d2=gradlt[3],gradlt$ad1=gradlt[4],gradlt$ad2=gradlt[5],pdis$0=pdis[0],pdis$1=pdis[1],pdis$2=pdis[2],psegment$h$0=psegment[0],psegment$h$1=psegment[1],psegment$h$2=psegment[2],psegment$d$0=psegment[3],psegment$d$1=psegment[4],psegment$d$2=psegment[5],psegment$ad$0=psegment[6],psegment$ad$1=psegment[7],psegment$ad$2=psegment[8];

// initialisation 
 int auxL03=0,auxL17$0=0,auxL17$1=0,auxL17$2=0,auxL18$0=0,auxL18$1=0,auxL18$2=0,auxTmp1$0=0,auxTmp1$1=0,auxTmp1$2=0,r0=0,segment$0=0,segment$1=0,segment$2=0,tmun05$0=0,tmun05$1=0,tmun05$2=0,tmun06$0=0,tmun06$1=0,tmun06$2=0,tmun07=0,tmun08$0=0,tmun08$1=0,tmun08$2=0,tmun09=0,tmun10$0=0,tmun10$1=0,tmun10$2=0,tmun11=0;
for (int i = 1; i < pdis$0.length -1; i++) {
 auxL18$0= pdis$0[i] ;auxL18$1= pdis$1[i] ;auxL18$2= pdis$2[i] ;auxTmp1$0= auxL17$0 ;
 auxTmp1$1= auxL17$1 ;auxTmp1$2= auxL17$2 ;segment$0= psegment$h$0[i] ;segment$1= psegment$h$1[i] ;
 segment$2= psegment$h$2[i] ;r0=( tmun06$0  &  auxTmp1$0 );r0=( r0  | ( tmun06$1  &  auxTmp1$1 ));r0=( r0  | ( tmun06$2  &  auxTmp1$2 ));
 auxL03= r0 ;tmun06$2= segment$2 ;tmun06$1=(~(r0= segment$2 ) &  segment$1 );tmun06$0=(~ segment$1  &  segment$0 );
 tmun05$0=( auxL18$0  <<  1 );tmun05$1=( auxL18$1  <<  1 );tmun05$2=( auxL18$2  <<  1 );gradlt$h1[i-1]= auxL03 ;
 gradlt$h2[i-1]=(~ auxL03  &  tmun07 );r0= segment$0 ;tmun07= r0 ;auxTmp1$0= auxL17$0 ;
 auxTmp1$1= auxL17$1 ;auxTmp1$2= auxL17$2 ;segment$0= psegment$d$0[i] ;segment$1= psegment$d$1[i] ;
 segment$2= psegment$d$2[i] ;r0=( tmun08$0  &  auxTmp1$0 );r0=( r0  | ( tmun08$1  &  auxTmp1$1 ));r0=( r0  | ( tmun08$2  &  auxTmp1$2 ));
 auxL03= r0 ;tmun08$2= segment$2 ;tmun08$1=(~(r0= segment$2 ) &  segment$1 );tmun08$0=(~ segment$1  &  segment$0 );
 gradlt$d1[i-1]= auxL03 ;gradlt$d2[i-1]=(~ auxL03  &  tmun09 );r0= segment$0 ;tmun09= r0 ;
 auxTmp1$0= auxL17$0 ;auxTmp1$1= auxL17$1 ;auxTmp1$2= auxL17$2 ;auxL17$0= auxL18$0 ;
 auxL17$1= auxL18$1 ;auxL17$2= auxL18$2 ;segment$0= psegment$ad$0[i] ;segment$1= psegment$ad$1[i] ;
 segment$2= psegment$ad$2[i] ;r0=( tmun10$0  &  auxTmp1$0 );r0=( r0  | ( tmun10$1  &  auxTmp1$1 ));r0=( r0  | ( tmun10$2  &  auxTmp1$2 ));
 auxL03= r0 ;tmun10$2= segment$2 ;tmun10$1=(~(r0= segment$2 ) &  segment$1 );tmun10$0=(~ segment$1  &  segment$0 );
 gradlt$ad1[i-1]= auxL03 ;gradlt$ad2[i-1]=(~ auxL03  &  tmun11 );r0= segment$0 ;tmun11= r0 ;
  }
  ;
p.prepareBit(gradlt)
 ;
  }
public static int ltapex2_3_3_1_1GateCount=21;
 public static void ltapex2_3_3_1_1(PrShift p,int [][] pdeef,int [][] psegmentderiv,int [][] pdifff,int [][] gradltapex2){
 int[] gradltapex2$h1=gradltapex2[0],gradltapex2$h2=gradltapex2[1],gradltapex2$d1=gradltapex2[2],gradltapex2$d2=gradltapex2[3],gradltapex2$ad1=gradltapex2[4],gradltapex2$ad2=gradltapex2[5],pdeef$h1$0=pdeef[0],pdeef$h1$1=pdeef[1],pdeef$h1$2=pdeef[2],pdeef$h2$0=pdeef[3],pdeef$h2$1=pdeef[4],pdeef$h2$2=pdeef[5],pdeef$d1$0=pdeef[6],pdeef$d1$1=pdeef[7],pdeef$d1$2=pdeef[8],pdeef$d2$0=pdeef[9],pdeef$d2$1=pdeef[10],pdeef$d2$2=pdeef[11],pdeef$ad1$0=pdeef[12],pdeef$ad1$1=pdeef[13],pdeef$ad1$2=pdeef[14],pdeef$ad2$0=pdeef[15],pdeef$ad2$1=pdeef[16],pdeef$ad2$2=pdeef[17],psegmentderiv$h$0=psegmentderiv[0],psegmentderiv$h$1=psegmentderiv[1],psegmentderiv$h$2=psegmentderiv[2],psegmentderiv$d$0=psegmentderiv[3],psegmentderiv$d$1=psegmentderiv[4],psegmentderiv$d$2=psegmentderiv[5],psegmentderiv$ad$0=psegmentderiv[6],psegmentderiv$ad$1=psegmentderiv[7],psegmentderiv$ad$2=psegmentderiv[8],pdifff$h=pdifff[0],pdifff$d=pdifff[1],pdifff$ad=pdifff[2];

// initialisation 
 int auxL02=0,r0=0;
for (int i = 1; i < pdeef$h1$0.length -1; i++) {
 r0=( psegmentderiv$h$0[i]  &  pdeef$h1$0[i] );r0=( r0  | ( psegmentderiv$h$1[i]  &  pdeef$h1$1[i] ));r0=( r0  | ( psegmentderiv$h$2[i]  &  pdeef$h1$2[i] ));auxL02= r0 ;
 gradltapex2$h1[i]= auxL02 ;gradltapex2$h2[i]=(~ auxL02  &  pdifff$h[i] );r0=( psegmentderiv$d$0[i]  &  pdeef$d1$0[i] );r0=( r0  | ( psegmentderiv$d$1[i]  &  pdeef$d1$1[i] ));
 r0=( r0  | ( psegmentderiv$d$2[i]  &  pdeef$d1$2[i] ));auxL02= r0 ;gradltapex2$d1[i]= auxL02 ;gradltapex2$d2[i]=(~ auxL02  &  pdifff$d[i] );
 r0=( psegmentderiv$ad$0[i]  &  pdeef$ad1$0[i] );r0=( r0  | ( psegmentderiv$ad$1[i]  &  pdeef$ad1$1[i] ));r0=( r0  | ( psegmentderiv$ad$2[i]  &  pdeef$ad1$2[i] ));auxL02= r0 ;
 gradltapex2$ad1[i]= auxL02 ;gradltapex2$ad2[i]=(~ auxL02  &  pdifff$ad[i] );
  }
  ;
p.prepareBit(gradltapex2)
 ;
  }
public static int slopDeltaDist_4_1_2_1_1GateCount=237;
 public static void slopDeltaDist_4_1_2_1_1(PrShift p,int [][] pdis,int [][] slop,int [][] deltaR,int [][] level,int [][] resultCA){
int[] slop$e=slop[0],slop$se=slop[1],slop$sw=slop[2],slop$w=slop[3],slop$nw=slop[4],slop$ne=slop[5],deltaR$0=deltaR[0],deltaR$1=deltaR[1],level$h=level[0],level$d=level[1],level$ad=level[2],resultCA$h=resultCA[0],resultCA$d=resultCA[1],resultCA$ad=resultCA[2],pdis$0=pdis[0],pdis$1=pdis[1],pdis$2=pdis[2],pdis$3=pdis[3];;;;
int auxL25=0,auxL26$0=0,auxL26$1=0,auxL26$2=0,auxL26$3=0,auxL27$0=0,auxL27$1=0,auxL27$2=0,auxL27$3=0,auxL63$0=0,auxL63$1=0,auxL63$2=0,auxL63$3=0,auxL64$0=0,auxL64$1=0,auxL64$2=0,auxL64$3=0,auxL64$4=0,auxL64$5=0,auxL64$6=0,auxL65$0=0,auxL65$1=0,auxL65$2=0,auxL65$3=0,auxO13=0,delta$0=0,delta$1=0,dis$0=0,dis$1=0,dis$2=0,dis$3=0,grad$0=0,grad$1=0,grad$2=0,grad$3=0,r0=0,r1=0,r10=0,r11=0,r12=0,r2=0,r3=0,r4=0,r5=0,r6=0,r7=0,r8=0,r9=0,tmun09$0=0,tmun09$1=0,tmun09$2=0,tmun09$3=0,tmun10$0=0,tmun10$1=0,tmun10$2=0,tmun10$3=0,tmun11$0=0,tmun11$1=0,tmun11$2=0,tmun11$3=0;// initialisation
for (int i = 1; i < pdis$0.length -1; i++) {
 dis$0= pdis$0[i] ;dis$1= pdis$1[i] ;dis$2= pdis$2[i] ;dis$3= pdis$3[i] ;
 auxL27$0= dis$0 ;auxL27$1=((r0=~ dis$0 ) ^ ~ dis$1 );auxL27$2=((r0=( r0  & ~ dis$1 )) ^ ~ dis$2 );auxL27$3=(( r0  & ~ dis$2 ) ^ ~ dis$3 );
 grad$0= tmun09$0 ;grad$1= tmun09$1 ;grad$2= tmun09$2 ;grad$3= tmun09$3 ;
 tmun09$0=((r0=( auxL27$0  <<  1 )) ^  dis$0 );tmun09$1=(((r1=( dis$0  &  r0 )) ^ (r0=( auxL27$1  <<  1 ))) ^  dis$1 );tmun09$2=(((r1=(( r1  &  r0 ) | ( dis$1  & ( r1  |  r0 )))) ^ (r0=( auxL27$2  <<  1 ))) ^  dis$2 );tmun09$3=(((( r1  &  r0 ) | ( dis$2  & ( r1  |  r0 ))) ^ ( auxL27$3  <<  1 )) ^  dis$3 );
 auxL26$0= grad$0 ;auxL26$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL26$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );auxL26$3=(( r0  & ~ grad$2 ) ^ ~ grad$3 );
 r1= auxL26$0 ;r5= auxL26$1 ;r4= auxL26$2 ;r3=(r7= auxL26$3 );
 r2= r7 ;r6= r7 ;r0= r7 ;r9=(r10= r1 );
 r9=( r9  | (r10=~ r5 ));r9=( r9  | (r10=((r7= r5 ) ^  r4 )));r9=( r9  | (r10=((r7=( r7  &  r4 )) ^  r3 )));r9=( r9  | (r10=((r7=( r7  &  r3 )) ^  r2 )));
 r9=( r9  | (r10=((r7=( r7  &  r2 )) ^  r6 )));r9=( r9  | (r10=(( r7  &  r6 ) ^  r0 )));r8= r10 ;delta$0= r9 ;
 delta$1= r8 ;r0= auxL26$3 ;auxL25= r0 ;slop$e[i-1]= auxL25 ;
 auxO13= auxL25 ;auxL26$0= grad$0 ;auxL26$1= grad$1 ;auxL26$2= grad$2 ;
 auxL26$3= grad$3 ;r7=( auxL26$0  >>>  1 );r3=( auxL26$1  >>>  1 );r2=( auxL26$2  >>>  1 );
 r0=(r1=( auxL26$3  >>>  1 ));r5= r1 ;r4= r1 ;r6= r1 ;
 r9= r7 ;r1= r9 ;r9=~ r3 ;r1=( r1  |  r9 );
 r9=((r8= r3 ) ^  r2 );r1=( r1  |  r9 );r9=((r8=( r8  &  r2 )) ^  r0 );r1=( r1  |  r9 );
 r9=((r8=( r8  &  r0 )) ^  r5 );r1=( r1  |  r9 );r9=((r8=( r8  &  r5 )) ^  r4 );r1=( r1  |  r9 );
 r10=(r9=(( r8  &  r4 ) ^  r6 ));r1=( r1  |  r9 );r2= r1 ;r0= r2 ;
 r3=(r2= r10 );r1= delta$0 ;r2= delta$1 ;r4=( r2  |  r3 );
 delta$0=( r4  | (~ r4  & ( r1  &  r0 )));delta$1= r4 ;r0= auxL26$3 ;auxL25= r0 ;
 slop$w[i-1]=( auxL25  >>>  1 );level$h[i-1]=~( auxO13  |  auxL25 );r0= grad$0 ;r0=( r0  |  grad$1 );
 r0=( r0  | ~ grad$2 );r0=( r0  | ( grad$2  ^  grad$3 ));resultCA$h[i-1]=~ r0 ;grad$0=( auxL63$0  ^  auxL27$0 );
 grad$1=(((r0=( auxL27$0  &  auxL63$0 )) ^  auxL63$1 ) ^  auxL27$1 );grad$2=(((r0=(( r0  &  auxL63$1 ) | ( auxL27$1  & ( r0  |  auxL63$1 )))) ^  auxL63$2 ) ^  auxL27$2 );grad$3=(((( r0  &  auxL63$2 ) | ( auxL27$2  & ( r0  |  auxL63$2 ))) ^  auxL63$3 ) ^  auxL27$3 );auxL26$0= grad$0 ;
 auxL26$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL26$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );auxL26$3=(( r0  & ~ grad$2 ) ^ ~ grad$3 );r5= auxL26$0 ;
 r1= auxL26$1 ;r0= auxL26$2 ;r7=(r2= auxL26$3 );r4= r2 ;
 r3= r2 ;r6= r2 ;r2=(r8= r5 );r2=( r2  | (r8=~ r1 ));
 r2=( r2  | (r8=((r9= r1 ) ^  r0 )));r2=( r2  | (r8=((r9=( r9  &  r0 )) ^  r7 )));r2=( r2  | (r8=((r9=( r9  &  r7 )) ^  r4 )));r2=( r2  | (r8=((r9=( r9  &  r4 )) ^  r3 )));
 r2=( r2  | (r8=(( r9  &  r3 ) ^  r6 )));r10= r8 ;r0= delta$0 ;r1= delta$1 ;
 r3=(r5= r2 );r5= r10 ;r4= r5 ;r2=( r1  |  r4 );
 delta$0=( r2  | (~ r2  & ( r0  &  r3 )));delta$1= r2 ;r0= auxL26$3 ;auxL25= r0 ;
 slop$se[i-1]= auxL25 ;auxO13= auxL25 ;auxL26$0= grad$0 ;auxL26$1= grad$1 ;
 auxL26$2= grad$2 ;auxL26$3= grad$3 ;r0= delta$1 ;r1= delta$0 ;
 r6= tmun10$0 ;r4= tmun10$1 ;r3= tmun10$2 ;r2=(r8= tmun10$3 );
 r5= r8 ;r9= r8 ;r7= r8 ;r10=(r8= r6 );
 r10=( r10  | (r8=~ r4 ));r10=( r10  | (r8=((r12= r4 ) ^  r3 )));r10=( r10  | (r8=((r12=( r12  &  r3 )) ^  r2 )));r10=( r10  | (r8=((r12=( r12  &  r2 )) ^  r5 )));
 r10=( r10  | (r8=((r12=( r12  &  r5 )) ^  r9 )));r10=( r10  | (r8=(( r12  &  r9 ) ^  r7 )));r11= r8 ;r3=(r4= r10 );
 r4= r11 ;r2= r4 ;r4=( r0  |  r2 );delta$0=( r4  | (~ r4  & ( r1  &  r3 )));
 delta$1= r4 ;tmun10$0= auxL26$0 ;tmun10$1= auxL26$1 ;tmun10$2= auxL26$2 ;
 tmun10$3= auxL26$3 ;r0= auxL26$3 ;auxL25= r0 ;slop$nw[i]= auxL25 ;
 level$d[i-1]=~( auxO13  |  auxL25 );r0= grad$0 ;r0=( r0  |  grad$1 );r0=( r0  | ~ grad$2 );
 r0=( r0  | ( grad$2  ^  grad$3 ));resultCA$d[i-1]=~ r0 ;grad$0=( auxL63$0  ^ (r1=( auxL27$0  >>>  1 )));grad$1=(((r0=( r1  &  auxL63$0 )) ^  auxL63$1 ) ^ (r1=( auxL27$1  >>>  1 )));
 grad$2=(((r0=(( r0  &  auxL63$1 ) | ( r1  & ( r0  |  auxL63$1 )))) ^  auxL63$2 ) ^ (r1=( auxL27$2  >>>  1 )));grad$3=(((( r0  &  auxL63$2 ) | ( r1  & ( r0  |  auxL63$2 ))) ^  auxL63$3 ) ^ ( auxL27$3  >>>  1 ));auxL63$0= dis$0 ;auxL63$1= dis$1 ;
 auxL63$2= dis$2 ;auxL63$3= dis$3 ;auxL26$0= grad$0 ;auxL26$1= grad$1 ;
 auxL26$2= grad$2 ;auxL26$3= grad$3 ;r0= delta$1 ;r2= tmun11$0 ;
 r6= tmun11$1 ;r5= tmun11$2 ;r4=(r8= tmun11$3 );r1= r8 ;
 r7= r8 ;r3= r8 ;r8= delta$0 ;r11= r2 ;
 r12= r11 ;r11=~ r6 ;r12=( r12  |  r11 );r11=((r10= r6 ) ^  r5 );
 r12=( r12  |  r11 );r11=((r10=( r10  &  r5 )) ^  r4 );r12=( r12  |  r11 );r11=((r10=( r10  &  r4 )) ^  r1 );
 r12=( r12  |  r11 );r11=((r10=( r10  &  r1 )) ^  r7 );r12=( r12  |  r11 );r9=(r11=(( r10  &  r7 ) ^  r3 ));
 r12=( r12  |  r11 );r1=(r2= r12 );r2= r9 ;r3= r2 ;
 r2=( r0  |  r3 );delta$0=( r2  | (~ r2  & ( r8  &  r1 )));delta$1= r2 ;tmun11$0=( auxL26$0  <<  1 );
 tmun11$1=( auxL26$1  <<  1 );tmun11$2=( auxL26$2  <<  1 );tmun11$3=( auxL26$3  <<  1 );r0= auxL26$3 ;
 auxL25= r0 ;slop$ne[i]=( auxL25  <<  1 );auxO13= auxL25 ;auxL26$0= grad$0 ;
 auxL26$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL26$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );auxL26$3=(( r0  & ~ grad$2 ) ^ ~ grad$3 );r0= auxL26$0 ;
 r6= auxL26$1 ;r1= auxL26$2 ;r7=(r4= auxL26$3 );r5= r4 ;
 r3= r4 ;r2= r4 ;r9= r0 ;r10= r9 ;
 r9=~ r6 ;r10=( r10  |  r9 );r9=((r8= r6 ) ^  r1 );r10=( r10  |  r9 );
 r9=((r8=( r8  &  r1 )) ^  r7 );r10=( r10  |  r9 );r9=((r8=( r8  &  r7 )) ^  r5 );r10=( r10  |  r9 );
 r9=((r8=( r8  &  r5 )) ^  r3 );r10=( r10  |  r9 );r4=(r9=(( r8  &  r3 ) ^  r2 ));r10=( r10  |  r9 );
 r0= r10 ;r1= r0 ;r2=(r0= r4 );r0= delta$0 ;
 r3= delta$1 ;r4=( r3  |  r2 );deltaR$0[i-1]=( r4  | (~ r4  & ( r0  &  r1 )));deltaR$1[i-1]= r4 ;
 r0= auxL26$3 ;auxL25= r0 ;slop$sw[i-1]= auxL25 ;level$ad[i-1]=~( auxO13  |  auxL25 );
 r0= grad$0 ;r0=( r0  |  grad$1 );r0=( r0  | ~ grad$2 );r0=( r0  | ( grad$2  ^  grad$3 ));
 resultCA$ad[i-1]=~ r0 ;   }
 p.mirror(deltaR);p.prepareBit(slop);p.prepareBit(deltaR);p.prepareBit(level);p.prepareBit(resultCA) ;   }
public static int ltapex2_4_4_1_1GateCount=27;
 public static void ltapex2_4_4_1_1(PrShift p,int [][] pdeef,int [][] psegmentderiv,int [][] pdifff,int [][] gradltapex2){
int[] gradltapex2$h1=gradltapex2[0],gradltapex2$h2=gradltapex2[1],gradltapex2$d1=gradltapex2[2],gradltapex2$d2=gradltapex2[3],gradltapex2$ad1=gradltapex2[4],gradltapex2$ad2=gradltapex2[5],pdeef$h1$0=pdeef[0],pdeef$h1$1=pdeef[1],pdeef$h1$2=pdeef[2],pdeef$h1$3=pdeef[3],pdeef$h2$0=pdeef[4],pdeef$h2$1=pdeef[5],pdeef$h2$2=pdeef[6],pdeef$h2$3=pdeef[7],pdeef$d1$0=pdeef[8],pdeef$d1$1=pdeef[9],pdeef$d1$2=pdeef[10],pdeef$d1$3=pdeef[11],pdeef$d2$0=pdeef[12],pdeef$d2$1=pdeef[13],pdeef$d2$2=pdeef[14],pdeef$d2$3=pdeef[15],pdeef$ad1$0=pdeef[16],pdeef$ad1$1=pdeef[17],pdeef$ad1$2=pdeef[18],pdeef$ad1$3=pdeef[19],pdeef$ad2$0=pdeef[20],pdeef$ad2$1=pdeef[21],pdeef$ad2$2=pdeef[22],pdeef$ad2$3=pdeef[23],psegmentderiv$h$0=psegmentderiv[0],psegmentderiv$h$1=psegmentderiv[1],psegmentderiv$h$2=psegmentderiv[2],psegmentderiv$h$3=psegmentderiv[3],psegmentderiv$d$0=psegmentderiv[4],psegmentderiv$d$1=psegmentderiv[5],psegmentderiv$d$2=psegmentderiv[6],psegmentderiv$d$3=psegmentderiv[7],psegmentderiv$ad$0=psegmentderiv[8],psegmentderiv$ad$1=psegmentderiv[9],psegmentderiv$ad$2=psegmentderiv[10],psegmentderiv$ad$3=psegmentderiv[11],pdifff$h=pdifff[0],pdifff$d=pdifff[1],pdifff$ad=pdifff[2];;;;
int auxL29=0,r0=0;// initialisation
for (int i = 1; i < pdeef$h1$0.length -1; i++) {
 r0=( psegmentderiv$h$0[i]  &  pdeef$h1$0[i] );r0=( r0  | ( psegmentderiv$h$1[i]  &  pdeef$h1$1[i] ));r0=( r0  | ( psegmentderiv$h$2[i]  &  pdeef$h1$2[i] ));r0=( r0  | ( psegmentderiv$h$3[i]  &  pdeef$h1$3[i] ));
 auxL29= r0 ;gradltapex2$h1[i]= auxL29 ;gradltapex2$h2[i]=(~ auxL29  &  pdifff$h[i] );r0=( psegmentderiv$d$0[i]  &  pdeef$d1$0[i] );
 r0=( r0  | ( psegmentderiv$d$1[i]  &  pdeef$d1$1[i] ));r0=( r0  | ( psegmentderiv$d$2[i]  &  pdeef$d1$2[i] ));r0=( r0  | ( psegmentderiv$d$3[i]  &  pdeef$d1$3[i] ));auxL29= r0 ;
 gradltapex2$d1[i]= auxL29 ;gradltapex2$d2[i]=(~ auxL29  &  pdifff$d[i] );r0=( psegmentderiv$ad$0[i]  &  pdeef$ad1$0[i] );r0=( r0  | ( psegmentderiv$ad$1[i]  &  pdeef$ad1$1[i] ));
 r0=( r0  | ( psegmentderiv$ad$2[i]  &  pdeef$ad1$2[i] ));r0=( r0  | ( psegmentderiv$ad$3[i]  &  pdeef$ad1$3[i] ));auxL29= r0 ;gradltapex2$ad1[i]= auxL29 ;
 gradltapex2$ad2[i]=(~ auxL29  &  pdifff$ad[i] );   }
 ;p.prepareBit(gradltapex2) ;   }
public static int lt_4_4_1GateCount=45;
 public static void lt_4_4_1(PrShift p,int [][] pdis,int [][] psegment,int [][] gradlt){
int[] gradlt$h1=gradlt[0],gradlt$h2=gradlt[1],gradlt$d1=gradlt[2],gradlt$d2=gradlt[3],gradlt$ad1=gradlt[4],gradlt$ad2=gradlt[5],pdis$0=pdis[0],pdis$1=pdis[1],pdis$2=pdis[2],pdis$3=pdis[3],psegment$h$0=psegment[0],psegment$h$1=psegment[1],psegment$h$2=psegment[2],psegment$h$3=psegment[3],psegment$d$0=psegment[4],psegment$d$1=psegment[5],psegment$d$2=psegment[6],psegment$d$3=psegment[7],psegment$ad$0=psegment[8],psegment$ad$1=psegment[9],psegment$ad$2=psegment[10],psegment$ad$3=psegment[11];;;;
int auxL28=0,auxL66$0=0,auxL66$1=0,auxL66$2=0,auxL66$3=0,auxL67$0=0,auxL67$1=0,auxL67$2=0,auxL67$3=0,auxTmp1$0=0,auxTmp1$1=0,auxTmp1$2=0,auxTmp1$3=0,r0=0,segment$0=0,segment$1=0,segment$2=0,segment$3=0,tmun12$0=0,tmun12$1=0,tmun12$2=0,tmun12$3=0,tmun13$0=0,tmun13$1=0,tmun13$2=0,tmun13$3=0,tmun14=0,tmun15$0=0,tmun15$1=0,tmun15$2=0,tmun15$3=0,tmun16=0,tmun17$0=0,tmun17$1=0,tmun17$2=0,tmun17$3=0,tmun18=0;// initialisation
for (int i = 1; i < pdis$0.length -1; i++) {
 auxL67$0= pdis$0[i] ;auxL67$1= pdis$1[i] ;auxL67$2= pdis$2[i] ;auxL67$3= pdis$3[i] ;
 auxTmp1$0= auxL66$0 ;auxTmp1$1= auxL66$1 ;auxTmp1$2= auxL66$2 ;auxTmp1$3= auxL66$3 ;
 segment$0= psegment$h$0[i] ;segment$1= psegment$h$1[i] ;segment$2= psegment$h$2[i] ;segment$3= psegment$h$3[i] ;
 r0=( tmun13$0  &  auxTmp1$0 );r0=( r0  | ( tmun13$1  &  auxTmp1$1 ));r0=( r0  | ( tmun13$2  &  auxTmp1$2 ));r0=( r0  | ( tmun13$3  &  auxTmp1$3 ));
 auxL28= r0 ;tmun12$0=( auxL67$0  <<  1 );tmun12$1=( auxL67$1  <<  1 );tmun12$2=( auxL67$2  <<  1 );
 tmun12$3=( auxL67$3  <<  1 );tmun13$3= segment$3 ;tmun13$2=(~(r0= segment$3 ) &  segment$2 );tmun13$1=(~(r0= segment$2 ) &  segment$1 );
 tmun13$0=(~ segment$1  &  segment$0 );gradlt$h1[i-1]= auxL28 ;gradlt$h2[i-1]=(~ auxL28  &  tmun14 );r0= segment$0 ;
 tmun14= r0 ;auxTmp1$0= auxL66$0 ;auxTmp1$1= auxL66$1 ;auxTmp1$2= auxL66$2 ;
 auxTmp1$3= auxL66$3 ;segment$0= psegment$d$0[i] ;segment$1= psegment$d$1[i] ;segment$2= psegment$d$2[i] ;
 segment$3= psegment$d$3[i] ;r0=( tmun15$0  &  auxTmp1$0 );r0=( r0  | ( tmun15$1  &  auxTmp1$1 ));r0=( r0  | ( tmun15$2  &  auxTmp1$2 ));
 r0=( r0  | ( tmun15$3  &  auxTmp1$3 ));auxL28= r0 ;tmun15$3= segment$3 ;tmun15$2=(~(r0= segment$3 ) &  segment$2 );
 tmun15$1=(~(r0= segment$2 ) &  segment$1 );tmun15$0=(~ segment$1  &  segment$0 );gradlt$d1[i-1]= auxL28 ;gradlt$d2[i-1]=(~ auxL28  &  tmun16 );
 r0= segment$0 ;tmun16= r0 ;auxTmp1$0= auxL66$0 ;auxTmp1$1= auxL66$1 ;
 auxTmp1$2= auxL66$2 ;auxTmp1$3= auxL66$3 ;auxL66$0= auxL67$0 ;auxL66$1= auxL67$1 ;
 auxL66$2= auxL67$2 ;auxL66$3= auxL67$3 ;segment$0= psegment$ad$0[i] ;segment$1= psegment$ad$1[i] ;
 segment$2= psegment$ad$2[i] ;segment$3= psegment$ad$3[i] ;r0=( tmun17$0  &  auxTmp1$0 );r0=( r0  | ( tmun17$1  &  auxTmp1$1 ));
 r0=( r0  | ( tmun17$2  &  auxTmp1$2 ));r0=( r0  | ( tmun17$3  &  auxTmp1$3 ));auxL28= r0 ;tmun17$3= segment$3 ;
 tmun17$2=(~(r0= segment$3 ) &  segment$2 );tmun17$1=(~(r0= segment$2 ) &  segment$1 );tmun17$0=(~ segment$1  &  segment$0 );gradlt$ad1[i-1]= auxL28 ;
 gradlt$ad2[i-1]=(~ auxL28  &  tmun18 );r0= segment$0 ;tmun18= r0 ;   }
 ;p.prepareBit(gradlt) ;   }
public static int lt_5_5_1GateCount=57;
 public static void lt_5_5_1(PrShift p,int [][] pdis,int [][] psegment,int [][] gradlt){
int[] gradlt$h1=gradlt[0],gradlt$h2=gradlt[1],gradlt$d1=gradlt[2],gradlt$d2=gradlt[3],gradlt$ad1=gradlt[4],gradlt$ad2=gradlt[5],pdis$0=pdis[0],pdis$1=pdis[1],pdis$2=pdis[2],pdis$3=pdis[3],pdis$4=pdis[4],psegment$h$0=psegment[0],psegment$h$1=psegment[1],psegment$h$2=psegment[2],psegment$h$3=psegment[3],psegment$h$4=psegment[4],psegment$d$0=psegment[5],psegment$d$1=psegment[6],psegment$d$2=psegment[7],psegment$d$3=psegment[8],psegment$d$4=psegment[9],psegment$ad$0=psegment[10],psegment$ad$1=psegment[11],psegment$ad$2=psegment[12],psegment$ad$3=psegment[13],psegment$ad$4=psegment[14];;;;
int auxL24=0,auxL58$0=0,auxL58$1=0,auxL58$2=0,auxL58$3=0,auxL58$4=0,auxL59$0=0,auxL59$1=0,auxL59$2=0,auxL59$3=0,auxL59$4=0,auxTmp1$0=0,auxTmp1$1=0,auxTmp1$2=0,auxTmp1$3=0,auxTmp1$4=0,r0=0,segment$0=0,segment$1=0,segment$2=0,segment$3=0,segment$4=0,tmun09$0=0,tmun09$1=0,tmun09$2=0,tmun09$3=0,tmun09$4=0,tmun10$0=0,tmun10$1=0,tmun10$2=0,tmun10$3=0,tmun10$4=0,tmun11=0,tmun12$0=0,tmun12$1=0,tmun12$2=0,tmun12$3=0,tmun12$4=0,tmun13=0,tmun14$0=0,tmun14$1=0,tmun14$2=0,tmun14$3=0,tmun14$4=0,tmun15=0;// initialisation
for (int i = 1; i < pdis$0.length -1; i++) {
 auxL59$0= pdis$0[i] ;auxL59$1= pdis$1[i] ;auxL59$2= pdis$2[i] ;auxL59$3= pdis$3[i] ;
 auxL59$4= pdis$4[i] ;auxTmp1$0= auxL58$0 ;auxTmp1$1= auxL58$1 ;auxTmp1$2= auxL58$2 ;
 auxTmp1$3= auxL58$3 ;auxTmp1$4= auxL58$4 ;segment$0= psegment$h$0[i] ;segment$1= psegment$h$1[i] ;
 segment$2= psegment$h$2[i] ;segment$3= psegment$h$3[i] ;segment$4= psegment$h$4[i] ;r0=( tmun10$0  &  auxTmp1$0 );
 r0=( r0  | ( tmun10$1  &  auxTmp1$1 ));r0=( r0  | ( tmun10$2  &  auxTmp1$2 ));r0=( r0  | ( tmun10$3  &  auxTmp1$3 ));r0=( r0  | ( tmun10$4  &  auxTmp1$4 ));
 auxL24= r0 ;tmun09$0=( auxL59$0  <<  1 );tmun09$1=( auxL59$1  <<  1 );tmun09$2=( auxL59$2  <<  1 );
 tmun09$3=( auxL59$3  <<  1 );tmun09$4=( auxL59$4  <<  1 );tmun10$4= segment$4 ;tmun10$3=(~(r0= segment$4 ) &  segment$3 );
 tmun10$2=(~(r0= segment$3 ) &  segment$2 );tmun10$1=(~(r0= segment$2 ) &  segment$1 );tmun10$0=(~ segment$1  &  segment$0 );gradlt$h1[i-1]= auxL24 ;
 gradlt$h2[i-1]=(~ auxL24  &  tmun11 );r0= segment$0 ;tmun11= r0 ;auxTmp1$0= auxL58$0 ;
 auxTmp1$1= auxL58$1 ;auxTmp1$2= auxL58$2 ;auxTmp1$3= auxL58$3 ;auxTmp1$4= auxL58$4 ;
 segment$0= psegment$d$0[i] ;segment$1= psegment$d$1[i] ;segment$2= psegment$d$2[i] ;segment$3= psegment$d$3[i] ;
 segment$4= psegment$d$4[i] ;r0=( tmun12$0  &  auxTmp1$0 );r0=( r0  | ( tmun12$1  &  auxTmp1$1 ));r0=( r0  | ( tmun12$2  &  auxTmp1$2 ));
 r0=( r0  | ( tmun12$3  &  auxTmp1$3 ));r0=( r0  | ( tmun12$4  &  auxTmp1$4 ));auxL24= r0 ;tmun12$4= segment$4 ;
 tmun12$3=(~(r0= segment$4 ) &  segment$3 );tmun12$2=(~(r0= segment$3 ) &  segment$2 );tmun12$1=(~(r0= segment$2 ) &  segment$1 );tmun12$0=(~ segment$1  &  segment$0 );
 gradlt$d1[i-1]= auxL24 ;gradlt$d2[i-1]=(~ auxL24  &  tmun13 );r0= segment$0 ;tmun13= r0 ;
 auxTmp1$0= auxL58$0 ;auxTmp1$1= auxL58$1 ;auxTmp1$2= auxL58$2 ;auxTmp1$3= auxL58$3 ;
 auxTmp1$4= auxL58$4 ;auxL58$0= auxL59$0 ;auxL58$1= auxL59$1 ;auxL58$2= auxL59$2 ;
 auxL58$3= auxL59$3 ;auxL58$4= auxL59$4 ;segment$0= psegment$ad$0[i] ;segment$1= psegment$ad$1[i] ;
 segment$2= psegment$ad$2[i] ;segment$3= psegment$ad$3[i] ;segment$4= psegment$ad$4[i] ;r0=( tmun14$0  &  auxTmp1$0 );
 r0=( r0  | ( tmun14$1  &  auxTmp1$1 ));r0=( r0  | ( tmun14$2  &  auxTmp1$2 ));r0=( r0  | ( tmun14$3  &  auxTmp1$3 ));r0=( r0  | ( tmun14$4  &  auxTmp1$4 ));
 auxL24= r0 ;tmun14$4= segment$4 ;tmun14$3=(~(r0= segment$4 ) &  segment$3 );tmun14$2=(~(r0= segment$3 ) &  segment$2 );
 tmun14$1=(~(r0= segment$2 ) &  segment$1 );tmun14$0=(~ segment$1  &  segment$0 );gradlt$ad1[i-1]= auxL24 ;gradlt$ad2[i-1]=(~ auxL24  &  tmun15 );
 r0= segment$0 ;tmun15= r0 ;   }
 ;p.prepareBit(gradlt) ;   }
public static int slopDeltaRadius_4_1_1_2_2_1GateCount=403;
 public static void slopDeltaRadius_4_1_1_2_2_1(PrShift p,int [][] pdis,int [][] psrcPropag,int [][] slop,int [][] delta,int [][] sgnMaxLt,int [][] gap){
int[] slop$e=slop[0],slop$se=slop[1],slop$sw=slop[2],slop$w=slop[3],slop$nw=slop[4],slop$ne=slop[5],delta$0=delta[0],delta$1=delta[1],sgnMaxLt$e$0=sgnMaxLt[0],sgnMaxLt$e$1=sgnMaxLt[1],sgnMaxLt$se$0=sgnMaxLt[2],sgnMaxLt$se$1=sgnMaxLt[3],sgnMaxLt$sw$0=sgnMaxLt[4],sgnMaxLt$sw$1=sgnMaxLt[5],sgnMaxLt$w$0=sgnMaxLt[6],sgnMaxLt$w$1=sgnMaxLt[7],sgnMaxLt$nw$0=sgnMaxLt[8],sgnMaxLt$nw$1=sgnMaxLt[9],sgnMaxLt$ne$0=sgnMaxLt[10],sgnMaxLt$ne$1=sgnMaxLt[11],gap$h=gap[0],gap$d=gap[1],gap$ad=gap[2],pdis$0=pdis[0],pdis$1=pdis[1],pdis$2=pdis[2],pdis$3=pdis[3],psrcPropag$e=psrcPropag[0],psrcPropag$se=psrcPropag[1],psrcPropag$sw=psrcPropag[2],psrcPropag$w=psrcPropag[3],psrcPropag$nw=psrcPropag[4],psrcPropag$ne=psrcPropag[5];;;;
int auxL35$0=0,auxL35$1=0,auxL35$2=0,auxL35$3=0,auxL36$0=0,auxL36$1=0,auxL36$2=0,auxL36$3=0,auxL66=0,auxL67=0,auxL68=0,auxL69=0,auxL70$0=0,auxL70$1=0,auxL70$2=0,auxL70$3=0,auxL71=0,auxL72=0,auxL73=0,auxL74=0,auxL75$0=0,auxL75$1=0,auxL75$2=0,auxL75$3=0,auxL76$0=0,auxL76$1=0,auxL76$2=0,auxL76$3=0,auxL77=0,auxL78=0,auxL79$0=0,auxL79$1=0,auxL80$0=0,auxL80$1=0,auxL81=0,auxL82=0,auxL83$0=0,auxL83$1=0,auxL83$2=0,auxL83$3=0,auxL84$0=0,auxL84$1=0,auxL84$2=0,auxL84$3=0,auxL85$0=0,auxL85$1=0,auxL85$2=0,auxL85$3=0,dis$0=0,dis$1=0,dis$2=0,dis$3=0,grad$0=0,grad$1=0,grad$2=0,grad$3=0,maxSignGradm2$0=0,maxSignGradm2$1=0,minsignLt$0=0,minsignLt$1=0,r0=0,r1=0,r10=0,r11=0,r12=0,r13=0,r14=0,r15=0,r16=0,r17=0,r18=0,r19=0,r2=0,r20=0,r21=0,r3=0,r4=0,r5=0,r6=0,r7=0,r8=0,r9=0,sgnMinLt$0=0,sgnMinLt$1=0,signGrad6$0=0,signGrad6$1=0,srcPropag=0,tmun08$0=0,tmun08$1=0,tmun08$2=0,tmun08$3=0,tmun09$0=0,tmun09$1=0,tmun10$0=0,tmun10$1=0,tmun11$0=0,tmun11$1=0,tmun12$0=0,tmun12$1=0,tmun13$0=0,tmun13$1=0,tmun14$0=0,tmun14$1=0,tmun15$0=0,tmun15$1=0,tmun15$2=0,tmun15$3=0,tmun16$0=0,tmun16$1=0,tmun17$0=0,tmun17$1=0,tmun18$0=0,tmun18$1=0,tmun19$0=0,tmun19$1=0,tmun20$0=0,tmun20$1=0,tmun20$2=0,tmun20$3=0,tmun21$0=0,tmun21$1=0,tmun22$0=0,tmun22$1=0;// initialisation
for (int i = 1; i < pdis$0.length -1; i++) {
 srcPropag= psrcPropag$e[i] ;dis$0= pdis$0[i] ;dis$1= pdis$1[i] ;dis$2= pdis$2[i] ;
 dis$3= pdis$3[i] ;auxL36$0= dis$0 ;auxL36$1=((r0=~ dis$0 ) ^ ~ dis$1 );auxL36$2=((r0=( r0  & ~ dis$1 )) ^ ~ dis$2 );
 auxL36$3=(( r0  & ~ dis$2 ) ^ ~ dis$3 );grad$0= tmun08$0 ;grad$1= tmun08$1 ;grad$2= tmun08$2 ;
 grad$3= tmun08$3 ;tmun08$0=((r0=( auxL36$0  <<  1 )) ^  dis$0 );tmun08$1=(((r1=( dis$0  &  r0 )) ^ (r0=( auxL36$1  <<  1 ))) ^  dis$1 );tmun08$2=(((r1=(( r1  &  r0 ) | ( dis$1  & ( r1  |  r0 )))) ^ (r0=( auxL36$2  <<  1 ))) ^  dis$2 );
 tmun08$3=(((( r1  &  r0 ) | ( dis$2  & ( r1  |  r0 ))) ^ ( auxL36$3  <<  1 )) ^  dis$3 );auxL35$0= grad$0 ;auxL35$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL35$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );
 auxL35$3=(( r0  & ~ grad$2 ) ^ ~ grad$3 );r0= auxL35$3 ;slop$e[i-1]= r0 ;r0= auxL35$3 ;
 r1= auxL35$0 ;r1=( r1  |  auxL35$1 );r1=( r1  |  auxL35$2 );r1=( r1  |  auxL35$3 );
 signGrad6$0= r1 ;signGrad6$1= r0 ;auxL66=~ srcPropag ;sgnMinLt$0=(( auxL67  & ( signGrad6$0  &  signGrad6$0 )) |  tmun09$0 );
 sgnMinLt$1=(( auxL67  & ( signGrad6$1  &  signGrad6$1 )) |  tmun09$1 );tmun09$0= auxL66 ;minsignLt$0=( sgnMinLt$0  &  sgnMinLt$0 );minsignLt$1=( sgnMinLt$1  &  sgnMinLt$1 );
 sgnMaxLt$e$0[i-1]=(( auxL67  &  signGrad6$0 ) |  tmun10$0 );sgnMaxLt$e$1[i-1]=(( auxL67  &  signGrad6$1 ) |  tmun10$1 );tmun10$0= auxL66 ;tmun10$1= auxL66 ;
 auxL67= srcPropag ;srcPropag= psrcPropag$w[i] ;r1= auxL35$0 ;r2= auxL35$1 ;
 r4= auxL35$2 ;r3=(r0= auxL35$3 );r6= r1 ;r0= r6 ;
 r6=~ r2 ;r0=( r0  |  r6 );r6=~((r7= r2 ) ^  r4 );r0=( r0  |  r6 );
 r5=(r6=~(( r7  |  r4 ) ^  r3 ));r0=( r0  |  r6 );maxSignGradm2$0= r0 ;maxSignGradm2$1= r5 ;
 auxL35$0= grad$0 ;auxL35$1= grad$1 ;auxL35$2= grad$2 ;auxL35$3= grad$3 ;
 r0= auxL35$3 ;slop$w[i-1]=( r0  >>>  1 );auxL70$0=( auxL35$0  >>>  1 );auxL70$1=( auxL35$1  >>>  1 );
 auxL70$2=( auxL35$2  >>>  1 );auxL70$3=( auxL35$3  >>>  1 );r0= auxL70$3 ;r1= auxL70$0 ;
 r1=( r1  |  auxL70$1 );r1=( r1  |  auxL70$2 );r1=( r1  |  auxL70$3 );signGrad6$0= r1 ;
 signGrad6$1= r0 ;auxL68=~ srcPropag ;sgnMinLt$0=(( auxL69  & ( signGrad6$0  &  signGrad6$0 )) |  tmun11$0 );sgnMinLt$1=(( auxL69  & ( signGrad6$1  &  signGrad6$1 )) |  tmun11$1 );
 tmun11$0= auxL68 ;r0= minsignLt$1 ;r1=(r2=( sgnMinLt$0  &  sgnMinLt$0 ));r2=( sgnMinLt$1  &  sgnMinLt$1 );
 r3= r2 ;r2= minsignLt$0 ;r4=( r0  |  r3 );minsignLt$0=( r4  | (~ r4  & ( r2  &  r1 )));
 minsignLt$1= r4 ;sgnMaxLt$w$0[i-1]=(( auxL69  &  signGrad6$0 ) |  tmun12$0 );sgnMaxLt$w$1[i-1]=(( auxL69  &  signGrad6$1 ) |  tmun12$1 );tmun12$0= auxL68 ;
 tmun12$1= auxL68 ;auxL69= srcPropag ;srcPropag= psrcPropag$se[i] ;r0= grad$0 ;
 r0=( r0  |  grad$1 );r0=( r0  | ~ grad$2 );r0=( r0  | ( grad$2  ^  grad$3 ));gap$h[i-1]=~ r0 ;
 grad$0=( auxL76$0  ^  auxL36$0 );grad$1=(((r0=( auxL36$0  &  auxL76$0 )) ^  auxL76$1 ) ^  auxL36$1 );grad$2=(((r0=(( r0  &  auxL76$1 ) | ( auxL36$1  & ( r0  |  auxL76$1 )))) ^  auxL76$2 ) ^  auxL36$2 );grad$3=(((( r0  &  auxL76$2 ) | ( auxL36$2  & ( r0  |  auxL76$2 ))) ^  auxL76$3 ) ^  auxL36$3 );
 auxL35$0= grad$0 ;auxL35$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL35$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );auxL35$3=(( r0  & ~ grad$2 ) ^ ~ grad$3 );
 r0= auxL35$3 ;slop$se[i-1]= r0 ;r0= auxL35$0 ;r0=( r0  |  auxL35$1 );
 r0=( r0  |  auxL35$2 );r0=( r0  |  auxL35$3 );r1= auxL35$3 ;signGrad6$0= r0 ;
 signGrad6$1= r1 ;auxL71=~ srcPropag ;sgnMinLt$0=(( auxL72  & ( signGrad6$0  &  signGrad6$0 )) |  tmun13$0 );sgnMinLt$1=(( auxL72  & ( signGrad6$1  &  signGrad6$1 )) |  tmun13$1 );
 tmun13$0= auxL71 ;r0= minsignLt$1 ;r3=( sgnMinLt$0  &  sgnMinLt$0 );r2= r3 ;
 r1=(r3=( sgnMinLt$1  &  sgnMinLt$1 ));r3=( r0  |  r1 );r0= minsignLt$0 ;minsignLt$0=( r3  | (~ r3  & ( r0  &  r2 )));
 minsignLt$1= r3 ;sgnMaxLt$se$0[i-1]=(( auxL72  &  signGrad6$0 ) |  tmun14$0 );sgnMaxLt$se$1[i-1]=(( auxL72  &  signGrad6$1 ) |  tmun14$1 );tmun14$0= auxL71 ;
 tmun14$1= auxL71 ;auxL72= srcPropag ;srcPropag= psrcPropag$nw[i] ;r0= maxSignGradm2$0 ;
 r5= auxL35$0 ;r1= auxL35$1 ;r2= auxL35$2 ;r3=(r4= auxL35$3 );
 r7=(r8= r5 );r7=( r7  | (r8=~ r1 ));r7=( r7  | (r8=~((r6= r1 ) ^  r2 )));r7=( r7  | (r8=~(( r6  |  r2 ) ^  r3 )));
 r4= r8 ;r1= r7 ;r3= r1 ;r2=(r1= r4 );
 r4= auxL70$0 ;r6= auxL70$1 ;r5= auxL70$2 ;r1=(r7= auxL70$3 );
 r9= r4 ;r8= r9 ;r9=~ r6 ;r8=( r8  |  r9 );
 r9=~((r10= r6 ) ^  r5 );r8=( r8  |  r9 );r7=(r9=~(( r10  |  r5 ) ^  r1 ));r8=( r8  |  r9 );
 r4=(r1= r8 );r1= r7 ;r5= r1 ;r1= maxSignGradm2$1 ;
 r6=( r1  &  r5 );r7=(r9=( r6  | (~ r6  & ((~ r1  &  r0 ) | (~ r5  &  r4 )))));r9= r6 ;r8= r9 ;
 r0=( r8  &  r2 );maxSignGradm2$0=( r0  | (~ r0  & ((~ r8  &  r7 ) | (~ r2  &  r3 ))));maxSignGradm2$1= r0 ;auxL35$0= grad$0 ;
 auxL35$1= grad$1 ;auxL35$2= grad$2 ;auxL35$3= grad$3 ;r0= auxL35$3 ;
 slop$nw[i]= r0 ;auxL75$0= tmun15$0 ;auxL75$1= tmun15$1 ;auxL75$2= tmun15$2 ;
 auxL75$3= tmun15$3 ;tmun15$0= auxL35$0 ;tmun15$1= auxL35$1 ;tmun15$2= auxL35$2 ;
 tmun15$3= auxL35$3 ;r0= auxL75$0 ;r0=( r0  |  auxL75$1 );r0=( r0  |  auxL75$2 );
 r0=( r0  |  auxL75$3 );r1= auxL75$3 ;signGrad6$0= r0 ;signGrad6$1= r1 ;
 auxL73=~ srcPropag ;sgnMinLt$0=(( auxL74  & ( signGrad6$0  &  signGrad6$0 )) |  tmun16$0 );sgnMinLt$1=(( auxL74  & ( signGrad6$1  &  signGrad6$1 )) |  tmun16$1 );tmun16$0= auxL73 ;
 r1=( sgnMinLt$0  &  sgnMinLt$0 );r2= r1 ;r0=(r1=( sgnMinLt$1  &  sgnMinLt$1 ));r1= minsignLt$0 ;
 r3= minsignLt$1 ;r4=( r3  |  r0 );minsignLt$0=( r4  | (~ r4  & ( r1  &  r2 )));minsignLt$1= r4 ;
 sgnMaxLt$nw$0[i-1]=(( auxL74  &  signGrad6$0 ) |  tmun17$0 );sgnMaxLt$nw$1[i-1]=(( auxL74  &  signGrad6$1 ) |  tmun17$1 );tmun17$0= auxL73 ;tmun17$1= auxL73 ;
 auxL74= srcPropag ;srcPropag= psrcPropag$sw[i] ;r0= grad$0 ;r0=( r0  |  grad$1 );
 r0=( r0  | ~ grad$2 );r0=( r0  | ( grad$2  ^  grad$3 ));gap$d[i-1]=~ r0 ;grad$0=( auxL76$0  ^ (r0=( auxL36$0  >>>  1 )));
 grad$1=(((r1=( r0  &  auxL76$0 )) ^  auxL76$1 ) ^ (r0=( auxL36$1  >>>  1 )));grad$2=(((r1=(( r1  &  auxL76$1 ) | ( r0  & ( r1  |  auxL76$1 )))) ^  auxL76$2 ) ^ (r0=( auxL36$2  >>>  1 )));grad$3=(((( r1  &  auxL76$2 ) | ( r0  & ( r1  |  auxL76$2 ))) ^  auxL76$3 ) ^ ( auxL36$3  >>>  1 ));auxL76$0= dis$0 ;
 auxL76$1= dis$1 ;auxL76$2= dis$2 ;auxL76$3= dis$3 ;auxL35$0= grad$0 ;
 auxL35$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL35$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );auxL35$3=(( r0  & ~ grad$2 ) ^ ~ grad$3 );r0= auxL35$3 ;
 slop$sw[i-1]= r0 ;r0= auxL35$3 ;r1= auxL35$0 ;r1=( r1  |  auxL35$1 );
 r1=( r1  |  auxL35$2 );r1=( r1  |  auxL35$3 );signGrad6$0= r1 ;signGrad6$1= r0 ;
 auxL77=~ srcPropag ;sgnMinLt$0=(( auxL78  & ( signGrad6$0  &  signGrad6$0 )) |  tmun18$0 );sgnMinLt$1=(( auxL78  & ( signGrad6$1  &  signGrad6$1 )) |  tmun18$1 );tmun18$0= auxL77 ;
 r0= minsignLt$0 ;r2=( sgnMinLt$0  &  sgnMinLt$0 );r3= r2 ;r1=(r2=( sgnMinLt$1  &  sgnMinLt$1 ));
 r2= minsignLt$1 ;r4=( r2  |  r1 );minsignLt$0=( r4  | (~ r4  & ( r0  &  r3 )));minsignLt$1= r4 ;
 sgnMaxLt$sw$0[i-1]=(( auxL78  &  signGrad6$0 ) |  tmun19$0 );sgnMaxLt$sw$1[i-1]=(( auxL78  &  signGrad6$1 ) |  tmun19$1 );tmun19$0= auxL77 ;tmun19$1= auxL77 ;
 auxL78= srcPropag ;srcPropag= psrcPropag$ne[i] ;r0= maxSignGradm2$0 ;r1= auxL75$0 ;
 r5= auxL75$1 ;r4= auxL75$2 ;r2=(r3= auxL75$3 );r8= r1 ;
 r7= r8 ;r8=~ r5 ;r7=( r7  |  r8 );r8=~((r6= r5 ) ^  r4 );
 r7=( r7  |  r8 );r3=(r8=~(( r6  |  r4 ) ^  r2 ));r7=( r7  |  r8 );r4= auxL35$0 ;
 r2= auxL35$1 ;r1= auxL35$2 ;r5=(r6= auxL35$3 );r8=(r9= r4 );
 r8=( r8  | (r9=~ r2 ));r8=( r8  | (r9=~((r10= r2 ) ^  r1 )));r8=( r8  | (r9=~(( r10  |  r1 ) ^  r5 )));r6= r9 ;
 r4= r7 ;r1= r4 ;r2=(r4= r3 );r3= maxSignGradm2$1 ;
 r4=( r3  &  r2 );r5=(r9=( r4  | (~ r4  & ((~ r3  &  r0 ) | (~ r2  &  r1 )))));r9= r4 ;r7= r9 ;
 r0=(r2= r8 );r2= r6 ;r1= r2 ;r2=( r7  &  r1 );
 maxSignGradm2$0=( r2  | (~ r2  & ((~ r7  &  r5 ) | (~ r1  &  r0 ))));maxSignGradm2$1= r2 ;auxL35$0= grad$0 ;auxL35$1= grad$1 ;
 auxL35$2= grad$2 ;auxL35$3= grad$3 ;r0= auxL35$3 ;slop$ne[i]=( r0  <<  1 );
 auxL84$0= tmun20$0 ;auxL84$1= tmun20$1 ;auxL84$2= tmun20$2 ;auxL84$3= tmun20$3 ;
 tmun20$0=( auxL35$0  <<  1 );tmun20$1=( auxL35$1  <<  1 );tmun20$2=( auxL35$2  <<  1 );tmun20$3=( auxL35$3  <<  1 );
 r0= auxL84$0 ;r0=( r0  |  auxL84$1 );r0=( r0  |  auxL84$2 );r0=( r0  |  auxL84$3 );
 r1= auxL84$3 ;signGrad6$0= r0 ;signGrad6$1= r1 ;auxL81=~ srcPropag ;
 sgnMinLt$0=(( auxL82  & ( signGrad6$0  &  signGrad6$0 )) |  tmun21$0 );sgnMinLt$1=(( auxL82  & ( signGrad6$1  &  signGrad6$1 )) |  tmun21$1 );tmun21$0= auxL81 ;sgnMaxLt$ne$0[i-1]=(( auxL82  &  signGrad6$0 ) |  tmun22$0 );
 sgnMaxLt$ne$1[i-1]=(( auxL82  &  signGrad6$1 ) |  tmun22$1 );tmun22$0= auxL81 ;tmun22$1= auxL81 ;auxL82= srcPropag ;
 r0= sgnMaxLt$ne$0[i-1] ;r1= sgnMaxLt$sw$1[i-1] ;r2= minsignLt$0 ;r3= minsignLt$1 ;
 r4= sgnMaxLt$sw$0[i-1] ;r5= sgnMaxLt$e$0[i-1] ;r6= sgnMaxLt$nw$1[i-1] ;r7= sgnMaxLt$e$1[i-1] ;
 r8= sgnMaxLt$se$1[i-1] ;r10=(r11=( sgnMinLt$0  &  sgnMinLt$0 ));r11=( sgnMinLt$1  &  sgnMinLt$1 );r9= r11 ;
 r11=( r3  |  r9 );r9=( r11  | (~ r11  & ( r2  &  r10 )));r14=(r13= r11 );r12= r13 ;
 r3= r13 ;r2= auxL84$0 ;r15= auxL84$1 ;r13= auxL84$2 ;
 r10=(r11= auxL84$3 );r17=(r18= r2 );r17=( r17  | (r18=~ r15 ));r17=( r17  | (r18=~((r11= r15 ) ^  r13 )));
 r17=( r17  | (r18=~(( r11  |  r13 ) ^  r10 )));r16= r18 ;r2= sgnMaxLt$w$0[i-1] ;r10= sgnMaxLt$w$1[i-1] ;
 r11=( r7  &  r10 );r15=(r18=( r11  | (~ r11  & ((~ r7  &  r5 ) | (~ r10  &  r2 )))));r18= r11 ;r13= r18 ;
 r2= sgnMaxLt$ne$1[i-1] ;r5= maxSignGradm2$1 ;r7=(r11= r17 );r11= r16 ;
 r10= r11 ;r11=( r5  &  r10 );r16= sgnMaxLt$nw$0[i-1] ;r17=( r13  &  r8 );
 r18= maxSignGradm2$0 ;r20=(r21=( r11  | (~ r11  & ((~ r5  &  r18 ) | (~ r10  &  r7 )))));r21= r11 ;r19= r21 ;
 r5= sgnMaxLt$se$0[i-1] ;r11=(r7=( r17  | (~ r17  & ((~ r13  &  r15 ) | (~ r8  &  r5 )))));r7= r17 ;r10= r7 ;
 r5=( r10  &  r6 );r8=(r7=( r5  | (~ r5  & ((~ r10  &  r11 ) | (~ r6  &  r16 )))));r7= r5 ;r13= r7 ;
 r5=( r13  &  r1 );r7=( r5  | (~ r5  & ((~ r13  &  r8 ) | (~ r1  &  r4 ))));r6= r7 ;r10=(r7= r5 );
 r1=( r10  &  r2 );r4=( r1  | (~ r1  & ((~ r10  &  r6 ) | (~ r2  &  r0 ))));r11=(r7= r1 );r8= r7 ;
 r5= r7 ;r0=(r6=( r9  ^  r4 ));r0=( r0  | (r6=(((r1=( r4  &  r9 )) ^  r14 ) ^  r11 )));r0=( r0  | (r6=(((r1=(( r1  &  r14 ) | ( r11  & ( r1  |  r14 )))) ^  r12 ) ^  r8 )));
 r0=( r0  | (r6=(((( r1  &  r12 ) | ( r8  & ( r1  |  r12 ))) ^  r3 ) ^  r5 )));r2= r6 ;r3=(r4= r0 );r4= r2 ;
 r1= r4 ;r0=( r19  &  r1 );delta$0[i-1]=( r0  | (~ r0  & ((~ r19  &  r20 ) | (~ r1  &  r3 ))));delta$1[i-1]= r0 ;
 r0= grad$0 ;r0=( r0  |  grad$1 );r0=( r0  | ~ grad$2 );r0=( r0  | ( grad$2  ^  grad$3 ));
 gap$ad[i-1]=~ r0 ;   }
 p.mirror(delta);p.prepareBit(slop);p.prepareBit(delta);p.prepareBit(sgnMaxLt);p.prepareBit(gap) ;   }
public static int ltapex2_5_5_1_1GateCount=33;
 public static void ltapex2_5_5_1_1(PrShift p,int [][] pdeef,int [][] psegmentderiv,int [][] pdifff,int [][] gradltapex2){
int[] gradltapex2$h1=gradltapex2[0],gradltapex2$h2=gradltapex2[1],gradltapex2$d1=gradltapex2[2],gradltapex2$d2=gradltapex2[3],gradltapex2$ad1=gradltapex2[4],gradltapex2$ad2=gradltapex2[5],pdeef$h1$0=pdeef[0],pdeef$h1$1=pdeef[1],pdeef$h1$2=pdeef[2],pdeef$h1$3=pdeef[3],pdeef$h1$4=pdeef[4],pdeef$h2$0=pdeef[5],pdeef$h2$1=pdeef[6],pdeef$h2$2=pdeef[7],pdeef$h2$3=pdeef[8],pdeef$h2$4=pdeef[9],pdeef$d1$0=pdeef[10],pdeef$d1$1=pdeef[11],pdeef$d1$2=pdeef[12],pdeef$d1$3=pdeef[13],pdeef$d1$4=pdeef[14],pdeef$d2$0=pdeef[15],pdeef$d2$1=pdeef[16],pdeef$d2$2=pdeef[17],pdeef$d2$3=pdeef[18],pdeef$d2$4=pdeef[19],pdeef$ad1$0=pdeef[20],pdeef$ad1$1=pdeef[21],pdeef$ad1$2=pdeef[22],pdeef$ad1$3=pdeef[23],pdeef$ad1$4=pdeef[24],pdeef$ad2$0=pdeef[25],pdeef$ad2$1=pdeef[26],pdeef$ad2$2=pdeef[27],pdeef$ad2$3=pdeef[28],pdeef$ad2$4=pdeef[29],psegmentderiv$h$0=psegmentderiv[0],psegmentderiv$h$1=psegmentderiv[1],psegmentderiv$h$2=psegmentderiv[2],psegmentderiv$h$3=psegmentderiv[3],psegmentderiv$h$4=psegmentderiv[4],psegmentderiv$d$0=psegmentderiv[5],psegmentderiv$d$1=psegmentderiv[6],psegmentderiv$d$2=psegmentderiv[7],psegmentderiv$d$3=psegmentderiv[8],psegmentderiv$d$4=psegmentderiv[9],psegmentderiv$ad$0=psegmentderiv[10],psegmentderiv$ad$1=psegmentderiv[11],psegmentderiv$ad$2=psegmentderiv[12],psegmentderiv$ad$3=psegmentderiv[13],psegmentderiv$ad$4=psegmentderiv[14],pdifff$h=pdifff[0],pdifff$d=pdifff[1],pdifff$ad=pdifff[2];;;;
int auxL67=0,r0=0;// initialisation
for (int i = 1; i < pdeef$h1$0.length -1; i++) {
 r0=( psegmentderiv$h$0[i]  &  pdeef$h1$0[i] );r0=( r0  | ( psegmentderiv$h$1[i]  &  pdeef$h1$1[i] ));r0=( r0  | ( psegmentderiv$h$2[i]  &  pdeef$h1$2[i] ));r0=( r0  | ( psegmentderiv$h$3[i]  &  pdeef$h1$3[i] ));
 r0=( r0  | ( psegmentderiv$h$4[i]  &  pdeef$h1$4[i] ));auxL67= r0 ;gradltapex2$h1[i]= auxL67 ;gradltapex2$h2[i]=(~ auxL67  &  pdifff$h[i] );
 r0=( psegmentderiv$d$0[i]  &  pdeef$d1$0[i] );r0=( r0  | ( psegmentderiv$d$1[i]  &  pdeef$d1$1[i] ));r0=( r0  | ( psegmentderiv$d$2[i]  &  pdeef$d1$2[i] ));r0=( r0  | ( psegmentderiv$d$3[i]  &  pdeef$d1$3[i] ));
 r0=( r0  | ( psegmentderiv$d$4[i]  &  pdeef$d1$4[i] ));auxL67= r0 ;gradltapex2$d1[i]= auxL67 ;gradltapex2$d2[i]=(~ auxL67  &  pdifff$d[i] );
 r0=( psegmentderiv$ad$0[i]  &  pdeef$ad1$0[i] );r0=( r0  | ( psegmentderiv$ad$1[i]  &  pdeef$ad1$1[i] ));r0=( r0  | ( psegmentderiv$ad$2[i]  &  pdeef$ad1$2[i] ));r0=( r0  | ( psegmentderiv$ad$3[i]  &  pdeef$ad1$3[i] ));
 r0=( r0  | ( psegmentderiv$ad$4[i]  &  pdeef$ad1$4[i] ));auxL67= r0 ;gradltapex2$ad1[i]= auxL67 ;gradltapex2$ad2[i]=(~ auxL67  &  pdifff$ad[i] );   }
 ;p.prepareBit(gradltapex2) ;   }}