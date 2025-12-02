package compiledMacro;
 import simulator.PrShift;
 public class grad{
 
public static int slopDelta_4_1_2_1_1GateCount=237;
 public static void slopDelta_4_1_2_1_1(PrShift p,int [][] pdis,int [][] slop,int [][] deltaR,int [][] level,int [][] resultCA){
 int[] slop$e=slop[0],slop$se=slop[1],slop$sw=slop[2],slop$w=slop[3],slop$nw=slop[4],slop$ne=slop[5],deltaR$0=deltaR[0],deltaR$1=deltaR[1],level$h=level[0],level$d=level[1],level$ad=level[2],resultCA$h=resultCA[0],resultCA$d=resultCA[1],resultCA$ad=resultCA[2],pdis$0=pdis[0],pdis$1=pdis[1],pdis$2=pdis[2],pdis$3=pdis[3];

// initialisation 
 int auxL110$0=0,auxL110$1=0,auxL110$2=0,auxL110$3=0,auxL111$0=0,auxL111$1=0,auxL111$2=0,auxL111$3=0,auxL111$4=0,auxL111$5=0,auxL111$6=0,auxL112$0=0,auxL112$1=0,auxL112$2=0,auxL112$3=0,auxL62=0,auxL63$0=0,auxL63$1=0,auxL63$2=0,auxL63$3=0,auxL64$0=0,auxL64$1=0,auxL64$2=0,auxL64$3=0,auxO10=0,delta$0=0,delta$1=0,dis$0=0,dis$1=0,dis$2=0,dis$3=0,grad$0=0,grad$1=0,grad$2=0,grad$3=0,r0=0,r1=0,r10=0,r11=0,r12=0,r2=0,r3=0,r4=0,r5=0,r6=0,r7=0,r8=0,r9=0,tmun18$0=0,tmun18$1=0,tmun18$2=0,tmun18$3=0,tmun19$0=0,tmun19$1=0,tmun19$2=0,tmun19$3=0,tmun20$0=0,tmun20$1=0,tmun20$2=0,tmun20$3=0;
for (int i = 1; i < pdis$0.length -1; i++) {
 dis$0= pdis$0[i] ;dis$1= pdis$1[i] ;dis$2= pdis$2[i] ;dis$3= pdis$3[i] ;
 auxL64$0= dis$0 ;auxL64$1=((r0=~ dis$0 ) ^ ~ dis$1 );auxL64$2=((r0=( r0  & ~ dis$1 )) ^ ~ dis$2 );auxL64$3=(( r0  & ~ dis$2 ) ^ ~ dis$3 );
 grad$0= tmun18$0 ;grad$1= tmun18$1 ;grad$2= tmun18$2 ;grad$3= tmun18$3 ;
 tmun18$0=((r0=( auxL64$0  <<  1 )) ^  dis$0 );tmun18$1=(((r1=( dis$0  &  r0 )) ^ (r0=( auxL64$1  <<  1 ))) ^  dis$1 );tmun18$2=(((r1=(( r1  &  r0 ) | ( dis$1  & ( r1  |  r0 )))) ^ (r0=( auxL64$2  <<  1 ))) ^  dis$2 );tmun18$3=(((( r1  &  r0 ) | ( dis$2  & ( r1  |  r0 ))) ^ ( auxL64$3  <<  1 )) ^  dis$3 );
 auxL63$0= grad$0 ;auxL63$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL63$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );auxL63$3=(( r0  & ~ grad$2 ) ^ ~ grad$3 );
 r3= auxL63$0 ;r1= auxL63$1 ;r0= auxL63$2 ;r6=(r5= auxL63$3 );
 r4= r5 ;r2= r5 ;r7= r5 ;r8=(r5= r3 );
 r8=( r8  | (r5=~ r1 ));r8=( r8  | (r5=((r9= r1 ) ^  r0 )));r8=( r8  | (r5=((r9=( r9  &  r0 )) ^  r6 )));r8=( r8  | (r5=((r9=( r9  &  r6 )) ^  r4 )));
 r8=( r8  | (r5=((r9=( r9  &  r4 )) ^  r2 )));r8=( r8  | (r5=(( r9  &  r2 ) ^  r7 )));r10= r5 ;delta$0= r8 ;
 delta$1= r10 ;r0= auxL63$3 ;auxL62= r0 ;slop$e[i-1]= auxL62 ;
 auxO10= auxL62 ;auxL63$0= grad$0 ;auxL63$1= grad$1 ;auxL63$2= grad$2 ;
 auxL63$3= grad$3 ;r0= delta$0 ;r1=( auxL63$0  >>>  1 );r3=( auxL63$1  >>>  1 );
 r8=( auxL63$2  >>>  1 );r4=(r2=( auxL63$3  >>>  1 ));r5= r2 ;r7= r2 ;
 r6= r2 ;r10= r1 ;r9= r10 ;r10=~ r3 ;
 r9=( r9  |  r10 );r10=((r11= r3 ) ^  r8 );r9=( r9  |  r10 );r10=((r11=( r11  &  r8 )) ^  r4 );
 r9=( r9  |  r10 );r10=((r11=( r11  &  r4 )) ^  r5 );r9=( r9  |  r10 );r10=((r11=( r11  &  r5 )) ^  r7 );
 r9=( r9  |  r10 );r2=(r10=(( r11  &  r7 ) ^  r6 ));r9=( r9  |  r10 );r3=(r1= r9 );
 r1= r2 ;r4= r1 ;r1= delta$1 ;r2=( r1  |  r4 );
 delta$0=( r2  | (~ r2  & ( r0  &  r3 )));delta$1= r2 ;r0= auxL63$3 ;auxL62= r0 ;
 slop$w[i-1]=( auxL62  >>>  1 );level$h[i-1]=~( auxO10  |  auxL62 );r0= grad$0 ;r0=( r0  |  grad$1 );
 r0=( r0  | ~ grad$2 );r0=( r0  | ( grad$2  ^  grad$3 ));resultCA$h[i-1]=~ r0 ;grad$0=( auxL110$0  ^  auxL64$0 );
 grad$1=(((r0=( auxL64$0  &  auxL110$0 )) ^  auxL110$1 ) ^  auxL64$1 );grad$2=(((r0=(( r0  &  auxL110$1 ) | ( auxL64$1  & ( r0  |  auxL110$1 )))) ^  auxL110$2 ) ^  auxL64$2 );grad$3=(((( r0  &  auxL110$2 ) | ( auxL64$2  & ( r0  |  auxL110$2 ))) ^  auxL110$3 ) ^  auxL64$3 );auxL63$0= grad$0 ;
 auxL63$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL63$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );auxL63$3=(( r0  & ~ grad$2 ) ^ ~ grad$3 );r0= delta$0 ;
 r4= auxL63$0 ;r3= auxL63$1 ;r5= auxL63$2 ;r2=(r7= auxL63$3 );
 r1= r7 ;r8= r7 ;r6= r7 ;r9= r4 ;
 r10= r9 ;r9=~ r3 ;r10=( r10  |  r9 );r9=((r7= r3 ) ^  r5 );
 r10=( r10  |  r9 );r9=((r7=( r7  &  r5 )) ^  r2 );r10=( r10  |  r9 );r9=((r7=( r7  &  r2 )) ^  r1 );
 r10=( r10  |  r9 );r9=((r7=( r7  &  r1 )) ^  r8 );r10=( r10  |  r9 );r11=(r9=(( r7  &  r8 ) ^  r6 ));
 r10=( r10  |  r9 );r1=(r3= r10 );r3= r11 ;r2= r3 ;
 r3= delta$1 ;r4=( r3  |  r2 );delta$0=( r4  | (~ r4  & ( r0  &  r1 )));delta$1= r4 ;
 r0= auxL63$3 ;auxL62= r0 ;slop$se[i-1]= auxL62 ;auxO10= auxL62 ;
 auxL63$0= grad$0 ;auxL63$1= grad$1 ;auxL63$2= grad$2 ;auxL63$3= grad$3 ;
 r1= tmun19$0 ;r2= tmun19$1 ;r0= tmun19$2 ;r7=(r6= tmun19$3 );
 r5= r6 ;r4= r6 ;r3= r6 ;r6= delta$0 ;
 r11=(r9= r1 );r11=( r11  | (r9=~ r2 ));r11=( r11  | (r9=((r10= r2 ) ^  r0 )));r11=( r11  | (r9=((r10=( r10  &  r0 )) ^  r7 )));
 r11=( r11  | (r9=((r10=( r10  &  r7 )) ^  r5 )));r11=( r11  | (r9=((r10=( r10  &  r5 )) ^  r4 )));r11=( r11  | (r9=(( r10  &  r4 ) ^  r3 )));r8= r9 ;
 r0=(r2= r11 );r2= r8 ;r1= r2 ;r2= delta$1 ;
 r3=( r2  |  r1 );delta$0=( r3  | (~ r3  & ( r6  &  r0 )));delta$1= r3 ;tmun19$0= auxL63$0 ;
 tmun19$1= auxL63$1 ;tmun19$2= auxL63$2 ;tmun19$3= auxL63$3 ;r0= auxL63$3 ;
 auxL62= r0 ;slop$nw[i]= auxL62 ;level$d[i-1]=~( auxO10  |  auxL62 );r0= grad$0 ;
 r0=( r0  |  grad$1 );r0=( r0  | ~ grad$2 );r0=( r0  | ( grad$2  ^  grad$3 ));resultCA$d[i-1]=~ r0 ;
 grad$0=( auxL110$0  ^ (r1=( auxL64$0  >>>  1 )));grad$1=(((r0=( r1  &  auxL110$0 )) ^  auxL110$1 ) ^ (r1=( auxL64$1  >>>  1 )));grad$2=(((r0=(( r0  &  auxL110$1 ) | ( r1  & ( r0  |  auxL110$1 )))) ^  auxL110$2 ) ^ (r1=( auxL64$2  >>>  1 )));grad$3=(((( r0  &  auxL110$2 ) | ( r1  & ( r0  |  auxL110$2 ))) ^  auxL110$3 ) ^ ( auxL64$3  >>>  1 ));
 auxL110$0= dis$0 ;auxL110$1= dis$1 ;auxL110$2= dis$2 ;auxL110$3= dis$3 ;
 auxL63$0= grad$0 ;auxL63$1= grad$1 ;auxL63$2= grad$2 ;auxL63$3= grad$3 ;
 r0= delta$1 ;r6= tmun20$0 ;r2= tmun20$1 ;r4= tmun20$2 ;
 r5=(r7= tmun20$3 );r8= r7 ;r1= r7 ;r3= r7 ;
 r10= r6 ;r7= r10 ;r10=~ r2 ;r7=( r7  |  r10 );
 r10=((r9= r2 ) ^  r4 );r7=( r7  |  r10 );r10=((r9=( r9  &  r4 )) ^  r5 );r7=( r7  |  r10 );
 r10=((r9=( r9  &  r5 )) ^  r8 );r7=( r7  |  r10 );r10=((r9=( r9  &  r8 )) ^  r1 );r7=( r7  |  r10 );
 r11=(r10=(( r9  &  r1 ) ^  r3 ));r7=( r7  |  r10 );r2=(r1= r7 );r1= r11 ;
 r3= r1 ;r1=( r0  |  r3 );r0= delta$0 ;delta$0=( r1  | (~ r1  & ( r0  &  r2 )));
 delta$1= r1 ;tmun20$0=( auxL63$0  <<  1 );tmun20$1=( auxL63$1  <<  1 );tmun20$2=( auxL63$2  <<  1 );
 tmun20$3=( auxL63$3  <<  1 );r0= auxL63$3 ;auxL62= r0 ;slop$ne[i]=( auxL62  <<  1 );
 auxO10= auxL62 ;auxL63$0= grad$0 ;auxL63$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL63$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );
 auxL63$3=(( r0  & ~ grad$2 ) ^ ~ grad$3 );r1= auxL63$0 ;r3= auxL63$1 ;r7= auxL63$2 ;
 r0=(r5= auxL63$3 );r4= r5 ;r2= r5 ;r6= r5 ;
 r5= delta$1 ;r8= delta$0 ;r9=(r10= r1 );r9=( r9  | (r10=~ r3 ));
 r9=( r9  | (r10=((r11= r3 ) ^  r7 )));r9=( r9  | (r10=((r11=( r11  &  r7 )) ^  r0 )));r9=( r9  | (r10=((r11=( r11  &  r0 )) ^  r4 )));r9=( r9  | (r10=((r11=( r11  &  r4 )) ^  r2 )));
 r9=( r9  | (r10=(( r11  &  r2 ) ^  r6 )));r12= r10 ;r0=(r1= r9 );r1= r12 ;
 r2= r1 ;r1=( r5  |  r2 );deltaR$0[i-1]=( r1  | (~ r1  & ( r8  &  r0 )));deltaR$1[i-1]= r1 ;
 r0= auxL63$3 ;auxL62= r0 ;slop$sw[i-1]= auxL62 ;level$ad[i-1]=~( auxO10  |  auxL62 );
 r0= grad$0 ;r0=( r0  |  grad$1 );r0=( r0  | ~ grad$2 );r0=( r0  | ( grad$2  ^  grad$3 ));
 resultCA$ad[i-1]=~ r0 ;
  }
  p.mirror(deltaR);
