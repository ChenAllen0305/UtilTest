package LocalDateTimeTest;

import Util.DateTimeUtils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class test2 {
    private String pattern = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) {
//        String timeZone = "Australia/Queensland";
//        Long rtime = System.currentTimeMillis();
//        String dtime = DateTimeUtils.getDateString(rtime, timeZone);
//        System.out.println(dtime);
//        System.out.println(DateTimeUtils.getTimestamp("2020-09-18 00:00:00", null));
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MILLISECOND, 0);
//        Date date = calendar.getTime();
//        System.out.println(date);
        String pattern = "yyyy-MM-dd";

//        Long lastTime = LocalDateTime.now().withMinute((LocalDateTime.now().getMinute() / 15) * 15).withSecond(0).withNano(0)
//                .atZone(TimeZone.getDefault().toZoneId()).toInstant().toEpochMilli();
//        System.out.println(lastTime);

        String dtime = "2020-11-07";
        Date date1 = DateTimeUtils.formatToDate(dtime, pattern);
        LocalDateTime localDateTime = DateTimeUtils.asLocalDateTime(date1);
//        LocalDateTime localDateTime1 = DateTimeUtils.format(dtime, pattern);
        System.out.println(localDateTime);
        Long test = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        System.out.println(test);
//        Long test2 = localDateTime1.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
//        System.out.println(test2);
        LocalDateTime date = DateTimeUtils.format(dtime, pattern);
        System.out.println(date);
        Long effectiveRtime = DateTimeUtils.parseDateTime(pattern, dtime);
        System.out.println(effectiveRtime);
    }
}
