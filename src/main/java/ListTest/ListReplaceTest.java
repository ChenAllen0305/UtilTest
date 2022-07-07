package ListTest;

import java.util.Arrays;
import java.util.List;

/**
 * @className: ListReplaceTest
 * @author: ChenLun
 * @date: 2022/1/10 9:25
 * @description:
 */
public class ListReplaceTest {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(integers);
        for (Integer integer : integers) {
            if (integer.equals(3)) {
                integer = 32;
            }
        }
        System.out.println(integers);
    }
}
