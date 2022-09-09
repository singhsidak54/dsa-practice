package dp1;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int minTillNow = prices[0], maxProfit = 0;
        for(int i=1; i<prices.length; i++) {
            if(prices[i] > minTillNow + fee){
                maxProfit += prices[i] - minTillNow - fee;
                minTillNow = prices[i] - fee;
            } else if (prices[i] < minTillNow) {
                minTillNow = prices[i];
            }
        }

        return maxProfit;
    }

    public int maxProfit2(int[] prices, int fee) {
        int hold = -prices[0], cash = 0;
        for(int i=1; i<prices.length; i++) {
            cash = Math.max(cash, prices[i] + hold - fee);
            hold = Math.max(hold, cash - prices[i]);
        }

        return cash;
    }
}
