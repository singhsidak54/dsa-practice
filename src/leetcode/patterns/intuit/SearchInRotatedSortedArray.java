package patterns.intuit;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, n = nums.length, m;
        while (l < r) {
            m = l + (r - l)/2;
            if(nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        int rotation = l;
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            m = l + (r - l)/2;
            int realM = (m + l) % n;
            if(nums[realM] == target) {
                return realM;
            } else if (nums[realM] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    public boolean inFirst(int[] nums, int first, int target) {
        return nums[first] <= target;
    }

    public int search2(int[] nums, int target) {
        int l = 0, r = nums.length - 1, m;
        while (l <= r) {
            m = l + (r - l)/2;

            if(nums[m] == target) {
                return m;
            }

            boolean midInFirst = inFirst(nums, l, nums[m]);
            boolean targetInFirst = inFirst(nums, l, target);

            if(midInFirst ^ targetInFirst) {
                if(midInFirst) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                if(nums[m] > target) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }

        return -1;
    }
}
