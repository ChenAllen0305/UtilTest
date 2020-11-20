package LeetCode;

import java.util.HashMap;
import java.util.Set;

/**
 * 下一个更大元素
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 */
public class nextBiggerNum {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};

        // 暴力破解方法，读题不清
//        if(nums1.length >= nums2.length){
//            for(int i=0; i<nums2.length-1; i++){
//                if(nums1[i] < nums2[i+1]){
//                    nums1[i] = nums2[i+1];
//                } else {
//                    nums1[i] = -1;
//                }
//            }
//            for(int j=nums2.length-1; j<nums1.length;j++){
//                nums1[j] = -1;
//            }
//        } else {
//            for(int i=0; i<nums1.length; i++){
//                if(nums1[i] < nums2[i+1]){
//                    nums1[i] = nums2[i+1];
//                } else {
//                    nums1[i] = -1;
//                }
//            }
//        }

        // 整体思路对，但是题目阅读不清楚
        // 找的是右边第一个比它大的元素，而不是右边一个位置上是否比它大
//        HashMap<Integer, Integer> hm = new HashMap();
//        for(int i=0; i<nums2.length; i++){
//            hm.put(nums2[i], i);
//        }
//
//        for(int j=0; j<nums1.length; j++){
//            if(hm.containsKey(nums1[j]) == true && hm.get(nums1[j]) != nums2.length-1){
//                int position = hm.get(nums1[j]) + 1;
//                if(nums1[j] < nums2[position]){
//                    nums1[j] = nums2[position];
//                } else {
//                    nums1[j] = -1;
//                }
//            } else {
//                nums1[j] = -1;
//            }
//        }

        //----------------------------------------
        // success
        HashMap<Integer, Integer> hm = new HashMap();
        for(int i=0; i<nums2.length; i++){
            hm.put(nums2[i], i);
        }

        for(int j=0; j<nums1.length; j++){
            if(hm.containsKey(nums1[j]) == true && hm.get(nums1[j]) != nums2.length-1){
                int position = hm.get(nums1[j]) + 1;
                if(position == nums2.length){
                    nums1[j] = -1;
                } else {
                    for(int x = position; x<nums2.length; x++){
                        if(nums2[x] > nums1[j]){
                            nums1[j] = nums2[x];
                            break;
                        }
                        if(x == nums2.length-1){
                            nums1[j] = -1;
                        }
                    }
                }
            } else {
                nums1[j] = -1;
            }
        }
        for(int i: nums1){
            System.out.println(i);
        }
    }
}
