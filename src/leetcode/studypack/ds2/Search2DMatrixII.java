package ds2;

public class Search2DMatrixII {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int i=0, j=0, rows = matrix.length, cols = matrix[0].length;
        while(i < rows && j < cols) {
            if(searchRow(matrix[i], j, target))
                return true;

            if(searchColumn(matrix, i + 1, j, target))
                return true;

            i++;
            j++;
        }
        return false;
    }

    public static boolean searchRow(int[] row, int start, int target) {
        int l=start, h=row.length-1, m;
        while(l <= h) {
            m = l + (h-l)/2;
            if(row[m] == target) {
                return true;
            } else if(row[m] > target) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }

    public static boolean searchColumn(int[][] matrix, int start, int column, int target) {
        int l=start, h=matrix.length-1, m;
        while(l <= h) {
            m = l + (h-l)/2;
            if(matrix[m][column] == target) {
                return true;
            } else if(matrix[m][column] > target) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length, i=0, j=cols-1;
        while(i < rows && j >= 0) {
            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j] < target)
                i++;
            else
                j--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(searchMatrix2(matrix, 5));
    }
}
