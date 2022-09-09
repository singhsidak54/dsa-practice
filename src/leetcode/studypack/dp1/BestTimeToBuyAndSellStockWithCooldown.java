package dp1;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices, int[] dp, int start) {
        if(start >= prices.length) return 0;

        if(dp[start] != -1) return dp[start];

        int maxProfit = 0;
        for(int i=start; i<prices.length; i++) {
            int currentMax = 0;
            for(int j=i+1; j<prices.length; j++) {
                if(prices[j] > prices[i]) {
                    int profit = maxProfit(prices, dp, j+2) + prices[j] - prices[i];
                    currentMax = Math.max(currentMax, profit);
                }
            }

            maxProfit = Math.max(maxProfit, currentMax);
        }

        dp[start] = maxProfit;
        return maxProfit;
    }

    //Gives TLE for 1 test case out of 210
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        Arrays.fill(dp, -1);
        return maxProfit(prices, dp, 0);
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if(n == 1) return 0;
        if(n == 2) return Math.max(0, prices[1] - prices[0]);
        int[] buy = new int[n];
        int[] sell = new int[n];

        buy[0] -= prices[0];
        buy[1] = Math.max(buy[0], -prices[1]);
        sell[1] = Math.max(0, prices[1] + buy[0]);

        for(int i=2; i<n; i++) {
            buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
        }

        return sell[n-1];
    }
}
