package contests.bw98;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimumImpossibleOR {
    public static int minImpossibleOR(int[] nums) {
        Set<Integer> possible = new HashSet<>();
        Arrays.sort(nums);
        int curr = 0;
        for(int i=0; i<nums.length; i++) {
            curr = curr | nums[i];
            possible.add(curr);
            possible.add(nums[i]);
        }

        return 1;
    }

    public static void main(String[] args) {
        int[] nums = {5,8,3,2,1,4};
        System.out.println(minImpossibleOR(nums));
    }
}
