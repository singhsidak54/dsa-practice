package dp1;

public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = nums[0], currMax = 0, minSum = nums[0], currMin = 0, total = 0;
        for(int i=0; i<nums.length; i++) {
            currMax = Math.max(nums[i], currMax + nums[i]);
            maxSum = Math.max(maxSum, currMax);

            currMin = Math.min(currMin + nums[i], nums[i]);
            minSum = Math.min(currMin, minSum);

            total += nums[i];
        }

        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }

    public int maxSubarraySumCircular2(int[] nums) {
        int n = nums.length;
        int[] maxDP = new int[n], minDP = new int[n];
        maxDP[0] = nums[0];
        minDP[0] = nums[0];
        int total = nums[0], max = maxDP[0], min = minDP[0];

        for(int i=1; i<n; i++) {
            maxDP[i] = nums[i] + Math.max(0, maxDP[i-1]);
            max = Math.max(max, maxDP[i]);

            minDP[i] = nums[i] + Math.min(0, minDP[i-1]);
            min = Math.min(min, minDP[i]);
            total += nums[i];
        }

        return max > 0 ? Math.max(max, total - min) : max;
    }


}
