package LocalDateTimeTest;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class StringToTimeTEST {
    public static void main(String[] args) {
//        String dtime = "20:00:00-08:00:00";
        String dtime = "00:00:00-24:00:00";
        List<List<LocalTime>> results = getTimeList(dtime);
        System.out.println(results);
        LocalTime now = LocalTime.now();
        Time zeroTime = Time.valueOf("00:00:00");
        System.out.println(zeroTime.toLocalTime());
        now = now.plusMinutes(1);

        for (List<LocalTime> localTimes : results) {
            if (localTimes.get(0).isBefore(now) && localTimes.get(1).isAfter(now)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
//
//        Long zeroTime = Time.valueOf("08:00:00").getTime();
//        System.out.println(zeroTime);
    }

    public static List<List<LocalTime>> getTimeList(String abnormalSmsConfig) {
        String dtime = abnormalSmsConfig;
        String[] arr = dtime.split(",");
        List<List<LocalTime>> resultList = new ArrayList<>();
        if (arr.length > 0) {
            for (String str : arr) {
                String[] times = str.split("-");
                if (times != null && times.length == 2) {
                    Time startTime = Time.valueOf(times[0]);
                    Time endTime = Time.valueOf(times[1]);
                    //比较开始时间和结束时间，针对20:00-08:00做处理
                    if (startTime.before(endTime)) {
                        List<LocalTime> result = new ArrayList<>();
                        result.add(startTime.toLocalTime());
                        //减1做特殊处理
                        result.add(endTime.toLocalTime().minusMinutes(1));
                        resultList.add(result);
                    } else {
                        Time zeroTime = Time.valueOf("00:00:00");
                        List<LocalTime> result = new ArrayList<>();
                        result.add(startTime.toLocalTime());
                        result.add(zeroTime.toLocalTime());
                        resultList.add(result);
                        result = new ArrayList<>();
                        result.add(zeroTime.toLocalTime());
                        result.add(endTime.toLocalTime());
                        resultList.add(result);
                    }
                }
            }
        }
        return resultList;
    }
}
