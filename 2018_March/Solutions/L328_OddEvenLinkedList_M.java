package Solutions;

public class L328_OddEvenLinkedList_M {

    public ListNode oddEvenList(ListNode head) {
        //
        if(head == null || head.next == null) return head;

        ListNode evenHead = head.next;
        ListNode even = evenHead;
        ListNode odd = head;
        while(even != null && even.next !=null) {
            odd.next = even.next;
            even.next = odd.next.next;

            // advance odd and even
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        // return the oddHead
        return head;
    }
}
