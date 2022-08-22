package bs2;

public class ShortestSubarrayToBeRemovedToMakeArraySorted {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length, left = 0, right = n - 1;
        while (left < right && arr[left] <= arr[left + 1]) {
            left++;
        }

        if(left == right) return 0;

        while (right > left && arr[right] >= arr[right - 1]) {
            right--;
        }

        int ans = Math.min(n - left - 1, right);
        int i=0, j = right;
        while (i <= left && j < n) {
            if(arr[j] >= arr[i]) {
                ans = Math.min(ans, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }
}
