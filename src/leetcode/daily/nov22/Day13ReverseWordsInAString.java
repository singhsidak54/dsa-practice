package daily.nov22;

public class Day13ReverseWordsInAString {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        StringBuilder currWord = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            if(s.charAt(i) == ' ') {
                while (i >= 0 && s.charAt(i) == ' ') {
                    i--;
                }

                if(!currWord.isEmpty()) {
                    result.append(currWord.reverse());
                    result.append(' ');
                    currWord = new StringBuilder();
                }
            }

            if(i < 0) {
                break;
            }

            currWord.append(s.charAt(i));
            i--;
        }

        if(!currWord.isEmpty()) {
            result.append(currWord.reverse());
        } else {
            result.deleteCharAt(result.length() - 1);
        }

        return result.toString();
    }
}
