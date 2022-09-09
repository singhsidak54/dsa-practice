package dp1;

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3) return 0;
        int ans = 0, currDiff = nums[1] - nums[0], prevAns = 0;
        for(int i=2; i<nums.length; i++) {
            if(nums[i] - nums[i-1] == currDiff) {
                prevAns = prevAns + 1;
                ans += prevAns;
            } else {
                currDiff = nums[i] - nums[i-1];
                prevAns = 0;
            }
        }
        return ans;
    }
}
