package Scaler.Sorting;

public class MatrixMedian {

    public static int findMedian(int[][] A) {
        int max = Integer.MIN_VALUE;
        int m = A.length, n = A[0].length;
        int smallerReq = (m * n) / 2;
        for(int i=0; i<m; i++) {
            max = Math.max(max, A[i][n - 1]);
        }

        int l = 1, r = max, mid;
        while (l <= r) {
            mid = l + (r - l)/2;
            int countSmaller = 0;

            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(A[i][j] > mid) {
                        break;
                    }
                    countSmaller++;
                }
            }

            if(countSmaller > smallerReq) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}};
        System.out.println(findMedian(A));
    }
}
