package daily.oct24;

import java.util.*;

public class Day28LongestSquareStreakInAnArray {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> seen = new HashMap<>();
        int max = 1;

        for(int i=nums.length-1; i>=0; i--) {
            int num = nums[i];
            int currStreak = 1 + seen.getOrDefault(num * num, 0);

            max = Math.max(max, currStreak);

            seen.put(num, currStreak);
        }

        return max == 1 ? -1 : max;
    }

    public int longestSquareStreakOptimised(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for(int num : nums) {
            seen.add(num);
        }

        int max = 1;

        for (int num : nums) {
            int currentStreak = 0;
            long current = num;

            while (seen.contains((int) current)) {
                currentStreak++;
                if (current * current > 1e5) break;
                current *= current;
            }

            max = Math.max(max, currentStreak);
        }

        return max == 1 ? -1 : max;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,4,2};
        Day28LongestSquareStreakInAnArray obj = new Day28LongestSquareStreakInAnArray();
        System.out.println(obj.longestSquareStreakOptimised(nums));
    }
}
