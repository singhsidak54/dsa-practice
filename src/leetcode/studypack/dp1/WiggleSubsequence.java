package dp1;

public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n < 2) return n;

        if(n == 2) {
            return nums[1] == nums[0] ? 1 : 2;
        }

        int prevDiff = nums[1] - nums[0];
        int count = prevDiff != 0 ? 2 : 1;

        for(int i=2; i<n; i++) {
            int diff = nums[i] - nums[i-1];

            if((diff > 0 && prevDiff <= 0) || (diff < 0 && prevDiff >= 0)) {
                count++;
                prevDiff = diff;
            }
        }

        return count;
    }
}
