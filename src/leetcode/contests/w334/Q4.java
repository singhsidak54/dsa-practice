package contests.w334;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q4 {

    public static boolean isValid(int m, int n, int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    public static int minimumTime(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        int[][] dirs = {{1,0}, {0,1}, {0,-1}, {-1, 0}};

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });

        queue.add(new int[] {0, 0, 0});
        grid[0][0] = -1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for(int[] dir : dirs) {
                int r = curr[0] + dir[0], c = curr[1] + dir[1];
                if(isValid(m, n, r, c) && grid[r][c] != -1 ) {
                    int[] next = {r, c, curr[2]};

                    if(grid[r][c] > next[2] + 1) {
                        int diff = grid[r][c] - next[2];
                        next[2] = diff % 2 == 0 ? grid[r][c] + 1 : grid[r][c];
                    } else {
                        next[2] += 1;
                    }

                    if(next[0] == m - 1 && next[1] == n - 1) {
                        return next[2];
                    }
                    queue.add(next);
                    grid[r][c] = -1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] nums = {{0,1,3,2},{5,1,2,5},{4,3,8,6}};

        System.out.println(minimumTime(nums));
    }
}
