package Scaler.Contest.AdvancedDSA4;

public class Q2 {
    public static int solve(final int[] A, final int B) {
        int sum = 0, count = 0;
        int start = 0, end = 0;

        while (end < A.length) {
            sum += A[end];

            while (sum > B) {
                sum -= A[start];
                start++;
            }

            if(sum == B) {
                count++;
            }

            end++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[] {3,2,1,4,1,5}, 5));
    }
}
