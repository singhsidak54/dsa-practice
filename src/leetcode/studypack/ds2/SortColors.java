package ds2;

import java.util.Arrays;

public class SortColors {
    public static void sortColors(int[] nums) {
        if(nums.length == 1) return;
        int zeroIndex = 0;
        while(zeroIndex < nums.length && nums[zeroIndex] == 0) {
            zeroIndex++;
        }

        int twoIndex = nums.length - 1;
        while(twoIndex > 0 && nums[twoIndex] == 2) {
            twoIndex--;
        }

        int idx = zeroIndex;
        while(idx <= twoIndex) {
            if(nums[idx] == 2) {
                nums[idx] = nums[twoIndex];
                nums[twoIndex--] = 2;
            } else if (nums[idx] == 0) {
                nums[idx++] = nums[zeroIndex];
                nums[zeroIndex++] = 0;
            } else {
                idx++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 1, 0};
        sortColors(a);
        System.out.println(Arrays.toString(a));
    }
}
