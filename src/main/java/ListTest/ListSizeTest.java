package ListTest;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: ListSizeTest
 * @author: ChenLun
 * @date: 2022/11/18 10:32
 * @description:
 */
@Slf4j
public class ListSizeTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(251);

        for (int i = 0; i <= 250; i++) {
            list.add(i);
        }
        log.info("size: " + list.size());

        int loopSize = list.size() / 100;
        log.info("loopSize: " + loopSize);
        if (0 != (list.size() % 100)) {
            loopSize++;
        }
        log.info("loopSize: " + loopSize);
    }
}
