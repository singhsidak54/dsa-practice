package bs2;

public class UglyNumberIII {
    public static long gcd(long a, long b) {
        if(a == 0) return b;
        return gcd(b % a, a);
    }

    public static long lcm(long a, long b) {
        return a * b/ gcd(a, b);
    }

    public static int count(long a, long b, long c, long num) {
        return (int) (num/a + num/b + num/c - num/lcm(a, b) - num/lcm(b, c) - num/lcm(c, a) + num/lcm(a, lcm(b, c)));
    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        int l = 0, r = (int) 2e9 + 1, mid;
        while (l < r) {
            mid = l + (r - l)/2;
            if(count(a, b, c, mid) < n) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
