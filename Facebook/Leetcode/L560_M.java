package Leetcode;

import java.util.HashMap;

public class L560_M {
    public int subarraySum(int[] nums, int k) {
    /*
        k = sum[i, j] = sum[0, j ] - sum[0, i-1];
    */
        if (nums == null || nums.length < 1) return 0;
        // to store preSum and # of occurences
        HashMap<Integer, Integer> preSum = new HashMap<>();
        int sum = 0;
        int count = 0;
        // 0 and 1 of occurence in case of 1array, equals to k,
        // and then this woudl be 1 count
        preSum.put(0, 1);

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (preSum.containsKey(sum - k )) {
                count += preSum.get(sum - k);
            }

            // still need to store this information!!!!!!!!!!!!
            // get or default
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);


        }

        return count;

    }
}
