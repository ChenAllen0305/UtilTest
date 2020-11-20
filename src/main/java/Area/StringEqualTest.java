package Area;

public class StringEqualTest {
    public static void main(String[] args) {
        String s1 = "Taiwan";
        String s2 = "taiwan";
        if (s1.equals(s2)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
