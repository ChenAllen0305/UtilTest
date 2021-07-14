package DateTest;

import Util.DateTimeUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * @title: DateTest
 * @Author Chen Lun
 * @Date: 2021/4/1
 */
public class DateTest {
    public static void main(String[] args) {
//        Date startDtime = new Date();
//        String YmdPattern = "yyyy-MM-dd";
//        String nowStr = DateTimeUtils.format(startDtime);
//        String startDtimeStr = DateTimeUtils.format(YmdPattern, startDtime);
//        System.out.println(startDtimeStr);
//
//        Date date = DateTimeUtils.formatToDate(nowStr);
//        System.out.println(date);
//        String eventDtime = DateTimeUtils.parseStrToNewStr(DateTimeUtils.PATTERN.DATETIME.value(), nowStr, DateTimeUtils.PATTERN.DATE.value());
//        System.out.println(eventDtime);
//        String eventStratDay = DateTimeUtils.format(YmdPattern,  date);
//        System.out.println(eventStratDay);
//        if (startDtimeStr.equals(eventStratDay)) {
//            System.out.println(1);
//        } else {
//            System.out.println(2);
//        }

        Date date = DateTimeUtils.formatToDate("2021-06-09 22:01:02");
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(Calendar.HOUR_OF_DAY, 0);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.SECOND, 0);
        instance.set(Calendar.MILLISECOND, 0);
        Date zeroDate = instance.getTime();
        System.out.println(DateTimeUtils.format(zeroDate));
    }
}
