package Amazon;
/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.


 For example, the following two linked lists:

 A:          a1 → a2
 ↘
 c1 → c2 → c3
 ↗
 B:     b1 → b2 → b3
 begin to intersect at node c1.

 */

import java.util.HashSet;


public class L160_IntersectionOfLList_E {
      class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
            }
      }

      // Idea:
    // 2 iterations:
    // first iteration: by the end -> switch to the head of the other common.data.types.ListNode
    // in the 2nd iteration: Note by the condition while (a!=b)
    // this will make sure that if no itersection, a will be null and b will be null at the same time
    // If Itersection, then a and b will meet at the same time!!!
    public ListNode getIntersectionNodeSolution(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while( a != b ) {
            a = (a == null) ? headB: a.next;
            b = (b == null) ? headA: b.next;
        }

        return a;

      }

//    public common.data.types.ListNode getIntersectionNode(common.data.types.ListNode headA, common.data.types.ListNode headB) {
//        common.data.types.ListNode a = headA;
//        common.data.types.ListNode b = headB;
//        HashSet <common.data.types.ListNode> hashSet = new HashSet<>();
//
//        while(a != null){
//            hashSet.add(a);
//            a = a.next;
//        }
//
//        while( b != null){
//            if (hashSet.contains(b)) {
//                return b;
//            }
//            b = b.next;
//        }
//        return null;
//    }
}
