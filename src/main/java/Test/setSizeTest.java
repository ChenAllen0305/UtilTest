package Test;

import java.util.HashSet;
import java.util.Set;

public class setSizeTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        String month = "1";
        set.add(month);
        System.out.println(set.size());
    }
}
