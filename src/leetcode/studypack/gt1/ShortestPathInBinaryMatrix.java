package gt1;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public boolean isValid(int m, int n, int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;

        int[][] dirs = {{0,1}, {1,0}, {1,1}, {1,-1}, {0,-1}, {-1,-1}, {-1,0}, {-1,1}};
        Queue<int[]> queue = new LinkedList<>();
        int dist = 0;
        queue.add(new int[] {0, 0});

        while (!queue.isEmpty()) {
            int size = queue.size();
            dist++;
            for(int i=0; i<size; i++) {
                int[] pt = queue.poll();
                if(pt[0] == m-1 && pt[1] == n-1) return dist;

                for(int[] dir : dirs) {
                    int r = pt[0] + dir[0], c = pt[1] + dir[1];
                    if(isValid(m, n, r, c) && grid[r][c] == 0) {
                        grid[r][c] = 1;
                        queue.add(new int[] {r, c});
                    }
                }
            }
        }
        return -1;
    }
}
