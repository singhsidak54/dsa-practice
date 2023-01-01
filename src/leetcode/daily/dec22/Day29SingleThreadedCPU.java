package daily.dec22;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Day29SingleThreadedCPU {
    class Task {
        int originalIndex;
        int enqueueTime;
        int processingTime;
        public Task(int originalIndex, int enqueueTime, int processingTime) {
            this.originalIndex = originalIndex;
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
        }
    }

    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] ans = new int[n];
        Task[] taskObjs = new Task[n];
        for(int i=0; i<n; i++) {
            taskObjs[i] = new Task(i, tasks[i][0], tasks[i][1]);
        }

        Arrays.sort(taskObjs, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return Integer.compare(o1.enqueueTime, o2.enqueueTime);
            }
        });

        PriorityQueue<Task> pq = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if(o1.processingTime == o2.processingTime) {
                    return Integer.compare(o1.originalIndex, o2.originalIndex);
                }

                return Integer.compare(o1.processingTime, o2.processingTime);
            }
        });

        int k = 0, t = 0, i = 0;
        while (k < n) {
            if(pq.isEmpty() && i < n && t < taskObjs[i].enqueueTime) {
                t = taskObjs[i].enqueueTime;
            }

            while (i < n && t >= taskObjs[i].enqueueTime) {
                pq.add(taskObjs[i]);
                i++;
            }

            if (!pq.isEmpty()) {
                Task currentTask = pq.poll();
                ans[k++] = currentTask.originalIndex;
                t += currentTask.processingTime;
            }
        }

        return ans;
    }
}
