package daily.nov22.premium;

public class ValidPalindromeIII {
    public boolean isPalindrome(StringBuilder s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    public boolean isValidPalindrome(String s, int k, int index, StringBuilder currString) {
        if(k < 0) return false;
        if(k == 0 || index == s.length()) {
            StringBuilder finalString = new StringBuilder(currString);
            if(index != s.length()) {
                finalString.append(s.substring(index));
            }
            return isPalindrome(finalString);
        }

        if(isValidPalindrome(s, k - 1, index + 1, currString)) {
            return true;
        }

        currString.append(s.charAt(index));
        if(isValidPalindrome(s, k, index + 1, currString)) {
            return true;
        }

        currString.deleteCharAt(currString.length() - 1);
        return false;
    }

    public boolean isValidPalindromeBruteForce(String s, int k) {
        return isValidPalindrome(s, k, 0, new StringBuilder());
    }

    public Integer isValidPalindromeDPHelper(String s, int l, int r, Integer[][] dp) {
        if(l == r) {
            return 0;
        }

        if(l == r - 1) {
            return s.charAt(l) == s.charAt(r) ? 0 : 1;
        }

        if(dp[l][r] != null) {
            return dp[l][r];
        }

        if(s.charAt(l) == s.charAt(r)) {
            dp[l][r] = isValidPalindromeDPHelper(s, l + 1, r - 1, dp);
            return dp[l][r];
        } else {
            dp[l][r] = 1 + Math.min(isValidPalindromeDPHelper(s, l + 1, r, dp), isValidPalindromeDPHelper(s, l, r - 1, dp));
            return dp[l][r];
        }
    }

    public boolean isValidPalindromeDP(String s, int k) {
        Integer[][] dp = new Integer[s.length()][s.length()];

        return isValidPalindromeDPHelper(s, 0, s.length() - 1, dp) <= k;
    }
}
