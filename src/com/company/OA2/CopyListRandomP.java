package com.company.OA2;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by stephen on 1/11/17.
 */

// leetcode 138
//https://leetcode.com/problems/copy-list-with-random-pointer/


// Definition for singly-linked list with a random pointer.
// own Implementation, beats merely 7% lols
 class RandomListNode {
     int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  };



public class CopyListRandomP {
    public CopyListRandomP(){
        RandomListNode head = new RandomListNode( -1);
        head.random = null;

        head.next = new RandomListNode(-2);
        head.next.random = head;

    // My Naive Implmentation
        //RandomListNode copy = copyRandomList(head);
    // Smart Only 1 HashMap Solution
        RandomListNode copy = SolutionCopyRandomList(head);

    }

    public RandomListNode SolutionCopyRandomList( RandomListNode head){
        if(head == null ) return null;
        RandomListNode copyHead = new RandomListNode( head.label);
        RandomListNode first = head;
        RandomListNode second = copyHead;

        // map first to second,
        // note first time, second.random points to first value!
        HashMap map = new HashMap<RandomListNode, RandomListNode>();


        while ( first !=null ){
            if( first.next!=null){
                second.next = new RandomListNode(first.next.label);
            }
            // important to keep it out!!!
            second.random = first.random;

            map.put(first, second);

            first = first.next;
            second = second.next;
        }

        second = copyHead;
        while(second!=null){
            second.random =(RandomListNode) map.get(second.random);

            second = second.next;
        }

        return copyHead;

    }

    // do deep copy first? and then link the random afterwards
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode copyhead = new RandomListNode(0) ;
        RandomListNode iterator = copyhead;

        RandomListNode cur = head;
        // Also Reverse Order
        HashMap inputDic = new HashMap<RandomListNode, Integer>();

        HashMap copyDic = new HashMap<Integer, RandomListNode>();

        // 2 iterations, first to build the LinkedList
        int index = 0;
        while(cur!=null){
            // Create HashMap for addr to corresponding node; 0 for 1st element
            inputDic.put( cur, index );
            iterator.next = new RandomListNode( cur.label);
            // Create Map for copy dic
            copyDic.put( index, iterator.next);

            // Update
            cur = cur.next;
            iterator = iterator.next;
            index ++;
        }

        // re-iterate again
        cur = head;
        iterator = copyhead.next;
        while(cur!=null){
            if(cur.random!= null){
                int inputLinkIndex = (int) inputDic.get( cur.random );
                RandomListNode copyLinkCorrespondingAddr
                    = (RandomListNode) copyDic.get(inputLinkIndex);
                iterator.random = copyLinkCorrespondingAddr;
            }

            cur = cur.next;
            iterator = iterator.next;
        }

        return copyhead.next;
    }

}
