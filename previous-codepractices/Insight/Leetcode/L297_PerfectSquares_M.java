package Leetcode;

public class L297_PerfectSquares_M {
    public int numSquares(int n) {

        int[] dp = new int[n + 1 ];
        // init value
        dp[0] = 0;
        for(int i = 1; i < n; i++) {
            int j = 1;
            int min = Integer.MAX_VALUE;;
            while( i - j*j >= 0) {
                min = Math.min(dp[i - j*j], min);
            }
            dp[i] = min + 1;
        }

        return dp[n];
    }

    public int numSquaresSol(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for(int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while(i - j*j >= 0) {
                min = Math.min(min, dp[i - j*j] + 1);
                ++j;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
