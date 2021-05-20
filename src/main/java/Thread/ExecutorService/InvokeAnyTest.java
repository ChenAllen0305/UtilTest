package Thread.ExecutorService;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * ClassName: InvokeAnyTest
 * Author: ChenLun
 * date: 2021/5/20
 * Description:
 */
@Slf4j
public class InvokeAnyTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Set<Callable<String>> callables = new HashSet<>();

        callables.add(() -> "task1");

        callables.add(() -> "task2");

        callables.add(() -> "task3");

        //invokeAny - 反正第一个执行完成的任务
//        for (int i = 1 ; i <=100; i ++) {
//            String result = executorService.invokeAny(callables);
//            System.out.println("结果: " + result);
//        }

        //invokeAll
        List<Future<String>> results = executorService.invokeAll(callables);
        results.stream().forEach(result -> {
            try {
                System.out.println(result.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
//        System.out.println("结果: " + result);
        executorService.shutdown();
    }
}
