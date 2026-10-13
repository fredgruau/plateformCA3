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
import scala.collection.immutable.List;

public final class Grow2CA implements CAloops2 {
    public static HashMap<String, Integer> buttons;
    { buttons= new HashMap<>();    buttons.put("test", -1);
    }
    //mettre tout les bouttons.
    public static HashMap<String, Integer> getbuttons() {  return (buttons); }



    public static void _fun0(PrShift p,int [][] growNNf2,int [][] auxC00){
        int[] auxC00$es=auxC00[0],auxC00$s=auxC00[1],auxC00$ws=auxC00[2],auxC00$wn=auxC00[3],auxC00$n=auxC00[4],auxC00$en=auxC00[5],growNNf2$do=growNNf2[0],growNNf2$up=growNNf2[1];

// initialisation
        int auxL00=0,auxL01=0;
        for (int i = 1; i < growNNf2$do.length -1; i++) {
            auxC00$n[i]= auxL00 ;auxL00= growNNf2$do[i] ;auxC00$es[i]= auxL00 ;auxC00$wn[i]= auxL01 ;
            auxL01= growNNf2$up[i] ;auxC00$s[i]= auxL01 ;auxC00$ws[i]=( auxL00  >>>  1 );auxC00$en[i+1]=( auxL01  <<  1 );
        }
        ;
        p.prepareBit(auxC00)

        ;}
    public static void _fun1(PrShift p,int [] growNTest,int [] growNTest2){

        for (int i = 1; i < growNTest.length -1; i++) {
            growNTest2[i]=( buttons.get("test")  ^  growNTest[i] );
        }
        p.mirror(growNTest2);
        p.prepareBit(growNTest2)

        ;}
    public int CAmemWidth() {return 18;}


    @Override public List<ArrayList<String>> theLoops(PrShift p, int[][] m) {


        ArrayList<String> bugs=new ArrayList<>();
        ArrayList<String> livesIf=new ArrayList<>();
        int[]lliveV=m[0],growNTest2=m[8],growNTest=m[17],llbugV=m[4];
        int[][]auxC00= new int[][]{m[11],m[12],m[13],m[14],m[15],m[16]},growNNf2= new int[][]{m[9],m[10]},llgrowN= new int[][]{m[1],m[2],m[3]},growN= new int[][]{m[5],m[6],m[7]},growNNext= new int[][]{m[11],m[12],m[13]};



        copy(llgrowN ,growN);
        show(growN);
        redsorb.ef_1_1(p,growN,growNNf2);// 4 gate
        show(growNNf2);
        _fun0(p,growNNf2,auxC00);
        reddorb.vf_1_1(p,auxC00,growNTest);// 5 gate
        _fun1(p,growNTest,growNTest2);// 1 gate
        show(growNTest2);
        redsorb.fe_1_1(p,growNNf2,growNNext);// 3 gate
        memo(growNNext,llgrowN);



        List<ArrayList<String>> conteneur =
                scala.collection.immutable.List$.MODULE$.empty();
        conteneur = conteneur.$colon$colon(livesIf);
        conteneur = conteneur.$colon$colon(bugs);
        return(conteneur);

    }


    @Override public HashMap<String, List<String>> textOfFields() {HashMap<String, List<String>> map = new HashMap<>();
        return (map); }

    @Override  public HashMap<String, String> partial() {HashMap<String, String> map = new HashMap<>();

        return (map);
    }

    @Override public HashMap<String, List<Integer>> fieldOffset() {HashMap<String, List<Integer>> map = new HashMap<>(); //for layer's initialization and update, as well as displayed fields.
        map.put("lliveV", li(0));
        map.put("auxC00", li(11,12,13,14,15,16));
        map.put("growNTest2", li(8));
        map.put("growNNf2", li(9,10));
        map.put("llgrowN", li(1,2,3));
        map.put("growNTest", li(17));
        map.put("llbugV", li(4));
        map.put("growN", li(5,6,7));
        map.put("growNNext", li(11,12,13)); return (map);}
    @Override public HashMap<String, Locus> fieldLocus() {HashMap<String, Locus> map = new HashMap<>();
        map.put("growNNf2",compiler.Locus.locusF());
        map.put("growNTest",compiler.Locus.locusV());
        map.put("auxC00",compiler.Locus.locusVf());
        map.put("lliveV",compiler.Locus.locusV());
        map.put("growNNext",compiler.Locus.locusE());
        map.put("llbugV",compiler.Locus.locusV());
        map.put("growNTest2",compiler.Locus.locusV());
        map.put("llgrowN",compiler.Locus.locusE());
        map.put("growN",compiler.Locus.locusE()); return (map);}
    @Override public HashMap<String, Integer> fieldBitSize() { HashMap<String, Integer> map = new HashMap<>();
        ; return (map); }
    @Override  public String displayableLayerHierarchy() { return "grow(growN(growNTest2)(growNNf2)).";}
    @Override public HashMap<String, String> init() {HashMap<String, String> map = new HashMap<>();
        map.put("lliveV","false");
        map.put("llgrowN","global");
        map.put("llbugV","false");
        return (map);}
    @Override public int gateCount(){return (13 );}

}
