package MapTest;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumMapTest {
    public static void main(String[] args) {
        Map<Long, Double> map = new HashMap<>();
        map.put(1L, 0D);
        map.put(2L, 1D);
//        for (Map.Entry<Long, Double> entry : map.entrySet()) {
//            map.put(entry.getKey(), entry.getValue() + 1);
//        }
//        System.out.println(map.values());
//        System.out.println(map.containsValue(0D));

//        Map<Long, Double> map2 = new HashMap<>();
//        map2.putAll(map);
//
//        System.out.println(map.get(3L));
        List<Long> pointNumbers = new ArrayList<>(map.keySet());
        for (Long pn : pointNumbers) {
            System.out.println(pn);
        }
    }
}
