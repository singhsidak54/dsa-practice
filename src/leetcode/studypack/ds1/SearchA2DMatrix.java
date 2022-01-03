package leetcode.studypack.ds1;

// Problem Link - https://leetcode.com/problems/search-a-2d-matrix/
public class SearchA2DMatrix {
    public static boolean searchRow(int[][] matrix, int row, int target) {
        int l=0, h = matrix[row].length - 1;
        while(l <= h) {
            int m = l + (h-l)/2;
            int cElem = matrix[row][m];
            if(cElem == target)
                return true;
            else if(cElem < target)
                l = m + 1;
            else
                h = m - 1;
        }
        return false;
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length - 1;
        int l = 0, h = rows - 1;
        while (l <= h) {
            int m = l + (h-l)/2;
            int rowStart = matrix[m][0];
            int rowEnd = matrix[m][cols];

            if(target >= rowStart && target <= rowEnd) {
                return searchRow(matrix, m, target);
            } else if (target >= rowEnd) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = {{1,2,5,7},{10,11,16,20},{23,30,34,60}};

        System.out.println(searchMatrix(a, 1));
    }
}
