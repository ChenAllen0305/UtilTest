package LocalDateTimeTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Date now = new Date(120,4,6,17,55,23);
        System.out.println(now);
        System.out.println(now.toString());
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(now));
    }
}
