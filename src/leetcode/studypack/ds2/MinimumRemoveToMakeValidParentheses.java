package ds2;

public class MinimumRemoveToMakeValidParentheses {
    public static String minRemoveToMakeValid(String s) {
        StringBuilder result = new StringBuilder("");
        int nOpen = 0, nClose = 0;
        int lastOpenIndex = -1;
        int k = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                result.append("(");
                lastOpenIndex = k;
                k++;
                nOpen++;
            } else if (s.charAt(i) == ')') {
                if(nClose + 1 > nOpen) {
                    continue;
                }
                result.append(")");
                k++;
                nClose++;
            } else {
                result.append(s.charAt(i));
                k++;
            }
        }

        while(nOpen > nClose) {
            result.deleteCharAt(lastOpenIndex);
            lastOpenIndex--;
            while(lastOpenIndex >= 0 && result.charAt(lastOpenIndex) != '(') {
                lastOpenIndex--;
            }
            nOpen--;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("))(("));
    }
}
