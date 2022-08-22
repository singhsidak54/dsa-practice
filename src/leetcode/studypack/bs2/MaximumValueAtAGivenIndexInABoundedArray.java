package bs2;

public class MaximumValueAtAGivenIndexInABoundedArray {
    public static long arraySum(int n, int index, long pivot) {
        long res = 0;
        long lastElem = Math.max(pivot - index, 0);
        res += (pivot + lastElem) * (pivot - lastElem + 1)/2;
        lastElem = Math.max(pivot - (n - index - 1), 0);
        res += (lastElem + pivot) * (pivot - lastElem + 1)/2;
        return res - pivot;
    }

    public static int maxValue(int n, int index, int maxSum) {
        maxSum -= n;
        int l = 0, r = maxSum, mid;
        while (l < r) {
            mid = (l + r + 1)/2;
            if(arraySum(n, index, mid) <= maxSum) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return l + 1;
    }

    public static void main(String[] args) {
        System.out.println(maxValue(4, 2, 6));
    }
}
