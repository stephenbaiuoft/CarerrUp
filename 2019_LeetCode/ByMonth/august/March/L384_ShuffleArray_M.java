package ByMonth.august.March;

import java.util.Arrays;
import java.util.Random;

public class L384_ShuffleArray_M {
    private int[] original = null;
    private int[] cur = null;
    private Random rand = null;
    public L384_ShuffleArray_M(int[] nums) {
        // save to original
        original = Arrays.copyOf(nums, nums.length);
        cur = nums;
        rand = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i = 0; i < cur.length-1; i++) {
            // from i to n-1 index (note n is excluded);
            int r = rand.nextInt(cur.length);
            // swap i & r
            swap(cur, i, r);
        }

        return cur;
    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
