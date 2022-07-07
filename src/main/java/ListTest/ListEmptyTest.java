package ListTest;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * ClassName: ListEmptyTest
 * Author: ChenLun
 * date: 2021/7/8
 * Description:
 */
public class ListEmptyTest {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(integers);
        ListIterator<Integer> iterator = integers.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(5)) {
                iterator.set(555);
            }
        }
        System.out.println(integers);
    }
}
