package Scaler.DP;

public class LongestIncreasingSubsequence {
    public int lis(final int[] A) {
        int n = A.length;
        int[] tails = new int[n];
        int size = 0;

        for (int curr : A) {
            int l = 0, r = size, m;
            while (l < r) {
                m = l + (r - l) / 2;
                if (tails[m] >= curr) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }

            tails[l] = curr;
            if (l == size) size++;
        }

        return size;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5};
        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
        System.out.println(obj.lis(arr));
    }
}
