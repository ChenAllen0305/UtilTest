package LeetCode;

/**
 * 回文数的判定
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class isPalindrome {
    public static void main(String[] args) {
        boolean isPalindromeF = false;
        int num = -15123;
        if(num < 0){
            isPalindromeF = false;
        }
        // 方法一:暴力破解，将整个数字变化成数组再反转比较
        String stringnum = String.valueOf(num);
        String[] arrs = stringnum.split("");
        String result = "";
        for(int i=arrs.length-1; i>=0; i--){
            result += arrs[i];
        }
        System.out.println(result);

    }

    // 方法二：通过计算余数进行比较
    public boolean isPalindrome2(int x) {
        //边界判断
        if (x < 0) return false;
        int div = 1;
        //
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

    // 方法三：取出后半段进行翻转比较
    public boolean isPalindrome(int x) {
        // 末尾为0肯定为false
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
