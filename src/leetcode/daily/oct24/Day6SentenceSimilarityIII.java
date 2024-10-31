package daily.oct24;

public class Day6SentenceSimilarityIII {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" "), s2 = sentence2.split(" ");

        // move from front
        int l = 0;
        while (l < s1.length && l < s2.length) {
            if(!s1[l].equals(s2[l])) break;
            l++;
        }

        l--;

        // move from back\
        int h1 = s1.length - 1, h2 = s2.length - 1;
        while (h1 > l && h2 > l) {
            if(!s1[h1].equals(s2[h2])) break;
            h1--;
            h2--;
        }

        return l == h1 || l == h2;
    }

    public static void main(String[] args) {
        Day6SentenceSimilarityIII obj = new Day6SentenceSimilarityIII();
        System.out.println(obj.areSentencesSimilar("Hello Jane", "Hello my name is Jane"));
    }
}
