package lc75l1;

import java.util.Arrays;

public class FindPivotIndex {
    public static int pivotIndex(int[] nums) {
        int rightSum = 0, leftSum = 0;

        for(int i=0; i<nums.length; i++) {
            rightSum += nums[i];
        }

        for(int i=0; i<nums.length; i++) {
            if(leftSum == rightSum - nums[i]) {
                return i;
            } else {
                leftSum += nums[i];
                rightSum -= nums[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[] {1,-1,4}));
    }
}
