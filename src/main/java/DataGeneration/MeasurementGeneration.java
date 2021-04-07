package DataGeneration;

import Util.DateTimeUtils;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

public class MeasurementGeneration {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat( "0.00");
        //日内维度数据
//        LocalDateTime dayStart = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
//        for (int i = 0; i < 96 ; i++) {
//            Long timeStamp = DateTimeUtils.asDate(dayStart).getTime();
//            double doubleValue = 20 + Math.random() * (60);
//            System.out.println("{\n" +
//                    "      \"dtime\": \"" + DateTimeUtils.format(dayStart) + "\",\n" +
//                    "      \"flag\": 0,\n" +
//                    "      \"pointNumber\": 1108999997,\n" +
//                    "      \"rtime\": " + timeStamp + ",\n" +
//                    "      \"val\": " + df.format(doubleValue) + "\n" +
//                    "    },");
//            dayStart = dayStart.plusMinutes(15);
//        }

        //日维度数据
//        LocalDateTime monthStart = LocalDateTime.now().withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
//        for (int i = 0; i < 22 ; i++) {
//            Long timeStamp = DateTimeUtils.asDate(monthStart).getTime();
//            double doubleValue = 200 + Math.random() * (500);
//            System.out.println("{\n" +
//                    "      \"dtime\": \"" + DateTimeUtils.format(monthStart) + "\",\n" +
//                    "      \"flag\": 0,\n" +
//                    "      \"pointNumber\": 9004573588,\n" +
//                    "      \"rtime\": " + timeStamp + ",\n" +
//                    "      \"val\":" + df.format(doubleValue) + "\n" +
//                    "    },");
//            monthStart = monthStart.plusDays(1);
//        }

        //月维度数据
//        LocalDateTime yearStart = LocalDateTime.now().withDayOfYear(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
//        yearStart = yearStart.minusHours(2);
//        for (int i = 0; i < 11 ; i++) {
//            Long timeStamp = DateTimeUtils.asDate(yearStart).getTime();
//            double doubleValue = 2000 + Math.random() * (1000);
//            System.out.println("{\n" +
//                    "      \"dtime\": \"" + DateTimeUtils.format(yearStart) + "\",\n" +
//                    "      \"flag\": 0,\n" +
//                    "      \"pointNumber\": 1108999993,\n" +
//                    "      \"rtime\": " + timeStamp + ",\n" +
//                    "      \"val\":" + df.format(doubleValue) + "\n" +
//                    "    },");
//            yearStart = yearStart.plusMonths(1);
//        }

        //年维度数据
        LocalDateTime yearStart = LocalDateTime.now().withDayOfYear(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
        yearStart = yearStart.minusHours(2);
        for (int i = 0; i < 2 ; i++) {
            yearStart = yearStart.minusYears(1);
            Long timeStamp = DateTimeUtils.asDate(yearStart).getTime();
            double doubleValue = 100 + Math.random() * (200);
            System.out.println("{\n" +
                    "      \"dtime\": \"" + DateTimeUtils.format(yearStart) + "\",\n" +
                    "      \"flag\": 0,\n" +
                    "      \"pointNumber\": 1108999994,\n" +
                    "      \"rtime\": " + timeStamp + ",\n" +
                    "      \"val\":" + df.format(doubleValue) + "\n" +
                    "    },");
        }
    }
}
