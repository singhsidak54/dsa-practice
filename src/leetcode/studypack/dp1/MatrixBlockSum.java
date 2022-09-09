package dp1;

public class MatrixBlockSum {

    public static int sumRegion(int[][] prefix, int row1, int col1, int row2, int col2) {
        return prefix[row2 + 1][col2 + 1] - prefix[row2 + 1][col1] - prefix[row1][col2 + 1] + prefix[row1][col1];
    }

    public static int[][] matrixBlockSum(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] prefix = new int[m+1][n+1];

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + matrix[i-1][j-1];
            }
        }

        int[][] ans = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int startRow = Math.max(0, i - k), endRow = Math.min(i + k, m-1);
                int startCol = Math.max(0, j - k), endCol = Math.min(j + k, n-1);
                ans[i][j] = sumRegion(prefix, startRow, startCol, endRow, endCol);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};

        System.out.println(matrixBlockSum(mat, 1));
    }
}
