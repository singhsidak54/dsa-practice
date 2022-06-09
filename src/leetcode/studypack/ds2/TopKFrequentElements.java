package ds2;

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for(int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return countMap.get(o1) - countMap.get(o2);
            }
        });

        for(int num : countMap.keySet()) {
            pq.add(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[k];
        for(int i=k-1; i>=0; i--) {
            res[i] = pq.poll();
        }
        return res;
    }

    //using partition method
    public static int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int[] uniqueNums = new int[countMap.keySet().size()];
        int index = 0;
        for(int num : countMap.keySet()) {
            uniqueNums[index++] = num;
        }

        int l = 0, h = uniqueNums.length - 1, requiredIndex = uniqueNums.length - k;
        while (l < h) {
            int partitionIndex = partition(uniqueNums, l, h, countMap);
            if(partitionIndex == requiredIndex) {
                break;
            } else if (partitionIndex < requiredIndex) {
                l = partitionIndex + 1;
            } else {
                h = partitionIndex - 1;
            }
        }

        return Arrays.copyOfRange(uniqueNums, requiredIndex, uniqueNums.length);
    }

    public static int partition(int[] nums, int low, int high, Map<Integer, Integer> countMap) {
        Random random_num = new Random();
        int pivot_index = low + random_num.nextInt(high - low);
        int pivotFreq = countMap.get(nums[pivot_index]);
        int j = low;
        swap(nums, high, pivot_index);
        while (low < high) {
            if(countMap.get(nums[low]) < pivotFreq) {
                swap(nums, low, j);
                j++;
            }
            low++;
        }
        swap(nums, low, j);
        return j;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent2(new int[]{3, 0, 1, 0}, 1)));
    }
}
