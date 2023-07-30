package com.ajcentaur.leetcode.arraygroup;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口
 */
public class SlidingWindow {
    public static void main(String[] args) {
//        System.out.println(totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
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

    /**
     * leetcode:904
     * @param fruits
     * @return
     */
    public static int totalFruit(int[] fruits) {
        Map<Integer,Integer> map = new HashMap<>();
        int i = 0;
        int res = 0;
        for(int j = 0; j < fruits.length; j++){
            if(map.containsKey(fruits[j])){
                map.put(fruits[j], map.get(fruits[j]) + 1);
            }else{
                map.put(fruits[j], 1);
            }
            while(map.size() > 2){
                map.put(fruits[i], map.get(fruits[i]) - 1);
                if(map.get(fruits[i]) <= 0){
                    map.remove(fruits[i]);
                }
                i++;
            }
            res = Math.max(j - i + 1, res);
        }
        return res;
    }

    /**
     * leetcode:76
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        int[] tnums = new int[128];
        int from = 0;
        int total = t.length();
        int minLength = s.length() + 1;
        for(int i = 0; i < t.length(); i++){
            tnums[t.charAt(i)]++;
        }
        for(int i = 0,j = 0; i < s.length(); i++){
            if(tnums[s.charAt(i)] > 0){
                total--;
            }
            tnums[s.charAt(i)]--;
            while(total == 0){
                if(minLength > i - j + 1){
                    from = j;
                    minLength = i - j + 1;
                }
                tnums[s.charAt(j)]++;
                if(tnums[s.charAt(j)] > 0){
                    total++;
                }
                j++;
            }
        }
        return minLength > s.length() ? "" : s.substring(from, from + minLength);
    }
}
