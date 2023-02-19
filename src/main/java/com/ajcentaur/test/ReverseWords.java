package com.ajcentaur.test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @version 1.0.0
 * @author: Centaur
 * @date: 2022/9/28 23:28
 * @description: ReverseWords
 */
public class ReverseWords {
    public static void main(String[] args) {
//        System.out.println(reverseWords("  hello world  "));
        System.out.println(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3));
    }

    public static String reverseWords(String s) {
        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder str = new StringBuilder();


        char[] ch = s.toCharArray();
        //将字符串整体反转
        reverse(ch, 0, ch.length - 1);
        int k = 0;
        for(int i = 0; i < ch.length; i++){
            if(ch[i] == ' '){
                continue;
            }
            int tempcur = i;
            while(i < ch.length && ch[i] != ' '){
                i++;
            }
            for(int j = tempcur; j < i; j++){
                if(j == tempcur){
                    //反转空格前一段字符
                    reverse(ch, j, i - 1);
                }
                //移除空格操作
                ch[k++] = ch[j];
                if(j == i - 1){
                    if(k < ch.length){
                        ch[k++] = ' ';
                    }
                }
            }
        }
        if(k == 0){
            return "";
        }else{
            return new String(ch, 0, (k == ch.length) && (ch[k - 1] != ' ') ? k : k - 1);
        }
    }

    private static void reverse(char[] ch, int i, int j){
        while(i < j){
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            // 根据题意，i为nums下标，是要在[i - k + 1, i] 中选到最大值，只需要保证两点
            // 1.队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
            while(!deque.isEmpty() && deque.peek() < i - k + 1){
                deque.poll();
            }
            // 2.既然是单调，就要保证每次放进去的数字要比末尾的都大，否则也弹出
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            // 因为单调，当i增长到符合第一个k范围的时候，每滑动一步都将队列头节点放入结果就行了
            if(i >= k - 1){
                res[idx++] = nums[deque.peek()];
            }
        }
        return res;
    }
}
