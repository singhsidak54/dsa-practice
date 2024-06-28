package Scaler.Contest.AdvancedDSA2;

public class Q2 {
    public static int solve(int[] A, int B) {
        int l = 0, r = A.length, m;
        while (l < r) {
            m = l + (r - l)/2;
            int missing = A[m] - (m + 1);
            if(missing < B) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l + B;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[] {5,9,14,17,22,23,24,28,33,35}, 5));
    }
}
