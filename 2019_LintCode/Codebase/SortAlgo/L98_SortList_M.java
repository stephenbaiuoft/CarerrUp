package Codebase.SortAlgo;

import common.data.types.ListNode;

public class L98_SortList_M {
    // get the middle point using 2 pointers
    private ListNode getMid(ListNode node) {
        ListNode slow = node;
        ListNode fast = node.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode merge(ListNode first, ListNode second) {
        ListNode dummy = new ListNode(2019);
        ListNode cur = dummy;
        while (first != null && second != null) {
            // advance either one of the nodes
            if (first.val < second.val) {
                cur.next = first;
                first = first.next;
            } else { // node.val >= node1.val
                cur.next = second;
                second = second.next;
            }
            cur = cur.next; // advance cur pointer
        }

        if (first != null) {
            cur.next = first;
        } else {
            cur.next = second; // link to the remaining
        }

        return dummy.next;
    }

    public ListNode sortList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode mid = getMid(node);

        ListNode secondHalf = sortList(mid.next);
        mid.next = null;
        ListNode first = sortList(node);

        return merge(first, secondHalf);
    }
}
