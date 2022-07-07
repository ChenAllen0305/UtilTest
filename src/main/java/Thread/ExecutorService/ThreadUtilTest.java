package Thread.ExecutorService;

import Thread.ThreadPoolUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * ClassName: UtilTest
 * Author: ChenLun
 * date: 2021/10/8
 * Description:
 */
@Slf4j
public class ThreadUtilTest {
    public static void main(String[] args) {
        ThreadPoolUtil.insertThread(() ->
        {
            try {
                log.info("test");
            } catch (RuntimeException e) {
                log.error(e.getMessage());
            }
        });
    }
}
