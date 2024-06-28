package Scaler.TwoPointer;

import java.util.Arrays;

public class SubarrayWithGivenSum {
    public static int[] solve(int[] A, int B) {
        int n = A.length;
        int start = 0, end = 0;
        long sum = 0;
        while(end < n) {
            sum += A[end];

            while(start <= end && sum > B) {
                sum -= A[start];
                start++;
            }
            
            if(sum == B) {
                int len = end - start + 1;
                int[] ans = new int[len];
                int ptr = 0;
                while(start <= end) {
                    ans[ptr++] = A[start++];
                }

                return ans;
            }

            end++;
        }

        return new int[] {-1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[] {1,2,3,4,5}, 5)));
    }
}
