package Leetcode;

public class ReverseList {

    public ReverseList() {

    }

    public ListNode reverse(ListNode prev, ListNode cur) {
        if(cur == null ) return null;
        // cur is the last node
        else if (cur.next == null) {
            cur.next = prev;
            return cur;
        }

        ListNode cNext = cur.next;
        cur.next = prev;

        return reverse(cur, cNext);
    }

    public void printList(ListNode node) {
        while(node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
    }

}
