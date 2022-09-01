package gt1;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {
    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static boolean isValidPixel(int m, int n, int r, int c) {
        return r >= 0 && r < m && c >=0 && c < n;
    }

    public static int maxDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        Queue<Point> queue = new LinkedList<>();
        int dist = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    queue.add(new Point(i, j));
                }
            }
        }

        if(queue.size()==0 || queue.size()==m*n ) return -1;

        int[][] dirs = new int[][] {{0,1}, {0,-1}, {1,0}, {-1, 0}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                Point pt = queue.poll();

                for(int[] dir : dirs) {
                    int r = pt.row + dir[0], c = pt.col + dir[1];
                    if(isValidPixel(m, n, r, c) && grid[r][c] == 0) {
                        grid[r][c] = 1;
                        queue.add(new Point(r, c));
                    }
                }
            }
            dist++;
        }


        return dist - 1;
    }

    public static void main(String[] args) {
        System.out.println(maxDistance(new int[][] {{1,0,0,0,0,1,0,0,0,1},{1,1,0,1,1,1,0,1,1,0}}));
    }
}
