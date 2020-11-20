package LeetCode;

public class InsertPosition {

    public int searchInsert(int[] nums, int target) {
        int position = 0;
        if(target < nums[0]){
            return 0;
        } else if(target > nums[nums.length -1]){
            return nums.length;
        } else {
            for(int i=0; i<nums.length; i++){
                if(target <= nums[i]){
                    position = i;
                    break;
                }
            }
        }
        return position;
    }
}
