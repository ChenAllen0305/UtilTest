package LocalDateTimeTest;

import Util.DateTimeUtils;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class TaskTest {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now().withHour(0).withSecond(0).withNano(0);
        Integer nowYear = now.getYear();
        Integer nowMonth = now.getMonthValue();
        Integer nowDay = now.getDayOfYear();
        LocalDateTime startDay = now.withYear(2019).withMonth(6).withDayOfMonth(1);
        LocalDateTime endDay = now.withDayOfMonth(1);
        LocalDateTime startMonth = startDay.withDayOfMonth(1);
        LocalDateTime endMonth = endDay.withDayOfMonth(1);
        do {
            //如果为同年当月，则不新增
            if (startMonth.getYear() == nowYear &&  startMonth.getMonthValue() == nowMonth) {
                break;
            }
//            String startMonthDtime = DateTimeUtils.format(startMonth);
//            Long startMonthRtime = DateTimeUtils.getTimestamp(startMonthDtime, timeZone);
//            LocalDateTime startMonthLastDay = startMonth.with(TemporalAdjusters.lastDayOfMonth());;
            Double monthElecValue = 0.0;
            Double monthYieldValue = 0.0;
//            Yield month = createYield(objectId, startMonthDtime, monthElecValue, objectScale, TimeTypeConsts.TIMETYPE.MONTH.getName(), startMonthRtime);
//            List<Yield> days = analysisClient.getYieldDay(objectId, asDateString(startDay, startMonthLastDay)).getBody().getResults();
//            if (CollectionUtils.isNotEmpty(days)) {
//                for (Yield day : days) {
//                    if (day.getElectricity() != null && day.getVal() != null) {
//                        monthElecValue += day.getElectricity();
//                        monthYieldValue += day.getVal();
//                    }
//                }
//                month.setElectricity(monthElecValue);
//                month.setVal(monthYieldValue);
//            }
//            createList.add(month);
            monthElecValue++;
            monthYieldValue++;
            startMonth = startMonth.plusMonths(1);
            System.out.println(monthElecValue);
            System.out.println(monthYieldValue);
        } while (startMonth.isBefore(endMonth) || startMonth.isEqual(endMonth));
    }
}
