package ds2;

import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>();
        HashSet<String> repeated =  new HashSet<>();
        for(int i=0; i+9<s.length(); i++) {
            String currentDNASeq = s.substring(i, i+10);
            if(!seen.add(currentDNASeq)) {
                repeated.add(currentDNASeq);
            }
        }
        return repeated.stream().toList();
    }
}
