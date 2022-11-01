package daily;

public class ConcatenationOfConsecutiveBinaryNumbers {
    public int concatenatedBinary(int n) {
        long ans = 0;
        int mod = (int) (1e9 + 7), l = 0;

        for(int i=1; i<=n; i++) {
            if((i & (i-1)) == 0) l++;
            ans = ((ans << l) | i) % mod;
        }

        return (int)ans;
    }
}
