package bs1;

public class ArrangingCoins {
    public static int arrangeCoins(int n) {
        int low = 1, high = n, mid;
        while (low <= high) {
            mid = low + (high - low)/2;
            long curr = mid * (mid + 1)/2;
            if(curr == n) {
                return mid;
            } else if (curr < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(8));
    }
}
