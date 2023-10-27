package ListTest;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: ListRetainAllTest
 * @author: ChenLun
 * @date: 2022/11/15 14:03
 * @description:
 */
@Slf4j
public class ListRetainAllTest {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("ab");
        list1.add("abc");

        List<String> list2 = new ArrayList<>();
        list2.add("ab");

        list1.retainAll(list2);
        log.info(list1.toString());
    }
}
