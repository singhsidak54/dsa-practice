package ds2;

public class RotateImage {
    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i< (n + 1)/2; i++) {
            for(int j=0; j<n/2; j++) {
                int t = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-j][n-1-i];
                matrix[n-1-j][n-1-i] = matrix[j][n-1-i];
                matrix[j][n-1-i] = matrix[i][j];
                matrix[i][j] = t;
            }
        }
    }

    public void rotate2(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }

    private void reverse(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n/2; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = t;
            }
        }
    }

    private void transpose(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }
}
