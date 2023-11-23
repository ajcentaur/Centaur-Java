package com.ajcentaur.leetcode;

import java.util.*;

/**
 * @version 1.0.0
 * @author: Centaur
 * @date: 2022/9/9 11:44
 * @description: StackTest  栈结构
 */
public class StackTest {
    public static void main(String[] args) {

//        Stack<Character> stack = new Stack();
//        System.out.println(isValid("()"));
//        System.out.println(isValid("(([]{}"));
        int[] cnt = new int[]{4,1,2};
        int[] cnt2 = new int[]{4,1,2};
        System.out.println(nextGreaterElement(cnt,cnt2).toString());
    }

    public static boolean isValid(String s) {
        if(s.length() == 0){
            return false;
        }
        Stack<Character> stack = new Stack();
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char temp = stack.pop();
                if(temp == '('){
                    if(c != ')'){
                        return false;
                    }
                }else if(temp == '['){
                    if(c != ']'){
                        return false;
                    }
                }else if(temp == '{'){
                    if(c != '}'){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty()?true:false;
    }

    public static char findTheDifference(String s, String t) {
        int[] cnt = new int[26];
        for(int i=0;i<s.length();++i){
            int index = s.charAt(i) - 'a';
            cnt[index]++;
        }
        for(int i=0;i<t.length();++i){
            int index = s.charAt(i) - 'a';
            cnt[index]--;
            if(cnt[index] < 0){
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        // Stack<Integer> stack = new Stack();
        // for(int num : nums2){
        //     stack.push(num);
        // }
        // for(int i=0;i<nums1.length;i++){
        //     Stack<Integer> temp = new Stack();
        //     boolean isFound = false;
        //     int max = -1;
        //     while(stack.size() > 0 && !isFound){
        //         int top = stack.pop();
        //         if(top > nums1[i]){
        //             max = top;
        //         }
        //         if(top == nums1[i]){
        //             isFound = true;
        //         }
        //         temp.push(top);
        //     }
        //     res[i] = max;
        //     while(temp.size() > 0){
        //         stack.push(temp.pop());
        //     }
        // }
        Deque<Integer> stack = new ArrayDeque<Integer>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = nums2.length - 1;i >= 0; --i){
            int num = nums2[i];
            while(!stack.isEmpty() && num>stack.peek()){
                stack.pop();
            }
            map.put(num,stack.isEmpty()?-1:stack.peek());
            stack.push(num);
        }
        for(int i =0;i < nums1.length; ++i){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
