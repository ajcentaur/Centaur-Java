package com.ajcentaur.leetcode;

import java.util.LinkedList;

/**
 * @version 1.0.0
 * @author: Centaur
 * @date: 2022/9/8 16:51
 * @description: 链表结构
 */
public class LinkedListTest {
    public static void main(String[] args) {
//        LinkedList<Integer> list = new LinkedList<>();
//        //新增元素 时间复杂度O(1)
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        System.out.println(list.toString());
//
//        //指定索引新增元素 时间复杂度O(n)
//        list.add(2,99);
//        System.out.println(list.toString());
//
//        //访问指定索引元素 O(n)
//        int element = list.get(2);
//        System.out.println(element);
//
//        //搜索元素 O(n)
//        int index = list.indexOf(99);
//        System.out.println(index);
//
//        //指定索引修改元素  O(n) 先搜索O(n)再修改O(1)
//        list.set(1,88);
//        System.out.println(list.toString());
//
//        //指定索引删除元素 O(n)
//        list.remove(3);
//        System.out.println(list.toString());
//
//        //链表长度 O(1)
//        int size = list.size();
//        System.out.println(size);
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0,head);
        ListNode prev = dummy;
        while(head != null){
            if(head.val == val){
                prev.next = head.next;
            }else{
                prev = head;
            }
            head = head.next;
        }
        return dummy.next;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
