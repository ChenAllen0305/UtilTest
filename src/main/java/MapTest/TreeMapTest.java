package MapTest;

import java.util.*;

public class TreeMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        Map<String, String> linkedMap = new LinkedHashMap<>();
        Map<Integer, String> treeMap = new TreeMap<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1.compareTo(o2);
                    }
                }
        );
        Hashtable hashtable = new Hashtable();
//        for (int i = 0; i < 10; i++) {
//            map.put("key" + i, "value" + i);
//            linkedMap.put("key" + i, "value" + i);
//        }
//
//        Set<Map.Entry<String, String>> entries = map.entrySet();
//        for (Map.Entry entry : entries) {
//            System.out.println(entry.getKey() + "->" + entry.getValue());
//        }

        treeMap.put(1, "1,2,3");
        treeMap.put(3, "9,10,11");
        treeMap.put(2, "4,5,6,7,8");
        treeMap.put(4, "12");

        linkedMap.put("1", "1,2,3");
        linkedMap.put("9", "9,10,11");
        linkedMap.put("4", "4,5,6,7,8");
        linkedMap.put("12", "12");

//        System.out.println("-----------------");

        Set<Map.Entry<String, String>> entries2 = linkedMap.entrySet();
        for (Map.Entry entry : entries2) {
//            System.out.println(entry.getKey() + "->" + entry.getValue());
        }

        Set<Integer> keySet = treeMap.keySet();
        Iterator<Integer> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println(key + ":" + treeMap.get(key));
        }
    }
}
