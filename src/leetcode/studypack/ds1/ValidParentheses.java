package ds1;

import java.util.HashMap;
import java.util.Stack;

// Problem Link - https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[')
                stack.push(c);
            else if (c == ')' || c == '}' || c == ']') {
                if(stack.isEmpty() || stack.pop() != map.get(c))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[{}]";
        System.out.println(isValid(s));
    }
}
