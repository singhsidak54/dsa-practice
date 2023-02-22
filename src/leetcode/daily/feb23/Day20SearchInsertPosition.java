package daily.feb23;

public class Day20SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length, m;
        while(l < r) {
            m = l + (r - l)/2;
            if(nums[m] == target) {
                return m;
            } else if(nums[m] > target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
