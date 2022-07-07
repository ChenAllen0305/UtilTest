package Thread.FutureTask;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * ClassName: FutureGetTest
 * Author: ChenLun
 * date: 2021/10/8
 * Description:
 */
@Slf4j
public class FutureGetTest {
    //    public static void main(String[] args) {
//        ExecutorService service = Executors.newFixedThreadPool(20);
//
//        for (int j = 1; j <= 2; j++) {
//            int finalJ = j;
//            Future future = service.submit(() ->
//            {
//                try {
//                    for (int i = 1; i <= 2; i++) {
//                        log.info("Thread" + finalJ + "Round" + i);
//                        Thread.sleep(1000);
//                    }
//                    return;
//                } catch (RuntimeException | InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                    log.error(e.getMessage());
//                }
//            });
//            try {
//                future.get(10, TimeUnit.SECONDS);
//            } catch (ExecutionException | InterruptedException | TimeoutException e) {
//                Thread.currentThread().interrupt();
//                future.cancel(Boolean.TRUE);
//            }
//        }
//        log.info("Count" + Thread.activeCount());
//        log.info("terminated" + service.isTerminated());
//        try {
//            service.shutdown();
//            log.info("Count" + Thread.activeCount());
//
//            if (!service.awaitTermination(1, TimeUnit.SECONDS)) {
//                service.shutdownNow();
//                log.info("Count" + Thread.activeCount());
//            }
//        } catch (InterruptedException e) {
//            log.error("await");
//            e.printStackTrace();
//        }
//    }
    public static void main(String[] args) {

        List<Future> futureList = new ArrayList<>();

        for (int q = 1; q <= 3; q++) {
            ExecutorService service = Executors.newFixedThreadPool(40);
            for (int j = 1; j <= 20; j++) {
                int finalJ = j;
                Future<Boolean> booleanTask = service.submit(() -> {
                    for (int i = 1; i <= 5; i++) {
                        log.info("Thread" + finalJ + "Round" + i);
                        Thread.sleep(1000);
                    }
                    return true;
                });
                log.info("start" + finalJ + ":" + booleanTask);
                futureList.add(booleanTask);

            }
            if (!futureList.isEmpty()) {
                futureList.forEach(k -> service.submit(() -> {
                    try {
                        log.info("ThreadGet" + k);
                        k.get(10, TimeUnit.SECONDS);
                    } catch (ExecutionException e) {
                        log.error("1");
                        k.cancel(Boolean.TRUE);
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        log.error("2");
                        k.cancel(Boolean.TRUE);
                        e.printStackTrace();
                    } catch (TimeoutException e) {
                        log.error("3" + k);
                        k.cancel(Boolean.TRUE);
                        e.printStackTrace();
                    }
                }));
            }
            log.info("ThreadSize:" + Thread.activeCount());
            log.info("shutdown" + service.isShutdown());
            log.info("terminated" + service.isTerminated());
            service.shutdownNow();
        }
    }
}
