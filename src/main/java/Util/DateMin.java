package Util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateMin {
    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);

        long now = System.currentTimeMillis() / 1000;
        System.out.println(now);
    }
}
