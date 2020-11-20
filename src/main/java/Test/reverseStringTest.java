package Test;
import Util.ReverseStringUtil;
import Util.ReverseStringSwapUtil;

public class reverseStringTest {
    public static void main(String[] args){
        ReverseStringUtil rsu = new ReverseStringUtil();
        String s = "hello";
        String[] s1 = s.split("");
//        rsu.reverseString(s1);

        char[] s2 = s.toCharArray();
        rsu.reverseChar(s2);

        ReverseStringSwapUtil su = new ReverseStringSwapUtil();
        su.reverseString(s2);
        for(char c : s2){
            System.out.print(c);
        }
    }
}
