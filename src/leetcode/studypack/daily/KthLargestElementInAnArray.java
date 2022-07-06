package daily;

import java.util.Random;

public class KthLargestElementInAnArray {
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static int partition(int[] nums, int low, int high) {
        Random random_num = new Random();
        int pivot_index = low + random_num.nextInt(high - low);
        swap(nums, high, pivot_index);
        int j = low;
        while(low < high) {
            if(nums[low] < nums[high]) {
                swap(nums, low, j);
                low++;
                j++;
            } else {
                low++;
            }
        }
        swap(nums, low, j);
        return j;
    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length, low = 0, high = n - 1, requiredIndex = n - k;
        while (low < high) {
            int partitionIndex = partition(nums, low, high);
            if(partitionIndex == requiredIndex) {
                return nums[partitionIndex];
            } else if (partitionIndex < requiredIndex) {
                low = partitionIndex + 1;
            } else {
                high = partitionIndex - 1;
            }
        }
        return nums[requiredIndex];
    }
}
