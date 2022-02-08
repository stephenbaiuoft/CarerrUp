package ByMonth.august.March;

public class L2_AddTwoNums_M {
    public L2_AddTwoNums_M() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode t = addTwoNumbers(l1,l2);;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = helper(l1, l2, 0);
        return head;
    }

    public ListNode helper(ListNode l1, ListNode l2, int carry) {
        int sum = 0;
        int nCarry = 0;
        int val = 0;
        ListNode a = null;
        ListNode b = null;

        if(l1 == null && l2 == null){
            if (carry == 0) return null;
            else {
                return new ListNode(carry);
            }
        }
        else if(l1 !=null && l2!=null){
            sum = l1.val + carry + l2.val;
            a = l1.next;
            b = l2.next;
        }
        else if(l1 !=null ){
            sum = l1.val + carry;
            a = l1.next;
            b = null;
        } else {
            sum = l2.val + carry;
            a = null;
            b = l2.next;
        }

        nCarry = sum / 10;
        val = sum %10;
        ListNode node = new ListNode(val);

        node.next = helper(a, b, nCarry);
        return node;
    }
}
