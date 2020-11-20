package SetTest;



import Util.DateTimeUtils;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        String dtimeStr1 = DateTimeUtils.getDateString(1603884600000L, "Australia/Queensland", "yyyy-MM-dd HH:mm:ss");
        String dtimeStr2 = DateTimeUtils.getDateString(1603797300000L, "Australia/Queensland", "yyyy-MM-dd HH:mm:ss");

        LocalDateTime dateTime = DateTimeUtils.format(dtimeStr1).withHour(0).withMinute(0).withSecond(0).withNano(0);
        System.out.println(dateTime);

        set.add(dtimeStr1);
        set.add(dtimeStr2);
        set.add(dtimeStr2);
        System.out.println(set);
        for (String str : set) {
            LocalDateTime start = DateTimeUtils.format(str, "yyyy-MM-dd HH:mm:ss").withHour(0).withMinute(0).withSecond(0).withNano(0);
            LocalDateTime end = DateTimeUtils.format(str, "yyyy-MM-dd HH:mm:ss").withHour(23).withMinute(45).withSecond(0).withNano(0);
            System.out.println(DateTimeUtils.format(start));
            System.out.println(DateTimeUtils.format(start));
        }
    }
}
