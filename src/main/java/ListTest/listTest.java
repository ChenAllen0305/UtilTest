package ListTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class listTest {
    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        list.add(2L);
        list.add(3L);
        list.add(1L);
        list.sort(Comparator.naturalOrder());
//        System.out.println(list.size());
//        System.out.println(list.get(list.size()));
        System.out.println(list);
    }
}
