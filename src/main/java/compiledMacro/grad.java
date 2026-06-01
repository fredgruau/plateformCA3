package compiledMacro;
 import simulator.PrShift;
 public class grad{
 
public static int slopDeltaDist_4_1_2_1_1GateCount=237;
 public static void slopDeltaDist_4_1_2_1_1(PrShift p,int [][] pdis,int [][] slop,int [][] deltaR,int [][] level,int [][] resultCA){
 int[] slop$e=slop[0],slop$se=slop[1],slop$sw=slop[2],slop$w=slop[3],slop$nw=slop[4],slop$ne=slop[5],deltaR$0=deltaR[0],deltaR$1=deltaR[1],level$h=level[0],level$d=level[1],level$ad=level[2],resultCA$h=resultCA[0],resultCA$d=resultCA[1],resultCA$ad=resultCA[2],pdis$0=pdis[0],pdis$1=pdis[1],pdis$2=pdis[2],pdis$3=pdis[3];

// initialisation 
 int auxL115$0=0,auxL115$1=0,auxL115$2=0,auxL115$3=0,auxL116$0=0,auxL116$1=0,auxL116$2=0,auxL116$3=0,auxL116$4=0,auxL116$5=0,auxL116$6=0,auxL117$0=0,auxL117$1=0,auxL117$2=0,auxL117$3=0,auxL74$0=0,auxL74$1=0,auxL74$2=0,auxL74$3=0,auxL80=0,auxL81$0=0,auxL81$1=0,auxL81$2=0,auxL81$3=0,auxO09=0,delta$0=0,delta$1=0,dis$0=0,dis$1=0,dis$2=0,dis$3=0,grad$0=0,grad$1=0,grad$2=0,grad$3=0,r0=0,r1=0,r10=0,r11=0,r12=0,r2=0,r3=0,r4=0,r5=0,r6=0,r7=0,r8=0,r9=0,tmun12$0=0,tmun12$1=0,tmun12$2=0,tmun12$3=0,tmun13$0=0,tmun13$1=0,tmun13$2=0,tmun13$3=0,tmun14$0=0,tmun14$1=0,tmun14$2=0,tmun14$3=0;
for (int i = 1; i < pdis$0.length -1; i++) {
 dis$0= pdis$0[i] ;dis$1= pdis$1[i] ;dis$2= pdis$2[i] ;dis$3= pdis$3[i] ;
 auxL74$0= dis$0 ;auxL74$1=((r0=~ dis$0 ) ^ ~ dis$1 );auxL74$2=((r0=( r0  & ~ dis$1 )) ^ ~ dis$2 );auxL74$3=(( r0  & ~ dis$2 ) ^ ~ dis$3 );
 grad$0= tmun12$0 ;grad$1= tmun12$1 ;grad$2= tmun12$2 ;grad$3= tmun12$3 ;
 tmun12$0=((r0=( auxL74$0  <<  1 )) ^  dis$0 );tmun12$1=(((r1=( dis$0  &  r0 )) ^ (r0=( auxL74$1  <<  1 ))) ^  dis$1 );tmun12$2=(((r1=(( r1  &  r0 ) | ( dis$1  & ( r1  |  r0 )))) ^ (r0=( auxL74$2  <<  1 ))) ^  dis$2 );tmun12$3=(((( r1  &  r0 ) | ( dis$2  & ( r1  |  r0 ))) ^ ( auxL74$3  <<  1 )) ^  dis$3 );
 auxL81$0= grad$0 ;auxL81$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL81$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );auxL81$3=(( r0  & ~ grad$2 ) ^ ~ grad$3 );
 r3= auxL81$0 ;r0= auxL81$1 ;r1= auxL81$2 ;r6=(r5= auxL81$3 );
 r2= r5 ;r4= r5 ;r7= r5 ;r5= r3 ;
 r10= r5 ;r5=~ r0 ;r10=( r10  |  r5 );r5=((r8= r0 ) ^  r1 );
 r10=( r10  |  r5 );r5=((r8=( r8  &  r1 )) ^  r6 );r10=( r10  |  r5 );r5=((r8=( r8  &  r6 )) ^  r2 );
 r10=( r10  |  r5 );r5=((r8=( r8  &  r2 )) ^  r4 );r10=( r10  |  r5 );r9=(r5=(( r8  &  r4 ) ^  r7 ));
 r10=( r10  |  r5 );delta$0= r10 ;delta$1= r9 ;r0= auxL81$3 ;
 auxL80= r0 ;slop$e[i-1]= auxL80 ;auxO09= auxL80 ;auxL81$0= grad$0 ;
 auxL81$1= grad$1 ;auxL81$2= grad$2 ;auxL81$3= grad$3 ;r0= delta$0 ;
 r1= delta$1 ;r9=( auxL81$0  >>>  1 );r6=( auxL81$1  >>>  1 );r5=( auxL81$2  >>>  1 );
 r2=(r8=( auxL81$3  >>>  1 ));r4= r8 ;r3= r8 ;r7= r8 ;
 r10=(r11= r9 );r10=( r10  | (r11=~ r6 ));r10=( r10  | (r11=((r12= r6 ) ^  r5 )));r10=( r10  | (r11=((r12=( r12  &  r5 )) ^  r2 )));
 r10=( r10  | (r11=((r12=( r12  &  r2 )) ^  r4 )));r10=( r10  | (r11=((r12=( r12  &  r4 )) ^  r3 )));r10=( r10  | (r11=(( r12  &  r3 ) ^  r7 )));r8= r11 ;
 r2=(r4= r10 );r4= r8 ;r3= r4 ;r4=( r1  |  r3 );
 delta$0=( r4  | (~ r4  & ( r0  &  r2 )));delta$1= r4 ;r0= auxL81$3 ;auxL80= r0 ;
 slop$w[i-1]=( auxL80  >>>  1 );level$h[i-1]=~( auxO09  |  auxL80 );r0= grad$0 ;r0=( r0  |  grad$1 );
 r0=( r0  | ~ grad$2 );r0=( r0  | ( grad$2  ^  grad$3 ));resultCA$h[i-1]=~ r0 ;grad$0=( auxL115$0  ^  auxL74$0 );
 grad$1=(((r0=( auxL74$0  &  auxL115$0 )) ^  auxL115$1 ) ^  auxL74$1 );grad$2=(((r0=(( r0  &  auxL115$1 ) | ( auxL74$1  & ( r0  |  auxL115$1 )))) ^  auxL115$2 ) ^  auxL74$2 );grad$3=(((( r0  &  auxL115$2 ) | ( auxL74$2  & ( r0  |  auxL115$2 ))) ^  auxL115$3 ) ^  auxL74$3 );auxL81$0= grad$0 ;
 auxL81$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL81$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );auxL81$3=(( r0  & ~ grad$2 ) ^ ~ grad$3 );r3= auxL81$0 ;
 r1= auxL81$1 ;r0= auxL81$2 ;r4=(r7= auxL81$3 );r6= r7 ;
 r2= r7 ;r5= r7 ;r7= delta$1 ;r8= delta$0 ;
 r12=(r9= r3 );r12=( r12  | (r9=~ r1 ));r12=( r12  | (r9=((r11= r1 ) ^  r0 )));r12=( r12  | (r9=((r11=( r11  &  r0 )) ^  r4 )));
 r12=( r12  | (r9=((r11=( r11  &  r4 )) ^  r6 )));r12=( r12  | (r9=((r11=( r11  &  r6 )) ^  r2 )));r12=( r12  | (r9=(( r11  &  r2 ) ^  r5 )));r10= r9 ;
 r2=(r0= r12 );r0= r10 ;r1= r0 ;r0=( r7  |  r1 );
 delta$0=( r0  | (~ r0  & ( r8  &  r2 )));delta$1= r0 ;r0= auxL81$3 ;auxL80= r0 ;
 slop$se[i-1]= auxL80 ;auxO09= auxL80 ;auxL81$0= grad$0 ;auxL81$1= grad$1 ;
 auxL81$2= grad$2 ;auxL81$3= grad$3 ;r0= delta$1 ;r3= tmun13$0 ;
 r1= tmun13$1 ;r7= tmun13$2 ;r6=(r4= tmun13$3 );r8= r4 ;
 r2= r4 ;r5= r4 ;r4= delta$0 ;r12= r3 ;
 r9= r12 ;r12=~ r1 ;r9=( r9  |  r12 );r12=((r11= r1 ) ^  r7 );
 r9=( r9  |  r12 );r12=((r11=( r11  &  r7 )) ^  r6 );r9=( r9  |  r12 );r12=((r11=( r11  &  r6 )) ^  r8 );
 r9=( r9  |  r12 );r12=((r11=( r11  &  r8 )) ^  r2 );r9=( r9  |  r12 );r10=(r12=(( r11  &  r2 ) ^  r5 ));
 r9=( r9  |  r12 );r1= r9 ;r3= r1 ;r2=(r1= r10 );
 r1=( r0  |  r2 );delta$0=( r1  | (~ r1  & ( r4  &  r3 )));delta$1= r1 ;tmun13$0= auxL81$0 ;
 tmun13$1= auxL81$1 ;tmun13$2= auxL81$2 ;tmun13$3= auxL81$3 ;r0= auxL81$3 ;
 auxL80= r0 ;slop$nw[i]= auxL80 ;level$d[i-1]=~( auxO09  |  auxL80 );r0= grad$0 ;
 r0=( r0  |  grad$1 );r0=( r0  | ~ grad$2 );r0=( r0  | ( grad$2  ^  grad$3 ));resultCA$d[i-1]=~ r0 ;
 grad$0=( auxL115$0  ^ (r1=( auxL74$0  >>>  1 )));grad$1=(((r0=( r1  &  auxL115$0 )) ^  auxL115$1 ) ^ (r1=( auxL74$1  >>>  1 )));grad$2=(((r0=(( r0  &  auxL115$1 ) | ( r1  & ( r0  |  auxL115$1 )))) ^  auxL115$2 ) ^ (r1=( auxL74$2  >>>  1 )));grad$3=(((( r0  &  auxL115$2 ) | ( r1  & ( r0  |  auxL115$2 ))) ^  auxL115$3 ) ^ ( auxL74$3  >>>  1 ));
 auxL115$0= dis$0 ;auxL115$1= dis$1 ;auxL115$2= dis$2 ;auxL115$3= dis$3 ;
 auxL81$0= grad$0 ;auxL81$1= grad$1 ;auxL81$2= grad$2 ;auxL81$3= grad$3 ;
 r0= delta$1 ;r3= tmun14$0 ;r7= tmun14$1 ;r5= tmun14$2 ;
 r4=(r2= tmun14$3 );r1= r2 ;r6= r2 ;r8= r2 ;
 r10=(r9= r3 );r10=( r10  | (r9=~ r7 ));r10=( r10  | (r9=((r2= r7 ) ^  r5 )));r10=( r10  | (r9=((r2=( r2  &  r5 )) ^  r4 )));
 r10=( r10  | (r9=((r2=( r2  &  r4 )) ^  r1 )));r10=( r10  | (r9=((r2=( r2  &  r1 )) ^  r6 )));r10=( r10  | (r9=(( r2  &  r6 ) ^  r8 )));r11= r9 ;
 r2= r10 ;r1= r2 ;r3=(r2= r11 );r2=( r0  |  r3 );
 r0= delta$0 ;delta$0=( r2  | (~ r2  & ( r0  &  r1 )));delta$1= r2 ;tmun14$0=( auxL81$0  <<  1 );
 tmun14$1=( auxL81$1  <<  1 );tmun14$2=( auxL81$2  <<  1 );tmun14$3=( auxL81$3  <<  1 );r0= auxL81$3 ;
 auxL80= r0 ;slop$ne[i]=( auxL80  <<  1 );auxO09= auxL80 ;auxL81$0= grad$0 ;
 auxL81$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL81$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );auxL81$3=(( r0  & ~ grad$2 ) ^ ~ grad$3 );r0= delta$0 ;
 r4= auxL81$0 ;r3= auxL81$1 ;r8= auxL81$2 ;r2=(r7= auxL81$3 );
 r6= r7 ;r5= r7 ;r1= r7 ;r7= delta$1 ;
 r10=(r11= r4 );r10=( r10  | (r11=~ r3 ));r10=( r10  | (r11=((r9= r3 ) ^  r8 )));r10=( r10  | (r11=((r9=( r9  &  r8 )) ^  r2 )));
 r10=( r10  | (r11=((r9=( r9  &  r2 )) ^  r6 )));r10=( r10  | (r11=((r9=( r9  &  r6 )) ^  r5 )));r10=( r10  | (r11=(( r9  &  r5 ) ^  r1 )));r12= r11 ;
 r1= r10 ;r3= r1 ;r2=(r1= r12 );r1=( r7  |  r2 );
 deltaR$0[i-1]=( r1  | (~ r1  & ( r0  &  r3 )));deltaR$1[i-1]= r1 ;r0= auxL81$3 ;auxL80= r0 ;
 slop$sw[i-1]= auxL80 ;level$ad[i-1]=~( auxO09  |  auxL80 );r0= grad$0 ;r0=( r0  |  grad$1 );
 r0=( r0  | ~ grad$2 );r0=( r0  | ( grad$2  ^  grad$3 ));resultCA$ad[i-1]=~ r0 ;
  }
  p.mirror(deltaR);
