package patterns.amazon;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    String[] digitMap = new String[10];

    public void letterCombinations(String digits, int index, StringBuilder curr, List<String> result) {
        if(index == digits.length()) {
            result.add(curr.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        for(char c : digitMap[digit].toCharArray()) {
            curr.append(c);
            letterCombinations(digits, index + 1, curr, result);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return new ArrayList<>();
        }

        digitMap[2] = "abc";
        digitMap[3] = "def";
        digitMap[4] = "ghi";
        digitMap[5] = "jkl";
        digitMap[6] = "mno";
        digitMap[7] = "pqrs";
        digitMap[8] = "tuv";
        digitMap[9] = "wxyz";

        List<String> result = new ArrayList<>();
        letterCombinations(digits, 0, new StringBuilder(), result);
        return result;
    }
}
