package GregorianCalendar;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * ClassName: Test1
 * Author: ChenLun
 * date: 2021/5/21
 * Description:
 */
public class Test1 {
    public static void main(String[] args) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        System.out.println(gregorianCalendar);
        Calendar calendar = new GregorianCalendar();
        System.out.println(calendar);
        Calendar calendar1 = Calendar.getInstance();
        System.out.println(calendar1);
        System.out.println(gregorianCalendar.isLeapYear(gregorianCalendar.get(Calendar.YEAR)));
    }
}
