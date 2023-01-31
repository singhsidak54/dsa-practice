package companies.Bloomberg;

public class MaximumNestingDepthOfTheParentheses {
    public int maxDepth(String s) {
        int max = 0, nOpen = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                nOpen++;
                max = Math.max(max, nOpen);
            } else if (s.charAt(i) == ')') {
                nOpen--;
            }
        }

        return max;
    }
}
