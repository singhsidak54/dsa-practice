package dp1;

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for(int i=1; i<m; i++) {
            for(int j=0; j<n; j++) {
                int curr = matrix[i-1][j];
                if(j != 0) {
                    curr = Math.min(curr, matrix[i-1][j-1]);
                }

                if(j != n-1) {
                    curr = Math.min(curr, matrix[i-1][j+1]);
                }

                matrix[i][j] += curr;
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            ans = Math.min(ans, matrix[m-1][i]);
        }
        return ans;
    }
}
