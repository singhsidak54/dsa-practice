package lc75l2;

public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[1] = nums[0];
        for(int i=1; i<n; i++) {
            dp[i+1] = Math.max(dp[i], dp[i-1] + nums[i]);
        }

        return dp[n];
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        int doublePrev = 0, prev = nums[0];

        for(int i=1; i<n; i++) {
            int temp = prev;
            prev = Math.max(prev, doublePrev + nums[i]);
            doublePrev = temp;
        }

        return prev;
    }
}
