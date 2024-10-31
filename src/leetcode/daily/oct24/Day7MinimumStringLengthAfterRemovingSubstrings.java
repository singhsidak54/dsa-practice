package daily.oct24;

import java.util.Stack;

public class Day7MinimumStringLengthAfterRemovingSubstrings {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (!stack.isEmpty()) {
                if(c == 'B' && stack.peek() == 'A') stack.pop();
                else if(c == 'D' && stack.peek() == 'C') stack.pop();
                else stack.push(c);
            } else {
                stack.push(c);
            }
            i++;
        }

        return stack.size();
    }
}
