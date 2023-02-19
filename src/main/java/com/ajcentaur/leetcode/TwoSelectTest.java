package com.ajcentaur.leetcode;

/**
 * @version 1.0.0
 * @author: Centaur
 * @date: 2022/9/14 23:00
 * @description: TwoSelectTest
 */
public class TwoSelectTest {
    public static void main(String[] args) {
//        System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,4}));
        System.out.println(minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }

    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (left + right)/2;
            if(nums[mid] > nums[mid + 1]){
                right = mid;
            }else if(nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }
        }
        return left;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int total = 0;
        int res = 0;
        while(j < nums.length){
            total = total + nums[j];
            j = j + 1;
            while(total >= target){
                res = j - 1;
                i = i + 1;
                j = i;
                total = 0;
            }
        }
        return res;
    }
}
