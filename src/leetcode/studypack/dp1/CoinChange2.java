package dp1;


import java.util.Arrays;

public class CoinChange2 {
    public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;

        for(int i=1; i<=coins.length; i++) {
            dp[i][0] = 1;
            for(int j=1; j<=amount; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= coins[i-1]) {
                    dp[i][j] += dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[coins.length][amount];
    }

    public int change2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for(int coin : coins) {
            for(int i=coin; i<=amount; i++) {
                dp[i] += dp[i-coin];
            }
        }

        return dp[amount];
    }
    public static void main(String[] args) {
        System.out.println(change(5, new int[] {1,2,5}));
    }
}
