package daily.dec22;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Day17EvaluateReversePolishNotation {
    public int solve(int a, int b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> -1;
        };

    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> operatorsSet = new HashSet<>();
        operatorsSet.add("+");
        operatorsSet.add("/");
        operatorsSet.add("-");
        operatorsSet.add("*");

        for(String token : tokens) {
            if(operatorsSet.contains(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(solve(a, b, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
