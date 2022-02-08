package SortAlgo;

import common.data.types.ListNode;

import java.util.List;
import java.util.PriorityQueue;

public class L104_MergeKSortedList_M {
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        PriorityQueue<ListNode> pq = new PriorityQueue<>((l1,l2)->(l1.val - l2.val)); // minQueue
        if (lists == null || lists.size() < 2) return lists.get(0);
        ListNode dummyHead = new ListNode(2019);
        ListNode cur = dummyHead;
        ListNode tmp = null;

        // put each lists head to pq
        for (int i = 0; i < lists.size();i++) {
            if (lists.get(i) != null) {
                pq.offer(lists.get(i));
            }
        }

        while(!pq.isEmpty()) {
            cur.next = pq.poll(); // get the first out the list
            cur = cur.next; //update cur
            if (cur.next != null) {
                pq.offer(cur.next);
            }
        }

        return dummyHead.next;
    }
}
