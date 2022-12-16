package companies.Amazon;

import java.util.HashMap;

public class RomanToInteger {
    public int romanToInt(String s) {
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        char c = s.charAt(s.length() - 1);
        int lastValue = romanMap.get(c), ans = lastValue;
        for(int i=s.length()-2; i>=0; i--) {
            c = s.charAt(i);
            int currentValue = romanMap.get(c);
            if(currentValue < lastValue) {
                ans -= currentValue;
            } else {
                ans += currentValue;
            }
            lastValue = currentValue;
        }
        return ans;
    }
}
