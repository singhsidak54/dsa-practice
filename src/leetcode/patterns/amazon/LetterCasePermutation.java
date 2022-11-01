package patterns.amazon;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public void letterCasePermutation(String s, int index, List<String> result, StringBuilder curr) {
        if(index == s.length()) {
            result.add(curr.toString());
            return;
        }

        char c = s.charAt(index);
        curr.append(c);
        letterCasePermutation(s, index + 1, result, curr);

        curr.deleteCharAt(index);
        if(Character.isLowerCase(c)) {
            curr.append(Character.toUpperCase(c));
            letterCasePermutation(s, index + 1, result, curr);
            curr.deleteCharAt(index);
        } else if (Character.isUpperCase(c)) {
            curr.append(Character.toLowerCase(c));
            letterCasePermutation(s, index + 1, result, curr);
            curr.deleteCharAt(index);
        }
    }

    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        letterCasePermutation(s, 0, result, new StringBuilder());
        return result;
    }
}
