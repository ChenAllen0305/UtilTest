package LocalDateTimeTest;

import Util.DateTimeUtils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

public class LdtTest2 {
    public static void main(String[] args) {
        //-----------------------------------------------
//        String timeZone = "Australia/Adelaide";
//        Date dtime0 = DateTimeUtils.formatToDate("2020-09-07 00:00:00");
//        Date dtime1 = DateTimeUtils.formatToDate("2020-09-08 00:00:00");
//        LocalDateTime start = dtime0.toInstant().atZone( ZoneId.systemDefault() ).toLocalDateTime().plusMinutes(15);
//        LocalDateTime end = dtime1.toInstant().atZone( ZoneId.systemDefault() ).toLocalDateTime().plusMinutes(15);
//        LocalDateTime startAustralia = dtime0.toInstant().atZone( ZoneId.of(timeZone) ).toLocalDateTime().plusMinutes(15);
//        LocalDateTime endAustralia = dtime1.toInstant().atZone( ZoneId.of(timeZone) ).toLocalDateTime().plusMinutes(15);
//        System.out.println(dtime0 + " " + dtime1);
//        System.out.println(start + " " + end);
//        System.out.println(startAustralia + " " + endAustralia);
//---------------------------------------------------
//        LocalDateTime now = LocalDateTime.now().withSecond(0).withNano(0).plusMinutes(-25);
//        LocalDateTime now = LocalDateTime.now().withSecond(0).withNano(0);
//        now = timeHandle(now.getMinute(), now);
//        //获取服务器时区
//        String currentDtime = DateTimeUtils.format(now);
//        Long currentRtime = DateTimeUtils.getTimestamp(currentDtime, "Asia/Shanghai");
//        System.out.println(currentDtime + " " + currentRtime);
//
//        //获取电站时区时间字符串并转换为LocalDateTime
//        String stationDtime = DateTimeUtils.getDateString(currentRtime, timeZone);
//        LocalDateTime stationNowTime = DateTimeUtils.format(stationDtime);
//        System.out.println(stationNowTime);
//        int minute = now.getMinute();
//        if (minute >=30) {
//            now = now.withMinute(30);
//        } else if (minute >= 0) {
//            now = now.withMinute(0);
//        }
//        Long milliSecond = now.toInstant(ZoneOffset.of("+8")).toEpochMilli();
//        System.out.println(milliSecond);
//        System.out.println(now);
//        String date = DateTimeUtils.getDateString(milliSecond, timeZone);
//        Date dtime = DateTimeUtils.formatToDate(date);
//        System.out.println(dtime);
//        now.atZone(ZoneId.of(timeZone));
//        System.out.println(now);
//        Date nowDate = Date.from(now.atZone( ZoneId.of(timeZone)).toInstant());
//        System.out.println(nowDate);
//        Date nowDate2 = Date.from(now.atZone( ZoneId.systemDefault()).toInstant());
//        System.out.println(nowDate2);
//        DateTimeUtils.updateTimeZoneDate(nowDate2, timeZone);
//        System.out.println(nowDate2);

//        now = timeHandle(now.getMinute(), now);
//        String currentDtime = DateTimeUtils.format(now);
//        System.out.println(currentDtime);
//        Long timeStamp = DateTimeUtils.getTimestamp(currentDtime, "Asia/Shanghai");
//        System.out.println(timeStamp);
//        Long historyStamp = timeStamp - 900000;
//        System.out.println(historyStamp);
//        String s = DateTimeUtils.getDateString(historyStamp, "Asia/Shanghai");
//        System.out.println(s);
//        String history15min = DateTimeUtils.format(now.plusMinutes(-15));
//        System.out.println(history15min);

//        Long milliSecond = now.toInstant(ZoneOffset.of("+8")).toEpochMilli();
//        System.out.println(now + " " + milliSecond);
//        String date = DateTimeUtils.getDateString(milliSecond, timeZone);
//        System.out.println(date);
//        Date nowDate = DateTimeUtils.formatToDate(date);
//        System.out.println(nowDate);

        LocalDateTime calcDay = LocalDateTime.now().withMinute((LocalDateTime.now().getMinute() / 15) * 15);
        System.out.println(DateTimeUtils.format(calcDay));
        LocalDateTime start = LocalDateTime.of(calcDay.toLocalDate(), LocalTime.MIN);
        LocalDateTime end = LocalDateTime.of(calcDay.toLocalDate(), LocalTime.MAX);
        System.out.println(start);
        System.out.println(end);

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
