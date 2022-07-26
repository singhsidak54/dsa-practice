package bs2;

public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int l = 0, r = nums.length - 1, m;
        boolean flag;

        while (r - l > 2) {
            m = l + (r - l)/2;
            flag = false;

            int elements = r - m;
            if(nums[m] == nums[m + 1]) {
                flag = true;
                elements--;
            }

            if(elements % 2 == 0) {
                if(flag) {
                    r = m - 1;
                } else {
                    r = m;
                }
            } else {
                if(flag) {
                    l = m;
                } else {
                    l = m + 1;
                }
            }
        }

        return nums[l] == nums[l + 1] ? nums[r] : nums[l];
    }

    public int singleNonDuplicate2(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid % 2 == 1) mid--;
            if (nums[mid] == nums[mid + 1]) {
                lo = mid + 2;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }
}
