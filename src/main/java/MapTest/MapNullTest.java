package MapTest;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title: MapNullTest
 * @Author Chen Lun
 * @Date: 2021/1/29
 */
public class MapNullTest {
    public static void main(String[] args) {
        Map<Long, List<Long>> map = new HashMap<>();
        map.put(1L, new ArrayList<>(1));
        map.put(null, new ArrayList<>());
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() == null) {
                continue;
            } else {
                System.out.println(entry.getValue());
            }
        }
        System.out.println(map);

    }
}
