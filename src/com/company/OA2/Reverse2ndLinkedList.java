package com.company.OA2;

/**
 * Created by stephenbai on 2016-11-18.
 */
public class Reverse2ndLinkedList {
    String t = "lakdsjf";

    public Reverse2ndLinkedList(){
        ListNode head = new ListNode(0);
        ListNode current = head;

        for(int i = 1; i < 10; i++){
            current.next = new ListNode(i);
            current = current.next;
        }
        reverseList(head);
    }

    public ListNode reverseList(ListNode head) {
        if( (head==null) || (head.next == null) ) return head;
        ListNode offSet = new ListNode(0);
        offSet.next = head;

        ListNode fast = offSet;
        ListNode slow = offSet;
        // problem? how to take care of fast ptr?
        // 4 nodes, 4,3,7,8, then start@ index 2
        // 5 nodes, 4,3,7,8,9 then starts@ index 2
        // 2
        while( (fast!=null)&&(fast.next!=null)){
            // take of doublle next.next
                fast = fast.next.next;
                slow = slow.next;
        }

        // Remember NCPC!!!!!
        ListNode currNode = slow.next;
        ListNode prevNode = null;
        ListNode nextNode ;
        while(currNode!=null){
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        slow.next = prevNode;

        ListNode cur = head;
        while(cur!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }

        return head;
    }

     public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
         }
}
