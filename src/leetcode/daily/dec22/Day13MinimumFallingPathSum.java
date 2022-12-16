package daily.dec22;

import java.util.Arrays;

public class Day13MinimumFallingPathSum {
    static int m, n;

    public static int minFallingPathSumHelper(int[][] matrix, int r, int c, Integer[][] dp) {
        if(r == m) return 0;
        if(c < 0 || c >= n) return Integer.MAX_VALUE;

        if(dp[r][c] != null) return dp[r][c];
        int[][] dirs = {{1,0}, {1,1}, {1, -1}};

        int nextAns = Integer.MAX_VALUE;
        for(int[] dir : dirs) {
            int nextR = r + dir[0], nextC = c + dir[1];
            nextAns = Math.min(nextAns, minFallingPathSumHelper(matrix, nextR, nextC, dp));
        }

        if(nextAns != Integer.MAX_VALUE) {
            dp[r][c] = matrix[r][c] + nextAns;
        } else {
            dp[r][c] = Integer.MAX_VALUE;
        }

        return dp[r][c];
    }

    public static int minFallingPathSum(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;

        Integer[][] dp = new Integer[m][n];
        int min = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            min = Math.min(min, minFallingPathSumHelper(matrix, 0, i, dp));
        }

        return min;
    }

    public static int minFallingPathSumIterative(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;

        int[] dp = new int[n];
        for(int i=0; i<n; i++) {
            dp[i] = matrix[m-1][i];
        }

        for(int i=m-2; i>=0; i--) {
            int prevRowPrev = Integer.MAX_VALUE;
            for(int j=0; j<n; j++) {
                int curr;
                if(j == n-1) {
                    curr = Math.min(prevRowPrev, dp[j]);
                } else {
                    curr = Math.min(prevRowPrev, Math.min(dp[j], dp[j + 1]));
                }

                prevRowPrev = dp[j];
                dp[j] = curr + matrix[i][j];
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            min = Math.min(min, dp[i]);
        }

        return min;
    }

    public static void main(String[] args) {
        int[][] matrix = {{2,1,3}, {6,5,4}, {7,8,9}};
        System.out.println(minFallingPathSumIterative(matrix));
    }
}
