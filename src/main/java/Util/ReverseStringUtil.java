package Util;

public class ReverseStringUtil {
    public void reverseString(String[] s){
        int length = s.length;
        for(int i=length-1;i>=0;i--){
            System.out.print(s[i]);
        }
    }

    public void reverseChar(char[] s){
        int length = s.length;
        for(int i=length-1;i>=0;i--){
            System.out.print(s[i]);
        }
    }
}


