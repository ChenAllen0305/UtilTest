package LeetCode;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class plusOne {
    public static void main(String[] args) {
        int[] digits = new int[]{1,2,3};
        if(digits[0] == 0){
            //return digits;
        }
    }

    public int[] plusone(int[] digits){
        int length = digits.length - 1;
        for(int i=length; i >=0; i--){
            digits[i]++;
            digits[i] = digits[i]%10;
            if(digits[i] != 0){
                return digits;
            }
        }
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }
}
