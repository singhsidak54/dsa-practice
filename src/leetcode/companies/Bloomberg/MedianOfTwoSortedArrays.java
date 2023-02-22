package companies.Bloomberg;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);

        int low = 0, high = n1;
        while (low <= high) {
            int m1 = low + (high - low)/2;
            int m2 = (n1 + n2 + 1)/2 - m1;

            int l1 = m1 == 0 ? Integer.MIN_VALUE : nums1[m1 - 1];
            int r1 = m1 == n1 ? Integer.MAX_VALUE : nums1[m1];
            int l2 = m2 == 0 ? Integer.MIN_VALUE : nums2[m2 - 1];
            int r2 = m2 == n2 ? Integer.MAX_VALUE : nums2[m2];

            if(l1 <= r2 && l2 <= r1) {
                return (n1 + n2) % 2 == 0 ? ((Math.max(l1, l2) + Math.min(r1, r2))/2.0) : (double) Math.max(l1, l2);
            } else if (l1 > r2) {
                high = m1 - 1;
            } else {
                low = m1 + 1;
            }
        }

        return 0.0;
    }

    public double findKthIndex(int[] n1, int[] n2, int l1, int r1, int l2, int r2, int k) {
        if(l1 > r1) {
            return n2[k - l1];
        } else if (l2 > r2) {
            return n1[k - l2];
        } else {
            int i1 = l1 + (r1 - l1)/2, i2 = l2 + (r2 - l2)/2;
            int m1 = n1[i1], m2 = n2[i2];
            if(i1 + i2 >= k) {
                if(m1 > m2) {
                    return findKthIndex(n1, n2, l1, i1 - 1, l2, r2, k);
                } else {
                    return findKthIndex(n1, n2, l1, r1, l2, i2 - 1, k);
                }
            } else {
                if(m1 > m2) {
                    return findKthIndex(n1, n2, l1, r1, i2 + 1, r2, k);
                } else {
                    return findKthIndex(n1, n2, i1 + 1, r1, l2, r2, k);
                }
            }
        }
    }
    public double findMedianSortedArraysSecondApproach(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if(len % 2 == 1) {
            return findKthIndex(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1, len/2);
        } else {
            double n1 = findKthIndex(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1, len/2);
            double n2 = findKthIndex(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1, len/2 - 1);
            return (n1 + n2)/2;
        }
    }
}
