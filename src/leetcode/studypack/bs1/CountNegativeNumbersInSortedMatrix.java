package bs1;

public class CountNegativeNumbersInSortedMatrix {
    public int countNegatives(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int negatives = 0, lastNegative = cols - 1;
        for(int i=0; i<rows; i++) {
            if(grid[i][0] < 0) {
                negatives += cols;
                continue;
            }

            if(grid[i][cols - 1] >= 0) {
                continue;
            }

            int l = 0, r = lastNegative, m;
            while (l < r) {
                m = l + (r - l)/2;
                if(grid[i][m] < 0) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }

            negatives += cols - l;
            lastNegative = l;
        }

        return negatives;
    }
}
