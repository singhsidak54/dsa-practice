package daily.oct22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day28GroupAnagrams {
    public String getCharString(String str) {
        char[] res = new char[26];
        for(char c : str.toCharArray()) {
            res[c - 'a']++;
        }

        return new String(res);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            String charString = getCharString(str);
            if(!map.containsKey(charString)) {
                map.put(charString, new ArrayList<>());
            }

            map.get(charString).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
