package LocalDateTimeTest;

import Util.DateTimeUtils;

import java.time.LocalDateTime;

public class TimeTest {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now().withSecond(0).withNano(0).plusMinutes(-25);
        now = timeHandle(now.getMinute(), now);
        //获取服务器时区
        String currentDtime = DateTimeUtils.format(now);
        Long currentRtime = DateTimeUtils.getTimestamp(currentDtime, "Asia/Shanghai");
        String timeZone = "Australia/Adelaide";
        String stationDtime = DateTimeUtils.getDateString(currentRtime, timeZone);
        System.out.println(stationDtime);
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
