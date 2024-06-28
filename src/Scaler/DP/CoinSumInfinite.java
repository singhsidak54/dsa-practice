package Scaler.DP;

import java.util.Arrays;

public class CoinSumInfinite {

    int mod = 1_000_007;

    public int helper(int[] A, int idx, int B, int[][] dp) {
        if(B == 0) return 1;
        if(B < 0 || idx == A.length) return 0;
        if(dp[idx][B] != -1) return dp[idx][B];


        int ways = 0;
        // pick
        ways = (ways + helper(A, idx, B - A[idx], dp)) % mod;

        // not pick
        ways = (ways + helper(A, idx + 1, B, dp)) % mod;

        dp[idx][B] = ways;
        return dp[idx][B];
    }

    public int coinchange2(int[] A, int B) {
        int[][] dp = new int[A.length][B + 1];
        for(int i=0; i<A.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(A, 0, B, dp);
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        CoinSumInfinite obj = new CoinSumInfinite();
        System.out.println(obj.coinchange2(A, 4));
    }
}
