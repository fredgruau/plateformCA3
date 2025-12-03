package compiledMacro;
 import simulator.PrShift;
 public class grad{
 
public static int slopDeltaDist_4_1_2_1_1GateCount=237;
 public static void slopDeltaDist_4_1_2_1_1(PrShift p,int [][] pdis,int [][] slop,int [][] deltaR,int [][] level,int [][] resultCA){
 int[] slop$e=slop[0],slop$se=slop[1],slop$sw=slop[2],slop$w=slop[3],slop$nw=slop[4],slop$ne=slop[5],deltaR$0=deltaR[0],deltaR$1=deltaR[1],level$h=level[0],level$d=level[1],level$ad=level[2],resultCA$h=resultCA[0],resultCA$d=resultCA[1],resultCA$ad=resultCA[2],pdis$0=pdis[0],pdis$1=pdis[1],pdis$2=pdis[2],pdis$3=pdis[3];

// initialisation 
 int auxL61$0=0,auxL61$1=0,auxL61$2=0,auxL61$3=0,auxL62=0,auxL63$0=0,auxL63$1=0,auxL63$2=0,auxL63$3=0,auxL97$0=0,auxL97$1=0,auxL97$2=0,auxL97$3=0,auxL98$0=0,auxL98$1=0,auxL98$2=0,auxL98$3=0,auxL98$4=0,auxL98$5=0,auxL98$6=0,auxL99$0=0,auxL99$1=0,auxL99$2=0,auxL99$3=0,auxO09=0,delta$0=0,delta$1=0,dis$0=0,dis$1=0,dis$2=0,dis$3=0,grad$0=0,grad$1=0,grad$2=0,grad$3=0,r0=0,r1=0,r10=0,r11=0,r12=0,r2=0,r3=0,r4=0,r5=0,r6=0,r7=0,r8=0,r9=0,tmun04$0=0,tmun04$1=0,tmun04$2=0,tmun04$3=0,tmun05$0=0,tmun05$1=0,tmun05$2=0,tmun05$3=0,tmun06$0=0,tmun06$1=0,tmun06$2=0,tmun06$3=0;
for (int i = 1; i < pdis$0.length -1; i++) {
 dis$0= pdis$0[i] ;dis$1= pdis$1[i] ;dis$2= pdis$2[i] ;dis$3= pdis$3[i] ;
 auxL61$0= dis$0 ;auxL61$1=((r0=~ dis$0 ) ^ ~ dis$1 );auxL61$2=((r0=( r0  & ~ dis$1 )) ^ ~ dis$2 );auxL61$3=(( r0  & ~ dis$2 ) ^ ~ dis$3 );
 grad$0= tmun04$0 ;grad$1= tmun04$1 ;grad$2= tmun04$2 ;grad$3= tmun04$3 ;
 tmun04$0=((r1=( auxL61$0  <<  1 )) ^  dis$0 );tmun04$1=(((r0=( dis$0  &  r1 )) ^ (r1=( auxL61$1  <<  1 ))) ^  dis$1 );tmun04$2=(((r0=(( r0  &  r1 ) | ( dis$1  & ( r0  |  r1 )))) ^ (r1=( auxL61$2  <<  1 ))) ^  dis$2 );tmun04$3=(((( r0  &  r1 ) | ( dis$2  & ( r0  |  r1 ))) ^ ( auxL61$3  <<  1 )) ^  dis$3 );
 auxL63$0= grad$0 ;auxL63$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL63$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );auxL63$3=(( r0  & ~ grad$2 ) ^ ~ grad$3 );
 r2= auxL63$0 ;r4= auxL63$1 ;r7= auxL63$2 ;r0=(r5= auxL63$3 );
 r1= r5 ;r3= r5 ;r6= r5 ;r5= r2 ;
 r10= r5 ;r5=~ r4 ;r10=( r10  |  r5 );r5=((r9= r4 ) ^  r7 );
 r10=( r10  |  r5 );r5=((r9=( r9  &  r7 )) ^  r0 );r10=( r10  |  r5 );r5=((r9=( r9  &  r0 )) ^  r1 );
 r10=( r10  |  r5 );r5=((r9=( r9  &  r1 )) ^  r3 );r10=( r10  |  r5 );r8=(r5=(( r9  &  r3 ) ^  r6 ));
 r10=( r10  |  r5 );delta$0= r10 ;delta$1= r8 ;r0= auxL63$3 ;
 auxL62= r0 ;slop$e[i-1]= auxL62 ;auxO09= auxL62 ;auxL63$0= grad$0 ;
 auxL63$1= grad$1 ;auxL63$2= grad$2 ;auxL63$3= grad$3 ;r1=( auxL63$0  >>>  1 );
 r4=( auxL63$1  >>>  1 );r5=( auxL63$2  >>>  1 );r0=(r2=( auxL63$3  >>>  1 ));r3= r2 ;
 r6= r2 ;r7= r2 ;r9= r1 ;r8= r9 ;
 r9=~ r4 ;r8=( r8  |  r9 );r9=((r2= r4 ) ^  r5 );r8=( r8  |  r9 );
 r9=((r2=( r2  &  r5 )) ^  r0 );r8=( r8  |  r9 );r9=((r2=( r2  &  r0 )) ^  r3 );r8=( r8  |  r9 );
 r9=((r2=( r2  &  r3 )) ^  r6 );r8=( r8  |  r9 );r10=(r9=(( r2  &  r6 ) ^  r7 ));r8=( r8  |  r9 );
 r2= r8 ;r0= r2 ;r1=(r2= r10 );r2= delta$1 ;
 r3=( r2  |  r1 );r1= delta$0 ;delta$0=( r3  | (~ r3  & ( r1  &  r0 )));delta$1= r3 ;
 r0= auxL63$3 ;auxL62= r0 ;slop$w[i-1]=( auxL62  >>>  1 );level$h[i-1]=~( auxO09  |  auxL62 );
 r0= grad$0 ;r0=( r0  |  grad$1 );r0=( r0  | ~ grad$2 );r0=( r0  | ( grad$2  ^  grad$3 ));
 resultCA$h[i-1]=~ r0 ;grad$0=( auxL97$0  ^  auxL61$0 );grad$1=(((r0=( auxL61$0  &  auxL97$0 )) ^  auxL97$1 ) ^  auxL61$1 );grad$2=(((r0=(( r0  &  auxL97$1 ) | ( auxL61$1  & ( r0  |  auxL97$1 )))) ^  auxL97$2 ) ^  auxL61$2 );
 grad$3=(((( r0  &  auxL97$2 ) | ( auxL61$2  & ( r0  |  auxL97$2 ))) ^  auxL97$3 ) ^  auxL61$3 );auxL63$0= grad$0 ;auxL63$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL63$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );
 auxL63$3=(( r0  & ~ grad$2 ) ^ ~ grad$3 );r4= auxL63$0 ;r6= auxL63$1 ;r2= auxL63$2 ;
 r3=(r0= auxL63$3 );r5= r0 ;r7= r0 ;r1= r0 ;
 r0= delta$1 ;r10=(r8= r4 );r10=( r10  | (r8=~ r6 ));r10=( r10  | (r8=((r11= r6 ) ^  r2 )));
 r10=( r10  | (r8=((r11=( r11  &  r2 )) ^  r3 )));r10=( r10  | (r8=((r11=( r11  &  r3 )) ^  r5 )));r10=( r10  | (r8=((r11=( r11  &  r5 )) ^  r7 )));r10=( r10  | (r8=(( r11  &  r7 ) ^  r1 )));
 r9= r8 ;r1= r10 ;r2= r1 ;r3=(r1= r9 );
 r1=( r0  |  r3 );r0= delta$0 ;delta$0=( r1  | (~ r1  & ( r0  &  r2 )));delta$1= r1 ;
 r0= auxL63$3 ;auxL62= r0 ;slop$se[i-1]= auxL62 ;auxO09= auxL62 ;
 auxL63$0= grad$0 ;auxL63$1= grad$1 ;auxL63$2= grad$2 ;auxL63$3= grad$3 ;
 r2= tmun05$0 ;r0= tmun05$1 ;r7= tmun05$2 ;r4=(r6= tmun05$3 );
 r1= r6 ;r3= r6 ;r5= r6 ;r9= r2 ;
 r10= r9 ;r9=~ r0 ;r10=( r10  |  r9 );r9=((r8= r0 ) ^  r7 );
 r10=( r10  |  r9 );r9=((r8=( r8  &  r7 )) ^  r4 );r10=( r10  |  r9 );r9=((r8=( r8  &  r4 )) ^  r1 );
 r10=( r10  |  r9 );r9=((r8=( r8  &  r1 )) ^  r3 );r10=( r10  |  r9 );r6=(r9=(( r8  &  r3 ) ^  r5 ));
 r10=( r10  |  r9 );r1= r10 ;r2= r1 ;r0=(r1= r6 );
 r1= delta$1 ;r3=( r1  |  r0 );r0= delta$0 ;delta$0=( r3  | (~ r3  & ( r0  &  r2 )));
 delta$1= r3 ;tmun05$0= auxL63$0 ;tmun05$1= auxL63$1 ;tmun05$2= auxL63$2 ;
 tmun05$3= auxL63$3 ;r0= auxL63$3 ;auxL62= r0 ;slop$nw[i]= auxL62 ;
 level$d[i-1]=~( auxO09  |  auxL62 );r0= grad$0 ;r0=( r0  |  grad$1 );r0=( r0  | ~ grad$2 );
 r0=( r0  | ( grad$2  ^  grad$3 ));resultCA$d[i-1]=~ r0 ;grad$0=( auxL97$0  ^ (r1=( auxL61$0  >>>  1 )));grad$1=(((r0=( r1  &  auxL97$0 )) ^  auxL97$1 ) ^ (r1=( auxL61$1  >>>  1 )));
 grad$2=(((r0=(( r0  &  auxL97$1 ) | ( r1  & ( r0  |  auxL97$1 )))) ^  auxL97$2 ) ^ (r1=( auxL61$2  >>>  1 )));grad$3=(((( r0  &  auxL97$2 ) | ( r1  & ( r0  |  auxL97$2 ))) ^  auxL97$3 ) ^ ( auxL61$3  >>>  1 ));auxL97$0= dis$0 ;auxL97$1= dis$1 ;
 auxL97$2= dis$2 ;auxL97$3= dis$3 ;auxL63$0= grad$0 ;auxL63$1= grad$1 ;
 auxL63$2= grad$2 ;auxL63$3= grad$3 ;r0= delta$0 ;r1= delta$1 ;
 r6= tmun06$0 ;r2= tmun06$1 ;r8= tmun06$2 ;r7=(r9= tmun06$3 );
 r4= r9 ;r3= r9 ;r5= r9 ;r9= r6 ;
 r10= r9 ;r9=~ r2 ;r10=( r10  |  r9 );r9=((r11= r2 ) ^  r8 );
 r10=( r10  |  r9 );r9=((r11=( r11  &  r8 )) ^  r7 );r10=( r10  |  r9 );r9=((r11=( r11  &  r7 )) ^  r4 );
 r10=( r10  |  r9 );r9=((r11=( r11  &  r4 )) ^  r3 );r10=( r10  |  r9 );r12=(r9=(( r11  &  r3 ) ^  r5 ));
 r10=( r10  |  r9 );r3= r10 ;r4= r3 ;r2=(r3= r12 );
 r3=( r1  |  r2 );delta$0=( r3  | (~ r3  & ( r0  &  r4 )));delta$1= r3 ;tmun06$0=( auxL63$0  <<  1 );
 tmun06$1=( auxL63$1  <<  1 );tmun06$2=( auxL63$2  <<  1 );tmun06$3=( auxL63$3  <<  1 );r0= auxL63$3 ;
 auxL62= r0 ;slop$ne[i]=( auxL62  <<  1 );auxO09= auxL62 ;auxL63$0= grad$0 ;
 auxL63$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL63$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );auxL63$3=(( r0  & ~ grad$2 ) ^ ~ grad$3 );r0= delta$0 ;
 r1= delta$1 ;r8= auxL63$0 ;r7= auxL63$1 ;r4= auxL63$2 ;
 r2=(r5= auxL63$3 );r9= r5 ;r3= r5 ;r6= r5 ;
 r10=(r5= r8 );r10=( r10  | (r5=~ r7 ));r10=( r10  | (r5=((r11= r7 ) ^  r4 )));r10=( r10  | (r5=((r11=( r11  &  r4 )) ^  r2 )));
 r10=( r10  | (r5=((r11=( r11  &  r2 )) ^  r9 )));r10=( r10  | (r5=((r11=( r11  &  r9 )) ^  r3 )));r10=( r10  | (r5=(( r11  &  r3 ) ^  r6 )));r12= r5 ;
 r2= r10 ;r4= r2 ;r3=(r2= r12 );r2=( r1  |  r3 );
 deltaR$0[i-1]=( r2  | (~ r2  & ( r0  &  r4 )));deltaR$1[i-1]= r2 ;r0= auxL63$3 ;auxL62= r0 ;
 slop$sw[i-1]= auxL62 ;level$ad[i-1]=~( auxO09  |  auxL62 );r0= grad$0 ;r0=( r0  |  grad$1 );
 r0=( r0  | ~ grad$2 );r0=( r0  | ( grad$2  ^  grad$3 ));resultCA$ad[i-1]=~ r0 ;
  }
  p.mirror(deltaR);
