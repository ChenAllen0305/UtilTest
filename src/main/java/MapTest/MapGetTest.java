package MapTest;

import java.util.*;

public class MapGetTest {
    public static void main(String[] args) {
        String area = "NSW";
        Map<String, List<Long>> map = new HashMap<>();
        List<Long> pns = map.get(area);
        if (pns == null || pns.size() == 0) {
            map.put(area, new ArrayList<>(Collections.singletonList(1001L)));
        } else {
            pns.add(1002L);
            map.put(area, pns);
        }
        //---------------
        if (pns != null) {
            pns.clear();
        }
        pns = map.get(area);
        if (pns == null || pns.size() == 0) {
            map.put(area, Collections.singletonList(1001L));
        } else {
            pns.add(1002L);
            map.put(area, pns);
        }
    }
}
