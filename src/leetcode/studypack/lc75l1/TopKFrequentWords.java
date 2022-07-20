package lc75l1;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> wordCount = new HashMap<>();

        for(String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int count1 = wordCount.get(o1);
                int count2 = wordCount.get(o2);

                if(count1 != count2) {
                    return Integer.compare(count2, count1);
                } else {
                    return o1.compareTo(o2);
                }
            }
        });

        pq.addAll(wordCount.keySet());

        List<String> result = new ArrayList<>();
        while(k-- > 0) {
            result.add(pq.poll());
        }
        return result;
    }
}
