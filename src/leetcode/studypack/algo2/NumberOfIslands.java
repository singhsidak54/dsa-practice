package algo2;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int islands = 0;
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    islands++;
                    Queue<int[]> islandNodes = new LinkedList<>();
                    islandNodes.add(new int[] {i, j});
                    while(!islandNodes.isEmpty()) {
                        int[] islandNode = islandNodes.poll();
                        visited[islandNode[0]][islandNode[1]] = true;
                        for (int[] dir : dirs) {
                            int r = islandNode[0] + dir[0];
                            int c = islandNode[1] + dir[1];

                            if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == '1' && !visited[r][c]) {
                                visited[r][c] = true;
                                islandNodes.add(new int[]{r, c});
                            }
                        }
                    }
                }
            }
        }
        return islands;
    }
}
