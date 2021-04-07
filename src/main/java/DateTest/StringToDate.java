package DateTest;

import Util.DateTimeUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StringToDate {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    private static SimpleDateFormat sdf3 = new SimpleDateFormat("HH:mm:ss");

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
        LocalDateTime startMonth = LocalDateTime.now().withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
        String loopMonthDtime = DateTimeUtils.format(startMonth);
        Long loopMonthRtime = DateTimeUtils.getTimestamp(loopMonthDtime, "Australia/Queensland");
        System.out.println(loopMonthDtime);
        System.out.println(loopMonthRtime);
    }
}