p.prepareBit(slop);p.prepareBit(deltaR);p.prepareBit(level);p.prepareBit(resultCA)
 ;
  }
public static int ltapex2_4_4_1_1GateCount=27;
 public static void ltapex2_4_4_1_1(PrShift p,int [][] pdeef,int [][] psegmentderiv,int [][] pdifff,int [][] gradltapex2){
 int[] gradltapex2$h1=gradltapex2[0],gradltapex2$h2=gradltapex2[1],gradltapex2$d1=gradltapex2[2],gradltapex2$d2=gradltapex2[3],gradltapex2$ad1=gradltapex2[4],gradltapex2$ad2=gradltapex2[5],pdeef$h1$0=pdeef[0],pdeef$h1$1=pdeef[1],pdeef$h1$2=pdeef[2],pdeef$h1$3=pdeef[3],pdeef$h2$0=pdeef[4],pdeef$h2$1=pdeef[5],pdeef$h2$2=pdeef[6],pdeef$h2$3=pdeef[7],pdeef$d1$0=pdeef[8],pdeef$d1$1=pdeef[9],pdeef$d1$2=pdeef[10],pdeef$d1$3=pdeef[11],pdeef$d2$0=pdeef[12],pdeef$d2$1=pdeef[13],pdeef$d2$2=pdeef[14],pdeef$d2$3=pdeef[15],pdeef$ad1$0=pdeef[16],pdeef$ad1$1=pdeef[17],pdeef$ad1$2=pdeef[18],pdeef$ad1$3=pdeef[19],pdeef$ad2$0=pdeef[20],pdeef$ad2$1=pdeef[21],pdeef$ad2$2=pdeef[22],pdeef$ad2$3=pdeef[23],psegmentderiv$h$0=psegmentderiv[0],psegmentderiv$h$1=psegmentderiv[1],psegmentderiv$h$2=psegmentderiv[2],psegmentderiv$h$3=psegmentderiv[3],psegmentderiv$d$0=psegmentderiv[4],psegmentderiv$d$1=psegmentderiv[5],psegmentderiv$d$2=psegmentderiv[6],psegmentderiv$d$3=psegmentderiv[7],psegmentderiv$ad$0=psegmentderiv[8],psegmentderiv$ad$1=psegmentderiv[9],psegmentderiv$ad$2=psegmentderiv[10],psegmentderiv$ad$3=psegmentderiv[11],pdifff$h=pdifff[0],pdifff$d=pdifff[1],pdifff$ad=pdifff[2];

// initialisation 
 int auxL65=0,r0=0;
for (int i = 1; i < pdeef$h1$0.length -1; i++) {
 r0=( psegmentderiv$h$0[i]  &  pdeef$h1$0[i] );r0=( r0  | ( psegmentderiv$h$1[i]  &  pdeef$h1$1[i] ));r0=( r0  | ( psegmentderiv$h$2[i]  &  pdeef$h1$2[i] ));r0=( r0  | ( psegmentderiv$h$3[i]  &  pdeef$h1$3[i] ));
 auxL65= r0 ;gradltapex2$h1[i]= auxL65 ;gradltapex2$h2[i]=(~ auxL65  &  pdifff$h[i] );r0=( psegmentderiv$d$0[i]  &  pdeef$d1$0[i] );
 r0=( r0  | ( psegmentderiv$d$1[i]  &  pdeef$d1$1[i] ));r0=( r0  | ( psegmentderiv$d$2[i]  &  pdeef$d1$2[i] ));r0=( r0  | ( psegmentderiv$d$3[i]  &  pdeef$d1$3[i] ));auxL65= r0 ;
 gradltapex2$d1[i]= auxL65 ;gradltapex2$d2[i]=(~ auxL65  &  pdifff$d[i] );r0=( psegmentderiv$ad$0[i]  &  pdeef$ad1$0[i] );r0=( r0  | ( psegmentderiv$ad$1[i]  &  pdeef$ad1$1[i] ));
 r0=( r0  | ( psegmentderiv$ad$2[i]  &  pdeef$ad1$2[i] ));r0=( r0  | ( psegmentderiv$ad$3[i]  &  pdeef$ad1$3[i] ));auxL65= r0 ;gradltapex2$ad1[i]= auxL65 ;
 gradltapex2$ad2[i]=(~ auxL65  &  pdifff$ad[i] );
  }
  ;
p.prepareBit(gradltapex2)
 ;
  }
