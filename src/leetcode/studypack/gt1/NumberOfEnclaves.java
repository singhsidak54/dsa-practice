package gt1;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public boolean isValid(int m, int n, int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    public int visit(int[][] grid, int row, int col) {
        int m = grid.length, n = grid[0].length;
        int lands = 0;
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(row, col));
        int[][] dirs = new int[][] {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            Point pt = queue.poll();
            lands++;

            for(int[] dir : dirs) {
                int r = pt.row + dir[0];
                int c = pt.col + dir[1];

                if(isValid(m, n, r, c) && grid[r][c] == 1) {
                    grid[r][c] = 0;
                    queue.add(new Point(r, c));
                }
            }
        }
        return lands;
    }

    public int numEnclaves(int[][] grid) {
        int enclaves = 0;

        int m = grid.length, n = grid[0].length;

        for(int i=0; i<m; i++) {
            if(grid[i][0] == 1) {
                grid[i][0] = 0;
                visit(grid, i, 0);
            }

            if(grid[i][n-1] == 1) {
                grid[i][n - 1] = 0;
                visit(grid, i, n - 1);
            }
        }

        for(int j=0; j<n; j++) {
            if(grid[0][j] == 1) {
                grid[0][j] = 0;
                visit(grid, 0, j);
            }

            if(grid[m - 1][j] == 1) {
                grid[m - 1][j] = 0;
                visit(grid, m - 1, j);
            }
        }

        for(int i=1; i<m-1; i++) {
            for(int j=1; j<n-1; j++) {
                if(grid[i][j] == 1) {
                    grid[i][j] = 0;
                    enclaves += visit(grid, i, j);
                }
            }
        }

        return enclaves;
    }
}
