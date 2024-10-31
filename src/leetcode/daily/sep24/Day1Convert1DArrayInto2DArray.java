package daily.sep24;

import java.util.Arrays;

public class Day1Convert1DArrayInto2DArray {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(original.length > m * n || original.length < m * n) return new int[0][0];

        int[][] res = new int[m][n];
        int row = 0, col = 0;
        for (int j : original) {
            res[row][col] = j;

            col++;
            if (col == n) {
                row++;
                col = 0;
            }
        }

        return res;
    }

    public int[][] construct2DArrayMath(int[] original, int m, int n) {
        if(original.length > m * n || original.length < m * n) return new int[0][0];

        int[][] res = new int[m][n];
        for (int i=0; i<original.length; i++) {
            res[i/n][i%n] = original[i];
        }

        return res;
    }

    public static void main(String[] args) {
        Day1Convert1DArrayInto2DArray obj = new Day1Convert1DArrayInto2DArray();
        System.out.println(Arrays.deepToString(obj.construct2DArray(new int[] {1,2,3,4}, 4, 1)));
    }
}
