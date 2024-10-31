package daily.sep24;

import java.util.ArrayList;
import java.util.List;

public class Day19DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> results = new ArrayList<>();

        if (expression.length() == 0) return results;

        if (expression.length() == 1) {
            results.add(Integer.parseInt(expression));
            return results;
        }

        if (expression.length() == 2 && Character.isDigit(expression.charAt(0))) {
            results.add(Integer.parseInt(expression));
            return results;
        }

        for (int i=0; i<expression.length(); i++) {
            char curr = expression.charAt(i);

            if (Character.isDigit(curr)) continue;

            String left = expression.substring(0, i), right = expression.substring(i + 1);
            char operand = expression.charAt(i);

            List<Integer> leftResults = diffWaysToCompute(left), rightResults = diffWaysToCompute(right);

            for (int first : leftResults) {
                for(int second : rightResults) {
                    if (operand == '+') results.add(first + second);
                    else if (operand == '-') results.add(first - second);
                    else results.add(first * second);
                }
            }
        }

        return results;
    }
}
