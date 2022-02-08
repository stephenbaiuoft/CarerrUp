package Leetcode;

public class L143_M {
    public L143_M() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        reorderList(head);

        printList(head);
    }

    public void reorderList(ListNode head) {
        if (head ==null) return;
        ListNode slow = head, fast = head, tail = null;

        // get list tail
        while (fast != null && fast.next != null) {
            if (fast.next.next == null) {
                tail = fast.next;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        tail = reverse (null, slow);

        ListNode cStart = head, cEnd = tail, nS = null, nE = null;
        while( cEnd != slow ) {
            nS = cStart.next;
            nE = cEnd.next;

            cStart.next = cEnd;
            cEnd.next = nS;

            // update cStart and cEnd indices
            cStart = nS;
            cEnd = nE;
        }

    }

    private void printList(ListNode node) {
        while(node!=null) {
            System.out.print(node.val + "->");
        }
    }

    private ListNode reverse(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }

        ListNode n = cur.next;
        cur.next = prev;

        return reverse(cur, n);
    }
}
