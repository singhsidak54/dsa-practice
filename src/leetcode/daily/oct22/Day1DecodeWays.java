package daily.oct22;

public class Day1DecodeWays {
    public static int numDecodings(String s) {
        if(s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=s.length(); i++) {
            int first = Integer.parseInt(s.substring(i -1, i));
            int second = Integer.parseInt(s.substring(i - 2, i));

            if(first != 0) {
                dp[i] = dp[i-1];
            }

            if(second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
    }
}
