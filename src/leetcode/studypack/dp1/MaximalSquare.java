package dp1;

public class MaximalSquare{
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int maxLen = 0;

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }

        return maxLen * maxLen;
    }

    public int maximalSquare2(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] dp = new int[n+1];

        int maxLen = 0, prev = 0;

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                int temp = dp[i];
                if(matrix[i-1][j-1] == '1') {
                    dp[i] = Math.min(dp[i], Math.min(prev, dp[i-1])) + 1;
                    maxLen = Math.max(maxLen, dp[i]);
                } else {
                    dp[i] = 0;
                }

                prev = temp;
            }
        }

        return maxLen * maxLen;
    }
}
