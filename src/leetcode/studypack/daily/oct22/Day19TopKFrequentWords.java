package daily.oct22;

import java.util.*;

public class Day19TopKFrequentWords {
    class Node {
        String word;
        int count;
        public Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> wordCount = new HashMap<>();

        for(String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.count == o2.count) {
                    return String.CASE_INSENSITIVE_ORDER.compare(o1.word, o2.word);
                }
                return Integer.compare(o2.count, o1.count);
            }
        });

        for(String word : wordCount.keySet()) {
            pq.add(new Node(word, wordCount.get(word)));
        }


        List<String> res = new ArrayList<>();
        for(int i=0; i<k; i++) {
            res.add(pq.poll().word);
        }
        return res;
    }

    public List<String> topKFrequent2(String[] words, int k) {
        HashMap<String, Integer> wordCount = new HashMap<>();

        for(String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int c1 = wordCount.get(o1);
                int c2 = wordCount.get(o2);

                if(c1 == c2) {
                    return o2.compareTo(o1);
                }

                return Integer.compare(c1, c2);
            }
        });

        for(String word : wordCount.keySet()) {
            pq.add(word);
            if(pq.size() > k) {
                pq.poll();
            }
        }


        String[] res = new String[k];
        for(int i=k-1; i>=0; i--) {
            res[i] = pq.poll();
        }

        return new ArrayList<>(List.of(res));
    }

    public void swap(String[] words, int l, int h) {
        String temp = words[l];
        words[l] = words[h];
        words[h] = temp;
    }

    public int partition(String[] words, int l, int h, HashMap<String, Integer> wordCount) {
        int i = l, j = l, pivotCount = wordCount.get(words[h]);
        while (i < h) {
            if(wordCount.get(words[i]) < pivotCount) {
                swap(words, i, j);
                j++;
            } else if (wordCount.get(words[i]) == pivotCount && words[i].compareTo(words[h]) < 0) {
                swap(words, i, j);
                j++;
            }
            i++;
        }

        swap(words, h, j);
        return j;
    }

    public List<String> topKFrequent3(String[] words, int k) {
        HashMap<String, Integer> wordCount = new HashMap<>();

        for(String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        String[] uniqueWords = new String[wordCount.size()];
        int index = 0;
        for(String word : wordCount.keySet()) {
            uniqueWords[index++] = word;
        }

        int l = 0, h = uniqueWords.length - 1, reqIndex = uniqueWords.length - k;
        while (l < h) {
            int partitionIndex = partition(uniqueWords, l, h, wordCount);
            if(partitionIndex == reqIndex) {
                break;
            } else if(partitionIndex < reqIndex) {
                l = partitionIndex + 1;
            } else {
                h = partitionIndex - 1;
            }
        }

        String[] res = new String[k];
        for(int i=reqIndex, j=0; i<uniqueWords.length; i++, j++) {
            res[j] = uniqueWords[i];
        }

        Arrays.sort(res, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int c1 = wordCount.get(o1);
                int c2 = wordCount.get(o2);

                if(c1 == c2) {
                    return o1.compareTo(o2);
                }
                return Integer.compare(c2, c1);
            }
        });

        return Arrays.stream(res).toList();
    }
}
