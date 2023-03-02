package com.ajcentaur.leetcode.linkedlist;

public class ListNodeDemo {
    public static void main(String[] args) {
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        ListNode n0 = new ListNode(12, n1);

        ListNode l2 = new ListNode(6, n1);
        ListNode l1 = new ListNode(9, l2);
//        System.out.println(swapPairs(n1));
        System.out.println(getIntersectionNode(n0, l1));
    }

    /**
     * leetcode:203
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode cur = dummyNode;
        while(cur != null && cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }

    /**
     * leetcode:24
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        ListNode temp = null;
        String s = "sss";
        int[] ddd = new int[128];
        for (int z : ddd) {

        }
        while(cur.next != null && cur.next.next != null){
            temp = cur.next;
            cur.next = cur.next.next;
            temp.next = temp.next.next;
            cur.next.next = temp;
            cur = cur.next.next;
        }
        return dummy.next;
    }

    /**
     * leetcode 02.07
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeHeadA = 0;
        int sizeHeadB = 0;
        ListNode cur = headA;
        while(cur != null){
            sizeHeadA++;
            cur = cur.next;
        }
        cur = headB;
        while(cur != null){
            sizeHeadB++;
            cur = cur.next;
        }

        if(sizeHeadA > sizeHeadB){
            int n = sizeHeadA - sizeHeadB;
            while(n-- > 0){
                headA = headA.next;
            }
        }else{
            int n = sizeHeadB - sizeHeadA;
            while(n-- > 0){
                headB = headB.next;
            }
        }

        while(headA != headB & headA != null){
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

}
