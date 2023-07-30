package com.ajcentaur.leetcode.arraygroup;

/**
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
//        System.out.println(search704(new int[]{5},5));
//        System.out.println(search704two(new int[]{-1,0,3,5,9,12},13));
//        System.out.println(searchInsert(new int[]{1,3,5,6},4));
//        System.out.println(searchRange(new int[]{1,2,2,3,3,3,6},3));
//        System.out.println(mySqrt(22222));
        System.out.println(isPerfectSquare(5));
    }

    /**
     * leetcode:704
     * 二分查找区间左闭右闭[left, right]
     * @param nums
     * @param target
     * @return
     */
    public static int search704(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    /**
     * leetcode:704
     * 二分查找区间左闭右开[left, right)
     * @param nums
     * @param target
     * @return
     */
    public static int search704two(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > target){
                right = mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    /**
     * leetcode:35
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid +1;
            }else{
                return mid;
            }
        }
        return left;
    }

    /**
     * leetcode:34
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftIndex = -1;
        int rightIndex = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                leftIndex = mid;
                rightIndex = mid;
                break;
            }
        }
        if(left > right){
            return new int[]{leftIndex, rightIndex};
        }
        //查找左边界
        while(leftIndex > 0 && nums[leftIndex] == nums[leftIndex - 1]){
            leftIndex--;
        }
        //查找右边界
        while(rightIndex < nums.length - 1 && nums[rightIndex] == nums[rightIndex + 1]){
            rightIndex++;
        }
        return new int[]{leftIndex, rightIndex};
    }

    /**
     * leetcode:69
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        if(x == 0 || x == 1){
            return x;
        }
        //x的平方根的区间一定在x/2以内
        int left = 1;
        int right = x / 2;
        while(left <= right){
            int mid = left + (right - left) / 2;
            //用除法防止int的值溢出
            int val = x / mid;
            if(mid > val){
                right = mid - 1;
            }else if(mid < val){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return right;
    }

    /**
     * leetcode:367
     * @param num
     * @return
     */
    public static boolean isPerfectSquare(int num) {
        if(num == 1 || num == 0){
            return true;
        }
        int left = 1;
        int right = num / 2;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int val = num / mid;
            if(mid > val){
                right = mid - 1;
            }else if(mid < val) {
                left = mid + 1;
            }else{
                return num % mid == 0 ? true : false;
            }
        }
        return false;
    }

}
