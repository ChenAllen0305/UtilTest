package ListTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @className: StreamTest
 * @author: ChenLun
 * @date: 2022/11/18 9:39
 * @description:
 */
@Slf4j
public class StreamTest {
    public static void main(String[] args) {
        List<DemoTest> list = new ArrayList<>();

        list.add(new DemoTest("name2", 2));
        list.add(new DemoTest("name1", 1));
        log.info("before sort: " + list);

        List<String> names = list.stream().sorted(Comparator.comparing(DemoTest::getCode)).map(DemoTest::getName).collect(Collectors.toList());
        log.info("after sort: " + names);

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DemoTest {
        private String name;

        private Integer code;
    }
}
