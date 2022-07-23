package bs2;

import java.util.Arrays;

public class MinimumAbsoluteSumDifference {
    public static int binarySearchPosition(int[] nums, int target) {
        int l = 0, r = nums.length, m;
        while (l < r) {
            m = l + (r - l)/2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }

    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        long ans = 0;
        int maxGain = 0;
        int[] nums1Sorted = nums1.clone();
        Arrays.sort(nums1Sorted);

        for(int i=0; i<nums1.length; i++) {
            int currDiff = Math.abs(nums1[i] - nums2[i]);
            ans += currDiff;

            if(currDiff > 0) {
                int idx = binarySearchPosition(nums1Sorted, nums2[i]);
                if(idx - 1 >= 0) {
                    maxGain = Math.max(maxGain, currDiff - Math.abs(nums1Sorted[idx - 1] - nums2[i]));
                }

                if(idx < nums1.length) {
                    maxGain = Math.max(maxGain, currDiff - Math.abs(nums1Sorted[idx] - nums2[i]));
                }
            }
        }

        return (int) ((ans - maxGain) % 1000000007);
    }

    public static void main(String[] args) {
        System.out.println(minAbsoluteSumDiff(new int[] {1,28,21}, new int[] {9,21,20}));
    }
}
