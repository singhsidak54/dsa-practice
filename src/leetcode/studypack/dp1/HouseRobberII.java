package dp1;

public class HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;
        if(nums.length == 1) return nums[0];

        int doublePrev = 0, prev = 0, ans;
        for(int i=0; i<=n-2; i++) {
            ans = doublePrev + nums[i];
            doublePrev = prev;
            prev = Math.max(ans, prev);
        }

        ans = prev;

        doublePrev = 0;
        prev = 0;
        for(int i=1; i<=n-1; i++) {
            int newAns = doublePrev + nums[i];
            doublePrev = prev;
            prev = Math.max(prev, newAns);
        }

        return Math.max(ans, prev);
    }
}
