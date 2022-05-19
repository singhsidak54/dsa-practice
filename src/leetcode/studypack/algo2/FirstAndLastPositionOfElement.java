package algo2;

import java.util.Arrays;

public class FirstAndLastPositionOfElement {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int l = 0, h = nums.length - 1, mid = 0;
        while(l <= h) {
            mid = (h-l)/2 + l;
            if(nums[mid] == target) {
                h = mid - 1;
                res[0] = mid;
            } else if (nums[mid] > target){
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        if(res[0] == -1) return res;
        l = 0;
        h = nums.length - 1;
        while(l <= h) {
            mid = (h-l)/2 + l;
            if(nums[mid] == target) {
                l = mid + 1;
                res[1] = mid;
            } else if (nums[mid] > target){
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {5,7,7,7,8,10};
        System.out.println(Arrays.toString(searchRange(a, 7)));
    }
}
