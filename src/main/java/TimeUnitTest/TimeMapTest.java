package TimeUnitTest;

import Util.DateUtils;

import java.util.*;

/**
 * ClassName: TimeMapTest
 * Author: ChenLun
 * date: 2021/7/27
 * Description:
 */
public class TimeMapTest {
    public static void main(String[] args) {
        //初始化日期格式
        String pattern = getTimePattern(DayTimeEnum.MONTH);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date startDate = calendar.getTime();
        System.out.println(startDate);
        Date endDate = new Date();
        System.out.println(endDate);
        //能源消耗数据映射 - 时间和值的映射
        Map<String, Double> dateValueMap = new HashMap<>();
        initializeDateValueMap(dateValueMap, Optional.empty(), startDate, endDate, DayTimeEnum.MONTH, pattern);
        System.out.println(dateValueMap);
    }

    /**
     * 根据时间枚举获取时间格式化字段
     */
    private static String getTimePattern(DayTimeEnum dayTimeEnum) {
        String pattern = null;
        if (dayTimeEnum.equals(DayTimeEnum.INTRADAY)) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        } else if (dayTimeEnum.equals(DayTimeEnum.DAY)) {
            pattern = "yyyy-MM-dd";
        } else if (dayTimeEnum.equals(DayTimeEnum.MONTH)) {
            pattern = "yyyy-MM";
        }
        return pattern;
    }

    /**
     * 初始化日期和值的映射表，初始话日期和产量的映射表
     */
    private static void initializeDateValueMap(Map<String, Double> dateValueMap,
                                               Optional<Map<String, Integer>> outputMap,
                                               Date startDate,
                                               Date endDate,
                                               DayTimeEnum dayTimeEnum,
                                               String pattern) {
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);
        fillingDateValueMap(dateValueMap, start, end, dayTimeEnum, pattern);
        if (outputMap.isPresent()) {
            Map<String, Integer> outputMapGet = outputMap.get();
            dateValueMap.keySet().forEach(dtime -> outputMapGet.put(dtime, 0));
        }
    }

    /**
     * 日内：填充每小时
     * 日：填充每天
     * 月：填充每月
     */
    private static void fillingDateValueMap(Map<String, Double> dateValueMap,
                                            Calendar start,
                                            Calendar end,
                                            DayTimeEnum dayTimeEnum,
                                            String pattern) {
        if (dayTimeEnum.equals(DayTimeEnum.INTRADAY)) {
            while (start.before(end) || start.equals(end)) {
                dateValueMap.put(DateUtils.format(start.getTime(), pattern), 0d);
                start.add(Calendar.HOUR, 1);
            }
        } else if (dayTimeEnum.equals(DayTimeEnum.DAY)) {
            while (start.before(end) || start.equals(end)) {
                dateValueMap.put(DateUtils.format(start.getTime(), pattern), 0d);
                start.add(Calendar.DAY_OF_YEAR, 1);
            }
        } else if (dayTimeEnum.equals(DayTimeEnum.MONTH)) {
            while (start.before(end) || start.equals(end)) {
                dateValueMap.put(DateUtils.format(start.getTime(), pattern), 0d);
                start.add(Calendar.MONTH, 1);
            }
        }
    }
}
