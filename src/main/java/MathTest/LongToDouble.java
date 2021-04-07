package MathTest;

/**
 * @title: LongToDouble
 * @Author Chen Lun
 * @Date: 2021/2/25
 */
public class LongToDouble {
    public static void main(String[] args) {
        Long now = System.currentTimeMillis();
        System.out.println(now);
        Double val = (double) now;
        System.out.println(val);
        Long now1 = val.longValue();
        System.out.println(now1);
    }
}
