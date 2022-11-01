package daily;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {
    public static int maximumUniqueSubarray(int[] nums) {
        int maxSum = nums[0], start = 0, currentSum = maxSum;
        int i = 1, n = nums.length;
        Set<Integer> set = new HashSet<>();
        set.add(nums[0]);
        while (i != n) {
            if(set.add(nums[i])) {
                currentSum += nums[i];
                maxSum = Math.max(maxSum, currentSum);
            } else {
                while (start != i) {
                    if(nums[start] == nums[i]) {
                        start++;
                        break;
                    }
                    currentSum -= nums[start];
                    set.remove(nums[start]);
                    start++;
                }
            }
            i++;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maximumUniqueSubarray(new int[] {5,2,1,2,5,2,1,2,5}));
    }
}
