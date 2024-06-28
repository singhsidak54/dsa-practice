package daily.apr23;

public class Day22MinimumInsertionStepsToMakeAStringPalindrome {

    public int backtrack(String s, Integer[][] dp, int left, int right) {
        if(left >= right) {
            return 0;
        }

        if(dp[left][right] != null) {
            return dp[left][right];
        }

        int i = left, j = right;
        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }

        if(left >= right) return 0;

        dp[i][j] = 1 + Math.min(backtrack(s, dp, left + 1, right), backtrack(s, dp, left, right - 1));

        return dp[i][j];
    }
    public int minInsertions(String s) {
        int n = s.length();
        Integer[][] dp = new Integer[n][n];
        return backtrack(s, dp, 0, s.length() - 1);
    }

    public static void main(String[] args) {
        Day22MinimumInsertionStepsToMakeAStringPalindrome obj = new Day22MinimumInsertionStepsToMakeAStringPalindrome();
        System.out.println(obj.minInsertions("leetcode"));
    }
}
