package TimeUnitTest;

import lombok.extern.slf4j.Slf4j;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TimeUnitTest {
    public static void main(String[] args) {
//        System.out.println(TimeUnit.SECONDS.toSeconds(5));
//        Calendar calendar = Calendar.getInstance();
//        Date now = calendar.getTime();
//        long nowLong = now.getTime();
//
//        calendar.add(Calendar.HOUR_OF_DAY, -1);
//        Date old = calendar.getTime();
//        long oldLong = old.getTime();

        long time = 1878583l;

        long minutes = TimeUnit.MILLISECONDS.toMinutes(time);
        log.info("minutes: " + minutes);
        DecimalFormat df = new DecimalFormat("0.00");
        double hours = minutes / 60d;

        log.info("hours: " + df.format(hours));
        log.info("hours: " + df.format(10.44333d));
        log.info("minutes: " + TimeUnit.MILLISECONDS.toHours(time));

        long hour = TimeUnit.MILLISECONDS.toDays(time)
                - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(time));
        log.info("hours: " + hour);
    }
}
