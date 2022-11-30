package daily.nov22;

import java.util.LinkedList;
import java.util.Queue;

public class Day21NearestExitFromEntranceInMaze {
    public boolean isValid(int m, int n, int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    public boolean isBoundary(int m, int n, int r, int c) {
        return r == 0 || r == m - 1 || c == 0 || c == n - 1;
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        int[][] dirs = {{1,0}, {-1,0}, {0,-1}, {0,1}};
        int m = maze.length, n = maze[0].length, dist = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] curr = queue.poll();
                for(int[] dir : dirs) {
                    int r = curr[0] + dir[0], c = curr[1] + dir[1];
                    if(isValid(m, n, r, c) && maze[r][c] != '+') {
                        if(isBoundary(m, n, r, c)) {
                            return dist;
                        }
                        maze[r][c] = '+';
                        queue.add(new int[] {r, c});
                    }
                }
            }
            dist++;
        }

        return -1;
    }
}
