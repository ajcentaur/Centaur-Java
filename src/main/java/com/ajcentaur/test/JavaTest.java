package com.ajcentaur.test;

import java.util.*;

public class JavaTest {

    public static void main(String[] args){
        Map<Integer,Integer> typeMap = new HashMap<>();
        Integer a = typeMap.get(5);
//        ArrayList<Integer> a = new ArrayList<>(15);
//        System.out.println(a.size());
//        a.add(1);
//        System.out.println(a.size());
//        Collections.synchronizedList(a);
//        a.add(2);
//        System.out.println(a.size());
//        System.out.println(test(new int[]{1,1,0,1,1,1}));
//        System.out.println(test(null));
//        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2},2));
//        System.out.println(removeElement2(new int[]{3,2,2,3,3},3));
//        System.out.println(sortedSquares(new int[]{-7,-3,2,3,11}));
        System.out.println(minSubArrayLen(4,new int[]{1,4,4}));
//        System.out.println(test(new int[]{}));
//        a.add(5,1);
//        a.set(5,1);
//        System.out.println(longestPalindrome("cccac"));
//        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
//        System.out.println(maxArea(new int[]{1,1}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int total = 0;
        int res = nums.length + 1;
        while(j < nums.length){
            total += nums[j];
            j++;
            while(total >= target){
                res = Math.min(res,j-i);
                // if(j - i < res){
                //     res = j - i;
                // }
                total -= nums[i];
                i++;
            }
        }
        return res == nums.length+1?0:res;
    }

    public static int[] sortedSquares(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int[] res = new int[nums.length];
        int k = nums.length - 1;
        while(l < r){
            if(nums[l] * nums[l] > nums[r] * nums[r]){
                res[k] = nums[l] * nums[l];
                k--;l++;
            }else if(nums[l] * nums[l] < nums[r] * nums[r]){
                res[k] = nums[r] * nums[r];
                k--;r--;
            }
        }
        if(l == r){
            res[k] = nums[l] * nums[l];
        }
        return res;
    }

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

    public static int removeElement2(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        //双指针：快慢指针
        int slow = 0;
        for(int fast = 0; fast < nums.length; fast++){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int maxlength = 0;
        int left = 0;
        int right = 0;
        for(int i = len - 1; i >= 0; i--){
            for(int j = i; j < len; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i < 2){
                        dp[i][j] = true;
                    }else if (dp[i + 1][j - 1]){
                        dp[i][j] = true;
                    }
                }
                if(dp[i][j] && j - i + 1 > maxlength){
                    maxlength = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left,right + 1);
    }

    public static int maxArea(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;

        while(left < right){
            int maxIndex = right - left;
            res = Math.max(res, maxIndex * Math.min(height[left], height[right]));
            if(height[left] > height[right]){
                right--;
            }else{
                left++;
            }

        }
        return res;
    }

}
