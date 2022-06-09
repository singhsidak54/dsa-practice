package bs1;

public class GuessNumberHigherOrLower {
    static boolean flag = true;
    public static int guess(int num) {
        flag = !flag;
        return flag ? -1 : 1;
    }

    public int guessNumber(int n) {
        int l = 1, h = n;
        while (l <= h) {
            int mid = l + (h - l)/2;
            int higherOrLower = guess(mid);
            if(higherOrLower > 0) {
                l = mid + 1;
            } else if (higherOrLower == 0) {
                return mid;
            } else {
                h = mid - 1;
            }
        }
        return -1;
    }
}
