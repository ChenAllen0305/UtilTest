package DateTest;

import Util.DateTimeUtils;

import java.util.Date;

/**
 * @title: DateTest
 * @Author Chen Lun
 * @Date: 2021/4/1
 */
public class DateTest {
    public static void main(String[] args) {
        Date startDtime = new Date();
        String YmdPattern = "yyyy-MM-dd";
        String nowStr = DateTimeUtils.format(startDtime);
        String startDtimeStr = DateTimeUtils.format(YmdPattern, startDtime);
        System.out.println(startDtimeStr);

        Date date = DateTimeUtils.formatToDate(nowStr);
        System.out.println(date);
        String eventDtime = DateTimeUtils.parseStrToNewStr(DateTimeUtils.PATTERN.DATETIME.value(), nowStr, DateTimeUtils.PATTERN.DATE.value());
        System.out.println(eventDtime);
        String eventStratDay = DateTimeUtils.format(YmdPattern,  date);
        System.out.println(eventStratDay);
        if (startDtimeStr.equals(eventStratDay)) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }
    }
}
