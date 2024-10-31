package daily.oct24;

public class Day29MaximumNumberOfMovesInAGrid {
    int m, n;
    Integer[][] dp;
    int[][] dirs = {{-1, 1}, {0, 1}, {1,1}};

    public int dfs(int[][] grid, int r, int c) {
        if(dp[r][c] != null) return dp[r][c];
        int curr = 0;

        for(int[] dir : dirs) {
            int nR = r + dir[0], nC = c + dir[1];

            if(nR < 0 || nR >= m) continue;
            if(nC < 0 || nC >= n) continue;
            if(grid[nR][nC] <= grid[r][c]) continue;

            curr = Math.max(curr, dfs(grid, nR, nC));
        }

        dp[r][c] = curr + 1;
        return dp[r][c];
    }

    public int maxMoves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new Integer[m][n];
        int max = 0;

        for(int i=0; i<m; i++) {
            max = Math.max(max, dfs(grid, i, 0));
        }

        return max == 0 ? 0 : max - 1;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,4,3,5}, {5,4,9,3}, {3,4,2,11}, {10,9,13,15}};
        Day29MaximumNumberOfMovesInAGrid obj = new Day29MaximumNumberOfMovesInAGrid();
        System.out.println(obj.maxMoves(grid));
    }
}
