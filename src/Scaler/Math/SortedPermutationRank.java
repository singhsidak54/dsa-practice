package Scaler.Math;

public class SortedPermutationRank {

    public static int findRank(String A) {
        int n = A.length(), mod = 1000003;
        int[] fact = new int[n + 1];
        fact[0] = 1;
        fact[1] = 1;
        for(int i=2; i<n; i++) {
            fact[i] = ((fact[i-1] % mod) * (i % mod)) % mod;
        }

        int[] chars = new int[58];
        for(int i=0; i<n; i++) {
            chars[A.charAt(i) - 'A'] = 1;
        }

        int ans = 0;
        for(int i=0; i<n; i++) {
            int smaller = 0;
            int charIdx = A.charAt(i) - 'A';
            chars[charIdx] = 0;

            for(int j=0; j<charIdx; j++) {
                if(chars[j] == 1) {
                    smaller++;
                }
            }
            ans = (ans + (smaller * fact[n - i - 1]) % mod) % mod;
        }

        return ans + 1;
    }

    public static void main(String[] args) {
        System.out.println(findRank("a"));
    }
}
