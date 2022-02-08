package dynamicprogramming;

import java.util.Arrays;

/*
*
You are given coins of different denominations and a total amount of money amount.
Write a function to compute the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.

* */
public class L322_CoinChange_M {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        int maxVal = amount + 1;

        Arrays.fill(dp, maxVal);
        dp[0] = 0;
        for(int i = 0; i <= amount; i++) {
            for(int coin: coins) {
                if (i>= coin) {
                    // 思路--》 这里一定是 DP[i-coin]+1 ！！ 很重要 因为是min是最外的决定！！
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }

        return dp[amount] == maxVal? -1: dp[amount];
    }

}
