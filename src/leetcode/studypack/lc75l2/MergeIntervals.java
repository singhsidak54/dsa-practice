package lc75l2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });

        List<int[]> res = new ArrayList<>();
        int i=0, n=intervals.length;
        while (i < n) {
            int intervalStart = intervals[i][0], intervalEnd = intervals[i][1];
            while (i < n - 1 && intervals[i+1][0] <= intervalEnd) {
                intervalEnd = Math.max(intervalEnd, intervals[i+1][1]);
                i++;
            }
            res.add(new int[] {intervalStart, intervalEnd});
            i++;
        }

        return res.toArray(new int[res.size()][2]);
    }
}
