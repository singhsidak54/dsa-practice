package algo2;

public class PeakElement {
    public static int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1, mid;
        while(low < high) {
            mid = low + (high - low)/2;
            if(nums[mid] > nums[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 1, 0};
        System.out.println(findPeakElement(nums));
    }
}
