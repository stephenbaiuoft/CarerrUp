package recursion_subproblem;

import common.data.types.ListNode;
import common.helpermethods.Helper;

public class L25_ReverseNodesInKGroup_H {
    public L25_ReverseNodesInKGroup_H(){
        initTest();
    }

    private void initTest() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode l = reverseKGroup(head, 3);
        ListNode c = l;
        System.out.println("printing array");
        while(c!=null) {
            System.out.print(c.val + "->");
        }
        System.out.print("|\n");
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }

        ListNode cur = head;
        for(int i= 0; i< k-1; i++){
            cur = cur.next; //advance cur first! important
            if(cur == null){
                return head;
            }
        }

        if(cur.next !=null){
            cur.next = reverseKGroup(cur.next, k);
        }

        ListNode ans = reverseHelper(head, cur);
        return ans;


    }

    public ListNode reverseHelper(ListNode head, ListNode tail){
        ListNode current = head;
        ListNode next = null;
        while(current != tail){
            next = current.next;
            current.next = tail.next; // use tail.next to store array that current needs to point to
            tail.next = current; //
            current = next;
        }

        return tail;
    }
}
