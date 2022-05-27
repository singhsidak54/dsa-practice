package algo2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        HashMap<Character, char[]> digitToCharactersMap = new HashMap<>();
        digitToCharactersMap.put('2', new char[] {'a', 'b', 'c'});
        digitToCharactersMap.put('3', new char[] {'d', 'e', 'f'});
        digitToCharactersMap.put('4', new char[] {'g', 'h', 'i'});
        digitToCharactersMap.put('5', new char[] {'j', 'k', 'l'});
        digitToCharactersMap.put('6', new char[] {'m', 'n', 'o'});
        digitToCharactersMap.put('7', new char[] {'p', 'q', 'r', 's'});
        digitToCharactersMap.put('8', new char[] {'t', 'u', 'v'});
        digitToCharactersMap.put('9', new char[] {'w', 'x', 'y', 'z'});

        List<String> result = new ArrayList<>();
        if(digits.length() != 0) {
            letterCombinationsHelper(digits.toCharArray(), new StringBuilder(), 0, digitToCharactersMap, result);
        }
        return result;
    }

    public static void letterCombinationsHelper(char[] digits, StringBuilder currCombination, int index, HashMap<Character, char[]> digitToCharactersMap, List<String> result) {
        if(index == digits.length) {
            result.add(currCombination.toString());
            return;
        }

        char[] digitToCharacters = digitToCharactersMap.get(digits[index]);
        for(int i=0; i<digitToCharacters.length; i++) {
            currCombination.append(digitToCharacters[i]);
            letterCombinationsHelper(digits, currCombination, index + 1, digitToCharactersMap, result);
            currCombination.deleteCharAt(currCombination.length() - 1);
        }
    }
}
