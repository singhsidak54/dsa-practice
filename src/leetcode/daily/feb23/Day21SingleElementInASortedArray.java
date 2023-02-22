package daily.feb23;

public class Day21SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1, m;
        while(l < r) {
            m = l + (r - l)/2;
            if(m % 2 == 1) {
                m--;
            }

            if(nums[m] != nums[m + 1]) {
                r = m;
            } else {
                l = m + 2;
            }
        }

        return nums[l];
    }
}
