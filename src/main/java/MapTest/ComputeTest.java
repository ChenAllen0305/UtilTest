package MapTest;

import Util.EmptyUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @className: ComputeTest
 * @author: ChenLun
 * @date: 2022/8/16 10:09
 * @description:
 */
@Slf4j
public class ComputeTest {
    public static void main(String[] args) {
//        Map<String, List<Integer>> map = new HashMap<>();
        Map<String, AtomicLong> map = new HashMap<>();

        String key1 = "test";
        String key2 = "test2";

        log.info(map.toString());
//        List<Integer> list = map.computeIfAbsent(key, k -> new ArrayList<>());
        AtomicLong value = map.computeIfAbsent(key1, k -> new AtomicLong());
        AtomicLong value2 = map.computeIfPresent(key2, (k, v) -> new AtomicLong());

        log.info(map.toString());
//        list.add(1);
//        value.incrementAndGet();
        value = new AtomicLong(5);

        log.info(map.toString());

        int i = EmptyUtil.isEmpty(key1) ? 1 : 0;
        log.info("" + i);
    }
}
