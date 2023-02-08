package com.ajcentaur.leetcode.arraygroup;

/**
 * 双指针
 */
public class DoublePoint {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2},2));
    }

    /**
     * leetcode:27
     * @param nums
     * @param val
     * @return
     */
    private static int removeElement(int[] nums, int val){
        int slow = 0;
        for(int fast = 0; fast < nums.length; fast++){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
