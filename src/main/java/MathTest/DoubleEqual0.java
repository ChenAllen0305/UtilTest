package MathTest;

public class DoubleEqual0 {
    public static void main(String[] args) {
        Double test1 = 0D;
        Double test2 = 0.0;
        System.out.println(test1.equals(0.0));
        System.out.println(test1 == 0.0);
        if (test1 != 0.0 && test2 != 0.0) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }
    }
}
