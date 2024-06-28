package Scaler.Sorting;

public class ReversePairs {
    int count;

    public long[] merge(long[] left, long[] right) {
        int n1 = left.length, n2 = right.length;
        long[] temp = new long[n1 + n2];
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if(left[i] <= right[j]) {
                temp[k] = left[i];
                i++;
            } else {
                temp[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            temp[k] = left[i];
            k++;
            i++;
        }

        while (j < n2) {
            temp[k] = right[j];
            k++;
            j++;
        }

        return temp;
    }

    public int countPairs(long[] left, long[] right) {
        int ans = 0;
        int i = 0, j = 0, n1 = left.length, n2 = right.length;

        while (i < n1) {
            while (j < n2 && left[i] > 2 * right[j]) {
                j++;
            }

            ans += j;
            i++;
        }

        return ans;
    }

    public long[] mergeSort(int[] A, int l, int r) {
        if(l == r) {
            return new long[] {A[l]};
        }

        int m = l + (r - l)/2;

        long[] left = mergeSort(A, l, m);
        long[] right = mergeSort(A, m + 1, r);

        count += countPairs(left, right);
        return merge(left, right);
    }

    public int solve(int[] A) {
        count = 0;
        mergeSort(A, 0, A.length - 1);
        return count;
    }

    public static void main(String[] args) {
        ReversePairs obj = new ReversePairs();
        System.out.println(obj.solve(new int[] {2000000000, 2000000000, -2000000000}));
    }
}
