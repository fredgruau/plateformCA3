package compiledMacro;
 import simulator.PrShift;
 public class grad{
 
public static int slopDeltaDist_4_1_2_1_1GateCount=237;
 public static void slopDeltaDist_4_1_2_1_1(PrShift p,int [][] pdis,int [][] slop,int [][] deltaR,int [][] level,int [][] resultCA){
 int[] slop$e=slop[0],slop$se=slop[1],slop$sw=slop[2],slop$w=slop[3],slop$nw=slop[4],slop$ne=slop[5],deltaR$0=deltaR[0],deltaR$1=deltaR[1],level$h=level[0],level$d=level[1],level$ad=level[2],resultCA$h=resultCA[0],resultCA$d=resultCA[1],resultCA$ad=resultCA[2],pdis$0=pdis[0],pdis$1=pdis[1],pdis$2=pdis[2],pdis$3=pdis[3];

// initialisation 
 int auxL103=0,auxL104$0=0,auxL104$1=0,auxL104$2=0,auxL104$3=0,auxL133$0=0,auxL133$1=0,auxL133$2=0,auxL133$3=0,auxL134$0=0,auxL134$1=0,auxL134$2=0,auxL134$3=0,auxL134$4=0,auxL134$5=0,auxL134$6=0,auxL135$0=0,auxL135$1=0,auxL135$2=0,auxL135$3=0,auxL99$0=0,auxL99$1=0,auxL99$2=0,auxL99$3=0,auxO09=0,delta$0=0,delta$1=0,dis$0=0,dis$1=0,dis$2=0,dis$3=0,grad$0=0,grad$1=0,grad$2=0,grad$3=0,r0=0,r1=0,r10=0,r11=0,r12=0,r2=0,r3=0,r4=0,r5=0,r6=0,r7=0,r8=0,r9=0,tmun07$0=0,tmun07$1=0,tmun07$2=0,tmun07$3=0,tmun08$0=0,tmun08$1=0,tmun08$2=0,tmun08$3=0,tmun09$0=0,tmun09$1=0,tmun09$2=0,tmun09$3=0;
for (int i = 1; i < pdis$0.length -1; i++) {
 dis$0= pdis$0[i] ;dis$1= pdis$1[i] ;dis$2= pdis$2[i] ;dis$3= pdis$3[i] ;
 auxL99$0= dis$0 ;auxL99$1=((r0=~ dis$0 ) ^ ~ dis$1 );auxL99$2=((r0=( r0  & ~ dis$1 )) ^ ~ dis$2 );auxL99$3=(( r0  & ~ dis$2 ) ^ ~ dis$3 );
 grad$0= tmun07$0 ;grad$1= tmun07$1 ;grad$2= tmun07$2 ;grad$3= tmun07$3 ;
 tmun07$0=((r0=( auxL99$0  <<  1 )) ^  dis$0 );tmun07$1=(((r1=( dis$0  &  r0 )) ^ (r0=( auxL99$1  <<  1 ))) ^  dis$1 );tmun07$2=(((r1=(( r1  &  r0 ) | ( dis$1  & ( r1  |  r0 )))) ^ (r0=( auxL99$2  <<  1 ))) ^  dis$2 );tmun07$3=(((( r1  &  r0 ) | ( dis$2  & ( r1  |  r0 ))) ^ ( auxL99$3  <<  1 )) ^  dis$3 );
 auxL104$0= grad$0 ;auxL104$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL104$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );auxL104$3=(( r0  & ~ grad$2 ) ^ ~ grad$3 );
 r2= auxL104$0 ;r3= auxL104$1 ;r4= auxL104$2 ;r5=(r0= auxL104$3 );
 r1= r0 ;r7= r0 ;r6= r0 ;r8= r2 ;
 r10= r8 ;r8=~ r3 ;r10=( r10  |  r8 );r8=((r0= r3 ) ^  r4 );
 r10=( r10  |  r8 );r8=((r0=( r0  &  r4 )) ^  r5 );r10=( r10  |  r8 );r8=((r0=( r0  &  r5 )) ^  r1 );
 r10=( r10  |  r8 );r8=((r0=( r0  &  r1 )) ^  r7 );r10=( r10  |  r8 );r9=(r8=(( r0  &  r7 ) ^  r6 ));
 r10=( r10  |  r8 );delta$0= r10 ;delta$1= r9 ;r0= auxL104$3 ;
 auxL103= r0 ;slop$e[i-1]= auxL103 ;auxO09= auxL103 ;auxL104$0= grad$0 ;
 auxL104$1= grad$1 ;auxL104$2= grad$2 ;auxL104$3= grad$3 ;r2=( auxL104$0  >>>  1 );
 r1=( auxL104$1  >>>  1 );r3=( auxL104$2  >>>  1 );r5=(r4=( auxL104$3  >>>  1 ));r0= r4 ;
 r7= r4 ;r6= r4 ;r4= delta$1 ;r10= r2 ;
 r11= r10 ;r10=~ r1 ;r11=( r11  |  r10 );r10=((r9= r1 ) ^  r3 );
 r11=( r11  |  r10 );r10=((r9=( r9  &  r3 )) ^  r5 );r11=( r11  |  r10 );r10=((r9=( r9  &  r5 )) ^  r0 );
 r11=( r11  |  r10 );r10=((r9=( r9  &  r0 )) ^  r7 );r11=( r11  |  r10 );r8=(r10=(( r9  &  r7 ) ^  r6 ));
 r11=( r11  |  r10 );r0= delta$0 ;r3=(r2= r11 );r2= r8 ;
 r1= r2 ;r2=( r4  |  r1 );delta$0=( r2  | (~ r2  & ( r0  &  r3 )));delta$1= r2 ;
 r0= auxL104$3 ;auxL103= r0 ;slop$w[i-1]=( auxL103  >>>  1 );level$h[i-1]=~( auxO09  |  auxL103 );
 r0= grad$0 ;r0=( r0  |  grad$1 );r0=( r0  | ~ grad$2 );r0=( r0  | ( grad$2  ^  grad$3 ));
 resultCA$h[i-1]=~ r0 ;grad$0=( auxL133$0  ^  auxL99$0 );grad$1=(((r0=( auxL99$0  &  auxL133$0 )) ^  auxL133$1 ) ^  auxL99$1 );grad$2=(((r0=(( r0  &  auxL133$1 ) | ( auxL99$1  & ( r0  |  auxL133$1 )))) ^  auxL133$2 ) ^  auxL99$2 );
 grad$3=(((( r0  &  auxL133$2 ) | ( auxL99$2  & ( r0  |  auxL133$2 ))) ^  auxL133$3 ) ^  auxL99$3 );auxL104$0= grad$0 ;auxL104$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL104$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );
 auxL104$3=(( r0  & ~ grad$2 ) ^ ~ grad$3 );r0= delta$1 ;r1= delta$0 ;r3= auxL104$0 ;
 r4= auxL104$1 ;r7= auxL104$2 ;r6=(r8= auxL104$3 );r2= r8 ;
 r9= r8 ;r5= r8 ;r8=(r10= r3 );r8=( r8  | (r10=~ r4 ));
 r8=( r8  | (r10=((r11= r4 ) ^  r7 )));r8=( r8  | (r10=((r11=( r11  &  r7 )) ^  r6 )));r8=( r8  | (r10=((r11=( r11  &  r6 )) ^  r2 )));r8=( r8  | (r10=((r11=( r11  &  r2 )) ^  r9 )));
 r8=( r8  | (r10=(( r11  &  r9 ) ^  r5 )));r12= r10 ;r4=(r2= r8 );r2= r12 ;
 r3= r2 ;r2=( r0  |  r3 );delta$0=( r2  | (~ r2  & ( r1  &  r4 )));delta$1= r2 ;
 r0= auxL104$3 ;auxL103= r0 ;slop$se[i-1]= auxL103 ;auxO09= auxL103 ;
 auxL104$0= grad$0 ;auxL104$1= grad$1 ;auxL104$2= grad$2 ;auxL104$3= grad$3 ;
 r5= tmun08$0 ;r1= tmun08$1 ;r2= tmun08$2 ;r6=(r4= tmun08$3 );
 r7= r4 ;r0= r4 ;r3= r4 ;r4= delta$1 ;
 r9=(r8= r5 );r9=( r9  | (r8=~ r1 ));r9=( r9  | (r8=((r10= r1 ) ^  r2 )));r9=( r9  | (r8=((r10=( r10  &  r2 )) ^  r6 )));
 r9=( r9  | (r8=((r10=( r10  &  r6 )) ^  r7 )));r9=( r9  | (r8=((r10=( r10  &  r7 )) ^  r0 )));r9=( r9  | (r8=(( r10  &  r0 ) ^  r3 )));r11= r8 ;
 r0= delta$0 ;r3=(r1= r9 );r1= r11 ;r2= r1 ;
 r1=( r4  |  r2 );delta$0=( r1  | (~ r1  & ( r0  &  r3 )));delta$1= r1 ;tmun08$0= auxL104$0 ;
 tmun08$1= auxL104$1 ;tmun08$2= auxL104$2 ;tmun08$3= auxL104$3 ;r0= auxL104$3 ;
 auxL103= r0 ;slop$nw[i]= auxL103 ;level$d[i-1]=~( auxO09  |  auxL103 );r0= grad$0 ;
 r0=( r0  |  grad$1 );r0=( r0  | ~ grad$2 );r0=( r0  | ( grad$2  ^  grad$3 ));resultCA$d[i-1]=~ r0 ;
 grad$0=( auxL133$0  ^ (r1=( auxL99$0  >>>  1 )));grad$1=(((r0=( r1  &  auxL133$0 )) ^  auxL133$1 ) ^ (r1=( auxL99$1  >>>  1 )));grad$2=(((r0=(( r0  &  auxL133$1 ) | ( r1  & ( r0  |  auxL133$1 )))) ^  auxL133$2 ) ^ (r1=( auxL99$2  >>>  1 )));grad$3=(((( r0  &  auxL133$2 ) | ( r1  & ( r0  |  auxL133$2 ))) ^  auxL133$3 ) ^ ( auxL99$3  >>>  1 ));
 auxL133$0= dis$0 ;auxL133$1= dis$1 ;auxL133$2= dis$2 ;auxL133$3= dis$3 ;
 auxL104$0= grad$0 ;auxL104$1= grad$1 ;auxL104$2= grad$2 ;auxL104$3= grad$3 ;
 r0= delta$1 ;r1= delta$0 ;r5= tmun09$0 ;r9= tmun09$1 ;
 r6= tmun09$2 ;r7=(r3= tmun09$3 );r8= r3 ;r4= r3 ;
 r2= r3 ;r11= r5 ;r10= r11 ;r11=~ r9 ;
 r10=( r10  |  r11 );r11=((r12= r9 ) ^  r6 );r10=( r10  |  r11 );r11=((r12=( r12  &  r6 )) ^  r7 );
 r10=( r10  |  r11 );r11=((r12=( r12  &  r7 )) ^  r8 );r10=( r10  |  r11 );r11=((r12=( r12  &  r8 )) ^  r4 );
 r10=( r10  |  r11 );r3=(r11=(( r12  &  r4 ) ^  r2 ));r10=( r10  |  r11 );r2= r10 ;
 r4= r2 ;r5=(r2= r3 );r2=( r0  |  r5 );delta$0=( r2  | (~ r2  & ( r1  &  r4 )));
 delta$1= r2 ;tmun09$0=( auxL104$0  <<  1 );tmun09$1=( auxL104$1  <<  1 );tmun09$2=( auxL104$2  <<  1 );
 tmun09$3=( auxL104$3  <<  1 );r0= auxL104$3 ;auxL103= r0 ;slop$ne[i]=( auxL103  <<  1 );
 auxO09= auxL103 ;auxL104$0= grad$0 ;auxL104$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL104$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );
 auxL104$3=(( r0  & ~ grad$2 ) ^ ~ grad$3 );r0= delta$0 ;r4= auxL104$0 ;r1= auxL104$1 ;
 r7= auxL104$2 ;r5=(r6= auxL104$3 );r3= r6 ;r2= r6 ;
 r8= r6 ;r6= delta$1 ;r9=(r11= r4 );r9=( r9  | (r11=~ r1 ));
 r9=( r9  | (r11=((r12= r1 ) ^  r7 )));r9=( r9  | (r11=((r12=( r12  &  r7 )) ^  r5 )));r9=( r9  | (r11=((r12=( r12  &  r5 )) ^  r3 )));r9=( r9  | (r11=((r12=( r12  &  r3 )) ^  r2 )));
 r9=( r9  | (r11=(( r12  &  r2 ) ^  r8 )));r10= r11 ;r1= r9 ;r2= r1 ;
 r3=(r1= r10 );r1=( r6  |  r3 );deltaR$0[i-1]=( r1  | (~ r1  & ( r0  &  r2 )));deltaR$1[i-1]= r1 ;
 r0= auxL104$3 ;auxL103= r0 ;slop$sw[i-1]= auxL103 ;level$ad[i-1]=~( auxO09  |  auxL103 );
 r0= grad$0 ;r0=( r0  |  grad$1 );r0=( r0  | ~ grad$2 );r0=( r0  | ( grad$2  ^  grad$3 ));
 resultCA$ad[i-1]=~ r0 ;
  }
  p.mirror(deltaR);
