package dp1;

public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int res = nums[0], lMax = 0, rMax = 0, n = nums.length;
        for(int i=0; i<n; i++) {
            lMax = (lMax == 0 ? 1 : lMax) * nums[i];
            rMax = (rMax == 0 ? 1 : rMax) * nums[n - 1 - i];
            res = Math.max(res, Math.max(lMax, rMax));
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[] {2, 3, -2, 4}));
    }
}
