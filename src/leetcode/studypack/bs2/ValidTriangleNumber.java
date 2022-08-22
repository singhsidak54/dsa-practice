package bs2;

import java.util.Arrays;

public class ValidTriangleNumber {
    // Using linear scan method
    public int triangleNumber(int[] nums) {
        if(nums.length < 3) return 0;
        Arrays.sort(nums);
        int count = 0;
        for(int i=0; i<nums.length-2; i++) {
            int k = i + 2;
            for(int j=i+1; j<nums.length-1 && nums[i] != 0; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k]) {
                    k++;
                }
                count += k - j - 1;
            }
        }

        return count;
    }

    //Using binary search method
    public int triangleNumber2(int[] nums) {
        if(nums.length < 3) return 0;
        Arrays.sort(nums);
        int count = 0;
        for(int i=0; i<nums.length-2; i++) {
            int k = i + 2;
            for(int j=i+1; j<nums.length-1 && nums[i] != 0; j++) {
                k = binarySearchJustGreater(nums, k, nums[i] + nums[j]);
                count += k - j - 1;
            }
        }

        return count;
    }

    public int binarySearchJustGreater(int[] nums, int start, int target) {
        int end = nums.length - 1, mid;
        while (start <= end) {
            mid = start + (end - start)/2;
            if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }
}
