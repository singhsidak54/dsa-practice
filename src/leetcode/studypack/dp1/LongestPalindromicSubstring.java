package dp1;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int ansLeftIndex = 0, ansRightIndex = 0;

        for(int i=0; i<n; i++) {
            dp[i][i] = 1;
            if(i<n-1 && s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = 1;
                ansLeftIndex = i;
                ansRightIndex = i+1;
            }
        }

        for(int len=2; len<n; len++) {
            for(int i=0; i+len<n; i++) {
                if(s.charAt(i) == s.charAt(i+len) && dp[i + 1][i+len-1] == 1) {
                    dp[i][i+len] = 1;
                    if(len > ansRightIndex - ansLeftIndex) {
                        ansLeftIndex = i;
                        ansRightIndex = i + len;
                    }
                }
            }
        }

        return s.substring(ansLeftIndex, ansRightIndex + 1);
    }

    public static int expandAroundCenter(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }

        return end - start - 1;
    }

    public static String longestPalindrome2(String s) {
        int n = s.length();
        int startIndex = 0, endIndex = 0;

        for (int i=0; i<n; i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);
            int currStartIndex = i - len1/2, currEndIndex = i + len1/2;
            if(len2 > len1) {
                currStartIndex = i + 1 - len2/2;
                currEndIndex = i + len2/2;
            }

            if(currEndIndex - currStartIndex > endIndex - startIndex) {
                startIndex = currStartIndex;
                endIndex = currEndIndex;
            }
        }
        return s.substring(startIndex, endIndex + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome2("bb"));
    }
}
