package lc75l1;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minTillNow = prices[0], maxProfit = 0;
        for(int i=1; i<prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minTillNow);
            if(prices[i] < minTillNow) {
                minTillNow = prices[i];
            }
        }

        return maxProfit;
    }
}
