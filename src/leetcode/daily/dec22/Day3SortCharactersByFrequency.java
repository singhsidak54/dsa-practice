package daily.dec22;

import java.util.*;

public class Day3SortCharactersByFrequency {
    public String frequencySort(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        for(char c : s.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Integer.compare(charMap.get(o2), charMap.get(o1));
            }
        });

        pq.addAll(charMap.keySet());

        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            int count = charMap.get(c);
            while (count-- > 0) {
                result.append(c);
            }
        }

        return result.toString();
    }

    public String frequencySortOptimised(String s) {
        int n = s.length();
        ArrayList<Character>[] buckets = new ArrayList[n + 1];
        HashMap<Character, Integer> charMap = new HashMap<>();
        for(char c : s.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        for(Map.Entry<Character, Integer> mapEntry : charMap.entrySet()) {
            int count = mapEntry.getValue();
            if(buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }

            buckets[count].add(mapEntry.getKey());
        }

        StringBuilder result = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--) {
            if(buckets[i] == null) {
                continue;
            }

            for(char c : buckets[i]) {
                result.append(String.valueOf(c).repeat(i));
            }
        }

        return result.toString();
    }
}
