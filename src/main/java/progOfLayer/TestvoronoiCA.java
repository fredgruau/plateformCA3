package progOfLayer ;

import compiledMacro.*;
import compiler.Locus;
import scala.collection.immutable.List;
import simulator.CAloops;
import simulator.CAloops2;
import simulator.PrShift;
import java.util.ArrayList;
import java.util.HashMap;
import static simulator.Util.*;

public final class TestvoronoiCA implements CAloops2 {
 public static void _fun0(PrShift p,int [][] testvoronoiN,int [][] testvoronoiNTestconst,int [][] testvoronoiNOtheruse){
 int[] testvoronoiNOtheruse$e=testvoronoiNOtheruse[0],testvoronoiNOtheruse$se=testvoronoiNOtheruse[1],testvoronoiNOtheruse$sw=testvoronoiNOtheruse[2],testvoronoiNOtheruse$w=testvoronoiNOtheruse[3],testvoronoiNOtheruse$nw=testvoronoiNOtheruse[4],testvoronoiNOtheruse$ne=testvoronoiNOtheruse[5],testvoronoiN$e=testvoronoiN[0],testvoronoiN$se=testvoronoiN[1],testvoronoiN$sw=testvoronoiN[2],testvoronoiN$w=testvoronoiN[3],testvoronoiN$nw=testvoronoiN[4],testvoronoiN$ne=testvoronoiN[5],testvoronoiNTestconst$e=testvoronoiNTestconst[0],testvoronoiNTestconst$se=testvoronoiNTestconst[1],testvoronoiNTestconst$sw=testvoronoiNTestconst[2],testvoronoiNTestconst$w=testvoronoiNTestconst[3],testvoronoiNTestconst$nw=testvoronoiNTestconst[4],testvoronoiNTestconst$ne=testvoronoiNTestconst[5];


for (int i = 1; i < testvoronoiN$e.length -1; i++) {
 testvoronoiNOtheruse$e[i]=( testvoronoiNTestconst$e[i]  ^  testvoronoiN$e[i] );testvoronoiNOtheruse$se[i]=( testvoronoiNTestconst$se[i]  ^  testvoronoiN$se[i] );testvoronoiNOtheruse$sw[i]=( testvoronoiNTestconst$sw[i]  ^  testvoronoiN$sw[i] );testvoronoiNOtheruse$w[i]=( testvoronoiNTestconst$w[i]  ^  testvoronoiN$w[i] );
 testvoronoiNOtheruse$nw[i]=( testvoronoiNTestconst$nw[i]  ^  testvoronoiN$nw[i] );testvoronoiNOtheruse$ne[i]=( testvoronoiNTestconst$ne[i]  ^  testvoronoiN$ne[i] );
 }
 ;
p.prepareBit(testvoronoiNOtheruse)

 ;}
public int CAmemWidth() {return 26;}

@Override public ArrayList<String> theLoops(PrShift p,int[][] m) {ArrayList<String> bugs=new ArrayList<>();
int[]auxL00=m[0],llbugV=m[6];
int[][]testvoronoiNOtheruse= new int[][]{m[13],m[14],m[15],m[16],m[17],m[18]},lltestvoronoiN= new int[][]{m[0],m[1],m[2],m[3],m[4],m[5]},testvoronoiNTestconst= new int[][]{m[19],m[20],m[21],m[22],m[23],m[24]},testvoronoiN= new int[][]{m[7],m[8],m[9],m[10],m[11],m[12]};



copy(lltestvoronoiN ,testvoronoiN);
show(testvoronoiN);
set1(auxL00);
broadcaast(6,auxL00 ,testvoronoiNTestconst);
_fun0(p,testvoronoiN,testvoronoiNTestconst,testvoronoiNOtheruse);// 6 gate
show(testvoronoiNOtheruse);
show(testvoronoiNTestconst);
memo(testvoronoiN,lltestvoronoiN);


 return bugs;}


@Override public HashMap<String, List<String>> textOfFields() {HashMap<String, List<String>> map = new HashMap<>();
  return (map); }
@Override public HashMap<String, List<Integer>> fieldOffset() {HashMap<String, List<Integer>> map = new HashMap<>(); //for layer's initialization and update, as well as displayed fields.
map.put("testvoronoiNOtheruse", li(13,14,15,16,17,18));
map.put("lltestvoronoiN", li(0,1,2,3,4,5));
map.put("auxL00", li(0));
map.put("llbugV", li(6));
map.put("testvoronoiNTestconst", li(19,20,21,22,23,24));
map.put("testvoronoiN", li(7,8,9,10,11,12)); return (map);}
@Override public HashMap<String, Locus> fieldLocus() {HashMap<String, Locus> map = new HashMap<>();
 map.put("testvoronoiN",compiler.Locus.locusVe());
 map.put("testvoronoiNOtheruse",compiler.Locus.locusVe());
 map.put("llbugV",compiler.Locus.locusV());
 map.put("lltestvoronoiN",compiler.Locus.locusVe());
 map.put("testvoronoiNTestconst",compiler.Locus.locusVe()); return (map);}
@Override public HashMap<String, Integer> fieldBitSize() { HashMap<String, Integer> map = new HashMap<>();
; return (map); }
@Override  public String displayableLayerHierarchy() { return "testvoronoi(testvoronoiN(testvoronoiNTestconst)(testvoronoiNOtheruse)).";}
@Override public HashMap<String, String> init() {HashMap<String, String> map = new HashMap<>();
  map.put("llbugV","false");
 map.put("lltestvoronoiN","global");
 return (map);}
@Override public int gateCount(){return (6 );}

}
