package Util;

import java.text.SimpleDateFormat;
import java.util.*;

public class DateTest {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化时间
//        Date date = new Date();// 获取当前时间
//        List<Date> list = new ArrayList<>();
//        System.out.println("现在时间：" + sdf.format(date)); // 输出已经格式化的现在时间（24小时制）
//        list.add(date);
//        System.out.println(date);
//
//        String s1 = "2019-09-19 15:45:00";
//        String s2 = "2019-09-19 15:46:00";
//        String s3 = "2019-09-19 15:47:00";
//        List<String> list2 = new ArrayList<>();
//        list2.add(s2);
//        list2.add(s3);
//        list2.add(s1);
//        System.out.println(list2);
//
//        Collections.sort(list2);
//        System.out.println(list2);
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date start = calendar.getTime();
        System.out.println(start);
        System.out.println(sdf.format(start));
        System.out.println(date);
        System.out.println(sdf.format(date));
        List<Date> dates = Arrays.asList(start, date);
        System.out.println(dates);
    }
}