p.prepareBit(slop);p.prepareBit(deltaR);p.prepareBit(level);p.prepareBit(resultCA)
 ;
  }
public static int slopGradGap_4_1_4GateCount=92;
 public static void slopGradGap_4_1_4(PrShift p,int [][] pdiiiis,int [][] resultCA,int [][] auxL77){
 int[] resultCA$e=resultCA[0],resultCA$se=resultCA[1],resultCA$sw=resultCA[2],resultCA$w=resultCA[3],resultCA$nw=resultCA[4],resultCA$ne=resultCA[5],auxL77$h1$0=auxL77[0],auxL77$h1$1=auxL77[1],auxL77$h1$2=auxL77[2],auxL77$h1$3=auxL77[3],auxL77$h2$0=auxL77[4],auxL77$h2$1=auxL77[5],auxL77$h2$2=auxL77[6],auxL77$h2$3=auxL77[7],auxL77$d1$0=auxL77[8],auxL77$d1$1=auxL77[9],auxL77$d1$2=auxL77[10],auxL77$d1$3=auxL77[11],auxL77$d2$0=auxL77[12],auxL77$d2$1=auxL77[13],auxL77$d2$2=auxL77[14],auxL77$d2$3=auxL77[15],auxL77$ad1$0=auxL77[16],auxL77$ad1$1=auxL77[17],auxL77$ad1$2=auxL77[18],auxL77$ad1$3=auxL77[19],auxL77$ad2$0=auxL77[20],auxL77$ad2$1=auxL77[21],auxL77$ad2$2=auxL77[22],auxL77$ad2$3=auxL77[23],pdiiiis$0=pdiiiis[0],pdiiiis$1=pdiiiis[1],pdiiiis$2=pdiiiis[2],pdiiiis$3=pdiiiis[3];

// initialisation 
 int auxL143$0=0,auxL143$1=0,auxL143$2=0,auxL143$3=0,auxL78$0=0,auxL78$1=0,auxL78$2=0,auxL78$3=0,auxL79$0=0,auxL79$1=0,auxL79$2=0,auxL79$3=0,diiiis$0=0,diiiis$1=0,diiiis$2=0,diiiis$3=0,r0=0,r1=0,tmun53$0=0,tmun53$1=0,tmun53$2=0,tmun53$3=0;
for (int i = 1; i < pdiiiis$0.length -1; i++) {
 diiiis$0= pdiiiis$0[i] ;diiiis$1= pdiiiis$1[i] ;diiiis$2= pdiiiis$2[i] ;diiiis$3= pdiiiis$3[i] ;
 auxL79$0= diiiis$0 ;auxL79$1=((r0=~ diiiis$0 ) ^ ~ diiiis$1 );auxL79$2=((r0=( r0  & ~ diiiis$1 )) ^ ~ diiiis$2 );auxL79$3=(( r0  & ~ diiiis$2 ) ^ ~ diiiis$3 );
 auxL78$0= tmun53$0 ;auxL78$1= tmun53$1 ;auxL78$2= tmun53$2 ;auxL78$3= tmun53$3 ;
 tmun53$0=((r1=( auxL79$0  <<  1 )) ^  diiiis$0 );tmun53$1=(((r0=( diiiis$0  &  r1 )) ^ (r1=( auxL79$1  <<  1 ))) ^  diiiis$1 );tmun53$2=(((r0=(( r0  &  r1 ) | ( diiiis$1  & ( r0  |  r1 )))) ^ (r1=( auxL79$2  <<  1 ))) ^  diiiis$2 );tmun53$3=(((( r0  &  r1 ) | ( diiiis$2  & ( r0  |  r1 ))) ^ ( auxL79$3  <<  1 )) ^  diiiis$3 );
 auxL77$h1$0[i-1]= auxL78$0 ;auxL77$h1$1[i-1]=((r0=~ auxL78$0 ) ^ ~ auxL78$1 );auxL77$h1$2[i-1]=((r0=( r0  & ~ auxL78$1 )) ^ ~ auxL78$2 );auxL77$h1$3[i-1]=(( r0  & ~ auxL78$2 ) ^ ~ auxL78$3 );
 r0= auxL77$h1$3[i-1] ;resultCA$e[i-1]= r0 ;auxL77$h2$0[i-1]= auxL78$0 ;auxL77$h2$1[i-1]= auxL78$1 ;
 auxL77$h2$2[i-1]= auxL78$2 ;auxL77$h2$3[i-1]= auxL78$3 ;r0= auxL77$h2$3[i-1] ;resultCA$w[i-1]=( r0  >>>  1 );
 auxL78$0=( auxL143$0  ^  auxL79$0 );auxL78$1=(((r0=( auxL79$0  &  auxL143$0 )) ^  auxL143$1 ) ^  auxL79$1 );auxL78$2=(((r0=(( r0  &  auxL143$1 ) | ( auxL79$1  & ( r0  |  auxL143$1 )))) ^  auxL143$2 ) ^  auxL79$2 );auxL78$3=(((( r0  &  auxL143$2 ) | ( auxL79$2  & ( r0  |  auxL143$2 ))) ^  auxL143$3 ) ^  auxL79$3 );
 auxL77$d1$0[i-1]= auxL78$0 ;auxL77$d1$1[i-1]=((r0=~ auxL78$0 ) ^ ~ auxL78$1 );auxL77$d1$2[i-1]=((r0=( r0  & ~ auxL78$1 )) ^ ~ auxL78$2 );auxL77$d1$3[i-1]=(( r0  & ~ auxL78$2 ) ^ ~ auxL78$3 );
 r0= auxL77$d1$3[i-1] ;resultCA$se[i-1]= r0 ;auxL77$d2$0[i-1]= auxL78$0 ;auxL77$d2$1[i-1]= auxL78$1 ;
 auxL77$d2$2[i-1]= auxL78$2 ;auxL77$d2$3[i-1]= auxL78$3 ;r0= auxL77$d2$3[i-1] ;resultCA$nw[i]= r0 ;
 auxL78$0=( auxL143$0  ^ (r0=( auxL79$0  >>>  1 )));auxL78$1=(((r1=( r0  &  auxL143$0 )) ^  auxL143$1 ) ^ (r0=( auxL79$1  >>>  1 )));auxL78$2=(((r1=(( r1  &  auxL143$1 ) | ( r0  & ( r1  |  auxL143$1 )))) ^  auxL143$2 ) ^ (r0=( auxL79$2  >>>  1 )));auxL78$3=(((( r1  &  auxL143$2 ) | ( r0  & ( r1  |  auxL143$2 ))) ^  auxL143$3 ) ^ ( auxL79$3  >>>  1 ));
 auxL143$0= diiiis$0 ;auxL143$1= diiiis$1 ;auxL143$2= diiiis$2 ;auxL143$3= diiiis$3 ;
 auxL77$ad1$0[i-1]= auxL78$0 ;auxL77$ad1$1[i-1]=((r0=~ auxL78$0 ) ^ ~ auxL78$1 );auxL77$ad1$2[i-1]=((r0=( r0  & ~ auxL78$1 )) ^ ~ auxL78$2 );auxL77$ad1$3[i-1]=(( r0  & ~ auxL78$2 ) ^ ~ auxL78$3 );
 r0= auxL77$ad1$3[i-1] ;resultCA$sw[i-1]= r0 ;auxL77$ad2$0[i-1]= auxL78$0 ;auxL77$ad2$1[i-1]= auxL78$1 ;
 auxL77$ad2$2[i-1]= auxL78$2 ;auxL77$ad2$3[i-1]= auxL78$3 ;r0= auxL77$ad2$3[i-1] ;resultCA$ne[i]=( r0  <<  1 );
  }
  ;
p.prepareBit(resultCA);p.prepareBit(auxL77)
 ;
  }
