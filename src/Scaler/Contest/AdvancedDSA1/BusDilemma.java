package Scaler.Contest.AdvancedDSA1;

public class BusDilemma {
    public static int solve(int[] A, int B) {
        int max = 0, min = B, sum = 0;
        for(int a : A) {
            sum += a;
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }

        if(min < 0) {
            B += min;
        }

        if(B < 0) {
            return 0;
        }

        for(int i=1; i<A.length; i++) {
            A[i] += A[i - 1];
        }

        return Math.max(B - max + 1, 0);
    }


    public static void main(String[] args) {
        System.out.println(solve(new int[] {-3, 2, -4, -1, -5}, 21));
    }
}
