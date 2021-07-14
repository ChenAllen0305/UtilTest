package Thread.LimitAccessCount;

import java.util.concurrent.Semaphore;

/**
 * ClassName: SemaphoreMethod
 * Author: ChenLun
 * date: 2021/5/21
 * Description: 限制方法多线程访问次数
 */
public class SemaphoreService {

    private Semaphore semaphore = new Semaphore(1);

    public void method() {
        if (!semaphore.tryAcquire()) {
            System.out.println(Thread.currentThread().getName() + "未得到许可");
        }
        try {
            System.out.println(Thread.currentThread().getName() + "得到许可");
            Thread.sleep(10000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
