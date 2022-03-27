package dp.buystock;

public class L123_BuyStock_H {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
    public int maxProfit(int[] prices) {
        int t1Cost = Integer.MAX_VALUE,
                t2Cost = Integer.MAX_VALUE;
        int t1Prift = 0, t2Profit = 0;
        // iterate once, where
        // get the max profit you can get with 1 transaction,
        // then after that, get the next max profit you can get
        for (int p: prices) {
            t1Cost = Math.min(t1Cost, p);
            t1Prift = Math.max(t1Prift, p - t1Cost);

            // now p1 at this point is the max profit
            // but t2Cost --> you may consider t1Profit is the profit you can so far, so put in under t2Cost
            // the way you do that is consider p at this point reducing t1Profit (as t2Cost will be deducted from p
            t2Cost = Math.min(t2Cost, p - t1Prift);

            t2Profit = Math.max(t2Profit, p - t2Cost);

        }

        return t2Profit;
    }

}
