package LeetcodeMedium;

import com.company.november.PriorityQueueOrder;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by stephen on 7/19/17.
 */
/*
*   Find the kth largest element in an unsorted array.
*   Note that it is the kth largest element in the sorted order, not the kth distinct element.

    For example,
    Given [3,2,1,5,6,4] and k = 2, return 5.

    Note:
    You may assume k is always valid, 1 ? k ? array's length.
* */
public class Leetcode215 {
    private PriorityQueue<Integer> minHeap;

    public int findKthLargest(int[] nums, int k) {
        if(nums == null) return 0;
        // Ascending order means the minimum is first element.
        minHeap = new PriorityQueue<>(k);

        for(int i=0; i <k; i++){
            minHeap.add(nums[i]);
        }
        for(int i=k; i < nums.length; i++){
            if(minHeap.peek() < nums[i]){
                minHeap.remove();
                minHeap.add(nums[i]);
            }
        }
        System.out.println("k largest is:" + minHeap.peek());
        return minHeap.peek();
    }

}
