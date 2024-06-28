package Scaler.Sorting;

public class SingleElementInSortedArray {
    public static int solve(int[] A) {
        int l = 0, r = A.length - 1, m;

        while(l < r) {
            m = l + (r - l)/2;
            if(m % 2 == 1) m -= 1;

            if(A[m] != A[m + 1]) {
                r = m;
            } else {
                l = m + 2;
            }
        }

        return A[l];
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[] {1,2,2,3,3}));
    }
}
