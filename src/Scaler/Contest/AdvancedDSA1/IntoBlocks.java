package Scaler.Contest.AdvancedDSA1;

import java.util.*;

public class IntoBlocks {
    public static int solve(int[] A) {
        HashMap<Integer, Integer> startInterval = new HashMap<>();
        HashMap<Integer, Integer> endInterval = new HashMap<>();

        for(int i=0; i<A.length; i++) {
            if(!startInterval.containsKey(A[i])) {
                startInterval.put(A[i], i);
            }

            endInterval.put(A[i], i);
        }

        List<int[]> intervals = new ArrayList<>();
        for(int key : startInterval.keySet()) {
            intervals.add(new int[] {startInterval.get(key), endInterval.get(key)});
        }

        Collections.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        List<int[]> mergedIntervals = new ArrayList<>();
        int currentStart = intervals.get(0)[0], currentEnd = intervals.get(0)[1], i = 1;
        while (i < intervals.size()) {
            int[] curr = intervals.get(i);
            if(curr[0] > currentEnd) {
                mergedIntervals.add(new int[] {currentStart, currentEnd});
                currentStart = curr[0];
                currentEnd = curr[1];
            } else {
                currentEnd = Math.max(currentEnd, curr[1]);
            }
            i++;
        }

        mergedIntervals.add(new int[] {currentStart, currentEnd});

        int swaps = 0;
        for(int[] interval : mergedIntervals) {
            HashMap<Integer, Integer> freqMap = new HashMap<>();
            for(int j=interval[0]; j<=interval[1]; j++) {
                freqMap.put(A[j], freqMap.getOrDefault(A[j], 0) + 1);
            }

            int maxFreq = 0;
            for(int freq : freqMap.values()) {
                maxFreq = Math.max(maxFreq, freq);
            }

            swaps += (interval[1] - interval[0] + 1) - maxFreq;
        }

        return swaps;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[] {3,3,1,3,2,1,2}));
    }
}
