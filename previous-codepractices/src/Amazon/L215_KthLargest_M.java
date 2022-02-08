package Amazon;

import com.company.november.PriorityQueueOrder;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest
 * element in the sorted order, not the kth distinct element.

 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ array's length.
 */


public class L215_KthLargest_M {
    private PriorityQueue<Integer> pq;
    private int capacity;

    public int findKthLargest(int[] nums, int k) {
        // default pq is increasing, meaning smallest at the head
        pq = new PriorityQueue<>(k);
        capacity = k;

        for (int val: nums){
            insert(val);
        }

        return pq.peek();
    }

    private void insert(int val){
        if( pq.size() < capacity){
            pq.offer(val);
        }
        else if( pq.peek() < val ) {
                // remove the head and add the val
                pq.poll();
                pq.offer(val);

        }
    }

}
