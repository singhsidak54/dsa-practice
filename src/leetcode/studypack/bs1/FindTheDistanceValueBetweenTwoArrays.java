package bs1;

import java.util.Arrays;

public class FindTheDistanceValueBetweenTwoArrays {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int res = 0;
        for(int i=0; i<arr1.length; i++) {
            if(notInRange(arr2, arr1[i] - d, arr1[i] + d)) {
                res++;
            }
        }
        return res;
    }

    public static boolean notInRange(int[] arr, int from, int to) {
        int low = 0, high = arr.length - 1, mid;
        while (low <= high) {
            mid = low + (high - low)/2;
            if(arr[mid] >= from && arr[mid] <= to) {
                return false;
            } else if (arr[mid] < from) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return true;
    }
}
