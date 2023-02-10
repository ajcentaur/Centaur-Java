package com.ajcentaur.leetcode.linkedlist;

/**
 * leetcode:707
 */
public class DesignLinkedList {
    int size;
    ListNode head;

    public DesignLinkedList() {
        this.size = 0;
        this.head = new ListNode(0);
    }

    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        ListNode cur = head;
        while(index-- >= 0){
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        this.addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        this.addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }
        index = index < 0 ? 0 : index;
        ListNode cur = head;
        while(index-- > 0){
            cur = cur.next;
        }
        ListNode addNode = new ListNode(val);
        ListNode temp = cur.next;
        cur.next = addNode;
        addNode.next = temp;
        size++;
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size){
            return;
        }
        ListNode cur = head;
        while(index-- > 0){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }
}
