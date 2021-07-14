package Thread.LimitAccessCount;

/**
 * ClassName: SemaphoreApplication
 * Author: ChenLun
 * date: 2021/5/21
 * Description:
 */
public class SemaphoreApplication {
    public static void main(String[] args) {
        SemaphoreService semaphoreService = new SemaphoreService();

        ThreadA a = new ThreadA(semaphoreService);
        a.setName("A");

        ThreadB b = new ThreadB(semaphoreService);
        b.setName("B");

        a.start();
        b.start();
    }
}
