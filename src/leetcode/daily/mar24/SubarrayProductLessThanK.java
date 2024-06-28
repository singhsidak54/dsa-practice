package daily.mar24;

public class SubarrayProductLessThanK {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0, l = 0, r = 0, n = nums.length, currProduct = 1;
        while(r < n) {
            currProduct = currProduct * nums[r];
            while (l < r && currProduct >= k) {
                currProduct /= nums[l];
                l++;
            }
            if (currProduct < k) {
                ans += r - l + 1;
            }
            r++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        System.out.println(numSubarrayProductLessThanK(nums, 0));
    }
}
