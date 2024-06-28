package Scaler.TwoPointer;

public class PairsWithGivenSumII {
    public static int solve(int[] A, int B) {
        int ans = 0, mod = 1_000_000_007;
        int l = 0, r = A.length - 1;
        while (l < r) {
            int sum = A[l] + A[r];
            if(sum == B) {
                if(A[l] == A[r]) {
                    int count = r - l + 1;
                    long curr = ((long)count * (count - 1)/2) % mod;
                    ans = (ans + (int)curr) % mod;
                    break;
                } else {
                    int L = l, R = r;
                    while (L + 1 < r && A[L] == A[L + 1]) {
                        L++;
                    }

                    while (R - 1 > l && A[R] == A[R - 1]) {
                        R--;
                    }

                    int lCount = L - l + 1, rCount = r - R + 1;
                    long curr = (lCount * (long)rCount) % mod;
                    ans = (ans + (int)curr) % mod;

                    l = L + 1;
                    r = R - 1;
                }
            } else if (sum < B) {
                l++;
            } else {
                r--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 9, 10};
        System.out.println(solve(A, 5));
    }
}
