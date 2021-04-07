package Number;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @title: AtomicInteger
 * @Author Chen Lun
 * @Date: 2021/3/10
 */
public class AtomicIntegerTest {
    public static void main(String[] args) {

        AtomicInteger currentRetrySize = new java.util.concurrent.atomic.AtomicInteger(0);
        System.out.println(currentRetrySize);
        currentRetrySize.getAndIncrement();
        System.out.println(currentRetrySize);
    }
}
