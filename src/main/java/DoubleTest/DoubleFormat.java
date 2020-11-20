package DoubleTest;

import Util.DateTimeUtils;

import java.text.DecimalFormat;
import java.util.Date;

public class DoubleFormat {
    public static void main(String[] args) {
        Double d = 0.0;
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(d));
//        d = d / 10000;
        System.out.println(d);
//        Double d1 = null;
//        String out = (d1==null)?"0":String.valueOf(d1);
//        System.out.println(out);
    }
}
