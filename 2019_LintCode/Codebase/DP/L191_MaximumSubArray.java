package Codebase.DP;

public class L191_MaximumSubArray {
    public int maxProduct(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) return -1;

        long max = nums[0];
        long min = nums[0];
        long preMax = max;
        long preMin = min;
        long res = nums[0];

        for (int i = 1; i < nums.length;i++) {
            max = Math.max(nums[i],
                    Math.max(preMax*nums[i], preMin * nums[i]  ));

            min = Math.min(nums[i],
                    Math.min(preMax*nums[i], preMin * nums[i]  ));

            // res only comparing to the max for this particular i
            res = Math.max(res, max);
            // update preMax and preMin --> note this takes care of breaking consecutive ones
            preMax = max;
            preMin = min;
        }

        return (int) res;
    }
}
