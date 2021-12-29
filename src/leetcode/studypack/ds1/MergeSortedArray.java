package leetcode.studypack.ds1;

import java.util.Arrays;

// Problem Link - https://leetcode.com/problems/merge-sorted-array/
public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m+n];
        int k = 0;
        int i=0, j=0;

        while(i<m && j<n) {
            if(nums1[i] < nums2[j]) {
                temp[k++] = nums1[i++];
            } else {
                temp[k++] = nums2[j++];
            }
        }

        while(i<m) {
            temp[k++] = nums1[i++];
        }

        while(j<n) {
            temp[k++] = nums2[j++];
        }

        for(i=0; i<temp.length; i++) {
            nums1[i] = temp[i];
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, k = m+n-1;
        while(i>=0 && j>=0) {
            if(nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }

        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,0,0,0};
        int[] b = {2,5,6};
        merge2(a, 3, b, 3);
        System.out.println(Arrays.toString(a));
    }
}
