package Solutions;

public class L19_RemoveNthNode_M {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(2018);
        dummy.next = head;
        ListNode offSet = dummy;
        ListNode slow = dummy;
        while(offSet!=null && offSet.next !=null) {
            if(n < 1) {
                // advance slow now
                slow = slow.next;
            } else {
                n--;
            }
            offSet = offSet.next;
        }
        // dummy -> 0 -> 1 -> 2  (n=1)
        if(slow.next!=null) {
            // delete that particular node
            slow.next = slow.next.next;
        }

        return dummy.next;

    }
}
