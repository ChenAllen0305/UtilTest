package DateTest;

import Util.DateTimeUtils;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    public static void main(String[] args) {
//        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.getTime().getTime());
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH);
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//        int hour =  calendar.get(Calendar.HOUR_OF_DAY);
//        int minute = calendar.get(Calendar.MINUTE);
//        int second = calendar.get(Calendar.SECOND);
//        Date startTime = DateTimeUtils.formatToDate("06:00:00", "HH:mm:ss");
//        calendar.setTime(startTime);
//        calendar.set(year, month, day, hour, minute, second);
//        startTime = calendar.getTime();
//
//
//        calendar.set(year, month, day, hour, minute, second);
//        //无法设置nanoSecond
//        Date now = calendar.getTime();
//        System.out.println(now);
//        System.out.println(now.getTime());
//
//
//        System.out.println(startTime);
//        System.out.println(startTime.getTime());
//        int result = startTime.compareTo(now);
//        System.out.println(result);
        Date date = new Date();
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(Calendar.HOUR, -12);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.SECOND, 0);
        instance.set(Calendar.MILLISECOND, 0);
        date = instance.getTime();
        System.out.println(DateTimeUtils.format(date));
    }
}
