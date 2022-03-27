package dp;

/*
*
Given a positive integer n,
 find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
*
* */


public class L279_PerfectSquares_M {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        // iterate through each number, i
        for (int i = 1; i <=n; i++) {
            // iterating from [1 - i_squared]
            int j = 1;
            int min = i;
            // inclusive
            while ( i - j*j >= 0) {
                min = Math.min(min, dp[i-j*j]);
                j++;
            }
            // 1 is either either 1*1 = 1 or some value squared
            dp[i] = min + 1;
        }

        return dp[n];
    }
}
