package daily.dec22.weekly;

public class Week1SingleRowKeyboard {
    public int calculateTime(String keyboard, String word) {
        int[] indexes = new int[26];
        int i = 0;
        for(char c : keyboard.toCharArray()) {
            indexes[c - 'a'] = i;
            i++;
        }

        int result = 0, pos = 0;
        for(char c : word.toCharArray()) {
            result += Math.abs(indexes[c - 'a'] - pos);
            pos = indexes[c - 'a'];
        }
        return result;
    }
}
