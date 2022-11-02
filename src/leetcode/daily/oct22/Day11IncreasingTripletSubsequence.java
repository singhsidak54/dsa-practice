package daily.oct22;

public class Day11IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int first = nums[0], second = Integer.MAX_VALUE;

        for(int i=1; i<nums.length; i++) {
            if(nums[i] < first) {
                first = nums[i];
            } else if (nums[i] < second && nums[i] != first) {
                second = nums[i];
            } else if (nums[i] > second) {
                return true;
            }
        }

        return false;
    }
}
