package daily.dec22;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day1DetermineIfStringHalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        int vowelsCountLeft = 0, n = s.length();
        Character[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        Set<Character> vowelSet = new HashSet<>(List.of(vowels));

        for(int i=0; i<n/2; i++) {
            if(vowelSet.contains(s.charAt(i))) {
                vowelsCountLeft++;
            }
        }

        for(int i=n/2; i<n; i++) {
            if(vowelSet.contains(s.charAt(i))) {
                vowelsCountLeft--;
            }
        }

        return vowelsCountLeft == 0;
    }
}
