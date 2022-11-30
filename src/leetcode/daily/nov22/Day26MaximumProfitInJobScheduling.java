package daily.nov22;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class Day26MaximumProfitInJobScheduling {
    private static class Job {
        int startTime;
        int endTime;
        int profit;
        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobs = new Job[startTime.length];
        for(int i=0; i<jobs.length; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                if(o1.endTime == o2.endTime) {
                    return Integer.compare(o1.startTime, o2.startTime);
                }
                return Integer.compare(o1.endTime, o2.endTime);
            }
        });

        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);
        for(Job job : jobs) {
            int currentProfit = dp.floorEntry(job.startTime).getValue() + job.profit;
            if(currentProfit > dp.lastEntry().getValue()) {
                dp.put(job.endTime, currentProfit);
            }
        }

        return dp.lastEntry().getValue();
    }

    public static void main(String[] args) {
        int[] sT = {1,2,3,3};
        int[] eT = {3,4,5,6};
        int[] pF = {50,10,40,70};

        System.out.println(jobScheduling(sT, eT, pF));
    }
}
