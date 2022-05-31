package algo2;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0; i<=n-1; i++) {
            dp[m-1][i] = 1;
        }

        for(int i=0; i<m-1; i++) {
            dp[i][n-1] = 1;
        }

        for(int i=m-2; i>=0; i--) {
            for(int j=n-2; j>=0; j--) {
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }

        return dp[0][0];
    }

    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        for(int i=0; i<n; i++) {
            dp[i] = 1;
        }

        for(int i=m-2; i>=0; i--) {
           for(int j=n-2; j>=0; j--) {
               dp[j] += dp[j+1];
           }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(2 * Math.pow(10, 9) < Integer.MAX_VALUE);
    }
}