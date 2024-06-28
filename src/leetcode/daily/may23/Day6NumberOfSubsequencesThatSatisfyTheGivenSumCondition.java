package daily.may23;

import java.util.Arrays;

public class Day6NumberOfSubsequencesThatSatisfyTheGivenSumCondition {
    public int searchInsertPosition(int[] nums, int target) {
        int l = 0, r = nums.length, m;
        while (l < r) {
            m = l + (r - l)/2;
            if(nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    public int numSubseq(int[] nums, int target) {
        int count = 0, mod = (int)1e9 + 7;
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++) {
            int req = target - nums[i];
            count = (count + searchInsertPosition(nums, req)) % mod;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3,5,6,7};
        Day6NumberOfSubsequencesThatSatisfyTheGivenSumCondition obj = new Day6NumberOfSubsequencesThatSatisfyTheGivenSumCondition();
        System.out.println(obj.numSubseq(nums, 9));
    }
}
