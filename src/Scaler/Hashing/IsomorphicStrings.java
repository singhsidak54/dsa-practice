package Scaler.Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class IsomorphicStrings {
    public static int solve(String A, String B) {
        if(A.length() != B.length()) return 0;
        Set<Character> set = new HashSet<>();
        HashMap<Character, Character> map = new HashMap<>();

        for(int i=0; i<A.length(); i++) {
            char a = A.charAt(i);
            char b = B.charAt(i);

            if(map.containsKey(a) && map.get(a) != b) {
                return 0;
            }

            if(set.contains(b) && !map.containsKey(a)) {
                return 0;
            }

            map.put(a, b);
            set.add(b);
        }

        return 1;
    }

    public static void main(String[] args) {
        System.out.println(solve("aba", "xyx"));
    }
}
