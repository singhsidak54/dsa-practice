package daily.feb23;

import java.util.HashSet;
import java.util.Set;

public class Day9NamingACompany {
    public long distinctNames(String[] ideas) {
        int n = ideas.length;
        long ans = 0;
        Set<String>[] suffixesSet = new HashSet[26];
        for(int i=0; i<26; i++) {
            suffixesSet[i] = new HashSet<>();
        }

        for(int i=0; i<n; i++) {
            suffixesSet[ideas[i].charAt(0) - 'a'].add(ideas[i].substring(1));
        }

        for(int i=0; i<26; i++) {
            for(int j=i+1; j<26; j++) {
                int mutual = 0;
                for(String suffix : suffixesSet[i]) {
                    if(suffixesSet[j].contains(suffix)) {
                        mutual++;
                    }
                }

                ans += 2L * (suffixesSet[i].size() - mutual) * (suffixesSet[j].size() - mutual);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Day9NamingACompany obj = new Day9NamingACompany();
        String[] ideas = {"coffee","donuts","time","toffee"};
        System.out.println(obj.distinctNames(ideas));
    }
}
