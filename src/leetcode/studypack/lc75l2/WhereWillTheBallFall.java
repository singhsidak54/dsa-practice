package lc75l2;

import java.util.LinkedList;
import java.util.Queue;

public class WhereWillTheBallFall {
    public boolean isValid(int m, int n, int r, int c) {
        return r >=0 && r < m && c >= 0 && c < n;
    }

    public int findPosition(int[][] grid, int i) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, i});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if(curr[0] == m) return curr[1];

            if(isValid(m, n, curr[0], curr[1])) {
                if(grid[curr[0]][curr[1]] == 1) {
                    if(isValid(m, n, curr[0], curr[1] + 1) && grid[curr[0]][curr[1] + 1] == 1) {
                        queue.add(new int[] {curr[0] + 1, curr[1] + 1});
                    }
                } else  {
                    if(isValid(m, n, curr[0], curr[1] - 1) && grid[curr[0]][curr[1]] == -1) {
                        queue.add(new int[] {curr[0] + 1, curr[1] - 1});
                    }
                }
            }
        }
        return -1;
    }

    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] res = new int[n];
        for(int i=0; i<n; i++) {
            res[i] = findPosition(grid, i);
        }

        return res;
    }

    public int[] findBall2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] res = new int[n];
        for(int i=0; i<n; i++) {
            int i1 = i, i2;
            for(int j=0; j<m; j++) {
                i2 = i1 + grid[j][i1];
                if(i2 < 0 || i2 == n || grid[j][i1] != grid[j][i2]) {
                    i1 = -1;
                    break;
                }
                i1 = i2;
            }
            res[i] = i1;
        }
        return res;
    }
}