public static int slopDeltaRadius_4_1_1_2_2_1GateCount=403;
 public static void slopDeltaRadius_4_1_1_2_2_1(PrShift p,int [][] pdis,int [][] psrcPropag,int [][] slop,int [][] delta,int [][] sgnMaxLt,int [][] gap){
 int[] slop$e=slop[0],slop$se=slop[1],slop$sw=slop[2],slop$w=slop[3],slop$nw=slop[4],slop$ne=slop[5],delta$0=delta[0],delta$1=delta[1],sgnMaxLt$e$0=sgnMaxLt[0],sgnMaxLt$e$1=sgnMaxLt[1],sgnMaxLt$se$0=sgnMaxLt[2],sgnMaxLt$se$1=sgnMaxLt[3],sgnMaxLt$sw$0=sgnMaxLt[4],sgnMaxLt$sw$1=sgnMaxLt[5],sgnMaxLt$w$0=sgnMaxLt[6],sgnMaxLt$w$1=sgnMaxLt[7],sgnMaxLt$nw$0=sgnMaxLt[8],sgnMaxLt$nw$1=sgnMaxLt[9],sgnMaxLt$ne$0=sgnMaxLt[10],sgnMaxLt$ne$1=sgnMaxLt[11],gap$h=gap[0],gap$d=gap[1],gap$ad=gap[2],pdis$0=pdis[0],pdis$1=pdis[1],pdis$2=pdis[2],pdis$3=pdis[3],psrcPropag$e=psrcPropag[0],psrcPropag$se=psrcPropag[1],psrcPropag$sw=psrcPropag[2],psrcPropag$w=psrcPropag[3],psrcPropag$nw=psrcPropag[4],psrcPropag$ne=psrcPropag[5];

// initialisation 
 int auxL117$0=0,auxL117$1=0,auxL117$2=0,auxL117$3=0,auxL124=0,auxL125=0,auxL126$0=0,auxL126$1=0,auxL126$2=0,auxL126$3=0,auxL127=0,auxL128=0,auxL129=0,auxL130=0,auxL131$0=0,auxL131$1=0,auxL131$2=0,auxL131$3=0,auxL132=0,auxL133=0,auxL134$0=0,auxL134$1=0,auxL134$2=0,auxL134$3=0,auxL135=0,auxL136=0,auxL137$0=0,auxL137$1=0,auxL137$2=0,auxL137$3=0,auxL138$0=0,auxL138$1=0,auxL138$2=0,auxL138$3=0,auxL139$0=0,auxL139$1=0,auxL140$0=0,auxL140$1=0,auxL141=0,auxL142=0,auxL73$0=0,auxL73$1=0,auxL73$2=0,auxL73$3=0,auxL74$0=0,auxL74$1=0,auxL74$2=0,auxL74$3=0,dis$0=0,dis$1=0,dis$2=0,dis$3=0,grad$0=0,grad$1=0,grad$2=0,grad$3=0,maxSignGradm2$0=0,maxSignGradm2$1=0,minsignLt$0=0,minsignLt$1=0,r0=0,r1=0,r10=0,r11=0,r12=0,r13=0,r14=0,r15=0,r16=0,r17=0,r18=0,r19=0,r2=0,r20=0,r21=0,r22=0,r3=0,r4=0,r5=0,r6=0,r7=0,r8=0,r9=0,sgnMinLt$0=0,sgnMinLt$1=0,signGrad6$0=0,signGrad6$1=0,srcPropag=0,tmun36$0=0,tmun36$1=0,tmun36$2=0,tmun36$3=0,tmun37$0=0,tmun37$1=0,tmun38$0=0,tmun38$1=0,tmun39$0=0,tmun39$1=0,tmun40$0=0,tmun40$1=0,tmun41$0=0,tmun41$1=0,tmun42$0=0,tmun42$1=0,tmun43$0=0,tmun43$1=0,tmun43$2=0,tmun43$3=0,tmun44$0=0,tmun44$1=0,tmun45$0=0,tmun45$1=0,tmun46$0=0,tmun46$1=0,tmun47$0=0,tmun47$1=0,tmun48$0=0,tmun48$1=0,tmun48$2=0,tmun48$3=0,tmun49$0=0,tmun49$1=0,tmun50$0=0,tmun50$1=0;
for (int i = 1; i < pdis$0.length -1; i++) {
 srcPropag= psrcPropag$e[i] ;dis$0= pdis$0[i] ;dis$1= pdis$1[i] ;dis$2= pdis$2[i] ;
 dis$3= pdis$3[i] ;auxL74$0= dis$0 ;auxL74$1=((r0=~ dis$0 ) ^ ~ dis$1 );auxL74$2=((r0=( r0  & ~ dis$1 )) ^ ~ dis$2 );
 auxL74$3=(( r0  & ~ dis$2 ) ^ ~ dis$3 );grad$0= tmun36$0 ;grad$1= tmun36$1 ;grad$2= tmun36$2 ;
 grad$3= tmun36$3 ;tmun36$0=((r1=( auxL74$0  <<  1 )) ^  dis$0 );tmun36$1=(((r0=( dis$0  &  r1 )) ^ (r1=( auxL74$1  <<  1 ))) ^  dis$1 );tmun36$2=(((r0=(( r0  &  r1 ) | ( dis$1  & ( r0  |  r1 )))) ^ (r1=( auxL74$2  <<  1 ))) ^  dis$2 );
 tmun36$3=(((( r0  &  r1 ) | ( dis$2  & ( r0  |  r1 ))) ^ ( auxL74$3  <<  1 )) ^  dis$3 );auxL73$0= grad$0 ;auxL73$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL73$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );
 auxL73$3=(( r0  & ~ grad$2 ) ^ ~ grad$3 );r0= auxL73$3 ;slop$e[i-1]= r0 ;r2= auxL73$0 ;
 r4= auxL73$1 ;r0= auxL73$2 ;r3=(r1= auxL73$3 );r7= r2 ;
 r1= r7 ;r7=~ r4 ;r1=( r1  |  r7 );r7=~((r5= r4 ) ^  r0 );
 r1=( r1  |  r7 );r6=(r7=~(( r5  |  r0 ) ^  r3 ));r1=( r1  |  r7 );maxSignGradm2$0= r1 ;
 maxSignGradm2$1= r6 ;r0= auxL73$3 ;r1= auxL73$0 ;r1=( r1  |  auxL73$1 );
 r1=( r1  |  auxL73$2 );r1=( r1  |  auxL73$3 );signGrad6$0= r1 ;signGrad6$1= r0 ;
 auxL124=~ srcPropag ;sgnMinLt$0=(( auxL125  & ( signGrad6$0  &  signGrad6$0 )) |  tmun37$0 );sgnMinLt$1=(( auxL125  & ( signGrad6$1  &  signGrad6$1 )) |  tmun37$1 );tmun37$0= auxL124 ;
 minsignLt$0=( sgnMinLt$0  &  sgnMinLt$0 );minsignLt$1=( sgnMinLt$1  &  sgnMinLt$1 );sgnMaxLt$e$0[i-1]=(( auxL125  &  signGrad6$0 ) |  tmun38$0 );sgnMaxLt$e$1[i-1]=(( auxL125  &  signGrad6$1 ) |  tmun38$1 );
 tmun38$0= auxL124 ;tmun38$1= auxL124 ;auxL125= srcPropag ;auxL73$0= grad$0 ;
 auxL73$1= grad$1 ;auxL73$2= grad$2 ;auxL73$3= grad$3 ;r0= auxL73$3 ;
 slop$w[i-1]=( r0  >>>  1 );auxL126$0=( auxL73$0  >>>  1 );auxL126$1=( auxL73$1  >>>  1 );auxL126$2=( auxL73$2  >>>  1 );
 auxL126$3=( auxL73$3  >>>  1 );r0= auxL126$3 ;r1= auxL126$0 ;r1=( r1  |  auxL126$1 );
 r1=( r1  |  auxL126$2 );r1=( r1  |  auxL126$3 );signGrad6$0= r1 ;signGrad6$1= r0 ;
 srcPropag= psrcPropag$w[i] ;auxL127=~ srcPropag ;sgnMinLt$0=(( auxL128  & ( signGrad6$0  &  signGrad6$0 )) |  tmun39$0 );sgnMinLt$1=(( auxL128  & ( signGrad6$1  &  signGrad6$1 )) |  tmun39$1 );
 tmun39$0= auxL127 ;r0= minsignLt$1 ;r3=( sgnMinLt$0  &  sgnMinLt$0 );r1= r3 ;
 r2=(r3=( sgnMinLt$1  &  sgnMinLt$1 ));r3= minsignLt$0 ;r4=( r0  |  r2 );minsignLt$0=( r4  | (~ r4  & ( r3  &  r1 )));
 minsignLt$1= r4 ;sgnMaxLt$w$0[i-1]=(( auxL128  &  signGrad6$0 ) |  tmun40$0 );sgnMaxLt$w$1[i-1]=(( auxL128  &  signGrad6$1 ) |  tmun40$1 );tmun40$0= auxL127 ;
 tmun40$1= auxL127 ;auxL128= srcPropag ;srcPropag= psrcPropag$se[i] ;r0= grad$0 ;
 r0=( r0  |  grad$1 );r0=( r0  | ~ grad$2 );r0=( r0  | ( grad$2  ^  grad$3 ));gap$h[i-1]=~ r0 ;
 grad$0=( auxL134$0  ^  auxL74$0 );grad$1=(((r0=( auxL74$0  &  auxL134$0 )) ^  auxL134$1 ) ^  auxL74$1 );grad$2=(((r0=(( r0  &  auxL134$1 ) | ( auxL74$1  & ( r0  |  auxL134$1 )))) ^  auxL134$2 ) ^  auxL74$2 );grad$3=(((( r0  &  auxL134$2 ) | ( auxL74$2  & ( r0  |  auxL134$2 ))) ^  auxL134$3 ) ^  auxL74$3 );
 auxL73$0= grad$0 ;auxL73$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL73$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );auxL73$3=(( r0  & ~ grad$2 ) ^ ~ grad$3 );
 r0= auxL73$3 ;slop$se[i-1]= r0 ;r1= auxL73$0 ;r0= auxL73$1 ;
 r4= auxL73$2 ;r2=(r3= auxL73$3 );r8= auxL126$0 ;r7= auxL126$1 ;
 r6= auxL126$2 ;r5=(r3= auxL126$3 );r3= r1 ;r11= r3 ;
 r3=~ r0 ;r11=( r11  |  r3 );r3=~((r9= r0 ) ^  r4 );r11=( r11  |  r3 );
 r10=(r3=~(( r9  |  r4 ) ^  r2 ));r11=( r11  |  r3 );r1= r11 ;r2= r1 ;
 r0=(r1= r10 );r4=(r1= r8 );r4=( r4  | (r1=~ r7 ));r4=( r4  | (r1=~((r9= r7 ) ^  r6 )));
 r4=( r4  | (r1=~(( r9  |  r6 ) ^  r5 )));r3= r1 ;r1= maxSignGradm2$1 ;r5= maxSignGradm2$0 ;
 r8=(r7= r4 );r7= r3 ;r6= r7 ;r3=( r1  &  r6 );
 r7=(r9=( r3  | (~ r3  & ((~ r1  &  r5 ) | (~ r6  &  r8 )))));r9= r3 ;r4= r9 ;r1=( r4  &  r0 );
 maxSignGradm2$0=( r1  | (~ r1  & ((~ r4  &  r7 ) | (~ r0  &  r2 ))));maxSignGradm2$1= r1 ;r0= auxL73$3 ;r1= auxL73$0 ;
 r1=( r1  |  auxL73$1 );r1=( r1  |  auxL73$2 );r1=( r1  |  auxL73$3 );signGrad6$0= r1 ;
 signGrad6$1= r0 ;auxL129=~ srcPropag ;sgnMinLt$0=(( auxL130  & ( signGrad6$0  &  signGrad6$0 )) |  tmun41$0 );sgnMinLt$1=(( auxL130  & ( signGrad6$1  &  signGrad6$1 )) |  tmun41$1 );
 tmun41$0= auxL129 ;r2=( sgnMinLt$0  &  sgnMinLt$0 );r1= r2 ;r0=(r2=( sgnMinLt$1  &  sgnMinLt$1 ));
 r2= minsignLt$0 ;r3= minsignLt$1 ;r4=( r3  |  r0 );minsignLt$0=( r4  | (~ r4  & ( r2  &  r1 )));
 minsignLt$1= r4 ;sgnMaxLt$se$0[i-1]=(( auxL130  &  signGrad6$0 ) |  tmun42$0 );sgnMaxLt$se$1[i-1]=(( auxL130  &  signGrad6$1 ) |  tmun42$1 );tmun42$0= auxL129 ;
 tmun42$1= auxL129 ;auxL130= srcPropag ;auxL73$0= grad$0 ;auxL73$1= grad$1 ;
 auxL73$2= grad$2 ;auxL73$3= grad$3 ;r0= auxL73$3 ;slop$nw[i]= r0 ;
 auxL131$0= tmun43$0 ;auxL131$1= tmun43$1 ;auxL131$2= tmun43$2 ;auxL131$3= tmun43$3 ;
 tmun43$0= auxL73$0 ;tmun43$1= auxL73$1 ;tmun43$2= auxL73$2 ;tmun43$3= auxL73$3 ;
 r0= auxL131$3 ;r1= auxL131$0 ;r1=( r1  |  auxL131$1 );r1=( r1  |  auxL131$2 );
 r1=( r1  |  auxL131$3 );signGrad6$0= r1 ;signGrad6$1= r0 ;srcPropag= psrcPropag$nw[i] ;
 auxL132=~ srcPropag ;sgnMinLt$0=(( auxL133  & ( signGrad6$0  &  signGrad6$0 )) |  tmun44$0 );sgnMinLt$1=(( auxL133  & ( signGrad6$1  &  signGrad6$1 )) |  tmun44$1 );tmun44$0= auxL132 ;
 r0= minsignLt$1 ;r1=(r2=( sgnMinLt$0  &  sgnMinLt$0 ));r2=( sgnMinLt$1  &  sgnMinLt$1 );r3= r2 ;
 r2=( r0  |  r3 );r0= minsignLt$0 ;minsignLt$0=( r2  | (~ r2  & ( r0  &  r1 )));minsignLt$1= r2 ;
 sgnMaxLt$nw$0[i-1]=(( auxL133  &  signGrad6$0 ) |  tmun45$0 );sgnMaxLt$nw$1[i-1]=(( auxL133  &  signGrad6$1 ) |  tmun45$1 );tmun45$0= auxL132 ;tmun45$1= auxL132 ;
 auxL133= srcPropag ;srcPropag= psrcPropag$sw[i] ;r0= grad$0 ;r0=( r0  |  grad$1 );
 r0=( r0  | ~ grad$2 );r0=( r0  | ( grad$2  ^  grad$3 ));gap$d[i-1]=~ r0 ;grad$0=( auxL134$0  ^ (r1=( auxL74$0  >>>  1 )));
 grad$1=(((r0=( r1  &  auxL134$0 )) ^  auxL134$1 ) ^ (r1=( auxL74$1  >>>  1 )));grad$2=(((r0=(( r0  &  auxL134$1 ) | ( r1  & ( r0  |  auxL134$1 )))) ^  auxL134$2 ) ^ (r1=( auxL74$2  >>>  1 )));grad$3=(((( r0  &  auxL134$2 ) | ( r1  & ( r0  |  auxL134$2 ))) ^  auxL134$3 ) ^ ( auxL74$3  >>>  1 ));auxL134$0= dis$0 ;
 auxL134$1= dis$1 ;auxL134$2= dis$2 ;auxL134$3= dis$3 ;auxL73$0= grad$0 ;
 auxL73$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL73$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );auxL73$3=(( r0  & ~ grad$2 ) ^ ~ grad$3 );r0= auxL73$3 ;
 slop$sw[i-1]= r0 ;r2= auxL131$0 ;r1= auxL131$1 ;r4= auxL131$2 ;
 r3=(r0= auxL131$3 );r0= maxSignGradm2$1 ;r5= maxSignGradm2$0 ;r6= r2 ;
 r8= r6 ;r6=~ r1 ;r8=( r8  |  r6 );r6=~((r9= r1 ) ^  r4 );
 r8=( r8  |  r6 );r7=(r6=~(( r9  |  r4 ) ^  r3 ));r8=( r8  |  r6 );r2=(r3= r8 );
 r3= r7 ;r1= r3 ;r3=( r0  &  r1 );r4=( r3  | (~ r3  & ((~ r0  &  r5 ) | (~ r1  &  r2 ))));
 r6= r4 ;r7=(r4= r3 );r1= auxL73$0 ;r2= auxL73$1 ;
 r0= auxL73$2 ;r3=(r4= auxL73$3 );r4=(r9= r1 );r4=( r4  | (r9=~ r2 ));
 r4=( r4  | (r9=~((r5= r2 ) ^  r0 )));r4=( r4  | (r9=~(( r5  |  r0 ) ^  r3 )));r8= r9 ;r1=(r0= r4 );
 r0= r8 ;r2= r0 ;r0=( r7  &  r2 );maxSignGradm2$0=( r0  | (~ r0  & ((~ r7  &  r6 ) | (~ r2  &  r1 ))));
 maxSignGradm2$1= r0 ;r0= auxL73$3 ;r1= auxL73$0 ;r1=( r1  |  auxL73$1 );
 r1=( r1  |  auxL73$2 );r1=( r1  |  auxL73$3 );signGrad6$0= r1 ;signGrad6$1= r0 ;
 auxL135=~ srcPropag ;sgnMinLt$0=(( auxL136  & ( signGrad6$0  &  signGrad6$0 )) |  tmun46$0 );sgnMinLt$1=(( auxL136  & ( signGrad6$1  &  signGrad6$1 )) |  tmun46$1 );tmun46$0= auxL135 ;
 r0= minsignLt$0 ;r1=(r3=( sgnMinLt$0  &  sgnMinLt$0 ));r3=( sgnMinLt$1  &  sgnMinLt$1 );r2= r3 ;
 r3= minsignLt$1 ;r4=( r3  |  r2 );minsignLt$0=( r4  | (~ r4  & ( r0  &  r1 )));minsignLt$1= r4 ;
 sgnMaxLt$sw$0[i-1]=(( auxL136  &  signGrad6$0 ) |  tmun47$0 );sgnMaxLt$sw$1[i-1]=(( auxL136  &  signGrad6$1 ) |  tmun47$1 );tmun47$0= auxL135 ;tmun47$1= auxL135 ;
 auxL136= srcPropag ;auxL73$0= grad$0 ;auxL73$1= grad$1 ;auxL73$2= grad$2 ;
 auxL73$3= grad$3 ;r0= auxL73$3 ;slop$ne[i]=( r0  <<  1 );auxL138$0= tmun48$0 ;
 auxL138$1= tmun48$1 ;auxL138$2= tmun48$2 ;auxL138$3= tmun48$3 ;tmun48$0=( auxL73$0  <<  1 );
 tmun48$1=( auxL73$1  <<  1 );tmun48$2=( auxL73$2  <<  1 );tmun48$3=( auxL73$3  <<  1 );r0= auxL138$3 ;
 r1= auxL138$0 ;r1=( r1  |  auxL138$1 );r1=( r1  |  auxL138$2 );r1=( r1  |  auxL138$3 );
 signGrad6$0= r1 ;signGrad6$1= r0 ;srcPropag= psrcPropag$ne[i] ;auxL141=~ srcPropag ;
 sgnMinLt$0=(( auxL142  & ( signGrad6$0  &  signGrad6$0 )) |  tmun49$0 );sgnMinLt$1=(( auxL142  & ( signGrad6$1  &  signGrad6$1 )) |  tmun49$1 );tmun49$0= auxL141 ;sgnMaxLt$ne$0[i-1]=(( auxL142  &  signGrad6$0 ) |  tmun50$0 );
 sgnMaxLt$ne$1[i-1]=(( auxL142  &  signGrad6$1 ) |  tmun50$1 );tmun50$0= auxL141 ;tmun50$1= auxL141 ;auxL142= srcPropag ;
 r0= sgnMaxLt$w$1[i-1] ;r1= minsignLt$0 ;r2= maxSignGradm2$0 ;r3= minsignLt$1 ;
 r4= sgnMaxLt$ne$1[i-1] ;r5= sgnMaxLt$nw$0[i-1] ;r9= auxL138$0 ;r6= auxL138$1 ;
 r7= auxL138$2 ;r8=(r10= auxL138$3 );r10= sgnMaxLt$e$1[i-1] ;r11= sgnMaxLt$se$0[i-1] ;
 r12=( r10  &  r0 );r13= sgnMaxLt$sw$1[i-1] ;r14= sgnMaxLt$e$0[i-1] ;r15= maxSignGradm2$1 ;
 r16= sgnMaxLt$nw$1[i-1] ;r17= sgnMaxLt$ne$0[i-1] ;r18= sgnMaxLt$w$0[i-1] ;r20= r9 ;
 r19= r20 ;r20=~ r6 ;r19=( r19  |  r20 );r20=~((r22= r6 ) ^  r7 );
 r19=( r19  |  r20 );r21=(r20=~(( r22  |  r7 ) ^  r8 ));r19=( r19  |  r20 );r6= r19 ;
 r7= r6 ;r8=(r6= r21 );r6=( r15  &  r8 );r19=(r20=( r6  | (~ r6  & ((~ r15  &  r2 ) | (~ r8  &  r7 )))));
 r20= r6 ;r9= r20 ;r7=( sgnMinLt$0  &  sgnMinLt$0 );r6= r7 ;
 r2=(r7=( sgnMinLt$1  &  sgnMinLt$1 ));r7=( r3  |  r2 );r8=( r7  | (~ r7  & ( r1  &  r6 )));r15=(r20= r7 );
 r2= r20 ;r3= r20 ;r7=( r12  | (~ r12  & ((~ r10  &  r14 ) | (~ r0  &  r18 ))));r6= r7 ;
 r1=(r7= r12 );r0= sgnMaxLt$se$1[i-1] ;r7=( r1  &  r0 );r10=( r7  | (~ r7  & ((~ r1  &  r6 ) | (~ r0  &  r11 ))));
 r12= r10 ;r14=(r10= r7 );r0=( r14  &  r16 );r1= sgnMaxLt$sw$0[i-1] ;
 r10=(r6=( r0  | (~ r0  & ((~ r14  &  r12 ) | (~ r16  &  r5 )))));r6= r0 ;r7= r6 ;r0=( r7  &  r13 );
 r5=( r0  | (~ r0  & ((~ r7  &  r10 ) | (~ r13  &  r1 ))));r6= r5 ;r11=(r5= r0 );r0=( r11  &  r4 );
 r1=( r0  | (~ r0  & ((~ r11  &  r6 ) | (~ r4  &  r17 ))));r12=(r7= r0 );r10= r7 ;r5= r7 ;
 r4=(r6=( r8  ^  r1 ));r4=( r4  | (r6=(((r7=( r1  &  r8 )) ^  r15 ) ^  r12 )));r4=( r4  | (r6=(((r7=(( r7  &  r15 ) | ( r12  & ( r7  |  r15 )))) ^  r2 ) ^  r10 )));r4=( r4  | (r6=(((( r7  &  r2 ) | ( r10  & ( r7  |  r2 ))) ^  r3 ) ^  r5 )));
 r0= r6 ;r1=(r3= r4 );r3= r0 ;r2= r3 ;
 r0=( r9  &  r2 );delta$0[i-1]=( r0  | (~ r0  & ((~ r9  &  r19 ) | (~ r2  &  r1 ))));delta$1[i-1]= r0 ;r0= grad$0 ;
 r0=( r0  |  grad$1 );r0=( r0  | ~ grad$2 );r0=( r0  | ( grad$2  ^  grad$3 ));gap$ad[i-1]=~ r0 ;
  }
  p.mirror(delta);
