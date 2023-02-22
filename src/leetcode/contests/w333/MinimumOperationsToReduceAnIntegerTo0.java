package contests.w333;


import java.util.Arrays;

public class MinimumOperationsToReduceAnIntegerTo0 {

    public static int dfs(int n, int[] dp) {
        if(n < 0) {
            return 100001;
        }
        if(dp[n] != -1) {
            return dp[n];
        }

        dp[n] = 100001;
        int c = 1;
        while ((c << 1) < n) {
            c <<= 1;
        }

        int op1 = 1 + dfs(n - c, dp);

        c <<= 1;
        int op2 = 1 + dfs(c - n, dp);

        dp[n] = Math.min(op1, op2);
        return dp[n];
    }
    public static int minOperations(int n) {
        int c = 1;
        while ((c << 1) <= n) {
            c <<= 1;
        }

        c <<= 1;
        int[] dp = new int[c+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dfs(n, dp);

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(minOperations(54));
    }
}