p.prepareBit(slop);p.prepareBit(deltaR);p.prepareBit(level);p.prepareBit(resultCA)
 ;
  }
public static int slopDeltaRadius_4_1_1_2_2_1GateCount=403;
 public static void slopDeltaRadius_4_1_1_2_2_1(PrShift p,int [][] pdis,int [][] psrcPropag,int [][] slop,int [][] delta,int [][] sgnMaxLt,int [][] gap){
 int[] slop$e=slop[0],slop$se=slop[1],slop$sw=slop[2],slop$w=slop[3],slop$nw=slop[4],slop$ne=slop[5],delta$0=delta[0],delta$1=delta[1],sgnMaxLt$e$0=sgnMaxLt[0],sgnMaxLt$e$1=sgnMaxLt[1],sgnMaxLt$se$0=sgnMaxLt[2],sgnMaxLt$se$1=sgnMaxLt[3],sgnMaxLt$sw$0=sgnMaxLt[4],sgnMaxLt$sw$1=sgnMaxLt[5],sgnMaxLt$w$0=sgnMaxLt[6],sgnMaxLt$w$1=sgnMaxLt[7],sgnMaxLt$nw$0=sgnMaxLt[8],sgnMaxLt$nw$1=sgnMaxLt[9],sgnMaxLt$ne$0=sgnMaxLt[10],sgnMaxLt$ne$1=sgnMaxLt[11],gap$h=gap[0],gap$d=gap[1],gap$ad=gap[2],pdis$0=pdis[0],pdis$1=pdis[1],pdis$2=pdis[2],pdis$3=pdis[3],psrcPropag$e=psrcPropag[0],psrcPropag$se=psrcPropag[1],psrcPropag$sw=psrcPropag[2],psrcPropag$w=psrcPropag[3],psrcPropag$nw=psrcPropag[4],psrcPropag$ne=psrcPropag[5];

// initialisation 
 int auxL135$0=0,auxL135$1=0,auxL135$2=0,auxL135$3=0,auxL144=0,auxL145=0,auxL146$0=0,auxL146$1=0,auxL146$2=0,auxL146$3=0,auxL147=0,auxL148=0,auxL149=0,auxL150=0,auxL151$0=0,auxL151$1=0,auxL151$2=0,auxL151$3=0,auxL152=0,auxL153=0,auxL154$0=0,auxL154$1=0,auxL154$2=0,auxL154$3=0,auxL155=0,auxL156=0,auxL157$0=0,auxL157$1=0,auxL157$2=0,auxL157$3=0,auxL158$0=0,auxL158$1=0,auxL158$2=0,auxL158$3=0,auxL159$0=0,auxL159$1=0,auxL160$0=0,auxL160$1=0,auxL161=0,auxL162=0,auxL98$0=0,auxL98$1=0,auxL98$2=0,auxL98$3=0,auxL99$0=0,auxL99$1=0,auxL99$2=0,auxL99$3=0,dis$0=0,dis$1=0,dis$2=0,dis$3=0,grad$0=0,grad$1=0,grad$2=0,grad$3=0,maxSignGradm2$0=0,maxSignGradm2$1=0,minsignLt$0=0,minsignLt$1=0,r0=0,r1=0,r10=0,r11=0,r12=0,r13=0,r14=0,r15=0,r16=0,r17=0,r18=0,r19=0,r2=0,r20=0,r21=0,r22=0,r23=0,r24=0,r3=0,r4=0,r5=0,r6=0,r7=0,r8=0,r9=0,sgnMinLt$0=0,sgnMinLt$1=0,signGrad6$0=0,signGrad6$1=0,srcPropag=0,tmun32$0=0,tmun32$1=0,tmun32$2=0,tmun32$3=0,tmun33$0=0,tmun33$1=0,tmun34$0=0,tmun34$1=0,tmun35$0=0,tmun35$1=0,tmun36$0=0,tmun36$1=0,tmun37$0=0,tmun37$1=0,tmun38$0=0,tmun38$1=0,tmun39$0=0,tmun39$1=0,tmun39$2=0,tmun39$3=0,tmun40$0=0,tmun40$1=0,tmun41$0=0,tmun41$1=0,tmun42$0=0,tmun42$1=0,tmun43$0=0,tmun43$1=0,tmun44$0=0,tmun44$1=0,tmun44$2=0,tmun44$3=0,tmun45$0=0,tmun45$1=0,tmun46$0=0,tmun46$1=0;
for (int i = 1; i < pdis$0.length -1; i++) {
 srcPropag= psrcPropag$e[i] ;dis$0= pdis$0[i] ;dis$1= pdis$1[i] ;dis$2= pdis$2[i] ;
 dis$3= pdis$3[i] ;auxL99$0= dis$0 ;auxL99$1=((r0=~ dis$0 ) ^ ~ dis$1 );auxL99$2=((r0=( r0  & ~ dis$1 )) ^ ~ dis$2 );
 auxL99$3=(( r0  & ~ dis$2 ) ^ ~ dis$3 );grad$0= tmun32$0 ;grad$1= tmun32$1 ;grad$2= tmun32$2 ;
 grad$3= tmun32$3 ;tmun32$0=((r0=( auxL99$0  <<  1 )) ^  dis$0 );tmun32$1=(((r1=( dis$0  &  r0 )) ^ (r0=( auxL99$1  <<  1 ))) ^  dis$1 );tmun32$2=(((r1=(( r1  &  r0 ) | ( dis$1  & ( r1  |  r0 )))) ^ (r0=( auxL99$2  <<  1 ))) ^  dis$2 );
 tmun32$3=(((( r1  &  r0 ) | ( dis$2  & ( r1  |  r0 ))) ^ ( auxL99$3  <<  1 )) ^  dis$3 );auxL98$0= grad$0 ;auxL98$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL98$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );
 auxL98$3=(( r0  & ~ grad$2 ) ^ ~ grad$3 );r0= auxL98$3 ;slop$e[i-1]= r0 ;r3= auxL98$0 ;
 r0= auxL98$1 ;r1= auxL98$2 ;r4=(r2= auxL98$3 );r5=(r2= r3 );
 r5=( r5  | (r2=~ r0 ));r5=( r5  | (r2=~((r6= r0 ) ^  r1 )));r5=( r5  | (r2=~(( r6  |  r1 ) ^  r4 )));r7= r2 ;
 maxSignGradm2$0= r5 ;maxSignGradm2$1= r7 ;r0= auxL98$3 ;r1= auxL98$0 ;
 r1=( r1  |  auxL98$1 );r1=( r1  |  auxL98$2 );r1=( r1  |  auxL98$3 );signGrad6$0= r1 ;
 signGrad6$1= r0 ;auxL144=~ srcPropag ;sgnMinLt$0=(( auxL145  & ( signGrad6$0  &  signGrad6$0 )) |  tmun33$0 );sgnMinLt$1=(( auxL145  & ( signGrad6$1  &  signGrad6$1 )) |  tmun33$1 );
 tmun33$0= auxL144 ;minsignLt$0=( sgnMinLt$0  &  sgnMinLt$0 );minsignLt$1=( sgnMinLt$1  &  sgnMinLt$1 );sgnMaxLt$e$0[i-1]=(( auxL145  &  signGrad6$0 ) |  tmun34$0 );
 sgnMaxLt$e$1[i-1]=(( auxL145  &  signGrad6$1 ) |  tmun34$1 );tmun34$0= auxL144 ;tmun34$1= auxL144 ;auxL145= srcPropag ;
 auxL98$0= grad$0 ;auxL98$1= grad$1 ;auxL98$2= grad$2 ;auxL98$3= grad$3 ;
 r0= auxL98$3 ;slop$w[i-1]=( r0  >>>  1 );auxL146$0=( auxL98$0  >>>  1 );auxL146$1=( auxL98$1  >>>  1 );
 auxL146$2=( auxL98$2  >>>  1 );auxL146$3=( auxL98$3  >>>  1 );r0= auxL146$0 ;r0=( r0  |  auxL146$1 );
 r0=( r0  |  auxL146$2 );r0=( r0  |  auxL146$3 );r1= auxL146$3 ;signGrad6$0= r0 ;
 signGrad6$1= r1 ;srcPropag= psrcPropag$w[i] ;auxL147=~ srcPropag ;sgnMinLt$0=(( auxL148  & ( signGrad6$0  &  signGrad6$0 )) |  tmun35$0 );
 sgnMinLt$1=(( auxL148  & ( signGrad6$1  &  signGrad6$1 )) |  tmun35$1 );tmun35$0= auxL147 ;r0=( sgnMinLt$0  &  sgnMinLt$0 );r1= r0 ;
 r2=(r0=( sgnMinLt$1  &  sgnMinLt$1 ));r0= minsignLt$0 ;r3= minsignLt$1 ;r4=( r3  |  r2 );
 minsignLt$0=( r4  | (~ r4  & ( r0  &  r1 )));minsignLt$1= r4 ;sgnMaxLt$w$0[i-1]=(( auxL148  &  signGrad6$0 ) |  tmun36$0 );sgnMaxLt$w$1[i-1]=(( auxL148  &  signGrad6$1 ) |  tmun36$1 );
 tmun36$0= auxL147 ;tmun36$1= auxL147 ;auxL148= srcPropag ;srcPropag= psrcPropag$se[i] ;
 r0= grad$0 ;r0=( r0  |  grad$1 );r0=( r0  | ~ grad$2 );r0=( r0  | ( grad$2  ^  grad$3 ));
 gap$h[i-1]=~ r0 ;grad$0=( auxL154$0  ^  auxL99$0 );grad$1=(((r0=( auxL99$0  &  auxL154$0 )) ^  auxL154$1 ) ^  auxL99$1 );grad$2=(((r0=(( r0  &  auxL154$1 ) | ( auxL99$1  & ( r0  |  auxL154$1 )))) ^  auxL154$2 ) ^  auxL99$2 );
 grad$3=(((( r0  &  auxL154$2 ) | ( auxL99$2  & ( r0  |  auxL154$2 ))) ^  auxL154$3 ) ^  auxL99$3 );auxL98$0= grad$0 ;auxL98$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL98$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );
 auxL98$3=(( r0  & ~ grad$2 ) ^ ~ grad$3 );r0= auxL98$3 ;slop$se[i-1]= r0 ;r0= maxSignGradm2$1 ;
 r2= auxL146$0 ;r4= auxL146$1 ;r3= auxL146$2 ;r1=(r5= auxL146$3 );
 r8= auxL98$0 ;r6= auxL98$1 ;r5= auxL98$2 ;r9=(r7= auxL98$3 );
 r11=(r7= r8 );r11=( r11  | (r7=~ r6 ));r11=( r11  | (r7=~((r10= r6 ) ^  r5 )));r11=( r11  | (r7=~(( r10  |  r5 ) ^  r9 )));
 r12= r7 ;r5= maxSignGradm2$0 ;r6=(r8= r11 );r8= r12 ;
 r7= r8 ;r9=(r11= r2 );r9=( r9  | (r11=~ r4 ));r9=( r9  | (r11=~((r10= r4 ) ^  r3 )));
 r9=( r9  | (r11=~(( r10  |  r3 ) ^  r1 )));r8= r11 ;r1=(r2= r9 );r2= r8 ;
 r3= r2 ;r2=( r0  &  r3 );r8=(r4=( r2  | (~ r2  & ((~ r0  &  r5 ) | (~ r3  &  r1 )))));r4= r2 ;
 r9= r4 ;r0=( r9  &  r7 );maxSignGradm2$0=( r0  | (~ r0  & ((~ r9  &  r8 ) | (~ r7  &  r6 ))));maxSignGradm2$1= r0 ;
 r0= auxL98$0 ;r0=( r0  |  auxL98$1 );r0=( r0  |  auxL98$2 );r0=( r0  |  auxL98$3 );
 r1= auxL98$3 ;signGrad6$0= r0 ;signGrad6$1= r1 ;auxL149=~ srcPropag ;
 sgnMinLt$0=(( auxL150  & ( signGrad6$0  &  signGrad6$0 )) |  tmun37$0 );sgnMinLt$1=(( auxL150  & ( signGrad6$1  &  signGrad6$1 )) |  tmun37$1 );tmun37$0= auxL149 ;r2=( sgnMinLt$0  &  sgnMinLt$0 );
 r1= r2 ;r0=(r2=( sgnMinLt$1  &  sgnMinLt$1 ));r2= minsignLt$1 ;r3=( r2  |  r0 );
 r0= minsignLt$0 ;minsignLt$0=( r3  | (~ r3  & ( r0  &  r1 )));minsignLt$1= r3 ;sgnMaxLt$se$0[i-1]=(( auxL150  &  signGrad6$0 ) |  tmun38$0 );
 sgnMaxLt$se$1[i-1]=(( auxL150  &  signGrad6$1 ) |  tmun38$1 );tmun38$0= auxL149 ;tmun38$1= auxL149 ;auxL150= srcPropag ;
 auxL98$0= grad$0 ;auxL98$1= grad$1 ;auxL98$2= grad$2 ;auxL98$3= grad$3 ;
 r0= auxL98$3 ;slop$nw[i]= r0 ;auxL151$0= tmun39$0 ;auxL151$1= tmun39$1 ;
 auxL151$2= tmun39$2 ;auxL151$3= tmun39$3 ;tmun39$0= auxL98$0 ;tmun39$1= auxL98$1 ;
 tmun39$2= auxL98$2 ;tmun39$3= auxL98$3 ;r0= auxL151$3 ;r1= auxL151$0 ;
 r1=( r1  |  auxL151$1 );r1=( r1  |  auxL151$2 );r1=( r1  |  auxL151$3 );signGrad6$0= r1 ;
 signGrad6$1= r0 ;srcPropag= psrcPropag$nw[i] ;auxL152=~ srcPropag ;sgnMinLt$0=(( auxL153  & ( signGrad6$0  &  signGrad6$0 )) |  tmun40$0 );
 sgnMinLt$1=(( auxL153  & ( signGrad6$1  &  signGrad6$1 )) |  tmun40$1 );tmun40$0= auxL152 ;r2=( sgnMinLt$0  &  sgnMinLt$0 );r0= r2 ;
 r1=(r2=( sgnMinLt$1  &  sgnMinLt$1 ));r2= minsignLt$0 ;r3= minsignLt$1 ;r4=( r3  |  r1 );
 minsignLt$0=( r4  | (~ r4  & ( r2  &  r0 )));minsignLt$1= r4 ;sgnMaxLt$nw$0[i-1]=(( auxL153  &  signGrad6$0 ) |  tmun41$0 );sgnMaxLt$nw$1[i-1]=(( auxL153  &  signGrad6$1 ) |  tmun41$1 );
 tmun41$0= auxL152 ;tmun41$1= auxL152 ;auxL153= srcPropag ;srcPropag= psrcPropag$sw[i] ;
 r0= grad$0 ;r0=( r0  |  grad$1 );r0=( r0  | ~ grad$2 );r0=( r0  | ( grad$2  ^  grad$3 ));
 gap$d[i-1]=~ r0 ;grad$0=( auxL154$0  ^ (r1=( auxL99$0  >>>  1 )));grad$1=(((r0=( r1  &  auxL154$0 )) ^  auxL154$1 ) ^ (r1=( auxL99$1  >>>  1 )));grad$2=(((r0=(( r0  &  auxL154$1 ) | ( r1  & ( r0  |  auxL154$1 )))) ^  auxL154$2 ) ^ (r1=( auxL99$2  >>>  1 )));
 grad$3=(((( r0  &  auxL154$2 ) | ( r1  & ( r0  |  auxL154$2 ))) ^  auxL154$3 ) ^ ( auxL99$3  >>>  1 ));auxL154$0= dis$0 ;auxL154$1= dis$1 ;auxL154$2= dis$2 ;
 auxL154$3= dis$3 ;auxL98$0= grad$0 ;auxL98$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL98$2=((r0=( r0  & ~ grad$1 )) ^ ~ grad$2 );
 auxL98$3=(( r0  & ~ grad$2 ) ^ ~ grad$3 );r0= auxL98$3 ;slop$sw[i-1]= r0 ;r0= maxSignGradm2$0 ;
 r3= auxL151$0 ;r5= auxL151$1 ;r1= auxL151$2 ;r2=(r4= auxL151$3 );
 r6= auxL98$0 ;r9= auxL98$1 ;r8= auxL98$2 ;r7=(r4= auxL98$3 );
 r4= maxSignGradm2$1 ;r10= r3 ;r12= r10 ;r10=~ r5 ;
 r12=( r12  |  r10 );r10=~((r13= r5 ) ^  r1 );r12=( r12  |  r10 );r11=(r10=~(( r13  |  r1 ) ^  r2 ));
 r12=( r12  |  r10 );r3=(r2= r12 );r2= r11 ;r1= r2 ;
 r2=( r4  &  r1 );r12=(r5= r6 );r12=( r12  | (r5=~ r9 ));r12=( r12  | (r5=~((r10= r9 ) ^  r8 )));
 r12=( r12  | (r5=~(( r10  |  r8 ) ^  r7 )));r11= r5 ;r6= r12 ;r7= r6 ;
 r5=(r6= r11 );r9=(r6=( r2  | (~ r2  & ((~ r4  &  r0 ) | (~ r1  &  r3 )))));r6= r2 ;r8= r6 ;
 r0=( r8  &  r5 );maxSignGradm2$0=( r0  | (~ r0  & ((~ r8  &  r9 ) | (~ r5  &  r7 ))));maxSignGradm2$1= r0 ;r0= auxL98$0 ;
 r0=( r0  |  auxL98$1 );r0=( r0  |  auxL98$2 );r0=( r0  |  auxL98$3 );r1= auxL98$3 ;
 signGrad6$0= r0 ;signGrad6$1= r1 ;auxL155=~ srcPropag ;sgnMinLt$0=(( auxL156  & ( signGrad6$0  &  signGrad6$0 )) |  tmun42$0 );
 sgnMinLt$1=(( auxL156  & ( signGrad6$1  &  signGrad6$1 )) |  tmun42$1 );tmun42$0= auxL155 ;r2=( sgnMinLt$0  &  sgnMinLt$0 );r1= r2 ;
 r0=(r2=( sgnMinLt$1  &  sgnMinLt$1 ));r2= minsignLt$0 ;r3= minsignLt$1 ;r4=( r3  |  r0 );
 minsignLt$0=( r4  | (~ r4  & ( r2  &  r1 )));minsignLt$1= r4 ;sgnMaxLt$sw$0[i-1]=(( auxL156  &  signGrad6$0 ) |  tmun43$0 );sgnMaxLt$sw$1[i-1]=(( auxL156  &  signGrad6$1 ) |  tmun43$1 );
 tmun43$0= auxL155 ;tmun43$1= auxL155 ;auxL156= srcPropag ;auxL98$0= grad$0 ;
 auxL98$1= grad$1 ;auxL98$2= grad$2 ;auxL98$3= grad$3 ;r0= auxL98$3 ;
 slop$ne[i]=( r0  <<  1 );auxL158$0= tmun44$0 ;auxL158$1= tmun44$1 ;auxL158$2= tmun44$2 ;
 auxL158$3= tmun44$3 ;tmun44$0=( auxL98$0  <<  1 );tmun44$1=( auxL98$1  <<  1 );tmun44$2=( auxL98$2  <<  1 );
 tmun44$3=( auxL98$3  <<  1 );r0= auxL158$0 ;r0=( r0  |  auxL158$1 );r0=( r0  |  auxL158$2 );
 r0=( r0  |  auxL158$3 );r1= auxL158$3 ;signGrad6$0= r0 ;signGrad6$1= r1 ;
 srcPropag= psrcPropag$ne[i] ;auxL161=~ srcPropag ;sgnMinLt$0=(( auxL162  & ( signGrad6$0  &  signGrad6$0 )) |  tmun45$0 );sgnMinLt$1=(( auxL162  & ( signGrad6$1  &  signGrad6$1 )) |  tmun45$1 );
 tmun45$0= auxL161 ;sgnMaxLt$ne$0[i-1]=(( auxL162  &  signGrad6$0 ) |  tmun46$0 );sgnMaxLt$ne$1[i-1]=(( auxL162  &  signGrad6$1 ) |  tmun46$1 );tmun46$0= auxL161 ;
 tmun46$1= auxL161 ;auxL162= srcPropag ;r0= sgnMaxLt$se$1[i-1] ;r2= auxL158$0 ;
 r3= auxL158$1 ;r1= auxL158$2 ;r4=(r5= auxL158$3 );r5= sgnMaxLt$se$0[i-1] ;
 r8=( sgnMinLt$0  &  sgnMinLt$0 );r7= r8 ;r6=(r8=( sgnMinLt$1  &  sgnMinLt$1 ));r8= maxSignGradm2$1 ;
 r9= sgnMaxLt$ne$1[i-1] ;r10= sgnMaxLt$e$1[i-1] ;r11= sgnMaxLt$sw$0[i-1] ;r12= sgnMaxLt$nw$0[i-1] ;
 r13= sgnMaxLt$w$1[i-1] ;r14=( r10  &  r13 );r15= sgnMaxLt$e$0[i-1] ;r16= sgnMaxLt$ne$0[i-1] ;
 r17= maxSignGradm2$0 ;r18= sgnMaxLt$nw$1[i-1] ;r19= minsignLt$0 ;r20= sgnMaxLt$sw$1[i-1] ;
 r21= sgnMaxLt$w$0[i-1] ;r22=(r24=( r14  | (~ r14  & ((~ r10  &  r15 ) | (~ r13  &  r21 )))));r24= r14 ;r23= r24 ;
 r10=( r23  &  r0 );r13=(r15=( r10  | (~ r10  & ((~ r23  &  r22 ) | (~ r0  &  r5 )))));r15= r10 ;r14= r15 ;
 r5= r2 ;r0= r5 ;r5=~ r3 ;r0=( r0  |  r5 );
 r5=~((r10= r3 ) ^  r1 );r0=( r0  |  r5 );r15=(r5=~(( r10  |  r1 ) ^  r4 ));r0=( r0  |  r5 );
 r2=(r3= r0 );r3= r15 ;r1= r3 ;r0=( r8  &  r1 );
 r4=( r0  | (~ r0  & ((~ r8  &  r17 ) | (~ r1  &  r2 ))));r5= r4 ;r3=(r4= r0 );r0= minsignLt$1 ;
 r1=( r0  |  r6 );r8=( r1  | (~ r1  & ( r19  &  r7 )));r6=(r2= r1 );r4= r2 ;
 r0= r2 ;r1=( r14  &  r18 );r7=(r2=( r1  | (~ r1  & ((~ r14  &  r13 ) | (~ r18  &  r12 )))));r2= r1 ;
 r10= r2 ;r1=( r10  &  r20 );r2=(r13=( r1  | (~ r1  & ((~ r10  &  r7 ) | (~ r20  &  r11 )))));r13= r1 ;
 r12= r13 ;r1=( r12  &  r9 );r7=( r1  | (~ r1  & ((~ r12  &  r2 ) | (~ r9  &  r16 ))));r10=(r14= r1 );
 r11= r14 ;r13= r14 ;r12=( r8  ^  r7 );r9= r12 ;
 r12=(((r1=( r7  &  r8 )) ^  r6 ) ^  r10 );r9=( r9  |  r12 );r12=(((r1=(( r1  &  r6 ) | ( r10  & ( r1  |  r6 )))) ^  r4 ) ^  r11 );r9=( r9  |  r12 );
 r2=(r12=(((( r1  &  r4 ) | ( r11  & ( r1  |  r4 ))) ^  r0 ) ^  r13 ));r9=( r9  |  r12 );r4= r9 ;r1= r4 ;
 r0=(r4= r2 );r2=( r3  &  r0 );delta$0[i-1]=( r2  | (~ r2  & ((~ r3  &  r5 ) | (~ r0  &  r1 ))));delta$1[i-1]= r2 ;
 r0= grad$0 ;r0=( r0  |  grad$1 );r0=( r0  | ~ grad$2 );r0=( r0  | ( grad$2  ^  grad$3 ));
 gap$ad[i-1]=~ r0 ;
  }
  p.mirror(delta);
