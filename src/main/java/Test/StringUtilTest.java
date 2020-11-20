package Test;

import Util.StringUtil;

public class StringUtilTest {
    public static void main(String[] args){
        String str = "0123456789";
        boolean ans = StringUtil.isEmpty(str);
//        boolean ans = StringUtil.isNumber(str);
//        for(int index=0; index < str.length(); index++){
//            System.out.println((int) str.charAt(index));
//        }
//        if(ans){
//            System.out.println("Yes");
//        } else {
//            System.out.println("No");
//        }


        System.out.println(ans);

        Long chargeTypeCode = 140000029L;
        Long dischargeTypeCode = 140000030L;
        Long nanziTypeCode = 140000039L;

//        System.out.println(chargeTypeCode + " " + dischargeTypeCode + " " + nanziTypeCode);
    }
}
