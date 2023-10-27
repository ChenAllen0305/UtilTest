package StreamTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @className: EmptyTest
 * @author: ChenLun
 * @date: 2023/1/12 18:51
 * @description:
 */
public class EmptyTest {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = null;
        List<String> result1 = list2.stream().distinct().collect(Collectors.toList());

    }
}
