package ds1;

import java.util.Arrays;

// Problem Link - https://leetcode.com/problems/reshape-the-matrix/
public class ReshapeTheMatrix {
    public static  int[][] matrixReshape(int[][] mat, int r, int c) {
        int originalRows = mat.length;
        int originalCols = mat[0].length;
        if(originalRows == r && originalCols == c || originalRows * originalCols != r * c) {
            return mat;
        }

        int[][] reshapedMatrix = new int[r][c];
        int i = 0, j = 0, k = 0, l = 0;
        while(k < r) {
            l = 0;
            while(l < c) {
                if(j == mat[i].length) {
                    j = 0;
                    i++;
                }
                reshapedMatrix[k][l] = mat[i][j];
                j++;
                l++;
            }
            k++;
        }
        return reshapedMatrix;
    }

    public static void main(String[] args) {
        int[][] a = {{1,2,3,4}};
        int[][] ans =  matrixReshape(a, 2, 2);
        for(int[] row : ans) {
            for(int num : row) {
                System.out.print(num);
            }
            System.out.println();
        }
    }
}
