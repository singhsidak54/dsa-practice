package patterns.amazon;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        int m = matrix.length, n = matrix[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int row : rows) {
            for(int j=0; j<n; j++) {
                matrix[row][j] = 0;
            }
        }

        for(int col : cols) {
            for(int j=0; j<m; j++) {
                matrix[j][col] = 0;
            }
        }
    }

    public void setZeroesOptimised(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean isCol = false;

        for(int i=0; i<m; i++) {
            if(matrix[i][0] == 0) {
                isCol = true;
            }

            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(matrix[0][0] == 0) {
            for(int i=0; i<n; i++) {
                matrix[0][i] = 0;
            }
        }

        if(isCol) {
            for(int i=0; i<m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
