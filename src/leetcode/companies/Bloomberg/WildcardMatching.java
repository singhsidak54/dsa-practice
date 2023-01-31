package companies.Bloomberg;

public class WildcardMatching {
    public String removeDuplicateStars(String p) {
        StringBuilder pattern = new StringBuilder();
        int i = 0;
        while (i < p.length()) {
            if(p.charAt(i) == '*') {
                pattern.append('*');
                i++;
                while (i < p.length() && p.charAt(i) == '*') {
                    i++;
                }
            } else {
                pattern.append(p.charAt(i));
                i++;
            }
        }

        return pattern.toString();
    }

    public boolean isEqual(String s, String p, int i, int j) {
        while (i < s.length() && j < p.length() && s.charAt(i) == p.charAt(j)) {
            i++;
            j++;
        }

        return i == s.length() && j == p.length();
    }

    public boolean dfs(String s, String p, int sId, int pId, Boolean[][] dp) {
        if(pId == p.length() && sId == s.length()) return true;
        if(sId == s.length() && pId == p.length() - 1 && p.charAt(pId) == '*') return true;
        if(pId >= p.length() || sId >= s.length()) return false;

        if(dp[sId][pId] != null) {
            return dp[sId][pId];
        }

        if(isEqual(s, p, sId, pId) || isEqual("*", p, 0, pId)) {
            dp[sId][pId] = true;
        } else if (p.charAt(pId) == s.charAt(sId) || p.charAt(pId) == '?') {
            dp[sId][pId] = dfs(s, p, sId + 1, pId + 1, dp);
        } else if (p.charAt(pId) == '*') {
            dp[sId][pId] = dfs(s, p, sId, pId + 1, dp) || dfs(s, p, sId + 1, pId, dp);
        } else {
            dp[sId][pId] = false;
        }

        return dp[sId][pId];
    }

    public boolean isMatch(String s, String p) {
        p = removeDuplicateStars(p);
        Boolean[][] dp = new Boolean[s.length()][p.length()];
        return dfs(s, p, 0, 0, dp);
    }
}
