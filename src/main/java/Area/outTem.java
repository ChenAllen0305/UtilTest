package Area;

import java.util.ArrayList;
import java.util.List;

public class outTem {
    public static void main(String[] args) {
//        for(int i=104; i <= 113; i++){
////            System.out.println("(:Area{code: ,title:'', name:'', type:''}),");
//            System.out.println("(103)-[:HAS_CHILD]->(" + i + "),");
//        }
        List<Integer> test = new ArrayList<>();
        for (int i=1; i<36; i++) {
            System.out.println("(a" + i + ":Area{title:'', name:'', type:'', code:''})");
        }
//        System.out.println(test);

//        if (test.equals(null)) {
//            System.out.println(2);
//        }
    }
}
