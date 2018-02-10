package Microsoft;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
/**
 * Given a sorted array, remove the duplicates in-place such that each element appear only once
 * and return the new length.

 Do not allocate extra space for another array, you must do this by modifying
 the input array in-place with O(1) extra memory.
 */

public class L26_removeDuplicates_E {
    public void test() {
        int[] nums = {1,2,3,3,4};
        removeDuplicates(nums);
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i == 0 || n > nums[i-1])
                nums[i++] = n;


        // well well well
        Stack<Object> stack1 = new Stack<>();
        stack1.push(1);
        stack1.push("askld;fjalskdfj");

        List<List<Integer>> l = new LinkedList<>();

        return i;
    }
}
