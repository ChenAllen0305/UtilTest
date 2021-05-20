package Thread.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName: Executor
 * Author: ChenLun
 * date: 2021/5/19
 * Description: 限制线程数
 */
public class Executor {

    public static void main(String[] args) {
        final int MAX_THREADS = 3;//定义线程数最大值

        ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREADS);

        for (int i = 0; i < 10; i++) {
            int no = i;
            int lifeTime = (int)(Math.random() * 9 + 1);

            executorService.submit(new SampleThread(no, lifeTime));
        }

        executorService.shutdown();
    }
}
