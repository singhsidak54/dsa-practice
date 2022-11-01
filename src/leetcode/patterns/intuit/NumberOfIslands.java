package patterns.intuit;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public boolean isValid(int m, int n, int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    public void visit(char[][] grid, int row, int col) {
        int[][] dirs = {{0,1}, {1,0}, {-1, 0}, {0, -1}};
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, col});
        grid[row][col] = '0';

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for(int[] dir : dirs) {
                int r = curr[0] + dir[0], c = curr[1] + dir[1];
                if(isValid(m, n, r, c) && grid[r][c] == '1') {
                    grid[r][c] = '0';
                    queue.add(new int[] {r, c});
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    islands++;
                    visit(grid, i, j);
                }
            }
        }

        return islands;
    }
}
