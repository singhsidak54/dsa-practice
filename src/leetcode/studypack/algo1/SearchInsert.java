package algo1;

public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        int l = 0, h = nums.length - 1, m, ans = 0;
        while(l <= h) {
            m = (l + h)/2;
            if(nums[m] == target)
                return m;
            else if(nums[m] > target) {
                h = m - 1;
                ans = m;
            } else {
                l = m + 1;
                ans = m + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1,3,5,6};
        System.out.println(searchInsert(a, 9));
    }
}
