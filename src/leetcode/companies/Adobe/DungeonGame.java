package companies.Adobe;

public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m][n];

        if(dungeon[m-1][n-1] < 0) {
            dp[m-1][n-1] = Math.abs(dungeon[m-1][n-1]) + 1;
        } else {
            dp[m-1][n-1] = 1;
        }

        for(int i=m-2; i>=0; i--) {
            if(dungeon[i][n-1] < 0) {
                dp[i][n-1] = Math.abs(dungeon[i][n-1]) + dp[i+1][n-1];
            } else {
                dp[i][n-1] = Math.max(1, dp[i+1][n-1] - dungeon[i][n-1]);
            }
        }

        for(int i=n-2; i>=0; i--) {
            if(dungeon[m-1][i] < 0) {
                dp[m-1][i] = Math.abs(dungeon[m-1][i]) + dp[m-1][i+1];
            } else {
                dp[m-1][i] = Math.max(1, dp[m-1][i+1] - dungeon[m-1][i]);
            }
        }

        for(int i=m-2; i>=0; i--) {
            for(int j=n-2; j>=0; j--) {
                int min = Math.min(dp[i+1][j], dp[i][j+1]);
                if(dungeon[i][j] < 0) {
                    dp[i][j] = Math.abs(dungeon[i][j]) + min;
                } else {
                    dp[i][j] = Math.max(1, min - dungeon[i][j]);
                }
            }
        }


        return dp[0][0];
    }
}
