package gt1;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int visit(int[][] grid, int row, int col) {
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(row, col));
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int area = 0;
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            area++;

            for(int[] dir : dirs) {
                int r = curr.row + dir[0], c = curr.col + dir[1];
                if(r >= 0 && r < grid.length && c >= 0 && c < grid[r].length && grid[r][c] == 1) {
                    queue.add(new Point(r, c));
                    grid[r][c] = 0;
                }
            }
        }
        return area;
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    grid[i][j] = 0;
                    maxArea = Math.max(maxArea, visit(grid, i, j));

                }
            }
        }
        return maxArea;
    }
}