p.prepareBit(slop);p.prepareBit(delta);p.prepareBit(sgnMaxLt);p.prepareBit(gap)
 ;
  }
public static int ltapex2_4_4_1_1GateCount=27;
 public static void ltapex2_4_4_1_1(PrShift p,int [][] pdeef,int [][] psegmentderiv,int [][] pdifff,int [][] gradltapex2){
 int[] gradltapex2$h1=gradltapex2[0],gradltapex2$h2=gradltapex2[1],gradltapex2$d1=gradltapex2[2],gradltapex2$d2=gradltapex2[3],gradltapex2$ad1=gradltapex2[4],gradltapex2$ad2=gradltapex2[5],pdeef$h1$0=pdeef[0],pdeef$h1$1=pdeef[1],pdeef$h1$2=pdeef[2],pdeef$h1$3=pdeef[3],pdeef$h2$0=pdeef[4],pdeef$h2$1=pdeef[5],pdeef$h2$2=pdeef[6],pdeef$h2$3=pdeef[7],pdeef$d1$0=pdeef[8],pdeef$d1$1=pdeef[9],pdeef$d1$2=pdeef[10],pdeef$d1$3=pdeef[11],pdeef$d2$0=pdeef[12],pdeef$d2$1=pdeef[13],pdeef$d2$2=pdeef[14],pdeef$d2$3=pdeef[15],pdeef$ad1$0=pdeef[16],pdeef$ad1$1=pdeef[17],pdeef$ad1$2=pdeef[18],pdeef$ad1$3=pdeef[19],pdeef$ad2$0=pdeef[20],pdeef$ad2$1=pdeef[21],pdeef$ad2$2=pdeef[22],pdeef$ad2$3=pdeef[23],psegmentderiv$h$0=psegmentderiv[0],psegmentderiv$h$1=psegmentderiv[1],psegmentderiv$h$2=psegmentderiv[2],psegmentderiv$h$3=psegmentderiv[3],psegmentderiv$d$0=psegmentderiv[4],psegmentderiv$d$1=psegmentderiv[5],psegmentderiv$d$2=psegmentderiv[6],psegmentderiv$d$3=psegmentderiv[7],psegmentderiv$ad$0=psegmentderiv[8],psegmentderiv$ad$1=psegmentderiv[9],psegmentderiv$ad$2=psegmentderiv[10],psegmentderiv$ad$3=psegmentderiv[11],pdifff$h=pdifff[0],pdifff$d=pdifff[1],pdifff$ad=pdifff[2];

// initialisation 
 int auxL105=0,r0=0;
for (int i = 1; i < pdeef$h1$0.length -1; i++) {
 r0=( psegmentderiv$h$0[i]  &  pdeef$h1$0[i] );r0=( r0  | ( psegmentderiv$h$1[i]  &  pdeef$h1$1[i] ));r0=( r0  | ( psegmentderiv$h$2[i]  &  pdeef$h1$2[i] ));r0=( r0  | ( psegmentderiv$h$3[i]  &  pdeef$h1$3[i] ));
 auxL105= r0 ;gradltapex2$h1[i]= auxL105 ;gradltapex2$h2[i]=(~ auxL105  &  pdifff$h[i] );r0=( psegmentderiv$d$0[i]  &  pdeef$d1$0[i] );
 r0=( r0  | ( psegmentderiv$d$1[i]  &  pdeef$d1$1[i] ));r0=( r0  | ( psegmentderiv$d$2[i]  &  pdeef$d1$2[i] ));r0=( r0  | ( psegmentderiv$d$3[i]  &  pdeef$d1$3[i] ));auxL105= r0 ;
 gradltapex2$d1[i]= auxL105 ;gradltapex2$d2[i]=(~ auxL105  &  pdifff$d[i] );r0=( psegmentderiv$ad$0[i]  &  pdeef$ad1$0[i] );r0=( r0  | ( psegmentderiv$ad$1[i]  &  pdeef$ad1$1[i] ));
 r0=( r0  | ( psegmentderiv$ad$2[i]  &  pdeef$ad1$2[i] ));r0=( r0  | ( psegmentderiv$ad$3[i]  &  pdeef$ad1$3[i] ));auxL105= r0 ;gradltapex2$ad1[i]= auxL105 ;
 gradltapex2$ad2[i]=(~ auxL105  &  pdifff$ad[i] );
  }
  ;
p.prepareBit(gradltapex2)
 ;
  }
