package daily.dec22;

public class Day26JumpGame {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int maxJumpIndex = 0;
        for(int i=0; i<nums.length && i<=maxJumpIndex && maxJumpIndex<nums.length; i++) {
            maxJumpIndex = Math.max(maxJumpIndex, i + nums[i]);
        }

        return maxJumpIndex >= nums.length;
    }
}
