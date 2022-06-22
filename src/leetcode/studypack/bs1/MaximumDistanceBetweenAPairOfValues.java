package bs1;

public class MaximumDistanceBetweenAPairOfValues {
    public static int binarySearch(int[] nums, int e, int target) {
        int l = 0, m;
        e = Math.min(e, nums.length);
        while (l < e) {
            m = l + (e - l)/2;
            if(nums[m] > target) {
                l = m + 1;
            } else {
                e = m;
            }
        }

        if(nums[l] > target) {
            return -1;
        } else {
            return l;
        }
    }
    public int maxDistance(int[] nums1, int[] nums2) {
        int maxDist = 0;
        for(int i=0; i<nums2.length; i++) {
            int searchIndex = binarySearch(nums1, i, nums2[i]);
            if(searchIndex != -1) {
                maxDist = Math.max(maxDist, i - searchIndex);
            }
        }
        return maxDist;
    }

    public int maxDistance2(int[] nums1, int[] nums2) {
        int i = 0, j = 0, maxDist = 0;
        while (i < nums1.length && j < nums2.length) {
            if(nums1[i] > nums2[j]) {
                i++;
            } else {
                maxDist = Math.max(maxDist, j - i);
                j++;
            }
        }
        return maxDist;
    }
}
