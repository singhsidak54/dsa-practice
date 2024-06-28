package dp2;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE, currSum = 0;
        for(int i=0; i<nums.length; i++) {
            currSum = Math.max(0, currSum) + nums[i];
            ans = Math.max(ans, currSum);
        }

        return ans;
    }
}
