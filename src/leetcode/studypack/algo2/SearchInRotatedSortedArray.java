package algo2;

public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int l = 0, h = nums.length - 1, m;
        while(l < h) {
            m = l + (h-l)/2;
            if(nums[m] > nums[h]) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        int rotation = l;
        l = 0;
        h = nums.length - 1;
        while(l <= h) {
            m = l + (h-l)/2;
            int realM = (m + rotation) % nums.length;
            if(nums[realM] == target) {
                return realM;
            } else if(nums[realM] > target) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));
    }
}
