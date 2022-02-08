package Leetcode;

public class L213_HouseRobber_M {
    public L213_HouseRobber_M() {
        int[] nums = new int[] {2,3,2};

        int rez = rob(nums);

    }

    public int rob(int[] nums) {
        // classic DP
        // 2 cases: c1 starting 0 - n-2 (first one to second last)
        //          c2 starting 1 - n-1 (second one to last one)
        if (nums == null || nums.length < 1) return 0;
        else if (nums.length == 1) return nums[0];


        int c1 = helper(nums, 0, nums.length -2);
        int c2 = helper(nums, 1, nums.length -1);

        return Math.max(c1, c2);
    }

    // return the max value given start and end indice of nums
    private int helper(int[] nums, int sIndex, int eIndex) {
        // compute the total lenth
        int n = eIndex - sIndex + 1;
        // build the default array
        int[] dp = new int[n + 1];
        dp[0] = 0;
        // make sure increment sIndex
        dp[1] = nums[sIndex++];

        // di is the index for DP array
        for(int di = 2; di <= n; di++) {
            // make sure increment sIndex!!!!
            dp[di] = Math.max(dp[di-1], nums[sIndex++] + dp[di-2]);
        }

        return dp[n];
    }
}
