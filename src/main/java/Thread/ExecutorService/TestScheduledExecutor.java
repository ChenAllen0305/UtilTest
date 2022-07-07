package Thread.ExecutorService;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: TestScheduledExecutor
 * Author: ChenLun
 * date: 2021/9/22
 * Description:
 */
@Slf4j
public class TestScheduledExecutor {

    private ScheduledExecutorService scheduledExecutorService;

    public long start;

    public TestScheduledExecutor() {
        this.scheduledExecutorService = Executors.newScheduledThreadPool(10);
        this.start = System.currentTimeMillis();
    }

    public void timerOne(int i) {
        ScheduledFuture future = scheduledExecutorService.schedule(() -> {
            System.out.println("No." + i + ",timerOne,the time:" + (System.currentTimeMillis() - start));
            log.error("No." + i + "关闭前启动");
        }, 0, TimeUnit.MILLISECONDS);
        future.cancel(Boolean.FALSE);
        log.info("No." + i + "关闭");
    }

    public void timerTwo(int i) {
        scheduledExecutorService.schedule(() -> {
                    log.error("启动失败");
                    throw new RuntimeException("启动失败");
                },
                0, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {
        TestScheduledExecutor test = new TestScheduledExecutor();
//        ScheduledFuture one = test.timerOne();
//        log.info(one.toString());
//        ScheduledFuture two = test.timerOne();
//        log.info(two.toString());
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                test.timerTwo(i);
            } else {
                test.timerOne(i);
            }
        }
    }
}
