package leetcode.studypack.random;

import java.util.Arrays;

// Problem Link - https://leetcode.com/problems/bricks-falling-when-hit/
public class BricksFallingWhenHit {
    public static void updateGridStabilityHelper(int[][] grid, boolean[][] stable, boolean[][] visited, int row, int col) {
        visited[row][col] = true;
        if(row == 0)
            stable[row][col] = true;

        if((row - 1 == 0) && grid[row-1][col] == 1) {
        }
    }

    public static void updateGridStability(int[][] grid, boolean[][] stable) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    updateGridStabilityHelper(grid, stable, visited, i, j);
                }
            }
        }
    }

    public static int calculateBricksFell(int[][] grid, int row, int col) {
        int bricksFell = 0;
        grid[row][col] = 0;

        boolean[][] updatedStability = new boolean[grid.length][grid[row].length];
        updateGridStability(grid, updatedStability);
        return bricksFell;
    }

    public static int[] hitBricks(int[][] grid, int[][] hits) {
        int[] res = new int[hits.length];

        for(int i=0; i<hits.length; i++) {
            int row = hits[i][0];
            int col = hits[i][1];

            if(grid[row][col] == 0)
                res[i] = 0;
            else
                res[i] = calculateBricksFell(grid, row, col);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,0,0},{1,1,1,0}};
        int[][] hits = {{1,0}};
        System.out.println(Arrays.toString(hitBricks(grid, hits)));
    }
}
