package ListTest;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: AddRemoveTEST
 * @author: ChenLun
 * @date: 2022/5/5 16:28
 * @description:
 */
@Slf4j
public class AddRemoveTest {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            integers.add(i);
        }
        log.info(integers + " with size " + integers.size());
        integers.add(16);
        log.info(integers + " with size " + integers.size());
        integers.remove(0);
        log.info(integers + " with size " + integers.size());
    }
}
