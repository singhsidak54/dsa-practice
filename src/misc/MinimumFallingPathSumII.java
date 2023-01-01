package misc;

public class MinimumFallingPathSumII {
    public static int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[] dp = new int[n];

        for(int i=0; i<n; i++) {
            dp[i] = grid[0][i];
        }

        for(int i=1; i<n; i++) {
            int prevRowSameCol = Integer.MAX_VALUE;
            for(int j=0; j<n; j++) {
                int currMin = prevRowSameCol;
                for(int k=0; k<n; k++) {
                    if(k == j) {
                        prevRowSameCol = dp[k];
                    } else {
                        currMin = Math.min(currMin, dp[k]);
                    }
                }

                dp[j] = grid[i][j] + currMin;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            min = Math.min(min, dp[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(minFallingPathSum(matrix));
    }
}
