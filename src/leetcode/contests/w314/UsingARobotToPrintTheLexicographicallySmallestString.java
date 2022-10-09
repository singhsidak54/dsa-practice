package contests.w314;

import java.util.Stack;

public class UsingARobotToPrintTheLexicographicallySmallestString {
    public String robotWithString(String s) {
        char[] res = new char[s.length()];
        Stack<Character> stack = new Stack<>();
        int k = 0, l = 0;
        int[] freq = new int[26];

        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for(char c : s.toCharArray()) {
            stack.push(c);
            freq[c - 'a']--;
            while (l < 26 && freq[l] == 0) {
                l++;
            }

            while (!stack.isEmpty() && stack.peek() - 'a' <= l) {
                res[k++] = stack.pop();
            }
        }

        return new String(res);
    }
}
