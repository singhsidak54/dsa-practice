package ds1;

// Problem Link - https://leetcode.com/problems/maximum-subarray/
public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = maxSum;
        for (int i=1; i<nums.length; i++) {
            if(currSum < 0) {
                if(nums[i] > currSum)
                    currSum = nums[i];
            } else
                currSum += nums[i];
            if(currSum > maxSum) {
                maxSum = currSum;
            }
        }
        return maxSum;
    }

    public static int maxMidSum(int [] nums, int low, int mid, int high) {
        int leftSum = nums[mid];
        int currSum = leftSum;
        for(int i=mid-1; i>=low; i--) {
            currSum += nums[i];
            if(currSum > leftSum)
                leftSum = currSum;
        }

        int rightSum = nums[mid+1];
        currSum = rightSum;
        for(int i=mid+2; i<=high; i++) {
            currSum += nums[i];
            if(currSum > rightSum)
                rightSum = currSum;
        }

        return Math.max(leftSum + rightSum, Math.max(leftSum, rightSum));
    }

    public static int maxSubArrayRecursion(int [] nums, int low, int high) {
        if(low == high)
            return nums[low];

        int m = (low + high) / 2;
        return Math.max(
                Math.max(
                        maxSubArrayRecursion(nums, low, m),
                        maxSubArrayRecursion(nums, m + 1, high)),
                maxMidSum(nums, low, m, high));
    }
    public static int maxSubArray2(int [] nums) {
        return maxSubArrayRecursion(nums, 0, nums.length - 1);
    }
    public static void main(String[] args) {
        int[] a = {-2, 1, 5,6, -30};
        System.out.println(maxSubArray2(a));
    }
}
