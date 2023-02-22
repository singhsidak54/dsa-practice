package daily.feb23;

import java.util.*;

public class Day10AsFarFromLandAsPossible {
    public int maxDistanceBruteForce(int[][] grid) {
        int n = grid.length;
        int[][] dist = new int[n][n];
        List<int[]> ones = new ArrayList<>();

        for(int i=0; i<n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    ones.add(new int[] {i,j});
                    dist[i][j] = 0;
                }
            }
        }

        // no land
        if(ones.size() == 0) return -1;

        for(int[] one : ones) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    int currentDist = Math.abs(i - one[0]) + Math.abs(j - one[1]);
                    if(currentDist < dist[i][j]) {
                        dist[i][j] = currentDist;
                    }
                }
            }
        }

        int maxX = 0, maxY = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(dist[i][j] > dist[maxX][maxY]) {
                    maxX = i;
                    maxY = j;
                }
            }
        }

        // no water
        return dist[maxX][maxY] == 0 ? -1 : dist[maxX][maxY];
    }

    public boolean isValid(int n, int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
    public int maxDistanceBFS(int[][] grid) {
        int[][] dirs = {{-1,0}, {0, -1}, {1, 0}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        int n = grid.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    queue.add(new int[] {i,j, 0});
                    visited.add(i + "-" + j);
                }
            }
        }

        if(queue.size() == 0 || queue.size() == n * n) {
            return -1;
        }

        int distance = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            distance = Math.max(distance, curr[2]);

            for(int[] dir : dirs) {
                int r = curr[0] + dir[0], c = curr[1] + dir[1];
                if(isValid(n, r, c) && !visited.contains(r + "-" + c)) {
                    visited.add(r + "-" + c);
                    queue.add(new int[] {r, c, curr[2] + 1});
                }
            }
        }

        return distance;
    }

    public int maxDistanceDP(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];

        // top left to bottom right
        // first row
        dp[0][0] = grid[0][0] == 1 ? 0 : 10000;
        for(int i=1; i<n; i++) {
            dp[0][i] = grid[0][i] == 1 ? 0 : dp[0][i-1] + 1;
        }
        // first col
        for(int i=1; i<n; i++) {
            dp[i][0] = grid[i][0] == 1 ? 0 : dp[i-1][0] + 1;
        }

        for(int i=1; i<n; i++) {
            for(int j=1; j<n; j++) {
                dp[i][j] = grid[i][j] == 1 ? 0 : Math.min(dp[i-1][j], dp[i][j-1]) + 1;
            }
        }

        // bottom right to top left
        // last row
        for(int i=n-2; i>=0; i--) {
            dp[n-1][i] = Math.min(dp[n-1][i], dp[n-1][i+1] + 1);
        }

        // last col
        for(int i=n-2; i>=0; i--) {
            dp[i][n-1] = Math.min(dp[i][n-1], dp[i+1][n-1] + 1);
        }


        for(int i=n-2; i>=0; i--) {
            for(int j=n-2; j>=0; j--) {
                dp[i][j] = Math.min(dp[i][j], Math.min(dp[i][j+1], dp[i+1][j]) + 1);
            }
        }

        int max = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }

        return max == 0 || max >= 10000 ? -1 : max;
    }
}
