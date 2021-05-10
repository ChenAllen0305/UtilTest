package DateTest;

import Util.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.DateUtils;

import java.util.Date;

/**
 * ClassName: DateMinsTest
 * Author: ChenLun
 * date: 2021/5/10
 * Description:
 */
@Slf4j
public class DateMinsTest {
    public static void main(String[] args) {
        Date d1 = DateTimeUtils.formatToDate("2021-01-01 00:00:00");
        Date d2 = DateTimeUtils.formatToDate("2020-02-01 00:00:00");
        log.info(String.valueOf(d1.getTime()));
        log.info(String.valueOf(d2.getTime()));
        long diff = d1.getTime() - d2.getTime();
        log.info(String.valueOf(diff));
        long oneYear = 365 * 24 * 60 * 60 * 1000;
        log.info(String.valueOf(oneYear));
        if (diff > oneYear) {
            System.out.println("时差大于1年");
        } else {
            System.out.println("时差小于1年");
        }

        long day = diff/(24 * 60 * 60 * 1000);
        log.info(String.valueOf(day));
    }
}
