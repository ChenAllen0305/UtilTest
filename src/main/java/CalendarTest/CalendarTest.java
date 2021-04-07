package CalendarTest;

import java.util.Calendar;

/**
 * @title: CalendarTest
 * @Author Chen Lun
 * @Date: 2021/3/19
 */
public class CalendarTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(year + " " + month + " " + day);
    }
}
