package algo2;

public class DecodeWays {
    public static int numDecodings(String s) {
        if(s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i=2; i<=s.length(); i++) {
            int single = Integer.parseInt(s.substring(i-1, i));
            int dbl = Integer.parseInt(s.substring(i-2, i));
            if(single >= 1 && single <= 9) {
                dp[i] += dp[i-1];
            }

            if(dbl >= 10 && dbl <= 26) {
                dp[i] += dp[i-2];
            }
        }

        return dp[s.length()];
    }

    public static int numDecodings2(String s) {
        if(s.length() == 0) return 0;

        int twoBack = 1;
        int oneBack = s.charAt(0) == '0' ? 0 : 1;
        int curr = oneBack;
        for(int i=2; i<=s.length(); i++) {
            curr = 0;
            int first = Integer.parseInt(s.substring(i-1, i));
            int second = Integer.parseInt(s.substring(i-2, i));

            if(first >= 1 && first <= 9) {
                curr = oneBack;
            }

            if(second >= 10 && second <= 26) {
                curr += twoBack;
            }

            twoBack = oneBack;
            oneBack = curr;
        }

        return curr;
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("11106"));
    }
}
