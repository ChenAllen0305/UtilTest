package Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class mapKeySetTest {
    public static void main(String[] args){
        Map map = new HashMap();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "d");

//        List key1 = (List) map.keySet();
        Set key1 = map.keySet();

        System.out.println(key1);

        System.out.println("----------");
        key1.remove(1);
        System.out.println(key1);
    }
}
