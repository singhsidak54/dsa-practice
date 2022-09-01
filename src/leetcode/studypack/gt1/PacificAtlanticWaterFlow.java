package gt1;

import java.util.*;

public class PacificAtlanticWaterFlow {
    public static boolean isValid(int m, int n, int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    public static void bfs(int[][] heights, boolean[][] visited, int row, int col) {

        int m = heights.length, n = heights[0].length;
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, col});

        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            for(int[] dir : dirs) {
                int r = point[0] + dir[0], c = point[1] + dir[1];

                if(isValid(m, n, r, c) && !visited[r][c] && heights[r][c] >= heights[point[0]][point[1]]) {
                    visited[r][c] = true;
                    queue.add(new int[] {r, c});
                }
            }
        }
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<m; i++) {
            bfs(heights, pacific, i, 0);
            bfs(heights, atlantic, i, n - 1);

            pacific[i][0] = true;
            atlantic[i][n - 1] = true;
        }

        for(int i=0; i<n; i++) {
            bfs(heights, pacific, 0, i);
            bfs(heights, atlantic, m - 1, i);

            pacific[0][i] = true;
            atlantic[m - 1][i] = true;
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i,j));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(pacificAtlantic(new int[][] {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}}));
    }
}
