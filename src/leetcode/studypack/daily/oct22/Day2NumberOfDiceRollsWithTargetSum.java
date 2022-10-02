package daily.oct22;

import java.util.Arrays;

public class Day2NumberOfDiceRollsWithTargetSum {
    public static int numRollsToTargetHelper(int n, int k, int currentDice, int target, int[][] dp) {
        if(target == 0 && currentDice == n) {
            return 1;
        }

        if(target < 0 || currentDice == n) {
            return 0;
        }

        if(dp[currentDice][target] != -1) {
            return dp[currentDice][target];
        }

        int curr = 0, mod = (int)1e9 + 7;
        for(int i=1; i<=k; i++) {
            if(target - i < 0) break;
            curr = (curr + numRollsToTargetHelper(n, k, currentDice + 1, target - i, dp)) % mod;
        }

        dp[currentDice][target] = curr;
        return dp[currentDice][target];
    }

    public static int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n][target + 1];

        for(int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int mod = (int)1e9 + 7;
        int ways = numRollsToTargetHelper(n, k, 0, target, dp);
        return ways % mod;
    }
}