p.prepareBit(slop);p.prepareBit(delta);p.prepareBit(sgnMaxLt);p.prepareBit(gap)
 ;
  }
public static int ltapex2_4_4_1_1GateCount=27;
 public static void ltapex2_4_4_1_1(PrShift p,int [][] pdeef,int [][] psegmentderiv,int [][] pdifff,int [][] gradltapex2){
 int[] gradltapex2$h1=gradltapex2[0],gradltapex2$h2=gradltapex2[1],gradltapex2$d1=gradltapex2[2],gradltapex2$d2=gradltapex2[3],gradltapex2$ad1=gradltapex2[4],gradltapex2$ad2=gradltapex2[5],pdeef$h1$0=pdeef[0],pdeef$h1$1=pdeef[1],pdeef$h1$2=pdeef[2],pdeef$h1$3=pdeef[3],pdeef$h2$0=pdeef[4],pdeef$h2$1=pdeef[5],pdeef$h2$2=pdeef[6],pdeef$h2$3=pdeef[7],pdeef$d1$0=pdeef[8],pdeef$d1$1=pdeef[9],pdeef$d1$2=pdeef[10],pdeef$d1$3=pdeef[11],pdeef$d2$0=pdeef[12],pdeef$d2$1=pdeef[13],pdeef$d2$2=pdeef[14],pdeef$d2$3=pdeef[15],pdeef$ad1$0=pdeef[16],pdeef$ad1$1=pdeef[17],pdeef$ad1$2=pdeef[18],pdeef$ad1$3=pdeef[19],pdeef$ad2$0=pdeef[20],pdeef$ad2$1=pdeef[21],pdeef$ad2$2=pdeef[22],pdeef$ad2$3=pdeef[23],psegmentderiv$h$0=psegmentderiv[0],psegmentderiv$h$1=psegmentderiv[1],psegmentderiv$h$2=psegmentderiv[2],psegmentderiv$h$3=psegmentderiv[3],psegmentderiv$d$0=psegmentderiv[4],psegmentderiv$d$1=psegmentderiv[5],psegmentderiv$d$2=psegmentderiv[6],psegmentderiv$d$3=psegmentderiv[7],psegmentderiv$ad$0=psegmentderiv[8],psegmentderiv$ad$1=psegmentderiv[9],psegmentderiv$ad$2=psegmentderiv[10],psegmentderiv$ad$3=psegmentderiv[11],pdifff$h=pdifff[0],pdifff$d=pdifff[1],pdifff$ad=pdifff[2];

// initialisation 
 int auxL75=0,r0=0;
for (int i = 1; i < pdeef$h1$0.length -1; i++) {
 r0=( psegmentderiv$h$0[i]  &  pdeef$h1$0[i] );r0=( r0  | ( psegmentderiv$h$1[i]  &  pdeef$h1$1[i] ));r0=( r0  | ( psegmentderiv$h$2[i]  &  pdeef$h1$2[i] ));r0=( r0  | ( psegmentderiv$h$3[i]  &  pdeef$h1$3[i] ));
 auxL75= r0 ;gradltapex2$h1[i]= auxL75 ;gradltapex2$h2[i]=(~ auxL75  &  pdifff$h[i] );r0=( psegmentderiv$d$0[i]  &  pdeef$d1$0[i] );
 r0=( r0  | ( psegmentderiv$d$1[i]  &  pdeef$d1$1[i] ));r0=( r0  | ( psegmentderiv$d$2[i]  &  pdeef$d1$2[i] ));r0=( r0  | ( psegmentderiv$d$3[i]  &  pdeef$d1$3[i] ));auxL75= r0 ;
 gradltapex2$d1[i]= auxL75 ;gradltapex2$d2[i]=(~ auxL75  &  pdifff$d[i] );r0=( psegmentderiv$ad$0[i]  &  pdeef$ad1$0[i] );r0=( r0  | ( psegmentderiv$ad$1[i]  &  pdeef$ad1$1[i] ));
 r0=( r0  | ( psegmentderiv$ad$2[i]  &  pdeef$ad1$2[i] ));r0=( r0  | ( psegmentderiv$ad$3[i]  &  pdeef$ad1$3[i] ));auxL75= r0 ;gradltapex2$ad1[i]= auxL75 ;
 gradltapex2$ad2[i]=(~ auxL75  &  pdifff$ad[i] );
  }
  ;
p.prepareBit(gradltapex2)
 ;
  }
