package Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CalendarTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        List<String> dtime = new ArrayList<>();
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        Date endTime = calendar.getTime();
//        dtime.add(sdf.format(endTime));
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MILLISECOND, 0);
//        Date startTime = calendar.getTime();
//        dtime.add(0, sdf.format(startTime));
//        System.out.println(dtime);
        String test = "2019-11-22 00:00:00";
        Date date = sdf.parse(test);
        System.out.println( date);
    }
}
