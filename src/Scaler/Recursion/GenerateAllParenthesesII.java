package Scaler.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateAllParenthesesII {
    List<String> res;

    public void backtrack(StringBuilder curr, int open, int close, int A) {
        if(open == A && close == A) {
            res.add(curr.toString());
            return;
        }

        if(open < A) {
            curr.append('(');
            backtrack(curr, open + 1, close, A);
            curr.deleteCharAt(curr.length() - 1);
        }

        if(close < open) {
            curr.append(')');
            backtrack(curr, open, close + 1, A);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public String[] generateParenthesis(int A) {
        res = new ArrayList<>();
        backtrack(new StringBuilder(), 0, 0, A);
        String[] ans = new String[res.size()];
        for(int i=0; i<ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        GenerateAllParenthesesII obj = new GenerateAllParenthesesII();
        System.out.println(Arrays.toString(obj.generateParenthesis(4)));
    }
}
