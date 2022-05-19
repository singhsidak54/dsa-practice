package leetcode.studypack.algo1;

// Problem Link - https://leetcode.com/problems/house-robber/
public class HouseRobber {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if(nums.length == 1) return dp[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for(int i=2; i<nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,10,6};
        System.out.println(rob(nums));
    }
}
