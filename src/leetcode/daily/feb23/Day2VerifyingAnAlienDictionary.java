package daily.feb23;

public class Day2VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] dict = new int[26];
        for(int i=0; i<26; i++) {
            dict[order.charAt(i) - 'a'] = i;
        }

        for(int i=1; i<words.length; i++) {
            int j = 0;
            while (j < words[i-1].length()) {
                if(j == words[i].length()) {
                    return false;
                }

                char prevWordChar = words[i-1].charAt(j);
                char currWordChar = words[i].charAt(j);
                if(prevWordChar == currWordChar) {
                    j++;
                } else if (dict[prevWordChar - 'a'] < dict[currWordChar - 'a']) {
                    break;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
