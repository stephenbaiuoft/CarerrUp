package May;

public class L24_SwapNodesInPairs_M {

    public ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode first = head;
        ListNode second = head.next;

        // point to the next pair
        ListNode nextPair = second.next;
        second.next = first;
        first.next = swapPairs(nextPair);

        return second;

    }
}
