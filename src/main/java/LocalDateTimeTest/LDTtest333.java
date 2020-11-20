package LocalDateTimeTest;

import Util.DateTimeUtils;

import java.time.LocalDateTime;

public class LDTtest333 {
//    public static void main(String[] args) {
//        String timeZone = "Australia/Adelaide";
//        String timeZoneSys = "Australia/Queensland";
//
//        LocalDateTime now1 = LocalDateTime.now().withSecond(0).withNano(0);
//        System.out.println(now1);
//        LocalDateTime now = DateTimeUtils.updateTimeZoneDate(LocalDateTime.now().withSecond(0).withNano(0), timeZone);
//
//        LocalDateTime now2 = DateTimeUtils.updateTimeZoneDate(LocalDateTime.now().withMonth(12).withSecond(0).withNano(0), timeZoneSys);
//        System.out.println(now);
//        System.out.println(now2);
//    }

    public static void main(String[] args) {
        String timeZone = "Australia/Queensland";
        LocalDateTime now = DateTimeUtils.updateTimeZoneDate(LocalDateTime.now().withSecond(0).withNano(0), timeZone);
        now = timeHandle(now.getMinute(), now);
        System.out.println(now);
        //根据timeZone转换
        now = DateTimeUtils.updateTimeZoneDate(now, timeZone);
        System.out.println(now);
    }

    private static LocalDateTime timeHandle(int minute, LocalDateTime localDateTime) {
        if (minute >= 45) {
            localDateTime = localDateTime.withMinute(45);
        } else if (minute >= 30) {
            localDateTime = localDateTime.withMinute(30);
        } else if (minute >= 15) {
            localDateTime = localDateTime.withMinute(15);
        } else  if (minute >= 0) {
            localDateTime = localDateTime.withMinute(0);
        }
        return localDateTime;
    }
}
