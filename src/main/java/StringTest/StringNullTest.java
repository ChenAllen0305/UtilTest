package StringTest;

public class StringNullTest {
    public static void main(String[] args) {
        String s = null;

//        System.out.println(s.equals(null));
//        System.out.println(s.isEmpty());
        System.out.println(s == null);

        for (int i = 1; i<=36 ; i++) {
            System.out.println("(s1)-[:HAS_MENU]->(m" + i + "),");
        }
    }
}
