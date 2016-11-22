package com.company.november;

/**
 * Created by stephenbai on 2016-11-11.
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        if (head == null || head.next == null) {
            return head;
        }

        // find the middle node
        ListNode fast = dummy;
        ListNode slow = dummy;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse the second half of linked list
        ListNode pre = null;
        ListNode temp;
        head = slow.next;
        while(head != null) {
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }

        slow.next = pre;
        return dummy.next;

    }
}


  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
