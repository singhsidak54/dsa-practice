package dp1;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1] == 1) return 0;
        int[] dp = new int[n];
        dp[n-1] = 1;
        for(int j=n-2; j>=0; j--) {
            if(obstacleGrid[m-1][j] != 1) {
                dp[j] = dp[j+1];
            }
        }

        for(int i=m-2; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                if(obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j != n-1) {
                    dp[j] += dp[j+1];
                }
            }
        }

        return dp[0];
    }
}