public static int lt_4_4_1GateCount=45;
 public static void lt_4_4_1(PrShift p,int [][] pdis,int [][] psegment,int [][] gradlt){
 int[] gradlt$h1=gradlt[0],gradlt$h2=gradlt[1],gradlt$d1=gradlt[2],gradlt$d2=gradlt[3],gradlt$ad1=gradlt[4],gradlt$ad2=gradlt[5],pdis$0=pdis[0],pdis$1=pdis[1],pdis$2=pdis[2],pdis$3=pdis[3],psegment$h$0=psegment[0],psegment$h$1=psegment[1],psegment$h$2=psegment[2],psegment$h$3=psegment[3],psegment$d$0=psegment[4],psegment$d$1=psegment[5],psegment$d$2=psegment[6],psegment$d$3=psegment[7],psegment$ad$0=psegment[8],psegment$ad$1=psegment[9],psegment$ad$2=psegment[10],psegment$ad$3=psegment[11];

// initialisation 
 int auxL106=0,auxL136$0=0,auxL136$1=0,auxL136$2=0,auxL136$3=0,auxL137$0=0,auxL137$1=0,auxL137$2=0,auxL137$3=0,auxTmp1$0=0,auxTmp1$1=0,auxTmp1$2=0,auxTmp1$3=0,r0=0,segment$0=0,segment$1=0,segment$2=0,segment$3=0,tmun10$0=0,tmun10$1=0,tmun10$2=0,tmun10$3=0,tmun11$0=0,tmun11$1=0,tmun11$2=0,tmun11$3=0,tmun12=0,tmun13$0=0,tmun13$1=0,tmun13$2=0,tmun13$3=0,tmun14=0,tmun15$0=0,tmun15$1=0,tmun15$2=0,tmun15$3=0,tmun16=0;
for (int i = 1; i < pdis$0.length -1; i++) {
 auxL137$0= pdis$0[i] ;auxL137$1= pdis$1[i] ;auxL137$2= pdis$2[i] ;auxL137$3= pdis$3[i] ;
 auxTmp1$0= auxL136$0 ;auxTmp1$1= auxL136$1 ;auxTmp1$2= auxL136$2 ;auxTmp1$3= auxL136$3 ;
 segment$0= psegment$h$0[i] ;segment$1= psegment$h$1[i] ;segment$2= psegment$h$2[i] ;segment$3= psegment$h$3[i] ;
 r0=( tmun11$0  &  auxTmp1$0 );r0=( r0  | ( tmun11$1  &  auxTmp1$1 ));r0=( r0  | ( tmun11$2  &  auxTmp1$2 ));r0=( r0  | ( tmun11$3  &  auxTmp1$3 ));
 auxL106= r0 ;tmun10$0=( auxL137$0  <<  1 );tmun10$1=( auxL137$1  <<  1 );tmun10$2=( auxL137$2  <<  1 );
 tmun10$3=( auxL137$3  <<  1 );tmun11$3= segment$3 ;tmun11$2=(~(r0= segment$3 ) &  segment$2 );tmun11$1=(~(r0= segment$2 ) &  segment$1 );
 tmun11$0=(~ segment$1  &  segment$0 );gradlt$h1[i-1]= auxL106 ;gradlt$h2[i-1]=(~ auxL106  &  tmun12 );r0= segment$0 ;
 tmun12= r0 ;auxTmp1$0= auxL136$0 ;auxTmp1$1= auxL136$1 ;auxTmp1$2= auxL136$2 ;
 auxTmp1$3= auxL136$3 ;segment$0= psegment$d$0[i] ;segment$1= psegment$d$1[i] ;segment$2= psegment$d$2[i] ;
 segment$3= psegment$d$3[i] ;r0=( tmun13$0  &  auxTmp1$0 );r0=( r0  | ( tmun13$1  &  auxTmp1$1 ));r0=( r0  | ( tmun13$2  &  auxTmp1$2 ));
 r0=( r0  | ( tmun13$3  &  auxTmp1$3 ));auxL106= r0 ;tmun13$3= segment$3 ;tmun13$2=(~(r0= segment$3 ) &  segment$2 );
 tmun13$1=(~(r0= segment$2 ) &  segment$1 );tmun13$0=(~ segment$1  &  segment$0 );gradlt$d1[i-1]= auxL106 ;gradlt$d2[i-1]=(~ auxL106  &  tmun14 );
 r0= segment$0 ;tmun14= r0 ;auxTmp1$0= auxL136$0 ;auxTmp1$1= auxL136$1 ;
 auxTmp1$2= auxL136$2 ;auxTmp1$3= auxL136$3 ;auxL136$0= auxL137$0 ;auxL136$1= auxL137$1 ;
 auxL136$2= auxL137$2 ;auxL136$3= auxL137$3 ;segment$0= psegment$ad$0[i] ;segment$1= psegment$ad$1[i] ;
 segment$2= psegment$ad$2[i] ;segment$3= psegment$ad$3[i] ;r0=( tmun15$0  &  auxTmp1$0 );r0=( r0  | ( tmun15$1  &  auxTmp1$1 ));
 r0=( r0  | ( tmun15$2  &  auxTmp1$2 ));r0=( r0  | ( tmun15$3  &  auxTmp1$3 ));auxL106= r0 ;tmun15$3= segment$3 ;
 tmun15$2=(~(r0= segment$3 ) &  segment$2 );tmun15$1=(~(r0= segment$2 ) &  segment$1 );tmun15$0=(~ segment$1  &  segment$0 );gradlt$ad1[i-1]= auxL106 ;
 gradlt$ad2[i-1]=(~ auxL106  &  tmun16 );r0= segment$0 ;tmun16= r0 ;
  }
  ;
p.prepareBit(gradlt)
 ;
  }
