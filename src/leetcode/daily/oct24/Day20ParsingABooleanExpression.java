package daily.oct24;

import java.util.ArrayList;
import java.util.List;

public class Day20ParsingABooleanExpression {

    int index;

    public boolean evaluate(String expression) {
        char curr = expression.charAt(index++);

        if(curr == 'f') return false;
        if(curr == 't') return true;

        if(curr == '!') {
            index++;
            boolean ans = !evaluate(expression);
            index++;
            return ans;
        }

        List<Boolean> values = new ArrayList<>();
        if(curr == '&' || curr == '|') {
            index++;
            while (expression.charAt(index) != ')') {
                if(expression.charAt(index) != ',') {
                    values.add(evaluate(expression));
                } else {
                    index++;
                }
            }
            index++;
        }
        if(curr == '&') {
            for(boolean val : values) {
                if(!val) return false;
            }

            return true;
        }

        if(curr == '|') {
            for(boolean val : values) {
                if(val) return true;
            }

            return false;
        }

        return false;
    }

    public boolean parseBoolExpr(String expression) {
        index = 0;
        return evaluate(expression);
    }

    public static void main(String[] args) {
        Day20ParsingABooleanExpression obj = new Day20ParsingABooleanExpression();
        System.out.println(obj.parseBoolExpr("(!(&(f,t)),f)"));
    }
}
