package gt1;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfClosedIslands {
    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void visit(int[][] grid, int row, int col) {
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(row, col));
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            for(int[] dir : dirs) {
                int r = curr.row + dir[0], c = curr.col + dir[1];
                if(r >= 0 && r < grid.length && c >= 0 && c < grid[r].length && grid[r][c] == 0) {
                    queue.add(new Point(r, c));
                    grid[r][c] = 1;
                }
            }
        }
    }

    public static int closedIsland(int[][] grid) {
        int islands = 0, m = grid.length, n = grid[0].length;

        for(int i=0; i<m; i++) {
            if(grid[i][0] == 0) {
                visit(grid, i, 0);
            }

            if(grid[i][n - 1] == 0) {
                visit(grid, i, n - 1);
            }
        }

        for(int j=0; j<n; j++) {
            if(grid[0][j] == 0) {
                visit(grid, 0, j);
            }

            if(grid[m - 1][j] == 0) {
                visit(grid, m - 1, j);
            }
        }

        for(int i=1; i<grid.length-1; i++) {
            for(int j=1; j<grid[i].length-1; j++) {
                if(grid[i][j] == 0) {
                    grid[i][j] = 1;
                    visit(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }
}
