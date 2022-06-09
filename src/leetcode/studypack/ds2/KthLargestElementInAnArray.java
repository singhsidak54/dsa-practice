package ds2;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums) {
            pq.add(num);

            if(pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }

    //using quick select algorithm
    public int findKthLargest2(int[] nums, int k) {
        int requiredElementIndex = nums.length - k;
        int l = 0, h = nums.length - 1;
        while(l < h) {
            int partition = partition(nums, l, h);
            if(partition == requiredElementIndex) {
                return nums[requiredElementIndex];
            } else if(partition > requiredElementIndex) {
                h = partition - 1;
            } else {
                l = partition + 1;
            }
        }

        return nums[requiredElementIndex];
    }

    public int partition(int[] nums, int l, int h) {
        int pivot = nums[h], i = l, j = l;

        while(i < h) {
            if(nums[i] > pivot) {
                i++;
            } else {
                swap(nums, i, j);
                i++;
                j++;
            }
        }

        swap(nums, i, j);
        return j;
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
