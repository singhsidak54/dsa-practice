package daily.oct24;

public class Day9MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        int nOpen = 0, ans = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') nOpen++;
            else if(c ==')') nOpen--;

            if(nOpen < 0) {
                ans++;
                nOpen++;
            }
        }

        return ans + nOpen;
    }
}
