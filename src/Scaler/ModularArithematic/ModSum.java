package Scaler.ModularArithematic;

import java.util.Arrays;

public class ModSum {
    public static int solve(int[] A) {
        Arrays.sort(A);
        int sum = 0, mod = 1_000_000_007, ans = 0, n = A.length;
        int[] prefixModSum = new int[n];
        for(int i=0; i<n; i++) {

        }
        for(int i=0; i<n; i++) {
            int leftSide = sum;
            int rightSide = A[i] * (n - i - 1);
            ans = (ans % mod + leftSide % mod + rightSide % mod) % mod;
            sum += A[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[] {1,2,3}));
    }
}
