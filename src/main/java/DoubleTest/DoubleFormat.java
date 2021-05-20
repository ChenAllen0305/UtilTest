package DoubleTest;

import java.text.DecimalFormat;

public class DoubleFormat {
    public static void main(String[] args) {
        double d = 10.0;
        DecimalFormat df = new DecimalFormat("#.00");
        DecimalFormat df2 = new DecimalFormat("0");
        System.out.println(df.format(d));
        System.out.println(d);

        double d2 = 123.81;
        System.out.println(df2.format(d2));

        double percent = d2 * 100;
        System.out.println(Integer.valueOf(df2.format(percent)));
        System.out.println((int) percent);
    }
}
