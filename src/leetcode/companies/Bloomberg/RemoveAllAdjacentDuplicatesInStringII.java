package companies.Bloomberg;

import java.util.Arrays;
import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInStringII {
    public String removeDuplicates(String s, int k) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for(int i=s.length()-1; i>=0; i--) {
            if(result.length() > 0 && result.charAt(result.length() - 1) == s.charAt(i)) {
                int currentCount = stack.pop();
                if(currentCount + 1 == k) {
                    int deleteStartIndex = result.length() - k + 1;
                    result.delete(deleteStartIndex, result.length());
                } else {
                    result.append(s.charAt(i));
                    stack.push(currentCount + 1);
                }
            } else {
                result.append(s.charAt(i));
                stack.push(1);
            }
        }

        return result.reverse().toString();
    }
}
