package daily.nov22;

public class Day1WhereWillTheBallFall {
    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] ans = new int[n];

        for(int i=0; i<n; i++) {
            int currRow = 0, currCol = i;
            while (currRow < m) {
                if(currCol == 0 && grid[currRow][currCol] == -1) {
                    break;
                }

                if(currCol == n - 1 && grid[currRow][currCol] == 1) {
                    break;
                }

                if(grid[currRow][currCol] == 1 && grid[currRow][currCol + 1] == -1) {
                    break;
                }

                if(grid[currRow][currCol] == -1 && grid[currRow][currCol - 1] == 1) {
                    break;
                }

                currCol += grid[currRow][currCol];
                currRow++;
            }

            ans[i] = currRow == m ? currCol : -1;
        }

        return ans;
    }
}
