package daily.feb23.weekly;

import java.util.Arrays;

public class Week2WiggleSort {

    public void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public void wiggleSort(int[] nums) {
        for(int i=1; i<nums.length; i+=2) {
            if(i == nums.length - 1) {
                if(nums[i - 1] > nums[i]) {
                    swap(nums, i - 1, i);
                }
                return;
            }

            if(nums[i] >= nums[i + 1] && nums[i] >= nums[i - 1]) continue;

            if(nums[i + 1] > nums[i - 1]) {
                swap(nums, i + 1, i);
            } else {
                swap(nums, i - 1, i);
            }
        }
    }
}
