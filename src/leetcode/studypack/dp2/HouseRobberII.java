package dp2;

public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], dp[1]);
        // 0 to n-2
        for(int i=2; i<n-1; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        int ans = dp[n-2];
        dp[0] = 0;
        dp[1] = nums[1];
        // 1 to n-1
        for(int i=2; i<n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        ans = Math.max(ans, dp[n-1]);

        return ans;
    }
}
