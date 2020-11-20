package LocalDateTimeTest;

import Util.DateTimeUtils;

import java.time.LocalDateTime;

public class TimeZoneTest {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        String timeZone = "Australia/Queensland";
        LocalDateTime stationNow = DateTimeUtils.updateTimeZoneDate(now, timeZone);
        String stationDtime = DateTimeUtils.format(stationNow);
        System.out.println(stationDtime);
    }
}
