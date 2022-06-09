package ds2;

import java.util.*;

public class SortCharactersByFrequency {
    public static String frequencySort(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        char[] sToArray = s.toCharArray();
        for(char c : sToArray) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return countMap.get(o2) - countMap.get(o1);
            }
        });

        pq.addAll(countMap.keySet());
        Map<Character, Integer> countMapCopy = new HashMap<>(countMap);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            char c = pq.peek();
            sb.append(c);
            int count = countMapCopy.get(c);
            countMapCopy.put(c, count - 1);
            if(count - 1 == 0) {
                pq.poll();
            }
        }

        return sb.toString();
    }

    //using bucket sort
    public static String frequencySort2(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        ArrayList<Character>[] buckets = new ArrayList[s.length() + 1];
        char[] sToArray = s.toCharArray();
        for(char c : sToArray) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        for(char c : countMap.keySet()) {
            int count = countMap.get(c);
            if(buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }
            buckets[count].add(c);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=s.length(); i>=0; i--) {
            if(buckets[i] == null) {
                continue;
            }

            for(char c : buckets[i]) {
                for(int j=0; j<i; j++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(frequencySort2("tree"));
    }
}
