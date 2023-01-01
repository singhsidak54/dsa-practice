package daily.dec22;

public class Day31UniquePathsIII {
    static int ans;

    public static void dfs(int[][] grid, int row, int col, int numEmpty) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] < 0) return;

        if(grid[row][col] == 2) {
            if(numEmpty == 0) ans++;
            return;
        }

        grid[row][col] = -3;
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        for(int[] dir : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];
            dfs(grid, r, c, numEmpty - 1);
        }
        grid[row][col] = 0;
    }

    public static int uniquePathsIII(int[][] grid) {
        ans = 0;
        int startX = 0, startY = 0, numEmpty = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 0) {
                    numEmpty++;
                }
            }
        }

        dfs(grid, startX, startY, numEmpty + 1);
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,0,0}, {0,0,0,0}, {0,0,2,-1}};
        System.out.println(uniquePathsIII(grid));
    }
}
