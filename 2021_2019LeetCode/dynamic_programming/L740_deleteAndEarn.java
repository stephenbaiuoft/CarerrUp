package dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class L740_deleteAndEarn {
    /**
     * You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:
     *
     * Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
     * Return the maximum number of points you can earn by applying the above operation some number of times.
     */

    public L740_deleteAndEarn() {
        int[] nums = {3, 4, 2};
        deleteAndEarnArry(nums);
    }

    public int deleteAndEarn(int[] nums) {

        int count[] = new int[10001];
        for (int x: nums) count[x]++;
        int avoid = 0, using = 0, prev = -1;
        int curMax = 0;

        for (int k = 1; k <= 10000; k++) if (count[k] > 0) {
            curMax = Math.max(avoid, using);
            // k isn't close to prev
            if (k - 1 != prev) {
                // update the values here
                using = k * count[k] + curMax;
                avoid = curMax;
            } else { // k is close to prev
                using = k * count[k] + avoid;
                avoid = curMax;
            }
            // Always update the prev
            prev = k;
        }

        return Math.max(avoid, using);
    }

    public int deleteAndEarnArry(int[] nums) {

        int count[] = new int[10001];
        for (int x: nums) count[x]++;
        int maxRob[] = new int[10001];

        // 1 <= h <= 10000,
        // h[0] = 0
        // default values for maxRob[1]
        maxRob[1] = count[1];
        for (int h = 2; h < 10001; h++) {
            maxRob[h] = Math.max(
                    maxRob[h-1],
                    maxRob[h-2] + h * count[h]
            );
        }

        // return the max you'd get for 10000
        return maxRob[10000];

    }
}
