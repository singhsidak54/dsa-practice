package daily.oct22;

public class Day31ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for(int i=m-2; i>=0; i--) {
            for(int j=0; j<n-1; j++) {
                if(matrix[i][j] != matrix[i+1][j+1]) {
                    return false;
                }
            }
        }

        return true;
    }
}
