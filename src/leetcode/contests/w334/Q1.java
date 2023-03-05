package contests.w334;

public class Q1 {
    public int[] leftRigthDifference(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return nums;
        }

        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        int[] ans = new int[n];

        leftSum[0] = 0;
        int currSum = nums[0];
        for(int i=1; i<n; i++) {
            leftSum[i] = currSum;
            currSum += nums[i];
        }

        currSum = nums[n-1];
        rightSum[n-1] = 0;
        for(int i=n-2; i>=0; i--) {
            rightSum[i] = currSum;
            currSum += nums[i];
        }

        for(int i=0; i<n; i++) {
            ans[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return ans;
    }
}
