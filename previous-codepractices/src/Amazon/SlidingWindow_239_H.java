package Amazon;

import java.util.ArrayDeque;
import java.util.Deque;
// GOOD !!! 90.7%!!!!

public class SlidingWindow_239_H {
    public Deque<Integer> deque = new ArrayDeque<>();

    // create decending order
    private void addToQueue(int num) {
        while (!deque.isEmpty() && deque.peekLast() < num) {
            deque.removeLast();
        }
        deque.addLast(num);
    }

    // remove from the deque
    private void removeFromQueue(int num) {
        // it is this num being removed
        if (deque.peekFirst() != null && deque.peekFirst() == num) {
            deque.removeFirst();
        }
    }


// think
// k = 2, num.length = 3
// [6,3,8]
//

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0 || nums.length == 0 || k > nums.length) return new int[0];
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < k - 1; i++) {
            addToQueue(nums[i]);
        }

        for (int i = k - 1; i < nums.length; i ++  ) {
            addToQueue(nums[i]);
            result[i- k + 1] = deque.peekFirst();
            removeFromQueue(nums[i - k + 1]);
        }

        return result;
    }
}
