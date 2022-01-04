package leetcode.studypack.ds1;

// Problem Link - https://leetcode.com/problems/valid-anagram/
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(t.length() != s.length())
            return false;
        int[] temp = new int[26];
        for(int c : t.toCharArray()) {
            temp[c - 'a']++;
        }

        for (int c : s.toCharArray()) {
            if(--temp[c - 'a'] < 0)
                return false;
        }

        return true;
    }
}
