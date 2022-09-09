package dp1;

public class MaximumLengthOfSubarrayWithPositiveProduct {
    public int getMaxLen(int[] nums) {
        int maxLen = 0, currLen = 0, currLenWithNegative = 0;

        for(int num : nums) {
            if(num == 0) {
                currLen = 0;
                currLenWithNegative = 0;
            } else if (num > 0) {
                currLen++;
                currLenWithNegative = currLenWithNegative == 0 ? 0 : currLenWithNegative + 1;
            } else {
                int temp = currLen;
                currLen = currLenWithNegative == 0 ? 0 : currLenWithNegative + 1;
                currLenWithNegative = temp + 1;
            }

            maxLen = Math.max(maxLen, currLen);
        }

        return maxLen;
    }
}
