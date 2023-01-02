package daily.jan23;

public class Day2DetectCapital {
    public boolean detectCapitalUse(String word) {
        int capitals = 0;
        for(char c : word.toCharArray()) {
            if(Character.isUpperCase(c)) {
                capitals++;
            }
        }

        return capitals == word.length() || capitals == 0 || (capitals == 1 && Character.isUpperCase(word.charAt(0)));
    }
}
