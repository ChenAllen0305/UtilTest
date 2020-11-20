package LocalDateTimeTest;

import Util.DateTimeUtils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalDateTimeUtil {
    public static void main(String[] args) {
        //----------------------------------------获取
        //获取当前时间
        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(localDateTime);
//        //获取当前月份
//        int month = localDateTime.getMonthValue();
//        System.out.println(month);
//        //获取在当前月份中的日期
//        int dayOfMonth = localDateTime.getDayOfMonth();
//        System.out.println(dayOfMonth);
//        System.out.println("---------------------------------------");
//        //----------------------------------------计算
//        //计算日期加减
//        LocalDateTime yesterday = localDateTime.minusDays(1);
//        System.out.println(yesterday);
//        LocalDateTime nextYear = localDateTime.plusYears(1);
//        System.out.println(nextYear);
//        System.out.println("---------------------------------------");
//        //-----------------------------------------直接设置
//        //设置日月年时分秒
//        LocalDateTime setMonth = localDateTime.withMonth(4);
//        System.out.println(setMonth);
//        //这个月第一天
//        System.out.println(localDateTime.with(TemporalAdjusters.firstDayOfMonth()));
//        //这个月最后一天
//        System.out.println(localDateTime.with(TemporalAdjusters.lastDayOfMonth()));
//        //下个月第一天
//        System.out.println(localDateTime.with(TemporalAdjusters.firstDayOfNextMonth()));
//        System.out.println("---------------------------------------");
//        //---------------------------------------格式化
        //转String
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter pattern =
                DateTimeFormatter.ofPattern("G yyyy年MM月dd号 E a hh时mm分ss秒");
        DateTimeFormatter pattern2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter pattern3 = DateTimeFormatter.ofPattern("yyyy-MM");
//        String format = now.format(pattern);
//        String format2 = now.format(pattern2);
//        System.out.println(format);
//        System.out.println(format2);
        String before7Days = now.plusDays(-7).format(pattern2);
        String before8Days = now.plusDays(-8).format(pattern2);
//        System.out.println(before7Days + " " + before8Days);
        //转LocalDateTime
        LocalDateTime dt1 = LocalDateTime.parse("2020-07",pattern3);
        System.out.println(dt1);
//        LocalDateTime test = DateTimeUtils.format("2020-07-07 09:23:31", "yyyy-MM");
//        System.out.println(test);
        LocalDateTime dt2 = LocalDateTime.parse("2020-07-01 00:00:00",pattern2);
//        do {
//            System.out.println(dt1.getDayOfMonth());
//            dt1 = dt1.plusDays(1);
//            System.out.println(dt1);
//        } while (dt1.is(Before(dt2) || dt1.isEqual(dt2));
//        System.out.println(dt.format(pattern3));
//        //--------------------------------------Date转LocalDateTime
        Date todayDate = new Date();

//        System.out.println(todayDate);

        LocalDateTime ldt = todayDate.toInstant().atZone( ZoneId.systemDefault() ).toLocalDateTime();

//        System.out.println(ldt);
//        //--------------------------------------LocalDateTime转Date
//        System.out.println(localDateTime);
//
        Date date = Date.from(localDateTime.atZone( ZoneId.systemDefault()).toInstant());

//        System.out.println(date);

        LocalDateTime sevenDayLater = localDateTime.plusHours(164);

        Boolean result = sevenDayLater.isBefore(localDateTime);
//        System.out.println(result);
    }
}
