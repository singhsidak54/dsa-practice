package bs1;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int l=0, h=nums.length-1,m;
        while (l < h) {
            m = l + (h - l)/2;
            if(nums[m] > nums[h]) {
                l = m + 1;
            } else {
                h = m;
            }
        }

        int rotation = l, realM;
        l = 0;
        h = nums.length - 1;
        while (l <= h) {
            m = l + (h - l)/2;
            realM = (m + rotation) % nums.length;
            if(nums[realM] == target) {
                return m;
            } else if (nums[realM] > target) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
