package daily.jan23.weekly;

public class Week3FindTheIndexOfTheLargeInteger {
    interface ArrayReader {
        // Compares the sum of arr[l..r] with the sum of arr[x..y]
        // return 1 if sum(arr[l..r]) > sum(arr[x..y])
        // return 0 if sum(arr[l..r]) == sum(arr[x..y])
        // return -1 if sum(arr[l..r]) < sum(arr[x..y])
        int compareSub(int l, int r, int x, int y);

        // Returns the length of the array
        int length();
    }

    public int getIndex(ArrayReader reader) {
        int n = reader.length();
        int l = 0, r = n - 1;
        while (l < r) {
            int elements = r - l + 1;
            int m = l + (r - l)/2;

            if(elements % 2 == 0) {
                int l1 = l, r1 = m, l2 = m + 1, r2 = r;
                int compareResult = reader.compareSub(l1, r1, l2, r2);
                if(compareResult == 1) {
                    r = m;
                } else {
                    l = m + 1;
                }
            } else {
                int l1 = l, r1 = m, l2 = m, r2 = r;
                int compareResult = reader.compareSub(l1, r1, l2, r2);
                if(compareResult == 0) {
                    return m;
                } else if (compareResult == 1) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }

        return l;
    }
}
