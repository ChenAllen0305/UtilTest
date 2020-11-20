package LocalDateTimeTest;

import Util.DateTimeUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class UnitTest {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDate date = now.toLocalDate();
        String day = DateTimeUtils.format(LocalDateTime.of(date, LocalTime.MIN));
        System.out.println(day);
    }
}
