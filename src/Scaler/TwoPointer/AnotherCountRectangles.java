package Scaler.TwoPointer;

public class AnotherCountRectangles {
    public static int solve(int[] A, int B) {
        int l = 0, r = A.length - 1;
        int count = 0, mod = 1_000_000_007;
        while (l < r) {
            while (l < r && ((long) A[l] * A[r] >= B)) {
                r--;
            }

            long curr = ((r - l) * 2L) % mod;
            count = (count + (int) curr) % mod;
            l++;
        }

        while (r >= 0) {
            long sum = (long)A[r] * A[r];

            if (sum < B) {
                count = (count + r + 1) % mod;
                break;
            }

            r--;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3,4,5};
        System.out.println(solve(A, 5));
    }
}
