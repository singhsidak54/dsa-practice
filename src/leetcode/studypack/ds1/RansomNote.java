package ds1;

// Problem Link - https://leetcode.com/problems/ransom-note/
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] temp = new int[26];
        for(int c : magazine.toCharArray()) {
            temp[c - 'a']++;
        }

        for (int c : ransomNote.toCharArray()) {
            if(--temp[c - 'a'] < 0)
                return false;
        }

        return true;
    }
}
