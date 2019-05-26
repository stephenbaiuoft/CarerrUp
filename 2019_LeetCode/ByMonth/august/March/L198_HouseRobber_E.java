package ByMonth.august.March;

public class L198_HouseRobber_E {

    // idea
    // each spot is either rob or not rob
    // and save the max of that operation
    // --> DP[i] the maximum one can rob from up to i index!!!!!
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];

        int value = 0;
        for(int i = 2; i <= nums.length; i++) {
            int prev = i - 2;
            int rob = nums[i-1] + dp[prev];
            int notrob = dp[i-1];
            dp[i] =  Math.max(rob, notrob);
        }
        return dp[nums.length];
    }
}
