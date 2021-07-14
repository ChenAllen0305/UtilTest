package Thread.LimitAccessCount;

/**
 * ClassName: ThreadA
 * Author: ChenLun
 * date: 2021/5/21
 * Description:
 */
public class ThreadA extends Thread{
    private SemaphoreService semaphoreService;

    public ThreadA(SemaphoreService semaphoreService) {
        this.semaphoreService = semaphoreService;
    }

    @Override
    public void run() {
        semaphoreService.method();
    }
}
