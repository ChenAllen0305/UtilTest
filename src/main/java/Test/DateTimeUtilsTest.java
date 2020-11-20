package Test;

import Util.DateTimeUtils;

import java.time.LocalDateTime;
import java.util.Date;

public class DateTimeUtilsTest {
    public static void main(String[] args) {
//        LocalDateTime now = LocalDateTime.now();
//
//        String nowStr = DateTimeUtils.format(now);
//        System.out.println(nowStr);
        LocalDateTime now = LocalDateTime.now().withSecond(0).withNano(0).plusMinutes(-15);
//        now = timeHandle(now.getMinute(), now);
        String currentDtime = DateTimeUtils.format(now);
        System.out.println(currentDtime);
        Long timeStamp = DateTimeUtils.getTimestamp(currentDtime, "Asia/Shanghai");
//        Long timeStamp = System.currentTimeMillis();
        System.out.println(timeStamp);
        String date = DateTimeUtils.getDateString(timeStamp, "Australia/Adelaide");
        System.out.println(date);
        Long ausTimeStamp = DateTimeUtils.getTimestamp(date, "Australia/Adelaide");
        System.out.println(ausTimeStamp);
        LocalDateTime stationNowTime = DateTimeUtils.format(date);
        System.out.println(stationNowTime);
        Date nowDateTest = DateTimeUtils.asDate(stationNowTime);
//        System.out.println(currentDtime + " " + timeStamp + " " + date);
//        System.out.println(stationNowTime + " " + nowDateTest + " " + ausTimeStamp);
    }
}
