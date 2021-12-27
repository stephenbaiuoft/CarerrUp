package ByMonth.august.July;
import java.util.*;

public class L239_SlidingWindowMax_H {
    public L239_SlidingWindowMax_H() {
        int[] input = new int[] {
                1,3,-1,-3,5,3,6,7
        };
        int k = 3;

        int[] rez = maxSlidingWindow(input, k );

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k == 1 ) return nums;

        int[] rez = new int[nums.length - k + 1 ];
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < k - 1; i++) {
            add(q, nums[i]);
        }

        for(int i = k; i < nums.length; i++) {
            // evaluate the max now
            rez[i-k] = q.peekFirst();
            // remove the last element
            remove(q, nums[i-k]);
            add(q, nums[i]);
        }

        rez[nums.length - k] = q.peekLast();
        return rez;
    }

    private void remove(Deque<Integer> q, int val) {
        if (q.peekLast() == val) {
            q.remove();
        }
    }

    private void add(Deque<Integer> q, int val) {
        while (!q.isEmpty() && q.peekFirst() <  val) {
            // remove until val is the largest on the end
            q.remove();
        }

        q.offer(val);
    }

}
