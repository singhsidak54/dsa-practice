package bs1;

public class SquareRootX {
    public static int mySqrt(int x) {
        int low = 1, high = x, ans = 0;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if(mid > x/mid) {
                high = mid - 1;
            } else {
                ans = mid;
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(3));
    }
}
