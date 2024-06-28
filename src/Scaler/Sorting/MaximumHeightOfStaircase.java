package Scaler.Sorting;

public class MaximumHeightOfStaircase {
    public static int solve(int A) {
        long l = 0, r = A, m;
        while(l < r) {
            m = r - (r - l)/2;
            if((m * (m + 1)/2) > A) {
                r = m - 1;
            } else {
                l = m;
            }
        }

        return (int)l;
    }

    public static void main(String[] args) {
        System.out.println(solve(10));
    }
}
