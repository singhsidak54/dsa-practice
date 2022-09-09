package dp1;

import java.util.Arrays;

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return combinationSumHelper(nums, target, dp);
    }

    public int combinationSumHelper(int[] nums, int target, int[] dp) {
        if(target == 0) {
            return 1;
        } else if (target < 0) {
            return 0;
        } else {
            if(dp[target] != -1) {
                return dp[target];
            }
            int ways = 0;
            for(int num : nums) {
                ways += combinationSumHelper(nums, target - num, dp);
            }
            dp[target] = ways;
            return ways;
        }
    }

    public int combinationSum4DP(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for(int i=0; i<=target; i++) {
            for(int num : nums) {
                if(i - num < 0) continue;
                dp[i] += dp[i-num];
            }
        }
        return dp[target];
    }
}
