package bs2;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int cSum = 0;
        int l = 0, r = 0;
        while (r < nums.length) {
            cSum += nums[r];
            while (cSum >= target && l <= r) {
                minLen = Math.min(minLen, r - l + 1);
                cSum -= nums[l];
                l++;
            }
            r++;
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public int binarySearchJustGreater(int[] nums, int target) {
        int l=0, h = nums.length, m;
        while (l < h) {
            m = l + (h - l)/2;
            if(nums[m] < target) {
                l = m + 1;
            } else {
                h = m;
            }
        }

        return l;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int[] sums = new int[nums.length + 1];

        for(int i=1; i<=nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        int minLen = Integer.MAX_VALUE;

        for(int i=1; i<sums.length; i++) {
            int newTarget = target + sums[i - 1];
            int justGreaterIndex = binarySearchJustGreater(sums, newTarget);
            if(justGreaterIndex != sums.length) {
                minLen = Math.min(minLen, justGreaterIndex - i + 1);
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
