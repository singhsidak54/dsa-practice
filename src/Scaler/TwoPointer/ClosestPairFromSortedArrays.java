package Scaler.TwoPointer;

import java.util.Arrays;

public class ClosestPairFromSortedArrays {
    public static int[] solve(int[] A, int[] B, int C) {
        int n1 = A.length, n2 = B.length;
        int ans = Integer.MAX_VALUE, e1 = 0, e2 = 0;
        int l = 0, r = n2 - 1;

        while (l < n1 && r >= 0) {
            int sum = A[l] + B[r];
            if(Math.abs(sum - C) < ans) {
                ans = Math.abs(sum - C);
                e1 = A[l];
                e2 = B[r];
            } else if (Math.abs(sum - C) == ans && A[l] == e1) {
                e2 = B[r];
            }

            if(sum > C) {
                r--;
            } else {
                l++;
            }
        }

        return new int[] {e1, e2};
    }

    public static void main(String[] args) {
        int[] A = {1};
        int[] B = {2, 4};

        System.out.println(Arrays.toString(solve(A, B, 4)));
    }
}
