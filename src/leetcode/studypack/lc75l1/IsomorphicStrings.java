package lc75l1;

import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicStrings {

    // can also be solved by replacing characters with their first occurrence index
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> charMappings = new HashMap<>();
        HashSet<Character> assignedValues = new HashSet<>();

        for(int i=0; i<s.length(); i++) {
            if(charMappings.containsKey(s.charAt(i)) && charMappings.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }

            if(!charMappings.containsKey(s.charAt(i)) && assignedValues.contains(t.charAt(i))) {
                return false;
            }

            charMappings.put(s.charAt(i), t.charAt(i));
            assignedValues.add(t.charAt(i));
        }

        return true;
    }
}
