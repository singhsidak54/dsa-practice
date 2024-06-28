package Scaler.Math;

public class SortedPermutationRank2 {
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

    public int findRank(String A) {
        int n = A.length(), mod = 1000003;
        int[] fact = new int[n + 1];
        fact[0] = 1;
        fact[1] = 1;
        for(int i=2; i<n; i++) {
            fact[i] = ((fact[i-1] % mod) * (i % mod)) % mod;
        }

        long totalCount = 1;
        for (int i=0; i<A.length(); i++) {
            long lessThanCount = 0;
            for (int j=i+1; j<A.length(); j++) {
                if (A.charAt(j) < A.charAt(i))
                    lessThanCount++;
            }

            int[] repetition = new int[52];
            for (int j=i; j<A.length(); j++) {
                if (A.charAt(j) >= 'A' && A.charAt(j) <= 'Z')
                    repetition[A.charAt(j) - 'A'] += 1;
                else
                    repetition[A.charAt(j) - 'a' + 26] += 1;
            }

            long repetitionFact = 1;
            for (int j: repetition)
                repetitionFact = (repetitionFact * fact[j]) % mod;

            long inverse = fastPow((int) repetitionFact, mod-2, mod);
            long perm = (fact[n-i-1] * inverse) % mod;
            totalCount = (totalCount + (lessThanCount * perm)) % mod;
        }
        return (int) totalCount;
    }
}
