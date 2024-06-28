package daily.apr23;

import java.util.LinkedList;
import java.util.Queue;

public class Day6NumberOfClosedIslands {
    int n, m;
    int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0, -1}};

    public boolean isValid(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }

    public void visit(int[][] grid, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, col});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for(int[] dir : dirs) {
                int r = curr[0] + dir[0], c = curr[1] + dir[1];
                if(isValid(r, c) && grid[r][c] == 0) {
                    grid[r][c] = 1;
                    queue.add(new int[] {r, c});
                }
            }
        }
    }

    public int closedIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        for(int i=0; i<n; i++) {
            if(grid[i][0] == 0) {
                visit(grid, i, 0);
            }

            if(grid[i][m - 1] == 0) {
                visit(grid, i, m - 1);
            }
        }

        for(int i=0; i<m; i++) {
            if(grid[0][i] == 0) {
                visit(grid, 0, i);
            }

            if(grid[n - 1][i] == 0) {
                visit(grid, n - 1, i);
            }
        }


        int islands = 0;
        for(int i=1; i<n-1; i++) {
            for(int j=1; j<m-1; j++) {
                if(grid[i][j] == 0) {
                    islands++;
                    visit(grid, i, j);
                }
            }
        }

        return islands;
    }
}
