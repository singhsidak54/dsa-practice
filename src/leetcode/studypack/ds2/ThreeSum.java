package ds2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void twoSum(int[] nums, int start, int reqSum, List<List<Integer>> result) {
        List<Integer> currResult;
        int end = nums.length - 1;
        while(start < end) {
            int currSum = nums[start] + nums[end];
            if(currSum == reqSum) {
                currResult = Arrays.asList(-reqSum, nums[start], nums[end]);
                result.add(currResult);
                while(start < end && nums[start] == currResult.get(1)) start++;
                while(start < end && nums[end] == currResult.get(2)) end--;
            } else if (currSum < reqSum) {
                start++;
            } else {
                end--;
            }
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<nums.length-2 && nums[i] <= 0; i++) {
            int reqSum = -nums[i];
            twoSum(nums, i+1, reqSum, result);
            while(i + 1 < nums.length && nums[i + 1] == nums[i])
                i++;

        }
        return result;
     }

    public static void main(String[] args) {
        int[] a = {0 ,0 ,0, 0};
        System.out.println(threeSum(a).toString());
    }
}
