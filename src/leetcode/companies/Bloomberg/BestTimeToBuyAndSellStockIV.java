package companies.Bloomberg;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIV {
    public int dfs(int[] prices, int index, int k, int[][] dp) {
        if(index >= prices.length || k == 0) {
            return 0;
        }

        if(dp[index][k] != -1) {
            return dp[index][k];
        }

        dp[index][k] = 0;
        for(int i=index+1; i<prices.length; i++) {
            if(prices[index] >= prices[i]) {
                dp[index][k] = Math.max(dp[index][k], dfs(prices, i, k, dp));
                return dp[index][k];
            } else {
                dp[index][k] = Math.max(dp[index][k], prices[i] - prices[index] + dfs(prices, i + 1, k - 1, dp));
            }
        }

        return dp[index][k];
    }

    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][k+1];
        for(int i=0; i<prices.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(prices, 0, k, dp);
    }

    public static void main(String[] args) {
        int[] prices = {2,4,1};
        BestTimeToBuyAndSellStockIV obj = new BestTimeToBuyAndSellStockIV();
        System.out.println(obj.maxProfit(2, prices));
    }
}
