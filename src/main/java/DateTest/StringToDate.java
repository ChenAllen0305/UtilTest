package DateTest;

import Util.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
public class StringToDate {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    private static SimpleDateFormat sdf3 = new SimpleDateFormat("HH:mm:ss");

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) throws ParseException {
//        List<Date> newdate = new ArrayList<>();
//        dtime.set(0,DateTimeUtils.asDate(DateTimeUtils.asLocalDateTime(dtime.get(0)).withYear(dtime.get(0).getYear() + 1900).withDayOfMonth(dtime.get(0).getDay())));
//        dtime.set(1,DateTimeUtils.asDate(DateTimeUtils.asLocalDateTime(dtime.get(1)).withYear(dtime.get(1).getYear() + 1900).withDayOfMonth(dtime.get(1).getDay())));
//        String s = "2020-08-24T16:30:00".replace("T", " ");
//        Date date = null;
//        try {
//            date = sdf.parse(s);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (date != null) {
//            System.out.println(date);
//        }
//        String s2 = "2020-08-24T16:30:00";
//        Date date2 = sdf2.parse(s2);
//        System.out.println(date2);

//        String s3 = "00:00:00";
//        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//        Date date2 = sdf3.parse(s3);
//        Date date = dateFormat.parse(s3);
//        System.out.println(s3);
//        System.out.println(date);
//        LocalDateTime startMonth = LocalDateTime.now().withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
//        String loopMonthDtime = DateTimeUtils.format(startMonth);
//        Long loopMonthRtime = DateTimeUtils.getTimestamp(loopMonthDtime, "Australia/Queensland");
//        System.out.println(loopMonthDtime);
//        System.out.println(loopMonthRtime);

        Date now = new Date();
        log.info("方法1：");
        Long method1Start = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        String nowStr = simpleDateFormat.format(now);
        System.out.println(nowStr.substring(0, 7));
        Long method1End = System.currentTimeMillis();
        log.info("耗时:" + (method1End - method1Start));

        Long method2Start = System.currentTimeMillis();
        System.out.println(generateMapKey(now));
        Long method2End = System.currentTimeMillis();
        log.info("耗时:" + (method2End - method2Start));
    }

    private static String generateMapKey(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int year = instance.get(Calendar.YEAR);
        int month = instance.get(Calendar.MONTH);
        return year + "-" + month;
    }
}
