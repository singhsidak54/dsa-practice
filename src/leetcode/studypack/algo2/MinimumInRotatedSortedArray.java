package algo2;

public class MinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int low = 0, high = nums.length - 1, mid;
        while(low < high) {
            mid = (high - low)/2 + low;
            if(nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return nums[low];
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(nums));
    }
}
