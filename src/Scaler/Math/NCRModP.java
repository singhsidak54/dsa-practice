package Scaler.Math;

public class NCRModP {
    public static int fastPow(int A, int B, int mod) {
        if(B == 0) {
            return 1;
        }

        long halfAns = fastPow(A, B/2, mod);
        if(B % 2 == 0) {
            return (int) ((halfAns%mod * halfAns%mod) % mod);
        } else {
            return (int) ((halfAns%mod * halfAns%mod * A%mod) % mod);
        }
    }

    public static int solve(int A, int B, int C) {
        long[] fact = new long[A + 1];
        fact[0] = 1;
        fact[1] = 1;
        for(int i=2; i<=A; i++) {
            fact[i] = ((fact[i-1]%C) * (i%C)) % C;
        }

        long nFact = fact[A];
        int nMinusFact = (int)fact[A - B], rMinusFact = (int)fact[B];
        long nInverse = fastPow(nMinusFact, C - 2, C), rInverse = fastPow(rMinusFact, C - 2, C);

        long inverse = (nInverse * rInverse) % C;
        return (int)(((nFact % C) * (inverse % C)) % C);
    }

    public static void main(String[] args) {
        System.out.println(solve(51299,25646,3685739));
    }
}
