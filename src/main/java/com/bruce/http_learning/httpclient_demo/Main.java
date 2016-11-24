package com.bruce.http_learning.httpclient_demo;

import org.junit.Test;

/**
 * Created by wuteng1 on 2016/10/11.
 */
public class Main {
    public static void main(String[] args) {
//        for(int i = 115; i <= 132; i++){
//            System.out.print("172.22.184." + i + ",");
//        }

    }

    @Test
    public void testReverseList(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode node = reverseList(n1);
        while(node != null){
            System.out.print(node);
            node = node.next;
        }

    }
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode last = head, cur = head.next;
        while(cur != null){
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return pre.next;
    }

}
