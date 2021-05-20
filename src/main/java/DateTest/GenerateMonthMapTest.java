package DateTest;

import Domain.Cat;
import Util.DateTimeUtils;

import java.util.*;

/**
 * ClassName: GenerateMonthMapTest
 * Author: ChenLun
 * date: 2021/5/12
 * Description:
 */
public class GenerateMonthMapTest {
    public static void main(String[] args) {
        Date start = DateTimeUtils.formatToDate("2021-05-11 00:00:00");

        Date end = DateTimeUtils.formatToDate("2021-05-11 00:00:00");

        Map<String, Cat> map = generateMonthMap(start, end);
        System.out.println(map);
    }

    private static  Map<String, Cat> generateMonthMap(Date startDate, Date endDate) {
        Map<String, Cat> monthMap = new HashMap<>();
        while (startDate.before(endDate) || startDate.equals(endDate)) {
            String key = generateMapKey(startDate);
            Cat value = monthMap.get(key);
            if (value == null) {
                value = new Cat("name", 1);
                monthMap.put(key, value);
            }
            startDate = getNextMonth(startDate);
        }
        return monthMap;
    }

    private static String generateMapKey(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int year = instance.get(Calendar.YEAR);
        int month = instance.get(Calendar.MONTH);
        return year + "-" + month;
    }

    public static Date getNextMonth(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);//把日期往后增加一天.整数往后推,负数往前移动
        return calendar.getTime();//这个时间就是日期往后推一天的结果
    }
}
