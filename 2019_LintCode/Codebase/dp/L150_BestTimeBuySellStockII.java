package Codebase.dp;

/*
* Given an array prices, which represents the price of a stock in each day.

You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, if you already have the stock, you must sell it before you buy again).

Design an algorithm to find the maximum profit.

Example
Example 1:

Input: [2, 1, 2, 0, 1]
Output: 2
Explanation:
    1. Buy the stock on the second day at 1, and sell the stock on the third day at 2. Profit is 1.
    2. Buy the stock on the 4th day at 1, and sell the stock on the 5th day at 2. Profit is 1.
    Total profit is 2.
Example 2:

Input: [4, 3, 2, 1]
Output: 0
Explanation: No transaction, profit is 0.
* */

public class L150_BestTimeBuySellStockII {
    public L150_BestTimeBuySellStockII() {
        int p = maxProfit(new int[] {
                2,1,2,0,1
        });
        System.out.println(p);
    }

    // dp[i] the maximum profit you may gain by the ith day
    // dp[i] = max{ dp[j-1] + p[i] - p[j] } for some j, because ---> even if you sell j stock, the total profit!!!!
    // would be the same as keep j and sell on ith day
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) return 0;
        int[] dp = new int[prices.length];

        for (int i = 1; i < prices.length; i++) {
            dp[i] = dp[i-1]; // previous largest --> defined by ur own definition
            for (int j = i-1; j > -1; j--) {
                dp[i] = Math.max(dp[i],
                        dp[j] + prices[i] - prices[j]);
            }
        }

        return dp[prices.length-1];
    }

    public int maxProfitGreedy(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) return 0;
        int totProfit = 0;
        int curMin = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > curMin) {
                totProfit += prices[i] - curMin;
                curMin = prices[i];
            } else {
                curMin = prices[i];
            }
        }

        return totProfit;
    }

}
