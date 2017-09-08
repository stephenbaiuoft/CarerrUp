package Amazon;


import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Idea: use a Heap to queue and deque
 */

public class L23_MergeKLists_H {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length== 0 ) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for(int i =0; i <lists.length; i++){
            if(lists[i] !=null ){
            queue.add(lists[i]);}
        }

        ListNode dummy = new ListNode(0);
        ListNode current=dummy;

        while (!queue.isEmpty()) {
            current.next = queue.poll();
            current = current.next;

            if(current.next != null){
                queue.add(current.next);
            }
        }

        return dummy.next;
    }
}
/**
 *
 public ListNode mergeKLists(ListNode[] lists ) {
 if (lists==null||lists.length==0) return null;

 PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
@Override
public int compare(ListNode o1,ListNode o2){
if (o1.val<o2.val)
return -1;
else if (o1.val==o2.val)
return 0;
else
return 1;
}
});

 ListNode dummy = new ListNode(0);
 ListNode tail=dummy;

 for (ListNode node:lists)
 if (node!=null)
 queue.add(node);

 while (!queue.isEmpty()){
 tail.next=queue.poll();
 tail=tail.next;

 if (tail.next!=null)
 queue.add(tail.next);
 }
 return dummy.next;
 }
 */
