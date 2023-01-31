package Scaler.Primer.Misc;

public class NextPermutation {
    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }

        int pivotIndex = i - 1;
        if(pivotIndex != 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[pivotIndex]) {
                j--;
            }

            int temp = nums[pivotIndex];
            nums[pivotIndex] = nums[j];
            nums[j] = temp;
        }

        reverse(nums, pivotIndex + 1);
    }
}