public static int lt_3_3_1GateCount=33;
 public static void lt_3_3_1(PrShift p,int [][] pdis,int [][] psegment,int [][] gradlt){
 int[] gradlt$h1=gradlt[0],gradlt$h2=gradlt[1],gradlt$d1=gradlt[2],gradlt$d2=gradlt[3],gradlt$ad1=gradlt[4],gradlt$ad2=gradlt[5],pdis$0=pdis[0],pdis$1=pdis[1],pdis$2=pdis[2],psegment$h$0=psegment[0],psegment$h$1=psegment[1],psegment$h$2=psegment[2],psegment$d$0=psegment[3],psegment$d$1=psegment[4],psegment$d$2=psegment[5],psegment$ad$0=psegment[6],psegment$ad$1=psegment[7],psegment$ad$2=psegment[8];

// initialisation 
 int auxL106=0,auxL142$0=0,auxL142$1=0,auxL142$2=0,auxL143$0=0,auxL143$1=0,auxL143$2=0,auxTmp2$0=0,auxTmp2$1=0,auxTmp2$2=0,r0=0,segment$0=0,segment$1=0,segment$2=0,tmun25$0=0,tmun25$1=0,tmun25$2=0,tmun26$0=0,tmun26$1=0,tmun26$2=0,tmun27=0,tmun28$0=0,tmun28$1=0,tmun28$2=0,tmun29=0,tmun30$0=0,tmun30$1=0,tmun30$2=0,tmun31=0;
for (int i = 1; i < pdis$0.length -1; i++) {
 auxL143$0= pdis$0[i] ;auxL143$1= pdis$1[i] ;auxL143$2= pdis$2[i] ;auxTmp2$0= auxL142$0 ;
 auxTmp2$1= auxL142$1 ;auxTmp2$2= auxL142$2 ;segment$0= psegment$h$0[i] ;segment$1= psegment$h$1[i] ;
 segment$2= psegment$h$2[i] ;r0=( tmun26$0  &  auxTmp2$0 );r0=( r0  | ( tmun26$1  &  auxTmp2$1 ));r0=( r0  | ( tmun26$2  &  auxTmp2$2 ));
 auxL106= r0 ;tmun26$2= segment$2 ;tmun26$1=(~(r0= segment$2 ) &  segment$1 );tmun26$0=(~ segment$1  &  segment$0 );
 tmun25$0=( auxL143$0  <<  1 );tmun25$1=( auxL143$1  <<  1 );tmun25$2=( auxL143$2  <<  1 );gradlt$h1[i-1]= auxL106 ;
 gradlt$h2[i-1]=(~ auxL106  &  tmun27 );r0= segment$0 ;tmun27= r0 ;auxTmp2$0= auxL142$0 ;
 auxTmp2$1= auxL142$1 ;auxTmp2$2= auxL142$2 ;segment$0= psegment$d$0[i] ;segment$1= psegment$d$1[i] ;
 segment$2= psegment$d$2[i] ;r0=( tmun28$0  &  auxTmp2$0 );r0=( r0  | ( tmun28$1  &  auxTmp2$1 ));r0=( r0  | ( tmun28$2  &  auxTmp2$2 ));
 auxL106= r0 ;tmun28$2= segment$2 ;tmun28$1=(~(r0= segment$2 ) &  segment$1 );tmun28$0=(~ segment$1  &  segment$0 );
 gradlt$d1[i-1]= auxL106 ;gradlt$d2[i-1]=(~ auxL106  &  tmun29 );r0= segment$0 ;tmun29= r0 ;
 auxTmp2$0= auxL142$0 ;auxTmp2$1= auxL142$1 ;auxTmp2$2= auxL142$2 ;auxL142$0= auxL143$0 ;
 auxL142$1= auxL143$1 ;auxL142$2= auxL143$2 ;segment$0= psegment$ad$0[i] ;segment$1= psegment$ad$1[i] ;
 segment$2= psegment$ad$2[i] ;r0=( tmun30$0  &  auxTmp2$0 );r0=( r0  | ( tmun30$1  &  auxTmp2$1 ));r0=( r0  | ( tmun30$2  &  auxTmp2$2 ));
 auxL106= r0 ;tmun30$2= segment$2 ;tmun30$1=(~(r0= segment$2 ) &  segment$1 );tmun30$0=(~ segment$1  &  segment$0 );
 gradlt$ad1[i-1]= auxL106 ;gradlt$ad2[i-1]=(~ auxL106  &  tmun31 );r0= segment$0 ;tmun31= r0 ;
  }
  ;
p.prepareBit(gradlt)
 ;
  }
public static int slopGradGap_2_1_2GateCount=24;
 public static void slopGradGap_2_1_2(PrShift p,int [][] pdiiiis,int [][] resultCA,int [][] auxL08){
 int[] resultCA$e=resultCA[0],resultCA$se=resultCA[1],resultCA$sw=resultCA[2],resultCA$w=resultCA[3],resultCA$nw=resultCA[4],resultCA$ne=resultCA[5],auxL08$h1$0=auxL08[0],auxL08$h1$1=auxL08[1],auxL08$h2$0=auxL08[2],auxL08$h2$1=auxL08[3],auxL08$d1$0=auxL08[4],auxL08$d1$1=auxL08[5],auxL08$d2$0=auxL08[6],auxL08$d2$1=auxL08[7],auxL08$ad1$0=auxL08[8],auxL08$ad1$1=auxL08[9],auxL08$ad2$0=auxL08[10],auxL08$ad2$1=auxL08[11],pdiiiis$0=pdiiiis[0],pdiiiis$1=pdiiiis[1];

// initialisation 
 int auxL09$0=0,auxL09$1=0,auxL10$0=0,auxL10$1=0,auxL11$0=0,auxL11$1=0,diiiis$0=0,diiiis$1=0,r0=0,tmun00$0=0,tmun00$1=0;
for (int i = 1; i < pdiiiis$0.length -1; i++) {
 diiiis$0= pdiiiis$0[i] ;diiiis$1= pdiiiis$1[i] ;auxL10$0= diiiis$0 ;auxL10$1=(~ diiiis$0  ^ ~ diiiis$1 );
 auxL09$0= tmun00$0 ;auxL09$1= tmun00$1 ;tmun00$0=((r0=( auxL10$0  <<  1 )) ^  diiiis$0 );tmun00$1=((( diiiis$0  &  r0 ) ^ ( auxL10$1  <<  1 )) ^  diiiis$1 );
 auxL08$h1$0[i-1]= auxL09$0 ;auxL08$h1$1[i-1]=(~ auxL09$0  ^ ~ auxL09$1 );r0= auxL08$h1$1[i-1] ;resultCA$e[i-1]= r0 ;
 auxL08$h2$0[i-1]= auxL09$0 ;auxL08$h2$1[i-1]= auxL09$1 ;r0= auxL08$h2$1[i-1] ;resultCA$w[i-1]=( r0  >>>  1 );
 auxL09$0=( auxL11$0  ^  auxL10$0 );auxL09$1=((( auxL10$0  &  auxL11$0 ) ^  auxL11$1 ) ^  auxL10$1 );auxL08$d1$0[i-1]= auxL09$0 ;auxL08$d1$1[i-1]=(~ auxL09$0  ^ ~ auxL09$1 );
 r0= auxL08$d1$1[i-1] ;resultCA$se[i-1]= r0 ;r0= auxL08$d2$1[i-1] ;resultCA$nw[i-1]= r0 ;
 auxL08$d2$0[i-1]= auxL09$0 ;auxL08$d2$1[i-1]= auxL09$1 ;auxL09$0=( auxL11$0  ^ (r0=( auxL10$0  >>>  1 )));auxL09$1=((( r0  &  auxL11$0 ) ^  auxL11$1 ) ^ ( auxL10$1  >>>  1 ));
 auxL11$0= diiiis$0 ;auxL11$1= diiiis$1 ;auxL08$ad1$0[i-1]= auxL09$0 ;auxL08$ad1$1[i-1]=(~ auxL09$0  ^ ~ auxL09$1 );
 r0= auxL08$ad1$1[i-1] ;resultCA$sw[i-1]= r0 ;r0= auxL08$ad2$1[i-1] ;resultCA$ne[i-1]=( r0  <<  1 );
 auxL08$ad2$0[i-1]= auxL09$0 ;auxL08$ad2$1[i-1]= auxL09$1 ;
  }
  ;
p.prepareBit(resultCA);p.prepareBit(auxL08)
 ;
  }