p.prepareBit(slop);p.prepareBit(deltaR);p.prepareBit(level);p.prepareBit(resultCA)
 ;
  }
public static int ltapex2_4_4_1_1GateCount=27;
 public static void ltapex2_4_4_1_1(PrShift p,int [][] pdeef,int [][] psegmentderiv,int [][] pdifff,int [][] gradltapex2){
 int[] gradltapex2$h1=gradltapex2[0],gradltapex2$h2=gradltapex2[1],gradltapex2$d1=gradltapex2[2],gradltapex2$d2=gradltapex2[3],gradltapex2$ad1=gradltapex2[4],gradltapex2$ad2=gradltapex2[5],pdeef$h1$0=pdeef[0],pdeef$h1$1=pdeef[1],pdeef$h1$2=pdeef[2],pdeef$h1$3=pdeef[3],pdeef$h2$0=pdeef[4],pdeef$h2$1=pdeef[5],pdeef$h2$2=pdeef[6],pdeef$h2$3=pdeef[7],pdeef$d1$0=pdeef[8],pdeef$d1$1=pdeef[9],pdeef$d1$2=pdeef[10],pdeef$d1$3=pdeef[11],pdeef$d2$0=pdeef[12],pdeef$d2$1=pdeef[13],pdeef$d2$2=pdeef[14],pdeef$d2$3=pdeef[15],pdeef$ad1$0=pdeef[16],pdeef$ad1$1=pdeef[17],pdeef$ad1$2=pdeef[18],pdeef$ad1$3=pdeef[19],pdeef$ad2$0=pdeef[20],pdeef$ad2$1=pdeef[21],pdeef$ad2$2=pdeef[22],pdeef$ad2$3=pdeef[23],psegmentderiv$h$0=psegmentderiv[0],psegmentderiv$h$1=psegmentderiv[1],psegmentderiv$h$2=psegmentderiv[2],psegmentderiv$h$3=psegmentderiv[3],psegmentderiv$d$0=psegmentderiv[4],psegmentderiv$d$1=psegmentderiv[5],psegmentderiv$d$2=psegmentderiv[6],psegmentderiv$d$3=psegmentderiv[7],psegmentderiv$ad$0=psegmentderiv[8],psegmentderiv$ad$1=psegmentderiv[9],psegmentderiv$ad$2=psegmentderiv[10],psegmentderiv$ad$3=psegmentderiv[11],pdifff$h=pdifff[0],pdifff$d=pdifff[1],pdifff$ad=pdifff[2];

// initialisation 
 int auxL64=0,r0=0;
for (int i = 1; i < pdeef$h1$0.length -1; i++) {
 r0=( psegmentderiv$h$0[i]  &  pdeef$h1$0[i] );r0=( r0  | ( psegmentderiv$h$1[i]  &  pdeef$h1$1[i] ));r0=( r0  | ( psegmentderiv$h$2[i]  &  pdeef$h1$2[i] ));r0=( r0  | ( psegmentderiv$h$3[i]  &  pdeef$h1$3[i] ));
 auxL64= r0 ;gradltapex2$h1[i]= auxL64 ;gradltapex2$h2[i]=(~ auxL64  &  pdifff$h[i] );r0=( psegmentderiv$d$0[i]  &  pdeef$d1$0[i] );
 r0=( r0  | ( psegmentderiv$d$1[i]  &  pdeef$d1$1[i] ));r0=( r0  | ( psegmentderiv$d$2[i]  &  pdeef$d1$2[i] ));r0=( r0  | ( psegmentderiv$d$3[i]  &  pdeef$d1$3[i] ));auxL64= r0 ;
 gradltapex2$d1[i]= auxL64 ;gradltapex2$d2[i]=(~ auxL64  &  pdifff$d[i] );r0=( psegmentderiv$ad$0[i]  &  pdeef$ad1$0[i] );r0=( r0  | ( psegmentderiv$ad$1[i]  &  pdeef$ad1$1[i] ));
 r0=( r0  | ( psegmentderiv$ad$2[i]  &  pdeef$ad1$2[i] ));r0=( r0  | ( psegmentderiv$ad$3[i]  &  pdeef$ad1$3[i] ));auxL64= r0 ;gradltapex2$ad1[i]= auxL64 ;
 gradltapex2$ad2[i]=(~ auxL64  &  pdifff$ad[i] );
  }
  ;
p.prepareBit(gradltapex2)
 ;
  }
