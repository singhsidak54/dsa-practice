package Scaler.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FinishMaximumJobs {
    class Job {
        int start;
        int end;
        public Job(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int solve(int[] A, int[] B) {
        Job[] jobs = new Job[A.length];
        for(int i=0; i<A.length; i++) {
            jobs[i] = new Job(A[i], B[i]);
        }

        Arrays.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return Integer.compare(o1.end, o2.end);
            }
        });

        int max = 0, currStart = 0;
        for(int i=0; i<jobs.length; i++) {
            if(jobs[i].start >= currStart) {
                max++;
                currStart = jobs[i].end;
            }
        }

        return max;
    }
}
