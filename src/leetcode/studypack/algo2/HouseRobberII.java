package algo2;

public class HouseRobberII {
    public static int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        return Math.max(rob(nums, 0, n-2), rob(nums, 1, n-1));
    }

    public static int rob(int[] nums, int start, int end) {
        int prev = 0, doublePrev = 0;
        for(int i=start; i<=end; i++) {
            int current = nums[i] + doublePrev;
            doublePrev = prev;
            prev = Math.max(prev, current);
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(rob(arr, 0, 2));
    }
}
