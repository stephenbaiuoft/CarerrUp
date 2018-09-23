package Leetcode;

/*
* Given an integer array nums, find the contiguous subarray
* within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
* */

public class L152_M {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int maxVal = nums[0];
        // this most negative number up to ith element!!!!!最重要的definition!!!!
        int[] nDp = new int[nums.length + 1];
        int[] pDp = new int[nums.length + 1];
        nDp[0] = 1;
        pDp[0] = 1;

        for(int i = 1; i <= nums.length; i++) {
            if (nums[i-1] >= 0) {
                pDp[i] = Math.max(nums[i-1], nums[i-1] * pDp[i-1]);
                nDp[i] = Math.min(nums[i-1], nums[i-1] * nDp[i-1]);
            }
            // nums[i-1] < 0
            else {
                nDp[i] = Math.min(nums[i-1], nums[i-1] * pDp[i-1]);
                // comparing previous one VS (nDp[i-1] * nums[i-1])
                pDp[i] = Math.max(nDp[i-1] * nums[i-1], nums[i-1]);

            }
            maxVal = Math.max(pDp[i], maxVal);
        }

        return maxVal;
    }
}
