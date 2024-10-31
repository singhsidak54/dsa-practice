package daily.oct24;

import java.util.HashMap;

public class Day3MakeSumDivisibleByP {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for(int num : nums) {
            sum += num;
        }

        if (sum < p) return -1;
        int extraSum = (int)(sum % p);
        if (extraSum == 0) return 0;

        HashMap<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, -1);
        int ans = nums.length, currentSum = 0;
        for(int i=0; i<nums.length; i++) {
            currentSum = (currentSum + nums[i]) % p;

            int needed = (currentSum - extraSum + p) % p;
            if (modMap.containsKey(needed)) {
                ans = Math.min(ans, i - modMap.get(needed));
            }

            modMap.put(currentSum, i);
        }


        return ans == nums.length ? -1 : ans;
    }

    public static void main(String[] args) {
        Day3MakeSumDivisibleByP obj = new Day3MakeSumDivisibleByP();
        int[] nums = {26,19,11,14,18,4,7,1,30,23,19,8,10,6,26,3};
        System.out.println(obj.minSubarray(nums, 26));
    }
}
