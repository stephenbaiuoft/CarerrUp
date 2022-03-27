package linkedlist;

public class L234_PalindromeLinkedList_E {
  public class ListNode {
      int val;
      ListNode next;

      ListNode() {
      }

      ListNode(int val) {
          this.val = val;
      }

      ListNode(int val, ListNode next) {
          this.val = val;
          this.next = next;
      }
  }

      public boolean isPalindrome(ListNode head) {
          // get mid node
          // from mid node, reverse the list
          // do comparison

          ListNode slow = head, fast = head;
          while (fast!= null && fast.next != null) {
              // advance the pointers
              slow = slow.next;
              fast = fast.next.next;
          }

          ListNode rhead = reverse(slow);
          while (rhead != null ) {
              if (head.val != rhead.val) {
                  return false;
              }
              head = head.next;
              rhead = rhead.next;

          }

          return true;

      }

      // reverse and return the head of reversed node
      public ListNode reverse(ListNode head) {
          // Always use prev!!!
          ListNode prev = null;

          while (head != null) {
              ListNode next = head.next;
              head.next = prev;
              prev = head;
              head = next;
          }

          return prev;
      }
}
