package Scaler.DP;

public class UniquePathsInAGrid {
    public int uniquePathsWithObstacles(int[][] A) {
        int n = A.length, m = A[0].length;
        if(A[n - 1][m - 1] == 1) return 0;

        int[][] dp = new int[n][m];
        dp[n - 1][m - 1] = 1;

        // last col
        for(int i=n-2; i>=0; i--) {
            if(A[i][m - 1] == 1) dp[i][m - 1] = 0;
            else {
                dp[i][m - 1] = dp[i + 1][m - 1];
            }
        }

        // last row
        for(int i=m-2; i>=0; i--) {
            if(A[n - 1][i] == 1) dp[n - 1][i] = 0;
            else {
                dp[n - 1][i] = dp[n - 1][i + 1];
            }
        }

        // dp
        for(int i=n-2; i>=0; i--) {
            for(int j=m-2; j>=0; j--) {
                if(A[i][j] == 1) dp[i][j] = 0;
                else {
                    dp[i][j] += dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}
