package dp1;

import java.util.Arrays;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return numSquaresHelper(n, dp);
    }

    public int numSquaresHelper(int n, int[] dp) {
        if(n < 0) return 10001;
        if(n == 0) return 0;
        if(n == 1) return 1;

        if(dp[n] != -1) return dp[n];
        int res = 10001;
        for(int i=1; i*i<=n; i++) {
            res = Math.min(res, 1 + numSquaresHelper(n - (i*i), dp));
        }

        dp[n] = res;
        return res;
    }

    public int numSquaresIterative(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            dp[i] = i;
            for(int j=1; j*j<=i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j*j]);
            }
        }

        return dp[n];
    }
}
