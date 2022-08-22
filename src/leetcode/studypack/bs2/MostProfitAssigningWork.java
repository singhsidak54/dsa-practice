package bs2;

import java.util.TreeMap;

public class MostProfitAssigningWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        TreeMap<Integer, Integer> jobs = new TreeMap<>();
        jobs.put(0, 0);
        for(int i=0; i<difficulty.length; i++) {
            jobs.put(difficulty[i], Math.max(profit[i], jobs.getOrDefault(difficulty[i], 0)));
        }

        int best = 0;
        for(Integer key : jobs.keySet()) {
            best = Math.max(best, jobs.get(key));
            jobs.put(key, best);
        }

        int maxProfit = 0;
        for(int i=0; i< worker.length; i++) {
            maxProfit += jobs.floorEntry(worker[i]).getValue();
        }
        return maxProfit;
    }
}
