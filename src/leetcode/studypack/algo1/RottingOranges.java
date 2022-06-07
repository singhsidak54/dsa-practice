package algo1;

import java.util.LinkedList;
import java.util.Queue;

// Problem Link - https://leetcode.com/problems/rotting-oranges/
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int minTime = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        int[][] dirs = {{-1,0}, {1, 0}, {0, -1}, {0,1}};
        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean rotten = false;
            for(int i=0; i<size; i++) {
                int[] cell = queue.poll();
                for(int[] d : dirs) {
                    int r = cell[0] + d[0];
                    int c = cell[1] + d[1];
                    if(r<0 || c<0 || r>=rows || c>=cols || grid[r][c]!=1) continue;

                    grid[r][c] = 2;
                    rotten = true;
                    queue.offer(new int[] {r, c});
                }
            }
            if(rotten) minTime++;
        }

        for (int[] ints : grid) {
            for (int j = 0; j < cols; j++) {
                if (ints[j] == 1) return -1;
            }
        }
        return minTime;
    }
}
