package daily.nov22;

import java.util.Stack;

public class Day20BasicCalculator {
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, n = s.length(), sign = 1, result = 0;
        while (i < n) {
            if(Character.isDigit(s.charAt(i))) {
                int number = s.charAt(i) - '0';
                while(i + 1 < n && Character.isDigit(s.charAt(i + 1))) {
                    number = number * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                result += sign * number;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                result = (stack.pop() * result) + stack.pop();
            }
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculate("2147483647"));
    }
}
