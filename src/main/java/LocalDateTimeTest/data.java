package LocalDateTimeTest;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class data {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime zero = now.withHour(0).withMinute(0).withSecond(0);
        LocalDateTime zeroPlus = zero.plusSeconds(10);
//        System.out.println(zero);
//        System.out.println(zeroPlus);
        //---------------
        DecimalFormat df = new DecimalFormat("#0.00");
        Double val = 2 + Math.random()*(5-2);
//        Double val = 1 + Math.random()*(1.1-0.9);

//        Random r = new Random();
//        Double val1 = r.nextDouble(1.1)
//        System.out.println(df.format(val));
//        System.out.println(zero);
        //---------------
        DateTimeFormatter pattern2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format2 = zero.format(pattern2);
        //---------------
        for (int i=0; i<=4680; i++) {
            String dtime = zero.format(pattern2);
            zero = zero.plusSeconds(10);
//            zero =zero .plusHours(1);
//            val = 0.9 + Math.random()*(1.1-0.9);
//            val = 2 + Math.random()*(5-2);
            if (i%360 == 0) {
                val = 2 + Math.random()*(5-2);
            }
//            val = 3.65;
            System.out.println("{" +
                    "\"pointNumber\":" + "\"200000041\"," +
                    "\"dtime\":" + "\"" + dtime + "\"," +
                    "\"val\":" + "\"" + df.format(-val) + "\"},");
            System.out.println("{" +
                    "\"pointNumber\":" + "\"200000043\"," +
                    "\"dtime\":" + "\"" + dtime + "\"," +
                    "\"val\":" + "\"" + df.format(-val) + "\"},");
        }
    }
}
