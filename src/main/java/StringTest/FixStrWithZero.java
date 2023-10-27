package StringTest;

import Util.StringUtil;
import lombok.extern.slf4j.Slf4j;

import java.text.DecimalFormat;

@Slf4j
public class FixStrWithZero {
    public static void main(String[] args) {
        DecimalFormat decimalFormat = StringUtil.getZeroFixFormat(2);

        for (int i = 1; i <= 2; i++) {
            log.info(decimalFormat.format(i));
        }
    }
}
