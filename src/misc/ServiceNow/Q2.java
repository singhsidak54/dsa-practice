package misc.ServiceNow;

import java.util.HashSet;
import java.util.Set;

public class Q2 {
    public static long substringCalculator(String s) {
        long ans = 0;

        Set<String> set = new HashSet<>();

        for(int i=0; i<s.length(); i++) {
            StringBuilder curr = new StringBuilder();
            for(int j=i; j<s.length(); j++) {
                curr.append(s.charAt(j));
                set.add(curr.toString());
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(substringCalculator("kincen"));
    }
}
