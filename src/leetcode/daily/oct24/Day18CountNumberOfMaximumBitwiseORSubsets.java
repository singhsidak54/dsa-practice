package daily.oct24;

public class Day18CountNumberOfMaximumBitwiseORSubsets {
    int count, maxOr;

    public void helper(int currOr, int idx, int[] nums) {
        if(idx == nums.length) {
            if(currOr == maxOr) {
                count++;
            }
            return;
        }

        // add curr num
        helper(currOr | nums[idx],idx + 1, nums);

        // remove curr num
        helper(currOr, idx + 1, nums);
    }

    public int countMaxOrSubsets(int[] nums) {
        // find max or
        maxOr = 0;
        for(int num : nums) {
            maxOr = maxOr | num;
        }

        helper(0, 0, nums);

        return count;
    }

    public static void main(String[] args) {
        Day18CountNumberOfMaximumBitwiseORSubsets obj = new Day18CountNumberOfMaximumBitwiseORSubsets();
        int[] nums = {2,2,2};
        System.out.println(obj.countMaxOrSubsets(nums));
    }
}
