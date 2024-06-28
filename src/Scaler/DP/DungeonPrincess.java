package Scaler.DP;

public class DungeonPrincess {
    public int calculateMinimumHP(int[][] A) {
        int n = A.length, m = A[0].length;
        int[][] dp = new int[n][m];

        dp[n-1][m-1] = Math.max(1 - A[n-1][m-1], 1);

        for(int i=m-2; i>=0; i--) {
            dp[n-1][i] = Math.max(1, dp[n-1][i+1] - A[n-1][i]);
        }

        for(int i=n-2; i>=0; i--) {
            dp[i][m-1] = Math.max(1, dp[i+1][m-1] - A[i][m-1]);
        }

        for(int i=n-2; i>=0; i--) {
            for(int j=m-2; j>=0; j--) {
                int right = Math.max(1, dp[i][j+1] - A[i][j]);
                int down = Math.max(1, dp[i+1][j] - A[i][j]);

                dp[i][j] = Math.min(right, down);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] arr = {{-2,-3,3}, {-5,-10,1}, {10,30,-5}};
        DungeonPrincess obj = new DungeonPrincess();
        System.out.println(obj.calculateMinimumHP(arr));
    }
}
