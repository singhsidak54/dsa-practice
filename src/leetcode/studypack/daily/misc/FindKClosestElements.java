package daily;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, h = arr.length - 1;
        while (h - l + 1 != k) {
            if(Math.abs(arr[l] - x) > Math.abs(arr[h] - x)) {
                l++;
            } else {
                h--;
            }
        }

        List<Integer> res = new ArrayList<>();
        while (l <= h) {
            res.add(arr[l]);
            l++;
        }
        return res;
    }

    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int l = 0, r = arr.length - k, m;
        while (l < r) {
            m = l + (r - l)/2;
            if(x - arr[m] > arr[m + k] - x) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        List<Integer> res = new ArrayList<>();
        while (k != 0) {
            res.add(arr[l]);
            k--;
        }
        return res;
    }
}
