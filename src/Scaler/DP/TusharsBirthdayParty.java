package Scaler.DP;

public class TusharsBirthdayParty {
    public int knapsack(int capacity, int [] weights, int[] costs) {
        int[] dp = new int[capacity + 1];

        for(int i=1; i<=capacity; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j=0; j<weights.length; j++) {
                if(weights[j] > i) continue;
                if(dp[i - weights[j]] == Integer.MAX_VALUE) continue;

                dp[i] = Math.min(dp[i], costs[j] + dp[i - weights[j]]);
            }
        }

        return dp[capacity];
    }

    public int solve(final int[] A, final int[] B, final int[] C) {
        int cost = 0;
        for(int i=0; i<A.length; i++) {
            cost += knapsack(A[i], B, C);
        }

        return cost;
    }

    public static void main(String[] args) {
        int[] A = {2,4,6}, B = {2,1,3}, C = {2,5,3};
        TusharsBirthdayParty obj = new TusharsBirthdayParty();
        System.out.println(obj.solve(A, B, C));
    }
}
