package daily.sep24;

public class Day14LongestSubarrayWithMaximumBitwiseAND {
    public int longestSubarray(int[] nums) {
        if(nums.length == 0) return 0;
        int currentSteak = 1, maxAnd = nums[0], ans = 1;
        for (int num : nums) {
            if (num > maxAnd) {
                maxAnd = num;
                ans = 0;
                currentSteak = 0;
            }

            if (num == maxAnd) {
                currentSteak++;
            } else {
                currentSteak = 0;
            }

            ans = Math.max(ans, currentSteak);
        }

        return ans;
    }

    public static void main(String[] args) {
        Day14LongestSubarrayWithMaximumBitwiseAND obj = new Day14LongestSubarrayWithMaximumBitwiseAND();
        System.out.println(obj.longestSubarray(new int[] {96317,96317,96317,96317,96317,96317,96317,96317,96317,279979}));
    }
}
