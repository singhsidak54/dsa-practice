package bs2;

public class MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold {
    public static boolean doesSquareExist(int[][] mat, int threshold, int len) {
        for(int i=len; i<mat.length; i++) {
            for(int j=len; j<mat[0].length; j++) {
                if(mat[i][j] - mat[i - len][j] - mat[i][j - len] + mat[i - len][j - len] <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int[][] sum = new int[m + 1][n + 1];

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + mat[i-1][j-1];
            }
        }

        int l = 0, r = Math.min(m, n), mid;
        while (l <= r) {
            mid = l + (r - l)/2;
            if(doesSquareExist(sum, threshold, mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(maxSideLength(
                new int[][] {{1,1,1,1},{1,0,0,0},{1,0,0,0},{1,0,0,0}},
                6
        ));
    }
}
