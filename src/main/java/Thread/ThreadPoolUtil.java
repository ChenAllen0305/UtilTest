package Thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName: ThreadPoolUtil
 * Author: ChenLun
 * date: 2021/9/29
 * Description: 线程池工具类
 */
public class ThreadPoolUtil {

    private static ExecutorService executorService;

    public static void createThreadPool(Integer poolSize) {
        executorService = Executors.newFixedThreadPool(poolSize);
    }

    public static void insertThread(Runnable runnable) {
        executorService.submit(runnable);
    }

}
