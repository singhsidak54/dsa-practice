package Scaler.Sorting;

import java.util.Arrays;

public class UniqueElements {
    public static int solve(int[] A) {
        Arrays.sort(A);

        int steps = 0;
        for(int i=1; i<A.length; i++) {
            if(A[i] <= A[i - 1]) {
                steps += A[i - 1] - A[i] + 1;
                A[i] = A[i - 1] + 1;
            }
        }

        return steps;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[] {2,4,5}));
    }
}
