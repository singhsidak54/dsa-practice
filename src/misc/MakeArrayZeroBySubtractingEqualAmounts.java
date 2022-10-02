package misc;

import java.util.Arrays;
import java.util.HashSet;

public class MakeArrayZeroBySubtractingEqualAmounts {
    public static int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int operations = 0, currDiff = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == currDiff) continue;
            currDiff = nums[i];
            operations++;
        }

        return operations;
    }

    public static int minimumOperationsBetter(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(num != 0) {
                set.add(num);
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[] {0}));
    }
}
