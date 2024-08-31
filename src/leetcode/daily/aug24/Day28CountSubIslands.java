package daily.aug24;

public class Day28CountSubIslands {
    int[][] dirs = {{1,0}, {-1,0}, {0, 1}, {0, -1}};

    public boolean isValid(int m, int n, int r, int c) {
        return m >= 0 && m < r && n >= 0 && n < c;
    }

    public boolean dfs(int[][] grid1, int[][] grid2, int row, int col) {
        if(!isValid(row, col, grid1.length, grid1[0].length)) return true;
        if(grid2[row][col] == 0) return true;

        grid2[row][col] = 0;
        boolean isSubIsland = grid1[row][col] == 1;
        for(int[] dir : dirs) {
            int r = row + dir[0], c = col + dir[1];
            isSubIsland = dfs(grid1, grid2, r, c) && isSubIsland;
        }

        return isSubIsland;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int subIslands = 0;
        for(int i=0; i<grid2.length; i++) {
            for(int j=0; j<grid2[0].length; j++) {
                if(grid2[i][j] == 1 && dfs(grid1, grid2, i, j)) {
                    subIslands++;
                }
            }
        }

        return subIslands;
    }

    public static void main(String[] args) {
        int[][] g1 = {{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}};
        int[][] g2 = {{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}};

        Day28CountSubIslands obj = new Day28CountSubIslands();
        System.out.println(obj.countSubIslands(g1, g2));
    }
}
