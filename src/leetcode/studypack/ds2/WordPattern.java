package ds2;

import java.util.HashMap;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] sWordArray = s.split(" ");
        if(pattern.length() != sWordArray.length)
            return false;

        HashMap<Character, String> charToWordMap = new HashMap<>();
        for(int i=0; i<pattern.length(); i++) {
            char current = pattern.charAt(i);
            if(charToWordMap.containsKey(current)) {
                if(!charToWordMap.get(current).equals(sWordArray[i]))
                    return false;
            } else if(charToWordMap.containsValue(sWordArray[i])) {
                return false;
            } else {
                charToWordMap.put(current, sWordArray[i]);
            }
        }

        return true;
    }
}
