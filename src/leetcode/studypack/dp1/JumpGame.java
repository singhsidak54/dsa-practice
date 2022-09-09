package dp1;

public class JumpGame {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;

        for(int i=nums.length-2; i>=0; i--) {
            for(int j=1; j<=nums[i] && j+i<nums.length; j++) {
                if(dp[j+i]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }

    public boolean canJump2(int[] nums) {
        int maxReached = 0;
        for(int i=0; i< nums.length; i++) {
            if(maxReached < i) return false;
            maxReached = Math.max(maxReached, i + nums[i]);
        }

        return maxReached >= nums.length - 1;
    }
}
