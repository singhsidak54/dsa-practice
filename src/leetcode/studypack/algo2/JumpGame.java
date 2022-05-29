package algo2;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n-1] = true;
        for(int i=n-2; i>=0; i--) {
            for(int j=nums[i]; j>0; j--) {
                if(i + j >= n) continue;
                if(dp[i + j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

    public boolean canJump2(int[] nums) {
        int maxReached = 0;
        for(int i=0; i<nums.length; i++) {
            if(maxReached < i) return false;
            maxReached = Math.max(maxReached, i + nums[i]);
        }
        return maxReached >= nums.length - 1;
    }
}