public static int slopDeltaDist_2_1_2_1_1GateCount=169;
 public static void slopDeltaDist_2_1_2_1_1(PrShift p,int [][] pdis,int [][] slop,int [][] deltaR,int [][] level,int [][] resultCA){
 int[] slop$e=slop[0],slop$se=slop[1],slop$sw=slop[2],slop$w=slop[3],slop$nw=slop[4],slop$ne=slop[5],deltaR$0=deltaR[0],deltaR$1=deltaR[1],level$h=level[0],level$d=level[1],level$ad=level[2],resultCA$h=resultCA[0],resultCA$d=resultCA[1],resultCA$ad=resultCA[2],pdis$0=pdis[0],pdis$1=pdis[1];

// initialisation 
 int auxL05=0,auxL06$0=0,auxL06$1=0,auxL07$0=0,auxL07$1=0,auxL12$0=0,auxL12$1=0,auxL13$0=0,auxL13$1=0,auxL13$2=0,auxL13$3=0,auxL13$4=0,auxL13$5=0,auxL13$6=0,auxL14$0=0,auxL14$1=0,auxL14$2=0,auxL14$3=0,auxO11=0,delta$0=0,delta$1=0,dis$0=0,dis$1=0,grad$0=0,grad$1=0,r0=0,r1=0,r10=0,r11=0,r12=0,r2=0,r3=0,r4=0,r5=0,r6=0,r7=0,r8=0,r9=0,tmun01$0=0,tmun01$1=0,tmun02$0=0,tmun02$1=0,tmun03$0=0,tmun03$1=0;
for (int i = 1; i < pdis$0.length -1; i++) {
 dis$0= pdis$0[i] ;dis$1= pdis$1[i] ;auxL07$0= dis$0 ;auxL07$1=(~ dis$0  ^ ~ dis$1 );
 grad$0= tmun01$0 ;grad$1= tmun01$1 ;tmun01$0=((r0=( auxL07$0  <<  1 )) ^  dis$0 );tmun01$1=((( dis$0  &  r0 ) ^ ( auxL07$1  <<  1 )) ^  dis$1 );
 auxL06$0= grad$0 ;auxL06$1=(~ grad$0  ^ ~ grad$1 );r7= auxL06$0 ;r4=(r5= auxL06$1 );
 r3= r5 ;r6= r5 ;r0= r5 ;r1= r5 ;
 r2= r5 ;r8=(r10= r7 );r8=( r8  | (r10=~ r4 ));r8=( r8  | (r10=((r9= r4 ) ^  r3 )));
 r8=( r8  | (r10=((r9=( r9  &  r3 )) ^  r6 )));r8=( r8  | (r10=((r9=( r9  &  r6 )) ^  r0 )));r8=( r8  | (r10=((r9=( r9  &  r0 )) ^  r1 )));r8=( r8  | (r10=(( r9  &  r1 ) ^  r2 )));
 r5= r10 ;delta$0= r8 ;delta$1= r5 ;r0= auxL06$1 ;
 auxL05= r0 ;slop$e[i-1]= auxL05 ;auxO11= auxL05 ;auxL06$0= grad$0 ;
 auxL06$1= grad$1 ;r0= delta$1 ;r1= delta$0 ;r5=( auxL06$0  >>>  1 );
 r2=(r9=( auxL06$1  >>>  1 ));r6= r9 ;r3= r9 ;r4= r9 ;
 r8= r9 ;r7= r9 ;r9=(r10= r5 );r9=( r9  | (r10=~ r2 ));
 r9=( r9  | (r10=((r12= r2 ) ^  r6 )));r9=( r9  | (r10=((r12=( r12  &  r6 )) ^  r3 )));r9=( r9  | (r10=((r12=( r12  &  r3 )) ^  r4 )));r9=( r9  | (r10=((r12=( r12  &  r4 )) ^  r8 )));
 r9=( r9  | (r10=(( r12  &  r8 ) ^  r7 )));r11= r10 ;r3= r9 ;r4= r3 ;
 r2=(r3= r11 );r3=( r0  |  r2 );delta$0=( r3  | (~ r3  & ( r1  &  r4 )));delta$1= r3 ;
 r0= auxL06$1 ;auxL05= r0 ;slop$w[i-1]=( auxL05  >>>  1 );level$h[i-1]=~( auxO11  |  auxL05 );
 r0=(r2= grad$0 );r0=( r0  | (r2=(r1= grad$1 )));r0=( r0  | ~(r2= r1 ));r0=( r0  | ( r2  ^  r1 ));
 resultCA$h[i-1]=~ r0 ;grad$0=( auxL12$0  ^  auxL07$0 );grad$1=((( auxL07$0  &  auxL12$0 ) ^  auxL12$1 ) ^  auxL07$1 );auxL06$0= grad$0 ;
 auxL06$1=(~ grad$0  ^ ~ grad$1 );r0= delta$0 ;r1= delta$1 ;r2= auxL06$0 ;
 r5=(r4= auxL06$1 );r7= r4 ;r8= r4 ;r6= r4 ;
 r3= r4 ;r9= r4 ;r4= r2 ;r11= r4 ;
 r4=~ r5 ;r11=( r11  |  r4 );r4=((r12= r5 ) ^  r7 );r11=( r11  |  r4 );
 r4=((r12=( r12  &  r7 )) ^  r8 );r11=( r11  |  r4 );r4=((r12=( r12  &  r8 )) ^  r6 );r11=( r11  |  r4 );
 r4=((r12=( r12  &  r6 )) ^  r3 );r11=( r11  |  r4 );r10=(r4=(( r12  &  r3 ) ^  r9 ));r11=( r11  |  r4 );
 r4=(r2= r11 );r2= r10 ;r3= r2 ;r2=( r1  |  r3 );
 delta$0=( r2  | (~ r2  & ( r0  &  r4 )));delta$1= r2 ;r0= auxL06$1 ;auxL05= r0 ;
 slop$se[i-1]= auxL05 ;auxO11= auxL05 ;auxL06$0= grad$0 ;auxL06$1= grad$1 ;
 r0= delta$1 ;r8= tmun02$0 ;r7=(r3= tmun02$1 );r5= r3 ;
 r1= r3 ;r4= r3 ;r6= r3 ;r2= r3 ;
 r3= delta$0 ;r11= r8 ;r10= r11 ;r11=~ r7 ;
 r10=( r10  |  r11 );r11=((r12= r7 ) ^  r5 );r10=( r10  |  r11 );r11=((r12=( r12  &  r5 )) ^  r1 );
 r10=( r10  |  r11 );r11=((r12=( r12  &  r1 )) ^  r4 );r10=( r10  |  r11 );r11=((r12=( r12  &  r4 )) ^  r6 );
 r10=( r10  |  r11 );r9=(r11=(( r12  &  r6 ) ^  r2 ));r10=( r10  |  r11 );r4=(r2= r10 );
 r2= r9 ;r1= r2 ;r2=( r0  |  r1 );delta$0=( r2  | (~ r2  & ( r3  &  r4 )));
 delta$1= r2 ;tmun02$0= auxL06$0 ;tmun02$1= auxL06$1 ;r0= auxL06$1 ;
 auxL05= r0 ;slop$nw[i]= auxL05 ;level$d[i-1]=~( auxO11  |  auxL05 );r1=(r0= grad$0 );
 r1=( r1  | (r0=(r2= grad$1 )));r1=( r1  | ~(r0= r2 ));r1=( r1  | ( r0  ^  r2 ));resultCA$d[i-1]=~ r1 ;
 grad$0=( auxL12$0  ^ (r0=( auxL07$0  >>>  1 )));grad$1=((( r0  &  auxL12$0 ) ^  auxL12$1 ) ^ ( auxL07$1  >>>  1 ));auxL12$0= dis$0 ;auxL12$1= dis$1 ;
 auxL06$0= grad$0 ;auxL06$1= grad$1 ;r5= tmun03$0 ;r4=(r7= tmun03$1 );
 r1= r7 ;r0= r7 ;r6= r7 ;r3= r7 ;
 r2= r7 ;r7= delta$0 ;r9=(r10= r5 );r9=( r9  | (r10=~ r4 ));
 r9=( r9  | (r10=((r8= r4 ) ^  r1 )));r9=( r9  | (r10=((r8=( r8  &  r1 )) ^  r0 )));r9=( r9  | (r10=((r8=( r8  &  r0 )) ^  r6 )));r9=( r9  | (r10=((r8=( r8  &  r6 )) ^  r3 )));
 r9=( r9  | (r10=(( r8  &  r3 ) ^  r2 )));r11= r10 ;r2= r9 ;r0= r2 ;
 r1=(r2= r11 );r2= delta$1 ;r3=( r2  |  r1 );delta$0=( r3  | (~ r3  & ( r7  &  r0 )));
 delta$1= r3 ;tmun03$0=( auxL06$0  <<  1 );tmun03$1=( auxL06$1  <<  1 );r0= auxL06$1 ;
 auxL05= r0 ;slop$ne[i]=( auxL05  <<  1 );auxO11= auxL05 ;auxL06$0= grad$0 ;
 auxL06$1=(~ grad$0  ^ ~ grad$1 );r0= delta$0 ;r1= delta$1 ;r8= auxL06$0 ;
 r4=(r7= auxL06$1 );r3= r7 ;r6= r7 ;r5= r7 ;
 r9= r7 ;r2= r7 ;r10=(r7= r8 );r10=( r10  | (r7=~ r4 ));
 r10=( r10  | (r7=((r11= r4 ) ^  r3 )));r10=( r10  | (r7=((r11=( r11  &  r3 )) ^  r6 )));r10=( r10  | (r7=((r11=( r11  &  r6 )) ^  r5 )));r10=( r10  | (r7=((r11=( r11  &  r5 )) ^  r9 )));
 r10=( r10  | (r7=(( r11  &  r9 ) ^  r2 )));r12= r7 ;r2=(r4= r10 );r4= r12 ;
 r3= r4 ;r4=( r1  |  r3 );deltaR$0[i-1]=( r4  | (~ r4  & ( r0  &  r2 )));deltaR$1[i-1]= r4 ;
 r0= auxL06$1 ;auxL05= r0 ;slop$sw[i-1]= auxL05 ;level$ad[i-1]=~( auxO11  |  auxL05 );
 r0=(r1= grad$0 );r0=( r0  | (r1=(r2= grad$1 )));r0=( r0  | ~(r1= r2 ));r0=( r0  | ( r1  ^  r2 ));
 resultCA$ad[i-1]=~ r0 ;
  }
  p.mirror(deltaR);
p.prepareBit(slop);p.prepareBit(deltaR);p.prepareBit(level);p.prepareBit(resultCA)
 ;
  }
  
