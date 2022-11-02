package daily.oct22;

import java.util.Arrays;

public class Day8ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE, k = nums.length - 1;
        for(int i=0; i<nums.length-2; i++) {
            if(nums[i] == nums[i+1]) continue;
            for(int j=i+1; j<k; j++) {
                while (j+1 != k && nums[i] + nums[j] + nums[k] > target) {
                    k--;
                }
                int currSum = nums[i] + nums[j];
                if(k != nums.length - 1 && Math.abs(currSum + nums[k] - target) > Math.abs(currSum + nums[k + 1] - target)) {
                    currSum += nums[k + 1];
                } else {
                    currSum += nums[k];
                }

                if(currSum == target) return currSum;
                if(Math.abs(target - ans) > Math.abs(target - currSum)) {
                    ans = currSum;
                }
            }
        }

        return ans;
    }
}
