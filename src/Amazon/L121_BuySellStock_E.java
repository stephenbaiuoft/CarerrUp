package Amazon;

public class L121_BuySellStock_E {

    // beats 9.82%
    public int maxProfit(int[] prices) {
        // maxProIndex: profit @ that index
        // maxProfit:
        int maxProIndex = 0, maxProfit = 0;

        for( int i = 1; i < prices.length; i++){
            int difference = prices[i] - prices[i-1];
            if (maxProIndex + difference > 0 ) {
                maxProIndex = maxProIndex + difference;
            } else {
                // decreasing
                maxProIndex = 0;
            }

            // record the highest one
            if (maxProIndex > maxProfit) {
                maxProfit = maxProIndex;
            }
        }
        return maxProfit;

//
//        int today=0,max=0;
//        for(int i=1;i<prices.length;i++){
//            if(today+prices[i]-prices[i-1]>0)
//                today=today+prices[i]-prices[i-1];
//            else today=0;
//            if(today>max)
//                max=today;
//        }
//        return max;

//        int minPrice = Integer.MAX_VALUE;
//        int maxProfit = 0;
//        for (int i = 0; i < prices.length; i ++) {
//            minPrice = Integer.min(minPrice, prices[i]);
//            maxProfit = Integer.max(maxProfit, prices[i] - minPrice);
//        }
//        return maxProfit;
    }

}
