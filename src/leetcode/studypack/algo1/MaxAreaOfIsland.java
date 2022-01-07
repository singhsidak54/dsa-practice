package leetcode.studypack.algo1;

// Problem Link - https://leetcode.com/problems/max-area-of-island/
public class MaxAreaOfIsland {
    public static int calculateAreaOfLand(int[][] grid, int r, int c, boolean[][] visited) {
        if(visited[r][c]) return 0;
        int currArea = 1;
        visited[r][c] = true;
        if((r-1 >= 0) && grid[r-1][c] == 1)
            currArea += calculateAreaOfLand(grid, r - 1, c, visited);
        if((r+1 < grid.length) && grid[r+1][c] == 1)
            currArea += calculateAreaOfLand(grid, r + 1, c, visited);
        if((c-1 >= 0) && grid[r][c-1] == 1)
            currArea += calculateAreaOfLand(grid, r, c - 1, visited);
        if((c+1 < grid[0].length) && grid[r][c+1] == 1)
            currArea += calculateAreaOfLand(grid, r, c + 1, visited);
        return currArea;
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    int currArea = calculateAreaOfLand(grid, i, j, visited);
                    if(currArea > maxArea) {
                        maxArea = currArea;
                    }
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        System.out.println(maxAreaOfIsland(grid));
    }
}
