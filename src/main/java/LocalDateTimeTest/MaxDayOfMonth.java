package LocalDateTimeTest;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.TemporalAdjusters;

public class MaxDayOfMonth {
    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.now().withDayOfMonth(1);
        LocalDateTime start2 = start.with(TemporalAdjusters.firstDayOfMonth());
        LocalDateTime startMonthLastDay = start.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(start);
        System.out.println(start2);
        System.out.println(startMonthLastDay);
        start = start.plusMonths(1);
    }
}
