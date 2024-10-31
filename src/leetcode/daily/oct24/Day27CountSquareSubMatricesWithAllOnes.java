package daily.oct24;

public class Day27CountSquareSubMatricesWithAllOnes {
    public int countSquares(int[][] matrix) {
        int ans = 0, n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n + 1][m + 1];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j] == 0) continue;
                dp[i + 1][j + 1] = 1 + Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1]));
                ans += dp[i + 1][j + 1];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Day27CountSquareSubMatricesWithAllOnes obj = new Day27CountSquareSubMatricesWithAllOnes();
        int[][] matrix = {{1,0,1},{1,1,0}, {1,1,0}};

        System.out.println(obj.countSquares(matrix));
    }
}
