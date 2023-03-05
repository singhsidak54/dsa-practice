package Scaler.BitManipulation;

public class SmallestXorSum {
    public static int solve(int A, int B) {
        int X = A & B;
        return (A ^ X) + (B ^ X);
    }

    public static void main(String[] args) {
        System.out.println(solve(3,3));
    }
}
