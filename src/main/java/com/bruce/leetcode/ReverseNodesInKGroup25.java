package com.bruce.leetcode;

/**
 * Created by wuteng1 on 2016/7/29.
 */
public class ReverseNodesInKGroup25 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k){
        if(head == null || k == 1)return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        int i = 0;
        while(head != null){
            i++;
            if(i % k == 0){
                pre = reverseList(pre, head.next);
                //head is changing to the first node
                head = pre.next;
            }
            else head = head.next;
        }
        return dummy.next;
    }
    //reverse the list node between head and next exclusively
    private ListNode reverseList(ListNode pre, ListNode next){
        ListNode last = pre.next;
        ListNode cur = last.next;
        while(cur != next){
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }

    private ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode last = pre.next;
        ListNode cur = last.next;
        //pre --> last --> cur --> cur2
        //pre --> cur --> last --> cur2
        //pre --> cur2 -- >cur --> last
        while(cur != null){
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return dummy.next;
    }
}
