package bs1;

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int low = 1, high = num, mid;
        while (low <= high) {
            mid = low + (high - low)/2;
            int divRes = num/mid, rem = num % mid;
            if(divRes == mid && rem == 0) {
                return true;
            } else if (divRes > mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
