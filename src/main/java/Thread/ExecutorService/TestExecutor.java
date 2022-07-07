package Thread.ExecutorService;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName: TestExecutor
 * Author: ChenLun
 * date: 2021/9/23
 * Description:
 */
@Slf4j
public class TestExecutor {

    private ExecutorService executorService;

    public TestExecutor() {
        this.executorService = Executors.newFixedThreadPool(10);
    }

    public static void main(String[] args) {
        TestExecutor testExecutor = new TestExecutor();
        for (int i = 1; i <= 100; i++) {
            int finalI = i;
            if (i % 2 == 0) {
                testExecutor.executorService.submit(() ->
                        log.error("No." + finalI + "启动成功"));
            } else {
                testExecutor.executorService.submit(() ->
                {
                    log.error("No." + finalI + "启动失败");
                    String empty = "";
                    try {
                        Integer integer = Integer.valueOf(empty);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        }
    }
}
