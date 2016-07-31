package com.bruce.leetcode;

/**
 * Created by wuteng1 on 2016/7/5.
 */
public class AddTwoNumbers2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(1);
        n1.next.next = new ListNode(1);
        ListNode n2 = new ListNode(9);
        n2.next = new ListNode(9);
        n2.next.next = new ListNode(9);
        ListNode res = sol.addTwoNumbers(n1, n2);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }

    }
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }
    static class Solution{
        public ListNode addTwoNumbers(ListNode l1, ListNode l2){
            int num1, num2, carry = 0;
            ListNode header = new ListNode(-1);
            ListNode node = header;
            while(l1 != null && l2 != null){
                num1 = l1.val;
                num2 = l2.val;
                node.next = new ListNode((num1 + num2 + carry) % 10);
                carry = (num1 + num2 + carry) / 10;
                l1 = l1.next;
                l2 = l2.next;
                node = node.next;
            }
            if(l1 != null){
                node.next = l1;
                while(node.next != null){
                    int num = node.next.val;
                    node.next.val = (num + carry) % 10;
                    carry = (num + carry) / 10;
                    node = node.next;
                }
            }
            if(l2 != null){
                node.next = l2;
                while(node.next != null){
                    int num = node.next.val;
                    node.next.val = (num + carry) % 10;
                    carry = (num + carry) / 10;
                    node = node.next;
                }
            }
            if(carry == 1){
                node.next = new ListNode(1);
            }
            return header.next;

        }
    }
}
