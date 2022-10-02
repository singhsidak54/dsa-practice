package daily.oct22;

import java.util.Arrays;

public class Day2NumberOfDiceRollsWithTargetSum {
    public static int numRollsToTargetHelper(int n, int k, int target, int[][] dp) {
        if(target == 0 && n == 0) {
            return 1;
        }

        if(target < 0 || n == 0) {
            return 0;
        }

        if(dp[n][target] != -1) {
            return dp[n][target];
        }

        int curr = 0, mod = (int)1e9 + 7;
        for(int i=1; i<=k; i++) {
            if(target - i < 0) break;
            curr = (curr + numRollsToTargetHelper(n - 1, k, target - i, dp)) % mod;
        }

        dp[n][target] = curr;
        return dp[n][target];
    }

    public static int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];

        for(int i=0; i<=n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return numRollsToTargetHelper(n, k, target, dp);
    }
}
