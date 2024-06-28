package daily.apr24;

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for(char digit : num.toCharArray()) {
            while(!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }

            stack.push(digit);
        }


        while (k-- > 0) {
            stack.pop();
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        res.reverse();
        while (res.length() > 0 && res.charAt(0) == '0') res.deleteCharAt(0);
        if(res.isEmpty()) return "0";
        return res.toString();
    }
}
