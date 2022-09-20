package lc75l2;

public class SearchInRotatedSortedArray {
    public static int findMindIndex(int[] nums) {
        int l = 0, r = nums.length - 1, m;

        while (l < r) {
            m = l + (r - l)/2;
            if(nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }

    public static int search(int[] nums, int target) {
        int rotation = findMindIndex(nums);

        int l = 0, r = nums.length - 1, m;
        while (l <= r) {
            m = l + (r - l)/2;
            int realM = (m + rotation) % nums.length;

            if(nums[realM] == target) {
                return realM;
            } else if(nums[realM] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }

    public boolean existAfter(int a, int b) {
        return a <= b;
    }

    public int search2(int[] nums, int target) {
        int l = 0, r = nums.length - 1, m;

        while (l <= r) {
            m = l + (r - l)/2;

            if(nums[m] == target) return m;

            boolean midInFirst = existAfter(nums[l], nums[m]);
            boolean targetInFirst = existAfter(nums[l], target);

            if(midInFirst ^ targetInFirst) {
                if(midInFirst) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                if(nums[m] < target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
