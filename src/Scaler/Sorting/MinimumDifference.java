package Scaler.Sorting;

import java.util.Arrays;

public class MinimumDifference {
    public static int searchInsert(int[] A, int B) {
        int l = 0, r = A.length, m;
        while(l < r) {
            m = l + (r - l)/2;
            if(A[m] < B) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }

    public static int solve(int A, int B, int[][] C) {
        for(int i=0; i<A; i++) {
            Arrays.sort(C[i]);
        }

        int minDiff = Integer.MAX_VALUE;
        for(int i=0; i<A-1; i++) {
            for(int j=0; j<B; j++) {
                int element = C[i][j];
                int insertPos = searchInsert(C[i+1], element);
                int possibleAns = insertPos == 0 ? Integer.MAX_VALUE : Math.abs(element - C[i+1][insertPos - 1]);

                if(insertPos != B) {
                    possibleAns = Math.min(possibleAns, Math.abs(element - C[i+1][insertPos]));
                }

                minDiff = Math.min(minDiff, possibleAns);
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
        int[][] C = {{8,4}, {6,8}};
        System.out.println(solve(2,2, C));
    }
}
