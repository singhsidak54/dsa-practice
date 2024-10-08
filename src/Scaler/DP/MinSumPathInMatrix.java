package Scaler.DP;

public class MinSumPathInMatrix {
    public int minPathSum(int[][] A) {
        int n = A.length, m = A[0].length;
        int[][] dp = new int[n][m];
        dp[n-1][m-1] = A[n-1][m-1];

        for(int i=m-2; i>=0; i--) {
            dp[n-1][i] = A[n-1][i] + dp[n-1][i+1];
        }

        for(int i=n-2; i>=0; i--) {
            dp[i][m-1] = A[i][m-1] + dp[i+1][m-1];
        }

        for(int i=n-2; i>=0; i--) {
            for(int j=m-2; j>=0; j--) {
                dp[i][j] = A[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
            }
        }

        return dp[0][0];
    }
}
