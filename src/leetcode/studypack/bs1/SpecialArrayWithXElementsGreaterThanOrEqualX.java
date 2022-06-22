package bs1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SpecialArrayWithXElementsGreaterThanOrEqualX {
    public static int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = 0, high = n - 1, mid;
        while (low <= high) {
            mid = low + (high - low)/2;
            if(nums[mid] >= n - mid && (mid == 0 || nums[mid - 1] < n - mid)) {
                return n - mid;
            } else if(nums[mid] < n - mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(specialArray(new int[] {3,6,7,7,0}));
    }
}
