package daily.nov22;

import java.util.*;

public class Day30UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2001];
        Set<Integer> set = new HashSet<>();
        Arrays.fill(count, -1);

        for(int num : arr) {
            count[num + 1000]++;
        }

        for(int i=0; i<=2000; i++) {
            if(count[i] != -1 && set.contains(count[i])) {
                return false;
            }
            set.add(count[i]);
        }

        return true;
    }

    public boolean uniqueOccurrences2(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for(int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(set.contains(entry.getValue())) {
                return false;
            }
            set.add(entry.getValue());
        }

        return true;
    }
}
