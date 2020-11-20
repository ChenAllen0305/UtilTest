package CalculatePackTest;

import java.util.HashMap;
import java.util.Map;

public class MapDoubleToNumber {
    public static void main(String[] args) {
        Map<Long, Double> map1 = new HashMap<>();
        map1.put(1L, 0.2);
        map1.put(2L, 0.5);
        Map<String, Number> map2 = new HashMap<>();
        for (Map.Entry entry : map1.entrySet()) {
            map2.put(String.valueOf(entry.getKey()), (Number) entry.getValue());
        }
        for (Map.Entry entry : map2.entrySet()) {
//            map2.put((Long) entry.getKey(), (Number) entry.getValue());
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
