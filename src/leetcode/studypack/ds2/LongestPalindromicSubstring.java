package ds2;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if(s.length() == 0) return "";
        int n = s.length();
        int maxLength = 1;
        String result = s.substring(0,1);
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++) {
            dp[i][i] = 1;
            if(i+1<n && s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = 1;
                if(maxLength < 2) {
                    maxLength = 2;
                    result = s.substring(i, i+2);
                }
            }
        }

        for (int length=3; length<=n; length++) {
            for(int i=0; i+length-1<n; i++) {
                int j = i + length - 1;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 1) {
                    dp[i][j] = 1;
                    if(length > maxLength) {
                        maxLength = length;
                        result = s.substring(i,j+1);
                    }
                }
            }
        }
        return result;
    }

    public static String longestPalindrome2(String s) {
        String result = "";
        int maxLength = 0;
        for(int i=0; i<s.length(); i++) {
            int left = i, right = i;
            while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
                if(right - left + 1 > maxLength) {
                    maxLength = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                left--;
                right++;
            }

            left = i;
            right = i + 1;
            while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
                if(right - left + 1 > maxLength) {
                    maxLength = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome2("aaaab"));
    }
}
