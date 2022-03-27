package queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class L215_KLargest_M {
    // 思路
    // minQueue up to K
    // then we only pop() and add elements greater than peek()
    // --> This will ensure K largest is always peek
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            // minQueue
            PriorityQueue<Integer> q = new PriorityQueue<>();
            for (int num: nums) {
                if (q.size() < k) {
                    q.offer(num);
                }
                else if (q.peek() < num) {
                    q.poll();
                    q.offer(num);
                }
            }

            return q.peek();
        }
    }
}
