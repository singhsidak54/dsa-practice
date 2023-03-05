package daily.mar23;

import java.util.Arrays;
import java.util.Random;

public class Day1SortAnArray {

    Random random;
    public int partition(int[] nums, int left, int right) {
        int pivotIdx = random.nextInt(right - left);
        int pivot = nums[left + pivotIdx];
        nums[left + pivotIdx] = nums[right];
        nums[right] = pivot;
        int j = left, i = left;
        while (i < right) {
            if(nums[i] < pivot) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
            i++;
        }

        nums[right] = nums[j];
        nums[j] = pivot;

        return j;
    }

    public void quickSort(int[] nums, int left, int right) {
        if(left >= right) {
            return;
        }

        int partitionIndex = partition(nums, left, right);

        quickSort(nums, left, partitionIndex - 1);
        quickSort(nums, partitionIndex + 1, right);
    }
    public int[] sortArray(int[] nums) {
        random = new Random();
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void main(String[] args) {
        Day1SortAnArray obj = new Day1SortAnArray();
        int[] nums = {1,2,3,4,5};
        System.out.println(Arrays.toString(obj.sortArray(nums)));
    }
}
