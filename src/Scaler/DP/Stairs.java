package Scaler.DP;

public class Stairs {
    public int climbStairs(int A) {
        if(A == 1) return 1;
        if(A == 2) return 2;
        int mod = 1_000_000_007;
        int[] dp = new int[A + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=A; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % mod;
        }

        return dp[A];
    }
}
