package bs2;

import java.util.Arrays;

public class FindAPeakElementII {
    public static int findMaxCol(int[][] mat, int row) {
        int l = 1, r = mat[row].length, m = 0;
        while (l < r) {
            if(mat[row][l] > mat[row][m]) {
                m = l;
            }
            l++;
        }
        return m;
    }

    public static int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int l = 0, r = m, mid;
        while (l < r) {
            mid = l + (r - l)/2;
            int maxCol = findMaxCol(mat, mid);

            boolean topSide = mid == 0 || mat[mid - 1][maxCol] < mat[mid][maxCol];
            boolean bottomSide = mid == (mat.length - 1) || mat[mid + 1][maxCol] < mat[mid][maxCol];

            if(topSide && bottomSide) {
                return new int[] {mid, maxCol};
            } else if (topSide) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return new int[] {l, findMaxCol(mat, l)};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findPeakGrid(new int[][]{{47, 30, 35, 8, 25}, {6, 36, 19, 41, 40}, {24, 37, 13, 46, 5}, {3, 43, 15, 50, 19}, {6, 15, 7, 25, 18}})));
    }
}
