package LocalDateTimeTest;

import java.time.*;

public class ZoneOffSetTest {
    public static void main(String[] args) {
        OffsetDateTime odt = OffsetDateTime.now ( ZoneId.systemDefault () );
        ZoneOffset zoneOffset = odt.getOffset ();
        System.out.println(zoneOffset);
        Long startMill = LocalDateTime.now().toEpochSecond(zoneOffset);
        System.out.println(startMill);
//        ZonedDateTime zdt = LocalDateTime.now().atZone(ZoneId.of("America/Los_Angeles"));
        ZonedDateTime zdt = LocalDateTime.now().atZone(zoneOffset);
        System.out.println(zdt);
        long millis = zdt.toInstant().toEpochMilli();
        System.out.println(millis);
    }
}
