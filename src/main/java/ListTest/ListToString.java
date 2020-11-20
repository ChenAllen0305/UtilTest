package ListTest;

import java.util.ArrayList;
import java.util.List;

public class ListToString {
    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        String s = list.toString();
        System.out.println(s);
    }
}
