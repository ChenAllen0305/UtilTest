package DateTest;

import Util.DateTimeUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeZoneTest {
    private static String timeZone = "Australia/Queensland";

    public static void main(String[] args) {
//        Date date = new Date();
//        System.out.println(date);
////        DateTimeUtils.updateTimeZoneDate(date, timeZone);
//
//        SimpleDateFormat tokyoSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        tokyoSdf.setTimeZone(TimeZone.getTimeZone(timeZone));
//        String result = tokyoSdf.format(date);
//        System.out.println(result);
        LocalDateTime yesterdayLDT = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
        String dtime = DateTimeUtils.format(yesterdayLDT);
        Long rtime = DateTimeUtils.getTimestamp(dtime, timeZone);
        System.out.println(rtime);
    }
}
