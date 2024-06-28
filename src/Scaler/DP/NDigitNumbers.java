package Scaler.DP;

import java.util.Arrays;

public class NDigitNumbers {
    int mod = 1_000_000_007;

    public int helper(int digits, int sum, int[][] dp) {
        if(sum == 0) return 1;

        if(digits == 0 || sum < 0) return 0;

        if(dp[digits][sum] != -1) return dp[digits][sum];

        int count = 0;
        for(int i=0; i<=9; i++) {
            count = (count + helper(digits - 1, sum - i, dp)) % mod;
        }

        dp[digits][sum] = count;
        return dp[digits][sum];
    }

    public int solve(int A, int B) {
        int[][] dp = new int[A + 1][B + 1];
        for(int i=0; i<=A; i++) {
            Arrays.fill(dp[i], -1);
        }

        int count = 0;
        for(int i=1; i<=9; i++) {
            count = (count + helper(A - 1, B - i, dp)) % mod;
        }

        return count;
    }

    public static void main(String[] args) {
        NDigitNumbers obj = new NDigitNumbers();
        System.out.println(obj.solve(1, 3));
    }
}
