package Scaler.DP;

public class RegularExpressionMatch {

    public int countNonStar(String B, int i2) {
        int count = 0;
        for(int i=i2; i<B.length(); i++) {
            if(B.charAt(i) != '*') count++;
        }

        return count;
    }

    public int isMatch(String A, String B, int i1, int i2, int[][] dp) {
        if(i1 == A.length() && i2 == B.length()) return 1;
        if(i2 == B.length()) return -1;
        if(i1 == A.length() && i2 == B.length() - 1 && B.charAt(i2) == '*') return 1;
        if(i1 == A.length()) return -1;

        if(countNonStar(B, i2) > A.length()) return -1;
        char a = A.charAt(i1), b = B.charAt(i2);
        if(a == b || b == '?') {
            dp[i1][i2] = isMatch(A, B, i1 + 1, i2 + 1, dp);
        } else if (b == '*') {
            int res = isMatch(A, B, i1 + 1, i2, dp);
            if(res == -1) {
                res = isMatch(A, B, i1, i2 + 1, dp);
            }
            dp[i1][i2] = res;
        } else {
            dp[i1][i2] = -1;
        }

        return dp[i1][i2];
    }
    public int isMatch(final String A, final String B) {
        if(countNonStar(B, 0) > A.length()) return 0;
        int[][] dp = new int[A.length()][B.length()];
        return isMatch(A, B, 0, 0, dp) == 1 ? 1 : 0;
    }

    public static void main(String[] args) {
        RegularExpressionMatch obj = new RegularExpressionMatch();
        System.out.println(obj.isMatch("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "a**************************************************************************************"));
    }
}