public static int lt_4_4_1GateCount=45;
 public static void lt_4_4_1(PrShift p,int [][] pdis,int [][] psegment,int [][] gradlt){
 int[] gradlt$h1=gradlt[0],gradlt$h2=gradlt[1],gradlt$d1=gradlt[2],gradlt$d2=gradlt[3],gradlt$ad1=gradlt[4],gradlt$ad2=gradlt[5],pdis$0=pdis[0],pdis$1=pdis[1],pdis$2=pdis[2],pdis$3=pdis[3],psegment$h$0=psegment[0],psegment$h$1=psegment[1],psegment$h$2=psegment[2],psegment$h$3=psegment[3],psegment$d$0=psegment[4],psegment$d$1=psegment[5],psegment$d$2=psegment[6],psegment$d$3=psegment[7],psegment$ad$0=psegment[8],psegment$ad$1=psegment[9],psegment$ad$2=psegment[10],psegment$ad$3=psegment[11];

// initialisation 
 int auxL120$0=0,auxL120$1=0,auxL120$2=0,auxL120$3=0,auxL121$0=0,auxL121$1=0,auxL121$2=0,auxL121$3=0,auxL76=0,auxTmp1$0=0,auxTmp1$1=0,auxTmp1$2=0,auxTmp1$3=0,r0=0,segment$0=0,segment$1=0,segment$2=0,segment$3=0,tmun22$0=0,tmun22$1=0,tmun22$2=0,tmun22$3=0,tmun23$0=0,tmun23$1=0,tmun23$2=0,tmun23$3=0,tmun24=0,tmun25$0=0,tmun25$1=0,tmun25$2=0,tmun25$3=0,tmun26=0,tmun27$0=0,tmun27$1=0,tmun27$2=0,tmun27$3=0,tmun28=0;
for (int i = 1; i < pdis$0.length -1; i++) {
 auxL121$0= pdis$0[i] ;auxL121$1= pdis$1[i] ;auxL121$2= pdis$2[i] ;auxL121$3= pdis$3[i] ;
 auxTmp1$0= auxL120$0 ;auxTmp1$1= auxL120$1 ;auxTmp1$2= auxL120$2 ;auxTmp1$3= auxL120$3 ;
 segment$0= psegment$h$0[i] ;segment$1= psegment$h$1[i] ;segment$2= psegment$h$2[i] ;segment$3= psegment$h$3[i] ;
 r0=( tmun23$0  &  auxTmp1$0 );r0=( r0  | ( tmun23$1  &  auxTmp1$1 ));r0=( r0  | ( tmun23$2  &  auxTmp1$2 ));r0=( r0  | ( tmun23$3  &  auxTmp1$3 ));
 auxL76= r0 ;tmun22$0=( auxL121$0  <<  1 );tmun22$1=( auxL121$1  <<  1 );tmun22$2=( auxL121$2  <<  1 );
 tmun22$3=( auxL121$3  <<  1 );tmun23$3= segment$3 ;tmun23$2=(~(r0= segment$3 ) &  segment$2 );tmun23$1=(~(r0= segment$2 ) &  segment$1 );
 tmun23$0=(~ segment$1  &  segment$0 );gradlt$h1[i-1]= auxL76 ;gradlt$h2[i-1]=(~ auxL76  &  tmun24 );r0= segment$0 ;
 tmun24= r0 ;auxTmp1$0= auxL120$0 ;auxTmp1$1= auxL120$1 ;auxTmp1$2= auxL120$2 ;
 auxTmp1$3= auxL120$3 ;segment$0= psegment$d$0[i] ;segment$1= psegment$d$1[i] ;segment$2= psegment$d$2[i] ;
 segment$3= psegment$d$3[i] ;r0=( tmun25$0  &  auxTmp1$0 );r0=( r0  | ( tmun25$1  &  auxTmp1$1 ));r0=( r0  | ( tmun25$2  &  auxTmp1$2 ));
 r0=( r0  | ( tmun25$3  &  auxTmp1$3 ));auxL76= r0 ;tmun25$3= segment$3 ;tmun25$2=(~(r0= segment$3 ) &  segment$2 );
 tmun25$1=(~(r0= segment$2 ) &  segment$1 );tmun25$0=(~ segment$1  &  segment$0 );gradlt$d1[i-1]= auxL76 ;gradlt$d2[i-1]=(~ auxL76  &  tmun26 );
 r0= segment$0 ;tmun26= r0 ;auxTmp1$0= auxL120$0 ;auxTmp1$1= auxL120$1 ;
 auxTmp1$2= auxL120$2 ;auxTmp1$3= auxL120$3 ;auxL120$0= auxL121$0 ;auxL120$1= auxL121$1 ;
 auxL120$2= auxL121$2 ;auxL120$3= auxL121$3 ;segment$0= psegment$ad$0[i] ;segment$1= psegment$ad$1[i] ;
 segment$2= psegment$ad$2[i] ;segment$3= psegment$ad$3[i] ;r0=( tmun27$0  &  auxTmp1$0 );r0=( r0  | ( tmun27$1  &  auxTmp1$1 ));
 r0=( r0  | ( tmun27$2  &  auxTmp1$2 ));r0=( r0  | ( tmun27$3  &  auxTmp1$3 ));auxL76= r0 ;tmun27$3= segment$3 ;
 tmun27$2=(~(r0= segment$3 ) &  segment$2 );tmun27$1=(~(r0= segment$2 ) &  segment$1 );tmun27$0=(~ segment$1  &  segment$0 );gradlt$ad1[i-1]= auxL76 ;
 gradlt$ad2[i-1]=(~ auxL76  &  tmun28 );r0= segment$0 ;tmun28= r0 ;
  }
  ;
p.prepareBit(gradlt)
 ;
  }
