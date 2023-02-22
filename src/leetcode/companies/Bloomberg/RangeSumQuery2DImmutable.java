package companies.Bloomberg;

public class RangeSumQuery2DImmutable {
    int[][] prefixSum;
    public RangeSumQuery2DImmutable(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        prefixSum = new int[m][n];
        for(int i=0; i<n; i++) {
            prefixSum[0][i] = matrix[0][i] + (i == 0 ? 0 : prefixSum[0][i-1]);
        }

        for(int i=1; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(j == 0) {
                    prefixSum[i][j] = prefixSum[i-1][j] + matrix[i][j];
                } else {
                    prefixSum[i][j] = prefixSum[i-1][j] + matrix[i][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = prefixSum[row2][col2];
        int sub1 = col1 == 0 ? 0 : prefixSum[row2][col1 - 1];
        int sub2 = row1 == 0 ? 0 : prefixSum[row1 - 1][col2];
        int add = row1 == 0 || col1 == 0 ? 0 : prefixSum[row1-1][col1-1];

        return total + add - sub1 - sub2;
    }
}
