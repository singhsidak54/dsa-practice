package Scaler.DP;


public class FlipArray {

    public int solve(final int[] A) {
        int n = A.length;
        int sum = 0;
        for(int num : A) {
            sum += num;
        }

        int[] dp = new int[sum/2 + 1];
        for(int i=1; i<=sum/2; i++) {
            dp[i] = n;
            for (int k : A) {
                if (i - k >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - k]);
                }
            }
        }

        return dp[sum/2];
    }

    public static void main(String[] args) {
        int[] A = {15,10,6};
        FlipArray obj = new FlipArray();
        System.out.println(obj.solve(A));
    }
}
