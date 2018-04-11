package April;

import java.util.HashMap;

public class L325_MaxSubArray_M {

    public int maxSubArrayLen(int[] nums, int k) {
        // default case
        if(nums == null || nums.length == 0) return 0;

        for(int i = 1; i < nums.length; i++) {
            // make the value in each array as the sum up to
            // the index i
            nums[i] += nums[i-1];
        }

        // use hashmap s.t looking for value is O(1)
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        // put value 0 as the reference value with index of -1
        // so the max length is really i - j  (because of -1 offset)

        // KEY IDEA
        // nums[i] - nums[j] = k
        // so nums[j] = nums[i] - k
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            // up to the ith index, the map contains k - nums[i] value
            if(map.containsKey(nums[i] - k)) {
                maxLength = Math.max(maxLength, i - map.get(nums[i] - k));
            }
            // add the value ONLY if this value does not exist
            // we are moving from left to right
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }

        return maxLength;
    }
}
