package Microsoft;

import java.util.Stack;

/**
 *
 L445_addTwoNumbers_M p = new L445_addTwoNumbers_M();
 p.test();

 */

/**
 L445_addTwoNumbers_M p = new L445_addTwoNumbers_M();
 p.test();
 */

public class L445_addTwoNumbers_M {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public void test() {
        ListNode a = new ListNode(5);
        ListNode b = new ListNode(5);
        ListNode result = addTwoNumbers(a, b);


    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        // push to stack
        while(cur1 != null || cur2!= null){
            if(cur1 != null)
            {
                s1.push(cur1.val);
                cur1 = cur1.next;
            }
            if(cur2 != null) {
                s2.push(cur2.val);
                cur2 = cur2.next;
            }
        }

        ListNode node = new ListNode(0);
        int sum = 0;
        // add to node
        while(!s1.empty() || !s2.empty()) {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            // add to node val
            node.val = sum %10;
            // carry on to next significant bit
            sum = sum/10;
            ListNode head = new ListNode(0);
            head.next = node;
            // re-point node to head
            node = head;

        }

        if(sum > 0){
            node.val = sum;
        }

        // return the node now ===> next
        return node.val == 0? node.next : node;


    }
}
