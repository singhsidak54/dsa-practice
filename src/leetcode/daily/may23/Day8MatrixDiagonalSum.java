package daily.may23;

public class Day8MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        int start = 0, end = mat[0].length - 1;

        int sum = 0, row = 0;
        while (row < mat.length) {
            if(start == end) {
                sum += mat[row][start];
            } else {
                sum += mat[row][start] + mat[row][end];
            }

            start++;
            end--;
            row++;
        }

        return sum;
    }
}