public static int slopDeltaDist_3_1_2_1_1GateCount=203;
 public static void slopDeltaDist_3_1_2_1_1(PrShift p,int [][] pdis,int [][] slop,int [][] deltaR,int [][] level,int [][] resultCA){
 int[] slop$e=slop[0],slop$se=slop[1],slop$sw=slop[2],slop$w=slop[3],slop$nw=slop[4],slop$ne=slop[5],deltaR$0=deltaR[0],deltaR$1=deltaR[1],level$h=level[0],level$d=level[1],level$ad=level[2],resultCA$h=resultCA[0],resultCA$d=resultCA[1],resultCA$ad=resultCA[2],pdis$0=pdis[0],pdis$1=pdis[1],pdis$2=pdis[2];

// initialisation 
 int auxL05=0,auxL06$0=0,auxL06$1=0,auxL06$2=0,auxL07$0=0,auxL07$1=0,auxL07$2=0,auxL13$0=0,auxL13$1=0,auxL13$2=0,auxL14$0=0,auxL14$1=0,auxL14$2=0,auxL14$3=0,auxL14$4=0,auxL14$5=0,auxL14$6=0,auxL15$0=0,auxL15$1=0,auxL15$2=0,auxL15$3=0,auxO11=0,delta$0=0,delta$1=0,dis$0=0,dis$1=0,dis$2=0,grad$0=0,grad$1=0,grad$2=0,r0=0,r1=0,r10=0,r11=0,r12=0,r2=0,r3=0,r4=0,r5=0,r6=0,r7=0,r8=0,r9=0,tmun02$0=0,tmun02$1=0,tmun02$2=0,tmun03$0=0,tmun03$1=0,tmun03$2=0,tmun04$0=0,tmun04$1=0,tmun04$2=0;
for (int i = 1; i < pdis$0.length -1; i++) {
 dis$0= pdis$0[i] ;dis$1= pdis$1[i] ;dis$2= pdis$2[i] ;auxL07$0= dis$0 ;
 auxL07$1=((r0=~ dis$0 ) ^ ~ dis$1 );auxL07$2=(( r0  & ~ dis$1 ) ^ ~ dis$2 );grad$0= tmun02$0 ;grad$1= tmun02$1 ;
 grad$2= tmun02$2 ;tmun02$0=((r1=( auxL07$0  <<  1 )) ^  dis$0 );tmun02$1=(((r0=( dis$0  &  r1 )) ^ (r1=( auxL07$1  <<  1 ))) ^  dis$1 );tmun02$2=(((( r0  &  r1 ) | ( dis$1  & ( r0  |  r1 ))) ^ ( auxL07$2  <<  1 )) ^  dis$2 );
 auxL06$0= grad$0 ;auxL06$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL06$2=(( r0  & ~ grad$1 ) ^ ~ grad$2 );r7= auxL06$0 ;
 r4= auxL06$1 ;r3=(r6= auxL06$2 );r5= r6 ;r0= r6 ;
 r1= r6 ;r2= r6 ;r10=(r8= r7 );r10=( r10  | (r8=~ r4 ));
 r10=( r10  | (r8=((r9= r4 ) ^  r3 )));r10=( r10  | (r8=((r9=( r9  &  r3 )) ^  r5 )));r10=( r10  | (r8=((r9=( r9  &  r5 )) ^  r0 )));r10=( r10  | (r8=((r9=( r9  &  r0 )) ^  r1 )));
 r10=( r10  | (r8=(( r9  &  r1 ) ^  r2 )));r6= r8 ;delta$0= r10 ;delta$1= r6 ;
 r0= auxL06$2 ;auxL05= r0 ;slop$e[i-1]= auxL05 ;auxO11= auxL05 ;
 auxL06$0= grad$0 ;auxL06$1= grad$1 ;auxL06$2= grad$2 ;r0= delta$1 ;
 r1= delta$0 ;r6=( auxL06$0  >>>  1 );r2=( auxL06$1  >>>  1 );r8=(r3=( auxL06$2  >>>  1 ));
 r4= r3 ;r5= r3 ;r7= r3 ;r9= r3 ;
 r3=(r11= r6 );r3=( r3  | (r11=~ r2 ));r3=( r3  | (r11=((r10= r2 ) ^  r8 )));r3=( r3  | (r11=((r10=( r10  &  r8 )) ^  r4 )));
 r3=( r3  | (r11=((r10=( r10  &  r4 )) ^  r5 )));r3=( r3  | (r11=((r10=( r10  &  r5 )) ^  r7 )));r3=( r3  | (r11=(( r10  &  r7 ) ^  r9 )));r12= r11 ;
 r4= r3 ;r5= r4 ;r2=(r4= r12 );r3=( r0  |  r2 );
 delta$0=( r3  | (~ r3  & ( r1  &  r5 )));delta$1= r3 ;r0= auxL06$2 ;auxL05= r0 ;
 slop$w[i-1]=( auxL05  >>>  1 );level$h[i-1]=~( auxO11  |  auxL05 );r0=(r1= grad$0 );r0=( r0  | (r1= grad$1 ));
 r0=( r0  | ~(r1=(r2= grad$2 )));r0=( r0  | ( r1  ^  r2 ));resultCA$h[i-1]=~ r0 ;grad$0=( auxL13$0  ^  auxL07$0 );
 grad$1=(((r0=( auxL07$0  &  auxL13$0 )) ^  auxL13$1 ) ^  auxL07$1 );grad$2=(((( r0  &  auxL13$1 ) | ( auxL07$1  & ( r0  |  auxL13$1 ))) ^  auxL13$2 ) ^  auxL07$2 );auxL06$0= grad$0 ;auxL06$1=((r0=~ grad$0 ) ^ ~ grad$1 );
 auxL06$2=(( r0  & ~ grad$1 ) ^ ~ grad$2 );r0= delta$0 ;r1= delta$1 ;r2= auxL06$0 ;
 r4= auxL06$1 ;r6=(r8= auxL06$2 );r7= r8 ;r5= r8 ;
 r3= r8 ;r9= r8 ;r10= r2 ;r12= r10 ;
 r10=~ r4 ;r12=( r12  |  r10 );r10=((r8= r4 ) ^  r6 );r12=( r12  |  r10 );
 r10=((r8=( r8  &  r6 )) ^  r7 );r12=( r12  |  r10 );r10=((r8=( r8  &  r7 )) ^  r5 );r12=( r12  |  r10 );
 r10=((r8=( r8  &  r5 )) ^  r3 );r12=( r12  |  r10 );r11=(r10=(( r8  &  r3 ) ^  r9 ));r12=( r12  |  r10 );
 r4=(r2= r12 );r2= r11 ;r3= r2 ;r2=( r1  |  r3 );
 delta$0=( r2  | (~ r2  & ( r0  &  r4 )));delta$1= r2 ;r0= auxL06$2 ;auxL05= r0 ;
 slop$se[i-1]= auxL05 ;auxO11= auxL05 ;auxL06$0= grad$0 ;auxL06$1= grad$1 ;
 auxL06$2= grad$2 ;r7= tmun03$0 ;r6= tmun03$1 ;r3=(r4= tmun03$2 );
 r0= r4 ;r2= r4 ;r5= r4 ;r1= r4 ;
 r4= delta$1 ;r8= delta$0 ;r11= r7 ;r10= r11 ;
 r11=~ r6 ;r10=( r10  |  r11 );r11=((r12= r6 ) ^  r3 );r10=( r10  |  r11 );
 r11=((r12=( r12  &  r3 )) ^  r0 );r10=( r10  |  r11 );r11=((r12=( r12  &  r0 )) ^  r2 );r10=( r10  |  r11 );
 r11=((r12=( r12  &  r2 )) ^  r5 );r10=( r10  |  r11 );r9=(r11=(( r12  &  r5 ) ^  r1 ));r10=( r10  |  r11 );
 r2=(r1= r10 );r1= r9 ;r0= r1 ;r1=( r4  |  r0 );
 delta$0=( r1  | (~ r1  & ( r8  &  r2 )));delta$1= r1 ;tmun03$0= auxL06$0 ;tmun03$1= auxL06$1 ;
 tmun03$2= auxL06$2 ;r0= auxL06$2 ;auxL05= r0 ;slop$nw[i]= auxL05 ;
 level$d[i-1]=~( auxO11  |  auxL05 );r0=(r2= grad$0 );r0=( r0  | (r2= grad$1 ));r0=( r0  | ~(r2=(r1= grad$2 )));
 r0=( r0  | ( r2  ^  r1 ));resultCA$d[i-1]=~ r0 ;grad$0=( auxL13$0  ^ (r1=( auxL07$0  >>>  1 )));grad$1=(((r0=( r1  &  auxL13$0 )) ^  auxL13$1 ) ^ (r1=( auxL07$1  >>>  1 )));
 grad$2=(((( r0  &  auxL13$1 ) | ( r1  & ( r0  |  auxL13$1 ))) ^  auxL13$2 ) ^ ( auxL07$2  >>>  1 ));auxL13$0= dis$0 ;auxL13$1= dis$1 ;auxL13$2= dis$2 ;
 auxL06$0= grad$0 ;auxL06$1= grad$1 ;auxL06$2= grad$2 ;r0= delta$0 ;
 r7= tmun04$0 ;r6= tmun04$1 ;r3=(r2= tmun04$2 );r1= r2 ;
 r8= r2 ;r5= r2 ;r4= r2 ;r2=(r9= r7 );
 r2=( r2  | (r9=~ r6 ));r2=( r2  | (r9=((r10= r6 ) ^  r3 )));r2=( r2  | (r9=((r10=( r10  &  r3 )) ^  r1 )));r2=( r2  | (r9=((r10=( r10  &  r1 )) ^  r8 )));
 r2=( r2  | (r9=((r10=( r10  &  r8 )) ^  r5 )));r2=( r2  | (r9=(( r10  &  r5 ) ^  r4 )));r11= r9 ;r4= r2 ;
 r1= r4 ;r3=(r4= r11 );r2= delta$1 ;r4=( r2  |  r3 );
 delta$0=( r4  | (~ r4  & ( r0  &  r1 )));delta$1= r4 ;tmun04$0=( auxL06$0  <<  1 );tmun04$1=( auxL06$1  <<  1 );
 tmun04$2=( auxL06$2  <<  1 );r0= auxL06$2 ;auxL05= r0 ;slop$ne[i]=( auxL05  <<  1 );
 auxO11= auxL05 ;auxL06$0= grad$0 ;auxL06$1=((r0=~ grad$0 ) ^ ~ grad$1 );auxL06$2=(( r0  & ~ grad$1 ) ^ ~ grad$2 );
 r0= delta$0 ;r1= delta$1 ;r8= auxL06$0 ;r6= auxL06$1 ;
 r4=(r5= auxL06$2 );r2= r5 ;r7= r5 ;r9= r5 ;
 r3= r5 ;r11=(r5= r8 );r11=( r11  | (r5=~ r6 ));r11=( r11  | (r5=((r10= r6 ) ^  r4 )));
 r11=( r11  | (r5=((r10=( r10  &  r4 )) ^  r2 )));r11=( r11  | (r5=((r10=( r10  &  r2 )) ^  r7 )));r11=( r11  | (r5=((r10=( r10  &  r7 )) ^  r9 )));r11=( r11  | (r5=(( r10  &  r9 ) ^  r3 )));
 r12= r5 ;r2=(r4= r11 );r4= r12 ;r3= r4 ;
 r4=( r1  |  r3 );deltaR$0[i-1]=( r4  | (~ r4  & ( r0  &  r2 )));deltaR$1[i-1]= r4 ;r0= auxL06$2 ;
 auxL05= r0 ;slop$sw[i-1]= auxL05 ;level$ad[i-1]=~( auxO11  |  auxL05 );r0=(r1= grad$0 );
 r0=( r0  | (r1= grad$1 ));r0=( r0  | ~(r1=(r2= grad$2 )));r0=( r0  | ( r1  ^  r2 ));resultCA$ad[i-1]=~ r0 ;
  }
  p.mirror(deltaR);
p.prepareBit(slop);p.prepareBit(deltaR);p.prepareBit(level);p.prepareBit(resultCA)
 ;
  }
