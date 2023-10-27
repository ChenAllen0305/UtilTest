package StringTest;

import java.nio.charset.StandardCharsets;

public class StringNullTest {
    public static void main(String[] args) {
        String s = "s1";
        String s2 = "s2";

//        System.out.println(s.equals(null));
//        System.out.println(s.isEmpty());
        System.out.println(!s.equals(s2));

//        for (int i = 1; i<=36 ; i++) {
//            System.out.println("(s1)-[:HAS_MENU]->(m" + i + "),");
//        }

        System.out.println(StandardCharsets.UTF_8.name());


        String industry = null + "/" + "A1" + null + "A2";
        System.out.println(industry);
    }
}
