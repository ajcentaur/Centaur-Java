package com.ajcentaur.leetcode;

import java.util.*;

/**
 * @version 1.0.0
 * @author: Centaur
 * @date: 2022/9/8 23:10
 * @description: 队列结构算法
 */
public class QueueTest {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> subRes = new ArrayList<>();
        subRes.clear();
//        queue.isEmpty();
//        queue.size();
//
//        HashSet<Character> hashSet = new HashSet<>();
//        hashSet.contains('a');

//        String a = "aaa";
//
//        maxVowels(a,3);
//        int[] nums = new int[]{2,2,1,1,1,2,2};
//        test(nums,0,nums.length - 1);
//        generateParenthesis(2);
        dfsSubsets(new int[]{1,2});

    }

    public static int maxVowels(String s, int k) {
        HashSet<Character> hashSet = new HashSet<Character>(Arrays.asList('a','e','i','o','u'));
        int count = 0;
        for(int i=0;i<k;i++){
            if(hashSet.contains(s.charAt(i))){
                count++;
            }
        }
        int res = count;
        for(int j = k; j < s.length(); j++){
            if(hashSet.contains(s.charAt(j-k))){
                count--;
            }
            if(hashSet.contains(s.charAt(j))){
                count++;
            }
            if(count > res){
                res = count;
            }
        }
        return res;
    }

    public static int test(int[] nums,int left,int right){
        if(left == right){
            return nums[left];
        }
        int mid = left + (right-left)/2;
        int leftVal = test(nums,left,mid);
        int rightVal = test(nums,mid+1,right);

        if(leftVal == rightVal){
            return leftVal;
        }
        int leftCount = 0;
        int rightCount = 0;
        for(int i =left;i <= right;i++){
            if(nums[i] == leftVal){
                leftCount++;
            }
            if (nums[i] == rightVal){
                rightCount++;
            }
        }
        return leftCount > rightCount ? leftVal:rightVal;
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtracking(n, result, 0, 0, "");
        return result;
    }

    private static void backtracking(int n, List<String> result, int left, int right, String str) {
//        if (right > left) {
//            return;
//        }
        if (left == n && right == n) {
            result.add(str);
            return;
        }

        if (left < n) {
            backtracking(n, result, left+1, right, str+"(");
            System.out.println("aaa");
        }

        if (right < left) {
            backtracking(n, result, left, right+1, str+")");
            System.out.println("bbb");
        }
    }


    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());

        for(int i = 1; i <= nums.length; i++){
            searchSub(res, nums, i, 0 , new ArrayList<Integer>());
        }
        return res;
    }

    private static void searchSub(List<List<Integer>> res,int[] nums, int length, int index, List<Integer> subList){
        if(length == subList.size()){
            res.add(subList);
            return;
        }
        for(int i = index; i < nums.length; i++){
            List<Integer> temp = new ArrayList<>(subList);
            temp.add(nums[i]);
            searchSub(res, nums, length, i + 1 , temp);
        }
    }

    public static List<List<Integer>> dfsSubsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums,res,0,new ArrayList<Integer>());
        return res;
    }

    private static void dfs(int[] nums,List<List<Integer>> res,int index,List<Integer> subList){
        res.add(new ArrayList<Integer>(subList));
        if(index == nums.length){
            return;
        }
        for(int i = index; i < nums.length; i++){
            subList.add(nums[i]);
            dfs(nums,res,i+1,subList);
            subList.remove(subList.size() - 1);
        }
    }
}
