package Scaler.DP;

import java.util.Arrays;

public class WaysToSendTheSignal {
    int mod;
    public int solve(int A, int idx, int prevOn, int[][] dp) {
        if(idx == A) return 1;
        if(dp[idx][prevOn] != -1) return dp[idx][prevOn];

        int ways = solve(A, idx + 1, 0, dp);
        if(prevOn == 0) {
            ways = (ways + solve(A, idx + 1, 1, dp)) % mod;
        }

        dp[idx][prevOn] = ways;
        return dp[idx][prevOn];
    }

    public int solve(int A) {
        mod = 1_000_000_007;
        int[][] dp = new int[A][2];

        for(int i=0; i<A; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(A, 0, 0, dp);
    }

    public static void main(String[] args) {
        WaysToSendTheSignal obj = new WaysToSendTheSignal();
        System.out.println(obj.solve(3));
    }
}
