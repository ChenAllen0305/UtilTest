package WusitaiModel;

public class SubStringTest {
    public static void main(String[] args) {
        String s = "BCMS1单体电压1";
        String s1 = "130140017000";
        System.out.println(s1.substring(3));
        String code = "110501" + "1" + s1.substring(7);
        System.out.println(code);

//        System.out.println(s.substring(9));
//
//        System.out.println(s.substring(0,7) + "电池" + s.substring(9));
//
//        System.out.println(s.substring(0,5) + "_" + s.substring(9));
    }
}
