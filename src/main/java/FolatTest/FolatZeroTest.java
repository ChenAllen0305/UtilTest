package FolatTest;

import java.text.DecimalFormat;

/**
 * ClassName: FolatZeroTest
 * Author: ChenLun
 * date: 2021/5/12
 * Description:
 */
public class FolatZeroTest {
    private static final DecimalFormat decimalFormat= new  DecimalFormat( "00.00" );
    public static void main(String[] args) {
        long l1 = 2;
        long l2 = 1;
        float result = calAbnormalPercent(l1, l2);
        System.out.println(result);
        System.out.println((float) ((Math.round(result * 1000))  / 1000));
    }

    private static float calAbnormalPercent(long normalQuantity, long abnormalQuantity) {
        if ((normalQuantity + abnormalQuantity) == 0) {
            return 0;
        } else {
            float result = abnormalQuantity / (abnormalQuantity + normalQuantity);
            double result2 = 1l * 1.0 / (1l + 2l);
            String result3 = decimalFormat.format(result2);
            return result;
        }
    }
}
