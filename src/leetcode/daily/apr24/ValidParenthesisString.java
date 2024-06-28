package daily.apr24;

public class ValidParenthesisString {
    public static boolean checkValid(String s, int idx, int nOpen, int[][] dp) {
        if(nOpen < 0) return false;

        if(dp[idx][nOpen] == -1) return false;
        int cOpen = nOpen;
        for(int i=idx; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') cOpen++;
            else if(c == ')') cOpen--;
            else if(c == '*') {
                return checkValid(s, i + 1, cOpen, dp)
                        || checkValid(s, i + 1, cOpen - 1, dp)
                        || checkValid(s, i + 1, cOpen + 1, dp);
            }
        }

        dp[idx][nOpen] = nOpen == 0 ? 1 : -1;
        return dp[idx][nOpen] == 1;
    }

    public static boolean checkValidString(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        return checkValid(s, 0, 0, dp);
    }

    public static void main(String[] args) {
        System.out.println(checkValidString("(*))"));
    }
}
