package ByMonth.august.april;

import java.util.HashMap;

public class L523_ContinuousSubArySum_M {
    public boolean checkSubarraySum(int[] nums, int k) {
        // need to use module property
        // (a + n*k)%k == a%k   --> so we use this as key, and value is the index of nums
        // init the map with default values (-1 and 0 s.t if indice of 0 and 1 gets to 0 --> return true)
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int runningSum = 0;
        for(int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if (k != 0) runningSum %= k;
            if (map.get(runningSum) != null) {
                // meets the >=2 condition
                if (i - map.get(runningSum) > 1) {
                    return true;
                }
            }
            else {
                // store the moduled runningSum val and the index
                map.put(runningSum, i);
            }
        }

        return false;

    }
}
