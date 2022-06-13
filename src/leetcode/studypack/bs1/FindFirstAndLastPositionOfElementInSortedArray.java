package bs1;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums.length == 0) return res;
        int low = 0, high = nums.length - 1, mid;
        while (low < high) {
            mid = low + (high - low)/2;
            if(nums[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        if(nums[low] != target) return res;
        res[0] = low;
        high = nums.length - 1;

        while (low < high) {
            mid = low + (high - low)/2 + 1;
            if(nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] <= target) {
                low = mid;
            }
        }

        res[1] = low;
        return res;
    }


}
