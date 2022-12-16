package daily.dec22;

public class Day14HouseRobber {
    public int robDP(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[n-1];
    }

    public int robDPSpaceOptimised(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }

        int doublePrev = nums[0], prev = Math.max(doublePrev, nums[1]);

        for(int i=2; i<nums.length; i++) {
            int temp = prev;
            prev = Math.max(prev, doublePrev + nums[i]);
            doublePrev = temp;
        }

        return prev;
    }
}
