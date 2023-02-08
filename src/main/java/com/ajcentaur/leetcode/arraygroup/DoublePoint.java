package com.ajcentaur.leetcode.arraygroup;

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

    /**
     * leetcode:209
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = 0;
        int right = 0;
        int result = nums.length + 1;
        while(right < nums.length){
            sum += nums[right];
            while(sum >= target){
                int curVal = right - left + 1;
                result = result > curVal ? curVal : result;
                sum -= nums[left];
                left++;
            }
            right++;
        }
        if(result > nums.length){
            return 0;
        }
        return result;
    }
}
