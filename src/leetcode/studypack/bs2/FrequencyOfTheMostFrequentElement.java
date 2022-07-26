package bs2;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, res = 1;
        long sum = 0;

        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            while (sum + k < (long)nums[i] * (i - l + 1)) {
                sum -= nums[l];
                l++;
            }
            res = Math.max(res, i - l + 1);
        }

        return res;
    }
}