public static int lt_4_4_1GateCount=45;
 public static void lt_4_4_1(PrShift p,int [][] pdis,int [][] psegment,int [][] gradlt){
 int[] gradlt$h1=gradlt[0],gradlt$h2=gradlt[1],gradlt$d1=gradlt[2],gradlt$d2=gradlt[3],gradlt$ad1=gradlt[4],gradlt$ad2=gradlt[5],pdis$0=pdis[0],pdis$1=pdis[1],pdis$2=pdis[2],pdis$3=pdis[3],psegment$h$0=psegment[0],psegment$h$1=psegment[1],psegment$h$2=psegment[2],psegment$h$3=psegment[3],psegment$d$0=psegment[4],psegment$d$1=psegment[5],psegment$d$2=psegment[6],psegment$d$3=psegment[7],psegment$ad$0=psegment[8],psegment$ad$1=psegment[9],psegment$ad$2=psegment[10],psegment$ad$3=psegment[11];

// initialisation 
 int auxL108$0=0,auxL108$1=0,auxL108$2=0,auxL108$3=0,auxL109$0=0,auxL109$1=0,auxL109$2=0,auxL109$3=0,auxL66=0,auxTmp1$0=0,auxTmp1$1=0,auxTmp1$2=0,auxTmp1$3=0,r0=0,segment$0=0,segment$1=0,segment$2=0,segment$3=0,tmun11$0=0,tmun11$1=0,tmun11$2=0,tmun11$3=0,tmun12$0=0,tmun12$1=0,tmun12$2=0,tmun12$3=0,tmun13=0,tmun14$0=0,tmun14$1=0,tmun14$2=0,tmun14$3=0,tmun15=0,tmun16$0=0,tmun16$1=0,tmun16$2=0,tmun16$3=0,tmun17=0;
for (int i = 1; i < pdis$0.length -1; i++) {
 auxL109$0= pdis$0[i] ;auxL109$1= pdis$1[i] ;auxL109$2= pdis$2[i] ;auxL109$3= pdis$3[i] ;
 auxTmp1$0= auxL108$0 ;auxTmp1$1= auxL108$1 ;auxTmp1$2= auxL108$2 ;auxTmp1$3= auxL108$3 ;
 segment$0= psegment$h$0[i] ;segment$1= psegment$h$1[i] ;segment$2= psegment$h$2[i] ;segment$3= psegment$h$3[i] ;
 r0=( tmun12$0  &  auxTmp1$0 );r0=( r0  | ( tmun12$1  &  auxTmp1$1 ));r0=( r0  | ( tmun12$2  &  auxTmp1$2 ));r0=( r0  | ( tmun12$3  &  auxTmp1$3 ));
 auxL66= r0 ;tmun11$0=( auxL109$0  <<  1 );tmun11$1=( auxL109$1  <<  1 );tmun11$2=( auxL109$2  <<  1 );
 tmun11$3=( auxL109$3  <<  1 );tmun12$3= segment$3 ;tmun12$2=(~(r0= segment$3 ) &  segment$2 );tmun12$1=(~(r0= segment$2 ) &  segment$1 );
 tmun12$0=(~ segment$1  &  segment$0 );gradlt$h1[i-1]= auxL66 ;gradlt$h2[i-1]=(~ auxL66  &  tmun13 );r0= segment$0 ;
 tmun13= r0 ;auxTmp1$0= auxL108$0 ;auxTmp1$1= auxL108$1 ;auxTmp1$2= auxL108$2 ;
 auxTmp1$3= auxL108$3 ;segment$0= psegment$d$0[i] ;segment$1= psegment$d$1[i] ;segment$2= psegment$d$2[i] ;
 segment$3= psegment$d$3[i] ;r0=( tmun14$0  &  auxTmp1$0 );r0=( r0  | ( tmun14$1  &  auxTmp1$1 ));r0=( r0  | ( tmun14$2  &  auxTmp1$2 ));
 r0=( r0  | ( tmun14$3  &  auxTmp1$3 ));auxL66= r0 ;tmun14$3= segment$3 ;tmun14$2=(~(r0= segment$3 ) &  segment$2 );
 tmun14$1=(~(r0= segment$2 ) &  segment$1 );tmun14$0=(~ segment$1  &  segment$0 );gradlt$d1[i-1]= auxL66 ;gradlt$d2[i-1]=(~ auxL66  &  tmun15 );
 r0= segment$0 ;tmun15= r0 ;auxTmp1$0= auxL108$0 ;auxTmp1$1= auxL108$1 ;
 auxTmp1$2= auxL108$2 ;auxTmp1$3= auxL108$3 ;auxL108$0= auxL109$0 ;auxL108$1= auxL109$1 ;
 auxL108$2= auxL109$2 ;auxL108$3= auxL109$3 ;segment$0= psegment$ad$0[i] ;segment$1= psegment$ad$1[i] ;
 segment$2= psegment$ad$2[i] ;segment$3= psegment$ad$3[i] ;r0=( tmun16$0  &  auxTmp1$0 );r0=( r0  | ( tmun16$1  &  auxTmp1$1 ));
 r0=( r0  | ( tmun16$2  &  auxTmp1$2 ));r0=( r0  | ( tmun16$3  &  auxTmp1$3 ));auxL66= r0 ;tmun16$3= segment$3 ;
 tmun16$2=(~(r0= segment$3 ) &  segment$2 );tmun16$1=(~(r0= segment$2 ) &  segment$1 );tmun16$0=(~ segment$1  &  segment$0 );gradlt$ad1[i-1]= auxL66 ;
 gradlt$ad2[i-1]=(~ auxL66  &  tmun17 );r0= segment$0 ;tmun17= r0 ;
  }
  ;
p.prepareBit(gradlt)
 ;
  }
