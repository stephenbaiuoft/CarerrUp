package ByMonth.august.March;

public class L147_InsertionSortList_M {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;

        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        // IMPORTANT!!! --> not to set dummy.next = head !! in this case
        ListNode prev = dummy;
        ListNode next = null;
        // insertion sort
        while(cur!=null) {
            // set apart the region
            next = cur.next;
            cur.next = null;

            // insertion search for the node
            while(prev.next !=null && prev.next.val < cur.val) {
                prev = prev.next;
            }

            // insert the node
            cur.next = prev.next;
            prev.next = cur;
            // reset prev
            prev = dummy;

            cur = next;

        }

        return dummy.next;
    }
}
