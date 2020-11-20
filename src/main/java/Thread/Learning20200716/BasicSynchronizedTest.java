package Thread.Learning20200716;

import java.util.concurrent.atomic.AtomicInteger;

public class BasicSynchronizedTest {

    private static int count = 0;

    //3.添加原子类数据
    private static AtomicInteger atomicCount = new AtomicInteger(0);

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //每个线程让count自增100次
                    //1.该状态下线程不安全
                    for (int i = 0; i < 100; i++) {
                        count++;
                    }
                    for (int i = 0; i < 100; i++) {
                        atomicCount.incrementAndGet();
                    }
                    //2.加上同步锁会变为安全
//                    for (int i = 0; i < 100; i++) {
//                        synchronized (VolatileTestOne.class){
//                            count++;
//                        }
//                    }
                }
            }).start();
        }

        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(count);
        System.out.println(atomicCount);
    }
}
