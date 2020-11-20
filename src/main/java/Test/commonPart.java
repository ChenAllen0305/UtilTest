package Test;

import Util.longestCommonPrefix;

public class commonPart {
    public static void main(String[] args) {
        longestCommonPrefix lc = new longestCommonPrefix();
        String[] strs = new String[]{"flower","flow","flight"};

        String result = lc.longestCommonPrefix1(strs);
        System.out.println(result);
    }
}
