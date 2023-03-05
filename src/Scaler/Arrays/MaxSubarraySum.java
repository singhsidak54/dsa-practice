package Scaler.Arrays;

public class MaxSubarraySum {
    public static Long solve(int[][] A) {
        long ans = Long.MIN_VALUE;
        int n = A.length, m = A[0].length;

        for(int i=0; i<n; i++) {
            long[] curr = new long[m];

            for(int e=i; e<n; e++) {
                for(int j=0; j<m; j++) {
                    curr[j] += A[e][j];
                }

                Long currAns = kadanes(curr);
                ans = Math.max(ans, currAns);
            }
        }

        return ans;
    }

    public static Long kadanes(long[] nums) {
        long ans = Long.MIN_VALUE, curr = 0L;

        for (Long num : nums) {
            curr += num;

            if (curr > ans) {
                ans = curr;
            }

            if (curr < 0) {
                curr = 0L;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] A = {{-83, -73, -70, -61}, {-56, -48, -13, 4}, {38, 48, 71, 71}};
        System.out.println(solve(A));
    }
}
