package MapTest;

import java.util.*;

public class TreeMapTest2 {
    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<String, String>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        return obj1.compareTo(obj2);
                    }
                });

        Map<Integer, String> map2 = new TreeMap<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1.compareTo(o2);
                    }
                }
        );
//        map.put("b", "ccccc");
//        map.put("d", "aaaaa");
//        map.put("c", "bbbbb");
//        map.put("a", "ddddd");
        map.put("1", "1,2,3");
        map.put("9", "9,10,11");
        map.put("4", "4,5,6,7,8");
        map.put("12", "12");

        map2.put(1, "1,2,3");
        map2.put(9, "9,10,11");
        map2.put(4, "4,5,6,7,8");
        map2.put(12, "12");

        Set<String> keySet = map.keySet();
        Iterator<String> iter = keySet.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
//            System.out.println(key + ":" + map.get(key));
        }

        Set<Integer> keySet2 = map2.keySet();
        Iterator<Integer> iter2 = keySet2.iterator();
        while (iter2.hasNext()) {
            Integer key = iter2.next();
            System.out.println(key + ":" + map2.get(key));
        }
    }
}
