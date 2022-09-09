package dp1;

import java.util.Arrays;

public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return integerBreak(n, dp);
    }

    public int integerBreak(int n, int[] dp) {
        if(n == 1) return 1;

        if(dp[n] != -1) return Math.max(n, dp[n]);
        int res = 0;
        for(int i=1; i<n; i++) {
            res = Math.max(res, Math.max(i * integerBreak(n-i, dp), i * (n-i)));
        }

        dp[n] = res;
        return dp[n];
    }

    public static int integerBreakIterative(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            for(int j=1; j<=i/2; j++) {
                dp[i] = Math.max(dp[i], j * Math.max(i-j, dp[i-j]));
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreakIterative(7));
    }
}
