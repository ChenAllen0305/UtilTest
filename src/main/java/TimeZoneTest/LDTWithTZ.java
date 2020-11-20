package TimeZoneTest;

import Util.DateTimeUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LDTWithTZ {

    private static DateTimeFormatter YmdHmsPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now().withSecond(0).withNano(0).plusMinutes(-15);
        now = timeHandle(now.getMinute(), now);

        String currentDtime = now.format(YmdHmsPattern);
        System.out.println(currentDtime);
        Long timeStamp = DateTimeUtils.getTimestamp(currentDtime, "Asia/Shanghai");
        System.out.println(timeStamp);
        String stationDtime = DateTimeUtils.getDateString(timeStamp, "Australia/Adelaide");
        System.out.println(stationDtime);
        LocalDateTime stationNowTime = LocalDateTime.parse(stationDtime, YmdHmsPattern);
        System.out.println(stationNowTime);
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
