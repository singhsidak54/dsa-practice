package misc;

import java.util.Stack;

public class ScoreOfParentheses {
    public int scoreOfParentheses(String s) {
        Stack<String> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push("(");
            } else {
                if(stack.peek().equals("(")) {
                    stack.pop();
                    stack.push("1");
                } else {
                    int currAns = 0;
                    while (!stack.peek().equals("(")) {
                        currAns += Integer.parseInt(stack.pop());
                    }
                    stack.pop();
                    stack.push(String.valueOf(currAns * 2));
                }
            }
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            ans += Integer.parseInt(stack.pop());
        }
        return ans;
    }

    public int scoreOfParentheses2(String s) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(-1);
            } else {
                if(stack.peek().equals(-1)) {
                    stack.pop();
                    stack.push(1);
                } else {
                    int currAns = 0;
                    while (!stack.peek().equals(-1)) {
                        currAns += stack.pop();
                    }
                    stack.pop();
                    stack.push(currAns * 2);
                }
            }
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
