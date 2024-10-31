package daily.sep24;

public class Day12CountTheNumberOfConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] charSet = new boolean[26];
        for(char c : allowed.toCharArray()) {
            charSet[c - 'a'] = true;
        }

        int ans = 0;
        for(String word : words) {
            boolean consistent = true;
            for(char c : word.toCharArray()) {
                if(!charSet[c - 'a']) {
                    consistent = false;
                    break;
                }
            }

            if(consistent) ans++;
        }

        return ans;
    }
}
