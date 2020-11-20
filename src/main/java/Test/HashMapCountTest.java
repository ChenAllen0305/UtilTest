package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class HashMapCountTest {
    public static void main(String[] args) {
        HashMap<HashMap<String, Float>, String> HM=new HashMap<HashMap<String,Float>, String>();

        HashMap<String, Float> typeValuesHM;

        typeValuesHM=new HashMap<String, Float>();
        typeValuesHM.put("X", 48.0f);
        typeValuesHM.put("Y", 80.0f);
        HM.put(typeValuesHM, "Red");

        typeValuesHM=new HashMap<String, Float>();
        typeValuesHM.put("X", 192.0f);
        typeValuesHM.put("Y", 80.0f);
        HM.put(typeValuesHM, "Red");

        typeValuesHM=new HashMap<String, Float>();
        typeValuesHM.put("X", 192.0f);
        typeValuesHM.put("Y", 320.0f);
        HM.put(typeValuesHM, "Blue");

        typeValuesHM=new HashMap<String, Float>();
        typeValuesHM.put("X", 336.0f);
        typeValuesHM.put("Y", 560.0f);
        HM.put(typeValuesHM, "Blue");

        int count = Collections.frequency(new ArrayList<String>(HM.values()), "Red");
        System.out.println(count);
    }
}
