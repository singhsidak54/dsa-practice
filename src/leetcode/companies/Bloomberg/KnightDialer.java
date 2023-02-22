package companies.Bloomberg;

public class KnightDialer {
    int mod = 1_000_000_007;
    Integer[][][] dp;

    int[][] dirs = {{1,2}, {2,1}, {2, -1}, {1, -2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}};

    public boolean isValid(int row, int col) {
        boolean valid = row >= 0 && row < 4 && col >= 0 && col < 3;
        return valid && !(row == 3 && (col == 0 || col == 2));
    }

    public int dfs(int row, int col, int n) {
        if(!isValid(row, col)) {
            return 0;
        }

        if(n == 0) {
            return 1;
        }

        if(dp[row][col][n] != null) {
            return dp[row][col][n];
        }

        dp[row][col][n] = 0;
        for(int[] dir : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];
            dp[row][col][n] = (dp[row][col][n] + dfs(r, c, n - 1)) % mod;
        }

        return dp[row][col][n];
    }

    public int knightDialer(int n) {
        dp = new Integer[4][3][n+1];
        int ans = 0;
        for(int i=0; i<4; i++) {
            for(int j=0; j<3; j++) {
                if(i == 3 && j != 1) continue;
                ans = (ans + dfs(i, j, n - 1)) % mod;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        KnightDialer obj = new KnightDialer();
        System.out.println(obj.knightDialer(2));
    }
}
