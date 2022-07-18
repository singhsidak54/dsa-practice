package lc75l1;

public class NumberOfIslands {
    public void visit(char[][] grid, int r, int c) {
        if(r == grid.length) return;
        if(c == grid[r].length) return;

        grid[r][c] = '0';
        int[][] dirs = {{1,0}, {0, 1}, {-1,0}, {0,-1}};
        for(int[] dir : dirs) {
            int newR = r + dir[0];
            int newC = c + dir[1];

            if(newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[newR].length && grid[newR][newC] == '1') {
                grid[newR][newC] = '0';
                visit(grid, newR, newC);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int islands = 0;
        int m = grid.length, n = grid[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1') {
                    islands++;
                    visit(grid, i, j);
                }
            }
        }

        return islands;
    }
}
