package LeetCode;

public class rotateList {
    public static void main(String[] args) {
        rotateList rl = new rotateList();
        int[] nums = new int[]{1,2,3,4,5,6,7};

        rl.rotate(nums, 3);
        for(int i: nums){
            System.out.print(i + " ");
        }
        System.out.println("/.");
        int[] result = rl.rotate2(nums, 3);
        for(int i: result){
            System.out.print(i + " ");
        }
    }

    // 暴力旋转
    public void rotate(int[] nums, int k){
        int temp;
        int previous;
        for(int i= 0; i< k; i++){
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    // 创建新的数组保存移动后的数据
    // 若为void方法，则需要将新的数组复制到老的数组当中
    public int[] rotate2(int[] nums, int k){
        int[] result = new int[nums.length];
        for(int i=0; i < nums.length; i++){
            result[(i+k) % nums.length] = nums[i];
        }
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }

        return result;
    }
}
