package daily.oct22;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Day26ContinuousSubarraySum {
    public boolean checkSubarraySumAttemptHelper(int[] nums, int index, int curr, int k, HashMap<Integer, HashMap<Integer, Boolean>> dp) {
        if(curr % k == 0) return true;
        if(index == nums.length) return false;

        if(dp.get(index).containsKey(curr)) {
            return dp.get(index).get(curr);
        }

        int required = (curr + nums[index]) % k;
        boolean ans = checkSubarraySumAttemptHelper(nums, index + 1, required, k, dp);
        dp.get(index).put(curr, ans);
        return ans;
    }

    public boolean checkSubarraySumAttempt(int[] nums, int k) {
        if(nums.length < 2) return false;
        HashMap<Integer, HashMap<Integer, Boolean>> dp = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            dp.put(i, new HashMap<>());
        }

        for(int i=0; i<nums.length-1; i++) {
            int required = (nums[i] + nums[i + 1]) % k;
            if(checkSubarraySumAttemptHelper(nums, i + 2, required, k, dp)) {
                return true;
            }
        }

        return false;
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int[] sums = new int[nums.length + 1];

        for(int i=1; i<=nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        Set<Integer> set = new HashSet<>();
        for(int i=2; i<=nums.length; i++) {
            set.add(sums[i-2] % k);
            if(set.contains(sums[i] % k)) {
                return true;
            }
        }

        return false;
    }

    public boolean checkSubarraySumSinglePass(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(!map.containsKey(sum % k)) {
                map.put(sum % k, i + 1);
            } else if (map.get(sum % k) < i) {
                return true;
            }
        }
        return false;
    }
}
