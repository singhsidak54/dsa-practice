package daily.oct22;

public class Day17CheckIfTheSentenceIsPangram {
    public boolean checkIfPangram(String sentence) {
        boolean[] charMap = new boolean[26];
        int count = 0;

        for(int i=0; i<sentence.length(); i++) {
            char c = sentence.charAt(i);
            if(!charMap[c - 'a']) {
                charMap[c - 'a'] = true;
                count++;

                if(count == 26) {
                    return true;
                }
            }
        }

        return false;
    }
}
