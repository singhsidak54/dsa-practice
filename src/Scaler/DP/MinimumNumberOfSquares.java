package Scaler.DP;

public class MinimumNumberOfSquares {
    public int countMinSquares(int A) {
        int[] dp = new int[A + 1];
        dp[1] = 1;
        dp[0] = 0;

        for(int i=2; i<=A; i++) {
            dp[i] = i;
            for(int j=0; j*j<=i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j*j]);
            }
        }

        return dp[A];
    }

    public static void main(String[] args) {
        MinimumNumberOfSquares obj = new MinimumNumberOfSquares();
        System.out.println(obj.countMinSquares(12));
    }
}
