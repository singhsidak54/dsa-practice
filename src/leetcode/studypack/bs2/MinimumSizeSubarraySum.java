package bs2;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int cSum = 0;
        int l = 0, r = 0;
        while (r < nums.length) {
            cSum += nums[r];
            while (cSum >= target && l <= r) {
                minLen = Math.min(minLen, r - l + 1);
                cSum -= nums[l];
                l++;
            }
            r++;
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
