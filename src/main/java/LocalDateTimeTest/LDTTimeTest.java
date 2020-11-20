package LocalDateTimeTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LDTTimeTest {

    public static void main(String[] args) {

        DateTimeFormatter YmdHmsPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        DateTimeFormatter YmPattern = DateTimeFormatter.ofPattern("yyyy-MM");

        LocalDateTime now = LocalDateTime.now().withMinute(20).withSecond(0).withNano(0);
        now = timeHandle(now.getMinute(), now);
        String nowDateString = YmPattern.format(now);
        System.out.println(now);
        System.out.println(nowDateString);
    }

    private static LocalDateTime timeHandle(int minute, LocalDateTime localDateTime) {
        if (minute >= 45) {
            localDateTime = localDateTime.withMinute(45);
        } else if (minute >= 30) {
            localDateTime = localDateTime.withMinute(30);
        } else if (minute >= 15) {
            localDateTime = localDateTime.withMinute(15);
        } else  if (minute >= 0) {
            localDateTime = localDateTime.withMinute(0);
        }
        return localDateTime;
    }
}
