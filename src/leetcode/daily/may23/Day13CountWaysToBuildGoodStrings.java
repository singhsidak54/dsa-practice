package daily.may23;

import java.util.Arrays;

public class Day13CountWaysToBuildGoodStrings {
    int mod = (int)1e9 + 7;

    public int dfs(int low, int high, int zero, int one, int size, int[] dp) {
        if(size > high) return 0;
        if(dp[size] != -1) return dp[size];

        int count = 0;

        // add zero
        int zeroSize = size + zero;
        if(zeroSize >= low && zeroSize <= high) count++;
        count = (count + dfs(low, high, zero, one, zeroSize, dp)) % mod;

        // add one
        int oneSize = size + one;
        if(oneSize >= low && oneSize <= high) count++;
        count = (count + dfs(low, high, zero, one, oneSize, dp)) % mod;

        dp[size] = count;
        return dp[size];
    }

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        Arrays.fill(dp, -1);
        return dfs(low, high, zero, one, 0, dp);
    }
}
