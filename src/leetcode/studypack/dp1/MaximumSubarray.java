package dp1;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for(int i=1; i<nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            if(dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }

    public int maxSubArray2(int[] nums) {
        int maxTillNow = nums[0], currentMax = nums[0];
        for(int i=1; i<nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            if(currentMax > maxTillNow) {
                maxTillNow = currentMax;
            }
        }

        return maxTillNow;
    }

    public int maxMidSum(int[] nums, int low, int mid, int high) {
        int ml = nums[mid], mr = 0, cl = ml, cr = 0; //maxLeft, maxRight, currentLeft, currentRight
        for(int i=mid-1; i>=low; i--) {
            cl += nums[i];
            if(cl > ml) {
                ml = cl;
            }
        }


        for(int i=mid+1; i<=high; i++) {
            cr += nums[i];
            if(cr > mr) {
                mr = cr;
            }
        }

        return Math.max(ml, ml + mr);
    }
    public int maxSubArrayRecursion(int[] nums, int low, int high) {
        if(low == high) {
            return nums[low];
        }

        int mid = low + (high - low)/2;
        int maxRight = maxSubArrayRecursion(nums, mid + 1, high);
        int maxLeft = maxSubArrayRecursion(nums, low, mid);

        return Math.max(Math.max(maxLeft, maxRight), maxMidSum(nums, low, mid, high));
    }
    public int maxSubArray3(int[] nums) {
        return maxSubArrayRecursion(nums, 0, nums.length - 1);
    }
}
