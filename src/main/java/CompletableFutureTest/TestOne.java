package CompletableFutureTest;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @className: TestOne
 * @author: ChenLun
 * @date: 2022/10/26 9:23
 * @description:
 */
@Slf4j
public class TestOne {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 基础任务
        CompletableFuture<Integer> task = CompletableFuture.supplyAsync(() -> 100);

        CompletableFuture<Integer> result1 = task.thenApply(number -> {
            number = number * 2;
            log.info("thenApply1: " + number);
            return number;
        });

        // join和get都可以获取相对应的返回值
        Integer result1Get1 = result1.get();
        Integer result1Get2 = result1.join();


        // 添加exceptionally方法返回异常状态下的默认值，优先使用这种，省去get或者join的异常处理
        CompletableFuture<Integer> result2 = task.thenApply(number -> {
            number = number / 0;
            log.info("thenApply2: " + number);
            return number;
        }).exceptionally(throwable -> {
            log.error(throwable.getMessage());
            return 0;
        });

        log.info("error result2 get: " + result2.get());
        log.info("error result2 join: " + result2.join());

        CompletableFuture<Integer> result3 = result1.thenApply(number -> {
            number = number * 2;
            log.info("thenApply3: " + number);
            return number;
        });

        CompletableFuture<Integer> result4 = task.thenApply(number -> {
            number = number / 0;
            log.info("thenApply2: " + number);
            return number;
        });

        log.info("error result4 join: " + result4.join());
        log.info("error result4 get: " + result4.get());
    }
}
