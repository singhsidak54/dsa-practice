package bs1;

import java.util.Arrays;

public class CheckIfNAndItsDoubleExist {
    public boolean binarySearch(int[] arr, int index) {
        int target = arr[index] * 2;
        int l, h, m;
        if(arr[index] < 0) {
            l = 0;
            h = index - 1;
        } else {
            l = index + 1;
            h = arr.length - 1;
        }

        while (l <= h) {
            m = l + (h - l)/2;
            if (arr[m] == target) {
                return true;
            } else if (arr[m] > target) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++) {
            if(binarySearch(arr, i)) {
                return true;
            }
        }
        return false;
    }
}
