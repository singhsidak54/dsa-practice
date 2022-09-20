package lc75l2;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for(int i=1; i<=amount; i++) {
            dp[i] = 10001;
            for(int coin: coins) {
                if(i - coin < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        return dp[amount] >= 10001 ? -1 : dp[amount];
    }
}
