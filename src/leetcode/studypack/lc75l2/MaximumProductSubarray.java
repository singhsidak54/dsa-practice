package lc75l2;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE, leftMax = 1, rightMax = 1, n = nums.length;

        for(int i=0; i<n; i++) {
            leftMax = ((leftMax == 0) ? 1 : leftMax) * nums[i];
            rightMax = ((rightMax == 0) ? 1 : rightMax) * nums[n - i - 1];

            maxProduct = Math.max(maxProduct, Math.max(leftMax, rightMax));
        }
        return maxProduct;
    }
}
