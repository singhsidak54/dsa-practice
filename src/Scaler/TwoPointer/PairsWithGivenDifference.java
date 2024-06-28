package Scaler.TwoPointer;

import java.util.Arrays;

public class PairsWithGivenDifference {
    public static int solve(int[] A, int B) {
        Arrays.sort(A);
        int i = 0, j = 0, count = 0;

        while(j < A.length) {
            while(i < j && A[j] - A[i] > B) {
                i++;
            }

            if(i != j && A[j] - A[i] == B) {
                count++;

                while (j + 1 < A.length && A[j] == A[j + 1]) {
                    j++;
                }

                while (i < j && A[i] == A[i + 1]) {
                    i++;
                }
            }

            j++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 1, 2, 2};
        System.out.println(solve(A, 0));
    }
}
