package Scaler.BinarySearch;

import java.util.Arrays;

public class SpecialInteger {

    public static boolean possible(int[] A, int len, int B) {
        long sum = 0;
        int start = 0, end = 0;
        for(; end<len; end++) {
            sum += A[end];
        }

        while (end < A.length) {
            if(sum > B) return false;
            sum = sum - A[start] + A[end];

            start++;
            end++;
        }

        return sum <= B;
    }

    public static int solve(int[] A, int B) {
        int l = 1, r = A.length, m;
        int ans = 0;
        while (l <= r) {
            m = l + (r - l)/2;
            if(possible(A, m, B)) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[] {5, 10, 20, 100, 105}, 130));
    }
}
