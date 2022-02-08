package Amazon.OA2Review;
import java.util.*;

public class TemplateHolder {
    public TemplateHolder(){

    }

    private Deque<Integer> deque = new ArrayDeque<>();

    private void insert(int num){
        while(deque.peekFirst() != null && deque.peekLast() < num) {
            deque.removeLast();
        }
        deque.add(num);
    }

    private void remove(int num){
        if(deque.peekFirst()!= null && deque.peekFirst() == num) {
            deque.removeFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k > nums.length || nums.length == 0) return nums;

        int[] result = new int[nums.length - k + 1];

        for(int i = 0; i < k - 1; i ++) {
            insert(nums[i]);
        }

        for(int last = k; last < nums.length ; last ++) {
            insert(nums[last]);
            result[last-k+1] = deque.peekFirst();
            remove(nums[last-k + 1]);
        }

        return result;
    }
}
