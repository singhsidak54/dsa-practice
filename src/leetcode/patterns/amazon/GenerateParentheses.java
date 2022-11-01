package patterns.amazon;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public void generateParenthesisHelper(int n, int nOpen, int nClose, StringBuilder curr, List<String> result) {
        if(nClose == n && nOpen == n) {
            result.add(curr.toString());
            return;
        }

        if (nOpen > nClose) {
            curr.append(')');
            generateParenthesisHelper(n, nOpen, nClose + 1, curr, result);
            curr.deleteCharAt(curr.length() - 1);
        }

        if (n > nOpen) {
            curr.append('(');
            generateParenthesisHelper(n, nOpen + 1, nClose, curr, result);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(n, 0, 0, new StringBuilder(), result);
        return result;
    }
}
