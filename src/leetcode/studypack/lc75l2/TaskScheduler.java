package lc75l2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int[] taskCounts = new int[26];

        for(char c : tasks) {
            taskCounts[c - 'A']++;
        }

        for(int i=0; i<26; i++) {
            if(taskCounts[i] != 0) {
                maxHeap.add(taskCounts[i]);
            }
        }

        int time = 0;
        Queue<int[]> queue = new LinkedList<>();

        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time = time + 1;

            if (!maxHeap.isEmpty()) {
                int curr = maxHeap.poll();
                if(curr - 1 > 0) {
                    queue.add(new int[] {curr - 1, n + time});
                }
            }

            while (!queue.isEmpty() && queue.peek()[1] <= time) {
                maxHeap.add(queue.poll()[0]);
            }
        }
        return time;
    }

    public int leastInterval2(char[] tasks, int n) {
        int[] taskCount = new int[26];
        int max = 0, maxCount = 0;

        for(char c : tasks) {
            taskCount[c - 'A']++;
            if(taskCount[c - 'A'] > max) {
                max = taskCount[c - 'A'];
                maxCount = 1;
            } else if (taskCount[c - 'A'] == max) {
                maxCount++;
            }
        }

        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int tasksLeftToPlace = tasks.length - (max * maxCount);
        int idles = Math.max(0, emptySlots - tasksLeftToPlace);

        return tasks.length + idles;
    }
}
