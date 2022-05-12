package leetcode.studypack.algo1;

// Problem Link - https://leetcode.com/problems/binary-search/
public class BinarySearch {
    public static int search(int[] nums, int target) {
        int l = 0, h = nums.length - 1, m = 0;
        while(l <= h) {
            m = l + (h - l)/2;
            if(nums[m] == target)
                return m;
            else if(nums[m] > target) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {-1,0,3,5,9,12};
        System.out.println(search(a, 9));
    }
}
