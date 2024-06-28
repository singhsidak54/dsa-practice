package daily.mar23;

public class Day27MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        dp[n - 1] = grid[m - 1][n - 1];
        for(int i=n-2; i>=0; i--) {
            dp[i] = dp[i + 1] + grid[m-1][i];
        }

        for(int i=m-2; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                int right = j == n - 1 ? Integer.MAX_VALUE : dp[j + 1];
                int bottom = dp[j];

                dp[j] = grid[i][j] + Math.min(right, bottom);
            }
        }

        return dp[0];
    }
}
