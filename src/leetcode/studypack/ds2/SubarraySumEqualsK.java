package ds2;

import java.util.HashMap;

public class SubarraySumEqualsK {
    //fails because nums array can contain negative numbers.
    public static int subarraySum(int[] nums, int k) {
        if(nums.length == 1)
            return nums[0] == k ? 1 : 0;
        int count = 0;
        int start = 0, currentSum = nums[0], i = 1;
        while (i < nums.length) {
            if(currentSum + nums[i] == k) {
                count++;
                currentSum += nums[i] - nums[start];
                start++;
                i++;
            } else if(currentSum + nums[i] > k) {
                currentSum -= nums[start];
                start++;
            } else {
                currentSum += nums[i];
                i++;
            }
        }
        return count;
    }

    //gives TLE
    public static int subarraySum2(int[] nums, int k) {
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            int cSum = 0;
            for(int j=i; j<nums.length; j++) {
                cSum += nums[j];
                if(cSum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int subarraySum3(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> sumOccurrencesMap = new HashMap<>();
        sumOccurrencesMap.put(0, 1);
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            count += sumOccurrencesMap.getOrDefault(sum - k, 0);
            sumOccurrencesMap.put(sum, sumOccurrencesMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {-1, -1, 1};
        System.out.println(subarraySum3(nums, 0));
    }
}
