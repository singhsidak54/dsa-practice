package leetcode.studypack.algo1;

// Problem Link - https://leetcode.com/problems/house-robber/
public class HouseRobber {
    public static int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] res = new int[nums.length];
        res[0] = nums[0];
        res[1] = Math.max(res[0], nums[1]);
        for(int i=2; i<nums.length; i++) {
            res[i] = Math.max(res[i-1], nums[i] + res[i-2]);
        }
        return res[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,10,6};
        System.out.println(rob(nums));
    }
}
