package com.bruce.leetcode;

/**
 * Created by 腾 on 2016/5/23.
 */
public class ReorderList143 {
     static class Solution{
        public void reorderList(ListNode head){
            if(head == null || head.next == null)
                return;
            ListNode fastp = head, slowp = head;
            while(fastp.next != null && fastp.next.next != null){
                fastp = fastp.next.next;
                slowp = slowp.next;
            }
            ListNode head2 = slowp.next;
            slowp.next = null;
            head2 = reverseList(head2);
            fastp = head;
            // 1   3   5 - 7
            // | / | / |
            // 2   4   6
            while(head2 != null) {
                ListNode temphead2 = head2.next;
                head2.next = fastp.next;
                fastp.next = head2;
                fastp = head2.next;
                head2 = temphead2;
            }
        }
        public  ListNode reverseList(ListNode node){
            if(node == null || node.next == null)
                return node;
            ListNode pre = node, nxt = node.next;
            while(nxt != null){
                ListNode temp = nxt.next;
                nxt.next = pre;
                pre = nxt;
                nxt = temp;
            }
            node.next = null;
            return pre;
        }

    }
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x;}
    }

    public static void main(String[] args) {
        ListNode n1= new ListNode(1);
        ListNode n2= new ListNode(2);
        ListNode n3= new ListNode(3);
        ListNode n4= new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        /*Solution sol = new Solution();
        sol.reorderList(n1);*/
        ListNode temp = n1.next;
        System.out.println(temp.val);
        n1.next = null;
        //引用删除了，但是对象还在
        System.out.println(temp.val);
    }
}
