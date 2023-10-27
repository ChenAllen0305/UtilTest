package MathTest;

import lombok.extern.slf4j.Slf4j;

/**
 * @className: DivadeTest
 * @author: ChenLun
 * @date: 2023/4/6 10:12
 * @description:
 */
@Slf4j
public class DivadeTest {
    public static void main(String[] args) {
        double pushTime = 134.0;

        double pushHour = Math.floor(pushTime / 60);
        double pushTimeMinute = pushTime % 60;

        log.info("pushHour: " + pushHour);
        log.info("pushTimeMinute: " + pushTimeMinute);
    }
}
