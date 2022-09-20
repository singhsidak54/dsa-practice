package lc75l2;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public boolean isValid(int m, int n, int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length, n = grid[0].length, freshOranges = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    freshOranges++;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        if(freshOranges == 0) return 0;

        int[][] dirs = new int[][] {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        int minutes = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                int[] curr = queue.poll();

                for(int[] dir : dirs) {
                    int r = curr[0] + dir[0], c = curr[1] + dir[1];
                    if(isValid(m, n, r, c) && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        queue.add(new int[] {r, c});
                        freshOranges--;
                    }
                }
            }
            minutes++;
        }

        return freshOranges == 0 ? minutes : -1;
    }
}