public static int slopGradGap_3_1_3GateCount=58;
 public static void slopGradGap_3_1_3(PrShift p,int [][] pdiiiis,int [][] resultCA,int [][] auxL05){
 int[] resultCA$e=resultCA[0],resultCA$se=resultCA[1],resultCA$sw=resultCA[2],resultCA$w=resultCA[3],resultCA$nw=resultCA[4],resultCA$ne=resultCA[5],auxL05$h1$0=auxL05[0],auxL05$h1$1=auxL05[1],auxL05$h1$2=auxL05[2],auxL05$h2$0=auxL05[3],auxL05$h2$1=auxL05[4],auxL05$h2$2=auxL05[5],auxL05$d1$0=auxL05[6],auxL05$d1$1=auxL05[7],auxL05$d1$2=auxL05[8],auxL05$d2$0=auxL05[9],auxL05$d2$1=auxL05[10],auxL05$d2$2=auxL05[11],auxL05$ad1$0=auxL05[12],auxL05$ad1$1=auxL05[13],auxL05$ad1$2=auxL05[14],auxL05$ad2$0=auxL05[15],auxL05$ad2$1=auxL05[16],auxL05$ad2$2=auxL05[17],pdiiiis$0=pdiiiis[0],pdiiiis$1=pdiiiis[1],pdiiiis$2=pdiiiis[2];

// initialisation 
 int auxL06$0=0,auxL06$1=0,auxL06$2=0,auxL07$0=0,auxL07$1=0,auxL07$2=0,auxL08$0=0,auxL08$1=0,auxL08$2=0,diiiis$0=0,diiiis$1=0,diiiis$2=0,r0=0,r1=0,tmun00$0=0,tmun00$1=0,tmun00$2=0;
for (int i = 1; i < pdiiiis$0.length -1; i++) {
 diiiis$0= pdiiiis$0[i] ;diiiis$1= pdiiiis$1[i] ;diiiis$2= pdiiiis$2[i] ;auxL07$0= diiiis$0 ;
 auxL07$1=((r0=~ diiiis$0 ) ^ ~ diiiis$1 );auxL07$2=(( r0  & ~ diiiis$1 ) ^ ~ diiiis$2 );auxL06$0= tmun00$0 ;auxL06$1= tmun00$1 ;
 auxL06$2= tmun00$2 ;tmun00$0=((r0=( auxL07$0  <<  1 )) ^  diiiis$0 );tmun00$1=(((r1=( diiiis$0  &  r0 )) ^ (r0=( auxL07$1  <<  1 ))) ^  diiiis$1 );tmun00$2=(((( r1  &  r0 ) | ( diiiis$1  & ( r1  |  r0 ))) ^ ( auxL07$2  <<  1 )) ^  diiiis$2 );
 auxL05$h1$0[i-1]= auxL06$0 ;auxL05$h1$1[i-1]=((r0=~ auxL06$0 ) ^ ~ auxL06$1 );auxL05$h1$2[i-1]=(( r0  & ~ auxL06$1 ) ^ ~ auxL06$2 );r0= auxL05$h1$2[i-1] ;
 resultCA$e[i-1]= r0 ;auxL05$h2$0[i-1]= auxL06$0 ;auxL05$h2$1[i-1]= auxL06$1 ;auxL05$h2$2[i-1]= auxL06$2 ;
 r0= auxL05$h2$2[i-1] ;resultCA$w[i-1]=( r0  >>>  1 );auxL06$0=( auxL08$0  ^  auxL07$0 );auxL06$1=(((r0=( auxL07$0  &  auxL08$0 )) ^  auxL08$1 ) ^  auxL07$1 );
 auxL06$2=(((( r0  &  auxL08$1 ) | ( auxL07$1  & ( r0  |  auxL08$1 ))) ^  auxL08$2 ) ^  auxL07$2 );auxL05$d1$0[i-1]= auxL06$0 ;auxL05$d1$1[i-1]=((r0=~ auxL06$0 ) ^ ~ auxL06$1 );auxL05$d1$2[i-1]=(( r0  & ~ auxL06$1 ) ^ ~ auxL06$2 );
 r0= auxL05$d1$2[i-1] ;resultCA$se[i-1]= r0 ;auxL05$d2$0[i-1]= auxL06$0 ;auxL05$d2$1[i-1]= auxL06$1 ;
 auxL05$d2$2[i-1]= auxL06$2 ;r0= auxL05$d2$2[i-1] ;resultCA$nw[i]= r0 ;auxL06$0=( auxL08$0  ^ (r1=( auxL07$0  >>>  1 )));
 auxL06$1=(((r0=( r1  &  auxL08$0 )) ^  auxL08$1 ) ^ (r1=( auxL07$1  >>>  1 )));auxL06$2=(((( r0  &  auxL08$1 ) | ( r1  & ( r0  |  auxL08$1 ))) ^  auxL08$2 ) ^ ( auxL07$2  >>>  1 ));auxL08$0= diiiis$0 ;auxL08$1= diiiis$1 ;
 auxL08$2= diiiis$2 ;auxL05$ad1$0[i-1]= auxL06$0 ;auxL05$ad1$1[i-1]=((r0=~ auxL06$0 ) ^ ~ auxL06$1 );auxL05$ad1$2[i-1]=(( r0  & ~ auxL06$1 ) ^ ~ auxL06$2 );
 r0= auxL05$ad1$2[i-1] ;resultCA$sw[i-1]= r0 ;auxL05$ad2$0[i-1]= auxL06$0 ;auxL05$ad2$1[i-1]= auxL06$1 ;
 auxL05$ad2$2[i-1]= auxL06$2 ;r0= auxL05$ad2$2[i-1] ;resultCA$ne[i]=( r0  <<  1 );
  }
  ;
p.prepareBit(resultCA);p.prepareBit(auxL05)
 ;
  }
public static int slopGradGap_4_1_4GateCount=92;
 public static void slopGradGap_4_1_4(PrShift p,int [][] pdiiiis,int [][] resultCA,int [][] auxL98){
 int[] resultCA$e=resultCA[0],resultCA$se=resultCA[1],resultCA$sw=resultCA[2],resultCA$w=resultCA[3],resultCA$nw=resultCA[4],resultCA$ne=resultCA[5],auxL98$h1$0=auxL98[0],auxL98$h1$1=auxL98[1],auxL98$h1$2=auxL98[2],auxL98$h1$3=auxL98[3],auxL98$h2$0=auxL98[4],auxL98$h2$1=auxL98[5],auxL98$h2$2=auxL98[6],auxL98$h2$3=auxL98[7],auxL98$d1$0=auxL98[8],auxL98$d1$1=auxL98[9],auxL98$d1$2=auxL98[10],auxL98$d1$3=auxL98[11],auxL98$d2$0=auxL98[12],auxL98$d2$1=auxL98[13],auxL98$d2$2=auxL98[14],auxL98$d2$3=auxL98[15],auxL98$ad1$0=auxL98[16],auxL98$ad1$1=auxL98[17],auxL98$ad1$2=auxL98[18],auxL98$ad1$3=auxL98[19],auxL98$ad2$0=auxL98[20],auxL98$ad2$1=auxL98[21],auxL98$ad2$2=auxL98[22],auxL98$ad2$3=auxL98[23],pdiiiis$0=pdiiiis[0],pdiiiis$1=pdiiiis[1],pdiiiis$2=pdiiiis[2],pdiiiis$3=pdiiiis[3];

// initialisation 
 int auxL100$0=0,auxL100$1=0,auxL100$2=0,auxL100$3=0,auxL146$0=0,auxL146$1=0,auxL146$2=0,auxL146$3=0,auxL99$0=0,auxL99$1=0,auxL99$2=0,auxL99$3=0,diiiis$0=0,diiiis$1=0,diiiis$2=0,diiiis$3=0,r0=0,r1=0,tmun28$0=0,tmun28$1=0,tmun28$2=0,tmun28$3=0;
for (int i = 1; i < pdiiiis$0.length -1; i++) {
 diiiis$0= pdiiiis$0[i] ;diiiis$1= pdiiiis$1[i] ;diiiis$2= pdiiiis$2[i] ;diiiis$3= pdiiiis$3[i] ;
 auxL100$0= diiiis$0 ;auxL100$1=((r0=~ diiiis$0 ) ^ ~ diiiis$1 );auxL100$2=((r0=( r0  & ~ diiiis$1 )) ^ ~ diiiis$2 );auxL100$3=(( r0  & ~ diiiis$2 ) ^ ~ diiiis$3 );
 auxL99$0= tmun28$0 ;auxL99$1= tmun28$1 ;auxL99$2= tmun28$2 ;auxL99$3= tmun28$3 ;
 tmun28$0=((r1=( auxL100$0  <<  1 )) ^  diiiis$0 );tmun28$1=(((r0=( diiiis$0  &  r1 )) ^ (r1=( auxL100$1  <<  1 ))) ^  diiiis$1 );tmun28$2=(((r0=(( r0  &  r1 ) | ( diiiis$1  & ( r0  |  r1 )))) ^ (r1=( auxL100$2  <<  1 ))) ^  diiiis$2 );tmun28$3=(((( r0  &  r1 ) | ( diiiis$2  & ( r0  |  r1 ))) ^ ( auxL100$3  <<  1 )) ^  diiiis$3 );
 auxL98$h1$0[i-1]= auxL99$0 ;auxL98$h1$1[i-1]=((r0=~ auxL99$0 ) ^ ~ auxL99$1 );auxL98$h1$2[i-1]=((r0=( r0  & ~ auxL99$1 )) ^ ~ auxL99$2 );auxL98$h1$3[i-1]=(( r0  & ~ auxL99$2 ) ^ ~ auxL99$3 );
 r0= auxL98$h1$3[i-1] ;resultCA$e[i-1]= r0 ;auxL98$h2$0[i-1]= auxL99$0 ;auxL98$h2$1[i-1]= auxL99$1 ;
 auxL98$h2$2[i-1]= auxL99$2 ;auxL98$h2$3[i-1]= auxL99$3 ;r0= auxL98$h2$3[i-1] ;resultCA$w[i-1]=( r0  >>>  1 );
 auxL99$0=( auxL146$0  ^  auxL100$0 );auxL99$1=(((r0=( auxL100$0  &  auxL146$0 )) ^  auxL146$1 ) ^  auxL100$1 );auxL99$2=(((r0=(( r0  &  auxL146$1 ) | ( auxL100$1  & ( r0  |  auxL146$1 )))) ^  auxL146$2 ) ^  auxL100$2 );auxL99$3=(((( r0  &  auxL146$2 ) | ( auxL100$2  & ( r0  |  auxL146$2 ))) ^  auxL146$3 ) ^  auxL100$3 );
 auxL98$d1$0[i-1]= auxL99$0 ;auxL98$d1$1[i-1]=((r0=~ auxL99$0 ) ^ ~ auxL99$1 );auxL98$d1$2[i-1]=((r0=( r0  & ~ auxL99$1 )) ^ ~ auxL99$2 );auxL98$d1$3[i-1]=(( r0  & ~ auxL99$2 ) ^ ~ auxL99$3 );
 r0= auxL98$d1$3[i-1] ;resultCA$se[i-1]= r0 ;auxL98$d2$0[i-1]= auxL99$0 ;auxL98$d2$1[i-1]= auxL99$1 ;
 auxL98$d2$2[i-1]= auxL99$2 ;auxL98$d2$3[i-1]= auxL99$3 ;r0= auxL98$d2$3[i-1] ;resultCA$nw[i]= r0 ;
 auxL99$0=( auxL146$0  ^ (r1=( auxL100$0  >>>  1 )));auxL99$1=(((r0=( r1  &  auxL146$0 )) ^  auxL146$1 ) ^ (r1=( auxL100$1  >>>  1 )));auxL99$2=(((r0=(( r0  &  auxL146$1 ) | ( r1  & ( r0  |  auxL146$1 )))) ^  auxL146$2 ) ^ (r1=( auxL100$2  >>>  1 )));auxL99$3=(((( r0  &  auxL146$2 ) | ( r1  & ( r0  |  auxL146$2 ))) ^  auxL146$3 ) ^ ( auxL100$3  >>>  1 ));
 auxL146$0= diiiis$0 ;auxL146$1= diiiis$1 ;auxL146$2= diiiis$2 ;auxL146$3= diiiis$3 ;
 auxL98$ad1$0[i-1]= auxL99$0 ;auxL98$ad1$1[i-1]=((r0=~ auxL99$0 ) ^ ~ auxL99$1 );auxL98$ad1$2[i-1]=((r0=( r0  & ~ auxL99$1 )) ^ ~ auxL99$2 );auxL98$ad1$3[i-1]=(( r0  & ~ auxL99$2 ) ^ ~ auxL99$3 );
 r0= auxL98$ad1$3[i-1] ;resultCA$sw[i-1]= r0 ;auxL98$ad2$0[i-1]= auxL99$0 ;auxL98$ad2$1[i-1]= auxL99$1 ;
 auxL98$ad2$2[i-1]= auxL99$2 ;auxL98$ad2$3[i-1]= auxL99$3 ;r0= auxL98$ad2$3[i-1] ;resultCA$ne[i]=( r0  <<  1 );
  }
  ;
p.prepareBit(resultCA);p.prepareBit(auxL98)
 ;
  }}