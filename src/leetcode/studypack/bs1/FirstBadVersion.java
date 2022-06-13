package bs1;

public class FirstBadVersion {
    public static boolean isBadVersion(int n) {
        return false;
    }

    public int firstBadVersion(int n) {
        int low = 1, high = n, mid;
        while(low < high) {
            mid = low + (high - low)/2;
            if(isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
