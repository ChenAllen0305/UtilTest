package Util;

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

}
