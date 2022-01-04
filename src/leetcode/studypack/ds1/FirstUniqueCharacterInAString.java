package leetcode.studypack.ds1;

import java.util.HashMap;

// Problem Link - https://leetcode.com/problems/first-unique-character-in-a-string/
public class FirstUniqueCharacterInAString {
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] temp = s.toCharArray();
        for(int i=0; i<temp.length; i++) {
            map.put(temp[i], map.getOrDefault(temp[i], 0) + 1);
        }

        for(int i=0; i<temp.length; i++) {
            if(map.get(temp[i]) == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("dddccdbba"));
    }
}
