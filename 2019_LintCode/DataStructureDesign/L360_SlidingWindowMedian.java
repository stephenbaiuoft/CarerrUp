package DataStructureDesign;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
*
* Given an array of n integer, and a moving window(size k),
* move the window at each iteration from the start of the array,
* find the median of the element inside the window at each moving.
* (If there are even numbers in the array, return the N/2-th number after sorting the element in the window. )
* */
public class L360_SlidingWindowMedian {
    PriorityQueue<Integer> minQ = new PriorityQueue<>(); // minQue to store maxValue
    PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder()); // maxQ to store minValue
    public List<Integer> medianSlidingWindow(int[] A, int k) {
        List<Integer> aL = new ArrayList<>();

        // we would put the median value under maxQ peek
        for (int i = 0; i < A.length; i++) {
            if (maxQ.isEmpty() || A[i] < maxQ.peek()) {
                maxQ.offer(A[i]);
            } else {
                minQ.offer(A[i]);
            }
            // we need to remove elements now
            if (i >= k) {
                if (A[i-k] > maxQ.peek()) {
                    minQ.remove(A[i-k]);
                } else {
                    maxQ.remove(A[i-k]);
                }
            }

            // balance the array before getting the median! important
            balance();
            if (i >= k-1) {// start getting the median
                aL.add(maxQ.peek());
            }

        }

        return aL;
    }

    private void balance() {
        while(minQ.size() > maxQ.size()) {
            maxQ.offer(minQ.poll());
        }

        // -1 >> put in maxQ
        while (minQ.size() < maxQ.size()-1) {
            minQ.offer(maxQ.poll());
        }
    }
}
