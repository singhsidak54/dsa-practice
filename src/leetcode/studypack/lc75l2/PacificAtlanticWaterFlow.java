package lc75l2;

import java.util.*;

public class PacificAtlanticWaterFlow {
    public boolean isValid(int m, int n, int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    public void visit(int[][] heights, int row, int col, boolean[][] visited) {
        int m = heights.length, n = heights[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        visited[row][col] = true;
        queue.offer(new int[] {row, col});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for(int[] dir : dirs) {
                int r = curr[0] + dir[0], c = curr[1] + dir[1];
                if(isValid(m, n, r, c) && !visited[r][c] && heights[r][c] >= heights[curr[0]][curr[1]]) {
                    visited[r][c] = true;
                    queue.offer(new int[] {r, c});
                }
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length, n = heights[0].length;

        boolean[][] pacificVisited = new boolean[m][n];
        boolean[][] atlanticVisited = new boolean[m][n];

        for(int i=0; i<m; i++) {
            if(!pacificVisited[i][0]) {
                visit(heights, i, 0, pacificVisited);
            }

            if(!atlanticVisited[i][n-1]) {
                visit(heights, i, n - 1, atlanticVisited);
            }
        }

        for(int i=0; i<n; i++) {
            if(!pacificVisited[0][i]) {
                visit(heights, 0, i, pacificVisited);
            }

            if(!atlanticVisited[m-1][i]) {
                visit(heights, m - 1, i, atlanticVisited);
            }
        }


        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(pacificVisited[i][j] && atlanticVisited[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }
}
