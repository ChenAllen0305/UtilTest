package LocalDateTimeTest;

import Util.DateTimeUtils;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class TimeZoneTest {
    public static void main(String[] args) {
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println(now);
//        String timeZone = "Australia/Queensland";
//        Long nowTimeStamp = now.atZone(ZoneId.of()).toInstant().toEpochMilli();
//        System.out.println(nowTimeStamp);
//        LocalDateTime stationNow = DateTimeUtils.updateTimeZoneDate(now, timeZone);
//        String stationDtime = DateTimeUtils.format(stationNow);
//        System.out.println(stationDtime);

        LocalDateTime now = LocalDateTime.now().withSecond(0).withNano(0).plusMinutes(-30);
        now = DateTimeUtils.timeHandle(now.getMinute(), now);
        System.out.println(now);
        Long currentRtime = System.currentTimeMillis();
        System.out.println(currentRtime);

        String currentDtime = DateTimeUtils.format(now);
        Long currentRtime2 = DateTimeUtils.getTimestamp(currentDtime, "Asia/Shanghai");

        Long currentRtime3 = DateTimeUtils.getTimestamp(currentDtime, "Australia/Queensland");
        System.out.println(currentRtime2);
        System.out.println(currentRtime3);



    }
}
