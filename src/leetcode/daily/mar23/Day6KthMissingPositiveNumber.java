package daily.mar23;

public class Day6KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int l = 0, r = arr.length, mid;

        while(l < r) {
            mid = l + (r - l)/2;
            int missing = arr[mid] - (mid + 1);
            if(missing < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l + k;
    }
}
