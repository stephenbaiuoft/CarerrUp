package dynamic_programming;

import java.util.Arrays;

public class L213HouseRobberII {
    /**
     * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
     *
     * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
     */

    public int rob(int[] nums) {

        // Given circular, then technically we have 2 cases
        // case 1, rob house 1, and we cannot take last house
        // case 2, do not rob house 1 and we can take last house
        return Math.max(robLinear(nums, 1, nums.length-1),
                robLinear(nums, 2, nums.length));

    }

    // s && end are for the house
    public int robLinear(int[] nums, int s, int end) {
        int[] maxProfit = new int[nums.length+1];
        if (s==1) {
            maxProfit[1] = nums[0];
        }

        for (int h = 2; h <= end; h++) {
            maxProfit[h] = Math.max(
                    maxProfit[h-1],
                    maxProfit[h-2] + nums[h-1] // nums[h-1] rob this house
            );
        }

        return Math.max(maxProfit[end], maxProfit[1]);
    }
}
