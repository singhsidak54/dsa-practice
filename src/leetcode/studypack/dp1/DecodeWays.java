package dp1;

public class DecodeWays {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;

        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            int num = Integer.parseInt(s.substring(i-2, i));
            if(num >= 10 && num <= 26) {
                dp[i] += dp[i-2] + 1;
            }
            if(s.charAt(i-1) == '0') {
                continue;
            }
            dp[i] += dp[i-1] + 1;
        }

        return dp[n];
    }

    public int numDecodings2(String s) {
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
}
