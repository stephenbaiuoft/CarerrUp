package Leetcode;

public class L494_TargetSum_M {
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for(int i: nums) sum+=i;
        if(s>sum || s<-sum) return 0;
        int[] dp = new int[2*sum+1];
        dp[0+sum] = 1;
        for(int i = 0; i<nums.length; i++){
            int[] next = new int[2*sum+1];
            for(int k = 0; k<2*sum+1; k++){
                if(dp[k]!=0){
                    // you need next to indicate that
                    // each i, you run adjacent to relative to i
                     next[k + nums[i]] += dp[k];
                     next[k - nums[i]] += dp[k];
//                    DP[k + nums[i]] += DP[k];
//                    DP[k - nums[i]] += DP[k];
                }
            }
            dp = next;
        }
        return dp[sum-s];
    }
}
