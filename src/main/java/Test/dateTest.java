package Test;

import java.util.Calendar;
import java.util.Date;

public class dateTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        System.out.println(calendar);
        calendar.add(Calendar.MONTH, -1);
        System.out.println(calendar);
    }
}
