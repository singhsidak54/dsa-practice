package Scaler.Sorting;

import java.util.Arrays;

public class SumTheDifference {
    public static int fastPow(int A, int B, int mod) {
        if(B == 0) {
            return 1;
        }

        long halfAns = fastPow(A, B/2, mod);
        if(B % 2 == 0) {
            return (int) ((halfAns%mod * halfAns%mod) % mod);
        } else {
            return (int) ((halfAns%mod * halfAns%mod * A%mod) % mod);
        }
    }

    public static int solve(int[] A) {
        Arrays.sort(A);
        long max = 0L, min = 0L, pow = 1L;
        int mod = 1_000_000_007, ans = 0, n = A.length;

        for(int i=0; i<n; i++) {
            max = (max + (A[i] * pow) % mod) % mod;
            min = (min + (A[n - i - 1] * pow) % mod) % mod;

            pow = (pow * 2) % mod;
        }

        return (int) (max - min + mod) % mod;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[] {5,4,2}));
    }
}
