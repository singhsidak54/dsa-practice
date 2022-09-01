package gt1;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    int[][] dirs = {{-1,0}, {1,0}, {0, 1}, {0, -1}};
    public boolean isValid(int m, int n, int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    public void visitIsland1(int[][] grid, int row, int col, Queue<int[]> queue) {
        int m = grid.length, n = grid[0].length;

        queue.add(new int[] {row, col});
        grid[row][col] = 2;

        for(int[] dir: dirs) {
            int r = row + dir[0], c = col + dir[1];
            if(isValid(m, n, r, c) && grid[r][c] == 1) {
                visitIsland1(grid, r, c, queue);
            }
        }
    }

    public int shortestBridge(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;

        for(int i=0; i<m; i++) {
            if(found) break;
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    visitIsland1(grid, i, j, queue);
                    found = true;
                    break;
                }
            }
        }

        int dist = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] pt = queue.poll();
                for(int[] dir : dirs) {
                    int r = pt[0] + dir[0], c = pt[1] + dir[1];
                    if(isValid(m, n, r, c)) {
                        if(grid[r][c] == 1) return dist;
                        if(grid[r][c] == 0) {
                            queue.add(new int[] {r, c});
                            grid[r][c] = -1;
                        }
                    }
                }
            }
            dist++;
        }

        return dist;
    }
}
