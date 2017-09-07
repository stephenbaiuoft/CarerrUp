package Amazon;

public class L206_ReverseLL_E {

      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
          if ( head == null ){
              return head;
          } else {
              ListNode previous = null, current = null, next = null;
              current = head;

              while (current!=null){
                  next = current.next;
                  current.next = previous;
                  previous = current;
                  current = next;
              }

              return previous;
          }
    }
}
