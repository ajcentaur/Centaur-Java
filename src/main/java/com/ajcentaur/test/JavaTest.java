package com.ajcentaur.test;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

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
//        ArrayList<Integer> a = new ArrayList<>(15);
//        System.out.println(a.size());
//        a.add(1);
//        System.out.println(a.size());
//        Collections.synchronizedList(a);
//        a.add(2);
//        System.out.println(a.size());
//        a.add(5,1);
//        a.set(5,1);
        double lon = 120.254046;
        double lat = 30.237788;
        Double[] a0 = new Double[]{120.251422,30.238501};
        Double[] a1 = new Double[]{120.253217,30.234206};
        Double[] a2 = new Double[]{120.250348,30.225197};
        Double[] a3 = new Double[]{120.193022,30.256562};
        List<Double[]> list = new ArrayList<>();
        list.add(a3);
        list.add(a0);
        list.add(a1);
        list.add(a2);
        sortByDistance(lon,lat,list);
        for (Double[] doub : list) {
            System.out.println("经度：" + doub[0] + "，纬度：" + doub[1]);
        }
    }

    public static void sortByDistance(double lon1, double lat1, List<Double[]> list){
        list.sort((o1, o2) -> {
            double lon2 = o1[0];
            double lat2 = o1[1];
            double lon3 = o2[0];
            double lat3 = o2[1];
            double dis1 = getDistance(lon1, lat1, lon2, lat2);
            double dis2 = getDistance(lon1, lat1, lon3, lat3);
            return Double.compare(dis1,dis2);
        });
    }

    public static double getDistance(double lon1,double lat1,double lon2,double lat2){
        double x1 = lon1 * Math.PI/180;
        double x2 = lon2 * Math.PI/180;
        double y1 = lat1 * Math.PI/180;
        double y2 = lat2 * Math.PI/180;
        double R = 6371;
        double d = Math.acos(Math.sin(y1) * Math.sin(y2) + Math.cos(y1) * Math.cos(y2) * Math.cos(x2 - x1)) * R;
        return d;
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
