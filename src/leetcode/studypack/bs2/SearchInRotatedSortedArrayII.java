package bs2;

public class SearchInRotatedSortedArrayII {
    public static boolean existInFirst(int[] nums, int start, int target) {
        return nums[start] <= target;
    }
    public static boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid;
        while (start <= end) {
            mid = start + (end - start)/2;

            if(nums[mid] == target) {
                return true;
            }

            if(nums[start] == nums[mid]) {
                start++;
                continue;
            }

            boolean midInFirst = existInFirst(nums, start, nums[mid]);
            boolean targetInFirst = existInFirst(nums, start, target);

            if(midInFirst ^ targetInFirst) {
                if(midInFirst) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if(nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] {5,1,3}, 3));
    }
}
