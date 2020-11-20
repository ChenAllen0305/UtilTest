package LocalDateTimeTest;

import java.util.Date;

public class LocalDateTimeCal {
    public static void main(String[] args) {
//        LocalDateTime now = LocalDateTime.now();
//        now.withHour(0).withMinute(0).withSecond(0);
//        LocalDateTime change = now.withHour(0).withMinute(0).withSecond(0).withNano(0);
//        System.out.println(change);

        Date date = new Date();
        System.out.println(date.toString());
    }
}
