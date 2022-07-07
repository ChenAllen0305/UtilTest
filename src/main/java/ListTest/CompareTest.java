package ListTest;

import java.util.*;

/**
 * @className: CompaerTest
 * @author: ChenLun
 * @date: 2022/5/26 19:16
 * @description:
 */
public class CompareTest {
    public static void main(String[] args) {
        List<Date> dateList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        dateList.add(calendar.getTime());
        System.out.println("1: " + dateList);

        calendar.add(Calendar.DAY_OF_MONTH, 2);
        dateList.add(calendar.getTime());
        System.out.println("3: " + dateList);

        dateList.sort(Comparator.comparing(Date::getTime));

        System.out.println("3: " + dateList);
    }
}