public static int lt_4_4_1GateCount=45;
 public static void lt_4_4_1(PrShift p,int [][] pdis,int [][] psegment,int [][] gradlt){
 int[] gradlt$h1=gradlt[0],gradlt$h2=gradlt[1],gradlt$d1=gradlt[2],gradlt$d2=gradlt[3],gradlt$ad1=gradlt[4],gradlt$ad2=gradlt[5],pdis$0=pdis[0],pdis$1=pdis[1],pdis$2=pdis[2],pdis$3=pdis[3],psegment$h$0=psegment[0],psegment$h$1=psegment[1],psegment$h$2=psegment[2],psegment$h$3=psegment[3],psegment$d$0=psegment[4],psegment$d$1=psegment[5],psegment$d$2=psegment[6],psegment$d$3=psegment[7],psegment$ad$0=psegment[8],psegment$ad$1=psegment[9],psegment$ad$2=psegment[10],psegment$ad$3=psegment[11];

// initialisation 
 int auxL109$0=0,auxL109$1=0,auxL109$2=0,auxL109$3=0,auxL110$0=0,auxL110$1=0,auxL110$2=0,auxL110$3=0,auxL65=0,auxTmp1$0=0,auxTmp1$1=0,auxTmp1$2=0,auxTmp1$3=0,r0=0,segment$0=0,segment$1=0,segment$2=0,segment$3=0,tmun25$0=0,tmun25$1=0,tmun25$2=0,tmun25$3=0,tmun26$0=0,tmun26$1=0,tmun26$2=0,tmun26$3=0,tmun27=0,tmun28$0=0,tmun28$1=0,tmun28$2=0,tmun28$3=0,tmun29=0,tmun30$0=0,tmun30$1=0,tmun30$2=0,tmun30$3=0,tmun31=0;
for (int i = 1; i < pdis$0.length -1; i++) {
 auxL110$0= pdis$0[i] ;auxL110$1= pdis$1[i] ;auxL110$2= pdis$2[i] ;auxL110$3= pdis$3[i] ;
 auxTmp1$0= auxL109$0 ;auxTmp1$1= auxL109$1 ;auxTmp1$2= auxL109$2 ;auxTmp1$3= auxL109$3 ;
 segment$0= psegment$h$0[i] ;segment$1= psegment$h$1[i] ;segment$2= psegment$h$2[i] ;segment$3= psegment$h$3[i] ;
 r0=( tmun26$0  &  auxTmp1$0 );r0=( r0  | ( tmun26$1  &  auxTmp1$1 ));r0=( r0  | ( tmun26$2  &  auxTmp1$2 ));r0=( r0  | ( tmun26$3  &  auxTmp1$3 ));
 auxL65= r0 ;tmun26$3= segment$3 ;tmun26$2=(~(r0= segment$3 ) &  segment$2 );tmun26$1=(~(r0= segment$2 ) &  segment$1 );
 tmun26$0=(~ segment$1  &  segment$0 );tmun25$0=( auxL110$0  <<  1 );tmun25$1=( auxL110$1  <<  1 );tmun25$2=( auxL110$2  <<  1 );
 tmun25$3=( auxL110$3  <<  1 );gradlt$h1[i-1]= auxL65 ;gradlt$h2[i-1]=(~ auxL65  &  tmun27 );r0= segment$0 ;
 tmun27= r0 ;auxTmp1$0= auxL109$0 ;auxTmp1$1= auxL109$1 ;auxTmp1$2= auxL109$2 ;
 auxTmp1$3= auxL109$3 ;segment$0= psegment$d$0[i] ;segment$1= psegment$d$1[i] ;segment$2= psegment$d$2[i] ;
 segment$3= psegment$d$3[i] ;r0=( tmun28$0  &  auxTmp1$0 );r0=( r0  | ( tmun28$1  &  auxTmp1$1 ));r0=( r0  | ( tmun28$2  &  auxTmp1$2 ));
 r0=( r0  | ( tmun28$3  &  auxTmp1$3 ));auxL65= r0 ;tmun28$3= segment$3 ;tmun28$2=(~(r0= segment$3 ) &  segment$2 );
 tmun28$1=(~(r0= segment$2 ) &  segment$1 );tmun28$0=(~ segment$1  &  segment$0 );gradlt$d1[i-1]= auxL65 ;gradlt$d2[i-1]=(~ auxL65  &  tmun29 );
 r0= segment$0 ;tmun29= r0 ;auxTmp1$0= auxL109$0 ;auxTmp1$1= auxL109$1 ;
 auxTmp1$2= auxL109$2 ;auxTmp1$3= auxL109$3 ;auxL109$0= auxL110$0 ;auxL109$1= auxL110$1 ;
 auxL109$2= auxL110$2 ;auxL109$3= auxL110$3 ;segment$0= psegment$ad$0[i] ;segment$1= psegment$ad$1[i] ;
 segment$2= psegment$ad$2[i] ;segment$3= psegment$ad$3[i] ;r0=( tmun30$0  &  auxTmp1$0 );r0=( r0  | ( tmun30$1  &  auxTmp1$1 ));
 r0=( r0  | ( tmun30$2  &  auxTmp1$2 ));r0=( r0  | ( tmun30$3  &  auxTmp1$3 ));auxL65= r0 ;tmun30$3= segment$3 ;
 tmun30$2=(~(r0= segment$3 ) &  segment$2 );tmun30$1=(~(r0= segment$2 ) &  segment$1 );tmun30$0=(~ segment$1  &  segment$0 );gradlt$ad1[i-1]= auxL65 ;
 gradlt$ad2[i-1]=(~ auxL65  &  tmun31 );r0= segment$0 ;tmun31= r0 ;
  }
  ;
p.prepareBit(gradlt)
 ;
  }
