package ds2;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] charLastIndexMap = new int[26];
        for(int i=0; i<s.length(); i++) {
            charLastIndexMap[s.charAt(i) - 'a'] = i;
        }

        int partitionStart = 0, partitionEnd = 0;
        for(int i=0; i<s.length(); i++) {
            partitionEnd = Math.max(partitionEnd, charLastIndexMap[s.charAt(i) - 'a']);

            if(partitionEnd == i) {
                result.add(i - partitionStart + 1);
                partitionStart = i + 1;
            }
        }

        return result;
    }
}
