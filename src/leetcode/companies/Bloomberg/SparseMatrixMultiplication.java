package companies.Bloomberg;

import java.util.ArrayList;

public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length, n = mat2[0].length, k = mat2.length;
        int[][] res = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int num = 0;
                for(int l=0; l<k; l++) {
                    num += mat1[i][l] * mat2[l][j];
                }
                res[i][j] = num;
            }
        }
        
        return res;
    }
}
