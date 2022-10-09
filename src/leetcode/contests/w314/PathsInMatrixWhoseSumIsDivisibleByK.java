package contests.w314;

import java.util.Arrays;

public class PathsInMatrixWhoseSumIsDivisibleByK {
    int mod = (int)1e9 + 7;

    public boolean isValid(int m, int n, int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    public int numberOfPaths(int[][] grid, int k, int sum, int row, int col, int[][][] dp) {
        int m = grid.length, n = grid[0].length;
        if(row == m - 1 && col == n - 1) {
            if((sum + grid[row][col]) % k == 0) {
                return 1;
            }
            return 0;
        }

        if(!isValid(m, n, row, col)) {
            return 0;
        }

        int rem = sum % k;
        if(dp[row][col][rem] != -1) {
            return dp[row][col][rem];
        }

        int newSum = sum + grid[row][col];
        dp[row][col][rem] = (numberOfPaths(grid, k, newSum,row + 1, col, dp) + numberOfPaths(grid, k, newSum, row, col + 1, dp)) % mod;
        return dp[row][col][rem];
    }
    public int numberOfPaths(int[][] grid, int k) {
        int[][][] dp = new int[grid.length][grid[0].length][k];

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return numberOfPaths(grid, k, 0, 0, 0, dp);
    }
}