public static int slopDelta_3_1_2_1_1GateCount=203;
 public static void slopDelta_3_1_2_1_1(PrShift p,int [][] pdis,int [][] slop,int [][] deltaR,int [][] level,int [][] resultCA){
 int[] slop$e=slop[0],slop$se=slop[1],slop$sw=slop[2],slop$w=slop[3],slop$nw=slop[4],slop$ne=slop[5],deltaR$0=deltaR[0],deltaR$1=deltaR[1],level$h=level[0],level$d=level[1],level$ad=level[2],resultCA$h=resultCA[0],resultCA$d=resultCA[1],resultCA$ad=resultCA[2],pdis$0=pdis[0],pdis$1=pdis[1],pdis$2=pdis[2];

// initialisation 
 int auxL105$0=0,auxL105$1=0,auxL105$2=0,auxL106$0=0,auxL106$1=0,auxL106$2=0,auxL106$3=0,auxL106$4=0,auxL106$5=0,auxL106$6=0,auxL107$0=0,auxL107$1=0,auxL107$2=0,auxL107$3=0,auxL62=0,auxL63$0=0,auxL63$1=0,auxL63$2=0,auxL64$0=0,auxL64$1=0,auxL64$2=0,auxO13=0,delta$0=0,delta$1=0,dis$0=0,dis$1=0,dis$2=0,grad$0=0,grad$1=0,grad$2=0,r0=0,r1=0,r10=0,r11=0,r12=0,r2=0,r3=0,r4=0,r5=0,r6=0,r7=0,r8=0,r9=0,tmun08$0=0,tmun08$1=0,tmun08$2=0,tmun09$0=0,tmun09$1=0,tmun09$2=0,tmun10$0=0,tmun10$1=0,tmun10$2=0;
for (int i = 1; i < pdis$0.length -1; i++) {
 dis$0= pdis$0[i] ;dis$1= pdis$1[i] ;dis$2= pdis$2[i] ;auxL64$0= dis$0 ;
 auxL64$1=((r0=~ dis$0 ) ^ ~ dis$1 );auxL64$2=(( r0  & ~ dis$1 ) ^ ~ dis$2 );grad$0= tmun08$0 ;grad$1= tmun08$1 ;
 grad$2= tmun08$2 ;tmun08$0=((r0=( auxL64$0  <<  1 )) ^  dis$0 );tmun08$1=(((r1=( dis$0  &  r0 )) ^ (r0=( auxL64$1  <<  1 ))) ^  dis$1 );tmun08$2=(((( r1  &  r0 ) | ( dis$1  & ( r1  |  r0 ))) ^ ( auxL64$2  <<  1 )) ^  dis$2 );
 auxL63$0= grad$0 ;auxL63$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL63$2=(( r0  & ~ grad$1 ) ^ ~ grad$2 );r1= auxL63$0 ;
 r6= auxL63$1 ;r4=(r3= auxL63$2 );r0= r3 ;r2= r3 ;
 r5= r3 ;r7= r3 ;r10=(r8= r1 );r10=( r10  | (r8=~ r6 ));
 r10=( r10  | (r8=((r9= r6 ) ^  r4 )));r10=( r10  | (r8=((r9=( r9  &  r4 )) ^  r0 )));r10=( r10  | (r8=((r9=( r9  &  r0 )) ^  r2 )));r10=( r10  | (r8=((r9=( r9  &  r2 )) ^  r5 )));
 r10=( r10  | (r8=(( r9  &  r5 ) ^  r7 )));r3= r8 ;delta$0= r10 ;delta$1= r3 ;
 r0= auxL63$2 ;auxL62= r0 ;slop$e[i-1]= auxL62 ;auxO13= auxL62 ;
 auxL63$0= grad$0 ;auxL63$1= grad$1 ;auxL63$2= grad$2 ;r4=( auxL63$0  >>>  1 );
 r7=( auxL63$1  >>>  1 );r0=(r2=( auxL63$2  >>>  1 ));r5= r2 ;r1= r2 ;
 r3= r2 ;r6= r2 ;r2= delta$0 ;r8= delta$1 ;
 r11= r4 ;r9= r11 ;r11=~ r7 ;r9=( r9  |  r11 );
 r11=((r12= r7 ) ^  r0 );r9=( r9  |  r11 );r11=((r12=( r12  &  r0 )) ^  r5 );r9=( r9  |  r11 );
 r11=((r12=( r12  &  r5 )) ^  r1 );r9=( r9  |  r11 );r11=((r12=( r12  &  r1 )) ^  r3 );r9=( r9  |  r11 );
 r10=(r11=(( r12  &  r3 ) ^  r6 ));r9=( r9  |  r11 );r1=(r3= r9 );r3= r10 ;
 r0= r3 ;r3=( r8  |  r0 );delta$0=( r3  | (~ r3  & ( r2  &  r1 )));delta$1= r3 ;
 r0= auxL63$2 ;auxL62= r0 ;slop$w[i-1]=( auxL62  >>>  1 );level$h[i-1]=~( auxO13  |  auxL62 );
 r1=(r2= grad$0 );r1=( r1  | (r2= grad$1 ));r1=( r1  | ~(r2=(r0= grad$2 )));r1=( r1  | ( r2  ^  r0 ));
 resultCA$h[i-1]=~ r1 ;grad$0=( auxL105$0  ^  auxL64$0 );grad$1=(((r0=( auxL64$0  &  auxL105$0 )) ^  auxL105$1 ) ^  auxL64$1 );grad$2=(((( r0  &  auxL105$1 ) | ( auxL64$1  & ( r0  |  auxL105$1 ))) ^  auxL105$2 ) ^  auxL64$2 );
 auxL63$0= grad$0 ;auxL63$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL63$2=(( r0  & ~ grad$1 ) ^ ~ grad$2 );r0= delta$1 ;
 r1= delta$0 ;r2= auxL63$0 ;r4= auxL63$1 ;r8=(r9= auxL63$2 );
 r7= r9 ;r3= r9 ;r5= r9 ;r6= r9 ;
 r9= r2 ;r10= r9 ;r9=~ r4 ;r10=( r10  |  r9 );
 r9=((r11= r4 ) ^  r8 );r10=( r10  |  r9 );r9=((r11=( r11  &  r8 )) ^  r7 );r10=( r10  |  r9 );
 r9=((r11=( r11  &  r7 )) ^  r3 );r10=( r10  |  r9 );r9=((r11=( r11  &  r3 )) ^  r5 );r10=( r10  |  r9 );
 r12=(r9=(( r11  &  r5 ) ^  r6 ));r10=( r10  |  r9 );r3=(r2= r10 );r2= r12 ;
 r4= r2 ;r2=( r0  |  r4 );delta$0=( r2  | (~ r2  & ( r1  &  r3 )));delta$1= r2 ;
 r0= auxL63$2 ;auxL62= r0 ;slop$se[i-1]= auxL62 ;auxO13= auxL62 ;
 auxL63$0= grad$0 ;auxL63$1= grad$1 ;auxL63$2= grad$2 ;r5= tmun09$0 ;
 r4= tmun09$1 ;r2=(r7= tmun09$2 );r1= r7 ;r3= r7 ;
 r0= r7 ;r6= r7 ;r7= delta$0 ;r9=(r10= r5 );
 r9=( r9  | (r10=~ r4 ));r9=( r9  | (r10=((r11= r4 ) ^  r2 )));r9=( r9  | (r10=((r11=( r11  &  r2 )) ^  r1 )));r9=( r9  | (r10=((r11=( r11  &  r1 )) ^  r3 )));
 r9=( r9  | (r10=((r11=( r11  &  r3 )) ^  r0 )));r9=( r9  | (r10=(( r11  &  r0 ) ^  r6 )));r8= r10 ;r0= delta$1 ;
 r1=(r3= r9 );r3= r8 ;r2= r3 ;r3=( r0  |  r2 );
 delta$0=( r3  | (~ r3  & ( r7  &  r1 )));delta$1= r3 ;tmun09$0= auxL63$0 ;tmun09$1= auxL63$1 ;
 tmun09$2= auxL63$2 ;r0= auxL63$2 ;auxL62= r0 ;slop$nw[i]= auxL62 ;
 level$d[i-1]=~( auxO13  |  auxL62 );r1=(r0= grad$0 );r1=( r1  | (r0= grad$1 ));r1=( r1  | ~(r0=(r2= grad$2 )));
 r1=( r1  | ( r0  ^  r2 ));resultCA$d[i-1]=~ r1 ;grad$0=( auxL105$0  ^ (r0=( auxL64$0  >>>  1 )));grad$1=(((r1=( r0  &  auxL105$0 )) ^  auxL105$1 ) ^ (r0=( auxL64$1  >>>  1 )));
 grad$2=(((( r1  &  auxL105$1 ) | ( r0  & ( r1  |  auxL105$1 ))) ^  auxL105$2 ) ^ ( auxL64$2  >>>  1 ));auxL105$0= dis$0 ;auxL105$1= dis$1 ;auxL105$2= dis$2 ;
 auxL63$0= grad$0 ;auxL63$1= grad$1 ;auxL63$2= grad$2 ;r0= delta$1 ;
 r1= delta$0 ;r9= tmun10$0 ;r6= tmun10$1 ;r4=(r8= tmun10$2 );
 r3= r8 ;r7= r8 ;r2= r8 ;r5= r8 ;
 r8= r9 ;r11= r8 ;r8=~ r6 ;r11=( r11  |  r8 );
 r8=((r10= r6 ) ^  r4 );r11=( r11  |  r8 );r8=((r10=( r10  &  r4 )) ^  r3 );r11=( r11  |  r8 );
 r8=((r10=( r10  &  r3 )) ^  r7 );r11=( r11  |  r8 );r8=((r10=( r10  &  r7 )) ^  r2 );r11=( r11  |  r8 );
 r12=(r8=(( r10  &  r2 ) ^  r5 ));r11=( r11  |  r8 );r4= r11 ;r3= r4 ;
 r2=(r4= r12 );r4=( r0  |  r2 );delta$0=( r4  | (~ r4  & ( r1  &  r3 )));delta$1= r4 ;
 tmun10$0=( auxL63$0  <<  1 );tmun10$1=( auxL63$1  <<  1 );tmun10$2=( auxL63$2  <<  1 );r0= auxL63$2 ;
 auxL62= r0 ;slop$ne[i]=( auxL62  <<  1 );auxO13= auxL62 ;auxL63$0= grad$0 ;
 auxL63$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL63$2=(( r0  & ~ grad$1 ) ^ ~ grad$2 );r0= delta$1 ;r6= auxL63$0 ;
 r2= auxL63$1 ;r3=(r5= auxL63$2 );r8= r5 ;r7= r5 ;
 r4= r5 ;r1= r5 ;r10= r6 ;r11= r10 ;
 r10=~ r2 ;r11=( r11  |  r10 );r10=((r9= r2 ) ^  r3 );r11=( r11  |  r10 );
 r10=((r9=( r9  &  r3 )) ^  r8 );r11=( r11  |  r10 );r10=((r9=( r9  &  r8 )) ^  r7 );r11=( r11  |  r10 );
 r10=((r9=( r9  &  r7 )) ^  r4 );r11=( r11  |  r10 );r5=(r10=(( r9  &  r4 ) ^  r1 ));r11=( r11  |  r10 );
 r1= delta$0 ;r4= r11 ;r3= r4 ;r2=(r4= r5 );
 r4=( r0  |  r2 );deltaR$0[i-1]=( r4  | (~ r4  & ( r1  &  r3 )));deltaR$1[i-1]= r4 ;r0= auxL63$2 ;
 auxL62= r0 ;slop$sw[i-1]= auxL62 ;level$ad[i-1]=~( auxO13  |  auxL62 );r0=(r2= grad$0 );
 r0=( r0  | (r2= grad$1 ));r0=( r0  | ~(r2=(r1= grad$2 )));r0=( r0  | ( r2  ^  r1 ));resultCA$ad[i-1]=~ r0 ;
  }
  p.mirror(deltaR);
p.prepareBit(slop);p.prepareBit(deltaR);p.prepareBit(level);p.prepareBit(resultCA)
 ;
  }}