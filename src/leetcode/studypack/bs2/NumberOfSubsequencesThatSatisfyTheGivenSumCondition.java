package bs2;

import java.util.Arrays;

public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1, mod = (int)1e9 + 7;
        int[] pow = new int[nums.length];
        pow[0] = 1;
        for(int i=1; i< pow.length; i++) {
            pow[i] = pow[i - 1] * 2 % mod;
        }

        int res = 0;
        while (l <= r) {
            if(nums[l] + nums[r] <= target) {
                res = (res + pow[r - l]) % mod;
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
