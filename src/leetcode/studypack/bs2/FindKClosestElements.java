package bs2;

import java.util.*;
import java.util.stream.Collectors;

public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0, end = arr.length - k, mid;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (x > (arr[mid] + (arr[mid + k] - arr[mid]) / 2)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return Arrays.stream(arr, start, start + k).boxed().collect(Collectors.toList());
    }

    public static int findClosestElement(int[] arr, int x) {
        if(arr.length == 1) return 0;
        int start = 0, end = arr.length - 1, mid;
        while (end - start != 1) {
            mid = start + (end - start) / 2;
            if(arr[mid] == x) {
                return mid;
            } else if(arr[mid] > x) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return Math.abs(arr[start] - x) <= Math.abs(arr[end] - x) ? start : end;
    }
    public static List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int closestElementIndex = findClosestElement(arr, x);
        int start = closestElementIndex, end = closestElementIndex;
        int nCloser = 1;
        while(k > nCloser) {
            if(start - 1 >= 0 && end + 1 < arr.length) {
                if(Math.abs(arr[start - 1] - x) <= Math.abs(arr[end + 1] - x)) {
                    start--;
                } else {
                    end++;
                }
            } else if (start - 1 >= 0) {
                start -= k - nCloser;
                break;
            }
            nCloser++;
        }

        return Arrays.stream(arr, start, start + k).boxed().collect(Collectors.toList());
    }

    public List<Integer> findClosestElements3(int[] arr, int k, int x) {
        int l = 0, r = arr.length - k, m;
        while (l < r) {
            m = l + (r - l)/2;
            if(x - arr[m] > arr[m + k] - x) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return Arrays.stream(arr, l, l + k).boxed().collect(Collectors.toList());
    }
    public static void main(String[] args) {
        System.out.println(findClosestElements2(new int[] {1}, 1, 0));
    }
}