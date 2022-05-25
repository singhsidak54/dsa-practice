package ds2;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if(s.length() == 0) return "";
        String result = s.substring(0,1);
        int maxLen = 1;
        int[][] dp = new int[s.length()][s.length()];
        for(int i=0; i<s.length(); i++) {
            dp[i][i] = 1;
            if(i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = 1;
                if(maxLen < 2) {
                    maxLen = 2;
                    result = s.substring(i,i+2);
                }
            }
        }
        for(int length=3; length<=s.length(); length++) {
            for(int i=0; i+length-1<s.length(); i++) {
                int j = i + length - 1;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 1) {
                    dp[i][j] = 1;
                    if(length > maxLen) {
                        maxLen = length;
                        result = s.substring(i,j + 1);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaaa"));
    }
}
