package bs1;

public class SumOfSquareNumbers {
    public static boolean isPerfectSquare(int n) {
        int l = 0, r = n, m;
        while (l <= r) {
            m = l + (r - l)/2;
            if(n/m == m && n % m == 0) {
                return true;
            } else if (n/m > m) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }
    public boolean judgeSquareSum(int c) {
        for(long a = 0; a * a <= c; a++) {
            int b = c - (int)(a * a);
            if(isPerfectSquare(b)) {
                return true;
            }
        }
        return false;
    }

    public boolean judgeSquareSum2(int c) {
        long l = 0, r = (long)Math.sqrt(c);
        while (l <= r) {
            long curr = l * l + r * r;
            if(curr == c) {
                return true;
            } else if (curr < c) {
                l++;
            } else {
                r--;
            }
        }
        return false;
    }
}
