package TimeZoneTest;

import Util.DateTimeUtils;

import java.time.LocalDateTime;
import java.util.Date;

public class dateTest {
    public static void main(String[] args) {
        Long timeStamp = System.currentTimeMillis();
        System.out.println(timeStamp);
        LocalDateTime nextDayStart = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0).plusDays(1);
        Date date = DateTimeUtils.asDate(nextDayStart);
        Long dateStamp = date.getTime();
        System.out.println(dateStamp);
        System.out.println(dateStamp - timeStamp);
    }
}
