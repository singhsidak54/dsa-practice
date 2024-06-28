package Scaler.Sorting;

import java.util.Arrays;

public class MaximumUnsortedSubarray {
    public static int[] subUnsort(int[] A) {
        int left = 0, right = A.length - 1;

        // find left point
        while(left < A.length - 1 && A[left] <= A[left + 1]) {
            left++;
        }

        if(left == A.length - 1 && A[right] >= A[right - 1]) {
            return new int[] {-1};
        }

        // find right point
        while(right > 0 && A[right] >= A[right - 1]) {
            right--;
        }

        // find min and max
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i=left; i<=right; i++) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }

        // find correct positions of min and max
        left = 0;
        right = A.length - 1;
        while(left < right && A[left] <= min) {
            left++;
        }

        while(right > left && A[right] >= max) {
            right--;
        }

        return new int[] { left, right };
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(subUnsort(new int[] {1, 3, 2, 4, 5})));
    }
}
