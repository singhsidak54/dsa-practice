package bs2;

import java.util.Arrays;

public class SumOfMutatedArrayClosestToTarget {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int i=0, n = arr.length;
        while(i < n && target > arr[i] * (n - i)) {
            target -= arr[i];
            i++;
        }

        if(i == n) {
            return arr[n - 1];
        }

        int res = target/(n - i);

        if(Math.abs(target - res * (n - i)) < Math.abs(target - (res + 1) * (n - i))) {
            return res;
        }

        return res + 1;
    }
}
