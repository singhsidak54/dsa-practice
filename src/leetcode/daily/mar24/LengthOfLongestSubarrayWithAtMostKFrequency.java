package daily.mar24;

import java.util.HashMap;

public class LengthOfLongestSubarrayWithAtMostKFrequency {
    public static int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int l = 0, r = 0, max = 0;
        while (r < nums.length) {
            int num = nums[r];
            count.put(num, count.getOrDefault(num, 0) + 1);
            while (count.get(num) > k) {
                int left = nums[l++];
                count.put(left, count.get(left) - 1);
            }
            max = Math.max(max, r - l + 1);
            r++;
        }

        return max;
    }

    public static int maxSubarrayLengthOptimised(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int l = 0, r = 0, charsWithFreqGreaterThanK = 0;
        while (r < nums.length) {
            int num = nums[r];
            count.put(num, count.getOrDefault(num, 0) + 1);
            if(count.get(num) == k + 1) {
                charsWithFreqGreaterThanK++;
            }

            if(charsWithFreqGreaterThanK > 0) {
                int left = nums[l++];
                count.put(left, count.get(left) - 1);
                if(count.get(left) == k) {
                    charsWithFreqGreaterThanK--;
                }
            }
            r++;
        }

        return nums.length - l;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3,1,2};
        System.out.println(maxSubarrayLengthOptimised(nums, 2));
    }
}
