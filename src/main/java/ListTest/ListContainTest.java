package ListTest;

import java.util.ArrayList;
import java.util.List;

public class ListContainTest {
    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        s.add("test");
        s.add("ceshi");

//        if (s.contains("test")) {
//            System.out.println(1);
//        } else if (s.contains("ceshi")) {
//            System.out.println(2);
//        }
//        for (int i = 1; i < s.size(); i++) {
//            System.out.println(s.get(i));
//        }
        System.out.println(s.toString());
    }
}
