package LeetCode;

public class reverseOnlyLetters {
    public static void main(String[] args) {
        int num = -1230;
        String[] nums = String.valueOf(num).split("");
        String result = "";
        if (nums[0].equals("-")) {
            result += "-";
            System.out.println(result);
            for (int i=nums.length-1; i>=1; i--) {
                result += nums[i];
            }
        } else {
            for (int i=nums.length-1; i>=0; i--) {
                result += nums[i];
            }
        }
        System.out.println(result);
        System.out.println(Integer.valueOf(result));
    }
}
