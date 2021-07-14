package MapTest;

import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import java.util.*;

/**
 * @title: KeySetTest
 * @Author Chen Lun
 * @Date: 2021/1/29
 */
public class KeySetTest {
    public static void main(String[] args) {
//        HashMap<String, Integer> map = new HashMap();
//        map.put("1", 1);
//        map.put("2", 2);
//        map.put("3", 3);
//        map.put("4", 4);
//        map.put("5", 5);
//        map.put("6", 6);
//        map.put("7", 7);
//        map.put("8", 8);
//        map.put("9", 9);
//        map.put("10", 10);
//        System.out.println(map);
//
//        for (int i = 1; i <= 10;i ++) {
//            int j = map.get(String.valueOf(i));
//            j += i;
//            map.put(String.valueOf(i), j);
//        }
//        System.out.println(map);

        HashMap<String, List<Integer>> map1 = new HashMap();
//        map1.put("1", new ArrayList<>(Collections.singletonList(1)));
//        map1.put("2", new ArrayList<>(Collections.singletonList(2)));
//        map1.put("3", new ArrayList<>(Collections.singletonList(3)));
//        map1.put("4", new ArrayList<>(Collections.singletonList(4)));
//        map1.put("5", new ArrayList<>(Collections.singletonList(5)));
//        map1.put("6", new ArrayList<>(Collections.singletonList(6)));
//        map1.put("7", new ArrayList<>(Collections.singletonList(7)));
//        map1.put("8", new ArrayList<>(Collections.singletonList(8)));
//        map1.put("9", new ArrayList<>(Collections.singletonList(9)));
//        map1.put("10", new ArrayList<>(Collections.singletonList(10)));
        map1.put("1", new ArrayList<>());
        map1.put("2", new ArrayList<>());
        map1.put("3", new ArrayList<>());
        map1.put("4", new ArrayList<>());
        map1.put("5", new ArrayList<>());
        map1.put("6", new ArrayList<>());
        map1.put("7", new ArrayList<>());
        map1.put("8", new ArrayList<>());
        map1.put("9", new ArrayList<>());
        map1.put("10", new ArrayList<>());
        System.out.println(map1);
        for (int i = 1; i <= 10;i ++) {
            List<Integer> j = map1.get(String.valueOf(i));
            j.add(i);
        }
        System.out.println(map1);
    }
}
