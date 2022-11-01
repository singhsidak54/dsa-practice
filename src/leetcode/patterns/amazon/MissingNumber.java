package patterns.amazon;

import java.util.Arrays;

public class MissingNumber {
    public int missingNumber1(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length, m;
        while (l < r) {
            m = l + (r - l)/2;
            if(m < nums[m]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int reqSum = n * (n + 1)/2, currSum = 0;
        for(int num : nums) {
            currSum += num;
        }
        return reqSum - currSum;
    }

    public int missingNumber3(int[] nums) {
        int xor = 0;
        for(int i=0; i<nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ nums.length;
    }
}
