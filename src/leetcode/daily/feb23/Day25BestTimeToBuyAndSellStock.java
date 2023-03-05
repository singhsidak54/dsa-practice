package daily.feb23;

public class Day25BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minTillNow = Integer.MAX_VALUE, profit = 0;
        for(int price : prices) {
            if(price < minTillNow) {
                minTillNow = price;
            } else {
                profit = Math.max(profit, price - minTillNow);
            }
        }

        return profit;
    }
}
