package Amazon.OA2Review;

public class ReverseLinkedList {

    public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
     }

     public void test() {
        ListNode head1 = getList();
        ListNode head2 = getList();

        showList(head1);
        ListNode r1 = reverseList(head1);
        ListNode r2 = reverseListSol(head2);

        showList(r1);
        System.out.println("\n\n");
        showList(r2);

     }

     public ListNode getList() {
         ListNode head = new ListNode(1);
         ListNode first = new ListNode(2);
         ListNode second = new ListNode(3);
         ListNode third = new ListNode(4);
         ListNode fourth = new ListNode(5);
         ListNode fifth = new ListNode(6);

         head.next = first;
         first.next = second;
         second.next = third;
         third.next = fourth;
         fourth.next = fifth;

         return head;
     }

     private void showList(ListNode node) {
        ListNode tmp = node;
        while(tmp != null) {
            System.out.print( tmp.val + "->" );
            tmp = tmp.next;
        }
        System.out.println("-|\n End");
     }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;
        while( fast.next != null && fast.next.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }


        ListNode previous = null;
        ListNode cur = slow.next;
        ListNode next = null;

        while( cur != null ) {
            next = cur.next;
            cur.next = previous;
            previous = cur;
            cur = next;
        }

        slow.next = previous;
        return head;

    }

    public ListNode reverseListSol(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = slow.next;
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = null, cur = slow.next;
        while(cur != null)
        {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        slow.next = pre;
        return head;
    }

}

