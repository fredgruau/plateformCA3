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

public final class TestrandCA implements CAloops2 {
 @Override public HashMap<String, List<String>> textOfFields() {HashMap<String, List<String>> map = new HashMap<>();
  return (map); }
public int CAmemWidth() {return 5;}

@Override public ArrayList<String> theLoops(PrShift p,int[][] m) {ArrayList<String> bugs=new ArrayList<>();
int[]auxC00=m[3],lltestrandN=m[0],llbugV=m[1],testrandN=m[2],testrandNNext=m[4];



copy(lltestrandN ,testrandN);
show(testrandN);
util.torusify_1_1(p,testrandN,auxC00);
util.rand_1_1(p,auxC00,testrandNNext);// 5 gate
memo(testrandNNext,lltestrandN);


 return bugs;}



@Override public HashMap<String, List<Integer>> fieldOffset() {HashMap<String, List<Integer>> map = new HashMap<>(); //for layer's initialization and update, as well as displayed fields.
map.put("auxC00", li(3));
map.put("lltestrandN", li(0));
map.put("llbugV", li(1));
map.put("testrandN", li(2));
map.put("testrandNNext", li(4)); return (map);}
@Override public HashMap<String, Locus> fieldLocus() {HashMap<String, Locus> map = new HashMap<>();
 map.put("testrandNNext",compiler.Locus.locusV());
 map.put("auxC00",compiler.Locus.locusV());
 map.put("testrandN",compiler.Locus.locusV());
 map.put("llbugV",compiler.Locus.locusV());
 map.put("lltestrandN",compiler.Locus.locusV()); return (map);}
@Override public HashMap<String, Integer> fieldBitSize() { HashMap<String, Integer> map = new HashMap<>();
; return (map); }
@Override  public String displayableLayerHierarchy() { return "testrand(testrandN).";}
@Override public HashMap<String, String> init() {HashMap<String, String> map = new HashMap<>();
  map.put("llbugV","false");
 map.put("lltestrandN","random");
 return (map);}
@Override public int gateCount(){return (5 );}

}
