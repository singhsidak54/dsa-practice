package Scaler.Backtracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LetterPhone {
    List<String> res;
    HashMap<Character, char[]> map;

    public void helper(String A, int idx, StringBuilder str) {
        if(idx == A.length()) {
            res.add(str.toString());
            return;
        }

        for(char c : map.get(A.charAt(idx))) {
            str.append(c);
            helper(A, idx + 1, str);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public String[] letterCombinations(String A) {
        map = new HashMap<>();
        res = new ArrayList<>();

        map.put('0', new char[] {'0'});
        map.put('1', new char[] {'1'});
        map.put('2', new char[] {'a', 'b', 'c'});
        map.put('3', new char[] {'d', 'e', 'f'});
        map.put('4', new char[] {'g', 'h', 'i'});
        map.put('5', new char[] {'j', 'k', 'l'});
        map.put('6', new char[] {'m', 'n', 'o'});
        map.put('7', new char[] {'p', 'q', 'r', 's'});
        map.put('8', new char[] {'t', 'u', 'v'});
        map.put('9', new char[] {'w', 'x', 'y', 'z'});

        helper(A, 0, new StringBuilder());
        String[] ans = new String[res.size()];

        for(int i=0; i<res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        LetterPhone obj = new LetterPhone();
        System.out.println(Arrays.toString(obj.letterCombinations("2")));
    }
}
