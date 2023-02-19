package com.ajcentaur.test;


import java.util.*;

/**
 * @version 1.0.0
 * @author: Centaur
 * @date: 2022/9/23 15:09
 * @description: JavaTest3
 */
public class JavaTest3 {
    public static void main(String[] args) {
//        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1}, 3));
//        System.out.println(minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
//        System.out.println(minWindow2("ADOBECODEBANC", "ABC"));
//        System.out.println(fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
//        System.out.println(longestPalindrome("aacabdkacaa"));
//        System.out.println(permuteUnique(new int[]{1,1,2}));
    }
    static int res = 0;
    public static int findTargetSumWays(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        dfs(res, nums, target, 0, 0);
        return res;
    }

    private static void dfs(int res, int[] nums, int target, int index, int sum){
        if(sum > target){
            return;
        }
        if(index > nums.length - 1){
            if(sum == target){
                res++;
            }
            return;
        }
        for(int i = index; i< nums.length; i++){
            dfs(res, nums, target, index + 1, sum + nums[i]);
            dfs(res, nums, target, index + 1, sum - nums[i]);
        }
    }

    public static String minWindow(String s, String t) {
        int[] tnums = new int[128];
        for(int i = 0; i < t.length(); i++){
            tnums[t.charAt(i)]++;
        }
        int[] snums = new int[128];
        int left = 0;
        int right = 0;
        int maxLength = s.length() + 1;
        String res = "";
        while(right < s.length()){
            snums[s.charAt(right)]++;
            while(tnums[s.charAt(right)] > 0 && snums[s.charAt(right)] > tnums[s.charAt(right)]){
                snums[s.charAt(left)]--;
                left++;
            }
            while(left < s.length() && tnums[s.charAt(left)] == 0){
                snums[s.charAt(left)]--;
                left++;
            }
            if(tnums[s.charAt(right)] > 0){
                int overNum = 0;
                for(int k = 0; k < t.length(); k++){
                    if(tnums[t.charAt(k)] == snums[t.charAt(k)]){
                        overNum++;
                    }
                }
                if(overNum == t.length() && maxLength > right - left + 1){
                    res = s.substring(left, right + 1);
                    maxLength = res.length();
                }
            }
            right++;
        }
        return res;
    }

    public static String minWindow2(String s, String t) {

        int[] res = new int[]{};
        res[0] = 5;
        Set<Integer> set = new HashSet<>();


        int[] tnums = new int[128];
        for(char c : t.toCharArray()){
            tnums[c]++;
        }
        int from = 0;
        int total = t.length();
        int min = s.length() + 1;
        for(int i = 0, j = 0; i < s.length(); i++){
            if(tnums[s.charAt(i)] > 0){
                total--;
            }
            tnums[s.charAt(i)]--;
            while(total == 0){
                if(i - j + 1 < min){
                    min = i - j + 1;
                    from = j;
                }
                //移动 j 指针
                tnums[s.charAt(j)]++;
                if(tnums[s.charAt(j)] > 0){
                    total++;
                }
                j++;
            }
        }
        return min == s.length() + 1 ? "" : s.substring(from, from + min);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length - 3; i++){
//            if(target < 0 && nums[0] >= 0){
//                break;
//            }
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for(int j = i + 1; j < nums.length - 2; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while(left < right){
                    if(nums[i] + nums[j] + nums[left] + nums[right] > target){
                        right--;
                    }else if(nums[i] + nums[j] + nums[left] + nums[right] < target){
                        left++;
                    }else{
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left < right && nums[right] == nums[--right]);
                        while(left < right && nums[left] == nums[++left]);
                    }
                }
            }
        }
        return res;
    }

    static int left = 0;
    static int maxLen = 0;

    public static String longestPalindrome(String s) {
        StringBuilder sub = new StringBuilder();
        sub.deleteCharAt(sub.length() - 1);
        if(s.length() == 1){
            return s;
        }
        for(int i = 0; i < s.length(); i++){
            //奇数长度的字符串以i为中心点扩散
            find(i, i, s);
            //偶数长度的字符串以i和i+1为中心点扩散
            find(i, i + 1, s);
        }
        return s.substring(left, left + maxLen);
    }

    private static void find(int i, int j, String s){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            if(j - i + 1 > maxLen){
                left = i;
                maxLen = j - i + 1;
            }
            i--;
            j++;
        }
    }


    static List<List<Integer>> res1 = new ArrayList<>();
    static List<Integer> sub = new ArrayList<>();
    static int[] used = new int[21];

    public static List<List<Integer>> permuteUnique(int[] nums) {
        int[][] dp = new int[5][5];
        dp[0][0] = 1;
        if(dp[0][0] == 1){
            System.out.println("XXXX");
        }
        for(int i = 0; i < nums.length; i++){
            used[nums[i] + 10]++;
        }
        backfunc(nums);
        return res1;
    }

    private static void backfunc(int[] nums){
        if(sub.size() == nums.length){
            res1.add(new ArrayList<>(sub));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[nums[i] + 10] == 0){
                continue;
            }
            sub.add(nums[i]);
            used[nums[i] + 10]--;
            backfunc(nums);
            used[nums[i] + 10]++;
            sub.remove(sub.size() - 1);
        }
    }
}
