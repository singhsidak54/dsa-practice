package daily.oct22;

public class Day25CheckIfTwoStringArraysAreEquivalent {
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int w1 = 0, w2 = 0, c1 = 0, c2 = 0, n1 = word1.length, n2 = word2.length;
        while (w1 < n1 && w2 < n2) {
            if(word1[w1].charAt(c1) != word2[w2].charAt(c2)) return false;

            c1++;
            c2++;
            if(c1 == word1[w1].length()) {
                w1++;
                c1 = 0;
            }

            if(c2 == word2[w2].length()) {
                w2++;
                c2 = 0;
            }
        }

        return w1 == n1 && w2 == n2;
    }

    public boolean arrayStringsAreEqual2(String[] word1, String[] word2) {
        StringBuilder w1String = new StringBuilder();
        for(String word : word1) {
            w1String.append(word);
        }

        int j=0, i=0;
        for(;i<word2.length && j<w1String.length(); i++) {
            int wordLength = word2[i].length();
            if(j + wordLength > w1String.length() || !w1String.substring(j, j + wordLength).equals(word2[i])) {
                return false;
            }
            j += wordLength;
        }

        return j == w1String.length() && i == word2.length;
    }
    public static void main(String[] args) {
        System.out.println(arrayStringsAreEqual(new String[] { "ab", "c"}, new String[] { "a", "bc"}));
    }
}
