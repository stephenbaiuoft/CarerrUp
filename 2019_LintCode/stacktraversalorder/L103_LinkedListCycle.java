package stacktraversalorder;

import common.data.types.ListNode;

public class L103_LinkedListCycle {
    public ListNode detectCycle(ListNode head) {
        // write your code here
        if (head == null || head.next == null) return null;

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null) { // no cycle as fast reached null
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        while (head != slow.next) {
            head = head.next;
            slow = slow.next;
        }

        return head;
    }
}