public static int slopDeltaRadius_3_1_1_2_1_1GateCount=329;
 public static void slopDeltaRadius_3_1_1_2_1_1(PrShift p,int [][] pdis,int [][] psrcPropag,int [][] slop,int [][] delta,int [][] level,int [][] resultCA){
 int[] slop$e=slop[0],slop$se=slop[1],slop$sw=slop[2],slop$w=slop[3],slop$nw=slop[4],slop$ne=slop[5],delta$0=delta[0],delta$1=delta[1],level$h=level[0],level$d=level[1],level$ad=level[2],resultCA$h=resultCA[0],resultCA$d=resultCA[1],resultCA$ad=resultCA[2],pdis$0=pdis[0],pdis$1=pdis[1],pdis$2=pdis[2],psrcPropag$e=psrcPropag[0],psrcPropag$se=psrcPropag[1],psrcPropag$sw=psrcPropag[2],psrcPropag$w=psrcPropag[3],psrcPropag$nw=psrcPropag[4],psrcPropag$ne=psrcPropag[5];

// initialisation 
 int auxL102$0=0,auxL102$1=0,auxL102$2=0,auxL103$0=0,auxL103$1=0,auxL103$2=0,auxL104$0=0,auxL104$1=0,auxL104$2=0,auxL105$0=0,auxL105$1=0,auxL105$2=0,auxL106$0=0,auxL106$1=0,auxL106$2=0,auxL106$3=0,auxL106$4=0,auxL106$5=0,auxL106$6=0,auxL107$0=0,auxL107$1=0,auxL108$0=0,auxL108$1=0,auxL108$2=0,auxL108$3=0,auxL59=0,auxL60$0=0,auxL60$1=0,auxL60$2=0,auxL61$0=0,auxL61$1=0,auxL61$2=0,auxO17$0=0,auxO17$1=0,auxO19$0=0,auxO19$1=0,auxO21=0,dis$0=0,dis$1=0,dis$2=0,grad$0=0,grad$1=0,grad$2=0,r0=0,r1=0,r10=0,r11=0,r12=0,r13=0,r14=0,r15=0,r16=0,r17=0,r2=0,r3=0,r4=0,r5=0,r6=0,r7=0,r8=0,r9=0,srcPropag=0,tmun10$0=0,tmun10$1=0,tmun10$2=0,tmun11$0=0,tmun11$1=0,tmun12=0,tmun13$0=0,tmun13$1=0,tmun14=0,tmun15$0=0,tmun15$1=0,tmun16=0,tmun17$0=0,tmun17$1=0,tmun17$2=0,tmun18$0=0,tmun18$1=0,tmun19=0,tmun20$0=0,tmun20$1=0,tmun20$2=0,tmun21$0=0,tmun21$1=0,tmun22=0,tmun23$0=0,tmun23$1=0,tmun24=0;
for (int i = 1; i < pdis$0.length -1; i++) {
 srcPropag= psrcPropag$e[i] ;dis$0= pdis$0[i] ;dis$1= pdis$1[i] ;dis$2= pdis$2[i] ;
 auxL61$0= dis$0 ;auxL61$1=((r0=~ dis$0 ) ^ ~ dis$1 );auxL61$2=(( r0  & ~ dis$1 ) ^ ~ dis$2 );grad$0= tmun10$0 ;
 grad$1= tmun10$1 ;grad$2= tmun10$2 ;tmun10$0=((r0=( auxL61$0  <<  1 )) ^  dis$0 );tmun10$1=(((r1=( dis$0  &  r0 )) ^ (r0=( auxL61$1  <<  1 ))) ^  dis$1 );
 tmun10$2=(((( r1  &  r0 ) | ( dis$1  & ( r1  |  r0 ))) ^ ( auxL61$2  <<  1 )) ^  dis$2 );auxL60$0= grad$0 ;auxL60$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL60$2=(( r0  & ~ grad$1 ) ^ ~ grad$2 );
 r2= auxL60$0 ;r4= auxL60$1 ;r0=(r7= auxL60$2 );r1= r7 ;
 r6= r7 ;r5= r7 ;r3= r7 ;r10=(r8= r2 );
 r10=( r10  | (r8=~ r4 ));r10=( r10  | (r8=~((r9= r4 ) ^  r0 )));r10=( r10  | (r8=~((r9=( r9  |  r0 )) ^  r1 )));r10=( r10  | (r8=~((r9=( r9  |  r1 )) ^  r6 )));
 r10=( r10  | (r8=~((r9=( r9  |  r6 )) ^  r5 )));r10=( r10  | (r8=~(( r9  |  r5 ) ^  r3 )));r7= r8 ;auxO19$0= r10 ;
 auxO19$1= r7 ;r0= auxL60$0 ;r0=( r0  |  auxL60$1 );r0=( r0  |  auxL60$2 );
 r1= auxL60$2 ;auxO17$0=(( tmun12  &  r0 ) |  tmun11$0 );auxO17$1=(( tmun12  &  r1 ) |  tmun11$1 );tmun12= srcPropag ;
 tmun11$0=(r0=~ srcPropag );srcPropag= psrcPropag$w[i] ;r0= auxL60$2 ;auxL59= r0 ;
 slop$e[i-1]= auxL59 ;auxO21= auxL59 ;auxL60$0= grad$0 ;auxL60$1= grad$1 ;
 auxL60$2= grad$2 ;auxL102$0=( auxL60$0  >>>  1 );auxL102$1=( auxL60$1  >>>  1 );auxL102$2=( auxL60$2  >>>  1 );
 r0= auxO17$1 ;r1= auxL102$0 ;r1=( r1  |  auxL102$1 );r1=( r1  |  auxL102$2 );
 r2= auxL102$2 ;r4=(r5=(( tmun14  &  r1 ) |  tmun13$0 ));r5=(( tmun14  &  r2 ) |  tmun13$1 );r3= r5 ;
 r1=( r0  |  r3 );r0= auxO17$0 ;auxO17$0=( r1  | (~ r1  & ( r0  &  r4 )));auxO17$1= r1 ;
 tmun13$0=(r0=~ srcPropag );tmun14= srcPropag ;srcPropag= psrcPropag$se[i] ;r0= auxL60$2 ;
 auxL59= r0 ;slop$w[i-1]=( auxL59  >>>  1 );level$h[i-1]=~( auxO21  |  auxL59 );r0=(r1= grad$0 );
 r0=( r0  | (r1= grad$1 ));r0=( r0  | ~(r1=(r2= grad$2 )));r0=( r0  | ( r1  ^  r2 ));resultCA$h[i-1]=~ r0 ;
 grad$0=( auxL104$0  ^  auxL61$0 );grad$1=(((r0=( auxL61$0  &  auxL104$0 )) ^  auxL104$1 ) ^  auxL61$1 );grad$2=(((( r0  &  auxL104$1 ) | ( auxL61$1  & ( r0  |  auxL104$1 ))) ^  auxL104$2 ) ^  auxL61$2 );auxL60$0= grad$0 ;
 auxL60$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL60$2=(( r0  & ~ grad$1 ) ^ ~ grad$2 );r4= auxL102$0 ;r6= auxL102$1 ;
 r0=(r1= auxL102$2 );r2= r1 ;r7= r1 ;r5= r1 ;
 r3= r1 ;r14= auxL60$0 ;r8= auxL60$1 ;r9=(r10= auxL60$2 );
 r13= r10 ;r11= r10 ;r1= r10 ;r12= r10 ;
 r16=(r10= r14 );r16=( r16  | (r10=~ r8 ));r16=( r16  | (r10=~((r15= r8 ) ^  r9 )));r16=( r16  | (r10=~((r15=( r15  |  r9 )) ^  r13 )));
 r16=( r16  | (r10=~((r15=( r15  |  r13 )) ^  r11 )));r16=( r16  | (r10=~((r15=( r15  |  r11 )) ^  r1 )));r16=( r16  | (r10=~(( r15  |  r1 ) ^  r12 )));r17= r10 ;
 r1= auxO19$1 ;r8= r4 ;r9= r8 ;r8=~ r6 ;
 r9=( r9  |  r8 );r8=~((r11= r6 ) ^  r0 );r9=( r9  |  r8 );r8=~((r11=( r11  |  r0 )) ^  r2 );
 r9=( r9  |  r8 );r8=~((r11=( r11  |  r2 )) ^  r7 );r9=( r9  |  r8 );r8=~((r11=( r11  |  r7 )) ^  r5 );
 r9=( r9  |  r8 );r10=(r8=~(( r11  |  r5 ) ^  r3 ));r9=( r9  |  r8 );r2=(r3= r9 );
 r3= r10 ;r0= r3 ;r3=( r1  &  r0 );r5=(r4= r16 );
 r4= r17 ;r6= r4 ;r4= auxO19$0 ;r8=(r7=( r3  | (~ r3  & ((~ r1  &  r4 ) | (~ r0  &  r2 )))));
 r7= r3 ;r9= r7 ;r0=( r9  &  r6 );auxO19$0=( r0  | (~ r0  & ((~ r9  &  r8 ) | (~ r6  &  r5 ))));
 auxO19$1= r0 ;r0= auxO17$0 ;r1= auxO17$1 ;r2= auxL60$2 ;
 r3= auxL60$0 ;r3=( r3  |  auxL60$1 );r3=( r3  |  auxL60$2 );r5=(( tmun16  &  r3 ) |  tmun15$0 );
 r4= r5 ;r6=(r5=(( tmun16  &  r2 ) |  tmun15$1 ));r2=( r1  |  r6 );auxO17$0=( r2  | (~ r2  & ( r0  &  r4 )));
 auxO17$1= r2 ;tmun16= srcPropag ;tmun15$0=(r0=~ srcPropag );srcPropag= psrcPropag$nw[i] ;
 r0= auxL60$2 ;auxL59= r0 ;slop$se[i-1]= auxL59 ;auxO21= auxL59 ;
 auxL60$0= grad$0 ;auxL60$1= grad$1 ;auxL60$2= grad$2 ;auxL103$0= tmun17$0 ;
 auxL103$1= tmun17$1 ;auxL103$2= tmun17$2 ;tmun17$0= auxL60$0 ;tmun17$1= auxL60$1 ;
 tmun17$2= auxL60$2 ;r0= auxO17$1 ;r1= auxL103$2 ;r2= auxL103$0 ;
 r2=( r2  |  auxL103$1 );r2=( r2  |  auxL103$2 );r3= auxO17$0 ;r4=(( tmun19  &  r2 ) |  tmun18$0 );
 r6= r4 ;r5=(r4=(( tmun19  &  r1 ) |  tmun18$1 ));r1=( r0  |  r5 );auxO17$0=( r1  | (~ r1  & ( r3  &  r6 )));
 auxO17$1= r1 ;tmun19= srcPropag ;tmun18$0=(r0=~ srcPropag );srcPropag= psrcPropag$ne[i] ;
 r0= auxL60$2 ;auxL59= r0 ;slop$nw[i]= auxL59 ;level$d[i-1]=~( auxO21  |  auxL59 );
 r1=(r2= grad$0 );r1=( r1  | (r2= grad$1 ));r1=( r1  | ~(r2=(r0= grad$2 )));r1=( r1  | ( r2  ^  r0 ));
 resultCA$d[i-1]=~ r1 ;grad$0=( auxL104$0  ^ (r1=( auxL61$0  >>>  1 )));grad$1=(((r0=( r1  &  auxL104$0 )) ^  auxL104$1 ) ^ (r1=( auxL61$1  >>>  1 )));grad$2=(((( r0  &  auxL104$1 ) | ( r1  & ( r0  |  auxL104$1 ))) ^  auxL104$2 ) ^ ( auxL61$2  >>>  1 ));
 auxL104$0= dis$0 ;auxL104$1= dis$1 ;auxL104$2= dis$2 ;auxL60$0= grad$0 ;
 auxL60$1= grad$1 ;auxL60$2= grad$2 ;auxL105$0= tmun20$0 ;auxL105$1= tmun20$1 ;
 auxL105$2= tmun20$2 ;tmun20$0=( auxL60$0  <<  1 );tmun20$1=( auxL60$1  <<  1 );tmun20$2=( auxL60$2  <<  1 );
 r0= auxL105$2 ;r1= auxL105$0 ;r1=( r1  |  auxL105$1 );r1=( r1  |  auxL105$2 );
 r2= auxO17$0 ;r3=(r5=(( tmun22  &  r1 ) |  tmun21$0 ));r5=(( tmun22  &  r0 ) |  tmun21$1 );r4= r5 ;
 r0= auxO17$1 ;r1=( r0  |  r4 );auxO17$0=( r1  | (~ r1  & ( r2  &  r3 )));auxO17$1= r1 ;
 tmun21$0=(r0=~ srcPropag );tmun22= srcPropag ;srcPropag= psrcPropag$sw[i] ;r0= auxL60$2 ;
 auxL59= r0 ;slop$ne[i]=( auxL59  <<  1 );auxO21= auxL59 ;auxL60$0= grad$0 ;
 auxL60$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL60$2=(( r0  & ~ grad$1 ) ^ ~ grad$2 );r1= auxL105$0 ;r4= auxL105$1 ;
 r7=(r2= auxL105$2 );r5= r2 ;r6= r2 ;r3= r2 ;
 r0= r2 ;r2= auxO19$0 ;r8= auxL60$0 ;r8=( r8  |  auxL60$1 );
 r8=( r8  |  auxL60$2 );r9= auxL60$2 ;r10=(r11=(( tmun24  &  r8 ) |  tmun23$0 ));r11=(( tmun24  &  r9 ) |  tmun23$1 );
 r12= r11 ;r9= r1 ;r11= r9 ;r9=~ r4 ;
 r11=( r11  |  r9 );r9=~((r8= r4 ) ^  r7 );r11=( r11  |  r9 );r9=~((r8=( r8  |  r7 )) ^  r5 );
 r11=( r11  |  r9 );r9=~((r8=( r8  |  r5 )) ^  r6 );r11=( r11  |  r9 );r9=~((r8=( r8  |  r6 )) ^  r3 );
 r11=( r11  |  r9 );r13=(r9=~(( r8  |  r3 ) ^  r0 ));r11=( r11  |  r9 );r3=(r0= r11 );
 r0= r13 ;r1= r0 ;r0= auxO19$1 ;r4= auxO17$0 ;
 r11= auxL103$0 ;r6= auxL103$1 ;r8=(r13= auxL103$2 );r7= r13 ;
 r5= r13 ;r14= r13 ;r9= r13 ;r13=(r15= r11 );
 r13=( r13  | (r15=~ r6 ));r13=( r13  | (r15=~((r16= r6 ) ^  r8 )));r13=( r13  | (r15=~((r16=( r16  |  r8 )) ^  r7 )));r13=( r13  | (r15=~((r16=( r16  |  r7 )) ^  r5 )));
 r13=( r13  | (r15=~((r16=( r16  |  r5 )) ^  r14 )));r13=( r13  | (r15=~(( r16  |  r14 ) ^  r9 )));r17= r15 ;r7=(r5= r13 );
 r5= r17 ;r6= r5 ;r5=( r0  &  r6 );r8=(r11=( r5  | (~ r5  & ((~ r0  &  r2 ) | (~ r6  &  r7 )))));
 r11= r5 ;r9= r11 ;r0=( r9  &  r1 );r2=(r6=( r0  | (~ r0  & ((~ r9  &  r8 ) | (~ r1  &  r3 )))));
 r6= r0 ;r5= r6 ;r0= auxO17$1 ;r1=( r0  |  r12 );
 r0=(r6=( r1  | (~ r1  & ( r4  &  r10 ))));r6= r1 ;r3= r6 ;r4= auxL60$0 ;
 r11= auxL60$1 ;r9=(r1= auxL60$2 );r7= r1 ;r8= r1 ;
 r10= r1 ;r6= r1 ;r13=(r1= r4 );r13=( r13  | (r1=~ r11 ));
 r13=( r13  | (r1=~((r12= r11 ) ^  r9 )));r13=( r13  | (r1=~((r12=( r12  |  r9 )) ^  r7 )));r13=( r13  | (r1=~((r12=( r12  |  r7 )) ^  r8 )));r13=( r13  | (r1=~((r12=( r12  |  r8 )) ^  r10 )));
 r13=( r13  | (r1=~(( r12  |  r10 ) ^  r6 )));r14= r1 ;r4=(r6= r13 );r6= r14 ;
 r1= r6 ;r6=( r5  &  r1 );r7=(r9=( r6  | (~ r6  & ((~ r5  &  r2 ) | (~ r1  &  r4 )))));r9= r6 ;
 r8= r9 ;r1=( r8  &  r3 );delta$0[i-1]=( r1  | (~ r1  & ((~ r8  &  r7 ) | (~ r3  &  r0 ))));delta$1[i-1]= r1 ;
 tmun23$0=(r0=~ srcPropag );tmun24= srcPropag ;r0= auxL60$2 ;auxL59= r0 ;
 slop$sw[i-1]= auxL59 ;level$ad[i-1]=~( auxO21  |  auxL59 );r1=(r0= grad$0 );r1=( r1  | (r0= grad$1 ));
 r1=( r1  | ~(r0=(r2= grad$2 )));r1=( r1  | ( r0  ^  r2 ));resultCA$ad[i-1]=~ r1 ;
  }
  p.mirror(delta);
p.prepareBit(slop);p.prepareBit(delta);p.prepareBit(level);p.prepareBit(resultCA)
 ;
  }
