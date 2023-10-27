package ForTest;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: BreakTest
 * @author: ChenLun
 * @date: 2022/11/28 17:55
 * @description:
 */
@Slf4j
public class BreakTest {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            log.info("count: " + i);
            list.add(String.valueOf(i));
            if (list.size() == 5) {
                break;
            }
        }

        log.info("list: " + list);
    }
}
