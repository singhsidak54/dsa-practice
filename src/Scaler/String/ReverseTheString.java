package Scaler.String;

public class ReverseTheString {
    public String solve(String A) {
        String[] words = A.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i=words.length-1; i>=0; i--) {
            result.append(words[i]);
            result.append(' ');
        }

        int i=0;
        while (i<result.length() && result.charAt(i) == ' ') {
            i++;
        }

        result.delete(0, i);

        i = result.length() - 1;
        while (i >= 0 && result.charAt(i) == ' ') {
            i--;
        }

        result.delete(i + 1, result.length());
        return result.toString();
    }
}
