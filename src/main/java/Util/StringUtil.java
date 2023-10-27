package Util;

import lombok.extern.slf4j.Slf4j;

import java.text.DecimalFormat;

@Slf4j
public class StringUtil {
    public static boolean isEmpty(String str){
        return str == null || "".equals(str);
    }

    public static boolean isNumber(String str){
        for(int index = 0; index < str.length(); index++){
            if(48 > (int) str.charAt(index) || (int) str.charAt(index) > 57){
                return false;
            }
        }
        return true;
    }

    public static DecimalFormat getZeroFixFormat(Integer number) {
        int numberLength2 = (int) Math.floor(Math.log1p(number));
        log.info("numberLength2: " + numberLength2);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numberLength2; i++) {
            stringBuilder.append("0");
        }
        return new DecimalFormat(stringBuilder.toString());
    }
}
