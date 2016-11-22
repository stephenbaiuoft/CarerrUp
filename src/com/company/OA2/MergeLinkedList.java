package com.company.OA2;

/**
 * Created by stephenbai on 2016-11-18.
 */


public class MergeLinkedList {
    public MergeLinkedList(){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(5);
        mergeTwoLists(l1,l2);
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //if(l1==null && l2==null ) return null;
        if(l1 ==null) return l2;
        if(l2 ==null) return l1;

        ListNode head ;
        ListNode current ;

        if( l1.val <= l2.val){
            head = l1;
            l1 = l1.next;
        }else{
            head = l2;
            l2 = l2.next;
        }
        current = head;

        while( (l1!=null) && (l2!=null) ){
            if ( (l1.val <= l2.val) ){
                current.next = l1;
                current = current.next;
                l1 = l1.next;
            }else {
                current.next = l2;
                current = current.next;
                l2 = l2.next;
            }

        }
        if (l1!=null){
            current.next = l1;

        }
        if (l2!=null){
            current.next = l2;
        }
        ListNode tmp = head;
        while(tmp !=null){
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
        return head;

    }
}
