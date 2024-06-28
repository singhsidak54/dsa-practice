package Scaler.DP;

public class CuttingARod {
    public int solve(int[] A) {
        int n = A.length;
        int[] dp = new int[n + 1];

        for(int i=1; i<=n; i++) {
            dp[i] = A[i - 1];
            for(int j=1; j<=(i + 1)/2; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + dp[j]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int[] prices = {3, 4, 1, 6, 2};
        CuttingARod obj = new CuttingARod();
        System.out.println(obj.solve(prices));
    }
}
