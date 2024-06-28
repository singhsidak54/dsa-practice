package Scaler.DP;

import java.util.Arrays;

public class Knapsack {
    public int knapsack(int[] value, int[] weight, int idx, int capacity, int[][] dp) {
        if(idx == value.length || capacity <= 0) return 0;

        if(dp[idx][capacity] != -1) return dp[idx][capacity];

        // not pick
        int maxValue = knapsack(value, weight, idx + 1, capacity, dp);

        // pick
        if(weight[idx] <= capacity) {
            maxValue = Math.max(maxValue, knapsack(value, weight, idx + 1, capacity - weight[idx], dp) + value[idx]);
        }

        dp[idx][capacity] = maxValue;
        return dp[idx][capacity];
    }

    public int solve(int[] A, int[] B, int C) {
        int[][] dp = new int[A.length][C + 1];
        for(int i=0; i<A.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return knapsack(A, B, 0, C, dp);
    }
}
