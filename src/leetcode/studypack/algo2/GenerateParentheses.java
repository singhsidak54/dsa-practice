package algo2;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(n, 0, 0 ,new StringBuilder(), result);
        return result;
    }

    public static void generateParenthesisHelper(int n, int nOpen, int nClose, StringBuilder current, List<String> result) {
        if(n * 2 == current.length()) {
            result.add(current.toString());
            return;
        }

        if (nOpen < n) {
            current.append('(');
            generateParenthesisHelper(n, nOpen + 1, nClose, current, result);
            current.deleteCharAt(current.length() - 1);
        }

        if(nClose < nOpen) {
            current.append(')');
            generateParenthesisHelper(n, nOpen, nClose + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }

    //Using Catalan numbers Equation
    public List<String> generateParenthesis2(int n) {
        List<List<String>> lists = new ArrayList<>();
        List<String> current = new ArrayList<>();
        current.add("");
        lists.add(current);

        for(int i=1; i<=n; i++) {
            current = new ArrayList<>();

            for(int j=0; j<i; j++) {
                for(String first : lists.get(j)) {
                    for(String second : lists.get(i - 1 - j)) {
                        current.add("(" + first + ")" + second);
                    }
                }
            }
            lists.add(current);
        }

        return lists.get(n);
    }
}
