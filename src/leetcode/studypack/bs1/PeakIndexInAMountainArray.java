package bs1;

public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 1, high = arr.length - 2, mid;
        while (low < high) {
            mid = low + (high - low)/2;
            if(arr[mid] > arr[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
