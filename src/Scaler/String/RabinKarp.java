package Scaler.String;

public class RabinKarp {
    public static int solve(String A, String B) {
        int hashReq = 0, mod = 1_000_000_007;
        for(int i=0; i<B.length(); i++) {
            char c = B.charAt(i);
            long curr = (c * (long)Math.pow(29, B.length() - i - 1)) % mod;
            hashReq = (hashReq + (int)curr) % mod;
        }

        int start = 0, end = 0, currHash = 0, count = 0;
        while (end < B.length()) {
            char c = A.charAt(end);
            long curr = (c * (long)Math.pow(29, B.length() - end - 1)) % mod;
            currHash = (currHash + (int)curr) % mod;
            end++;
        }

        if(currHash == hashReq) count++;

        while (end < A.length()) {
            char out = A.charAt(start++);
            char in = A.charAt(end++);


            long outHash = (out * (long)Math.pow(29, B.length() - 1)) % mod;

            currHash = ((currHash - (int)outHash) * 29) % mod;
            currHash = (currHash + in) % mod;

            if(currHash == hashReq) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(solve("aaaa", "aa"));
    }
}
