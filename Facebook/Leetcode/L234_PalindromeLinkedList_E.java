package Leetcode;

public class L234_PalindromeLinkedList_E {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while( fast !=null && fast.next!=null ) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode cur = slow;
        if (fast != null) {
            cur = slow.next;
        }

        ListNode p = null;
        ListNode n = null;
        // reverse linked list
        while(cur!=null) {
            n = cur.next;
            cur.next = p;
            p = cur;
            cur = n;
        }
        while(p !=null) {
            if (p.val != head.val) {
                return false;
            }
            p = p.next;
            head = head.next;
        }

        return true;

    }
}
