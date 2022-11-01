package patterns.intuit;

import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] tasksCount = new int[26];
        for(char task : tasks) {
            tasksCount[task - 'A']++;
        }

        int maxCount = 0, tasksWithMax = 0;
        for(int i=0; i<26; i++) {
            if(tasksCount[i] > maxCount) {
                maxCount = tasksCount[i];
                tasksWithMax = 1;
            } else if (tasksCount[i] == maxCount) {
                tasksWithMax++;
            }
        }

        int parts = maxCount - 1;
        int partLength = n - tasksWithMax + 1;
        int tasksLeft = tasks.length - (maxCount * tasksWithMax);
        int idles = (parts * partLength) - tasksLeft;
        return Math.max(tasks.length, tasks.length + idles);
    }

    class Node {
        char task;
        int freq;
        public Node(char task, int freq) {
            this.task = task;
            this.freq = freq;
        }
    }

    public int leastInterval2(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o2.freq, o1.freq);
            }
        });

        for(char task : map.keySet()) {
            pq.add(new Node(task, map.get(task)));
        }

        int time = 0;
        while (!pq.isEmpty()) {
            int k = n + 1;
            List<Node> temp = new ArrayList<>();
            while (k > 0 && !pq.isEmpty()) {
                Node task = pq.poll();
                task.freq--;
                time++;
                k--;
                if(task.freq > 0) temp.add(task);
            }

            pq.addAll(temp);
            if(k > 0 && !pq.isEmpty()) {
                time = time + k;
            }
        }

        return time;
    }
}
