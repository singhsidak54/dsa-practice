package bs2;

public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int l=0, h = nums.length - 1, m;
        while (l < h) {
            m = l + (h - l)/2;
            if(nums[m] > nums[h]) {
                l = m + 1;
            } else if (nums[m] < nums[h]) {
                h = m;
            } else {
                if(h != 0 && nums[h] >= nums[h - 1]) {
                    h--;
                } else {
                    return nums[h];
                }
            }
        }
        return nums[l];
    }
}
