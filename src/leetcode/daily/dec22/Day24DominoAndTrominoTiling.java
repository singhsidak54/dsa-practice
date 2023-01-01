package daily.dec22;

public class Day24DominoAndTrominoTiling {
    public int numTilings(int n) {
        if(n <= 2) return n;
        int mod = 1_000_000_007;
        long[] fullyFilled = new long[n + 1];
        long[] partiallyFilled = new long[n + 1];

        fullyFilled[1] = 1;
        fullyFilled[2] = 2;
        partiallyFilled[2] = 1;

        for(int i=3; i<=n; i++) {
            fullyFilled[i] = (fullyFilled[i-1] + fullyFilled[i-2] + 2 * partiallyFilled[i-1]) % mod;
            partiallyFilled[i] = (partiallyFilled[i-1] + fullyFilled[i-2]) % mod;
        }

        return (int)fullyFilled[n];
    }
}
