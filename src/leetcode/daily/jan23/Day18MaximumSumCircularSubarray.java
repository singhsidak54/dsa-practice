package daily.jan23;

public class Day18MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] maxSuffixSum = new int[n];
        maxSuffixSum[n-1] = nums[n-1];
        int suffixSum = nums[n-1];
        for(int i=n-2; i>=0; i--) {
            suffixSum += nums[i];
            maxSuffixSum[i] = Math.max(maxSuffixSum[i+1], suffixSum);
        }

        int maxSum = Integer.MIN_VALUE, currSum = Integer.MIN_VALUE, specialSum = Integer.MIN_VALUE, prefixSum = 0;
        for(int i=0; i<n; i++) {
            currSum = Math.max(0, currSum) + nums[i];
            maxSum = Math.max(maxSum, currSum);

            prefixSum += nums[i];
            if(i + 1 < n) {
                specialSum = Math.max(specialSum, prefixSum + maxSuffixSum[i + 1]);
            }
        }

        return Math.max(maxSum, specialSum);
    }

    public int maxSubarraySumCircularMinSum(int[] nums) {
        int maxSum = nums[0], minSum = nums[0], currMax = 0, currMin = 0, total = 0;
        for(int num : nums) {
            currMax = Math.max(num, currMax + num);
            maxSum = Math.max(maxSum, currMax);

            currMin = Math.min(num, currMin + num);
            minSum = Math.min(minSum, currMin);

            total += num;
        }

        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}
