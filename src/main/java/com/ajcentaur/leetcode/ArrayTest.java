package com.ajcentaur.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0.0
 * @author: Centaur
 * @date: 2022/9/8 16:46
 * @description: 数组结构
 */
public class ArrayTest {
    public static void main(String[] args){
        System.out.println(test(new int[]{1,1,0,1,1,1}));
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2},2));
        System.out.println(test(new int[]{}));
        Map<Integer,Integer> map = new HashMap<>();

    }
    /**
     * 485 最大连续 1 的个数
     * @param nums
     * @return
     */
    public static int test(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int max = 0;
        int temp = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                temp++;
            }else{
                //或者用Math.max(result,count)
                if(temp > max){
                    max = temp;
                }
                temp = 0;
            }
        }
        if(temp > max){
            max = temp;
        }
        return max;
    }

    /**
     * 283. 移动零
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int index = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                nums[index] = nums[i];
                index++;
            }
        }
        for(int i=index;i<nums.length;i++){
            nums[i] = 0;
        }
    }

    /**
     * 27  移除元素
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            while(l < r && nums[l] != val){
                l++;
            }
            while(l < r && nums[r] == val){
                r--;
            }
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
        return nums[l] == val?l:l+1;
//        int left = 0, right = nums.length;
//        while (left < right) {
//            if (nums[left] == val) {
//                nums[left] = nums[right-1];
//                right--;
//            } else {
//                left++;
//            }
//        }
//        return left;
    }
}
