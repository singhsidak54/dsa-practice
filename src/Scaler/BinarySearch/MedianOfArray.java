package Scaler.BinarySearch;

import java.util.List;

public class MedianOfArray {
    public double findKthIndex(final List<Integer> a, final List<Integer> b, int l1, int r1, int l2, int r2, int k) {
        if(l1 > r1) {
            return b.get(k - l1);
        } else if (l2 > r2) {
            return a.get(k - l2);
        } else {
            int i1 = l1 + (r1 - l1)/2, i2 = l2 + (r2 - l2)/2;
            int m1 = a.get(i1), m2 = b.get(i2);
            if(i1 + i2 >= k) {
                if(m1 > m2) {
                    return findKthIndex(a, b, l1, i1 - 1, l2, r2, k);
                } else {
                    return findKthIndex(a, b, l1, r1, l2, i2 - 1, k);
                }
            } else {
                if(m1 > m2) {
                    return findKthIndex(a, b, l1, r1, i2 + 1, r2, k);
                } else {
                    return findKthIndex(a, b, i1 + 1, r1, l2, r2, k);
                }
            }
        }
    }
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int len = a.size() + b.size();
        if(len % 2 == 1) {
            return findKthIndex(a, b, 0, a.size() - 1, 0, b.size() - 1, len/2);
        } else {
            double n1 = findKthIndex(a, b, 0, a.size() - 1, 0, b.size() - 1, len/2);
            double n2 = findKthIndex(a, b, 0, a.size() - 1, 0, b.size() - 1, len/2 - 1);
            return (n1 + n2)/2;
        }
    }
}
