package bs2;

public class WaysToSplitArrayIntoThreeSubarrays {
    public int waysToSplit(int[] nums) {
        int mod = 1_000_000_007;
        for(int i=1; i<nums.length; i++) {
            nums[i] += nums[i-1];
        }
        int res = 0, n = nums.length;

        for(int i=0, j=0, k=0; i<n-2; i++) {
            while ((j <= i) || ((j<n-1) && nums[j] < nums[i] * 2)) {
                j++;
            }

            while ((k < j) || ((k<n) && nums[k] - nums[i] <= nums[n - 1] - nums[k])) {
                k++;
            }

            res = (res + k - j) % mod;
        }

        return res;
    }
}
