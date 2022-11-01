package patterns.intuit;

import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums) {
            pq.add(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        return pq.poll();
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public int partition(int[] nums, int low, int high) {
        Random random = new Random();
        int pivot = low + random.nextInt(high - low);
        swap(nums, pivot, high);
        int j = low;
        while (low < high) {
            if(nums[low] < nums[high]) {
                swap(nums, low, j);
                j++;
            }
            low++;
        }
        swap(nums, j, high);
        return j;
    }

    public int findKthLargest2(int[] nums, int k) {
        int reqIndex = nums.length - k;
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int partitionIndex = partition(nums, low, high);
            if(partitionIndex == reqIndex) {
                return nums[reqIndex];
            } else if (partitionIndex < reqIndex) {
                low = partitionIndex + 1;
            } else {
                high = partitionIndex - 1;
            }

        }

        return nums[low];
    }

}
