package bs2;

public class FindLatestGroupOfSizeM {
    public int findLatestStep(int[] arr, int m) {
        int[] len = new int[arr.length + 2];
        int[] count = new int[arr.length + 1];
        int n = arr.length;
        if(n == m) return n;
        int res = -1;

        for(int i=0; i<arr.length; i++) {
            int left = len[arr[i] - 1], right = len[arr[i] + 1];
            len[arr[i]] = len[arr[i] - left] = len[arr[i] + right] = 1 + left + right;
            count[left]--;
            count[right]--;
            count[len[arr[i]]]++;

            if(count[m] > 0) {
                res = i + 1;
            }
        }

        return res;
    }
}
