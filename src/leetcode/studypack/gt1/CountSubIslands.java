package gt1;

public class CountSubIslands {
    public static boolean isValidPixel(int row, int col, int m, int n) {
        return (row >= 0 && row < m && col >= 0 && col < n);
    }
    public static boolean visit(int[][] grid1, int[][] grid2,int row, int col, boolean result) {
        if(isValidPixel(row, col, grid1.length, grid1[0].length)
                && grid2[row][col] == 1) {

            if(grid1[row][col] != 1) {
                result = false;
            }

            grid2[row][col] = 0;
            result = result & visit(grid1, grid2, row + 1, col, result);
            result = result & visit(grid1, grid2, row - 1, col, result);
            result = result & visit(grid1, grid2, row, col + 1, result);
            result = result & visit(grid1, grid2, row, col - 1, result);
        }

        return result;
    }

    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int subIslands = 0;
        for(int i=0; i<grid2.length; i++) {
            for(int j=0; j< grid2[i].length; j++) {
                if(grid2[i][j] == 1 && visit(grid1, grid2, i, j, true)) {
                    subIslands++;
                }
            }
        }

        return subIslands;
    }
}
