package dp1;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int max = 10001;

        for(int i=1; i<=amount; i++) {
            dp[i] = max;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] >= max ? -1 : dp[amount];
    }
}
