package ps1;

import java.util.Arrays;

public class LargestPerimeterTriangle {
    public boolean isValid(int a, int b, int c) {
        return c < (a + b);
    }

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for(int i=nums.length-3; i>=0; i--) {
            if(isValid(nums[i], nums[i+1], nums[i+2])) {
                return nums[i] + nums[i+1] + nums[i+2];
            }
        }

        return 0;
    }
}
