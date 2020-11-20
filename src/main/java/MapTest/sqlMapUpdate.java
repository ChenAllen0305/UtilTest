package MapTest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class sqlMapUpdate {
    public static void main(String[] args) {
        Map<Long, Long> map = new HashMap<>();
        map.put(11020100015001L, 21145L);
        map.put(11020100015002L, 23180L);
        map.put(11020100015003L, 23112L);
        map.put(11020100015004L, 23053L);
        map.put(11020100024001L, 23054L);
        map.put(11020100024002L, 23026L);
        map.put(11020100024003L, 23027L);
        map.put(11020100024004L, 23249L);
        map.put(11020100024005L, 23250L);
        map.put(11020100024006L, 23163L);
        map.put(11020100024007L, 23251L);
        map.put(11020100024008L, 23164L);
        map.put(11020101000001L, 20950L);
        map.put(11020101000002L, 20523L);
        map.put(11020101000003L, 21399L);
        map.put(11020101000004L, 20957L);
        map.put(11020100016001L, 4440L);

        List<Map.Entry<Long, Long>> list = new LinkedList<>(map.entrySet());

        for (Map.Entry<Long, Long> entry : list) {
            System.out.println("update sgool4.data_alarm_event1 set dev_id = " + entry.getValue() +" where dev_id = " + entry.getKey() +
                    ";");
        }
    }
}