public static int lt_3_3_1GateCount=33;
 public static void lt_3_3_1(PrShift p,int [][] pdis,int [][] psegment,int [][] gradlt){
 int[] gradlt$h1=gradlt[0],gradlt$h2=gradlt[1],gradlt$d1=gradlt[2],gradlt$d2=gradlt[3],gradlt$ad1=gradlt[4],gradlt$ad2=gradlt[5],pdis$0=pdis[0],pdis$1=pdis[1],pdis$2=pdis[2],psegment$h$0=psegment[0],psegment$h$1=psegment[1],psegment$h$2=psegment[2],psegment$d$0=psegment[3],psegment$d$1=psegment[4],psegment$d$2=psegment[5],psegment$ad$0=psegment[6],psegment$ad$1=psegment[7],psegment$ad$2=psegment[8];

// initialisation 
 int auxL122$0=0,auxL122$1=0,auxL122$2=0,auxL123$0=0,auxL123$1=0,auxL123$2=0,auxL76=0,auxTmp2$0=0,auxTmp2$1=0,auxTmp2$2=0,r0=0,segment$0=0,segment$1=0,segment$2=0,tmun29$0=0,tmun29$1=0,tmun29$2=0,tmun30$0=0,tmun30$1=0,tmun30$2=0,tmun31=0,tmun32$0=0,tmun32$1=0,tmun32$2=0,tmun33=0,tmun34$0=0,tmun34$1=0,tmun34$2=0,tmun35=0;
for (int i = 1; i < pdis$0.length -1; i++) {
 segment$0= psegment$h$0[i] ;segment$1= psegment$h$1[i] ;segment$2= psegment$h$2[i] ;auxL123$0= pdis$0[i] ;
 auxL123$1= pdis$1[i] ;auxL123$2= pdis$2[i] ;auxTmp2$0= auxL122$0 ;auxTmp2$1= auxL122$1 ;
 auxTmp2$2= auxL122$2 ;r0=( tmun30$0  &  auxTmp2$0 );r0=( r0  | ( tmun30$1  &  auxTmp2$1 ));r0=( r0  | ( tmun30$2  &  auxTmp2$2 ));
 auxL76= r0 ;tmun29$0=( auxL123$0  <<  1 );tmun29$1=( auxL123$1  <<  1 );tmun29$2=( auxL123$2  <<  1 );
 tmun30$2= segment$2 ;tmun30$1=(~(r0= segment$2 ) &  segment$1 );tmun30$0=(~ segment$1  &  segment$0 );gradlt$h1[i-1]= auxL76 ;
 gradlt$h2[i-1]=(~ auxL76  &  tmun31 );r0= segment$0 ;tmun31= r0 ;segment$0= psegment$d$0[i] ;
 segment$1= psegment$d$1[i] ;segment$2= psegment$d$2[i] ;auxTmp2$0= auxL122$0 ;auxTmp2$1= auxL122$1 ;
 auxTmp2$2= auxL122$2 ;r0=( tmun32$0  &  auxTmp2$0 );r0=( r0  | ( tmun32$1  &  auxTmp2$1 ));r0=( r0  | ( tmun32$2  &  auxTmp2$2 ));
 auxL76= r0 ;tmun32$2= segment$2 ;tmun32$1=(~(r0= segment$2 ) &  segment$1 );tmun32$0=(~ segment$1  &  segment$0 );
 gradlt$d1[i-1]= auxL76 ;gradlt$d2[i-1]=(~ auxL76  &  tmun33 );r0= segment$0 ;tmun33= r0 ;
 segment$0= psegment$ad$0[i] ;segment$1= psegment$ad$1[i] ;segment$2= psegment$ad$2[i] ;auxTmp2$0= auxL122$0 ;
 auxTmp2$1= auxL122$1 ;auxTmp2$2= auxL122$2 ;auxL122$0= auxL123$0 ;auxL122$1= auxL123$1 ;
 auxL122$2= auxL123$2 ;r0=( tmun34$0  &  auxTmp2$0 );r0=( r0  | ( tmun34$1  &  auxTmp2$1 ));r0=( r0  | ( tmun34$2  &  auxTmp2$2 ));
 auxL76= r0 ;tmun34$2= segment$2 ;tmun34$1=(~(r0= segment$2 ) &  segment$1 );tmun34$0=(~ segment$1  &  segment$0 );
 gradlt$ad1[i-1]= auxL76 ;gradlt$ad2[i-1]=(~ auxL76  &  tmun35 );r0= segment$0 ;tmun35= r0 ;
  }
  ;
p.prepareBit(gradlt)
 ;
  }}