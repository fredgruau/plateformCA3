package progOfCA ;

import compiledMacro.*;
import compiler.Locus;
import scala.collection.immutable.List;
import simulator.CAloops;
import simulator.CAloops2;
import simulator.PrShift;
import java.util.ArrayList;
import java.util.HashMap;
import static simulator.Util.*;

public final class GrowCA implements CAloops2 {
 public HashMap<String, String> partial() {return null;}
 public static void _fun2(PrShift p,int [][] auxC01,int [][] growNBEmptyrhomb){
 int[] growNBEmptyrhomb$h=growNBEmptyrhomb[0],growNBEmptyrhomb$d=growNBEmptyrhomb[1],growNBEmptyrhomb$ad=growNBEmptyrhomb[2],auxC01$h=auxC01[0],auxC01$d=auxC01[1],auxC01$ad=auxC01[2];


for (int i = 1; i < auxC01$h.length -1; i++) {
 growNBEmptyrhomb$h[i]=~ auxC01$h[i] ;growNBEmptyrhomb$d[i]=~ auxC01$d[i] ;growNBEmptyrhomb$ad[i]=~ auxC01$ad[i] ;
 }
 ;
p.prepareBit(growNBEmptyrhomb)

 ;}
 public static void _fun3(PrShift p,int [][] growNBTwoadjblob,int [][] growNBEmptyrhomb,int [][] growNBMeete){
 int[] growNBMeete$h=growNBMeete[0],growNBMeete$d=growNBMeete[1],growNBMeete$ad=growNBMeete[2],growNBTwoadjblob$h=growNBTwoadjblob[0],growNBTwoadjblob$d=growNBTwoadjblob[1],growNBTwoadjblob$ad=growNBTwoadjblob[2],growNBEmptyrhomb$h=growNBEmptyrhomb[0],growNBEmptyrhomb$d=growNBEmptyrhomb[1],growNBEmptyrhomb$ad=growNBEmptyrhomb[2];


for (int i = 1; i < growNBTwoadjblob$h.length -1; i++) {
 growNBMeete$h[i]=( growNBTwoadjblob$h[i]  &  growNBEmptyrhomb$h[i] );growNBMeete$d[i]=( growNBTwoadjblob$d[i]  &  growNBEmptyrhomb$d[i] );growNBMeete$ad[i]=( growNBTwoadjblob$ad[i]  &  growNBEmptyrhomb$ad[i] );
 }
 ;
p.prepareBit(growNBMeete)

 ;}
 public static void _fun0(PrShift p,int [][] growNBfBrde,int [] growN,int [][] growNBfBrdvein){
 int[] growNBfBrdvein$e=growNBfBrdvein[0],growNBfBrdvein$se=growNBfBrdvein[1],growNBfBrdvein$sw=growNBfBrdvein[2],growNBfBrdvein$w=growNBfBrdvein[3],growNBfBrdvein$nw=growNBfBrdvein[4],growNBfBrdvein$ne=growNBfBrdvein[5],growNBfBrde$h=growNBfBrde[0],growNBfBrde$d=growNBfBrde[1],growNBfBrde$ad=growNBfBrde[2];

// initialisation 
 int auxL01=0,auxL02=0,auxL03=0,auxL04=0,tmun00=0,tmun01=0;
for (int i = 1; i < growNBfBrde$h.length -1; i++) {
 auxL01= growNBfBrde$h[i] ;auxL03= growN[i] ;growNBfBrdvein$e[i]=( auxL01  &  auxL03 );auxL02= growNBfBrde$d[i] ;
 growNBfBrdvein$se[i]=( auxL02  &  auxL03 );auxL04= growNBfBrde$ad[i] ;growNBfBrdvein$sw[i]=( auxL04  &  auxL03 );growNBfBrdvein$w[i]=(( auxL01  >>>  1 ) &  auxL03 );
 growNBfBrdvein$nw[i]=( tmun00  &  auxL03 );tmun00= auxL02 ;growNBfBrdvein$ne[i]=( tmun01  &  auxL03 );tmun01=( auxL04  <<  1 );
 }
 ;
p.prepareBit(growNBfBrdvein)

 ;}
 public static void _fun1(PrShift p,int [] auxL00,int [][] growNBfBrde,int [][] growNBfBrdveout){
 int[] growNBfBrdveout$e=growNBfBrdveout[0],growNBfBrdveout$se=growNBfBrdveout[1],growNBfBrdveout$sw=growNBfBrdveout[2],growNBfBrdveout$w=growNBfBrdveout[3],growNBfBrdveout$nw=growNBfBrdveout[4],growNBfBrdveout$ne=growNBfBrdveout[5],growNBfBrde$h=growNBfBrde[0],growNBfBrde$d=growNBfBrde[1],growNBfBrde$ad=growNBfBrde[2];

// initialisation 
 int auxL05=0,auxL06=0,auxL07=0,auxL08=0,tmun02=0,tmun03=0;
for (int i = 1; i < auxL00.length -1; i++) {
 auxL05= growNBfBrde$h[i] ;auxL07= auxL00[i] ;growNBfBrdveout$e[i]=( auxL05  &  auxL07 );auxL06= growNBfBrde$d[i] ;
 growNBfBrdveout$se[i]=( auxL06  &  auxL07 );auxL08= growNBfBrde$ad[i] ;growNBfBrdveout$sw[i]=( auxL08  &  auxL07 );growNBfBrdveout$w[i]=(( auxL05  >>>  1 ) &  auxL07 );
 growNBfBrdveout$nw[i]=( tmun02  &  auxL07 );tmun02= auxL06 ;growNBfBrdveout$ne[i]=( tmun03  &  auxL07 );tmun03=( auxL08  <<  1 );
 }
 ;
p.prepareBit(growNBfBrdveout)

 ;}
 public static void _fun6(PrShift p,int [][] growNBNbcc,int [] growNBMeetv){
 int[] growNBNbcc$0=growNBNbcc[0],growNBNbcc$1=growNBNbcc[1];

// initialisation 
 int r0=0,r1=0,r2=0,r3=0,r4=0;
for (int i = 1; i < growNBNbcc$0.length -1; i++) {
 r1=~ growNBNbcc$0[i] ;r0= growNBNbcc$1[i] ;r3=((r4=(r2= r0 )) &  growNBNbcc$1[i] );r3=( r3  | ((~ r4  & ( r2  |  r1 )) &  growNBNbcc$0[i] ));
 growNBMeetv[i]= r3 ;
 }
 p.mirror(growNBMeetv);
p.prepareBit(growNBMeetv)

 ;}
 public static void _fun7(PrShift p,int [] growNBMeet,int [] growN,int [] growNBfBrdv,int [] llgrowN){
 


for (int i = 1; i < growNBMeet.length -1; i++) {
 llgrowN[i]=( growN[i]  | ( growNBfBrdv[i]  & ~ growNBMeet[i] ));
 }
 p.mirror(llgrowN);
p.prepareBit(llgrowN)

 ;}
 public static void _fun4(PrShift p,int [] growN,int [] auxC00,int [] auxL00){
 


for (int i = 1; i < growN.length -1; i++) {
 auxL00[i]=~ growN[i] ;auxC00[i]=~ auxL00[i] ;
 }
 p.mirror(auxC00);p.mirror(auxL00);
p.prepareBit(auxC00);p.prepareBit(auxL00)

 ;}
 public static void _fun5(PrShift p,int [] auxC03,int [] growNBMeetv,int [] growNBMeet){
 


for (int i = 1; i < auxC03.length -1; i++) {
 growNBMeet[i]=( growNBMeetv[i]  |  auxC03[i] );
 }
 p.mirror(growNBMeet);
p.prepareBit(growNBMeet)

 ;}
public int CAmemWidth() {return 35;}

@Override public ArrayList<String> theLoops(PrShift p,int[][] m) {ArrayList<String> bugs=new ArrayList<>();
int[]growNBMeet=m[15],auxC00=m[29],growNBfBrdv=m[22],auxL00=m[30],llgrowN=m[0],llbugV=m[1],growNBMeetv=m[16],growN=m[2],auxC03=m[29];
int[][]growNBTwoadjblob= new int[][]{m[29],m[31],m[32]},growNBfBrdveout= new int[][]{m[3],m[4],m[5],m[6],m[7],m[8]},growNBfBrde= new int[][]{m[26],m[27],m[28]},growNBMeete= new int[][]{m[19],m[20],m[21]},growNBNbcc= new int[][]{m[17],m[18]},growNBfBrdvein= new int[][]{m[9],m[10],m[11],m[12],m[13],m[14]},growNBEmptyrhomb= new int[][]{m[23],m[24],m[25]},auxC01= new int[][]{m[32],m[33],m[34]},auxC02= new int[][]{m[29],m[31]};



copy(llgrowN ,growN);
show(growN);
_fun4(p,growN,auxC00,auxL00);// 2 gate
redsxorb.ve_1_1(p,auxC00,growNBfBrde);// 3 gate
redsorb.ef_1_1(p,growNBfBrde,auxC02);// 4 gate
redsorb.fe_1_1(p,auxC02,auxC01);// 3 gate
_fun2(p,auxC01,growNBEmptyrhomb);// 3 gate
show(growNBEmptyrhomb);
redsorb.ev_1_1(p,growNBfBrde,growNBfBrdv);// 5 gate
redsandb.ve_1_1(p,growNBfBrdv,growNBTwoadjblob);// 3 gate
_fun3(p,growNBTwoadjblob,growNBEmptyrhomb,growNBMeete);// 3 gate
redsorb.ev_1_1(p,growNBMeete,auxC03);// 5 gate
topo.nbccV_1_2(p,growNBfBrde,growNBNbcc);// 21 gate
_fun6(p,growNBNbcc,growNBMeetv);// 7 gate
_fun5(p,auxC03,growNBMeetv,growNBMeet);// 1 gate
show(growNBMeet);
show(growNBMeete);
show(growNBMeetv);
show(growNBNbcc);
show(growNBfBrde);
show(growNBfBrdv);
_fun0(p,growNBfBrde,growN,growNBfBrdvein);// 6 gate
show(growNBfBrdvein);
_fun1(p,auxL00,growNBfBrde,growNBfBrdveout);// 6 gate
show(growNBfBrdveout);
_fun7(p,growNBMeet,growN,growNBfBrdv,llgrowN);// 3 gate


 return bugs;}


@Override public HashMap<String, List<String>> textOfFields() {HashMap<String, List<String>> map = new HashMap<>();
  return (map); }
@Override public HashMap<String, List<Integer>> fieldOffset() {HashMap<String, List<Integer>> map = new HashMap<>(); //for layer's initialization and update, as well as displayed fields.
map.put("growNBMeet", li(15));
map.put("growNBTwoadjblob", li(29,31,32));
map.put("growNBfBrde", li(26,27,28));
map.put("auxL00", li(30));
map.put("llbugV", li(1));
map.put("growNBMeetv", li(16));
map.put("growNBfBrdvein", li(9,10,11,12,13,14));
map.put("auxC03", li(29));
map.put("growNBEmptyrhomb", li(23,24,25));
map.put("auxC01", li(32,33,34));
map.put("auxC02", li(29,31));
map.put("auxC00", li(29));
map.put("growNBfBrdv", li(22));
map.put("growNBfBrdveout", li(3,4,5,6,7,8));
map.put("growNBMeete", li(19,20,21));
map.put("growNBNbcc", li(17,18));
map.put("llgrowN", li(0));
map.put("growN", li(2)); return (map);}
@Override public HashMap<String, Locus> fieldLocus() {HashMap<String, Locus> map = new HashMap<>();
 map.put("auxL00",compiler.Locus.locusV());
 map.put("growNBMeet",compiler.Locus.locusV());
 map.put("auxC01",compiler.Locus.locusE());
 map.put("growNBTwoadjblob",compiler.Locus.locusE());
 map.put("growNBMeete",compiler.Locus.locusE());
 map.put("growNBfBrdveout",compiler.Locus.locusVe());
 map.put("growNBEmptyrhomb",compiler.Locus.locusE());
 map.put("growNBfBrde",compiler.Locus.locusE());
 map.put("growNBNbcc",compiler.Locus.locusV());
 map.put("auxC03",compiler.Locus.locusV());
 map.put("llbugV",compiler.Locus.locusV());
 map.put("growNBMeetv",compiler.Locus.locusV());
 map.put("auxC02",compiler.Locus.locusF());
 map.put("auxC00",compiler.Locus.locusV());
 map.put("llgrowN",compiler.Locus.locusV());
 map.put("growN",compiler.Locus.locusV());
 map.put("growNBfBrdv",compiler.Locus.locusV());
 map.put("growNBfBrdvein",compiler.Locus.locusVe()); return (map);}
@Override public HashMap<String, Integer> fieldBitSize() { HashMap<String, Integer> map = new HashMap<>();
 map.put("growNBNbcc",2); return (map); }
@Override  public String displayableLayerHierarchy() { return "grow(growN(growNBf(growNBfBrdveout)(growNBfBrdvein)(growNBfBrdv)(growNBfBrde))(growNB(growNBNbcc)(growNBMeetv)(growNBMeete)(growNBMeet)(growNBEmptyrhomb))).";}
@Override public HashMap<String, String> init() {HashMap<String, String> map = new HashMap<>();
  map.put("llgrowN","global");
 map.put("llbugV","false");
 return (map);}
@Override public int gateCount(){return (75 );}

}
