package Scaler.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0, -1}};

    public boolean isValid(int r, int c, int m, int n) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    public int solve(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int orangesLeft = 0, timePassed = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j] == 2) {
                    queue.add(new int[] {i, j});
                } else if(mat[i][j] == 1) {
                    orangesLeft++;
                }
            }
        }

        while (orangesLeft > 0 && !queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] curr = queue.poll();
                for(int[] dir : dirs) {
                    int r = curr[0] + dir[0], c = curr[1] + dir[1];
                    if(isValid(r, c, m, n) && !visited[r][c] && mat[r][c] == 1) {
                        visited[r][c] = true;
                        queue.add(new int[] {r, c});
                        orangesLeft--;
                    }
                }
            }

            timePassed++;
        }
        return orangesLeft == 0 ? timePassed : -1;
    }
}
