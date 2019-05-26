package Amazon;

public class L122_BuySellStock_E {
    // You can buy and sell stock multiple times, but you must buy before selling
    // Same idea think about the linear Graph
    public int maxProfit(int[] prices) {
        // maxProIndex used to determined if the Graph keeps up or down
        // maxProfit: accumulates sum
        int maxProit = 0;
        for (int i = 1; i < prices.length; i++) {
            int difference = prices[i] - prices[i-1];
            if (difference > 0) {
                // keeps increasing
                maxProit += difference;
            }
        }
        return maxProit;
    }
}
