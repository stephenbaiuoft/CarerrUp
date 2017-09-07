package Amazon;

import java.util.HashSet;
import java.util.List;

// idea use a hashSet to check for repetition?
public class L141_LinkedListCycle_E {
    class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }

    public boolean hasCycleSolution(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode fast = dummy, slow = dummy;
        dummy.next = head;
        
        // let fast go twice while slow advance one at a time: ==> cycle means at some point they will meet
        while(fast!=null && fast.next!=null) {
           fast = fast.next.next;
           slow = slow.next;
           if(fast == slow){
               return true;
           }
        }
        return false;
    }

        // requires extra-space
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();

        ListNode current = head;
        while(current!=null){
            if (hashSet.contains(current)){
                return true;
            }
            hashSet.add(current);
            current = current.next;
        }
        return false;
    }
}
