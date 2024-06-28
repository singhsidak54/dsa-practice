package Scaler.Sorting;

public class InversionCountInAnArray {
    int count, mod;

    public int merge(int[] A, int l1, int r1, int l2, int r2) {
        int n1 = r1 - l1 + 1, n2 = r2 - l2 + 1;
        int[] temp = new int[n1 + n2];
        int ans = 0;
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if(A[l1 + i] <= A[l2 + j]) {
                temp[k] = A[l1 + i];
                i++;
            } else {
                temp[k] = A[l2 + j];
                j++;
                ans += (n1 - i);
            }
            k++;
        }

        while (i < n1) {
            temp[k] = A[l1 + i];
            k++;
            i++;
        }

        while (j < n2) {
            temp[k] = A[l2 + j];
            k++;
            j++;
        }

        k = 0;
        for(int l=l1; l<=r2; l++) {
            A[l] = temp[k++];
        }

        return ans;
    }

    public void mergeSort(int[] A, int l, int r) {
        if(l == r) return;
        int m = l + (r - l)/2;

        mergeSort(A, l, m);
        mergeSort(A, m + 1, r);
        count = (count + merge(A, l, m, m + 1, r)) % mod;
    }

    public int solve(int[] A) {
        count = 0;
        mod = 1_000_000_007;
        mergeSort(A, 0, A.length - 1);
        return count;
    }

    public static void main(String[] args) {
        InversionCountInAnArray obj = new InversionCountInAnArray();
        System.out.println(obj.solve(new int[] {6, 12, 10, 17, 10, 22, 9, 19, 21, 31, 26, 8}));
    }
}