public static int slopDeltaDist_3_1_2_1_1GateCount=203;
 public static void slopDeltaDist_3_1_2_1_1(PrShift p,int [][] pdis,int [][] slop,int [][] deltaR,int [][] level,int [][] resultCA){
 int[] slop$e=slop[0],slop$se=slop[1],slop$sw=slop[2],slop$w=slop[3],slop$nw=slop[4],slop$ne=slop[5],deltaR$0=deltaR[0],deltaR$1=deltaR[1],level$h=level[0],level$d=level[1],level$ad=level[2],resultCA$h=resultCA[0],resultCA$d=resultCA[1],resultCA$ad=resultCA[2],pdis$0=pdis[0],pdis$1=pdis[1],pdis$2=pdis[2];

// initialisation 
 int auxL111$0=0,auxL111$1=0,auxL111$2=0,auxL112$0=0,auxL112$1=0,auxL112$2=0,auxL112$3=0,auxL112$4=0,auxL112$5=0,auxL112$6=0,auxL113$0=0,auxL113$1=0,auxL113$2=0,auxL113$3=0,auxL61$0=0,auxL61$1=0,auxL61$2=0,auxL62=0,auxL63$0=0,auxL63$1=0,auxL63$2=0,auxO14=0,delta$0=0,delta$1=0,dis$0=0,dis$1=0,dis$2=0,grad$0=0,grad$1=0,grad$2=0,r0=0,r1=0,r10=0,r11=0,r12=0,r2=0,r3=0,r4=0,r5=0,r6=0,r7=0,r8=0,r9=0,tmun32$0=0,tmun32$1=0,tmun32$2=0,tmun33$0=0,tmun33$1=0,tmun33$2=0,tmun34$0=0,tmun34$1=0,tmun34$2=0;
for (int i = 1; i < pdis$0.length -1; i++) {
 dis$0= pdis$0[i] ;dis$1= pdis$1[i] ;dis$2= pdis$2[i] ;auxL61$0= dis$0 ;
 auxL61$1=((r0=~ dis$0 ) ^ ~ dis$1 );auxL61$2=(( r0  & ~ dis$1 ) ^ ~ dis$2 );grad$0= tmun32$0 ;grad$1= tmun32$1 ;
 grad$2= tmun32$2 ;tmun32$0=((r0=( auxL61$0  <<  1 )) ^  dis$0 );tmun32$1=(((r1=( dis$0  &  r0 )) ^ (r0=( auxL61$1  <<  1 ))) ^  dis$1 );tmun32$2=(((( r1  &  r0 ) | ( dis$1  & ( r1  |  r0 ))) ^ ( auxL61$2  <<  1 )) ^  dis$2 );
 auxL63$0= grad$0 ;auxL63$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL63$2=(( r0  & ~ grad$1 ) ^ ~ grad$2 );r6= auxL63$0 ;
 r4= auxL63$1 ;r2=(r0= auxL63$2 );r5= r0 ;r7= r0 ;
 r1= r0 ;r3= r0 ;r8= r6 ;r9= r8 ;
 r8=~ r4 ;r9=( r9  |  r8 );r8=((r10= r4 ) ^  r2 );r9=( r9  |  r8 );
 r8=((r10=( r10  &  r2 )) ^  r5 );r9=( r9  |  r8 );r8=((r10=( r10  &  r5 )) ^  r7 );r9=( r9  |  r8 );
 r8=((r10=( r10  &  r7 )) ^  r1 );r9=( r9  |  r8 );r0=(r8=(( r10  &  r1 ) ^  r3 ));r9=( r9  |  r8 );
 delta$0= r9 ;delta$1= r0 ;r0= auxL63$2 ;auxL62= r0 ;
 slop$e[i-1]= auxL62 ;auxO14= auxL62 ;auxL63$0= grad$0 ;auxL63$1= grad$1 ;
 auxL63$2= grad$2 ;r0= delta$0 ;r5=( auxL63$0  >>>  1 );r6=( auxL63$1  >>>  1 );
 r1=(r2=( auxL63$2  >>>  1 ));r7= r2 ;r4= r2 ;r3= r2 ;
 r8= r2 ;r2= delta$1 ;r11= r5 ;r9= r11 ;
 r11=~ r6 ;r9=( r9  |  r11 );r11=((r12= r6 ) ^  r1 );r9=( r9  |  r11 );
 r11=((r12=( r12  &  r1 )) ^  r7 );r9=( r9  |  r11 );r11=((r12=( r12  &  r7 )) ^  r4 );r9=( r9  |  r11 );
 r11=((r12=( r12  &  r4 )) ^  r3 );r9=( r9  |  r11 );r10=(r11=(( r12  &  r3 ) ^  r8 ));r9=( r9  |  r11 );
 r3=(r4= r9 );r4= r10 ;r1= r4 ;r4=( r2  |  r1 );
 delta$0=( r4  | (~ r4  & ( r0  &  r3 )));delta$1= r4 ;r0= auxL63$2 ;auxL62= r0 ;
 slop$w[i-1]=( auxL62  >>>  1 );level$h[i-1]=~( auxO14  |  auxL62 );r1=(r0= grad$0 );r1=( r1  | (r0= grad$1 ));
 r1=( r1  | ~(r0=(r2= grad$2 )));r1=( r1  | ( r0  ^  r2 ));resultCA$h[i-1]=~ r1 ;grad$0=( auxL111$0  ^  auxL61$0 );
 grad$1=(((r0=( auxL61$0  &  auxL111$0 )) ^  auxL111$1 ) ^  auxL61$1 );grad$2=(((( r0  &  auxL111$1 ) | ( auxL61$1  & ( r0  |  auxL111$1 ))) ^  auxL111$2 ) ^  auxL61$2 );auxL63$0= grad$0 ;auxL63$1=((r0=~ grad$0 ) ^ ~ grad$1 );
 auxL63$2=(( r0  & ~ grad$1 ) ^ ~ grad$2 );r0= delta$1 ;r1= delta$0 ;r9= auxL63$0 ;
 r2= auxL63$1 ;r3=(r6= auxL63$2 );r5= r6 ;r8= r6 ;
 r7= r6 ;r4= r6 ;r11= r9 ;r12= r11 ;
 r11=~ r2 ;r12=( r12  |  r11 );r11=((r6= r2 ) ^  r3 );r12=( r12  |  r11 );
 r11=((r6=( r6  &  r3 )) ^  r5 );r12=( r12  |  r11 );r11=((r6=( r6  &  r5 )) ^  r8 );r12=( r12  |  r11 );
 r11=((r6=( r6  &  r8 )) ^  r7 );r12=( r12  |  r11 );r10=(r11=(( r6  &  r7 ) ^  r4 ));r12=( r12  |  r11 );
 r4= r12 ;r3= r4 ;r2=(r4= r10 );r4=( r0  |  r2 );
 delta$0=( r4  | (~ r4  & ( r1  &  r3 )));delta$1= r4 ;r0= auxL63$2 ;auxL62= r0 ;
 slop$se[i-1]= auxL62 ;auxO14= auxL62 ;auxL63$0= grad$0 ;auxL63$1= grad$1 ;
 auxL63$2= grad$2 ;r0= delta$1 ;r3= tmun33$0 ;r6= tmun33$1 ;
 r8=(r7= tmun33$2 );r1= r7 ;r4= r7 ;r5= r7 ;
 r2= r7 ;r10=(r9= r3 );r10=( r10  | (r9=~ r6 ));r10=( r10  | (r9=((r11= r6 ) ^  r8 )));
 r10=( r10  | (r9=((r11=( r11  &  r8 )) ^  r1 )));r10=( r10  | (r9=((r11=( r11  &  r1 )) ^  r4 )));r10=( r10  | (r9=((r11=( r11  &  r4 )) ^  r5 )));r10=( r10  | (r9=(( r11  &  r5 ) ^  r2 )));
 r7= r9 ;r1= delta$0 ;r3=(r4= r10 );r4= r7 ;
 r2= r4 ;r4=( r0  |  r2 );delta$0=( r4  | (~ r4  & ( r1  &  r3 )));delta$1= r4 ;
 tmun33$0= auxL63$0 ;tmun33$1= auxL63$1 ;tmun33$2= auxL63$2 ;r0= auxL63$2 ;
 auxL62= r0 ;slop$nw[i]= auxL62 ;level$d[i-1]=~( auxO14  |  auxL62 );r2=(r0= grad$0 );
 r2=( r2  | (r0= grad$1 ));r2=( r2  | ~(r0=(r1= grad$2 )));r2=( r2  | ( r0  ^  r1 ));resultCA$d[i-1]=~ r2 ;
 grad$0=( auxL111$0  ^ (r0=( auxL61$0  >>>  1 )));grad$1=(((r1=( r0  &  auxL111$0 )) ^  auxL111$1 ) ^ (r0=( auxL61$1  >>>  1 )));grad$2=(((( r1  &  auxL111$1 ) | ( r0  & ( r1  |  auxL111$1 ))) ^  auxL111$2 ) ^ ( auxL61$2  >>>  1 ));auxL111$0= dis$0 ;
 auxL111$1= dis$1 ;auxL111$2= dis$2 ;auxL63$0= grad$0 ;auxL63$1= grad$1 ;
 auxL63$2= grad$2 ;r3= tmun34$0 ;r5= tmun34$1 ;r7=(r0= tmun34$2 );
 r1= r0 ;r2= r0 ;r4= r0 ;r6= r0 ;
 r0= delta$1 ;r10=(r9= r3 );r10=( r10  | (r9=~ r5 ));r10=( r10  | (r9=((r8= r5 ) ^  r7 )));
 r10=( r10  | (r9=((r8=( r8  &  r7 )) ^  r1 )));r10=( r10  | (r9=((r8=( r8  &  r1 )) ^  r2 )));r10=( r10  | (r9=((r8=( r8  &  r2 )) ^  r4 )));r10=( r10  | (r9=(( r8  &  r4 ) ^  r6 )));
 r11= r9 ;r2= r10 ;r1= r2 ;r3=(r2= r11 );
 r2=( r0  |  r3 );r0= delta$0 ;delta$0=( r2  | (~ r2  & ( r0  &  r1 )));delta$1= r2 ;
 tmun34$0=( auxL63$0  <<  1 );tmun34$1=( auxL63$1  <<  1 );tmun34$2=( auxL63$2  <<  1 );r0= auxL63$2 ;
 auxL62= r0 ;slop$ne[i]=( auxL62  <<  1 );auxO14= auxL62 ;auxL63$0= grad$0 ;
 auxL63$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL63$2=(( r0  & ~ grad$1 ) ^ ~ grad$2 );r7= auxL63$0 ;r1= auxL63$1 ;
 r3=(r5= auxL63$2 );r4= r5 ;r6= r5 ;r0= r5 ;
 r2= r5 ;r5= delta$1 ;r8= delta$0 ;r10= r7 ;
 r9= r10 ;r10=~ r1 ;r9=( r9  |  r10 );r10=((r11= r1 ) ^  r3 );
 r9=( r9  |  r10 );r10=((r11=( r11  &  r3 )) ^  r4 );r9=( r9  |  r10 );r10=((r11=( r11  &  r4 )) ^  r6 );
 r9=( r9  |  r10 );r10=((r11=( r11  &  r6 )) ^  r0 );r9=( r9  |  r10 );r12=(r10=(( r11  &  r0 ) ^  r2 ));
 r9=( r9  |  r10 );r2= r9 ;r0= r2 ;r1=(r2= r12 );
 r2=( r5  |  r1 );deltaR$0[i-1]=( r2  | (~ r2  & ( r8  &  r0 )));deltaR$1[i-1]= r2 ;r0= auxL63$2 ;
 auxL62= r0 ;slop$sw[i-1]= auxL62 ;level$ad[i-1]=~( auxO14  |  auxL62 );r0=(r2= grad$0 );
 r0=( r0  | (r2= grad$1 ));r0=( r0  | ~(r2=(r1= grad$2 )));r0=( r0  | ( r2  ^  r1 ));resultCA$ad[i-1]=~ r0 ;
  }
  p.mirror(deltaR);
p.prepareBit(slop);p.prepareBit(deltaR);p.prepareBit(level);p.prepareBit(resultCA)
 ;
  }}