package Scaler.Stack;

import java.util.ArrayList;
import java.util.Stack;

public class EvaluateExpression {
    public int evalRPN(ArrayList<String> A) {
        Stack<Integer> stack = new Stack<>();

        for(String s : A) {
            try {
                int num = Integer.parseInt(s);
                stack.add(num);
            } catch (Exception e) {
                int a = stack.pop();
                int b = stack.pop();
                switch (s) {
                    case "+" :
                        stack.add(b + a);
                        break;
                    case "-" :
                        stack.add(b - a);
                        break;
                    case "*" :
                        stack.add(b * a);
                        break;
                    default:
                        stack.add(b / a);
                }
            }
        }

        return stack.pop();
    }
}
