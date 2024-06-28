package Scaler.Sorting;

import java.util.Arrays;

public class AddOrNot {
    public static int[] solve(int[] A, int B) {
        Arrays.sort(A);
        int maxCount = 0, maxElement = 0;
        int currentCount = 0;
        long sum = 0;
        int start = 0, end = 0;

        while (end < A.length) {
            long req = (long) A[end] * currentCount - sum;

            while (req > B) {
                sum -= A[start];
                start++;
                currentCount--;
                req = (long) A[end] * currentCount - sum;
            }

            currentCount++;
            sum += A[end];

            if(currentCount > maxCount) {
                maxCount = currentCount;
                maxElement = A[end];
            }
            end++;
        }

        return new int[] {maxCount, maxElement};
    }

    public static void main(String[] args) {
        int[] A = {3, 1, 2, 2, 1};
        System.out.println(Arrays.toString(solve(A, 3)));
    }
}
