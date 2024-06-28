package Scaler.Contest.AdvancedDSA7;

public class BobAndIslands {
    public int solve(int[] A) {
        int n = A.length;
        if(n == 1) return A[0];

        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = Math.abs(A[1] - A[0]);
        for(int i=2; i<n; i++) {
            dp[i] = Math.min(dp[i - 1] + Math.abs(A[i] - A[i - 1]),
                                dp[i - 2] + Math.abs(A[i] - A[i - 2]));
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        BobAndIslands obj = new BobAndIslands();

    }
}
